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

package com.darrylsite.liferay.chat.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.darrylsite.liferay.chat.model.Contact;
import com.darrylsite.liferay.chat.model.ContactModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Contact service. Represents a row in the &quot;chatRoom_Contact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactImpl}.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ContactImpl
 * @see Contact
 * @see ContactModel
 * @generated
 */
@ProviderType
public class ContactModelImpl extends BaseModelImpl<Contact>
	implements ContactModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a contact model instance should use the {@link Contact} interface instead.
	 */
	public static final String TABLE_NAME = "chatRoom_Contact";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "category", Types.VARCHAR },
			{ "priviledge", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "chatUserId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priviledge", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("chatUserId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table chatRoom_Contact (id_ LONG not null primary key,category VARCHAR(75) null,priviledge INTEGER,status INTEGER,chatUserId LONG)";
	public static final String TABLE_SQL_DROP = "drop table chatRoom_Contact";
	public static final String ORDER_BY_JPQL = " ORDER BY contact.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY chatRoom_Contact.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(chat.room.service.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.darrylsite.liferay.chat.model.Contact"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(chat.room.service.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.darrylsite.liferay.chat.model.Contact"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(chat.room.service.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.darrylsite.liferay.chat.model.Contact"),
			true);
	public static final long CHATUSERID_COLUMN_BITMASK = 1L;
	public static final long ID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(chat.room.service.service.util.ServiceProps.get(
				"lock.expiration.time.com.darrylsite.liferay.chat.model.Contact"));

	public ContactModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Contact.class;
	}

	@Override
	public String getModelClassName() {
		return Contact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("category", getCategory());
		attributes.put("priviledge", getPriviledge());
		attributes.put("status", getStatus());
		attributes.put("chatUserId", getChatUserId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Integer priviledge = (Integer)attributes.get("priviledge");

		if (priviledge != null) {
			setPriviledge(priviledge);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long chatUserId = (Long)attributes.get("chatUserId");

		if (chatUserId != null) {
			setChatUserId(chatUserId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getCategory() {
		if (_category == null) {
			return StringPool.BLANK;
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		_category = category;
	}

	@Override
	public int getPriviledge() {
		return _priviledge;
	}

	@Override
	public void setPriviledge(int priviledge) {
		_priviledge = priviledge;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getChatUserId() {
		return _chatUserId;
	}

	@Override
	public void setChatUserId(long chatUserId) {
		_columnBitmask |= CHATUSERID_COLUMN_BITMASK;

		if (!_setOriginalChatUserId) {
			_setOriginalChatUserId = true;

			_originalChatUserId = _chatUserId;
		}

		_chatUserId = chatUserId;
	}

	@Override
	public String getChatUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getChatUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setChatUserUuid(String chatUserUuid) {
	}

	public long getOriginalChatUserId() {
		return _originalChatUserId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Contact.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Contact toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Contact)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setId(getId());
		contactImpl.setCategory(getCategory());
		contactImpl.setPriviledge(getPriviledge());
		contactImpl.setStatus(getStatus());
		contactImpl.setChatUserId(getChatUserId());

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public int compareTo(Contact contact) {
		long primaryKey = contact.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Contact)) {
			return false;
		}

		Contact contact = (Contact)obj;

		long primaryKey = contact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ContactModelImpl contactModelImpl = this;

		contactModelImpl._originalChatUserId = contactModelImpl._chatUserId;

		contactModelImpl._setOriginalChatUserId = false;

		contactModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Contact> toCacheModel() {
		ContactCacheModel contactCacheModel = new ContactCacheModel();

		contactCacheModel.id = getId();

		contactCacheModel.category = getCategory();

		String category = contactCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			contactCacheModel.category = null;
		}

		contactCacheModel.priviledge = getPriviledge();

		contactCacheModel.status = getStatus();

		contactCacheModel.chatUserId = getChatUserId();

		return contactCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", priviledge=");
		sb.append(getPriviledge());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", chatUserId=");
		sb.append(getChatUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.darrylsite.liferay.chat.model.Contact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priviledge</column-name><column-value><![CDATA[");
		sb.append(getPriviledge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chatUserId</column-name><column-value><![CDATA[");
		sb.append(getChatUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Contact.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Contact.class
		};
	private long _id;
	private String _category;
	private int _priviledge;
	private int _status;
	private long _chatUserId;
	private long _originalChatUserId;
	private boolean _setOriginalChatUserId;
	private long _columnBitmask;
	private Contact _escapedModel;
}