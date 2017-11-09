package com.darylsite.liferay.chatroom.server.rpc;

import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;

import com.darylsite.liferay.chatroom.server.MessageResponse;
import com.darylsite.liferay.chatroom.server.MessageResponse.Command;
import com.darylsite.liferay.chatroom.server.rpc.impl.AccountService;
import com.darylsite.liferay.chatroom.server.rpc.impl.LoungeService;
import com.darylsite.liferay.chatroom.server.rpc.impl.MessageService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Component
public class MethodLocator 
{
	private static final ConcurrentHashMap<String, MethodExecutor> methodExecutors;
	
	static
	{
	   synchronized (MethodLocator.class) 
	   {
		   methodExecutors = new ConcurrentHashMap<String, MethodExecutor>();
	   }
	   
	   AccountService.getInstance().registerMethodes((executor, methodName)->{addMethodExecutor(executor, methodName);});
	   LoungeService.getInstance().registerMethodes((executor, methodName)->{addMethodExecutor(executor, methodName);});
	   MessageService.getInstance().registerMethodes((executor, methodName)->{addMethodExecutor(executor, methodName);});
	}
	
	public static MethodExecutor getMethodExecutor(String name)
	{
		return methodExecutors.get(name);
	}
	
	public static MethodExecutor addMethodExecutor(MethodExecutor executor, String name)
	{
		return methodExecutors.put(name, executor);
	}
	
	public static MethodExecutor removeMethodExecutor(String name)
	{
		return methodExecutors.get(name);
	}
	
	public static MessageResponse execute(Session session, String methodName, JSONArray arguments)
	{
		MethodExecutor methodExecutor = getMethodExecutor(methodName);
		
		if(methodExecutor == null)
		{
			LogFactoryUtil.getLog(MethodLocator.class).error("Cannot find methodExecutor for : " + methodName);
			return null;
		}
		
		if(methodExecutor.hasPrivilege(session, methodName, arguments))
		{
		   return methodExecutor.execute(session, methodName, arguments);
		}
		
		return new MessageResponse(Command.EXCEPTION, "Privilege");
	}
	   
}
