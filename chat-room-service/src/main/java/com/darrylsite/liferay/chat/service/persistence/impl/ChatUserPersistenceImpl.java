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

package com.darrylsite.liferay.chat.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.darrylsite.liferay.chat.exception.NoSuchChatUserException;
import com.darrylsite.liferay.chat.model.ChatUser;
import com.darrylsite.liferay.chat.model.impl.ChatUserImpl;
import com.darrylsite.liferay.chat.model.impl.ChatUserModelImpl;
import com.darrylsite.liferay.chat.service.persistence.ChatUserPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the chat user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ChatUserPersistence
 * @see com.darrylsite.liferay.chat.service.persistence.ChatUserUtil
 * @generated
 */
@ProviderType
public class ChatUserPersistenceImpl extends BasePersistenceImpl<ChatUser>
	implements ChatUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChatUserUtil} to access the chat user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChatUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserModelImpl.FINDER_CACHE_ENABLED, ChatUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserModelImpl.FINDER_CACHE_ENABLED, ChatUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PSEUDO = new FinderPath(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserModelImpl.FINDER_CACHE_ENABLED, ChatUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPseudo",
			new String[] { String.class.getName() },
			ChatUserModelImpl.PSEUDO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PSEUDO = new FinderPath(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPseudo",
			new String[] { String.class.getName() });

	/**
	 * Returns the chat user where pseudo = &#63; or throws a {@link NoSuchChatUserException} if it could not be found.
	 *
	 * @param pseudo the pseudo
	 * @return the matching chat user
	 * @throws NoSuchChatUserException if a matching chat user could not be found
	 */
	@Override
	public ChatUser findByPseudo(String pseudo) throws NoSuchChatUserException {
		ChatUser chatUser = fetchByPseudo(pseudo);

		if (chatUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pseudo=");
			msg.append(pseudo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchChatUserException(msg.toString());
		}

		return chatUser;
	}

	/**
	 * Returns the chat user where pseudo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pseudo the pseudo
	 * @return the matching chat user, or <code>null</code> if a matching chat user could not be found
	 */
	@Override
	public ChatUser fetchByPseudo(String pseudo) {
		return fetchByPseudo(pseudo, true);
	}

	/**
	 * Returns the chat user where pseudo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pseudo the pseudo
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching chat user, or <code>null</code> if a matching chat user could not be found
	 */
	@Override
	public ChatUser fetchByPseudo(String pseudo, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { pseudo };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PSEUDO,
					finderArgs, this);
		}

		if (result instanceof ChatUser) {
			ChatUser chatUser = (ChatUser)result;

			if (!Objects.equals(pseudo, chatUser.getPseudo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CHATUSER_WHERE);

			boolean bindPseudo = false;

			if (pseudo == null) {
				query.append(_FINDER_COLUMN_PSEUDO_PSEUDO_1);
			}
			else if (pseudo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PSEUDO_PSEUDO_3);
			}
			else {
				bindPseudo = true;

				query.append(_FINDER_COLUMN_PSEUDO_PSEUDO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPseudo) {
					qPos.add(pseudo);
				}

				List<ChatUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PSEUDO,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ChatUserPersistenceImpl.fetchByPseudo(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ChatUser chatUser = list.get(0);

					result = chatUser;

					cacheResult(chatUser);

					if ((chatUser.getPseudo() == null) ||
							!chatUser.getPseudo().equals(pseudo)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_PSEUDO,
							finderArgs, chatUser);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PSEUDO, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ChatUser)result;
		}
	}

	/**
	 * Removes the chat user where pseudo = &#63; from the database.
	 *
	 * @param pseudo the pseudo
	 * @return the chat user that was removed
	 */
	@Override
	public ChatUser removeByPseudo(String pseudo)
		throws NoSuchChatUserException {
		ChatUser chatUser = findByPseudo(pseudo);

		return remove(chatUser);
	}

	/**
	 * Returns the number of chat users where pseudo = &#63;.
	 *
	 * @param pseudo the pseudo
	 * @return the number of matching chat users
	 */
	@Override
	public int countByPseudo(String pseudo) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PSEUDO;

		Object[] finderArgs = new Object[] { pseudo };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHATUSER_WHERE);

			boolean bindPseudo = false;

			if (pseudo == null) {
				query.append(_FINDER_COLUMN_PSEUDO_PSEUDO_1);
			}
			else if (pseudo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PSEUDO_PSEUDO_3);
			}
			else {
				bindPseudo = true;

				query.append(_FINDER_COLUMN_PSEUDO_PSEUDO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPseudo) {
					qPos.add(pseudo);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PSEUDO_PSEUDO_1 = "chatUser.pseudo IS NULL";
	private static final String _FINDER_COLUMN_PSEUDO_PSEUDO_2 = "chatUser.pseudo = ?";
	private static final String _FINDER_COLUMN_PSEUDO_PSEUDO_3 = "(chatUser.pseudo IS NULL OR chatUser.pseudo = '')";

	public ChatUserPersistenceImpl() {
		setModelClass(ChatUser.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the chat user in the entity cache if it is enabled.
	 *
	 * @param chatUser the chat user
	 */
	@Override
	public void cacheResult(ChatUser chatUser) {
		entityCache.putResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserImpl.class, chatUser.getPrimaryKey(), chatUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PSEUDO,
			new Object[] { chatUser.getPseudo() }, chatUser);

		chatUser.resetOriginalValues();
	}

	/**
	 * Caches the chat users in the entity cache if it is enabled.
	 *
	 * @param chatUsers the chat users
	 */
	@Override
	public void cacheResult(List<ChatUser> chatUsers) {
		for (ChatUser chatUser : chatUsers) {
			if (entityCache.getResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
						ChatUserImpl.class, chatUser.getPrimaryKey()) == null) {
				cacheResult(chatUser);
			}
			else {
				chatUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chat users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChatUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chat user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChatUser chatUser) {
		entityCache.removeResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserImpl.class, chatUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ChatUserModelImpl)chatUser, true);
	}

	@Override
	public void clearCache(List<ChatUser> chatUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChatUser chatUser : chatUsers) {
			entityCache.removeResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
				ChatUserImpl.class, chatUser.getPrimaryKey());

			clearUniqueFindersCache((ChatUserModelImpl)chatUser, true);
		}
	}

	protected void cacheUniqueFindersCache(ChatUserModelImpl chatUserModelImpl) {
		Object[] args = new Object[] { chatUserModelImpl.getPseudo() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_PSEUDO, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PSEUDO, args,
			chatUserModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ChatUserModelImpl chatUserModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { chatUserModelImpl.getPseudo() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PSEUDO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PSEUDO, args);
		}

		if ((chatUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PSEUDO.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { chatUserModelImpl.getOriginalPseudo() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PSEUDO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PSEUDO, args);
		}
	}

	/**
	 * Creates a new chat user with the primary key. Does not add the chat user to the database.
	 *
	 * @param id the primary key for the new chat user
	 * @return the new chat user
	 */
	@Override
	public ChatUser create(long id) {
		ChatUser chatUser = new ChatUserImpl();

		chatUser.setNew(true);
		chatUser.setPrimaryKey(id);

		return chatUser;
	}

	/**
	 * Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser remove(long id) throws NoSuchChatUserException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chat user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chat user
	 * @return the chat user that was removed
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser remove(Serializable primaryKey)
		throws NoSuchChatUserException {
		Session session = null;

		try {
			session = openSession();

			ChatUser chatUser = (ChatUser)session.get(ChatUserImpl.class,
					primaryKey);

			if (chatUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChatUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chatUser);
		}
		catch (NoSuchChatUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ChatUser removeImpl(ChatUser chatUser) {
		chatUser = toUnwrappedModel(chatUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chatUser)) {
				chatUser = (ChatUser)session.get(ChatUserImpl.class,
						chatUser.getPrimaryKeyObj());
			}

			if (chatUser != null) {
				session.delete(chatUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chatUser != null) {
			clearCache(chatUser);
		}

		return chatUser;
	}

	@Override
	public ChatUser updateImpl(ChatUser chatUser) {
		chatUser = toUnwrappedModel(chatUser);

		boolean isNew = chatUser.isNew();

		ChatUserModelImpl chatUserModelImpl = (ChatUserModelImpl)chatUser;

		Session session = null;

		try {
			session = openSession();

			if (chatUser.isNew()) {
				session.save(chatUser);

				chatUser.setNew(false);
			}
			else {
				chatUser = (ChatUser)session.merge(chatUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ChatUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
			ChatUserImpl.class, chatUser.getPrimaryKey(), chatUser, false);

		clearUniqueFindersCache(chatUserModelImpl, false);
		cacheUniqueFindersCache(chatUserModelImpl);

		chatUser.resetOriginalValues();

		return chatUser;
	}

	protected ChatUser toUnwrappedModel(ChatUser chatUser) {
		if (chatUser instanceof ChatUserImpl) {
			return chatUser;
		}

		ChatUserImpl chatUserImpl = new ChatUserImpl();

		chatUserImpl.setNew(chatUser.isNew());
		chatUserImpl.setPrimaryKey(chatUser.getPrimaryKey());

		chatUserImpl.setId(chatUser.getId());
		chatUserImpl.setPseudo(chatUser.getPseudo());
		chatUserImpl.setDescription(chatUser.getDescription());
		chatUserImpl.setUserId(chatUser.getUserId());
		chatUserImpl.setAvatar(chatUser.getAvatar());

		return chatUserImpl;
	}

	/**
	 * Returns the chat user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat user
	 * @return the chat user
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChatUserException {
		ChatUser chatUser = fetchByPrimaryKey(primaryKey);

		if (chatUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChatUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chatUser;
	}

	/**
	 * Returns the chat user with the primary key or throws a {@link NoSuchChatUserException} if it could not be found.
	 *
	 * @param id the primary key of the chat user
	 * @return the chat user
	 * @throws NoSuchChatUserException if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser findByPrimaryKey(long id) throws NoSuchChatUserException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chat user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat user
	 * @return the chat user, or <code>null</code> if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
				ChatUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ChatUser chatUser = (ChatUser)serializable;

		if (chatUser == null) {
			Session session = null;

			try {
				session = openSession();

				chatUser = (ChatUser)session.get(ChatUserImpl.class, primaryKey);

				if (chatUser != null) {
					cacheResult(chatUser);
				}
				else {
					entityCache.putResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
						ChatUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
					ChatUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chatUser;
	}

	/**
	 * Returns the chat user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chat user
	 * @return the chat user, or <code>null</code> if a chat user with the primary key could not be found
	 */
	@Override
	public ChatUser fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ChatUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ChatUser> map = new HashMap<Serializable, ChatUser>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ChatUser chatUser = fetchByPrimaryKey(primaryKey);

			if (chatUser != null) {
				map.put(primaryKey, chatUser);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
					ChatUserImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ChatUser)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CHATUSER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ChatUser chatUser : (List<ChatUser>)q.list()) {
				map.put(chatUser.getPrimaryKeyObj(), chatUser);

				cacheResult(chatUser);

				uncachedPrimaryKeys.remove(chatUser.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ChatUserModelImpl.ENTITY_CACHE_ENABLED,
					ChatUserImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the chat users.
	 *
	 * @return the chat users
	 */
	@Override
	public List<ChatUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChatUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ChatUser> findAll(int start, int end,
		OrderByComparator<ChatUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ChatUser> findAll(int start, int end,
		OrderByComparator<ChatUser> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ChatUser> list = null;

		if (retrieveFromCache) {
			list = (List<ChatUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CHATUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHATUSER;

				if (pagination) {
					sql = sql.concat(ChatUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChatUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChatUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the chat users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChatUser chatUser : findAll()) {
			remove(chatUser);
		}
	}

	/**
	 * Returns the number of chat users.
	 *
	 * @return the number of chat users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHATUSER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChatUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chat user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ChatUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CHATUSER = "SELECT chatUser FROM ChatUser chatUser";
	private static final String _SQL_SELECT_CHATUSER_WHERE_PKS_IN = "SELECT chatUser FROM ChatUser chatUser WHERE id_ IN (";
	private static final String _SQL_SELECT_CHATUSER_WHERE = "SELECT chatUser FROM ChatUser chatUser WHERE ";
	private static final String _SQL_COUNT_CHATUSER = "SELECT COUNT(chatUser) FROM ChatUser chatUser";
	private static final String _SQL_COUNT_CHATUSER_WHERE = "SELECT COUNT(chatUser) FROM ChatUser chatUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chatUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChatUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ChatUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}