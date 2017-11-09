package com.darylsite.liferay.chatroom.server.rpc.impl;

import java.util.Calendar;
import java.util.Iterator;
import java.util.function.BiConsumer;

import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;
import com.darrylsite.liferay.chat.model.ChatUser;
import com.darrylsite.liferay.chat.service.ChatUserLocalServiceUtil;
import com.darylsite.liferay.chatroom.server.ChatEndPoint;
import com.darylsite.liferay.chatroom.server.MessageResponse;
import com.darylsite.liferay.chatroom.server.MessageResponse.Command;
import com.darylsite.liferay.chatroom.server.ServerContext;
import com.darylsite.liferay.chatroom.server.rpc.MethodExecutor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;

@Component
public class MessageService   implements MethodExecutor
{
	private static MessageService messageService;
	
	public static final String SEND_MESSAGE_TO_LOUNGE = "sendMessageToLounge";
	public static final String RETRIEVE_MESSAGES = "retrieveMessages";
	public static final String SEND_PRIVATE_MESSAGE = "sendPrivateMessage";
	public static final String RETRIEVE_PRIVATE_MESSAGE = "retrievePrivateMessages";
	
	public static final String[] METHODS = new String[]
            {
		      SEND_MESSAGE_TO_LOUNGE, RETRIEVE_MESSAGES, 
		      SEND_PRIVATE_MESSAGE, RETRIEVE_PRIVATE_MESSAGE
            };
	
	
	
	@Override
	public void registerMethodes(BiConsumer<MethodExecutor, String> method) 
	{
		for(String methodName : METHODS)
		{
			method.accept(this, methodName);
		}
	}
	
	public synchronized static MessageService getInstance()
	{
		if(messageService == null)
		{
			messageService = new MessageService();
		}
		
		return messageService;
	}
	
	private MessageService() 
	{
	}
	
	@Override
	public boolean support(Session session, String methodName, JSONArray arguments) 
	{
		return ArrayUtil.contains(METHODS, methodName);
	}

	@Override
	public MessageResponse execute(Session session, String methodName, JSONArray arguments)
	{	
		try
		{
		 switch (methodName) 
		 {
		   case SEND_MESSAGE_TO_LOUNGE: return sendMessageToLounge(session, arguments);
		   case RETRIEVE_MESSAGES: return retrieveMessages(session, arguments);
		   case SEND_PRIVATE_MESSAGE: return sendPrivateMessage(session, arguments);
		   case RETRIEVE_PRIVATE_MESSAGE: return retrievePrivateMessages(session, arguments);
		 }
		}
		catch(JSONException e)
		{
			
		}
		
		return new MessageResponse(Command.EXCEPTION, "execute:: Method not implemented");
	}

	private MessageResponse retrievePrivateMessages(Session session, JSONArray arguments)
	{
		return null;
	}

	private MessageResponse sendPrivateMessage(Session session, JSONArray arguments) 
	{
		return null;
	}

	private MessageResponse retrieveMessages(Session session, JSONArray arguments) 
	{
		return null;
	}

	private MessageResponse sendMessageToLounge(Session session, JSONArray arguments) throws JSONException
	{
		String userId = (String) session.getUserProperties().get("userId");
		ChatUser chatUser = ChatUserLocalServiceUtil.createChatUser(Long.valueOf(userId));
		chatUser = ServerContext.getChatusers().get(ServerContext.getChatusers().indexOf(chatUser));
		
		String message = arguments.getJSONObject(0).getString("msg");
		long requestLoungeId = arguments.getJSONObject(0).getLong("loungeId");
		
		long loungeId = Long.valueOf((Long)session.getUserProperties().get("loungeId"));
		
		if(requestLoungeId != loungeId)
		{
			return new MessageResponse(Command.EXCEPTION, "Trying to send a message to a room you do not belong to");
		}
		
		JSONObject jsonChatUser = JSONFactoryUtil.createJSONObject();
		jsonChatUser.put("name", chatUser.getPseudo());
		jsonChatUser.put("id", chatUser.getId());
		jsonChatUser.put("avatar", chatUser.getAvatar());
		
		MessageResponse response = new MessageResponse();
		response.setCommand(Command.RESULT);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("method", "handleSendMessageToLounge");
		result.put("loungeId", loungeId);
        result.put("msg", message);
        result.put("time", DateFormatFactoryUtil.getSimpleDateFormat("hh:mm").format(Calendar.getInstance().getTime()));
        result.put("chatUser", jsonChatUser);
		response.setBody(result);
		
		Iterator<Session> iterator = ChatEndPoint.connections.iterator();
		
		while(iterator.hasNext())
		{
			Session clientSession = iterator.next();
			if(clientSession.getUserProperties().containsKey("loungeId"))
			{
				Long savedLoungeId = (Long) clientSession.getUserProperties().get("loungeId");
				if( loungeId == savedLoungeId )
				{
					clientSession.getAsyncRemote().sendText(response.toJson());
				}
			}
		}
		
		response.setCommand(Command.VOID);
		return response;
	}

	@Override
	public boolean hasPrivilege(Session session, String methodName,	JSONArray arguments) 
	{
		return true;
	}

}