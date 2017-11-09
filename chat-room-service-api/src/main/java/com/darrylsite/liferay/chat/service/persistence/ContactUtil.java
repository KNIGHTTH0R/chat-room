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

import com.darrylsite.liferay.chat.model.Contact;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the contact service. This utility wraps {@link com.darrylsite.liferay.chat.service.persistence.impl.ContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ContactPersistence
 * @see com.darrylsite.liferay.chat.service.persistence.impl.ContactPersistenceImpl
 * @generated
 */
@ProviderType
public class ContactUtil {
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
	public static void clearCache(Contact contact) {
		getPersistence().clearCache(contact);
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
	public static List<Contact> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Contact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Contact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Contact> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Contact update(Contact contact) {
		return getPersistence().update(contact);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Contact update(Contact contact, ServiceContext serviceContext) {
		return getPersistence().update(contact, serviceContext);
	}

	/**
	* Returns all the contacts where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @return the matching contacts
	*/
	public static List<Contact> findByChatUserId(long chatUserId) {
		return getPersistence().findByChatUserId(chatUserId);
	}

	/**
	* Returns a range of all the contacts where chatUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chatUserId the chat user ID
	* @param start the lower bound of the range of contacts
	* @param end the upper bound of the range of contacts (not inclusive)
	* @return the range of matching contacts
	*/
	public static List<Contact> findByChatUserId(long chatUserId, int start,
		int end) {
		return getPersistence().findByChatUserId(chatUserId, start, end);
	}

	/**
	* Returns an ordered range of all the contacts where chatUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chatUserId the chat user ID
	* @param start the lower bound of the range of contacts
	* @param end the upper bound of the range of contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts
	*/
	public static List<Contact> findByChatUserId(long chatUserId, int start,
		int end, OrderByComparator<Contact> orderByComparator) {
		return getPersistence()
				   .findByChatUserId(chatUserId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the contacts where chatUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chatUserId the chat user ID
	* @param start the lower bound of the range of contacts
	* @param end the upper bound of the range of contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching contacts
	*/
	public static List<Contact> findByChatUserId(long chatUserId, int start,
		int end, OrderByComparator<Contact> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByChatUserId(chatUserId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact
	* @throws NoSuchContactException if a matching contact could not be found
	*/
	public static Contact findByChatUserId_First(long chatUserId,
		OrderByComparator<Contact> orderByComparator)
		throws com.darrylsite.liferay.chat.exception.NoSuchContactException {
		return getPersistence()
				   .findByChatUserId_First(chatUserId, orderByComparator);
	}

	/**
	* Returns the first contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact, or <code>null</code> if a matching contact could not be found
	*/
	public static Contact fetchByChatUserId_First(long chatUserId,
		OrderByComparator<Contact> orderByComparator) {
		return getPersistence()
				   .fetchByChatUserId_First(chatUserId, orderByComparator);
	}

	/**
	* Returns the last contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact
	* @throws NoSuchContactException if a matching contact could not be found
	*/
	public static Contact findByChatUserId_Last(long chatUserId,
		OrderByComparator<Contact> orderByComparator)
		throws com.darrylsite.liferay.chat.exception.NoSuchContactException {
		return getPersistence()
				   .findByChatUserId_Last(chatUserId, orderByComparator);
	}

	/**
	* Returns the last contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact, or <code>null</code> if a matching contact could not be found
	*/
	public static Contact fetchByChatUserId_Last(long chatUserId,
		OrderByComparator<Contact> orderByComparator) {
		return getPersistence()
				   .fetchByChatUserId_Last(chatUserId, orderByComparator);
	}

	/**
	* Returns the contacts before and after the current contact in the ordered set where chatUserId = &#63;.
	*
	* @param id the primary key of the current contact
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact
	* @throws NoSuchContactException if a contact with the primary key could not be found
	*/
	public static Contact[] findByChatUserId_PrevAndNext(long id,
		long chatUserId, OrderByComparator<Contact> orderByComparator)
		throws com.darrylsite.liferay.chat.exception.NoSuchContactException {
		return getPersistence()
				   .findByChatUserId_PrevAndNext(id, chatUserId,
			orderByComparator);
	}

	/**
	* Removes all the contacts where chatUserId = &#63; from the database.
	*
	* @param chatUserId the chat user ID
	*/
	public static void removeByChatUserId(long chatUserId) {
		getPersistence().removeByChatUserId(chatUserId);
	}

	/**
	* Returns the number of contacts where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @return the number of matching contacts
	*/
	public static int countByChatUserId(long chatUserId) {
		return getPersistence().countByChatUserId(chatUserId);
	}

	/**
	* Caches the contact in the entity cache if it is enabled.
	*
	* @param contact the contact
	*/
	public static void cacheResult(Contact contact) {
		getPersistence().cacheResult(contact);
	}

	/**
	* Caches the contacts in the entity cache if it is enabled.
	*
	* @param contacts the contacts
	*/
	public static void cacheResult(List<Contact> contacts) {
		getPersistence().cacheResult(contacts);
	}

	/**
	* Creates a new contact with the primary key. Does not add the contact to the database.
	*
	* @param id the primary key for the new contact
	* @return the new contact
	*/
	public static Contact create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the contact
	* @return the contact that was removed
	* @throws NoSuchContactException if a contact with the primary key could not be found
	*/
	public static Contact remove(long id)
		throws com.darrylsite.liferay.chat.exception.NoSuchContactException {
		return getPersistence().remove(id);
	}

	public static Contact updateImpl(Contact contact) {
		return getPersistence().updateImpl(contact);
	}

	/**
	* Returns the contact with the primary key or throws a {@link NoSuchContactException} if it could not be found.
	*
	* @param id the primary key of the contact
	* @return the contact
	* @throws NoSuchContactException if a contact with the primary key could not be found
	*/
	public static Contact findByPrimaryKey(long id)
		throws com.darrylsite.liferay.chat.exception.NoSuchContactException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the contact
	* @return the contact, or <code>null</code> if a contact with the primary key could not be found
	*/
	public static Contact fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Contact> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the contacts.
	*
	* @return the contacts
	*/
	public static List<Contact> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contacts
	* @param end the upper bound of the range of contacts (not inclusive)
	* @return the range of contacts
	*/
	public static List<Contact> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contacts
	* @param end the upper bound of the range of contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contacts
	*/
	public static List<Contact> findAll(int start, int end,
		OrderByComparator<Contact> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contacts
	* @param end the upper bound of the range of contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of contacts
	*/
	public static List<Contact> findAll(int start, int end,
		OrderByComparator<Contact> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the contacts from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contacts.
	*
	* @return the number of contacts
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ContactPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ContactPersistence, ContactPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ContactPersistence.class);
}