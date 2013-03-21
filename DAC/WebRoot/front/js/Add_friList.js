//该区域的所有好友添加方法
function Add_friList() {
	//该区域变量
	var _acfr_main = $(".acfr_main");
	var _friList_scroll = $(".friList_scroll");
	var _friList_main = _friList_scroll.children(".friList_main");
	var _friList_single = _friList_main.children(".friSingle");
	var _fri_click_absolute = $(".fri_click_absolute").children("div");
	var _fri_buttons_array = _fri_click_absolute.eq(1).children("div");
	var _fri_click_bannerA = $(".fri_click_banner").children("div");
	var _fri_click_banner_ed_width = _fri_click_bannerA.eq(2).html();
	var _list_single_right_chakan = $(".list_single_right_chakan");
	var friendId;
	
	
	for (var i = 0; i < _fri_buttons_array.length; i++) {
		
		_fri_buttons_array.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 2) {
				$(this).attr("class", "fri_click_guanzhu_top_ed");
//				//绑定+关注操作
//				COMMON.attendFriend();
			} else if ($(this).attr("number") == 3) {
				$(this).attr("class", "fri_click_haoyou_top_ed");
			} else if ($(this).attr("number") == 4) {
				alert("分享");
			} else if ($(this).attr("number") == 5) {
				//聊天
			}
		});
	}
	_fri_click_bannerA.eq(0).css("width", _fri_click_banner_ed_width);
}
//刷新点好友回列表方法
function friendsMap(){
	var _friends_icon1 = $(".friends_icon1");
	var _acfr_main = $(".acfr_main");
	for(var i=0;i<_friends_icon1.length;i++){
		
		_friends_icon1.eq(i).mouseover(function(){
			$(this).css("cursor", "pointer");
		}).click(function () {
			
			_acfr_main.animate({
				"left" : "-565"
			}, 500);
		});
	}
}
function friendsRight(){
	var _friends_icon1 = $(".friends_icon1");
	var _acfr_main = $(".acfr_main");
//	for(var i=0;i<_friends_icon1.length;i++){
//		
//		_friends_icon1.eq(i).mouseover(function(){
//			$(this).css("cursor", "pointer");
//		}).click(function () {
//			
//			_acfr_main.animate({
//				"left" : "-565"
//			}, 500);
//		});
//	}
	var _select_number2;
	var _fri_banner_button = $(".fri_banner_button");
	
	for(var i=0;i<_fri_banner_button.length;i++){
		_fri_banner_button.eq(i).attr("number",i).mouseover(function(){
			$(this).css("cursor", "pointer");
		}).click(function(){
			_select_number2 = $(this).attr("number");
			for(var j=0;j<_fri_banner_button.length;j++){
				
				if(_fri_banner_button.eq(j).attr("number")==_select_number2){
					//
					_trace('friendsRight'+2);
					getFriendDetail($(this).attr("value"));
					_acfr_main.animate({
						"left" : "-1130"
					}, 500);
				}
			}
		});
	}
}

