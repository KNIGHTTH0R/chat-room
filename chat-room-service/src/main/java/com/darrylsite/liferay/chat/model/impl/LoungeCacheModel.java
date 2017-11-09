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

import com.darrylsite.liferay.chat.model.Lounge;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Lounge in entity cache.
 *
 * @author Darryl Kpizingui
 * @see Lounge
 * @generated
 */
@ProviderType
public class LoungeCacheModel implements CacheModel<Lounge>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoungeCacheModel)) {
			return false;
		}

		LoungeCacheModel loungeCacheModel = (LoungeCacheModel)obj;

		if (id == loungeCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", priviledge=");
		sb.append(priviledge);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lounge toEntityModel() {
		LoungeImpl loungeImpl = new LoungeImpl();

		loungeImpl.setId(id);

		if (name == null) {
			loungeImpl.setName(StringPool.BLANK);
		}
		else {
			loungeImpl.setName(name);
		}

		loungeImpl.setPriviledge(priviledge);
		loungeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			loungeImpl.setCreateDate(null);
		}
		else {
			loungeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loungeImpl.setModifiedDate(null);
		}
		else {
			loungeImpl.setModifiedDate(new Date(modifiedDate));
		}

		loungeImpl.resetOriginalValues();

		return loungeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();

		priviledge = objectInput.readInt();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(priviledge);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public String name;
	public int priviledge;
	public long userId;
	public long createDate;
	public long modifiedDate;
}