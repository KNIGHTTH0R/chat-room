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
				
				defaultAvatar: "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"
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
    Handlebars.registerHelper('formatMessage', function(text) 
    {
			text = text.replace( protocol, '<a href="$1" target="_blank">$1</a>');
			text = text.replace( scheme,   '$1<a href="http://$2" target="_blank">$2</a>' );
			return new Handlebars.SafeString( text );
    });
    
    Handlebars.registerHelper('if_startWith', function(a, b, opts) 
    {
        if(a && a.startsWith(b)) return opts.fn(this);
        else return opts.inverse(this);
    });
    
}());