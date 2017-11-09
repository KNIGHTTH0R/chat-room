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

import com.darrylsite.liferay.chat.model.ChatUser;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ChatUser in entity cache.
 *
 * @author Darryl Kpizingui
 * @see ChatUser
 * @generated
 */
@ProviderType
public class ChatUserCacheModel implements CacheModel<ChatUser>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChatUserCacheModel)) {
			return false;
		}

		ChatUserCacheModel chatUserCacheModel = (ChatUserCacheModel)obj;

		if (id == chatUserCacheModel.id) {
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
		sb.append(", pseudo=");
		sb.append(pseudo);
		sb.append(", description=");
		sb.append(description);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", avatar=");
		sb.append(avatar);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatUser toEntityModel() {
		ChatUserImpl chatUserImpl = new ChatUserImpl();

		chatUserImpl.setId(id);

		if (pseudo == null) {
			chatUserImpl.setPseudo(StringPool.BLANK);
		}
		else {
			chatUserImpl.setPseudo(pseudo);
		}

		if (description == null) {
			chatUserImpl.setDescription(StringPool.BLANK);
		}
		else {
			chatUserImpl.setDescription(description);
		}

		chatUserImpl.setUserId(userId);

		if (avatar == null) {
			chatUserImpl.setAvatar(StringPool.BLANK);
		}
		else {
			chatUserImpl.setAvatar(avatar);
		}

		chatUserImpl.resetOriginalValues();

		return chatUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		pseudo = objectInput.readUTF();
		description = objectInput.readUTF();

		userId = objectInput.readLong();
		avatar = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (pseudo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pseudo);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(userId);

		if (avatar == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(avatar);
		}
	}

	public long id;
	public String pseudo;
	public String description;
	public long userId;
	public String avatar;
}