$(document).ready(function () {
	public_round_activity();
	public_left_button();
	public_round_temp();
	public_round_fabu();
	public_round_top();
//	Add_public_round();
//	Add_nevigation();
	//Add_head_pic();
	addMore_banner();
//	addStatus();
//	addRoundDocument();
	setActiveBanner();
	
});

var shareId;
var messageShareId;
var replyId="";
var type=-1;
var click_type;

//状态框显示
function addStatus(){
	var _pic_upload_mask = $(".pic_upload_mask");
	var _zhuangtai_box = 
		'<div class="zhuangtai_box">'+
        	'<div class="main_box">'+
            	'<div class="cancel"></div>'+
                '<div class="fabu_button"></div>'+
                '<div class="at"></div>'+
            '</div>'+
        '</div>'+
        '<div class="notice_user">'+
        	'<div class="notice_top"></div>'+
        '</div>';
	_pic_upload_mask.after(_zhuangtai_box);
	$('.width .id_person_box_main .icons .zhuangtai').click(function(){
		$('.width .zhuangtai_box').slideToggle(200);
		$('.notice_user').css('display','none');
	})
	$('.width .zhuangtai_box .main_box .cancel').click(function(){
		$('.width .zhuangtai_box').slideUp(200);
		$('.notice_user').css('display','none');
	})
	$('.width .zhuangtai_box .main_box .fabu_button').click(function(){
		COMMON.speak();
	})
	$('.width .zhuangtai_box .main_box .at').click(function(){
		$('.notice_user').slideToggle(200);
		var old_text=$('.input_box').val();
		$('.input_box').val(old_text+'@');
	})
	$('.width .notice_user .user_line .user_name').click(function(){
		var inform=$(this).html();
		var old_text=$('.input_box').val();
		$('.input_box').val(old_text+inform+' ');
		$('.notice_user').slideUp(200);
	})
	$('.input_box').keydown(function(e){
		if((e.keyCode == 50&&e.shiftKey)||e.keyCode == 64){$('.notice_user').slideDown(200)}
	})
}

function addMore_banner(){
	$(".more_banner").mouseover(function(){
		$(this).css("cursor", "pointer");
	}).click(function(){
		var class_pic = $(".class_pic");
		var more_banner = $(this);
		var num = class_pic.attr("num");
		class_pic.attr("num",++num);
		var tid = more_banner.attr("no");
		R.getRoundList(tid,num);
	});
}

//活动内容
function public_round_activity() {
	var _letter_top_array = $("#main .public_width .letter_top");
	var _letter_top_activity;
	for (var i = 0; i < _letter_top_array.length; i++) {
		if (_letter_top_array.eq(i).attr("activity") == "click") {
			_letter_top_activity = _letter_top_array.eq(i).children(".letter_bottom").children(".letter_middle").children(".letter_activity_block").children(".info");
			_letter_top_activity.children(".button_xiangying").mouseover(function () {
				$(this).css("cursor", "pointer");
			}).click(function () {
				alert("click_xiangying");
			});
			_letter_top_activity.children(".button_chakan").mouseover(function () {
				$(this).css("cursor", "pointer");
			}).click(function () {
				alert("click_chakan");
			});
		}
	}
}
//左侧按钮
function public_left_button() {
	var _out_object = $("#main .public_width ._out_object");
	var _creat_object = $("#main .public_width .creat_object");
	var _locker_object = $("#main .public_width .locker_object");
	var _person = $("#main .public_width .person");
	var _left_button = $("#main .public_width .left_button");
	var _left_button_array = _left_button.children("div");
	var _acti_top = $(".acti_top");
	var _single_object = $(".single_object");
	var _custom_select = false;
	var _person_search;
	var _person_select_number;
	for(var i=0;i<_single_object.length;i++){
		_single_object.eq(i).mouseenter(function(){
			_custom_select = true;
		}).mouseleave(function(){
			_custom_select = false;
		}).mouseover(function(){
			$(this).css('cursor','pointer');
		}).click(function(){
			if(_custom_select){
				$(this).children('.single_mask').fadeTo(100,0.0);
			}
		}).children('.single_mask').fadeTo(100,0.5);
	}
	$(document).click(function(){
		if(!_custom_select){
			for(var j=0;j<_single_object.length;j++){
				_single_object.eq(j).children('.single_mask').fadeTo(100,0.5);
			}
		}
	});
	for (var i = 0; i < _left_button_array.length; i++) {
		_left_button_array.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "left_button_fabu") {
				//点击发布
				_out_object.slideDown("normal");
			}
			if ($(this).attr("class") == "left_button_locker") {
				//点击locker
				_creat_object.slideUp("normal");
				_locker_object.slideDown("normal");
				$(this).attr("class", "left_button_locker_close");
			} else if ($(this).attr("class") == "left_button_locker_close") {
				//点击locker关闭
				_creat_object.slideDown("normal");
				_locker_object.slideUp("normal");
				$(this).attr("class", "left_button_locker");
			}
			if ($(this).attr("class") == "acti_custom") {
				//点击自定义
				if(_acti_top.css('display')=='block'){
					_acti_top.slideUp();
				} else {
					_acti_top.slideDown();
				}
			}
		});
	}
	for (var i = 0; i < _person.length; i++) {
		if (_person.eq(i).attr("tab") == "click") {
			_person_search = _person.eq(i).children("div");
			for (var j = 0; j < _person_search.length; j++) {
				_person_search.eq(j).attr("number", j).mouseover(function () {
					$(this).css("cursor", "pointer");
				}).click(function () {
					_person_select_number = $(this).attr("number");
					for (var l = 0; l < _person_search.length; l++) {
						if (_person_search.eq(l).attr("number") == _person_select_number) {
							_person_search.eq(l).attr("class", "person_search_active");
						} else {
							_person_search.eq(l).attr("class", "person_search");
						}
					}
				});
			}
		}
	}
}


