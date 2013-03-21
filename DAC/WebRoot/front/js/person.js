$(document).ready(function () {
	
	//方法调用
	Add_nevigation();
	Add_person_round();
	Add_message();
	Add_out();
	Add_person_fri();
	person_top_button();
	input_top();
    //Add_person_fri_list();
	
});

//圈子界面方法
function Add_person_round() {
	var _round_top = $(".round_top");
	var _round_select = _round_top.children();
	var _round_selection = _round_select.eq(1);
	var _round_selection_out = _round_select.eq(0);
	var _round_single_select = _round_selection_out.children(".round_selection_middle").children();
	var _round_chengyuan = $(".round_chengyuan");
	var _round_slide_mask = $(".round_slide_mask");
	var _round_slide_mask_control = true;
	var _round_slide_mask_control2 = true;
	var _round_small_mask = $(".round_small_mask");
	var _round_single_obejct;
	var _top_tx = $(".round_slide_middle .main .top_tx div");
	var _top_tx2 = $(".round_slide_middle2 .main .top_tx div");
	var _round_slide_pics = $(".round_slide_middle .main .pic");
	var _round_slide_pics2 = $(".round_slide_middle2 .main .pic");
	var _round_slide_pics_control = false;
	var _bubble = $("#bubble");
	var _round_slide_pics_select = false;
	var _round_slide_pics_select2 = false;
	for (var i = 0; i < _round_chengyuan.length; i++) {
		var _N0_height = _round_slide_mask.eq(0).outerHeight();
		var _N1_height = _round_slide_mask.eq(1).outerHeight();
		_round_chengyuan.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == "0") {
				if (_round_slide_mask_control) {
					_round_slide_mask.eq(0).css("height", 0);
					_round_slide_mask.eq(0).css("display", "block");
					_round_slide_mask.eq(0).stop().animate({
						height : _N0_height
					}, "slow");
					_round_slide_mask_control = false;
				} else {
					_round_slide_mask.eq(0).stop().animate({
						height : 0
					}, "slow");
					_round_slide_mask_control = true;
				}
			}
			if ($(this).attr("number") == "1") {
				if (_round_slide_mask_control2) {
					_round_slide_mask.eq(1).css("height", 0);
					_round_slide_mask.eq(1).css("display", "block");
					_round_slide_mask.eq(1).stop().animate({
						height : _N1_height
					}, "slow");
					_round_slide_mask_control2 = false;
				} else {
					_round_slide_mask.eq(1).stop().animate({
						height : 0
					}, "slow");
					_round_slide_mask_control2 = true;
				}
			}
		});
	}
	for (var i = 0; i < _top_tx.length; i++) {
		_top_tx.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 0) {
				$(this).attr("class", "top_tx_left_active");
				_top_tx.eq(1).attr("class", "top_tx_left");
				_top_tx.eq(2).attr("class", "top_tx_left");
			}
			if ($(this).attr("number") == 1) {
				$(this).attr("class", "top_tx_left_active");
				_top_tx.eq(0).attr("class", "top_tx_left");
				_top_tx.eq(2).attr("class", "top_tx_left");
			}
			if ($(this).attr("number") == 2) {
				$(this).attr("class", "top_tx_left_active");
				_top_tx.eq(0).attr("class", "top_tx_left");
				_top_tx.eq(1).attr("class", "top_tx_left");
			}
			if ($(this).attr("number") == 3) {
				//点击确定
			}
			if ($(this).attr("number") == 4) {
				//点击取消
				for (var j = 0; j < _round_slide_pics.length; j++) {
					_round_slide_pics.eq(j).children(".mask").stop().fadeTo(200, 0.0);
				}
				_round_slide_pics_select = false;
			}
		});
	}
	for (var i = 0; i < _top_tx2.length; i++) {
		_top_tx2.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 0) {
				$(this).attr("class", "top_tx_left_active");
				_top_tx2.eq(1).attr("class", "top_tx_left");
				_top_tx2.eq(2).attr("class", "top_tx_left");
			}
			if ($(this).attr("number") == 1) {
				$(this).attr("class", "top_tx_left_active");
				_top_tx2.eq(0).attr("class", "top_tx_left");
				_top_tx2.eq(2).attr("class", "top_tx_left");
			}
			if ($(this).attr("number") == 2) {
				$(this).attr("class", "top_tx_left_active");
				_top_tx2.eq(0).attr("class", "top_tx_left");
				_top_tx2.eq(1).attr("class", "top_tx_left");
			}
			if ($(this).attr("number") == 3) {
				//点击确定
			}
			if ($(this).attr("number") == 4) {
				//点击取消
				for (var j = 0; j < _round_slide_pics2.length; j++) {
					_round_slide_pics2.eq(j).children(".mask").stop().fadeTo(200, 0.0);
				}
				_round_slide_pics_select2 = false;
			}
		});
	}
	for (var i = 0; i < _round_slide_pics.length; i++) {
		_round_slide_pics.eq(i).children(".mask").fadeTo(100, 0.0).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (!_round_slide_pics_select2) {
				for (var j = 0; j < _round_slide_pics.length; j++) {
					_round_slide_pics.eq(j).children(".mask").stop().fadeTo(200, 0.0);
					_round_slide_pics_select2 = true;
					$(this).stop().fadeTo(100, 0.7);
				}
			} else {
				$(this).stop().fadeTo(100, 0.7);
			}
		}).mouseenter(function () {
			var name = $(this).attr("title");
			var say = $(this).attr("say");
			var re = $(this).attr("re");
			$("#bubble .name").html(name);
			$("#bubble .tx").html("话题"+say+"&nbsp;&nbsp;评论"+re);
			_bubble.css("left", $(this).offset().left - 28).css("top", $(this).offset().top - 60).stop().fadeTo(200, 7.0);
		}).mouseleave(function () {
			_bubble.stop().fadeOut("normal");
		});
	}
	for (var i = 0; i < _round_slide_pics2.length; i++) {
		_round_slide_pics2.eq(i).children(".mask").fadeTo(100, 0.0).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (!_round_slide_pics_select2) {
				for (var j = 0; j < _round_slide_pics2.length; j++) {
					_round_slide_pics2.eq(j).children(".mask").stop().fadeTo(200, 0.0);
					_round_slide_pics_select2 = true;
					$(this).stop().fadeTo(100, 0.7);
				}
			} else {
				$(this).stop().fadeTo(100, 0.7);
			}
		}).mouseenter(function () {
			var name = $(this).attr("title");
			var say = $(this).attr("say");
			var re = $(this).attr("re");
			$("#bubble .name").html(name);
			$("#bubble .tx").html("话题"+say+"&nbsp;&nbsp;评论"+re);
			_bubble.css("left", $(this).offset().left - 28).css("top", $(this).offset().top - 60).stop().fadeTo(200, 7.0);
		}).mouseleave(function () {
			_bubble.stop().fadeOut("normal");
		});
	}
	for (var i = 0; i < _round_small_mask.length; i++) {
		_round_small_mask.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			for (var j = 0; j < _round_small_mask.length; j++) {
				_round_small_mask.eq(j).parent().children(".txt_object").children("div").stop().fadeOut(200);
			}
			_round_single_obejct = $(this).parent().children(".txt_object").children("div");
			_round_single_obejct.stop().fadeToggle(200);
		});
	}
	_round_selection.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_round_selection_out.stop().slideToggle("normal");
	});
	for (var i = 0; i < _round_single_select.length; i++) {
		_round_single_select.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			var _txt = _round_selection.html();
			_round_selection.html($(this).html());
			var number1 = $(this).attr("number");
			var number2 = _round_selection.attr("number");
			_round_selection.attr("number",number1);
			$(this).attr("number",number2);
			$(this).html(_txt);
			if(number2==0){
				$(".round_top_tx").eq(0).html("我加入或关注的圈子");
			}else if(number2==1){
				$(".round_top_tx").eq(0).html("我创建或管理的圈子");
			}
			_round_selection_out.stop().slideToggle("normal");
			ROUND.adminRoundList();
		});
	}
}

