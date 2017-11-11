/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.darrylsite.liferay.chat.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Lounge. This utility wraps
 * {@link com.darrylsite.liferay.chat.service.impl.LoungeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Darryl Kpizingui
 * @see LoungeLocalService
 * @see com.darrylsite.liferay.chat.service.base.LoungeLocalServiceBaseImpl
 * @see com.darrylsite.liferay.chat.service.impl.LoungeLocalServiceImpl
 * @generated
 */
@ProviderType
public class LoungeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.darrylsite.liferay.chat.service.impl.LoungeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lounge to the database. Also notifies the appropriate model listeners.
	*
	* @param lounge the lounge
	* @return the lounge that was added
	*/
	public static com.darrylsite.liferay.chat.model.Lounge addLounge(
		com.darrylsite.liferay.chat.model.Lounge lounge) {
		return getService().addLounge(lounge);
	}

	public static com.darrylsite.liferay.chat.model.Lounge create() {
		return getService().create();
	}

	/**
	* Creates a new lounge with the primary key. Does not add the lounge to the database.
	*
	* @param id the primary key for the new lounge
	* @return the new lounge
	*/
	public static com.darrylsite.liferay.chat.model.Lounge createLounge(long id) {
		return getService().createLounge(id);
	}

	/**
	* Deletes the lounge from the database. Also notifies the appropriate model listeners.
	*
	* @param lounge the lounge
	* @return the lounge that was removed
	*/
	public static com.darrylsite.liferay.chat.model.Lounge deleteLounge(
		com.darrylsite.liferay.chat.model.Lounge lounge) {
		return getService().deleteLounge(lounge);
	}

	/**
	* Deletes the lounge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the lounge
	* @return the lounge that was removed
	* @throws PortalException if a lounge with the primary key could not be found
	*/
	public static com.darrylsite.liferay.chat.model.Lounge deleteLounge(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLounge(id);
	}

	public static com.darrylsite.liferay.chat.model.Lounge fetchLounge(long id) {
		return getService().fetchLounge(id);
	}

	/**
	* Returns the lounge with the primary key.
	*
	* @param id the primary key of the lounge
	* @return the lounge
	* @throws PortalException if a lounge with the primary key could not be found
	*/
	public static com.darrylsite.liferay.chat.model.Lounge getLounge(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLounge(id);
	}

	/**
	* Updates the lounge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lounge the lounge
	* @return the lounge that was updated
	*/
	public static com.darrylsite.liferay.chat.model.Lounge updateLounge(
		com.darrylsite.liferay.chat.model.Lounge lounge) {
		return getService().updateLounge(lounge);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lounges.
	*
	* @return the number of lounges
	*/
	public static int getLoungesCount() {
		return getService().getLoungesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.darrylsite.liferay.chat.model.impl.LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.darrylsite.liferay.chat.model.impl.LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lounges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.darrylsite.liferay.chat.model.impl.LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @return the range of lounges
	*/
	public static java.util.List<com.darrylsite.liferay.chat.model.Lounge> getLounges(
		int start, int end) {
		return getService().getLounges(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static LoungeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoungeLocalService, LoungeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LoungeLocalService.class);
}