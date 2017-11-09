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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Darryl Kpizingui
 * @generated
 */
@ProviderType
public class LoungeSoap implements Serializable {
	public static LoungeSoap toSoapModel(Lounge model) {
		LoungeSoap soapModel = new LoungeSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setPriviledge(model.getPriviledge());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LoungeSoap[] toSoapModels(Lounge[] models) {
		LoungeSoap[] soapModels = new LoungeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoungeSoap[][] toSoapModels(Lounge[][] models) {
		LoungeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoungeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoungeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoungeSoap[] toSoapModels(List<Lounge> models) {
		List<LoungeSoap> soapModels = new ArrayList<LoungeSoap>(models.size());

		for (Lounge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoungeSoap[soapModels.size()]);
	}

	public LoungeSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getPriviledge() {
		return _priviledge;
	}

	public void setPriviledge(int priviledge) {
		_priviledge = priviledge;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _id;
	private String _name;
	private int _priviledge;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}