//公共圈子方法
function Add_public_round() {
	var _document_objects = $("*");
	var _tab_button = $("#main .width .tab_button");
	var _tab_buttons = _tab_button.children("div");
	var _class_pic = $("#main .width .class_pic");
	var _class_pic_pics = _class_pic.children(".pics_scroll");
	var _pics_main;
	var _class_pic_pics_on;
	var _pics_border_top;
	var _pics_button_cha;
	var _pics_button_guan;
	var _pics_static = 210;
	var _pics_static_y = 240;
	var _pics_x = 70;
	var _pics_x_other = 70;
	var _pics_y = 0;
	var _pics_change = 4;
	var _pics_box_height = 0;
	var _public_main_height;
	var _letter_number = $("#main .public_width .letter_top");
	var _letter_x1 = 0;
	var _letter_x2 = 390;
	var _letter_y1 = 0;
	var _letter_y2 = 0;
	var _public_main = $("#main .width .public_main");
	var _public_width = $("#main .public_width");
	var _message_object = _public_width.children(".message_object");
	var _class_tab = $("#main .width .class_tab");
	var _letter_main = $(".letter_main");
	var _link_array = $(".link");
	var _talk_array = $(".talk");
	var _drag_ball_array = $(".drag_ball");
	var _drag_ball_array_select;
	var _message_object = $(".message_object");
	var _close = _message_object.children(".single").children(".close");
	var _next = _message_object.children(".single").children(".next")
		var _message_object_x;
	var _message_object_y;
	var _message_select_object;
	var _message_select_number;
	var _select_talk_number;
	var _message_select_x;
	var _message_select_y;
	var _message_x;
	var _message_y;
	var _drag_object = $("#main .drag_object");
	var _drag_object_array = _drag_object.children("div");
	var _drag_object_select;
	var _drag_object_x;
	var _drag_object_y;
	var _drag_select_x;
	var _drag_select_y;
	var _drag_control = false;
	var _drag_object_up;
	//指定分享变量
	var _shareto_object = $("#main .shareto_object");
	var _shareto_top = _shareto_object.children("shareto_top");
	var _shareto_main = _shareto_top.children(".shareto_main");
	var _shareto_main_close = $(".close");
	var _input_sub = $(".sub");
	var _shareto_tab_button = $(".tab").children("div");
	var _shareto_tab_select;
	var _letter_top_array = $("#main .letter_top");
	var _person_middle = $(".person_main .bottom .middle");
	var _person_middle_height = 0;
	//round增加
	var _timerCache;
	//round增加
	for (var i = 0; i < _letter_top_array.length; i++) {
		_person_middle_height += _letter_top_array.eq(i).outerHeight();
	}
	_person_middle.css("height", _person_middle_height + 30);
	
	for (var i = 0; i < _tab_buttons.length; i++) {
		_tab_buttons.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			location.href=$(this).children("a").attr("href");
		});
	}
	for (var i = 0; i < _class_pic_pics.length; i++) {
		_class_pic_pics.eq(i).children(".pics_main").children(".pics_border_top").mouseenter(function () {
			$(this).css("cursor", "pointer");
			_class_pic_pics_on = $(this).parent().parent();
			_pics_main = $(this).parent();
			_pics_border_top = _pics_main.children(".pics_border_top");
			_pics_button_cha = _pics_border_top.children(".pics_button_cha");
			_pics_button_guan = _pics_border_top.children(".pics_button_guan");
			_class_pic_pics_on.css("z-index", "1");
			_class_pic_pics_on.animate({
				"width" : "+=40",
				"height" : "+=70",
				"left" : "-=20",
				"top" : "-=20"
			}, 0);
			_pics_main.animate({
				"left" : "+=20",
				"top" : "+=20"
			}, 0);
			_pics_button_cha.click(function () {
				//点击查看
			});
			_pics_button_guan.click(function () {
				//点击关注
			});
		}).mouseleave(function () {
			_class_pic_pics_on.animate({
				"width" : "-=40",
				"height" : "-=70",
				"left" : "+=20",
				"top" : "+=20"
			}, 0);
			_pics_main.animate({
				"left" : "-=20",
				"top" : "-=20"
			}, 0);
			_class_pic_pics_on.css("z-index", "0");
		});
	}
	for (var i = 0; i < _class_pic_pics.length; i++) {
		_class_pic_pics.eq(i).attr("number", i);
		if (i == 0) {
			_class_pic_pics.eq(i).css("left", _pics_x).css("top", _pics_y);
			_pics_x += _pics_static;
		} else if (i % _pics_change == 0) {
			_pics_y += _pics_static_y;
			_class_pic_pics.eq(i).css("left", _pics_x_other).css("top", _pics_y);
			_pics_x = _pics_x_other;
			_pics_x += _pics_static;
			_pics_box_height++;
		} else {
			_class_pic_pics.eq(i).css("left", _pics_x).css("top", _pics_y);
			_pics_x += _pics_static;
		}
	}
	for (var i = 0; i < _letter_number.length; i++) {
		if (_letter_y1 == _letter_y2) {
			_letter_number.eq(i).css("left", _letter_x1).css("top", _letter_y1);
			_letter_y1 += _letter_number.eq(i).outerHeight();
		} else if (_letter_y1 > _letter_y2) {
			_letter_number.eq(i).css("left", _letter_x2).css("top", _letter_y2);
			_letter_y2 += _letter_number.eq(i).outerHeight();
		} else {
			_letter_number.eq(i).css("left", _letter_x1).css("top", _letter_y1);
			_letter_y1 += _letter_number.eq(i).outerHeight();
		}
	}
	_letter_main.css("height", _letter_y1 > _letter_y2 ? _letter_y1 : _letter_y2);
	_public_main_height = _class_tab.outerHeight(true) + 55 + 241.5 * (_pics_box_height + 1);
	_public_main.css("height", _public_main_height);
	for (var i = 0; i < _drag_ball_array.length; i++) {
		_drag_ball_array.eq(i).attr("number", i);
	}
	_shareto_main_close.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_drag_object_up = 0;
		_shareto_object.slideUp(300);
	})
	
	_input_sub.unbind();
	_input_sub.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		R.shareMessageToRound();
	});
	for (var i = 0; i < _shareto_tab_button.length; i++) {
		_shareto_tab_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_shareto_tab_select = $(this).attr("number");
			for (var j = 0; j < _shareto_tab_button.length; j++) {
				if (_shareto_tab_button.eq(j).attr("number") == _shareto_tab_select) {
					_shareto_tab_button.eq(j).attr("class", "tab_active");
					//自定义圈子
				} else {
					_shareto_tab_button.eq(j).attr("class", "tab_normal");
					//我的好友
				}
			}
		});
	}
	
	_close.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_message_object.slideUp("normal");
	});
	_next.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//点击下一页
	});
	var _pic_main_pic = $(".pic_main").children();
	for (var i = 0; i < _pic_main_pic.length; i++) {
		_pic_main_pic.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).children(".select_icon").css("display") == "none") {
				$(this).children(".select_icon").show();
			} else {
				$(this).children(".select_icon").hide();
			}
		});
	}
	for (var i = 0; i < _link_array.length; i++) {
		_link_array.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).mousedown(function (e) {
			//点击link
			shareId = $(this).attr("no");
			_drag_ball_array_select = $(this).attr("number");
			_drag_ball_array.eq(_drag_ball_array_select).slideDown("200");
			if (_message_object.attr("position") == "person") {
				_drag_object_x = _letter_main.position().left - 9;
				_drag_object_y = _letter_main.position().top - 52;
			} else {
				_drag_object_x = _letter_main.position().left + 234;
				_drag_object_y = _letter_main.position().top + 15;
			}
			var y = e.pageY - 150;
			var x = e.pageX - 140;
			_drag_control = true;
			_drag_object_select = $(this).parent().parent().parent().parent().parent();
			_document_objects.css("-moz-user-select", "none");
			$(document).bind("selectstart", function () {
				return false;
			}).bind("mousemove", function (e) {
				_drag_ball_array.eq(_drag_ball_array_select).slideUp("200");
				if (_drag_control) {
					_drag_select_x = _drag_object_x + _drag_object_select.position().left + _drag_object_select.outerWidth() - 212;
					_drag_select_y = _drag_object_y + _drag_object_select.position().top + _drag_object_select.outerHeight() - 201;
					_drag_object.css("left", _drag_select_x).css("top", _drag_select_y);
					_drag_object.slideDown("normal");
					_drag_object_array.eq(4).css("top", e.pageY - y).css("left", e.pageX - x);
					if (_drag_object_array.eq(4).position().left < 0) {
						_drag_object_array.eq(4).css("left", 0);
					}
					if (_drag_object_array.eq(4).position().left > 158) {
						_drag_object_array.eq(4).css("left", 158);
					}
					if (_drag_object_array.eq(4).position().top > 146) {
						_drag_object_array.eq(4).css("top", 146);
					}
					if (_drag_object_array.eq(4).position().top < 0) {
						_drag_object_array.eq(4).css("top", 0);
					}
					if (_drag_object_array.eq(4).position().top < 54 && _drag_object_array.eq(4).position().left > 150 || _drag_object_array.eq(4).position().top < 7 && _drag_object_array.eq(4).position().left > 103) {
						_drag_object_up = 4;
						//round增加
						if(_timerCache==null){
							_timerCache = setDragTimer(_drag_object_up);
						}
						//round增加
					} else if (_drag_object_array.eq(4).position().left > 84 && _drag_object_array.eq(4).position().left < 132 && _drag_object_array.eq(4).position().top < 77) {
						_drag_object_up = 3;
						//round增加
						if(_timerCache==null){
							_timerCache = setDragTimer(_drag_object_up);
						}
						//round增加
					} else if (_drag_object_array.eq(4).position().top > 79 && _drag_object_array.eq(4).position().top < 130 && _drag_object_array.eq(4).position().left < 82) {
						_drag_object_up = 2;
						//round增加
						if(_timerCache==null){
							_timerCache = setDragTimer(_drag_object_up);
						}
						//round增加
					} else if (_drag_object_array.eq(4).position().top > 96 && _drag_object_array.eq(4).position().top < 150 && _drag_object_array.eq(4).position().left < 52) {
						_drag_object_up = 1;
						//round增加
						if(_timerCache==null){
							_timerCache = setDragTimer(_drag_object_up);
						}
						//round增加
					} else {
						_drag_object_up = 0;
						//round增加
						var _dragCache = $(".DragText");
						_dragCache.remove();
						_timerCache = null;
						//round增加
					}
				}
			}).mouseup(function () {
				//round更改
				$(this).unbind();
				//round更改
				_document_objects.css("-moz-user-select", "auto");
				_drag_object.slideUp("normal");
				_drag_control = false;
				if (_drag_object_up == 4) {
					//locker
				} else if (_drag_object_up == 3) {
					//drag_share_static
					//将分享面板修改为分享给圈子
					var main = $(".shareto_main");
					var title = main.children(".title");
					var tab = main.children(".tab");
					title.html("指定分享给好友");
					main.attr("number",0);
					tab.html("<div class='tab_active' number='0' style='cursor: pointer;'>固定圈子</div><div class='tab_normal' number='1' style='cursor: pointer;'>活动圈子</div>");
					if(_shareto_object.css("display")=="none"){
						main.children(".pic_page").attr("num",1);
						/*
						 * 取消绑定
						 */
						var _pic_page = $(".shareto_object .shareto_top .pic_page");
						_pic_page.children("a").unbind("mousemove").unbind("click");
						pic_page_click();
						
						R.shareRoundList();
						main.children(".tab").children(".tab_normal").click(function (){
							$(".tab_active").attr("class","tab_normal");
							$(".tab_normal").attr("class","tab_active");
						});

					}
					if (_message_object.attr("position") == "person") {
						var _left = 130;
						var _top = _drag_object_select.position().top + _letter_main.position().top + _drag_object_select.outerHeight() - 450;
					} else {
						var _left = 250;
						var _top = _drag_object_select.position().top + _letter_main.position().top + _drag_object_select.outerHeight() - 400;
					}
					_shareto_object.css("left", _left).css("top", _top);
					_shareto_object.slideDown(300);
					
				} else if (_drag_object_up == 2) {
					//drag_share_to
					//将分享面板修改为分享给人
					var main = $(".shareto_main");
					var title = main.children(".title");
					var tab = main.children(".tab");
					title.html("指定分享给好友");
					main.attr("number",1);
					tab.html("<div class='tab_active' number='0' style='cursor: pointer;'>全部好友</div>");
					if(_shareto_object.css("display")=="none"){
						main.children(".pic_page").attr("num",1);
						/*
						 * 取消绑定
						 */
						var _pic_page = $(".shareto_object .shareto_top .pic_page");
						_pic_page.children("a").unbind("mousemove").unbind("click");
						pic_page_click_friend();
						
						R.shareFirendList();
						main.children(".tab").children(".tab_normal").click(function (){
							$(".tab_active").attr("class","tab_normal");
							$(".tab_normal").attr("class","tab_active");
						});

					}
					
					if (_message_object.attr("position") == "person") {
						var _left = 130;
						var _top = _drag_object_select.position().top + _letter_main.position().top + _drag_object_select.outerHeight() - 450;
					} else {
						var _left = 250;
						var _top = _drag_object_select.position().top + _letter_main.position().top + _drag_object_select.outerHeight() - 400;
					}
					_shareto_object.css("left", _left).css("top", _top);
					_shareto_object.slideDown(300);
				} else if (_drag_object_up == 1) {
					//drag_share_all
				}
			});
		});
	}
	for (var i = 0; i < _talk_array.length; i++) {
		_talk_array.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			//点击talk
			if(messageShareId!=$(this).attr("no")){
				$(".message_object").attr("num",1);
			}
			messageShareId = $(this).attr("no");
			if (_message_object.attr("position") == "person") {
				_message_object_x = _letter_main.position().left - 15;
				_message_object_y = _letter_main.position().top + 8;
			} else {
				_message_object_x = _letter_main.position().left + 238;
				_message_object_y = _letter_main.position().top + 15;
			}
			if (_message_object.css("display") == "block") {
				R.reply();
				_message_select_object = $(this).parent().parent().parent().parent().parent();
				_select_talk_number = $(this).attr("number");
				if (_message_select_object.attr("number") == _message_select_number) {
					_message_object.slideUp("normal");
				} else {
					_message_object.slideUp("normal", function () {
						_message_select_x = _message_select_object.position().left;
						_message_select_y = _message_select_object.position().top;
						_message_x = _message_object_x + _message_select_x;
						_message_y = _message_object_y + _message_select_y + _message_select_object.outerHeight() - 3;
						_message_object.css("left", _message_x).css("top", _message_y).slideDown("normal");
						_message_select_object.attr("number", _select_talk_number);
						_message_select_number = _select_talk_number;
					});
				}
			} else {
				R.reply();
				_message_select_object = $(this).parent().parent().parent().parent().parent();
				_message_select_x = _message_select_object.position().left;
				_message_select_y = _message_select_object.position().top;
				_message_x = _message_object_x + _message_select_x;
				_message_y = _message_object_y + _message_select_y + _message_select_object.outerHeight() - 3;
				_message_object.css("left", _message_x).css("top", _message_y).slideDown("normal");
				_message_select_object.attr("number", $(this).attr("number"));
				_message_select_number = $(this).attr("number");
			}
		});
	}
}