function friendsList(){
	var _select_number;
	var _list_single_right_chakan = $(".list_single_right_chakan");
	var _list_single_right_jiahao=$(".list_single_right_jiahao");
	var list_single_right_guanzhu=$(".list_single_right_guanzhu");
	var _acfr_main = $(".acfr_main");
	for(var i=0;i<_list_single_right_chakan.length;i++){
		//friendId = _list_single_right_chakan.eq(i).attr("value");
		
		_list_single_right_chakan.eq(i).attr("number",i).attr("value");
		_list_single_right_chakan.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_select_number = $(this).attr("number");
			for(var j=0;j<_list_single_right_chakan.length;j++){
				if($(this).attr("number")==_select_number){
					friendId = $(this).attr("value");
				}
			}
			//
			_trace('friendsList+1');
			getFriendDetail(friendId);
			_acfr_main.animate({
				"left" : "-1130"
			}, 500);
		});
	}
	for(var i=0;i<_list_single_right_jiahao.length;i++){
		_list_single_right_jiahao.eq(i).attr("number",i).attr("value");
		_list_single_right_jiahao.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_select_number = $(this).attr("number");
			for(var j=0;j<_list_single_right_jiahao.length;j++){
				if($(this).attr("number")==_select_number){
					friendId = $(this).attr("value");
				}
			}
			COMMON.addFriend(friendId);
		});
	}
	for(var i=0;i<list_single_right_guanzhu.length;i++){
		list_single_right_guanzhu.eq(i).attr("number",i).attr("value");
		list_single_right_guanzhu.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_select_number = $(this).attr("number");
			for(var j=0;j<list_single_right_guanzhu.length;j++){
				if($(this).attr("number")==_select_number){
					friendId = $(this).attr("value");
				}
			}
			COMMON.attendFriend(friendId);
		});
	}
}
function getFriendDetail(friendId){
	var fri_click_localTx = $('.fri_click_localTx');
	var fri_click_guanzhu = $('.fri_click_guanzhu');
	var fri_click_haoyou = $('.fri_click_haoyou');
	var fri_click_right_tx = $('.fri_click_right_tx');
	var fri_click_pic = $('.fri_click_pic');
	var fri_click_right_pic = $('.fri_click_right_pic');
	var fri_click_topic = $('.fri_click_topic');
	var fri_click_banner_per = $('.fri_click_banner_per');
	var fri_click_banner_ed = $('.fri_click_banner_ed');
	var fri_click_somewords=$('.fri_click_somewords');
	fri_click_pic.unbind();
	fri_click_pic.click(function(){
		COMMON.chuansongmen(friendId);
	});
	LYD.openLink({
		params:{serviceName:'FriendService',methodName:'getFriendDetail',friendId:friendId},
		success:function(msg){
			fri_click_topic.html(msg.result.friendName);
			
			fri_click_pic.children("img").attr("src",msg.result.photo);
			
			if(msg.result.schoolName==""&&msg.result.provinceName!="该用户已设置隐私保护"){
				fri_click_localTx.html(" "+msg.result.provinceName+" "+msg.result.cityName);
			}
			else if(msg.result.provinceName!="该用户已设置隐私保护"&&msg.result.schoolName!=""){
				fri_click_localTx.html(" "+msg.result.schoolName);
			}
			else if(msg.result.provinceName=="该用户已设置隐私保护"&&msg.result.schoolName!=""){
				fri_click_localTx.html(" "+msg.result.schoolName);
			}
			else if(msg.result.provinceName=="该用户已设置隐私保护"&&msg.result.schoolName==""){
				fri_click_localTx.html(" "+msg.result.provinceName);
			}
			else{
				fri_click_localTx.html(" "+msg.result.schoolName);
			}
			fri_click_guanzhu.html("关注 "+msg.result.attentionCount);
			fri_click_haoyou.html("好友 "+msg.result.friendCount);
			fri_click_banner_per.html(msg.result.commonState+"%");
			fri_click_banner_ed.css("width", fri_click_banner_per.html());
			fri_click_right_tx.html(" ");
			fri_click_somewords.html(msg.result.userStatu);
			if(msg.result.friendActivityName=="此人近期没有参加任何活动"){
				fri_click_right_tx.append("<span>"+msg.result.friendActivityName+"</span>");
			}
			else{
				fri_click_right_tx.append("他在玩儿：<span>"+msg.result.friendActivityName+"...</span>等"+msg.result.friendActCount+"个活动<span><a href='#'>查看</a></span>");
			}
//			fri_click_right_tx.children("span").eq(0).html(msg.result.friendActivityName);
//			fri_click_right_tx.children("span").eq(0).after("等"+msg.result.friendActCount+"个活动");
//			fri_click_right_pic.children("div").eq(0).html("他的好友： ("+msg.result.friendCount+")");
			
			
			//判断男女
			if(msg.result.friendSex==1){
				var i;
				fri_click_right_pic.eq(0).html(" ");
				fri_click_topic.css("background"," url('../combo/front/images/activity/friend_icon.png') no-repeat ");
				fri_click_right_pic.eq(0).append("<div class='tx'>他的好友： ("+msg.result.friendCount+")</div>");
				for(i=0;i<msg.result.friendIdListSize&&i<5;i++){
					fri_click_right_pic.eq(0).append("<div class='_smallPic' onmouseover='COMBO.personIF("+msg.result.friendIdList[i].FRIENDID+")'><img src='"+msg.result.friendIdList[i].SIMG+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.friendIdListSize&&i<5){
					for(var ii=i;ii<5;ii++){
						fri_click_right_pic.eq(0).append("<div class='_smallPic'></div>");
					}
				}
				fri_click_right_pic.eq(1).html(" ");
				fri_click_right_pic.eq(1).append("<div class='tx'>共同好友： ("+msg.result.commonFriendIdPhotoListSize+")</div>");
				for(i =0;i<msg.result.commonFriendIdPhotoListSize&&i<3;i++){
					fri_click_right_pic.eq(1).append("<div class='_smallPic' onmouseover='COMBO.personIF("+msg.result.commonFriendIdPhotoList[i].FRIENDID+")' ><img src='"+msg.result.commonFriendIdPhotoList[i].FRIENDPHOTO+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.commonFriendIdPhotoListSize&&i<3){
					for(var ii=i;ii<3;ii++){
						fri_click_right_pic.eq(1).append("<div class='_smallPic'></div>");
					}
				}
				fri_click_right_pic.eq(2).html(" ");
				fri_click_right_pic.eq(2).append("<div class='tx'>他的圈子： ("+msg.result.friendRoundListSize+")</div>");
				if(msg.result.friendRoundListSize==0){
					//fri_click_right_pic.eq(2).append("<div class='_smallPic'>该用户已设置隐私保护</div>");
				}
				for(i=0;i<msg.result.friendRoundListSize&&i<5;i++){
					fri_click_right_pic.eq(2).append("<div class='_smallPic'><img src='"+msg.result.friendRoundList[i].RPATH+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.friendRoundListSize&&i<5){
					for(var ii=i;ii<5;ii++){
						fri_click_right_pic.eq(2).append("<div class='_smallPic'></div>");
					}
				}
				fri_click_right_pic.eq(3).html(" ");
				fri_click_right_pic.eq(3).append("<div class='tx'>共同圈子： ("+msg.result.friendCommonRoundListSize+")</div>");
				for(i=0;i<msg.result.friendCommonRoundListSize&&i<3;i++){
					fri_click_right_pic.eq(3).append("<div class='_smallPic' ><img src='"+msg.result.friendCommonRoundList[i].RPATH+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.friendCommonRoundListSize&&i<3){
					for(var ii=i;ii<3;ii++){
						fri_click_right_pic.eq(3).append("<div class='_smallPic'></div>");
					}
				}
				
			}
			else{
				fri_click_topic.css("background"," url('../combo/front/images/activity/list_single_pic_name.png') no-repeat");
				var i;
				fri_click_right_pic.eq(0).html(" ");
				fri_click_right_pic.eq(0).append("<div class='tx'>她的好友： ("+msg.result.friendCount+")</div>");
				for(i=0;i<msg.result.friendIdListSize&&i<5;i++){
					fri_click_right_pic.eq(0).append("<div class='_smallPic' onmouseover='COMBO.personIF("+msg.result.friendIdList[i].FRIENDID+")'><img src='"+msg.result.friendIdList[i].SIMG+"' width='38' height='38'  /></div>");
				}
				if(i>=msg.result.friendIdListSize&&i<5){
					for(var ii=i;ii<5;ii++){
						fri_click_right_pic.eq(0).append("<div class='_smallPic'></div>");
					}
				}
				fri_click_right_pic.eq(1).html(" ");
				fri_click_right_pic.eq(1).append("<div class='tx'>共同好友： ("+msg.result.commonFriendIdPhotoListSize+")</div>");
				for(i =0;i<msg.result.commonFriendIdPhotoListSize&&i<3;i++){
					fri_click_right_pic.eq(1).append("<div class='_smallPic' onmouseover='COMBO.personIF("+msg.result.commonFriendIdPhotoList[i].FRIENDID+")'><img src='"+msg.result.commonFriendIdPhotoList[i].FRIENDPHOTO+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.commonFriendIdPhotoListSize&&i<3){
					for(var ii=i;ii<3;ii++){
						fri_click_right_pic.eq(1).append("<div class='_smallPic'></div>");
					}
				}
				fri_click_right_pic.eq(2).html(" ");
				fri_click_right_pic.eq(2).append("<div class='tx'>她的圈子： ("+msg.result.friendRoundListSize+")</div>");
				for(i=0;i<msg.result.friendRoundListSize&&i<5;i++){
					fri_click_right_pic.eq(2).append("<div class='_smallPic'><img src='"+msg.result.friendRoundList[i].RPATH+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.friendRoundListSize&&i<5){
					for(var ii=i;ii<5;ii++){
						fri_click_right_pic.eq(2).append("<div class='_smallPic'></div>");
					}
				}
				fri_click_right_pic.eq(3).html(" ");
				fri_click_right_pic.eq(3).append("<div class='tx'>共同圈子： ("+msg.result.friendCommonRoundListSize+")</div>");
				for(i=0;i<msg.result.friendCommonRoundListSize&&i<3;i++){
					fri_click_right_pic.eq(3).append("<div class='_smallPic'><img src='"+msg.result.friendCommonRoundList[i].RPATH+"' width='38' height='38' /></div>");
				}
				if(i>=msg.result.friendCommonRoundListSize&&i<3){
					for(var ii=i;ii<3;ii++){
						fri_click_right_pic.eq(3).append("<div class='_smallPic'></div>");
					}
				}
			}
			Add_idCard();
			//回复原来按钮
			if($('.fri_click_haoyou_top').length==0||$('.fri_click_guanzhu_top').length==0){
				$('.fri_click_haoyou_top_ed').attr("class","fri_click_haoyou_top");
				$('.fri_click_guanzhu_top_ed').attr("class","fri_click_guanzhu_top");
			}
			//绑定加好友事件
			var _fri_click_haoyou_top=$('.fri_click_haoyou_top');
			var _fri_click_guanzhu_top=$('.fri_click_guanzhu_top');
			_fri_click_haoyou_top.unbind();
			_fri_click_haoyou_top.click(function(){
				$('.fri_click_haoyou_top').attr("class", "fri_click_haoyou_top");
				//绑定+关注操作
				COMMON.addFriend(friendId);
			})
			//绑定留言板
			$(".fri_click_speak").unbind();
			$(".fri_click_speak").css("cursor","pointer").click(function(){
				window.location.href="home.do?command=otherMessage&homePersonId="+friendId;
			});
			_fri_click_guanzhu_top.unbind();
			_fri_click_guanzhu_top.click(function(){
				$('.fri_click_guanzhu_top').attr("class", "fri_click_guanzhu_top_ed");
				//绑定+关注操作
				COMMON.attendFriend(friendId);
			})
			if(msg.result.is_fri=="1"){
				$(".fri_click_haoyou_top").attr("class", "fri_click_haoyou_top_ed");
			}
			if(msg.result.is_attend=="1"){
				$(".fri_click_guanzhu_top").attr("class","fri_click_guanzhu_top_ed");
			}
			
		}
	});
}
