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
import com.darrylsite.liferay.chat.service.ChatUserLocalServiceUtil;

/**
 * The extended model base implementation for the ChatUser service. Represents a row in the &quot;chatRoom_ChatUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChatUserImpl}.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ChatUserImpl
 * @see ChatUser
 * @generated
 */
@ProviderType
public abstract class ChatUserBaseImpl extends ChatUserModelImpl
	implements ChatUser {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chat user model instance should use the {@link ChatUser} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ChatUserLocalServiceUtil.addChatUser(this);
		}
		else {
			ChatUserLocalServiceUtil.updateChatUser(this);
		}
	}
}