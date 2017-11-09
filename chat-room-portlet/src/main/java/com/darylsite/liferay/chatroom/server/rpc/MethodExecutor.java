package com.darylsite.liferay.chatroom.server.rpc;

import java.util.function.BiConsumer;
import javax.websocket.Session;

import com.darylsite.liferay.chatroom.server.MessageResponse;
import com.liferay.portal.kernel.json.JSONArray;

public interface MethodExecutor 
{
	public static final String ADD_CONTACT = "addContact";
	public static final String GET_CONTACTS = "getContacts";
	public static final String INVITE_CONTACT = "inviteContact";
	public static final String ACCEPT_CONTACT = "acceptContact";
	public static final String REJECT_CONTACT = "rejectContact";
	
	public static final String GET_INVITATIONS = "getInvitations";
	
	public boolean support(Session session, String methodName, JSONArray arguments);
	public MessageResponse execute(Session session, String methodName, JSONArray arguments);
	public boolean hasPrivilege(Session session, String methodName, JSONArray arguments);
	
	public void registerMethodes(BiConsumer<MethodExecutor, String> method);
}
