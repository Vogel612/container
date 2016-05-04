package org.opentosca.bus.application.service.impl.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Map that manages the invocation results. RequestID is used as <tt>key</tt> of
 * the map. The <tt>value</tt> of the map is the result of the invocation. Or
 * <tt>null</tt> if the invocation failed.
 * 
 * @author Michael Zimmermann - zimmerml@studi.informatik.uni-stuttgart.de
 *
 */
public class ResultMap {

	private static ConcurrentHashMap<String, Object> invocations = new ConcurrentHashMap<String, Object>();

	/**
	 * @param id
	 *            of the request
	 * @param obj
	 *            result of the invocation.
	 */
	public static void put(String id, Object obj) {
		invocations.put(id, obj);
	}

	/**
	 * @param id
	 * @return result of the invocation. <tt>Void</tt> if the invoked method was
	 *         of return type <tt>void</tt>. <tt>null</tt> if the invocation
	 *         failed.
	 */
	public static Object get(String id) {
		return invocations.get(id);
	}

	/**
	 * @param id
	 *            of the request
	 * @return <tt>true</tt> if the map contains the specified requestID.
	 *         Otherwise <tt>false</tt>
	 */
	public static boolean containsID(String id) {
		return invocations.containsKey(id);
	}

	/**
	 * Removes the entry with the specified requestID from the map.
	 * 
	 * @param id
	 *            of the request
	 */
	public static void remove(String id) {
		invocations.remove(id);
	}
}