//临时活动圈子变量
function public_round_temp() {
	var _border_txt = $("#main .temporary_main .top_object .border_txt");
	var _border_txt_array = _border_txt.children("div");
	var _border_txt_select;
	var _top_object = $("#main .temporary_main .top_object");
	var _temporary_pics = $("#main .temporary_main .top_object .pic_main").children("div");
	var _temp_single_width = _temporary_pics.eq(0).outerWidth();
	var _temp_pic_number = 0;
	
	_top_object.children("._left").mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (_temp_pic_number > 0) {
			_temporary_pics.parent().animate({
				"left" : "+=103px"
			}, 500);
			_temp_pic_number--;
		}
	});
	_top_object.children("._right").mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (_temp_pic_number < (_temporary_pics.length - 6)) {
			_temporary_pics.parent().animate({
				"left" : "-=103px"
			}, 500);
			_temp_pic_number++;
		}
	});
	//last;
	for (var i = 0; i < _border_txt_array.length; i++) {
		_border_txt_array.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_border_txt_select = $(this).attr("number");
			for (var j = 0; j < _border_txt_array.length; j++) {
				if (_border_txt_array.eq(j).attr("number") == _border_txt_select) {
					_border_txt_array.eq(j).attr("class", "txt_active");
				} else if (_border_txt_array.eq(j).attr("class") != "clear") {
					_border_txt_array.eq(j).attr("class", "txt");
				}
			}
		});
	}
}

