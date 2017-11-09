package com.darylsite.liferay.chatroom.server.rpc.impl;

import java.util.function.BiConsumer;

import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;
import com.darrylsite.liferay.chat.model.ChatUser;
import com.darrylsite.liferay.chat.service.ChatUserLocalServiceUtil;
import com.darylsite.liferay.chatroom.server.MessageResponse;
import com.darylsite.liferay.chatroom.server.MessageResponse.Command;
import com.darylsite.liferay.chatroom.server.ServerContext;
import com.darylsite.liferay.chatroom.server.rpc.MethodExecutor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StringPool;

@Component(
	    	immediate = true
		)
public class AccountService implements MethodExecutor
{
	private static AccountService accountService;
	
	public static final String CREATE_ACCOUNT = "createAccount";
	public static final String CONNECT = "connect";
	public static final String DISCONNECT = "disconnect";
	public static final String SET_STATUS = "setStatus";
	public static final String GET_STATUS = "getStatus";

	public static final String[] METHODS = new String[]
			                               {
		                                      CREATE_ACCOUNT, CONNECT, DISCONNECT,
		                                      SET_STATUS, GET_STATUS
		                                   };
	
	@Override
	public void registerMethodes(BiConsumer<MethodExecutor, String> method) 
	{
		for(String methodName : METHODS)
		{
			method.accept(this, methodName);
		}
	}

	public synchronized static AccountService getInstance()
	{
		if(accountService == null)
		{
			accountService = new AccountService();
		}
		
		return accountService;
	}

	public AccountService() {}

	public MessageResponse createAccount(Session session, JSONArray arguments)
	{
		return null;
	}

	public MessageResponse connect(Session session, JSONArray arguments)
	{
		JSONObject userInfo = arguments.getJSONObject(0);
		String userId = userInfo.getString("userId");

		try
		{
			User user = UserLocalServiceUtil.getUser(Long.valueOf(userId));
			ChatUser  chatUser = ChatUserLocalServiceUtil.createChatUser(user.getUserId());

			if(ServerContext.getChatusers().contains(chatUser))
			{
				chatUser = ServerContext.getChatusers().get(ServerContext.getChatusers().indexOf(chatUser));
			}
			else
			{
				Image image = ImageLocalServiceUtil.fetchImage(user.getPortraitId());
				
				chatUser.setPseudo(user.getScreenName());
				chatUser.setDescription(user.getComments());
				chatUser.setUserId(user.getUserId());
				chatUser.setAvatar(Base64.encode(image.getTextObj()));

				ServerContext.getChatusers().add(chatUser);
			}

			session.getUserProperties().put("userId", userId);

			MessageResponse response = new MessageResponse();
			response.setCommand(Command.RESULT);

			JSONObject result = JSONFactoryUtil.createJSONObject();
			result.put("method", "handleConnect");

			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("name", chatUser.getPseudo());
			obj.put("id", chatUser.getId());
			obj.put("priviledge", 0);
			obj.put("avatar", chatUser.getAvatar());

			result.put("chatUser", obj);

			response.setBody(result);

			return response;
		} 
		catch (NumberFormatException | PortalException | SystemException e) 
		{
			return new MessageResponse(Command.EXCEPTION, e.getMessage());
		}
	}

	public MessageResponse disconnect(Session session, JSONArray arguments)
	{
        String userId = (String) session.getUserProperties().get("userId");

        if(userId != null)
        {
		   ChatUser chatUser = ChatUserLocalServiceUtil.createChatUser(Long.valueOf(userId));		  
		   ServerContext.getChatusers().remove(chatUser);
        }

		return new MessageResponse(Command.VOID, StringPool.BLANK);
	}

	public MessageResponse setStatus(Session session, JSONArray arguments)
	{
		return new MessageResponse(Command.EXCEPTION, "Not implemented");
	}

	public MessageResponse getStatus(Session session, JSONArray arguments)
	{
		return new MessageResponse(Command.EXCEPTION, "Not implemented");
	}

	@Override
	public boolean support(Session session, String method,	JSONArray arguments) 
	{
		return ArrayUtil.contains(METHODS, method);
	}

	@Override
	public MessageResponse execute(Session session, String methodName,	JSONArray arguments) 
	{
		switch (methodName) 
		{
		   case CREATE_ACCOUNT: return createAccount(session, arguments);
		   case CONNECT: return connect(session, arguments);
		   case DISCONNECT: return disconnect(session, arguments);
		   case SET_STATUS: return setStatus(session, arguments);
		   case GET_STATUS: return getStatus(session, arguments);
		}

		return new MessageResponse(Command.EXCEPTION, "execute:: Method not implemented");
	}

	@Override
	public boolean hasPrivilege(Session session, String methodName,	JSONArray arguments)
	{
		return true;
	}
}