package com.darylsite.liferay.chatroom.server;

import java.io.StringWriter;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class Message 
{
	public enum  Command 
	{
		msg, 
		cmd, 
		core, 
		rpc, 
		exception,
		Response;
	}

	private JSONObject body;
	private Command command;

	public Message() 
	{
	}

	public Message(JSONObject body, Command command)
	{
		this.body = body;
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

	public Command getType() 
	{
		return command;
	}

	public void setType(Command command)
	{
		this.command = command;
	}

	public String getName()
	{
		return body.getString("name");
	}

	public JSONArray getArguments()
	{
		return body.getJSONArray("args");
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
