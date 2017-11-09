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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Darryl Kpizingui
 * @see Contact
 * @generated
 */
@ProviderType
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactCacheModel)) {
			return false;
		}

		ContactCacheModel contactCacheModel = (ContactCacheModel)obj;

		if (id == contactCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", category=");
		sb.append(category);
		sb.append(", priviledge=");
		sb.append(priviledge);
		sb.append(", status=");
		sb.append(status);
		sb.append(", chatUserId=");
		sb.append(chatUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contact toEntityModel() {
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setId(id);

		if (category == null) {
			contactImpl.setCategory(StringPool.BLANK);
		}
		else {
			contactImpl.setCategory(category);
		}

		contactImpl.setPriviledge(priviledge);
		contactImpl.setStatus(status);
		contactImpl.setChatUserId(chatUserId);

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		category = objectInput.readUTF();

		priviledge = objectInput.readInt();

		status = objectInput.readInt();

		chatUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeInt(priviledge);

		objectOutput.writeInt(status);

		objectOutput.writeLong(chatUserId);
	}

	public long id;
	public String category;
	public int priviledge;
	public int status;
	public long chatUserId;
}