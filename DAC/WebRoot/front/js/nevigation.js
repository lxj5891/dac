//导航方法
function Add_nevigation() {
	var _school_ten = $("#school_ten");
	var _school_ten_main_icon = $("#school_ten_main_icon");
	var _hot_toggle = $("#hot_toggle");
	
	//导航变量
	var top_button = $("#top .width .txt_width .txt > span").children();
	var top_right_button = $(".width .top_button > div");
	var top_right_menu1_display = top_right_button.eq(0);
	var top_right_menu2_display = top_right_button.eq(1);
	var top_right_menu1 = top_right_menu1_display.children(".top_button1_menu");
	var top_right_menu2 = top_right_menu2_display.children(".top_button2_menu");
	var top_right_menu2_active = top_right_menu2.children(".active").children(".ul");
	var top_right_menu_bg = top_right_menu1.children(".top_button1_menu_bg");
	var top_right_menu_bg_main = top_right_menu1.children(".top_button1_menu_bg_main");
	var _right_button1 = top_right_button.eq(2);
	var _right_button2 = top_right_button.eq(3);
	var _right_button3 = top_right_button.eq(4);
	var _right_control1 = false;
	var _right_control2 = false;
	var _id_box_exit = false;
	var activity_mask = $("#activity_mask");
	var activity_mask_remove = $("#remove_mask_button");
	var activity_mask_button = activity_mask_remove.children("#activity_mask_button");
	
	//登陆注册变量
	var id_box = $(".id_box");
	var id_border = id_box.children(".id_border");
	var id_person_box = $(".id_person_box");
	var id_person_box_border = id_person_box.children(".id_person_box_border");
	var id_buttons = id_person_box.children(".id_person_box_main").children(".icons").children("div");
	var id_logo = $(".logo");
	var id_check = $(".id_check");
	var id_check_control = false;
	var id_login = $(".id_login");
	var id_reg = $(".id_reg");
	
	//地图
	var map_tab = $(".map .tab");
	var getFriends_icon = $(".friends_icon");
	
	//locker变量
	var _locker = $("#locker");
	
	var _acfr_main = $(".acfr_main");
	
	Add_topButton();
	Add_topRight_button();
	Add_idAnimate();
	
	
	//判断是否登录
	var cookie_email = $.cookie('combo_checked_user_email');
	if(cookie_email!=null){
		$(".id_login").click();
	}
	else{
//		$(".logo").eq(0).click();
	}
	
	
	
	
	
	//导航左侧按钮方法
	function Add_topButton() {
		for (var i = 0; i < top_button.length; i++) {
			top_button.eq(i).mouseover(function () {
				$(this).css("cursor", "pointer");
				var z = $(this).position().left - 15;
				$(".top_hover").stop().animate({
					"left" : z
				}, "fast");
			}).click(function(){
				switch($(this).attr("class")){
					case "zuobiao":
						window.location.href = "index.do";
						break;
					case "geren":
						window.location.href = "home.do";
						break;
					case "quanzi":
						var email = $.cookie('combo_checked_user_email');
						if(email==null){
							window.location.href = "round.do";
						}else{
							window.location.href = "rdetail.do?roundId=1";
						}
						
						break;
				}
			});;
		}
	}
	
	
	
	
	//导航右侧按钮方法
	function Add_topRight_button() {
		top_right_menu_bg.fadeTo(10, 0.9);
		top_right_menu_bg_main.fadeTo(10, 0.9);
		_right_button1.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (id_box.attr("out") == "false") {
				if (!_right_control1) {
					top_right_menu1_display.slideDown("normal");
					_right_control1 = true;
				} else {
					top_right_menu1_display.slideUp("normal");
					_right_control1 = false;
				}
				if (_right_control2) {
					top_right_menu2_display.slideUp("normal");
					top_right_menu1_display.slideDown("normal");
					_right_control2 = false;
				}
			}
		});
		_right_button2.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (id_box.attr("out") == "false") {
				if (!_right_control2) {
					top_right_menu2_display.slideDown("normal");
					_right_control2 = true;
				} else {
					top_right_menu2_display.slideUp("normal");
					_right_control2 = false;
				}
				if (_right_control1) {
					top_right_menu1_display.slideUp("normal");
					top_right_menu2_display.slideDown("normal");
					_right_control1 = false;
				}
			}
		});
		_right_button3.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (_id_box_exit) {
				id_person_box.animate({
					"top" : "-263"
				}, "500", function () {
					id_box.animate({
						"top" : "0"
					}, "500");
				});
				map_tab.slideUp("normal");
				if (getFriends_icon.css("display") == "block") {
					_acfr_main.animate({
						"left" : "0"
					}, 500);
					if (!map_button_control) {
						map_block.animate({
							"left" : "19"
						}, 500);
						getActivity_icon.slideDown("slow");
						getFriends_icon.slideUp("slow");
						map_button_control = true;
					}
				}
				top_right_menu1_display.slideUp("normal");
				top_right_menu2_display.slideUp("normal");
				_right_button1.slideUp("normal");
				_right_button2.slideUp("normal");
				_right_button3.slideUp("normal");
				id_box.attr("out", "true");
				id_box.attr("id_box_block", "true");
				id_person_box.attr("id_person_block", "true");
				_right_control1 = false;
				_right_control2 = false;
			}
			if (activity_mask.css("display") == "block") {
				activity_mask.animate({
					"height" : "304"
				}, 500);
				activity_mask_button.animate({
					"top" : "291"
				}, 500);
				activity_mask_remove.fadeOut(200);
				_school_ten.slideUp("normal", function () {
					_hot_toggle.slideDown("normal");
				});
				_school_ten_main_icon.fadeOut(150);
			}
			if (_locker.css("display") == "block") {
				_locker.fadeOut("normal");
				Add_map();
			}
			if (!_say_out) {
				_say_banner.slideUp("normal");
			} else if (_say_out) {
				if (_say_tra.css("display") == "block") {
					_say_tra.slideUp("normal");
				}
				if (_say_mes_per.css("display") == "block") {
					_say_mes_per.slideUp("normal");
				}
				if (_say_object.css("display") == "block") {
					_say_object.slideUp("normal");
				}
				_say_banner.animate({
					"width" : 10
				}, 500, function () {
					_say_out = false;
				});
				_say_banner.slideUp("normal");
				_say_buttons.slideUp("normal");
			}
		});
		top_right_menu2_active.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			var _class = $(this).attr("class");
			if (_class == "ul") {
				$(this).attr("class", "li").children("ul").slideToggle("normal");
			} else {
				$(this).attr("class", "ul").children("ul").slideToggle("normal");
			}
		});
	}
	//用户、登录界面方法
	function Add_idAnimate() {
		var top_right_button = $(".width .top_button > div");
		var _right_button1 = top_right_button.eq(2);
		var _right_button2 = top_right_button.eq(3);
		var _right_button3 = top_right_button.eq(4);
		var _map = $(".map_out");
		var hot_activity_control = $("#hot_activity");
		var _button_list = $("#button_list");
		var _friends_list = $("#friends_list");
		/*id_box.animate({
			"top" : "0"
		}, "500");*/
		id_logo.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (id_box.attr("out") == "true") {
				if (id_box.attr("id_box_block") == "true") {
					//未登录收起
					id_box_up();
				} else {
					//未登录放下
					id_box_down();
				}
			} else {
				if (id_person_box.attr("id_person_block") == "true") {
					//已登录收起
					id_person_box_up();
				} else {
					//已登录放下
					id_person_box_down();
				}
			}
		});
		id_person_box_border.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			id_person_box.animate({
				"top" : "-238"
			}, "500");
			id_person_box.attr("id_person_block", "false");
		});
		id_border.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			id_box.animate({
				"top" : "-180"
			}, "500");
			id_box.attr("id_box_block", "false");
		});
		id_check.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (!id_check_control) {
				$(this).attr("class", "id_checked");
				id_check_control = true;
			} else if (id_check_control) {
				$(this).attr("class", "id_check");
				id_check_control = false;
			}
		});
		id_login.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			//点击登陆按钮
				//判断是否登录
				var cookie_email = $.cookie('combo_checked_user_email');
				var cookie_psssword=$.cookie('combo_checked_user_passwd');
				var email;
				var passwd;
				var is_login=0;
				if(cookie_email!=null){
					//如果为已登录用户
					is_login=1;
					email=cookie_email;
					passwd=	cookie_psssword;
					LYD.openLink({
						params : {serviceName:'UserService',methodName:'checkUser',email:email,passwd:passwd,is_login:is_login},
						success : function(msg){
							if(msg.status==200){
								var combo_userId = msg.result.USERID;
								var combo_userName = msg.result.USERTRUENAME;
								$.cookie('uid',msg.result.UID);
								$.cookie('combo_checked_user_email',email);
								$.cookie('combo_checked_user_passwd',passwd);
								$.cookie('photo',msg.result.LIMG);
								$("#user_name").html(combo_userName);
								$("#user_pic").attr("src",msg.result.LIMG);
								$("#user_school").html(msg.result.SCHNAME);
								$(".id_person_box .id_person_box_main .icon").html("+"+msg.result.attentionCount);
								$('.top_button2_menu .active .name').eq(0).html(msg.result.USERTRUENAME);
								CUSER.uid = msg.result.UID;
								CUSER.username = msg.result.USERTRUENAME;
								CUSER.schname = msg.result.SCHNAME;
								CUSER.citycode = msg.result.CITY;
								CUSER.cityname=msg.result.cityName;
								CUSER.provinces = msg.result.PROVINCE;
								CUSER.zoneid = msg.result.ZONEID;
								CUSER.zonename = msg.result.zoneName;
								//判断是否保存密码
								if($('.id').children('div').eq(3).attr('class')=='id_check'){
									$(".id_email").children(".id_input").attr('value','');
									 $(".id_password").children(".id_input").attr('value','');
								}
								
									id_box.attr("out", "false");
									$(".logo").eq(0).click();
									//好友下滑
									map_tab.slideDown("normal");
	//								右侧滑下
									_right_button1.slideDown("normal");
									_right_button2.slideDown("normal");
									_right_button3.slideDown("normal");
									_say_banner.slideDown("normal");
								
								
							}else if(msg.status==300){
								LYD.Alert("message","提示","账号密码错误");
							}
							
						},
						error:function(){
							LYD.Alert("message","提示","登录失败，请重试！");
						}
					});
				}
				else{
					//如果未登录
					email = $(".id_email").children(".id_input").val();
					passwd = $(".id_password").children(".id_input").val();
					LYD.openLink({
						params : {serviceName:'UserService',methodName:'checkUser',email:email,passwd:passwd,is_login:is_login},
						success : function(msg){
							if(msg.status==200){
								var combo_userId = msg.result.USERID;
								var combo_userName = msg.result.USERTRUENAME;
								$.cookie('uid',msg.result.UID);
								$.cookie('combo_checked_user_email',email);
								$.cookie('combo_checked_user_passwd',passwd);
								$.cookie('photo',msg.result.LIMG);
								$("#user_name").html(combo_userName);
								$("#user_pic").attr("src",msg.result.LIMG);
								$("#user_school").html(msg.result.SCHNAME);
								$(".id_person_box .id_person_box_main .icon").html("+"+msg.result.attentionCount);
								$('.top_button2_menu .active .name').eq(0).html(msg.result.USERTRUENAME);
								CUSER.uid = msg.result.UID;
								CUSER.username = msg.result.USERTRUENAME;
								CUSER.schname = msg.result.SCHNAME;
								CUSER.citycode = msg.result.CITY;
								CUSER.cityname=msg.result.cityName;
								CUSER.provinces = msg.result.PROVINCE;
								CUSER.zoneid = msg.result.ZONEID;
								CUSER.zonename = msg.result.zoneName;
//								$(".logo").eq(0).click();
								//判断是否保存密码
								if($('.id').children('div').eq(3).attr('class')=='id_check'){
									$(".id_email").children(".id_input").attr('value','');
									 $(".id_password").children(".id_input").attr('value','');
								}
								
									//右侧下滑所有
									map_tab.slideDown("normal");
									id_box.animate({
										"top" : "-205"
									}, "500", function () {
										id_person_box.animate({
											"top" : "0"
										}, "500");
									});
									id_box.attr("out", "false");
									_id_box_exit = true;
	//								右侧滑下
									_right_button1.slideDown("normal");
									_right_button2.slideDown("normal");
									_right_button3.slideDown("normal");
									_say_banner.slideDown("normal");
								
							}else if(msg.status==300){
								LYD.Alert("message","提示","账号密码错误");
							}
							
						},
						error:function(){
							LYD.Alert("message","提示","登录失败，请重试！");
						}
					});
				}
			
			