//发布变量
function Add_out() {
	var _message_top = $(".message_top");
	var _message_top_tabs = _message_top.children(".tabs").children();
	//发布、消息页面标签
	for (var i = 0; i < _message_top_tabs.length; i++) {
		_message_top_tabs.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			var _number = $(this).attr("number");
			for (var j = 0; j < _message_top_tabs.length; j++) {
				_message_top_tabs.eq(j).attr("class", "tab_normal");
			}
			_message_top_tabs.eq(_number).attr("class", "tab_active");
		});
	}
}

//消息变量
function Add_message() {
	var _reply = '<div class="reply"><div class="reply_right"><div class="reply_middle"><div class="input"><div class="input_right"><div class="input_middle"><input type="text" class="input_style"/><div class="reply_button">回复</div></div></div></div></div></div></div>';
	var _person_main = $(".person_main");
	var _reply_object;
	var _person_middle = _person_main.children(".bottom").children(".middle");
	var _message_person = $(".message_person");
	var _txt_do = _message_person.children(".txt_do");
	var _changeTxt;
	var _select_index;
	for(var i=0;i<_message_person.length;i++){
		_message_person.eq(i).attr("number",i);
	}
	for(var i=0;i<_txt_do.length;i++){
		_txt_do.eq(i).children("span").eq(2).css("color","#000").attr("select","false").mouseover(function(){
			$(this).css("cursor", "pointer");
		}).click(function(){
			_changeTxt = $(this).html();
			_reply_object = $(".reply");
			_reply_object.slideUp("normal");
			if($(this).attr("select")=="false"){
				_reply_object = $(".reply");
				_reply_object.slideUp("normal",function(){
					$(this).remove();
				});
				for(var j=0;j<_txt_do.length;j++){
					_txt_do.eq(j).children("span").eq(2).attr("select","false").html("回复");
				}
				$(this).attr("select","true").html("收起");
				_select_index = $(this).parent().parent().attr("number");
				$(this).parent().parent().after(_reply);
				_reply_object = $(".reply");
				_reply_object.slideDown("normal",function(){
				});
			} else {
				$(this).attr("select","false").html("回复");
			}
		});
	}
}

