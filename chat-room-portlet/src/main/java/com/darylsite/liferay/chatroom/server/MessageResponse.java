package com.darylsite.liferay.chatroom.server;

import java.io.StringWriter;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class MessageResponse 
{
	
	public enum Command 
	{
		VOID, EXCEPTION, RESULT;
	}

	private Command command;
	private JSONObject body;

	public MessageResponse() 
	{
	}

	public MessageResponse(Command command, String body)
	{
		this.command = command;
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("result", body);
		this.body = result;
	}

	public Command getCommand()
	{
		return command;
	}

	public void setCommand(Command command) 
	{
		this.command = command;
	}

	public JSONObject getBody()
	{
		return body;
	}

	public void setBody(JSONObject body) 
	{
		this.body = body;
	}
	
	public void fromJson(String data) throws JSONException
	{	
	   JSONObject obj = JSONFactoryUtil.createJSONObject(data);
	   this.body =  obj.getJSONObject("body");
	   this.command =  Command.valueOf(obj.getString("command"));
	}
	
	public String toJson() throws JSONException
	{
	  JSONObject obj = JSONFactoryUtil.createJSONObject();
	  obj.put("body", this.body);
	  obj.put("command", this.command.name());

	  StringWriter writer = new StringWriter();
	  obj.write(writer);
	  return writer.toString();	 
	}
}
