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

package com.darrylsite.liferay.chat.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.darrylsite.liferay.chat.model.Lounge;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lounge service. This utility wraps {@link com.darrylsite.liferay.chat.service.persistence.impl.LoungePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see LoungePersistence
 * @see com.darrylsite.liferay.chat.service.persistence.impl.LoungePersistenceImpl
 * @generated
 */
@ProviderType
public class LoungeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Lounge lounge) {
		getPersistence().clearCache(lounge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lounge> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lounge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lounge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Lounge> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lounge update(Lounge lounge) {
		return getPersistence().update(lounge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lounge update(Lounge lounge, ServiceContext serviceContext) {
		return getPersistence().update(lounge, serviceContext);
	}

	/**
	* Returns all the lounges where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @return the matching lounges
	*/
	public static List<Lounge> findByPriviledge(int priviledge) {
		return getPersistence().findByPriviledge(priviledge);
	}

	/**
	* Returns a range of all the lounges where priviledge &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param priviledge the priviledge
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @return the range of matching lounges
	*/
	public static List<Lounge> findByPriviledge(int priviledge, int start,
		int end) {
		return getPersistence().findByPriviledge(priviledge, start, end);
	}

	/**
	* Returns an ordered range of all the lounges where priviledge &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param priviledge the priviledge
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lounges
	*/
	public static List<Lounge> findByPriviledge(int priviledge, int start,
		int end, OrderByComparator<Lounge> orderByComparator) {
		return getPersistence()
				   .findByPriviledge(priviledge, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lounges where priviledge &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param priviledge the priviledge
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lounges
	*/
	public static List<Lounge> findByPriviledge(int priviledge, int start,
		int end, OrderByComparator<Lounge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPriviledge(priviledge, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lounge
	* @throws NoSuchLoungeException if a matching lounge could not be found
	*/
	public static Lounge findByPriviledge_First(int priviledge,
		OrderByComparator<Lounge> orderByComparator)
		throws com.darrylsite.liferay.chat.exception.NoSuchLoungeException {
		return getPersistence()
				   .findByPriviledge_First(priviledge, orderByComparator);
	}

	/**
	* Returns the first lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lounge, or <code>null</code> if a matching lounge could not be found
	*/
	public static Lounge fetchByPriviledge_First(int priviledge,
		OrderByComparator<Lounge> orderByComparator) {
		return getPersistence()
				   .fetchByPriviledge_First(priviledge, orderByComparator);
	}

	/**
	* Returns the last lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lounge
	* @throws NoSuchLoungeException if a matching lounge could not be found
	*/
	public static Lounge findByPriviledge_Last(int priviledge,
		OrderByComparator<Lounge> orderByComparator)
		throws com.darrylsite.liferay.chat.exception.NoSuchLoungeException {
		return getPersistence()
				   .findByPriviledge_Last(priviledge, orderByComparator);
	}

	/**
	* Returns the last lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lounge, or <code>null</code> if a matching lounge could not be found
	*/
	public static Lounge fetchByPriviledge_Last(int priviledge,
		OrderByComparator<Lounge> orderByComparator) {
		return getPersistence()
				   .fetchByPriviledge_Last(priviledge, orderByComparator);
	}

	/**
	* Returns the lounges before and after the current lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param id the primary key of the current lounge
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lounge
	* @throws NoSuchLoungeException if a lounge with the primary key could not be found
	*/
	public static Lounge[] findByPriviledge_PrevAndNext(long id,
		int priviledge, OrderByComparator<Lounge> orderByComparator)
		throws com.darrylsite.liferay.chat.exception.NoSuchLoungeException {
		return getPersistence()
				   .findByPriviledge_PrevAndNext(id, priviledge,
			orderByComparator);
	}

	/**
	* Removes all the lounges where priviledge &le; &#63; from the database.
	*
	* @param priviledge the priviledge
	*/
	public static void removeByPriviledge(int priviledge) {
		getPersistence().removeByPriviledge(priviledge);
	}

	/**
	* Returns the number of lounges where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @return the number of matching lounges
	*/
	public static int countByPriviledge(int priviledge) {
		return getPersistence().countByPriviledge(priviledge);
	}

	/**
	* Caches the lounge in the entity cache if it is enabled.
	*
	* @param lounge the lounge
	*/
	public static void cacheResult(Lounge lounge) {
		getPersistence().cacheResult(lounge);
	}

	/**
	* Caches the lounges in the entity cache if it is enabled.
	*
	* @param lounges the lounges
	*/
	public static void cacheResult(List<Lounge> lounges) {
		getPersistence().cacheResult(lounges);
	}

	/**
	* Creates a new lounge with the primary key. Does not add the lounge to the database.
	*
	* @param id the primary key for the new lounge
	* @return the new lounge
	*/
	public static Lounge create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the lounge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the lounge
	* @return the lounge that was removed
	* @throws NoSuchLoungeException if a lounge with the primary key could not be found
	*/
	public static Lounge remove(long id)
		throws com.darrylsite.liferay.chat.exception.NoSuchLoungeException {
		return getPersistence().remove(id);
	}

	public static Lounge updateImpl(Lounge lounge) {
		return getPersistence().updateImpl(lounge);
	}

	/**
	* Returns the lounge with the primary key or throws a {@link NoSuchLoungeException} if it could not be found.
	*
	* @param id the primary key of the lounge
	* @return the lounge
	* @throws NoSuchLoungeException if a lounge with the primary key could not be found
	*/
	public static Lounge findByPrimaryKey(long id)
		throws com.darrylsite.liferay.chat.exception.NoSuchLoungeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the lounge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the lounge
	* @return the lounge, or <code>null</code> if a lounge with the primary key could not be found
	*/
	public static Lounge fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Lounge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lounges.
	*
	* @return the lounges
	*/
	public static List<Lounge> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lounges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @return the range of lounges
	*/
	public static List<Lounge> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lounges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lounges
	*/
	public static List<Lounge> findAll(int start, int end,
		OrderByComparator<Lounge> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lounges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LoungeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lounges
	* @param end the upper bound of the range of lounges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lounges
	*/
	public static List<Lounge> findAll(int start, int end,
		OrderByComparator<Lounge> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lounges from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lounges.
	*
	* @return the number of lounges
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LoungePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoungePersistence, LoungePersistence> _serviceTracker =
		ServiceTrackerFactory.open(LoungePersistence.class);
}