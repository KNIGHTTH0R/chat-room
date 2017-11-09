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
 * This class is a wrapper for {@link ChatUser}.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ChatUser
 * @generated
 */
@ProviderType
public class ChatUserWrapper implements ChatUser, ModelWrapper<ChatUser> {
	public ChatUserWrapper(ChatUser chatUser) {
		_chatUser = chatUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ChatUser.class;
	}

	@Override
	public String getModelClassName() {
		return ChatUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("pseudo", getPseudo());
		attributes.put("description", getDescription());
		attributes.put("userId", getUserId());
		attributes.put("avatar", getAvatar());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String pseudo = (String)attributes.get("pseudo");

		if (pseudo != null) {
			setPseudo(pseudo);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String avatar = (String)attributes.get("avatar");

		if (avatar != null) {
			setAvatar(avatar);
		}
	}

	@Override
	public ChatUser toEscapedModel() {
		return new ChatUserWrapper(_chatUser.toEscapedModel());
	}

	@Override
	public ChatUser toUnescapedModel() {
		return new ChatUserWrapper(_chatUser.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _chatUser.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _chatUser.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _chatUser.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _chatUser.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ChatUser> toCacheModel() {
		return _chatUser.toCacheModel();
	}

	@Override
	public int compareTo(ChatUser chatUser) {
		return _chatUser.compareTo(chatUser);
	}

	@Override
	public int hashCode() {
		return _chatUser.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _chatUser.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ChatUserWrapper((ChatUser)_chatUser.clone());
	}

	/**
	* Returns the avatar of this chat user.
	*
	* @return the avatar of this chat user
	*/
	@Override
	public java.lang.String getAvatar() {
		return _chatUser.getAvatar();
	}

	/**
	* Returns the description of this chat user.
	*
	* @return the description of this chat user
	*/
	@Override
	public java.lang.String getDescription() {
		return _chatUser.getDescription();
	}

	/**
	* Returns the pseudo of this chat user.
	*
	* @return the pseudo of this chat user
	*/
	@Override
	public java.lang.String getPseudo() {
		return _chatUser.getPseudo();
	}

	/**
	* Returns the user uuid of this chat user.
	*
	* @return the user uuid of this chat user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _chatUser.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _chatUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _chatUser.toXmlString();
	}

	/**
	* Returns the ID of this chat user.
	*
	* @return the ID of this chat user
	*/
	@Override
	public long getId() {
		return _chatUser.getId();
	}

	/**
	* Returns the primary key of this chat user.
	*
	* @return the primary key of this chat user
	*/
	@Override
	public long getPrimaryKey() {
		return _chatUser.getPrimaryKey();
	}

	/**
	* Returns the user ID of this chat user.
	*
	* @return the user ID of this chat user
	*/
	@Override
	public long getUserId() {
		return _chatUser.getUserId();
	}

	@Override
	public void persist() {
		_chatUser.persist();
	}

	/**
	* Sets the avatar of this chat user.
	*
	* @param avatar the avatar of this chat user
	*/
	@Override
	public void setAvatar(java.lang.String avatar) {
		_chatUser.setAvatar(avatar);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_chatUser.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this chat user.
	*
	* @param description the description of this chat user
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_chatUser.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_chatUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_chatUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_chatUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this chat user.
	*
	* @param id the ID of this chat user
	*/
	@Override
	public void setId(long id) {
		_chatUser.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_chatUser.setNew(n);
	}

	/**
	* Sets the primary key of this chat user.
	*
	* @param primaryKey the primary key of this chat user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_chatUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_chatUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the pseudo of this chat user.
	*
	* @param pseudo the pseudo of this chat user
	*/
	@Override
	public void setPseudo(java.lang.String pseudo) {
		_chatUser.setPseudo(pseudo);
	}

	/**
	* Sets the user ID of this chat user.
	*
	* @param userId the user ID of this chat user
	*/
	@Override
	public void setUserId(long userId) {
		_chatUser.setUserId(userId);
	}

	/**
	* Sets the user uuid of this chat user.
	*
	* @param userUuid the user uuid of this chat user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_chatUser.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChatUserWrapper)) {
			return false;
		}

		ChatUserWrapper chatUserWrapper = (ChatUserWrapper)obj;

		if (Objects.equals(_chatUser, chatUserWrapper._chatUser)) {
			return true;
		}

		return false;
	}

	@Override
	public ChatUser getWrappedModel() {
		return _chatUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _chatUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _chatUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_chatUser.resetOriginalValues();
	}

	private final ChatUser _chatUser;
}