//			map_tab.slideDown("normal");
//			id_box.animate({
//				"top" : "-205"
//			}, "500", function () {
//				id_person_box.animate({
//					"top" : "0"
//				}, "500");
//			});
//			id_box.attr("out", "false");
//			_id_box_exit = true;
////			右侧滑下
//			_right_button1.slideDown("normal");
//			_right_button2.slideDown("normal");
//			_right_button3.slideDown("normal");
//			_say_banner.slideDown("normal");
		});
		id_reg.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			//点击注册按钮
			location.href="register.do";
		});
		for (var i = 0; i < id_buttons.length; i++) {
			id_buttons.eq(i).attr("number", i).mouseover(function () {
				$(this).css("cursor", "pointer");
			}).click(function () {
				if ($(this).attr("number") == 0) {
					//创建活动
				} else if ($(this).attr("number") == 1) {
					//我所参与
				} else if ($(this).attr("number") == 2) {
					//回到个人
				} else if ($(this).attr("number") == 3) {
					//状态
				} else if ($(this).attr("number") == 4) {
					//locker收藏夹
					if (_map.css("display") == "block") {
						Remove_map();
						Add_locker();
						_button_list.attr("id", "button_map");
					} else if (_locker.css("display") == "block") {
						Remove_locker();
						Add_map();
						_button_list.attr("id", "button_list");
					}
					if (hot_activity_control.css("display") == "block") {
						Remove_hotActivity();
						Add_locker();
					}
					if (_friends_list.css("display") == "block") {
						_friends_list.fadeOut("normal");
						Add_locker();
					}
				}
			});
		}
	}
	
	//聊天变量
	var _say_banner = $("#say_banner");
	var _say_logo = _say_banner.children(".say_logo");
	var _say_banner_bg = _say_banner.children(".say_banner_bg");
	var _say_buttons = _say_banner_bg.children(".say_buttons");
	var _say_out = false;
	var _say_button_array = _say_buttons.children("div");
	var _say_mes_per = $("#say_mes_per");
	var _say_mes_per_main = _say_mes_per.children(".bottom").children(".middle");
	var _say_mes_per_tab = _say_mes_per_main.children(".tab").children("div");
	var _say_main = _say_mes_per_main.children(".scroll").children(".main");
	var _fri_scroll = _say_main.children(".fri_scroll");
	var _fri_main = _fri_scroll.children(".main");
	var _fri_single = _fri_main.children(".single");
	var _fri_scroll_drag = _fri_scroll.children(".drag");
	var _mes_scroll = _say_main.children(".mes_scroll");
	var _mes_main = _mes_scroll.children(".main");
	var _mes_single = _mes_main.children(".single");
	var _mes_scroll_drag = _mes_scroll.children(".drag");
	var _say_tra = $("#say_tra");
	var _say_tra_middle = _say_tra.children(".bottom").children(".middle");
	var _say_tra_button = _say_tra_middle.children(".tab").children("div");
	var _say_tra_main = _say_tra_middle.children(".scroll").children(".main");
	var _say_friend_scroll = _say_tra_main.children(".friend_scroll");
	var _say_friend_drag = _say_friend_scroll.children(".drag");
	var _say_friend_main = _say_friend_scroll.children(".main");
	var _say_friend_single = _say_friend_main.children(".single");
	var _say_round_scroll = _say_tra_main.children(".round_scroll");
	var _say_round_drag = _say_round_scroll.children(".drag");
	var _say_round_main = _say_round_scroll.children(".main");
	var _say_round_single = _say_round_main.children(".single");
	var _say_acti_scroll = _say_tra_main.children(".acti_scroll");
	var _say_acti_drag = _say_acti_scroll.children(".drag");
	var _say_acti_main = _say_acti_scroll.children(".main");
	var _say_acti_single = _say_acti_main.children(".single");
	var _say_acti_single_div = _say_acti_main.children(".single").children(".pic");
	var _say_round_single_div = _say_round_main.children(".single").children(".pic");
	var _say_friend_single_div = _say_friend_main.children(".single").children(".pic");
	var _say_task_array;
	
	for (var i = 0; i < _say_acti_single_div.length; i++) {
		_say_acti_single_div.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (_say_object.css("display") == "none") {
				_say_object.slideDown("normal");
			}
			//点击活动
		});
	}
	for (var i = 0; i < _say_round_single_div.length; i++) {
		_say_round_single_div.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (_say_object.css("display") == "none") {
				_say_object.slideDown("normal");
			}
			//点击圈子
		});
	}
	for (var i = 0; i < _say_friend_single_div.length; i++) {
		_say_friend_single_div.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if (_say_object.css("display") == "none") {
				_say_object.slideDown("normal");
			}
			//点击好友
			_say_buttons.children(".task_add").append("<div class='say_task'><div class='right'><div class='middle'><div class='txt'>asd</div></div></div>"); //添加到任务栏
			_say_task_array = _say_buttons.children(".task_add").children(".say_task");
			for (var i = 0; i < _say_task_array.length; i++) {
				_say_task_array.eq(i).attr("select", "false").mouseover(function () {
					$(this).css("cursor", "pointer");
				}).click(function () {
					if (_say_object.css("display") == "none") {
						_say_object.slideDown("normal");
					}
					for (var j = 0; j < _say_task_array.length; j++) {
						_say_task_array.eq(j).attr("select", "false").css("color", "#111").css("font-weight", "400");
					}
					$(this).attr("select", "true").css("color", "#111").css("font-weight", "bolder");
				});
			}
		});
	}
	for (var i = 0; i < _say_tra_button.length; i++) {
		_say_tra_button.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "say_tra_fri_normal") {
				$(this).attr("class", "say_tra_fri_active");
				_say_tra_button.eq(1).attr("class", "say_tra_round_normal");
				_say_tra_button.eq(2).attr("class", "say_tra_acti_normal");
				_say_tra_main.animate({
					"left" : 0
				}, 500);
			}
			if ($(this).attr("class") == "say_tra_round_normal") {
				$(this).attr("class", "say_tra_round_active");
				_say_tra_button.eq(0).attr("class", "say_tra_fri_normal");
				_say_tra_button.eq(2).attr("class", "say_tra_acti_normal");
				_say_tra_main.animate({
					"left" : -200
				}, 500);
			}
			if ($(this).attr("class") == "say_tra_acti_normal") {
				$(this).attr("class", "say_tra_acti_active");
				_say_tra_button.eq(0).attr("class", "say_tra_fri_normal");
				_say_tra_button.eq(1).attr("class", "say_tra_round_normal");
				_say_tra_main.animate({
					"left" : -400
				}, 500);
			}
		});
	}
	for (var i = 0; i < _say_mes_per_tab.length; i++) {
		_say_mes_per_tab.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "say_tab_fri_normal") {
				$(this).attr("class", "say_tab_fri_active");
				_say_mes_per_tab.eq(1).attr("class", "say_tab_mes_normal");
				_say_main.animate({
					"left" : 0
				}, 500);
			}
			if ($(this).attr("class") == "say_tab_mes_normal") {
				$(this).attr("class", "say_tab_mes_active");
				_say_mes_per_tab.eq(0).attr("class", "say_tab_fri_normal");
				_say_main.animate({
					"left" : -200
				}, 500);
				COMMON.readedMsg();
			}
		});
	}
	for (var i = 0; i < _say_button_array.length; i++) {
		_say_button_array.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "say_message_button") {
				if (_say_tra.css("display") == "block") {
					_say_tra.slideUp("normal");
				}
				_say_mes_per.slideToggle("normal");
			}
			if ($(this).attr("class") == "say_person_button") {
				if (_say_mes_per.css("display") == "block") {
					_say_mes_per.slideUp("normal");
				}
				_say_tra.slideToggle("normal");
			}
		});
	}
	$(window).resize(function () {
		if (_say_out) {
			setSayWdith();
		}
	});
	
	function setSayWdith() {
		var _width = $(document).width();
		if (_width > 1167) {
			_width = (_width - 1167) / 2 + 1006;
			_say_banner.css("width", _width);
		}
	}
	_say_logo.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (!_say_out) {
			var _width = $(document).width();
			if (_width > 1167) {
				_width = (_width - 1167) / 2 + 1006;
			}
			_say_banner.animate({
				"width" : _width
			}, 500, function () {
				_say_buttons.slideDown("normal", function () {
					_say_out = true;
				});
			});
		} else if (_say_out) {
			if (_say_tra.css("display") == "block") {
				_say_tra.slideUp("normal");
			}
			if (_say_mes_per.css("display") == "block") {
				_say_mes_per.slideUp("normal");
			}
			if (_say_object.css("display") == "block") {
				_say_object.slideUp("normal");
			}
			_say_buttons.slideUp("normal");
			_say_banner.animate({
				"width" : 10
			}, 500, function () {
				_say_out = false;
			});
		}
	});
	
	var _say_object = $("#say_object");
	var _say_object_middle = _say_object.children(".bottom").children(".middle");
	var _out_object = _say_object_middle.children(".out_object");
	var _in_object = _say_object_middle.children(".in_object");
	var _send_button = _in_object.children(".send_button");
	var _out_object_drag = _out_object.children(".drag");
	var _out_object_main = _out_object.children(".out_object_main");
	var _out_object_single = _out_object_main.children(".single");
	var _say_object_tab = _say_object_middle.children(".tab");
	var _say_object_tab_div = _say_object_tab.children("div");
	var _say_win_button = _say_object_middle.children(".win_button").children("div");
	
	_send_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		alert("点击发送");
	});
	for (var i = 0; i < _say_win_button.length; i++) {
		_say_win_button.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "min") {
				_say_object.slideUp("normal");
			}
			if ($(this).attr("class") == "close") {
				_say_object.slideUp("normal");
				for (var i = 0; i < _say_task_array.length; i++) {
					if (_say_task_array.eq(i).attr("select") == "true") {
						_say_task_array.eq(i).slideUp("normal", function () {
							//删除自己
						});
					}
				}
			}
		});
	}
	_say_object_tab_div.eq(1).show();
	for (var i = 0; i < _say_object_tab_div.length; i++) {
		if (i % 2 == 0) {
			_say_object_tab_div.eq(i).mouseover(function () {
				$(this).css("cursor", "pointer");
			}).click(function () {
				if ($(this).attr("class") == "canyu_normal") {
					$(this).attr("class", "canyu_active");
					_say_object_tab_div.eq(2).attr("class", "guanzhu_normal");
					_say_object_tab_div.eq(4).attr("class", "tuijian_normal");
					$(this).next().slideDown("normal");
					_say_object_tab_div.eq(3).slideUp("normal");
					_say_object_tab_div.eq(5).slideUp("normal");
				}
				if ($(this).attr("class") == "guanzhu_normal") {
					$(this).attr("class", "guanzhu_active");
					_say_object_tab_div.eq(0).attr("class", "canyu_normal");
					_say_object_tab_div.eq(4).attr("class", "tuijian_normal");
					$(this).next().slideDown("normal");
					_say_object_tab_div.eq(1).slideUp("normal");
					_say_object_tab_div.eq(5).slideUp("normal");
				}
				if ($(this).attr("class") == "tuijian_normal") {
					$(this).attr("class", "tuijian_active");
					_say_object_tab_div.eq(0).attr("class", "canyu_normal");
					_say_object_tab_div.eq(2).attr("class", "guanzhu_normal");
					$(this).next().slideDown("normal");
					_say_object_tab_div.eq(1).slideUp("normal");
					_say_object_tab_div.eq(3).slideUp("normal");
				}
			});
		}
	}
}
//未登录收起
function id_box_up() {
	var id_box = $(".id_box");
	id_box.stop().animate({
		"top" : "-180"
	}, "500");
	id_box.attr("id_box_block", "false");
}
//未登录放下
function id_box_down() {
	var id_box = $(".id_box");
	id_box.stop().animate({
		"top" : "0"
	}, "500");
	id_box.attr("id_box_block", "true");
}
//已登录收起
function id_person_box_up() {
	var id_person_box = $(".id_person_box");
	id_person_box.stop().animate({
		"top" : "-238"
	}, "500");
	id_person_box.attr("id_person_block", "false");
}
//已登录放下
function id_person_box_down() {
	var id_person_box = $(".id_person_box");
	id_person_box.animate({
		"top" : "0"
	}, "500");
	id_person_box.attr("id_person_block", "true");
}

//右侧滑下
function navigation_down(){
	var top_right_button = $(".width .top_button > div");
	var _right_button1 = top_right_button.eq(2);
	var _right_button2 = top_right_button.eq(3);
	var _right_button3 = top_right_button.eq(4);
	
	_right_button1.slideDown("normal");
	_right_button2.slideDown("normal");
	_right_button3.slideDown("normal");
//	_say_banner.slideDown("normal");
}
	
function setNotice(_selector,_number){
	var _setObject = $("#say_banner");
	var _string = _setObject.find("."+_selector);
	_string.append('<div class="notice">'+_number+'</div>');
}

function removeNotice(_selector){
	var _setObject = $("#say_banner");
	var _string = _setObject.find("."+_selector);
	_string.empty();
}