//发布变量
function public_round_fabu() {
	//发布变量
	var _out_object = $("#main .public_width ._out_object");
	var _out_object_buttons = _out_object.children(".tab_object").children("div");
	var _outclose = _out_object.children("._outclose");
	var _outbutton = _out_object.children("._button");
	var _slide_video = _out_object.children(".slide_video");
	var _slide_video_button = _slide_video.children(".yes_button");
	var _slide_audio = _out_object.children(".slide_audio");
	var _slide_audio_child = _out_object.children(".slide_audio_child");
	var _slide_audio_button = _slide_audio.children(".yes_button");
	var _slide_image = _out_object.children(".slide_image");
	var _slide_image_button = _slide_image.children(".up_load_button");
	var _slide_docm = $("#document");
	_slide_video_button.mouseover(function(){
		$(this).css("cursor", "pointer");
	}).click(function(){
		//视频确定按钮
		R.videoInfo();
		type=0;
	});
	_slide_audio_button.mouseover(function(){
		$(this).css("cursor", "pointer");
	}).click(function(){
		_slide_audio.slideUp("normal");
		_slide_audio_child.slideDown(200);
	});
	_slide_image_button.mouseover(function(){
		$(this).css("cursor", "pointer");
	}).click(function(){
		//点击本地上传
		if($(".up_load_pic").length>0){
			$("#main .public_width ._out_object .input .input_style").val("#分享图片#");
			type=2;	
			_slide_image.slideUp(200);
		}else{
			LYD.Alert("message","提示","未上传图片");
		}
		
	});
	_outclose.mouseover(function(){
		$(this).css("cursor", "pointer");
	}).click(function(){
		if(_slide_video.css("display")=="block"){
			_slide_video.slideUp(200,function(){
				_out_object.slideUp("normal");
			});
		} else if(_slide_audio.css("display")=="block"){
			_slide_audio.slideUp(200,function(){
				_out_object.slideUp("normal");
			});
		} else if(_slide_image.css("display")=="block"){
			_slide_image.slideUp(200,function(){
				_out_object.slideUp("normal");
			});
		} else if(_slide_audio_child.css("display")=="block"){
			_slide_audio_child.slideUp(200,function(){
				_out_object.slideUp("normal");
			});
		} else if(_slide_docm.css("display")=="block"){
			_slide_docm.slideUp(200,function(){
				$('.black').css("display","none");
				_out_object.slideUp("normal");
			});
		} else {
			_out_object.slideUp("normal");
		}
	});
	_outbutton.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		R.sendRoundMessage();
	});
	$('#main .public_width ._out_object .slide_audio_child .yes_button').click(function(){
		$("#main .public_width ._out_object .input .input_style").val("#分享音乐#");
		type=1;
		_slide_audio_child.slideUp(200);
	})
	$('#main .public_width ._out_object .slide_audio_child .no_button').click(function(){
		_slide_audio_child.slideUp(200);
	})
	for(var i=0;i<_out_object_buttons.length;i++){
		_out_object_buttons.eq(i).mouseover(function(){
			$(this).css("cursor", "pointer");
		}).click(function(){
			if($(this).attr("class")=="_out_video"){
				click_type=0;
				if(_slide_audio.css("display")=="block"){
					_slide_audio.slideUp(200,function(){
						_slide_video.slideDown(200);
					});
				} else if(_slide_image.css("display")=="block"){
					_slide_image.slideUp(200,function(){
						_slide_video.slideDown(200);
					});
				}else if(_slide_audio_child.css("display")=="block"){
					_slide_audio_child.slideUp(200,function(){
						_slide_video.slideDown(200);
					});
				}else if(_slide_docm.css("display")=="block"){
					_slide_docm.slideUp(200,function(){
						$('.black').css("display","none");
						_slide_video.slideDown(200);
					});
				}   else {
					_slide_video.slideToggle(200);
				}
			} else if($(this).attr("class")=="_out_audio"){
				click_type=1;
				if(_slide_video.css("display")=="block"){
					_slide_video.slideUp(200,function(){
						_slide_audio.slideDown(200);
					});
				} else if(_slide_image.css("display")=="block"){
					_slide_image.slideUp(200,function(){
						_slide_audio.slideDown(200);
					});
				} else if(_slide_audio_child.css("display")=="block"){
					_slide_audio_child.slideUp(200,function(){
						_slide_audio.slideDown(200);
					});
				} else if(_slide_docm.css("display")=="block"){
					_slide_docm.slideUp(200,function(){
						$('.black').css("display","none");
						_slide_audio.slideDown(200);
					});
				} else {
					_slide_audio.slideToggle(200);
				}
			} else if($(this).attr("class")=="_out_image"){
				click_type=2;
				if(_slide_video.css("display")=="block"){
					_slide_video.slideUp(200,function(){
						_slide_image.slideDown(200);
					});
				} else if(_slide_audio.css("display")=="block"){
					_slide_audio.slideUp(200,function(){
						_slide_image.slideDown(200);
					});
				} else if(_slide_audio_child.css("display")=="block"){
					_slide_audio_child.slideUp(200,function(){
						_slide_image.slideDown(200);
					});
				} else if(_slide_docm.css("display")=="block"){
					_slide_docm.slideUp(200,function(){
						$('.black').css("display","none");
						_slide_image.slideDown(200);
					});
				} else {
					_slide_image.slideToggle(200);
				}
			}else if($(this).attr("class")=="_out_docm"){
				if(_slide_video.css("display")=="block"){
					_slide_video.slideUp(200,function(){
						_slide_docm.slideDown(200);
						$('.black').css("height",document.body.scrollHeight+250+'px').css("display","block");
						if($('.black').height()<1000){$('.black').css("height",document.documentElement.scrollHeight+250+'px')}
					});
				} else if(_slide_image.css("display")=="block"){
					_slide_image.slideUp(200,function(){
						_slide_docm.slideDown(200);
						$('.black').css("height",document.body.scrollHeight+250+'px').css("display","block");
						if($('.black').height()<1000){$('.black').css("height",document.documentElement.scrollHeight+250+'px')}
					});
				} else if(_slide_audio_child.css("display")=="block"){
					_slide_audio_child.slideUp(200,function(){
						_slide_docm.slideDown(200);
						$('.black').css("height",document.body.scrollHeight+250+'px').css("display","block");
						if($('.black').height()<1000){$('.black').css("height",document.documentElement.scrollHeight+250+'px')}
					});
				} else if(_slide_audio.css("display")=="block"){
					_slide_audio.slideUp(200,function(){
						_slide_docm.slideDown(200);
						$('.black').css("height",document.body.scrollHeight+250+'px').css("display","block");
						if($('.black').height()<1000){$('.black').css("height",document.documentElement.scrollHeight+250+'px')}
					});
				} else {
					_slide_docm.slideToggle(200);
					$('.black').css("height",document.body.scrollHeight+250+'px')
					if($('.black').height()<1000){$('.black').css("height",document.documentElement.scrollHeight+250+'px')}
					$('.black').slideToggle(200);
					
				}
			}
		});
	}
	$('#main .public_width ._out_object .tab_object ._out_lock_before').click(function(){
			if($(this).attr("class")=="_out_lock_front"){
				$(this).attr("class","_out_lock_before");
			} else {
				$(this).attr("class","_out_lock_front");
			}
		});
	
	$('.right_panel_lock').toggle(function(){
		this.style.background="url('front/images/round/lock.png') no-repeat";},function(){
		this.style.background="url('front/images/round/lock_after_doc.png') no-repeat";})
}