//好友
function Add_person_fri() {
	var _person_main = $(".person_main");
	var _person_tab_buttons = _person_main.children(".tab_buttons").children();
	var _my_tab = $(".my_tab").children();
	var _fri_txt = $(".fri_txt");
	var _page_button = $(".page_button").children();
	var _pics_object = $(".pics_object");
	var _single_pic = _pics_object.children(".pics").children();
	var _person_pic_select = false;
	var _pics_object_click = false;
	
	for (var i = 0; i < _my_tab.length; i++) {
		_my_tab.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			for (var j = 0; j < _my_tab.length; j++) {
				_my_tab.eq(j).attr("class", "normal");
			}
			if ($(this).attr("class") == "normal") {
				$(this).attr("class", "active");
			}
		});
	}
	
	for (var i = 0; i < _page_button.length; i++) {
		_page_button.eq(i).mouseover(function () {
			if ($(this).attr("class") == "page") {}
			else {
				$(this).css("cursor", "pointer");
			}
		}).click(function () {
			if ($(this).attr("class") == "prev") {
				//点击上一页
			}
			if ($(this).attr("class") == "next") {
				//点击下一页
			}
		});
	}
	_pics_object.mouseenter(function () {
		_pics_object_click = true;
	}).mouseleave(function () {
		_pics_object_click = false;
	});
	$(document).click(function () {
		if (!_pics_object_click) {
			for (var j = 0; j < _single_pic.length; j++) {
				_single_pic.eq(j).children(".single_mask").stop().fadeTo(200, 0.0);
			}
		}
	});
	for (var i = 0; i < _single_pic.length; i++) {
		_single_pic.eq(i).children(".single_mask").fadeTo(200, 0.0);
		_single_pic.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (_pics_object_click) {
				if (!_person_pic_select) {
					for (var j = 0; j < _single_pic.length; j++) {
						_single_pic.eq(j).children(".single_mask").stop().fadeTo(200, 0.5);
					}
					_person_pic_select = true;
				}
				for (var i = 0; i < _single_pic.length; i++) {
					_single_pic.eq(i).children(".single_mask").stop().fadeTo(200, 0.5);
				}
				$(this).children(".single_mask").stop().fadeTo(200, 0.0);
			}
		});
	}
}
function Add_person_fri_list(){
    var _fri_txt = $(".fri_txt");
    _fri_txt.unbind();
    for (var i = 0; i < _fri_txt.length; i++) {
    	_fri_txt.eq(i).attr("number",$('.person_pic .friendPic').eq(i).attr("number"));
		_fri_txt.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			$(this).parent().children(".fri_out").toggle();
			fri_out=$(this).parent().children(".fri_out");
			$(this).parent().children(".fri_out").children('.select_single').remove();
			friId = $(this).attr("number");
			LYD.openLink({
				params:{serviceName:'FriendService',methodName:'is_friend',friendId:friId},
				success:function(msg){
					//好友关系
					if(msg.result.is_fri==1){
						//我关注好友
						if(msg.result.is_attend==1){
							fri_out.append("<div class='select_single' onclick='COMMON.deleteFriend("+friId+")'>删除好友</div><div class='select_single'  onclick='COMMON.deleteAttend("+friId+")'>取消关注</div><div class='select_single' onclick='COMMON.toBlack("+friId+")'>至黑名单</div>");
						}
						else{
							fri_out.append("<div class='select_single' onclick='COMMON.attendFriend("+friId+")'>加入关注</div><div class='select_single' onclick='COMMON.deleteFriend("+friId+")'>删除好友</div><div class='select_single' onclick='COMMON.toBlack("+friId+")'>至黑名单</div>");
						}
					}
					//非好友关系
					else{
						//我关注好友
						if(msg.result.is_attend==1){
							fri_out.append("<div class='select_single' onclick='COMMON.addFriend("+friId+")'>加入好友</div><div class='select_single'  onclick='COMMON.deleteAttend("+friId+")'>取消关注</div><div class='select_single' onclick='COMMON.toBlack("+friId+")'>至黑名单</div>");
						}
						else{
							fri_out.append("<div class='select_single' onclick='COMMON.addFriend("+friId+")'>加入好友</div><div class='select_single' onclick='COMMON.attendFriend("+friId+")'>加入关注</div><div class='select_single' onclick='COMMON.toBlack("+friId+")'>至黑名单</div>");
						}
					}
						$('.select_single').css("cursor","pointer");
				}
			});
		});
	}
}

