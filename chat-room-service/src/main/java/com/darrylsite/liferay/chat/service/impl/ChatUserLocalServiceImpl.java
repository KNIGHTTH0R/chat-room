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

package com.darrylsite.liferay.chat.service.impl;

import com.darrylsite.liferay.chat.model.ChatUser;
import com.darrylsite.liferay.chat.service.base.ChatUserLocalServiceBaseImpl;

/**
 * The implementation of the chat user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.darrylsite.liferay.chat.service.ChatUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see ChatUserLocalServiceBaseImpl
 * @see com.darrylsite.liferay.chat.service.ChatUserLocalServiceUtil
 */
public class ChatUserLocalServiceImpl extends ChatUserLocalServiceBaseImpl 
{
	public ChatUser create() 
	{
		return super.createChatUser(counterLocalService.increment());
	}
}