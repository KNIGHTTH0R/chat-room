<%@ include file="/views/init.jsp" %>

<div class="container">
  
<div id="chat-room" class="hide">
</div>

  <div id="chat-box" class="hide">
    <div class="row">
        <div class="col-md-3">
            <div class="btn-panel btn-panel-conversation">
               <span id="room-title" class=" icon-home"></span>
            </div>
        </div>

        <div class="spanoffset-1 col-md-7">
            <div class="btn-panel btn-panel-msg">

                <a href="" class="btn  col-md-3  send-message-btn pull-right" data-bind-click="doLeaveLounge" >
                    <i class="fa icon-unlock"></i>
                    <span><liferay-ui:message key="logout" /> </span> 
                </a>
            </div>
        </div>
    </div>
    
    <div class="row" id="chat-main-container">

        <div class="conversation-wrap col-md-3 hidden-sm hidden-xm" id="chat-user-list">
        </div>

        <div class="message-wrap col-md-8" id="discussion-container">
            <div class="msg-wrap" id="chat-messages"></div>
			
			<div id="discussion-controls">
				<div class="send-wrap ">
	                <textarea class="form-control send-message" rows="1" id="chat-msg" data-bind-keypress="sendMessageToLounge"></textarea>
	            </div>
	            <div class="btn-panel">
	                <a href="#" class=" col-md-3 btn   send-message-btn hide"><i class="fa icon-cloud-upload "></i> Add Files</a>
	                <a href="#" class=" col-md-4 text-right btn  send-message-btn pull-right" data-bind-click="sendMessageToLounge" >
	                	<i class="fa icon-share"></i>
	                	 <span> <liferay-ui:message key="send-message" /> </span>
	                </a>
	            </div>
			</div>
        </div>
    </div>
    </div>
</div>

<script id="chat-room-template" type="text/x-handlebars-template">
  <div class="row">
       {{#each lounges}}
        <div class="col-md-5 chat-room" data-id="{{this.id}}" data-bind-click="joinLounge" >
            <div class="well well-sm">
                <div class="row">
                    <div class="col-md-3 text-center">
                        <img src="<%=request.getContextPath() + "/images/icon_room.png" %>" class="img-rounded img-responsive" />
                    </div>
                    <div class="col-md-9 section-box">
                        <h2>
                            {{this.name}}
                        </h2>
                        <p>
                            {{this.description}}
                        </p>
                    </div>
                </div>
            </div>
        </div>

     {{/each}}
    <div class="col-md-2></div>
    </div>
</script>

<script id="chat-messages-template" type="text/x-handlebars-template">
   <div class="media conversation msg">
                    <a class="pull-left" href="#">
						{{#if_startWith this.avatar 'http'}}
                        	<img class="media-object" alt="avatar" style="width: 32px; height: 32px;" src="data:image/png;base64,{{chatUser.avatar}}">
						{{else}}
							<img class="media-object" alt="avatar" style="width: 32px; height: 32px;" src="{{chatUser.avatar}}">
						{{/if_startWith}}
                    </a>
                    <div class="media-body">
                        <small class="pull-right time"><i class="fa icon-time"></i> {{currentTime time}}</small>

                        <h5 class="media-heading">{{chatUser.name}}</h5>
                        <small class="col-md-10">
                          {{formatMessage msg}}
                        </small>
                    </div>
  </div>
</script>

<script id="chat-users-template" type="text/x-handlebars-template">
 {{#each chatUsers}}
  <div class="media conversation user-item" data-id="{{this.id}}" >
                <a class="pull-left" href="#">
					{{#if_startWith this.avatar 'http'}}
                    	<img class="media-object" alt="avatar" style="width: 50px; height: 50px;" src="{{this.avatar}}">
					{{else}}
						<img class="media-object" alt="avatar" style="width: 50px; height: 50px;" src="data:image/png;base64,{{this.avatar}}">
					{{/if_startWith}}
                </a>
                <div class="media-body">
                    <h5 class="media-heading">{{this.name}}</h5>
                    <small>{{this.description}}</small>
                </div>
 </div>
{{/each}}
</script>