//头条文字变量
function public_round_top() {
	var _info_border_top = $("._info_border_top");
	var _info_border_middle = _info_border_top.children("._info_border_bottom").children("._info_border_middle");
	var _info_main_txt = _info_border_middle.children(".main_txt");
	var _info_height = _info_main_txt.children("div");
	var _info_border_slide_button = _info_border_middle.children(".slide_down");
	var _slide_sign = false;
	var _info_border_slide_button_txt = _info_border_slide_button.html();
	var _xiangying_ac = $(".xiangying_ac");
	var _guanzhu_ac = $(".guanzhu_ac");
	_xiangying_ac.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		$(this).attr("class", "xiangying_ac_active");
		$(this).html("已响应");
	});
	_guanzhu_ac.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		$(this).attr("class", "guanzhu_ac_active");
		$(this).html("已关注");
	});
	_info_border_slide_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (!_slide_sign) {
			_info_main_txt.animate({
				"height" : _info_height.outerHeight()
			}, 500, function () {
				_slide_sign = true;
			});
			$(this).html("收起");
		} else {
			_info_main_txt.animate({
				"height" : 77
			}, 500, function () {
				_slide_sign = false;
			});
			$(this).html(_info_border_slide_button_txt);
		}
	});
}

function setActiveBanner(){
	var _letter_pictures_block = $(".letter_pictures_block");
	var _text = _letter_pictures_block.find(".text");
	for(var i=0;i<_text.length;i++){
		_text.eq(i).mouseenter(function(){
			$(this).find("span").attr("class","active");
		}).mouseleave(function(){
			$(this).find("span").attr("class","normal");
		});
	}
	for(var i=0;i<_letter_pictures_block.length;i++){
		_letter_pictures_block.eq(i).mouseenter(function(){
			$(this).find(".active_banner").stop(true,true).fadeTo(100,0.4);
		}).mouseleave(function(){
			$(this).find(".active_banner").stop(true,true).fadeOut(100);
		});
	}
}


