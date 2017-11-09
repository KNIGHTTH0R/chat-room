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

import com.darrylsite.liferay.chat.exception.NoSuchLoungeException;
import com.darrylsite.liferay.chat.model.Lounge;
import com.darrylsite.liferay.chat.model.impl.LoungeImpl;
import com.darrylsite.liferay.chat.model.impl.LoungeModelImpl;
import com.darrylsite.liferay.chat.service.persistence.LoungePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the lounge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Darryl Kpizingui
 * @see LoungePersistence
 * @see com.darrylsite.liferay.chat.service.persistence.LoungeUtil
 * @generated
 */
@ProviderType
public class LoungePersistenceImpl extends BasePersistenceImpl<Lounge>
	implements LoungePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoungeUtil} to access the lounge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoungeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeModelImpl.FINDER_CACHE_ENABLED, LoungeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeModelImpl.FINDER_CACHE_ENABLED, LoungeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIVILEDGE =
		new FinderPath(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeModelImpl.FINDER_CACHE_ENABLED, LoungeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPriviledge",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PRIVILEDGE =
		new FinderPath(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByPriviledge",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the lounges where priviledge &le; &#63;.
	 *
	 * @param priviledge the priviledge
	 * @return the matching lounges
	 */
	@Override
	public List<Lounge> findByPriviledge(int priviledge) {
		return findByPriviledge(priviledge, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Lounge> findByPriviledge(int priviledge, int start, int end) {
		return findByPriviledge(priviledge, start, end, null);
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
	@Override
	public List<Lounge> findByPriviledge(int priviledge, int start, int end,
		OrderByComparator<Lounge> orderByComparator) {
		return findByPriviledge(priviledge, start, end, orderByComparator, true);
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
	@Override
	public List<Lounge> findByPriviledge(int priviledge, int start, int end,
		OrderByComparator<Lounge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIVILEDGE;
		finderArgs = new Object[] { priviledge, start, end, orderByComparator };

		List<Lounge> list = null;

		if (retrieveFromCache) {
			list = (List<Lounge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Lounge lounge : list) {
					if ((priviledge < lounge.getPriviledge())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOUNGE_WHERE);

			query.append(_FINDER_COLUMN_PRIVILEDGE_PRIVILEDGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoungeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priviledge);

				if (!pagination) {
					list = (List<Lounge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lounge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first lounge in the ordered set where priviledge &le; &#63;.
	 *
	 * @param priviledge the priviledge
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lounge
	 * @throws NoSuchLoungeException if a matching lounge could not be found
	 */
	@Override
	public Lounge findByPriviledge_First(int priviledge,
		OrderByComparator<Lounge> orderByComparator)
		throws NoSuchLoungeException {
		Lounge lounge = fetchByPriviledge_First(priviledge, orderByComparator);

		if (lounge != null) {
			return lounge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("priviledge=");
		msg.append(priviledge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoungeException(msg.toString());
	}

	/**
	 * Returns the first lounge in the ordered set where priviledge &le; &#63;.
	 *
	 * @param priviledge the priviledge
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lounge, or <code>null</code> if a matching lounge could not be found
	 */
	@Override
	public Lounge fetchByPriviledge_First(int priviledge,
		OrderByComparator<Lounge> orderByComparator) {
		List<Lounge> list = findByPriviledge(priviledge, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lounge in the ordered set where priviledge &le; &#63;.
	 *
	 * @param priviledge the priviledge
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lounge
	 * @throws NoSuchLoungeException if a matching lounge could not be found
	 */
	@Override
	public Lounge findByPriviledge_Last(int priviledge,
		OrderByComparator<Lounge> orderByComparator)
		throws NoSuchLoungeException {
		Lounge lounge = fetchByPriviledge_Last(priviledge, orderByComparator);

		if (lounge != null) {
			return lounge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("priviledge=");
		msg.append(priviledge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoungeException(msg.toString());
	}

	/**
	 * Returns the last lounge in the ordered set where priviledge &le; &#63;.
	 *
	 * @param priviledge the priviledge
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lounge, or <code>null</code> if a matching lounge could not be found
	 */
	@Override
	public Lounge fetchByPriviledge_Last(int priviledge,
		OrderByComparator<Lounge> orderByComparator) {
		int count = countByPriviledge(priviledge);

		if (count == 0) {
			return null;
		}

		List<Lounge> list = findByPriviledge(priviledge, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Lounge[] findByPriviledge_PrevAndNext(long id, int priviledge,
		OrderByComparator<Lounge> orderByComparator)
		throws NoSuchLoungeException {
		Lounge lounge = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Lounge[] array = new LoungeImpl[3];

			array[0] = getByPriviledge_PrevAndNext(session, lounge, priviledge,
					orderByComparator, true);

			array[1] = lounge;

			array[2] = getByPriviledge_PrevAndNext(session, lounge, priviledge,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lounge getByPriviledge_PrevAndNext(Session session,
		Lounge lounge, int priviledge,
		OrderByComparator<Lounge> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOUNGE_WHERE);

		query.append(_FINDER_COLUMN_PRIVILEDGE_PRIVILEDGE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoungeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(priviledge);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(lounge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Lounge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lounges where priviledge &le; &#63; from the database.
	 *
	 * @param priviledge the priviledge
	 */
	@Override
	public void removeByPriviledge(int priviledge) {
		for (Lounge lounge : findByPriviledge(priviledge, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(lounge);
		}
	}

	/**
	 * Returns the number of lounges where priviledge &le; &#63;.
	 *
	 * @param priviledge the priviledge
	 * @return the number of matching lounges
	 */
	@Override
	public int countByPriviledge(int priviledge) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_PRIVILEDGE;

		Object[] finderArgs = new Object[] { priviledge };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOUNGE_WHERE);

			query.append(_FINDER_COLUMN_PRIVILEDGE_PRIVILEDGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priviledge);

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

	private static final String _FINDER_COLUMN_PRIVILEDGE_PRIVILEDGE_2 = "lounge.priviledge <= ?";

	public LoungePersistenceImpl() {
		setModelClass(Lounge.class);

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
	 * Caches the lounge in the entity cache if it is enabled.
	 *
	 * @param lounge the lounge
	 */
	@Override
	public void cacheResult(Lounge lounge) {
		entityCache.putResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeImpl.class, lounge.getPrimaryKey(), lounge);

		lounge.resetOriginalValues();
	}

	/**
	 * Caches the lounges in the entity cache if it is enabled.
	 *
	 * @param lounges the lounges
	 */
	@Override
	public void cacheResult(List<Lounge> lounges) {
		for (Lounge lounge : lounges) {
			if (entityCache.getResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
						LoungeImpl.class, lounge.getPrimaryKey()) == null) {
				cacheResult(lounge);
			}
			else {
				lounge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lounges.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoungeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lounge.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lounge lounge) {
		entityCache.removeResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeImpl.class, lounge.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lounge> lounges) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lounge lounge : lounges) {
			entityCache.removeResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
				LoungeImpl.class, lounge.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lounge with the primary key. Does not add the lounge to the database.
	 *
	 * @param id the primary key for the new lounge
	 * @return the new lounge
	 */
	@Override
	public Lounge create(long id) {
		Lounge lounge = new LoungeImpl();

		lounge.setNew(true);
		lounge.setPrimaryKey(id);

		return lounge;
	}

	/**
	 * Removes the lounge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the lounge
	 * @return the lounge that was removed
	 * @throws NoSuchLoungeException if a lounge with the primary key could not be found
	 */
	@Override
	public Lounge remove(long id) throws NoSuchLoungeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the lounge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lounge
	 * @return the lounge that was removed
	 * @throws NoSuchLoungeException if a lounge with the primary key could not be found
	 */
	@Override
	public Lounge remove(Serializable primaryKey) throws NoSuchLoungeException {
		Session session = null;

		try {
			session = openSession();

			Lounge lounge = (Lounge)session.get(LoungeImpl.class, primaryKey);

			if (lounge == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoungeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lounge);
		}
		catch (NoSuchLoungeException nsee) {
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
	protected Lounge removeImpl(Lounge lounge) {
		lounge = toUnwrappedModel(lounge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lounge)) {
				lounge = (Lounge)session.get(LoungeImpl.class,
						lounge.getPrimaryKeyObj());
			}

			if (lounge != null) {
				session.delete(lounge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lounge != null) {
			clearCache(lounge);
		}

		return lounge;
	}

	@Override
	public Lounge updateImpl(Lounge lounge) {
		lounge = toUnwrappedModel(lounge);

		boolean isNew = lounge.isNew();

		LoungeModelImpl loungeModelImpl = (LoungeModelImpl)lounge;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lounge.getCreateDate() == null)) {
			if (serviceContext == null) {
				lounge.setCreateDate(now);
			}
			else {
				lounge.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!loungeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lounge.setModifiedDate(now);
			}
			else {
				lounge.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lounge.isNew()) {
				session.save(lounge);

				lounge.setNew(false);
			}
			else {
				lounge = (Lounge)session.merge(lounge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LoungeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
			LoungeImpl.class, lounge.getPrimaryKey(), lounge, false);

		lounge.resetOriginalValues();

		return lounge;
	}

	protected Lounge toUnwrappedModel(Lounge lounge) {
		if (lounge instanceof LoungeImpl) {
			return lounge;
		}

		LoungeImpl loungeImpl = new LoungeImpl();

		loungeImpl.setNew(lounge.isNew());
		loungeImpl.setPrimaryKey(lounge.getPrimaryKey());

		loungeImpl.setId(lounge.getId());
		loungeImpl.setName(lounge.getName());
		loungeImpl.setPriviledge(lounge.getPriviledge());
		loungeImpl.setUserId(lounge.getUserId());
		loungeImpl.setCreateDate(lounge.getCreateDate());
		loungeImpl.setModifiedDate(lounge.getModifiedDate());

		return loungeImpl;
	}

	/**
	 * Returns the lounge with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lounge
	 * @return the lounge
	 * @throws NoSuchLoungeException if a lounge with the primary key could not be found
	 */
	@Override
	public Lounge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoungeException {
		Lounge lounge = fetchByPrimaryKey(primaryKey);

		if (lounge == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoungeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lounge;
	}

	/**
	 * Returns the lounge with the primary key or throws a {@link NoSuchLoungeException} if it could not be found.
	 *
	 * @param id the primary key of the lounge
	 * @return the lounge
	 * @throws NoSuchLoungeException if a lounge with the primary key could not be found
	 */
	@Override
	public Lounge findByPrimaryKey(long id) throws NoSuchLoungeException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the lounge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lounge
	 * @return the lounge, or <code>null</code> if a lounge with the primary key could not be found
	 */
	@Override
	public Lounge fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
				LoungeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Lounge lounge = (Lounge)serializable;

		if (lounge == null) {
			Session session = null;

			try {
				session = openSession();

				lounge = (Lounge)session.get(LoungeImpl.class, primaryKey);

				if (lounge != null) {
					cacheResult(lounge);
				}
				else {
					entityCache.putResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
						LoungeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
					LoungeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lounge;
	}

	/**
	 * Returns the lounge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the lounge
	 * @return the lounge, or <code>null</code> if a lounge with the primary key could not be found
	 */
	@Override
	public Lounge fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Lounge> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Lounge> map = new HashMap<Serializable, Lounge>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Lounge lounge = fetchByPrimaryKey(primaryKey);

			if (lounge != null) {
				map.put(primaryKey, lounge);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
					LoungeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Lounge)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOUNGE_WHERE_PKS_IN);

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

			for (Lounge lounge : (List<Lounge>)q.list()) {
				map.put(lounge.getPrimaryKeyObj(), lounge);

				cacheResult(lounge);

				uncachedPrimaryKeys.remove(lounge.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LoungeModelImpl.ENTITY_CACHE_ENABLED,
					LoungeImpl.class, primaryKey, nullModel);
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
	 * Returns all the lounges.
	 *
	 * @return the lounges
	 */
	@Override
	public List<Lounge> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Lounge> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Lounge> findAll(int start, int end,
		OrderByComparator<Lounge> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Lounge> findAll(int start, int end,
		OrderByComparator<Lounge> orderByComparator, boolean retrieveFromCache) {
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

		List<Lounge> list = null;

		if (retrieveFromCache) {
			list = (List<Lounge>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOUNGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOUNGE;

				if (pagination) {
					sql = sql.concat(LoungeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lounge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lounge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the lounges from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lounge lounge : findAll()) {
			remove(lounge);
		}
	}

	/**
	 * Returns the number of lounges.
	 *
	 * @return the number of lounges
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOUNGE);

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
		return LoungeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lounge persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LoungeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOUNGE = "SELECT lounge FROM Lounge lounge";
	private static final String _SQL_SELECT_LOUNGE_WHERE_PKS_IN = "SELECT lounge FROM Lounge lounge WHERE id_ IN (";
	private static final String _SQL_SELECT_LOUNGE_WHERE = "SELECT lounge FROM Lounge lounge WHERE ";
	private static final String _SQL_COUNT_LOUNGE = "SELECT COUNT(lounge) FROM Lounge lounge";
	private static final String _SQL_COUNT_LOUNGE_WHERE = "SELECT COUNT(lounge) FROM Lounge lounge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lounge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lounge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lounge exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LoungePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}