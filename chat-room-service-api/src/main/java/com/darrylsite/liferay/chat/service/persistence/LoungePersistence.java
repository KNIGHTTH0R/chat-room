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

import com.darrylsite.liferay.chat.exception.NoSuchLoungeException;
import com.darrylsite.liferay.chat.model.Lounge;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lounge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see com.darrylsite.liferay.chat.service.persistence.impl.LoungePersistenceImpl
 * @see LoungeUtil
 * @generated
 */
@ProviderType
public interface LoungePersistence extends BasePersistence<Lounge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoungeUtil} to access the lounge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lounges where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @return the matching lounges
	*/
	public java.util.List<Lounge> findByPriviledge(int priviledge);

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
	public java.util.List<Lounge> findByPriviledge(int priviledge, int start,
		int end);

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
	public java.util.List<Lounge> findByPriviledge(int priviledge, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator);

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
	public java.util.List<Lounge> findByPriviledge(int priviledge, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lounge
	* @throws NoSuchLoungeException if a matching lounge could not be found
	*/
	public Lounge findByPriviledge_First(int priviledge,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator)
		throws NoSuchLoungeException;

	/**
	* Returns the first lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lounge, or <code>null</code> if a matching lounge could not be found
	*/
	public Lounge fetchByPriviledge_First(int priviledge,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator);

	/**
	* Returns the last lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lounge
	* @throws NoSuchLoungeException if a matching lounge could not be found
	*/
	public Lounge findByPriviledge_Last(int priviledge,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator)
		throws NoSuchLoungeException;

	/**
	* Returns the last lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lounge, or <code>null</code> if a matching lounge could not be found
	*/
	public Lounge fetchByPriviledge_Last(int priviledge,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator);

	/**
	* Returns the lounges before and after the current lounge in the ordered set where priviledge &le; &#63;.
	*
	* @param id the primary key of the current lounge
	* @param priviledge the priviledge
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lounge
	* @throws NoSuchLoungeException if a lounge with the primary key could not be found
	*/
	public Lounge[] findByPriviledge_PrevAndNext(long id, int priviledge,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator)
		throws NoSuchLoungeException;

	/**
	* Removes all the lounges where priviledge &le; &#63; from the database.
	*
	* @param priviledge the priviledge
	*/
	public void removeByPriviledge(int priviledge);

	/**
	* Returns the number of lounges where priviledge &le; &#63;.
	*
	* @param priviledge the priviledge
	* @return the number of matching lounges
	*/
	public int countByPriviledge(int priviledge);

	/**
	* Caches the lounge in the entity cache if it is enabled.
	*
	* @param lounge the lounge
	*/
	public void cacheResult(Lounge lounge);

	/**
	* Caches the lounges in the entity cache if it is enabled.
	*
	* @param lounges the lounges
	*/
	public void cacheResult(java.util.List<Lounge> lounges);

	/**
	* Creates a new lounge with the primary key. Does not add the lounge to the database.
	*
	* @param id the primary key for the new lounge
	* @return the new lounge
	*/
	public Lounge create(long id);

	/**
	* Removes the lounge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the lounge
	* @return the lounge that was removed
	* @throws NoSuchLoungeException if a lounge with the primary key could not be found
	*/
	public Lounge remove(long id) throws NoSuchLoungeException;

	public Lounge updateImpl(Lounge lounge);

	/**
	* Returns the lounge with the primary key or throws a {@link NoSuchLoungeException} if it could not be found.
	*
	* @param id the primary key of the lounge
	* @return the lounge
	* @throws NoSuchLoungeException if a lounge with the primary key could not be found
	*/
	public Lounge findByPrimaryKey(long id) throws NoSuchLoungeException;

	/**
	* Returns the lounge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the lounge
	* @return the lounge, or <code>null</code> if a lounge with the primary key could not be found
	*/
	public Lounge fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Lounge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lounges.
	*
	* @return the lounges
	*/
	public java.util.List<Lounge> findAll();

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
	public java.util.List<Lounge> findAll(int start, int end);

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
	public java.util.List<Lounge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator);

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
	public java.util.List<Lounge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lounge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lounges from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lounges.
	*
	* @return the number of lounges
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}