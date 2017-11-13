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
				__welcome_message_template : "** I just entered the room. Didn't I look awesome with my given picture and name?",
				
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
					var message = {
							        "command": Liferay.ChatRoom.COMMAND_RPC, 
							        "body": {
							        	      "name": "connect",
							        	      "args": [{"userPseudo": ''}]
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
					
					A.one('textarea#chat-msg').setStyle('backgroundImage', 'url('+ Liferay.ChatRoom.chatUser.avatar + ')');
					
					//Welcome message
					Liferay.ChatRoom.sendTextMessageToLounge(Liferay.ChatRoom.__welcome_message_template);
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
					
					Liferay.ChatRoom.sendTextMessageToLounge(msg);
				},
				
				sendTextMessageToLounge: function(message)
				{
					var message = {
					        "command": Liferay.ChatRoom.COMMAND_RPC, 
					        "body": {
					        	      "name": "sendMessageToLounge",
					        	      "args": [{'loungeId': Liferay.ChatRoom.loungeId,
					        	    	        'msg': message
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
					
					var chatMessagesNode = A.one(Liferay.ChatRoom.__containerClass +" #chat-messages");
					chatMessagesNode.append(html);
					Liferay.ChatRoom._scrollToBottom(chatMessagesNode.get('id'));
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
				
				_scrollToBottom: function(id)
				{
					   var element = document.getElementById(id);
					   element.scrollTop = element.scrollHeight - element.clientHeight;
				}
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