function person_top_button (){
	var acti_top = $(".acti_top");
	var _private = $("#private");
	var left_tx = acti_top.find(".left_tx");
	var right_tx = acti_top.find(".right_tx");
	var bottom_tx = $(".bottom_tx");
	var save_button = _private.find(".save_button");
	var cancel_button = _private.find(".cancel_button");
	var top_tabs = $("#top_tabs").find("span");
	
	var select_cache;
	
	left_tx.click(function(){
		$("#date_main").stop(true,true).slideToggle(300);
	});
	right_tx.click(function(){
		_private.css("display","block");
		_private.children().css("top",-49).css("bottom","auto");
	});
	bottom_tx.click(function(){
		_private.css("display","block");
		_private.children().css("bottom",-20).css("top","auto");
	});
	save_button.click(function(){
		alert("保存");
	});
	cancel_button.click(function(){
		_private.css("display","none");
	});
	
	for(var i=0;i<top_tabs.length;i++){
		if(top_tabs.eq(i).attr("class")=="active"){
			select_cache = top_tabs.eq(i);
		}
		top_tabs.eq(i).click(function(){
			select_cache.removeAttr("class");
			$(this).attr("class","active");
			select_cache = $(this);
		});
	}
}

function input_top() {
	var _top = $("#message_top_input");
	var _button = _top.find("#send_button_normal");
	_button.click(function(){
		if($(this).attr("id")=="send_button_normal"){
			$(this).attr("id","send_button_active");
		} else {
			$(this).attr("id","send_button_normal");
		}
	});
}