//临时头部图片
function setTempPic(){
	var _temp_pics = $("#main .temporary_main .top_object .pic_main").children("div");
	var _cache;
	for(var i=0;i<_temp_pics.length;i++){
		_temp_pics.eq(i).click(function(){
			if(_cache!=null){
				_cache.css("border","none").css("height","109px").css("width","82px");
			}
			_cache = $(this).find("img").css("border","2px solid #fff").css("height","105px").css("width","78px");
			var roundId = $(this).attr("no");
			R.adviceActivityRoundInfo(roundId);
		})
	}
}

//round增加
function setDragTimer(_number) {
	var _timer = setTimeout("setDragText("+_number+")", 700);
	return _timer;
}

function setDragText(_type) {
	var _drag_object = $("#main .drag_object");
	switch(_type){
		case 4:
			_drag_object.append('<div class="DragText" style="position:absolute; left:70px; top:-30px;"><img src="front/images/round/dragtext_4.png" width="92" height="35" /></div>');
			break;
		case 3:
			_drag_object.append('<div class="DragText" style="position:absolute; left:-30px; top:34px;"><img src="front/images/round/dragtext_3.png" width="99" height="35" /></div>');
			break;
		case 2:
			_drag_object.append('<div class="DragText" style="position:absolute; left:-74px; top:90px;"><img src="front/images/round/dragtext_2.png" width="99" height="35" /></div>');
			break;
		case 1:
			_drag_object.append('<div class="DragText" style="position:absolute; left:-118px; top:151px;"><img src="front/images/round/dragtext_1.png" width="114" height="35" /></div>');
			break;
	}
}
//round增加