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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ChatUser service. Represents a row in the &quot;chatRoom_ChatUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Darryl Kpizingui
 * @see ChatUserModel
 * @see com.darrylsite.liferay.chat.model.impl.ChatUserImpl
 * @see com.darrylsite.liferay.chat.model.impl.ChatUserModelImpl
 * @generated
 */
@ImplementationClassName("com.darrylsite.liferay.chat.model.impl.ChatUserImpl")
@ProviderType
public interface ChatUser extends ChatUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.darrylsite.liferay.chat.model.impl.ChatUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ChatUser, Long> ID_ACCESSOR = new Accessor<ChatUser, Long>() {
			@Override
			public Long get(ChatUser chatUser) {
				return chatUser.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ChatUser> getTypeClass() {
				return ChatUser.class;
			}
		};
}