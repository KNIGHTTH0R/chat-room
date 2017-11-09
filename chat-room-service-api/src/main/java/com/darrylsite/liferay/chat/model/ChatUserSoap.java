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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Darryl Kpizingui
 * @generated
 */
@ProviderType
public class ChatUserSoap implements Serializable {
	public static ChatUserSoap toSoapModel(ChatUser model) {
		ChatUserSoap soapModel = new ChatUserSoap();

		soapModel.setId(model.getId());
		soapModel.setPseudo(model.getPseudo());
		soapModel.setDescription(model.getDescription());
		soapModel.setUserId(model.getUserId());
		soapModel.setAvatar(model.getAvatar());

		return soapModel;
	}

	public static ChatUserSoap[] toSoapModels(ChatUser[] models) {
		ChatUserSoap[] soapModels = new ChatUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChatUserSoap[][] toSoapModels(ChatUser[][] models) {
		ChatUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChatUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChatUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChatUserSoap[] toSoapModels(List<ChatUser> models) {
		List<ChatUserSoap> soapModels = new ArrayList<ChatUserSoap>(models.size());

		for (ChatUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChatUserSoap[soapModels.size()]);
	}

	public ChatUserSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getPseudo() {
		return _pseudo;
	}

	public void setPseudo(String pseudo) {
		_pseudo = pseudo;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAvatar() {
		return _avatar;
	}

	public void setAvatar(String avatar) {
		_avatar = avatar;
	}

	private long _id;
	private String _pseudo;
	private String _description;
	private long _userId;
	private String _avatar;
}