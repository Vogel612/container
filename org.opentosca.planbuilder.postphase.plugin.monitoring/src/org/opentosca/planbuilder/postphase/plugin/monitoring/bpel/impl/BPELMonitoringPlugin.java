package org.opentosca.planbuilder.postphase.plugin.monitoring.bpel.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.opentosca.container.core.tosca.convention.Utils;
import org.opentosca.planbuilder.core.bpel.context.BPELPlanContext;
import org.opentosca.planbuilder.model.plan.AbstractPlan.PlanType;
import org.opentosca.planbuilder.model.plan.bpel.BPELScopeActivity.BPELScopePhaseType;
import org.opentosca.planbuilder.model.tosca.AbstractDeploymentArtifact;
import org.opentosca.planbuilder.model.tosca.AbstractInterface;
import org.opentosca.planbuilder.model.tosca.AbstractNodeTemplate;
import org.opentosca.planbuilder.model.tosca.AbstractOperation;
import org.opentosca.planbuilder.model.tosca.AbstractRelationshipTemplate;
import org.opentosca.planbuilder.model.utils.ModelUtils;
import org.opentosca.planbuilder.plugins.IPlanBuilderPostPhasePlugin;
import org.opentosca.planbuilder.plugins.context.Variable;
import org.opentosca.planbuilder.provphase.plugin.invoker.bpel.BPELInvokerPlugin;

/**
 * <p>
 * This class represents a POST-Phase Plugin which sends runtime values of NodeTemplate Instances to
 * the OpenTOSCA Container InstanceData API
 * </p>
 * Copyright 2014 IAAS University of Stuttgart <br>
 * <br>
 *
 * @author Kalman Kepes - kepeskn@studi.informatik.uni-stuttgart.de
 *
 */
public class BPELMonitoringPlugin implements IPlanBuilderPostPhasePlugin<BPELPlanContext> {

    private final String monitoringInterfaceName = "http://opentosca.org/interfaces/monitoring";
    private final String monitoringOperationName = "deployAgent";
    private final QName configArtifactType = new QName("http://opentosca.org/artifacttypes", "ConfigurationArtifact");
    private final BPELInvokerPlugin invokerPlugin = new BPELInvokerPlugin();


    @Override
    public String getID() {
        return "PlanBuilder POSTPhase Plugin BPEL Monitoring";
    }

    @Override
    public boolean handle(final BPELPlanContext context, final AbstractNodeTemplate nodeTemplate) {
        // a double check basically
        // FIXME somehow the canHandle method should already include the planType but not with context
        // object itself as it allows to manipulate the plan already
        if (!this.canHandle(nodeTemplate)) {
            return false;
        }

        if (context.getPlanType().equals(PlanType.TERMINATE)) {
            return false;
        }

        final AbstractDeploymentArtifact configDeplArti = fetchConfigurationArtifact(nodeTemplate);

        if (configDeplArti != null) {
            uploadConfigurationArtifact(context, configDeplArti, nodeTemplate);
        }


        return context.executeOperation(nodeTemplate, this.monitoringInterfaceName, this.monitoringOperationName, null,
                                        null, BPELScopePhaseType.POST);
    }

    @Override
    public boolean handle(final BPELPlanContext context, final AbstractRelationshipTemplate relationshipTemplate) {
        return false;
    }

    @Override
    public boolean canHandle(final AbstractNodeTemplate nodeTemplate) {
        // what we are basically looking for:
        // <Interface name="Monitor">
        // <Operation name="deployAgent"/>
        // </Interface>
        for (final AbstractInterface iface : nodeTemplate.getType().getInterfaces()) {
            if (iface.getName().equals(this.monitoringInterfaceName)) {
                for (final AbstractOperation op : iface.getOperations()) {
                    if (op.getName().equals(this.monitoringOperationName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean canHandle(final AbstractRelationshipTemplate relationshipTemplate) {
        return false;
    }

    private void uploadConfigurationArtifact(final BPELPlanContext context, final AbstractDeploymentArtifact deplArti,
                                             final AbstractNodeTemplate nodeTemplate) {
        final List<AbstractNodeTemplate> infraNodes = new ArrayList<>();
        ModelUtils.getInfrastructureNodes(nodeTemplate, infraNodes);

        AbstractNodeTemplate infraNode = null;
        Variable sshIpVar = null;
        Variable sshKeyVar = null;
        Variable sshUserVar = null;

        for (final AbstractNodeTemplate infraNodeTemplate : infraNodes) {
            int propMatchCount = 0;
            final List<String> propNames = ModelUtils.getPropertyNames(infraNodeTemplate);
            for (final String propName : propNames) {
                if (Utils.isSupportedVirtualMachineIPProperty(propName)) {
                    sshIpVar = context.getPropertyVariable(propName);
                    propMatchCount++;
                } else if (Utils.isSupportedSSHKeyProperty(propName)) {
                    sshKeyVar = context.getPropertyVariable(propName);
                    propMatchCount++;
                } else if (Utils.isSupportedSSHUserPropery(propName)) {
                    sshUserVar = context.getPropertyVariable(propName);
                    propMatchCount++;
                }
            }
            if (propMatchCount == 3) {
                infraNode = infraNodeTemplate;
                break;
            } else {
                sshIpVar = null;
                sshKeyVar = null;
                sshUserVar = null;
            }
        }


        this.invokerPlugin.handleArtifactReferenceUpload(deplArti.getArtifactRef().getArtifactReferences().get(0),
                                                         context, sshIpVar, sshUserVar, sshKeyVar, infraNode,
                                                         BPELScopePhaseType.PROVISIONING);
    }

    private AbstractDeploymentArtifact fetchConfigurationArtifact(final AbstractNodeTemplate nodeTemplate) {
        for (final AbstractDeploymentArtifact deplArti : nodeTemplate.getDeploymentArtifacts()) {
            if (deplArti.getArtifactType().equals(this.configArtifactType)) {
                return deplArti;
            }
        }
        return null;
    }

}
