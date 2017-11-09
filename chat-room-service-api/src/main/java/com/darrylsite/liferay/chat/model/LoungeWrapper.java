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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Lounge}.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see Lounge
 * @generated
 */
@ProviderType
public class LoungeWrapper implements Lounge, ModelWrapper<Lounge> {
	public LoungeWrapper(Lounge lounge) {
		_lounge = lounge;
	}

	@Override
	public Class<?> getModelClass() {
		return Lounge.class;
	}

	@Override
	public String getModelClassName() {
		return Lounge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("priviledge", getPriviledge());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer priviledge = (Integer)attributes.get("priviledge");

		if (priviledge != null) {
			setPriviledge(priviledge);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Lounge toEscapedModel() {
		return new LoungeWrapper(_lounge.toEscapedModel());
	}

	@Override
	public Lounge toUnescapedModel() {
		return new LoungeWrapper(_lounge.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _lounge.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _lounge.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _lounge.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _lounge.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Lounge> toCacheModel() {
		return _lounge.toCacheModel();
	}

	@Override
	public int compareTo(Lounge lounge) {
		return _lounge.compareTo(lounge);
	}

	/**
	* Returns the priviledge of this lounge.
	*
	* @return the priviledge of this lounge
	*/
	@Override
	public int getPriviledge() {
		return _lounge.getPriviledge();
	}

	@Override
	public int hashCode() {
		return _lounge.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lounge.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LoungeWrapper((Lounge)_lounge.clone());
	}

	/**
	* Returns the name of this lounge.
	*
	* @return the name of this lounge
	*/
	@Override
	public java.lang.String getName() {
		return _lounge.getName();
	}

	/**
	* Returns the user uuid of this lounge.
	*
	* @return the user uuid of this lounge
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _lounge.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _lounge.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _lounge.toXmlString();
	}

	/**
	* Returns the create date of this lounge.
	*
	* @return the create date of this lounge
	*/
	@Override
	public Date getCreateDate() {
		return _lounge.getCreateDate();
	}

	/**
	* Returns the modified date of this lounge.
	*
	* @return the modified date of this lounge
	*/
	@Override
	public Date getModifiedDate() {
		return _lounge.getModifiedDate();
	}

	/**
	* Returns the ID of this lounge.
	*
	* @return the ID of this lounge
	*/
	@Override
	public long getId() {
		return _lounge.getId();
	}

	/**
	* Returns the primary key of this lounge.
	*
	* @return the primary key of this lounge
	*/
	@Override
	public long getPrimaryKey() {
		return _lounge.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lounge.
	*
	* @return the user ID of this lounge
	*/
	@Override
	public long getUserId() {
		return _lounge.getUserId();
	}

	@Override
	public void persist() {
		_lounge.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lounge.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lounge.
	*
	* @param createDate the create date of this lounge
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_lounge.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_lounge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_lounge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_lounge.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this lounge.
	*
	* @param id the ID of this lounge
	*/
	@Override
	public void setId(long id) {
		_lounge.setId(id);
	}

	/**
	* Sets the modified date of this lounge.
	*
	* @param modifiedDate the modified date of this lounge
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_lounge.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this lounge.
	*
	* @param name the name of this lounge
	*/
	@Override
	public void setName(java.lang.String name) {
		_lounge.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_lounge.setNew(n);
	}

	/**
	* Sets the primary key of this lounge.
	*
	* @param primaryKey the primary key of this lounge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lounge.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_lounge.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priviledge of this lounge.
	*
	* @param priviledge the priviledge of this lounge
	*/
	@Override
	public void setPriviledge(int priviledge) {
		_lounge.setPriviledge(priviledge);
	}

	/**
	* Sets the user ID of this lounge.
	*
	* @param userId the user ID of this lounge
	*/
	@Override
	public void setUserId(long userId) {
		_lounge.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lounge.
	*
	* @param userUuid the user uuid of this lounge
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_lounge.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoungeWrapper)) {
			return false;
		}

		LoungeWrapper loungeWrapper = (LoungeWrapper)obj;

		if (Objects.equals(_lounge, loungeWrapper._lounge)) {
			return true;
		}

		return false;
	}

	@Override
	public Lounge getWrappedModel() {
		return _lounge;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _lounge.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _lounge.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_lounge.resetOriginalValues();
	}

	private final Lounge _lounge;
}