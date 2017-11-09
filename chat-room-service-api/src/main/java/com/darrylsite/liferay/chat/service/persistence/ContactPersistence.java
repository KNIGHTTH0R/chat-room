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

import com.darrylsite.liferay.chat.exception.NoSuchContactException;
import com.darrylsite.liferay.chat.model.Contact;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see com.darrylsite.liferay.chat.service.persistence.impl.ContactPersistenceImpl
 * @see ContactUtil
 * @generated
 */
@ProviderType
public interface ContactPersistence extends BasePersistence<Contact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the contacts where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @return the matching contacts
	*/
	public java.util.List<Contact> findByChatUserId(long chatUserId);

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
	public java.util.List<Contact> findByChatUserId(long chatUserId, int start,
		int end);

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
	public java.util.List<Contact> findByChatUserId(long chatUserId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator);

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
	public java.util.List<Contact> findByChatUserId(long chatUserId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact
	* @throws NoSuchContactException if a matching contact could not be found
	*/
	public Contact findByChatUserId_First(long chatUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator)
		throws NoSuchContactException;

	/**
	* Returns the first contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact, or <code>null</code> if a matching contact could not be found
	*/
	public Contact fetchByChatUserId_First(long chatUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator);

	/**
	* Returns the last contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact
	* @throws NoSuchContactException if a matching contact could not be found
	*/
	public Contact findByChatUserId_Last(long chatUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator)
		throws NoSuchContactException;

	/**
	* Returns the last contact in the ordered set where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact, or <code>null</code> if a matching contact could not be found
	*/
	public Contact fetchByChatUserId_Last(long chatUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator);

	/**
	* Returns the contacts before and after the current contact in the ordered set where chatUserId = &#63;.
	*
	* @param id the primary key of the current contact
	* @param chatUserId the chat user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact
	* @throws NoSuchContactException if a contact with the primary key could not be found
	*/
	public Contact[] findByChatUserId_PrevAndNext(long id, long chatUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator)
		throws NoSuchContactException;

	/**
	* Removes all the contacts where chatUserId = &#63; from the database.
	*
	* @param chatUserId the chat user ID
	*/
	public void removeByChatUserId(long chatUserId);

	/**
	* Returns the number of contacts where chatUserId = &#63;.
	*
	* @param chatUserId the chat user ID
	* @return the number of matching contacts
	*/
	public int countByChatUserId(long chatUserId);

	/**
	* Caches the contact in the entity cache if it is enabled.
	*
	* @param contact the contact
	*/
	public void cacheResult(Contact contact);

	/**
	* Caches the contacts in the entity cache if it is enabled.
	*
	* @param contacts the contacts
	*/
	public void cacheResult(java.util.List<Contact> contacts);

	/**
	* Creates a new contact with the primary key. Does not add the contact to the database.
	*
	* @param id the primary key for the new contact
	* @return the new contact
	*/
	public Contact create(long id);

	/**
	* Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the contact
	* @return the contact that was removed
	* @throws NoSuchContactException if a contact with the primary key could not be found
	*/
	public Contact remove(long id) throws NoSuchContactException;

	public Contact updateImpl(Contact contact);

	/**
	* Returns the contact with the primary key or throws a {@link NoSuchContactException} if it could not be found.
	*
	* @param id the primary key of the contact
	* @return the contact
	* @throws NoSuchContactException if a contact with the primary key could not be found
	*/
	public Contact findByPrimaryKey(long id) throws NoSuchContactException;

	/**
	* Returns the contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the contact
	* @return the contact, or <code>null</code> if a contact with the primary key could not be found
	*/
	public Contact fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Contact> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the contacts.
	*
	* @return the contacts
	*/
	public java.util.List<Contact> findAll();

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
	public java.util.List<Contact> findAll(int start, int end);

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
	public java.util.List<Contact> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator);

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
	public java.util.List<Contact> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Contact> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the contacts from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of contacts.
	*
	* @return the number of contacts
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}