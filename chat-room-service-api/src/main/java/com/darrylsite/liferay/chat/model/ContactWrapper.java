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

package com.darrylsite.liferay.chat.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see Contact
 * @generated
 */
@ProviderType
public class ContactWrapper implements Contact, ModelWrapper<Contact> {
	public ContactWrapper(Contact contact) {
		_contact = contact;
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
	public Contact toEscapedModel() {
		return new ContactWrapper(_contact.toEscapedModel());
	}

	@Override
	public Contact toUnescapedModel() {
		return new ContactWrapper(_contact.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _contact.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _contact.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _contact.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _contact.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Contact> toCacheModel() {
		return _contact.toCacheModel();
	}

	@Override
	public int compareTo(Contact contact) {
		return _contact.compareTo(contact);
	}

	/**
	* Returns the priviledge of this contact.
	*
	* @return the priviledge of this contact
	*/
	@Override
	public int getPriviledge() {
		return _contact.getPriviledge();
	}

	/**
	* Returns the status of this contact.
	*
	* @return the status of this contact
	*/
	@Override
	public int getStatus() {
		return _contact.getStatus();
	}

	@Override
	public int hashCode() {
		return _contact.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contact.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ContactWrapper((Contact)_contact.clone());
	}

	/**
	* Returns the category of this contact.
	*
	* @return the category of this contact
	*/
	@Override
	public java.lang.String getCategory() {
		return _contact.getCategory();
	}

	/**
	* Returns the chat user uuid of this contact.
	*
	* @return the chat user uuid of this contact
	*/
	@Override
	public java.lang.String getChatUserUuid() {
		return _contact.getChatUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _contact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contact.toXmlString();
	}

	/**
	* Returns the chat user ID of this contact.
	*
	* @return the chat user ID of this contact
	*/
	@Override
	public long getChatUserId() {
		return _contact.getChatUserId();
	}

	/**
	* Returns the ID of this contact.
	*
	* @return the ID of this contact
	*/
	@Override
	public long getId() {
		return _contact.getId();
	}

	/**
	* Returns the primary key of this contact.
	*
	* @return the primary key of this contact
	*/
	@Override
	public long getPrimaryKey() {
		return _contact.getPrimaryKey();
	}

	@Override
	public void persist() {
		_contact.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contact.setCachedModel(cachedModel);
	}

	/**
	* Sets the category of this contact.
	*
	* @param category the category of this contact
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_contact.setCategory(category);
	}

	/**
	* Sets the chat user ID of this contact.
	*
	* @param chatUserId the chat user ID of this contact
	*/
	@Override
	public void setChatUserId(long chatUserId) {
		_contact.setChatUserId(chatUserId);
	}

	/**
	* Sets the chat user uuid of this contact.
	*
	* @param chatUserUuid the chat user uuid of this contact
	*/
	@Override
	public void setChatUserUuid(java.lang.String chatUserUuid) {
		_contact.setChatUserUuid(chatUserUuid);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_contact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_contact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_contact.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this contact.
	*
	* @param id the ID of this contact
	*/
	@Override
	public void setId(long id) {
		_contact.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_contact.setNew(n);
	}

	/**
	* Sets the primary key of this contact.
	*
	* @param primaryKey the primary key of this contact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contact.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_contact.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priviledge of this contact.
	*
	* @param priviledge the priviledge of this contact
	*/
	@Override
	public void setPriviledge(int priviledge) {
		_contact.setPriviledge(priviledge);
	}

	/**
	* Sets the status of this contact.
	*
	* @param status the status of this contact
	*/
	@Override
	public void setStatus(int status) {
		_contact.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactWrapper)) {
			return false;
		}

		ContactWrapper contactWrapper = (ContactWrapper)obj;

		if (Objects.equals(_contact, contactWrapper._contact)) {
			return true;
		}

		return false;
	}

	@Override
	public Contact getWrappedModel() {
		return _contact;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _contact.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _contact.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_contact.resetOriginalValues();
	}

	private final Contact _contact;
}