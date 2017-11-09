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

import com.darrylsite.liferay.chat.model.ChatUser;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the chat user service. This utility wraps {@link com.darrylsite.liferay.chat.service.persistence.impl.ChatUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ChatUserPersistence
 * @see com.darrylsite.liferay.chat.service.persistence.impl.ChatUserPersistenceImpl
 * @generated
 */
@ProviderType
public class ChatUserUtil {
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
	public static void clearCache(ChatUser chatUser) {
		getPersistence().clearCache(chatUser);
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
	public static List<ChatUser> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChatUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChatUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChatUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChatUser update(ChatUser chatUser) {
		return getPersistence().update(chatUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChatUser update(ChatUser chatUser,
		ServiceContext serviceContext) {
		return getPersistence().update(chatUser, serviceContext);
	}

	/**
	* Returns the chat user where pseudo = &#63; or throws a {@link NoSuchChatUserException} if it could not be found.
	*
	* @param pseudo the pseudo
	* @return the matching chat user
	* @throws NoSuchChatUserException if a matching chat user could not be found
	*/
	public static ChatUser findByPseudo(java.lang.String pseudo)
		throws com.darrylsite.liferay.chat.exception.NoSuchChatUserException {
		return getPersistence().findByPseudo(pseudo);
	}

	/**
	* Returns the chat user where pseudo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pseudo the pseudo
	* @return the matching chat user, or <code>null</code> if a matching chat user could not be found
	*/
	public static ChatUser fetchByPseudo(java.lang.String pseudo) {
		return getPersistence().fetchByPseudo(pseudo);
	}

	/**
	* Returns the chat user where pseudo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pseudo the pseudo
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching chat user, or <code>null</code> if a matching chat user could not be found
	*/
	public static ChatUser fetchByPseudo(java.lang.String pseudo,
		boolean retrieveFromCache) {
		return getPersistence().fetchByPseudo(pseudo, retrieveFromCache);
	}

	/**
	* Removes the chat user where pseudo = &#63; from the database.
	*
	* @param pseudo the pseudo
	* @return the chat user that was removed
	*/
	public static ChatUser removeByPseudo(java.lang.String pseudo)
		throws com.darrylsite.liferay.chat.exception.NoSuchChatUserException {
		return getPersistence().removeByPseudo(pseudo);
	}

	/**
	* Returns the number of chat users where pseudo = &#63;.
	*
	* @param pseudo the pseudo
	* @return the number of matching chat users
	*/
	public static int countByPseudo(java.lang.String pseudo) {
		return getPersistence().countByPseudo(pseudo);
	}

	/**
	* Caches the chat user in the entity cache if it is enabled.
	*
	* @param chatUser the chat user
	*/
	public static void cacheResult(ChatUser chatUser) {
		getPersistence().cacheResult(chatUser);
	}

	/**
	* Caches the chat users in the entity cache if it is enabled.
	*
	* @param chatUsers the chat users
	*/
	public static void cacheResult(List<ChatUser> chatUsers) {
		getPersistence().cacheResult(chatUsers);
	}

	/**
	* Creates a new chat user with the primary key. Does not add the chat user to the database.
	*
	* @param id the primary key for the new chat user
	* @return the new chat user
	*/
	public static ChatUser create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chat user
	* @return the chat user that was removed
	* @throws NoSuchChatUserException if a chat user with the primary key could not be found
	*/
	public static ChatUser remove(long id)
		throws com.darrylsite.liferay.chat.exception.NoSuchChatUserException {
		return getPersistence().remove(id);
	}

	public static ChatUser updateImpl(ChatUser chatUser) {
		return getPersistence().updateImpl(chatUser);
	}

	/**
	* Returns the chat user with the primary key or throws a {@link NoSuchChatUserException} if it could not be found.
	*
	* @param id the primary key of the chat user
	* @return the chat user
	* @throws NoSuchChatUserException if a chat user with the primary key could not be found
	*/
	public static ChatUser findByPrimaryKey(long id)
		throws com.darrylsite.liferay.chat.exception.NoSuchChatUserException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the chat user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chat user
	* @return the chat user, or <code>null</code> if a chat user with the primary key could not be found
	*/
	public static ChatUser fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, ChatUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the chat users.
	*
	* @return the chat users
	*/
	public static List<ChatUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chat users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChatUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chat users
	* @param end the upper bound of the range of chat users (not inclusive)
	* @return the range of chat users
	*/
	public static List<ChatUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chat users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChatUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chat users
	* @param end the upper bound of the range of chat users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chat users
	*/
	public static List<ChatUser> findAll(int start, int end,
		OrderByComparator<ChatUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the chat users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChatUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chat users
	* @param end the upper bound of the range of chat users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of chat users
	*/
	public static List<ChatUser> findAll(int start, int end,
		OrderByComparator<ChatUser> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the chat users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chat users.
	*
	* @return the number of chat users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ChatUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChatUserPersistence, ChatUserPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ChatUserPersistence.class);
}