LYD.comet = {
	countComet : 0 ,
	userid : 0,
	username : '游客',
	hostid : '-',
	online : false,
	url : 'chat?userid='+this.userid+'&&username='+this.username,
	initComet : function(c_userid,c_username){
		//初始化显示聊天窗口
		$("#say_banner").css("display","block");
		this.userid = c_userid;
		this.username = c_username;
		this.url = 'chat?userid='+this.userid;
		//打开长连接
		$.stream(this.url, {
			type: "http",
			dataType: "json",
			context: $("#content")[0],
			open: function(event, stream) {
				_trace(LYD.comet.online+"online");
				_trace(event.data);
				if(!LYD.comet.online){
					LYD.comet.online = true;
				}
				$("#comet_user").html('');
				$("#comet_myphoto").attr("src",$.cookie('photo'));
			},
			message: function(event) {
//				alert(event.data.status);
				if(event.data.status==204){
					//把自己推送给他人
					var userNode = '<div class="single" userid="'+event.data.UID+'" username="'+event.data.USERNAME+'"> '
					+'<div id="user'+event.data.UID+'" class="pic"><img src="'+event.data.photo+'" width="40" height="40" /></div>'
					+'<div class="name">'+event.data.USERNAME+'</div>'
					+'<div class="txt">一句话介绍</div>'
					+'<div class="clear"></div>'
				+'</div>';
					{$("#comet_user").append(userNode);}
					
					//绑定点击弹出聊天窗口事件
					$("#comet_user .single").css("cursor", "pointer");
					$("#comet_user .single").bind();
					$("#comet_user .single").click(function(event){
						var uid = $(this).attr("userid");
						var uname = $(this).attr("username");
						//打来对聊
						LYD.comet.createChat(uid,uname);
					});
					//添加未读信息removeNotice
					setNotice("say_logo","N");
					setNotice("say_person_button","N");
				}else if(event.data.status==205){
					//用户下线
					var single = $("#comet_user").children(".single");
					if(single.length==1){
						single.remove();
					}else{
						for(var i=0;i<single.length;i++){
							if(single[i].attr(userid)==event.date.leaveId){
								single[i].remove();
							}
						}
					}
				}else if(event.data.status==200){
					//刷新所有好友列表
					$("#webpager_online_friend_count").html(event.data.totalCount);
					$("#comet_user").html('');
					for(i=0;i < event.data.totalCount;i++){	
						var userId = event.data.friends[i].UID;
						_trace(userId);
						//好友
						var userNode = '<div class="single" userid="'+event.data.friends[i].UID+'" username="'+event.data.friends[i].USERNAME+'"> '
							+'<div id="user'+event.data.friends[i].UID+'" class="pic"><img src="'+event.data.friends[i].photo+'" width="40" height="40" /></div>'
							+'<div class="name">'+event.data.friends[i].USERNAME+'</div>'
							+'<div class="txt">一句话介绍</div>'
							+'<div class="clear"></div>'
						+'</div>';
						{$("#comet_user").append(userNode);}
					}
					_trace("刷新好友 完成");
					$("#comet_user .single").css("cursor", "pointer");
					//点击好友的方法
					$("#comet_user .single").click(function(event){
						var uid = $(this).attr("userid");
						var uname = $(this).attr("username");
						//打来对聊
						LYD.comet.createChat(uid,uname);
					});
				}else if(event.data.status==203){
					//聊天1
					if(LYD.comet.hasCard(event.data.fromUserId)){
					}else{
						var say_task = '<div class="say_task" userid="'+event.data.fromUserId+'" select="true" style="cursor: pointer; display: block; color: #111; font-weight: bolder; ">'
						+'<div class="right"><div class="middle">'
						+'<div class="txt">'+event.data.fromUserName+'</div>'
						+'</div></div>'
						+'</div>';
						$(".task_add").append(say_task);
					}
					
					//判断是否存在聊天主体
					if(LYD.comet.hasChat(event.data.fromUserId)){
					}else{
						var comet_view = '<div class="out_object_main" id="comet_msgview" userid="'+event.data.fromUserId+'" username='+event.data.fromUserName+'>'
//						+'<div class="single">'
//						+'<div class="pic"><img src="'+event.data.fromUserPhoto+'" width="44" height="44"></div>'
//						+'<div class="txt_main">'
//						+'<div class="in_txt">'
//						+'</div>'
//						+'</div>'
//						+'</div>'
						+'</div>';
						$("#comet_mainview").append(comet_view);
					}
					//消息内容
					var msgDom = '<div class="single">'
						+'<div class="pic"><img src="'+event.data.fromUserPhoto+'" width="44" height="44"></div>'
						+'<div class="txt_main">'
						+'	<div class="in_txt">'
						+'		<div>'+event.data.fromMsg+'</div>'
						+'		<div class="time">10:43:42<span>'+event.data.fromUserName+'</span></div>'
						+'	</div>'
						+'</div>'
						+'</div>';
					$("#comet_mainview .out_object_main").each(function(i){ 
						var m_userid = $(this).attr("userid");
						if(m_userid == event.data.fromUserId){
							
							$(this).append(msgDom);
							$(this).scrollTop($(this).scrollTop()+100);
						}
					});
					
					$("#comet_task .say_task").each(function(i){ 
						var userid = $(this).attr("userid");
						$(this).click(function(){
							var user_win = $("#say_object");
							user_win.attr("touserid",$(this).attr("userid"));
							user_win.css("display","block");
							
							//判断主窗口是否隐藏
							var _say_object=$("#say_object");
							if(_say_object.css("display")=="none"){
								_say_object.slideDown("normal");
							}
							
							//切换聊天OUT页面
							$("#comet_mainview .out_object_main").each(function(i){ 
								var main_userid = $(this).attr("userid");
								$(this).css("display","none");
								if(main_userid == userid){
									$(this).css("display","block");
								}
							});
							//切换聊天 选中TASK
							$("#comet_task .say_task").each(function(i){ 
								$(this).attr("select", "false").css("color", "#111").css("font-weight", "400");
							});
							$(this).attr("select", "true").css("color", "#111").css("font-weight", "bolder");
						});
					});
				}
			},
			error: function() {
//				alert("error");
			},
			close: function() {
//				alert("close");
			}
		});
		//绑定消息发送  
		$("#comet_msgbox").keyup(function(event) {
			if (event.which === 13 && $.trim(this.value)) {
				LYD.comet.sendMsg();
				this.value = "";
			}
		});
		this.refreshFriendAddList();
		this.sysMsg();
	},
	
	friendList : function(){
		$(".friends-panel").toggleClass("actived");
	},
	hasChat: function(in_userid){
		var flag = false;
		$("#comet_mainview .out_object_main").each(function(i){ 
			var userid = $(this).attr("userid");
			if(userid == in_userid){
				$(this).css("display","block");
				flag =  true;
			}
		});
		return flag;
	},
	hasCard : function(create_userid){
		var has_card = false;
		$("#comet_task .say_task").each(function(i){ 
			var userid = $(this).attr("userid");
			if(userid == create_userid){
				$(this).css("display","block");
				has_card =  true;
			}
		});
		return has_card;
	},
	createChat : function(userid,username){
		var create_userid = userid;
		LYD.comet.getUserPhoto(userid,"LIMG");
		try {
			$("#comet_mainview .out_object_main").each(function(i){ 
				var userid = $(this).attr("userid");
				$(this).css("display","none");
				_trace(userid);
			});
		} catch (e) {
		}
		this.countComet = this.countComet + 1;
		var user_win = $("#say_object");
		user_win.attr("touserid",userid);
		user_win.css("display","block");
		//底部添加聊天
		if(this.hasChat(userid)){
		}else{
			var comet_view = '<div class="out_object_main" id="comet_msgview" userid="'+userid+'" username='+username+'>'
//			+'<div class="single">'
//			+'<div class="pic"><img src="front/images/activity/demo/123.png" width="44" height="44"></div>'
//			+'<div class="txt_main">'
//			+'<div class="in_txt">'
//			+'	<div>'+username+'</div>'
//			+'	<div class="time">10:43:42<span>suqwe</span></div>'
//			+'</div>'
//			+'</div>'
//			+'</div>'
			+'</div>';
			$("#comet_mainview").append(comet_view);
		}
		//判断是否存在聊天主体  ！添加
		if(this.hasCard(userid)){
		}else{
			var say_task = '<div class="say_task" userid="'+userid+'" select="false" style="cursor: pointer; ">'
			+'<div class="right"><div class="middle">'
			+'<div class="txt">'+username+'</div>'
			+'</div></div></div>';
			$(".task_add").append(say_task);
		}
		
		
		//绑定 聊天 task 点击事件   
		$("#comet_task .say_task").each(function(i){ 
			var userid = $(this).attr("userid");
			$(this).click(function(){
				//判断主窗口是否隐藏
				var _say_object=$("#say_object");
				if(_say_object.css("display")=="none"){
					_say_object.slideDown("normal");
				}
				//切换聊天OUT页面
				$("#comet_mainview .out_object_main").each(function(i){ 
					var main_userid = $(this).attr("userid");
					$(this).css("display","none");
					if(main_userid == userid){
						$(this).css("display","block");
					}
				});
				//切换聊天 选中TASK
				$("#comet_task .say_task").each(function(i){ 
					$(this).attr("select", "false").css("color", "#111").css("font-weight", "400");
				});
				$(this).attr("select", "true").css("color", "#111").css("font-weight", "bolder");
			});
		});
	
	},
	//通过好友申请
	passFriend : function(userid){
		LYD.a({
			params : {serviceName:'FriendService',methodName:'passFriendAdd',userid:userid},
			success : function(msg){
				LYD.Alert("message","提示","添加好友成功");
			}
		});
	},
	//忽略好友申请
	ignoreFriend : function(userid){
		LYD.a({
			params : {serviceName:'FriendService',methodName:'ignoreFriend',userid:userid},
			success : function(msg){
				LYD.Alert("message","提示","已忽略");
			}
		});
	},
	//显示加好友请求列表
	refreshFriendAddList : function(){
		$("#comet_add_list").html('');
		LYD.a({
			params : {serviceName:'FriendService',methodName:'getFriendAddList'},
			success : function(msg){
				for(var i = 0 ;i<msg.totleCount;i++){
					var user_node  = '<div class="single" userid="'+msg.result[i].friendId+'">'+
					'<div class="tx"><span>'+msg.result[i].friendName+'</span>申请加您为好友</div>'+
					'<div class="tx_button">忽略</div>'+
					'<div class="tx_button">接受</div>'+
					'<div class="clear"></div>'+
					'</div>';
					$("#comet_add_list").append(user_node);
				}
				$("#comet_add_list").find(".single").each(function(i){
					var add_list_userid = $(this).attr("userid");
					$(this).find(".tx_button").eq(1).mouseover(function () {
						$(this).css("cursor", "pointer");
					}).click(function(){
						LYD.comet.passFriend(add_list_userid);
					});
					var add_list_userid = $(this).attr("userid");
					$(this).find(".tx_button").eq(0).mouseover(function () {
						$(this).css("cursor", "pointer");
					}).click(function(){
						LYD.comet.ignoreFriend(add_list_userid);
					});
					var userid = $(this).attr("userid");
				});
			}
		});
	},
	//显示系统消息列表
	refreshSysMsgdList : function(){
		$("#comet_add_list").html('');
		LYD.a({
			params : {serviceName:'FriendService',methodName:'getFriendAddList'},
			success : function(msg){
				for(var i = 0 ;i<msg.totleCount;i++){
					var user_node  = '<div class="single" userid="'+msg.result[i].friendId+'">'+
					'<div class="tx"><span>'+msg.result[i].friendName+'</span>申请加您为好友</div>'+
					'<div class="tx_button">忽略</div>'+
					'<div class="tx_button">接受</div>'+
					'<div class="clear"></div>'+
					'</div>';
					$("#comet_add_list").append(user_node);
				}
//				$("#comet_add_list").find(".single").each(function(i){
//					var add_list_userid = $(this).attr("userid");
//					$(this).find(".tx_button").eq(1).mouseover(function () {
//						$(this).css("cursor", "pointer");
//					}).click(function(){
//						LYD.comet.passFriend(add_list_userid);
//					});
//					var add_list_userid = $(this).attr("userid");
//					$(this).find(".tx_button").eq(0).mouseover(function () {
//						$(this).css("cursor", "pointer");
//					}).click(function(){
//						LYD.comet.ignoreFriend(add_list_userid);
//					});
//					var userid = $(this).attr("userid");
//				});
			}
		});
	},
	sysMsg : function(){
		var mes_main = $(".mes_scroll .main");
		mes_main.html("");
		LYD.a({
			params : {serviceName:'SysService',methodName:'sysMsg'},
			success : function(msg){
				if(msg.status==200){
					var flag = 0;
					for(var i = 0 ;i<msg.result.size;i++){
						
						var r = msg.result.sysMsg[i];
						if(r.READED=="false"){
							flag+=1;
						}
						
						if(r.TYPE==0){
						}else if(r.TYPE==1){
							var user_node  = '<div class="single">'+
							'<div class="tx"><span>'+msg.result.USERTRUENAME+'</span>'+msg.result.TITLE+'</div>'+
							'<div class="tx_button">忽略</div>'+
							'<div class="tx_button">接受</div>'+
							'<div class="clear"></div>'+
							'</div>';
						}else if(r.TYPE==2){
							//***关注了您
							var user_node  = '<div class="single">'+
							'<div class="tx"><span><a href="home.do?command=other&homePersonId='+r.eventIdList[0]+'">'+r.eventList[0]+'</a></span>关注了您'+'</div>'+
							'<div class="tx_button" style="cursor: pointer;" onclick="COMMON.ignoreSys('+r.SYSID+')">忽略</div>'+
							'<div class="tx_button" style="cursor: pointer;" onclick=window.location.href="home.do?command=other&homePersonId='+r.eventIdList[0]+'">查看</div>'+
							'<div class="clear"></div>'+
							'</div>'
						}else if(r.TYPE==3){
						
						}else if(r.TYPE==4){
							var user_node  = '<div class="single">'+
							'<div class="tx"><span><a href="home.do?command=other&homePersonId='+r.eventIdList[0]+'">'+r.eventList[0]+'</a></span>想加入'+'<span><a href="rdetail.do?roundId='+r.eventIdList[1]+'">'+r.eventList[1]+'</a></span>'+'</div>'+
							'<div class="tx_button" style="cursor: pointer;" onclick="COMMON.ignoreSys('+r.SYSID+')">忽略</div>'+
							'<div class="tx_button" style="cursor: pointer;" onclick="COMMON.passAttentionRound('+r.eventIdList[1]+','+r.eventIdList[0]+')">接受</div>'+
							'<div class="clear"></div>'+
							'</div>';
						}else if(r.TYPE==5){
							//您已成功加入XXX圈
							var user_node  = '<div class="single">'+
							'<div class="tx">您已成功加入<span><a href="rdetail.do?roundId='+r.eventIdList[1]+'">'+r.eventList[0]+'</a></span></div>'+
							'<div class="tx_button" style="cursor: pointer;" onclick="COMMON.ignoreSys('+r.SYSID+')">忽略</div>'+
							'<div class="tx_button" style="cursor: pointer;" onclick=window.location.href="rdetail.do?roundId='+r.eventIdList[1]+'>接受</div>'+
							'<div class="clear"></div>'+
							'</div>'
						}else if(r.TYPE==6){
						
						}else if(r.TYPE==7){
						
						}else if(r.TYPE==8){
						
						}else if(r.TYPE==9){
						
						}else if(r.TYPE==10){
						
						}else if(r.TYPE==11){
						
						}else if(r.TYPE==12){
						
						}else if(r.TYPE==13){
						
						}else if(r.TYPE==14){
						
						}else if(r.TYPE==15){
						
						}else if(r.TYPE==16){
						
						}else if(r.TYPE==17){
						
						}else if(r.TYPE==18){
						
						}
						mes_main.append(user_node);
					}
					if(flag>0){
						setNotice("say_logo",flag);
						setNotice("say_message_button",flag);
					}
				}else if(msg.status==300){
					alert("未登录");
				}
				
			}
		});
	}
	,
	startChat : function(userid){
		$("#userpanel"+userid).toggleClass("actived");
	},
	
	closeChat : function(){
		
	},
	sendMsg : function(){
		var msg = $("#comet_msgbox").val();
		var toUserId = $("#say_object").attr("touserid");
		$.stream().send({touser: toUserId, message: msg});
		$("#comet_msgbox").val('');
		//显示我的消息到聊天框
		var msgDom = '<div class="single">'
			+'<div class="pic"><img src="'+$.cookie('photo')+'" width="44" height="44"></div>'
			+'<div class="txt_main">'
			+'	<div class="in_txt">'
			+'		<div>'+msg+'</div>'
			+'		<div class="time">10:43:42<span>'+this.username+'</span></div>'
			+'	</div>'
			+'</div>'
			+'</div>';
		$("#comet_mainview .out_object_main").each(function(i){ 
			var m_userid = $(this).attr("userid");
			if(m_userid == toUserId){
				
				$(this).append(msgDom);
				$(this).scrollTop($(this).scrollTop()+100);
			}
		});
		msgDom =  null;
	},
	takeMsg : function(){
		
	},
	collapseBar : function(){
		var left = $("#bottombar").css("left");
		if(left == '1181px'){
			$("#bottombar").animate({left:'20px'},"fast");
			setTimeout(function(){
				$("#notification-panel").css("display","block");
				$("#friends-panel").css("display","block");
				$("#tasks-panel").css("display","block");
			},300);
		} else {
			$("#notification-panel").css("display","none");
			$("#friends-panel").css("display","none");
			$("#tasks-panel").css("display","none");
			$("#bottombar").animate({left:'1181px'},"fast");
		}
		
	},
	getUserPhoto : function(uid,dom){
		LYD.a({
			params : {serviceName:'UserService',methodName:'getPhotoByUIDandTYPE',uid:uid},
			success : function(msg){
				$("#comet_outphoto").attr("src",msg.result.photo);
			}
		});
	}
};