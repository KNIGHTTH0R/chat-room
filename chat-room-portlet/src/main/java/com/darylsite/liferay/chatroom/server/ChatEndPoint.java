package com.darylsite.liferay.chatroom.server;

import java.net.SocketException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;
import com.darylsite.liferay.chatroom.server.Message.Command;
import com.darylsite.liferay.chatroom.server.rpc.MethodLocator;
import com.darylsite.liferay.chatroom.server.rpc.impl.AccountService;
import com.darylsite.liferay.chatroom.server.rpc.impl.LoungeService;
import com.liferay.portal.kernel.log.LogFactoryUtil;


@Component(
	    immediate = true,
	    property = {"org.osgi.http.websocket.endpoint.path=/o/chat-room"},
	    service = Endpoint.class
	)
public class ChatEndPoint extends Endpoint 
{	 
	public static final Set<Session> connections =   new CopyOnWriteArraySet<Session>();
	
    public ChatEndPoint(){}
    
    @Override
	public void onOpen(Session session, EndpointConfig arg1)
	{
        connections.add(session);
                
        session.addMessageHandler(new MessageHandler.Whole<String>() 
        {
            public void onMessage(String text) 
            {
                try
                {
                	handleMessage(session, text);
                } 
                catch (Exception ioe) 
                {
                	LogFactoryUtil.getLog(getClass()).error(ioe);
                }
            }
        });
	}
    
    public void onClose(Session session, CloseReason reason) 
    {
    	AccountService.getInstance().disconnect(session, null);
    	LoungeService.getInstance().leaveLounge(session, null);
        connections.remove(session);
        
    }

    public void onError(Session session, Throwable throwable) 
    {
    	if(throwable instanceof SocketException)
    	{
    		this.onError(session, null);
    		return;
    	}
    }

    public void handleMessage(Session session, String msg) throws Exception
    { 	
    	Message message = new Message();
    	message.fromJson(msg);
    	        
        if(message.getType() == Command.rpc)
        {
        	MessageResponse response = MethodLocator.execute(session, message.getName(), message.getArguments());
        	if(response != null)
        	{
        		if(session.isOpen())
        		{
        			try
        			{
        				session.getAsyncRemote().sendText(response.toJson());
        			}
        			catch (IllegalStateException e) {}
        			
        		}
        	}
        }
    }
}