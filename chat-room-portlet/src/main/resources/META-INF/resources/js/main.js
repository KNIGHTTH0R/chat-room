AUI().use(
	'aui-base',
	function(A) 
	{
		Liferay.namespace('Liferay.ChatRoom');
		
		Liferay.ChatRoom = 
		{
				COMMAND_MSG: "msg", 
				COMMAND_CMD: "cmd", 
				COMMAND_CORE: "core", 
				COMMAND_RPC: "rpc", 
				COMMAND_EXCEPTION: "exception",
				COMMAND_RESPONSE: "Response",
				COMMAND_RESULT : "RESULT",
				__connected: false,
				loungeId: -1,
				
				__containerClass: '.chat-room-portlet',
				
				__init : function()
				{
					Liferay.ChatRoom.ws = new WebSocket(Liferay.ChatRoom.__getServicePath() + "/o/chat-room");
					Liferay.ChatRoom.ws.onmessage = Liferay.ChatRoom.__onMessage;
					Liferay.ChatRoom.ws.onopen = Liferay.ChatRoom.doConnect;
					Liferay.ChatRoom.__bind();
				},
				
				__getServicePath: function()
				{
					var loc = window.location, new_uri;
					if (loc.protocol === "https:") 
					{
					    new_uri = "wss:";
					}
					else 
					{
					    new_uri = "ws:";
					}
					
					new_uri += "//" + loc.host;					
					return new_uri;
				},
				
				triggerConnected: function()
				{
					Liferay.ChatRoom.getLoungeList();
					Liferay.ChatRoom.IntervalLoungeListHandler = setInterval(Liferay.ChatRoom.getLoungeList, 60000);
				},
								
				doConnect: function(evt)
				{
					var userId = Liferay.ThemeDisplay.getUserId();
					
					var message = {
							        "command": Liferay.ChatRoom.COMMAND_RPC, 
							        "body": {
							        	      "name": "connect",
							        	      "args": [{"userId": userId}]
							                }
							      };
					
					Liferay.ChatRoom.ws.send(JSON.stringify(message));
				},
				
				handleConnect: function(body)
				{
						Liferay.ChatRoom.chatUser = body.chatUser;
						Liferay.ChatRoom.__connected = true;
						Liferay.ChatRoom.triggerConnected();
				},
				
				doLeaveLounge: function()
				{
					var message = {
					        "command": Liferay.ChatRoom.COMMAND_RPC, 
					        "body": {
					        	      "name": "leaveLounge",
					        	      "args": []
					                }
					      };
			
			       Liferay.ChatRoom.ws.send(JSON.stringify(message));
				},
				
				handleLeaveLounge: function(body)
				{
					clearInterval(Liferay.ChatRoom.IntervalLoungeContactHandler);
					Liferay.ChatRoom.IntervalLoungeContactHandler = null;
					Liferay.ChatRoom.loungeId = -1;
					
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-room').removeClass('hide');
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-box').addClass('hide');
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-messages').setContent('');
					
					Liferay.ChatRoom.triggerConnected();
				},
				
				getLoungeList: function()
				{
					if(Liferay.ChatRoom.loungeId >= 0)
						return;
					
					var message = 
					{
					        "command": Liferay.ChatRoom.COMMAND_RPC, 
					        "body": {
					        	      "name": "getLoungeList",
					        	      "args": []
					                }
					};
			
			        Liferay.ChatRoom.ws.send(JSON.stringify(message));
				},
				
				handleGetLoungeList: function(body)
				{
					if(Liferay.ChatRoom.loungeId >= 0)
						return;
					
					var source   = A.one(Liferay.ChatRoom.__containerClass +" #chat-room-template").html();
					var template = Handlebars.compile(source);
					var html = template({'lounges': body.lounges});
					
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-room').setContent(html);
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-room').removeClass('hide');
					
				},
				
				joinLounge: function(node)
				{					
					var id = node.getAttribute('data-id');
					
					var message = {
					        "command": Liferay.ChatRoom.COMMAND_RPC, 
					        "body": {
					        	      "name": "joinLounge",
					        	      "args": [{'id': id}]
					                }
					      };
			
			        Liferay.ChatRoom.ws.send(JSON.stringify(message));
				},
				
				handleJoinLounge: function(body)
				{
					Liferay.ChatRoom.loungeId = body.loungeId;
					clearInterval(Liferay.ChatRoom.IntervalLoungeListHandler);
					
					
					A.one(Liferay.ChatRoom.__containerClass + ' .container #room-title').setContent(body.loungeName);
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-room').addClass('hide');
					A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-box').removeClass('hide');
					
					
					Liferay.ChatRoom.loungeId = body.loungeId;
					Liferay.ChatRoom.IntervalLoungeContactHandler  = setInterval(Liferay.ChatRoom.getLoungeContacts, 5000);
					Liferay.ChatRoom.getLoungeContacts();
				},
				
				getLoungeContacts: function()
				{					
					var message = 
					{
					        "command": Liferay.ChatRoom.COMMAND_RPC, 
					        "body": {
					        	      "name": "getLoungeContacts",
					        	      "args": [{'id': Liferay.ChatRoom.loungeId}]
					                }
					      };
			
			        Liferay.ChatRoom.ws.send(JSON.stringify(message));
				},
				 
				handleGetLoungeContacts: function(body)
				{
					var source   = A.one(Liferay.ChatRoom.__containerClass +" #chat-users-template").html();
					var template = Handlebars.compile(source);
					var html = template(body);
					
					var userListContainer = A.one(Liferay.ChatRoom.__containerClass + ' .container #chat-user-list');
					
					if(userListContainer)
						userListContainer.setContent(html);
				},
				
				sendMessageToLounge: function()
				{
					var msg = A.one(Liferay.ChatRoom.__containerClass + ' #chat-msg').get('value');
					
					if(!msg) return;
					
					A.one(Liferay.ChatRoom.__containerClass + ' #chat-msg').set('value', '');
					 
					var message = {
					        "command": Liferay.ChatRoom.COMMAND_RPC, 
					        "body": {
					        	      "name": "sendMessageToLounge",
					        	      "args": [{'loungeId': Liferay.ChatRoom.loungeId,
					        	    	        'msg': msg
					        	    	       }]
					                }
					      };
			
			        Liferay.ChatRoom.ws.send(JSON.stringify(message));
				},
				
				handleSendMessageToLounge: function(body)
				{
					var source   = A.one(Liferay.ChatRoom.__containerClass +" #chat-messages-template").html();
					
					if(!body.avatar || body.avatar.length < 100)
					{
						body.avatar = Liferay.ChatRoom.defaultAvatar;
					}
					
					var template = Handlebars.compile(source);
					var html = template(body);
					
					A.one(Liferay.ChatRoom.__containerClass +" #chat-messages").append(html);
					
					A.one(Liferay.ChatRoom.__containerClass +" #chat-messages")
				},
				
				__bind: function()
				{
					A.one(Liferay.ChatRoom.__containerClass).delegate('click', function(ev)
							{
						       ev.preventDefault();
						       var node =  ev.currentTarget;
						       var trigger = node.getData('bind-click');
						       
						       Liferay.ChatRoom[trigger](node);
							}, '[data-bind-click]');
					
					A.one(Liferay.ChatRoom.__containerClass).delegate('keypress', function(ev)
							{
						       if (ev.keyCode != 13)
						    	   return;
						
						       ev.preventDefault();
						       var node =  ev.currentTarget;
						       var trigger = node.getAttribute('data-bind-keypress');
						       
						       Liferay.ChatRoom[trigger](node);
							}, '[data-bind-keypress]');
					
					
					Handlebars.registerHelper('currentTime', Liferay.ChatRoom.__getTime);	
				},
				
				__onMessage: function(evt)
				{
					var msg = JSON.parse(evt.data);
					
					if(msg.command == Liferay.ChatRoom.COMMAND_RESULT)
					{
						var method = msg.body.method;
						Liferay.ChatRoom[method](msg.body);
					}
				},
				
				__getTime: function()
				{
				    var now     = new Date(); 
		
				    var hour    = now.getHours();
				    var minute  = now.getMinutes();
				    var second  = now.getSeconds(); 
				    
				    if(hour.toString().length == 1) {
				        var hour = '0'+hour;
				    }
				    if(minute.toString().length == 1) {
				        var minute = '0'+minute;
				    }
				    if(second.toString().length == 1) {
				        var second = '0'+second;
				    }   
				    var dateTime = hour +':' + minute + ':'+second;   
				    
				    return dateTime;
				},
				
				defaultAvatar: "PD94bWwgdmVyc2lvbj0iMS4wIiA/PjwhRE9DVFlQRSBzdmcgIFBVQkxJQyAnLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4nICAnaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkJz48c3ZnIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgLTI3IDI0IDEwMCAxMDAiIGhlaWdodD0iMTAwcHgiIGlkPSJ1bmtub3duIiB2ZXJzaW9uPSIxLjEiIHZpZXdCb3g9Ii0yNyAyNCAxMDAgMTAwIiB3aWR0aD0iMTAwcHgiIHhtbDpzcGFjZT0icHJlc2VydmUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6c2tldGNoPSJodHRwOi8vd3d3LmJvaGVtaWFuY29kaW5nLmNvbS9za2V0Y2gvbnMiIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIj48Zz48Zz48ZGVmcz48Y2lyY2xlIGN4PSIyMyIgY3k9Ijc0IiBpZD0iY2lyY2xlIiByPSI1MCIvPjwvZGVmcz48dXNlIGZpbGw9IiNGNUVFRTUiIG92ZXJmbG93PSJ2aXNpYmxlIiB4bGluazpocmVmPSIjY2lyY2xlIi8+PGNsaXBQYXRoIGlkPSJjaXJjbGVfMV8iPjx1c2Ugb3ZlcmZsb3c9InZpc2libGUiIHhsaW5rOmhyZWY9IiNjaXJjbGUiLz48L2NsaXBQYXRoPjxnIGNsaXAtcGF0aD0idXJsKCNjaXJjbGVfMV8pIj48ZGVmcz48cGF0aCBkPSJNMzYsOTUuOWMwLDQsNC43LDUuMiw3LjEsNS44YzcuNiwyLDIyLjgsNS45LDIyLjgsNS45YzMuMiwxLjEsNS43LDMuNSw3LjEsNi42djkuOEgtMjd2LTkuOCAgICAgICBjMS4zLTMuMSwzLjktNS41LDcuMS02LjZjMCwwLDE1LjItMy45LDIyLjgtNS45YzIuNC0wLjYsNy4xLTEuOCw3LjEtNS44YzAtNCwwLTEwLjksMC0xMC45aDI2QzM2LDg1LDM2LDkxLjksMzYsOTUuOXoiIGlkPSJzaG91bGRlcnMiLz48L2RlZnM+PHVzZSBmaWxsPSIjRTZDMTlDIiBvdmVyZmxvdz0idmlzaWJsZSIgeGxpbms6aHJlZj0iI3Nob3VsZGVycyIvPjxjbGlwUGF0aCBpZD0ic2hvdWxkZXJzXzFfIj48dXNlIG92ZXJmbG93PSJ2aXNpYmxlIiB4bGluazpocmVmPSIjc2hvdWxkZXJzIi8+PC9jbGlwUGF0aD48cGF0aCBjbGlwLXBhdGg9InVybCgjc2hvdWxkZXJzXzFfKSIgZD0iTTIzLjIsMzVjMC4xLDAsMC4xLDAsMC4yLDBjMCwwLDAsMCwwLDAgICAgICBjMy4zLDAsOC4yLDAuMiwxMS40LDJjMy4zLDEuOSw3LjMsNS42LDguNSwxMi4xYzIuNCwxMy43LTIuMSwzNS40LTYuMyw0Mi40Yy00LDYuNy05LjgsOS4yLTEzLjUsOS40YzAsMC0wLjEsMC0wLjEsMCAgICAgIGMtMC4xLDAtMC4xLDAtMC4yLDBjLTAuMSwwLTAuMSwwLTAuMiwwYzAsMC0wLjEsMC0wLjEsMGMtMy43LTAuMi05LjUtMi43LTEzLjUtOS40Yy00LjItNy04LjctMjguNy02LjMtNDIuNCAgICAgIGMxLjItNi41LDUuMi0xMC4yLDguNS0xMi4xYzMuMi0xLjgsOC4xLTIsMTEuNC0yYzAsMCwwLDAsMCwwQzIzLjEsMzUsMjMuMSwzNSwyMy4yLDM1TDIzLjIsMzV6IiBmaWxsPSIjRDRCMDhDIiBpZD0iaGVhZC1zaGFkb3ciLz48L2c+PC9nPjxwYXRoIGQ9Ik0yMi42LDQwYzE5LjEsMCwyMC43LDEzLjgsMjAuOCwxNS4xYzEuMSwxMS45LTMsMjguMS02LjgsMzMuN2MtNCw1LjktOS44LDguMS0xMy41LDguMyAgICBjLTAuMiwwLTAuMiwwLTAuMywwYy0wLjEsMC0wLjEsMC0wLjIsMEMxOC44LDk2LjgsMTMsOTQuNiw5LDg4LjdjLTMuOC01LjYtNy45LTIxLjgtNi44LTMzLjhDMi4zLDUzLjcsMy41LDQwLDIyLjYsNDB6IiBmaWxsPSIjRjJDRUE1IiBpZD0iaGVhZCIvPjwvZz48L3N2Zz4="
		};
	}
	);



AUI().ready(function(A)
{
	Liferay.ChatRoom.__init();
});


/********** HAndlebar helpers ****************/

(function(){
	
	//Plain text URL to anchor tags Handlebars Helper
    // defines markup enhancement regex
    var protocol = /(\b(https?|ftp):\/\/[-A-Z0-9+&@#\/%?=~_|!:,.;]*[-A-Z0-9+&@#\/%=~_|])/gim
      , scheme   = /(^|[^\/])(www\.[\S]+(\b|$))/gim;
			
    /*
     * Registers a Helper method with handlebars which, given a string of
     * plain text or existing markup, provides enhancements of plain text 
     * URLs, converting them to their respective anchor tag equivilents.=
     */
    Handlebars.registerHelper('formatMessage', function(text) {
	text = text.replace( protocol, '<a href="$1" target="_blank">$1</a>');
	text = text.replace( scheme,   '$1<a href="http://$2" target="_blank">$2</a>' );
	return new Handlebars.SafeString( text );
    });
}());