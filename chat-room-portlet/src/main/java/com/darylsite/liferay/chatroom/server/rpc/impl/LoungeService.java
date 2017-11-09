package com.darylsite.liferay.chatroom.server.rpc.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.function.BiConsumer;

import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;
import com.darrylsite.liferay.chat.model.ChatUser;
import com.darrylsite.liferay.chat.model.Lounge;
import com.darrylsite.liferay.chat.service.ChatUserLocalServiceUtil;
import com.darrylsite.liferay.chat.service.LoungeLocalServiceUtil;
import com.darylsite.liferay.chatroom.server.MessageResponse;
import com.darylsite.liferay.chatroom.server.MessageResponse.Command;
import com.darylsite.liferay.chatroom.server.ServerContext;
import com.darylsite.liferay.chatroom.server.rpc.MethodExecutor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;

@Component
public class LoungeService  implements MethodExecutor
{
	private static LoungeService loungeService;
	
	public static final String GET_LOUNGE_LIST = "getLoungeList";
	public static final String LEAVE_LOUNGE = "leaveLounge";
	public static final String JOIN_LOUNGE = "joinLounge";
	public static final String GET_LOUNGE_CONTACTS = "getLoungeContacts";

	public static final String[] METHODS = new String[]
            {
		      GET_LOUNGE_LIST, LEAVE_LOUNGE, JOIN_LOUNGE, GET_LOUNGE_CONTACTS
            };
	
	@Override
	public void registerMethodes(BiConsumer<MethodExecutor, String> method) 
	{
		for(String methodName : METHODS)
		{
			method.accept(this, methodName);
		}
	}
	
	
	public synchronized static LoungeService getInstance()
	{
		if(loungeService == null)
		{
			loungeService = new LoungeService();
		}
		
		return loungeService;
	}

	private LoungeService() {}

	@Override
	public boolean support(Session session, String methodName,	JSONArray arguments) 
	{
		return ArrayUtil.contains(METHODS, methodName);
	}

	@Override
	public MessageResponse execute(Session session, String methodName,		JSONArray arguments) 
	{
		switch (methodName) 
		{
		   case GET_LOUNGE_LIST: return getLoungeList(session, arguments);
		   case JOIN_LOUNGE: return joinLounge(session, arguments);
		   case LEAVE_LOUNGE: return leaveLounge(session, arguments);
		   case GET_LOUNGE_CONTACTS: return getLoungeContacts(session, arguments);
		}
		
		return new MessageResponse(Command.EXCEPTION, "execute:: Method not implemented");
	}

	private MessageResponse getLoungeList(Session session, JSONArray arguments) 
	{
		List<Lounge> lougnes = ServerContext.getLounges();
		
		MessageResponse response = new MessageResponse();
		response.setCommand(Command.RESULT);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("method", "handleGetLoungeList");
		
		JSONArray jsonLounges = JSONFactoryUtil.createJSONArray();
		
		for(Lounge lounge: lougnes)
		{
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("name", lounge.getName());
			obj.put("id", lounge.getId());
			obj.put("priviledge", lounge.getPriviledge());
			
			jsonLounges.put(obj);
		}
				
		result.put("lounges", jsonLounges);
		
		response.setBody(result);
		
		return response;
	}

	private MessageResponse joinLounge(Session session, JSONArray arguments) 
	{
		String userId = (String) session.getUserProperties().get("userId");
		long loungeId = Long.valueOf(arguments.getJSONObject(0).getLong("id"));
		
		ChatUser chatUser = ChatUserLocalServiceUtil.createChatUser(Long.valueOf(userId));
		chatUser = ServerContext.getChatusers().get(ServerContext.getChatusers().indexOf(chatUser));
		
		Lounge selectedLounge = LoungeLocalServiceUtil.createLounge(loungeId);
		selectedLounge = ServerContext.getLounges().get(ServerContext.getLounges().indexOf(selectedLounge));
		
		Enumeration<List<ChatUser>> loungeContainers = ServerContext.getLoungeusers().elements();
		
		while(loungeContainers.hasMoreElements())
		{
			loungeContainers.nextElement().remove(chatUser);
		}
		
		if(! ServerContext.getLoungeusers().containsKey(loungeId))
		{
			ServerContext.getLoungeusers().put(loungeId, new ArrayList<ChatUser>());
		}
		
		List<ChatUser> selectedLoungeContainer = ServerContext.getLoungeusers().get(loungeId);
		selectedLoungeContainer.add(chatUser);
		
		session.getUserProperties().put("loungeId", loungeId);
		
		MessageResponse response = new MessageResponse();
		response.setCommand(Command.RESULT);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("method", "handleJoinLounge");
		result.put("loungeId", loungeId);
		result.put("loungeName", selectedLounge.getName());		
		response.setBody(result);
		
		return response;
	}
	
	public MessageResponse leaveLounge(Session session, JSONArray arguments)
	{
        String userId = (String) session.getUserProperties().get("userId");
        
        if(userId != null)
        {
        		
		  ChatUser chatUser = ChatUserLocalServiceUtil.createChatUser(Long.valueOf(userId));
		  chatUser = ServerContext.getChatusers().get(ServerContext.getChatusers().indexOf(chatUser));
		
		  Enumeration<List<ChatUser>> loungeContainers = ServerContext.getLoungeusers().elements();
		
		  while(loungeContainers.hasMoreElements())
		  {
			loungeContainers.nextElement().remove(chatUser);
		  }
		  
        }
        
		MessageResponse response = new MessageResponse();
		response.setCommand(Command.RESULT);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("method", "handleLeaveLounge");
		response.setBody(result);
		
		return response;
	}

	
	private MessageResponse getLoungeContacts(Session session, JSONArray arguments)
	{
		long loungeId = Long.valueOf(arguments.getJSONObject(0).getLong("id"));
		
		List<ChatUser> selectedLoungeContainer = ServerContext.getLoungeusers().get(loungeId);
		
        JSONArray chatUsers = JSONFactoryUtil.createJSONArray();
		
		for(ChatUser chatUser: selectedLoungeContainer)
		{
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("name", chatUser.getPseudo());
			obj.put("description", chatUser.getDescription());
			obj.put("id", chatUser.getId());
			obj.put("avatar", chatUser.getAvatar());
			
			chatUsers.put(obj);
		}

		MessageResponse response = new MessageResponse();
		response.setCommand(Command.RESULT);

		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("method", "handleGetLoungeContacts");
		result.put("loungeId", loungeId);
        result.put("chatUsers", chatUsers);
		response.setBody(result);

		return response;
	}

	@Override
	public boolean hasPrivilege(Session session, String methodName,	JSONArray arguments) 
	{
		return true;
	}

}
