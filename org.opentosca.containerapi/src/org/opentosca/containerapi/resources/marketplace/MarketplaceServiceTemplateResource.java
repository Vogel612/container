package org.opentosca.containerapi.resources.marketplace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.namespace.QName;

import org.opentosca.containerapi.osgi.servicegetter.FileAccessServiceHandler;
import org.opentosca.containerapi.osgi.servicegetter.FileRepositoryServiceHandler;
import org.opentosca.containerapi.osgi.servicegetter.IOpenToscaControlServiceHandler;
import org.opentosca.containerapi.osgi.servicegetter.ToscaServiceHandler;
import org.opentosca.containerapi.resources.csar.CSARsResource;
import org.opentosca.containerapi.resources.utilities.ResourceConstants;
import org.opentosca.containerapi.resources.utilities.Utilities;
import org.opentosca.containerapi.resources.xlink.Reference;
import org.opentosca.containerapi.resources.xlink.References;
import org.opentosca.containerapi.resources.xlink.XLinkConstants;
import org.opentosca.core.file.service.ICoreFileService;
import org.opentosca.core.model.csar.id.CSARID;
import org.opentosca.exceptions.SystemException;
import org.opentosca.exceptions.UserException;
import org.opentosca.opentoscacontrol.service.IOpenToscaControlService;
import org.opentosca.planbuilder.export.Exporter;
import org.opentosca.planbuilder.importer.Importer;
import org.opentosca.planbuilder.model.plan.BuildPlan;
import org.opentosca.wineryconnector.WineryConnector;

/**
 * Copyright 2016 IAAS University of Stuttgart <br>
 * <br>
 *
 * @author Kálmán Képes - kalman.kepes@iaas.uni-stuttgart.de
 *
 */
public class MarketplaceServiceTemplateResource {

	UriInfo uriInfo;

	private WineryConnector connector = new WineryConnector();
	private QName serviceTemplate;
	
	private final ICoreFileService fileHandler;
	private final IOpenToscaControlService control;


	public MarketplaceServiceTemplateResource(QName qname) {
		this.serviceTemplate = qname;
		this.fileHandler = FileRepositoryServiceHandler.getFileHandler();
		this.control = IOpenToscaControlServiceHandler.getOpenToscaControlService();
	}

	@GET
	@Produces(ResourceConstants.LINKED_XML)
	public Response getReferencesXML(@Context UriInfo uriInfo) {
		this.uriInfo = uriInfo;
		return Response.ok(this.getRefs().getXMLString()).build();
	}

	@GET
	@Produces(ResourceConstants.LINKED_JSON)
	public Response getReferencesJSON(@Context UriInfo uriInfo) {
		this.uriInfo = uriInfo;
		return Response.ok(this.getRefs().getJSONString()).build();
	}

	public References getRefs() {
		References refs = new References();

		refs.getReference().add(new Reference(this.getWineryUri(), XLinkConstants.REFERENCE, this.serviceTemplate.toString()));
		refs.getReference().add(new Reference(this.uriInfo.getAbsolutePath().toString(), XLinkConstants.SIMPLE, XLinkConstants.SELF));

		return refs;
	}

	private String getWineryUri() {
		String encodedNamespace = Utilities.URLencode(Utilities.URLencode(this.serviceTemplate.getNamespaceURI()));
		return Utilities.buildURI(this.connector.getWineryPath() + "servicetemplates/" + encodedNamespace, this.serviceTemplate.getLocalPart());
	}

	@POST
	public Response deploy(@Context UriInfo uriInfo) throws MalformedURLException, IOException, URISyntaxException {
		this.uriInfo = uriInfo;
		// example url:
		// http://localhost:8080/winery/servicetemplates/http%253A%252F%252Fopentosca.org%252Fdeclarative%252Fbpel/BPELStack/?csar
		String csarUrl = this.getWineryUri() + "/?csar";

		InputStream inputStream = new URL(csarUrl).openConnection().getInputStream();

		CSARsResource res = new CSARsResource();

		CSARID csarId = this.storeCSAR(this.serviceTemplate.getLocalPart() + ".csar", inputStream);

		String csarsResourcePath = this.uriInfo.getAbsolutePath().getScheme() + "://" + this.uriInfo.getAbsolutePath().getHost() + ":" + this.uriInfo.getAbsolutePath().getPort() + "/containerapi/CSARs/" + csarId.toString();

		return Response.created(URI.create(csarsResourcePath)).build();
	}
	
	private CSARID storeCSAR(String fileName, InputStream uploadedInputStream) {
		try {
			File uploadFile = this.storeTemporaryFile(fileName, uploadedInputStream);
			CSARID csarID = null;
			csarID = this.fileHandler.storeCSAR(uploadFile.toPath());
			
			csarID = this.startPlanBuilder(csarID);
			
			if (csarID != null) {				
				this.control.setDeploymentProcessStateStored(csarID);
				
				if (this.control.invokeTOSCAProcessing(csarID)) {
					
					List<QName> serviceTemplates = ToscaServiceHandler.getToscaEngineService().getToscaReferenceMapper().getServiceTemplateIDsContainedInCSAR(csarID);
					
					for (QName serviceTemplate : serviceTemplates) {						
						if (!this.control.invokeIADeployment(csarID, serviceTemplate)) {
							
							break;
						}
						
						if (!this.control.invokePlanDeployment(csarID, serviceTemplate)) {
							
							break;
						}
						
					}
					return csarID;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private File storeTemporaryFile(String fileName, InputStream uploadedInputStream) throws IOException {
		File tmpDir = FileAccessServiceHandler.getFileAccessService().getTemp();
		tmpDir.mkdir();
		
		File uploadFile = new File(tmpDir.getAbsoluteFile() + System.getProperty("file.separator") + fileName);
		
		OutputStream out;
		
		out = new FileOutputStream(uploadFile);
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		while ((read = uploadedInputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		
		uploadedInputStream.close();
		
		out.flush();
		out.close();
		return uploadFile;
	}
	
	private CSARID startPlanBuilder(CSARID csarId) {
		Importer planBuilderImporter = new Importer();
		Exporter planBuilderExporter = new Exporter();
		
		List<BuildPlan> buildPlans = planBuilderImporter.importDefs(csarId);
		
		// no buildplan generated <=> nothing to do
		if (buildPlans.isEmpty()) {
			return csarId;
		}
		
		File repackagedCsar = planBuilderExporter.export(buildPlans, csarId);
		try {
			this.fileHandler.deleteCSAR(csarId);
			return this.fileHandler.storeCSAR(repackagedCsar.toPath());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
