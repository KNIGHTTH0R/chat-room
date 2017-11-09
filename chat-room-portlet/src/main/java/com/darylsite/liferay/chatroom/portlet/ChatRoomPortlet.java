package com.darylsite.liferay.chatroom.portlet;

import com.darylsite.liferay.chatroom.constants.ChatRoomPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Darryl Kpizingui
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=chat-room-portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/views/view.jsp",
		"javax.portlet.name=" + ChatRoomPortletKeys.ChatRoom,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		
		"com.liferay.portlet.footer-portlet-javascript=/js/handlebars-v1.3.0.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.css-class-wrapper=chat-room-portlet"
	},
	service = Portlet.class
)
public class ChatRoomPortlet extends MVCPortlet 
{
}
