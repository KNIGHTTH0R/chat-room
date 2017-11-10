package com.darylsite.liferay.chatroom.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.darrylsite.liferay.chat.model.ChatUser;
import com.darrylsite.liferay.chat.model.Lounge;
import com.darrylsite.liferay.chat.service.LoungeLocalServiceUtil;

public class ServerContext 
{
   private static final String[] DEFAULT_ROOM_NAMES = new String[]{"Public", "Technical"};
   private static final int DEFAULT_ROOM_PRILILEDGE = 0;
   
   private static final List<ChatUser> chatUsers;
   private static final List<Lounge> lounges;
   private static final ConcurrentHashMap<Long, List<ChatUser>> loungeUsers;

   static
   {
	   synchronized (ServerContext.class) 
	   {
		   chatUsers = new ArrayList<ChatUser>();
		   lounges = new ArrayList<Lounge>();
		   loungeUsers = new ConcurrentHashMap<Long, List<ChatUser>>();

		   for(String defaultRoomName: DEFAULT_ROOM_NAMES)
		   {
			   Lounge defaultLounge = LoungeLocalServiceUtil.createLounge(0); 
			   defaultLounge.setPriviledge(DEFAULT_ROOM_PRILILEDGE);
			   defaultLounge.setName(defaultRoomName);

			   lounges.add(defaultLounge);
		   }
	   }
   }
   
   private ServerContext() 
   {
   }
   
   public static List<ChatUser> getChatusers()
   {
	  return chatUsers;
   }
   
   public static List<Lounge> getLounges() 
   {
	 return lounges;
   }
   
   public static ConcurrentHashMap<Long, List<ChatUser>> getLoungeusers()
   {
	  return loungeUsers;
   }
}
