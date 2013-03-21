$(document).ready(function () {
	$("#friends_all").hide();
	$("#info_all").hide();
	$("#activity_bg").hide();
	var _document_objects = $("*");
	//第一步变量
	var _check_active = $(".check_active");
	var _check_no = $(".check_no");
	var _check_control = false;
	var _city_select = $(".city_select");
	var _city_object = $(".city_object");
	var _city_timer;
	var _reg_button = $(".reg_button");
	var _step_scroll = $("#step_scroll");
	
	//第二步变量
	var _back_button = $(".back_button");
	var _save_complete = $(".save_complete");
	
	//账号设置
	var _info = $(".info");
	var _info_div = _info.children("div");
	var _info_ul = _info.children("ul");
	var _info_li = _info_ul.children("li");
	var _info_input = $(".info_input");
	var _info_save = _info_input.children(".info_save");
	var _info_cancel = _info_input.children(".info_cancel");
	var _pic_upload_main = $(".pic_upload_main");
	var _pic_upload_save = _pic_upload_main.children(".pic_upload_save");
	var _pic_upload_cancel = _pic_upload_main.children(".pic_upload_cancel");
	var _tab_save = $(".tab_save");
	var _tab_cancel = $(".tab_cancel");
	
	//activity_creat变量
	//上按钮变量
	var _activity_main = $(".activity_main");
	var _activity_main_div = _activity_main.children("div");
	var _ac_main = _activity_main.children(".ac_scroll").children(".ac_main");
	var _date_button = _activity_main_div.eq(1);
	var _info_button = _activity_main_div.eq(2);
	var _friends_button = _activity_main_div.eq(3);
	var _active_line = _activity_main_div.eq(4);
	var _ac_creat_button = $(".ac_creat_button");
	
	//活动
	var short_acti = $("#short_acti");
	var long_acti = $("#long_acti");
	longSelect();
	//活动创建变量
	var _friends_main_single_pic = $(".friends_main_single .pic");
	for(var i=0;i<_friends_main_single_pic.length;i++){
		_friends_main_single_pic.eq(i).mouseover(function(){
			$(this).css("cursor", "pointer");
		}).click(function(){
			$(this).children(".pic_mask").toggle();
		});
	}
//	
//	_ac_back_button.mouseover(function () {
//		$(this).css("cursor", "pointer");
//	}).click(function () {
//		$("#friends_all").hide();
//		$("#info_all").hide();
//		$("#date_all").show();
//		_active_line.animate({
//			"left" : "18"
//		}, 500);
//		_ac_main.animate({
//			"top" : "15"
//		}, 500);
//	});
//	
	_ac_creat_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
//		$("#date_all").hide();
//		$("#info_all").hide();
//		$("#friends_all").show();
//		_active_line.animate({
//			"left" : "501"
//		}, 500);
//		_ac_main.animate({
//			"top" : "-1205"
//		}, 500);
	});
	
	//左侧按钮变量
	var _left_button = $(".left_button");
	var _left_button_div = _left_button.children("div");
	for (var i = 0; i < _left_button_div.length; i++) {
		_left_button_div.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 0) {
				$(this).attr("class", "creat_button_active");
				_left_button_div.eq(1).attr("class", "edit_button");
			} else if ($(this).attr("number") == 1) {
				$(this).attr("class", "edit_button_active");
				_left_button_div.eq(0).attr("class", "creat_button");
			}
		});
	}
	//中间变量
	var _date_main_single = $(".date_main_single");
	var _date_main_zhou = _date_main_single.children(".date_main_zhou");
	var _date_select_button = _date_main_zhou.children(".select").children("div");
	var _ri_main = _date_main_zhou.children(".time_ri_scroll").children(".ri_main");
	var _time_border = $(".time_border");
	var _time_border_left = _time_border.children(".time_border_left");
	var _time_border_middle = _time_border_left.children(".time_border_right").children(".time_border_middle");
	var _time_border_icon = _time_border_left.children(".time_border_icon");
	var _ac_next_button = $(".ac_next_button");
	var _ac_yes_button = $(".ac_yes_button");
	var _info_complete_button = $(".info_txt").children(".buttons").children("div");
	var _info_complete_number = 0;
	
	_ac_next_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
//		_active_line.animate({
//			"left" : "260"
//		}, 500);
//		_ac_main.animate({
//			"top" : "-595"
//		}, 500);
	});
	_ac_yes_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		alert("确定");
	});
	_time_border_middle.html("短期临时圈子（活动）时长默认为3天");
	for (var i = 0; i < _date_select_button.length; i++) {
		_date_select_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 1) {
				//短期
				$(this).attr("class", "single_active");
				_date_select_button.eq(2).attr("class", "single");
				_date_select_button.eq(3).attr("class", "single");
				_date_select_button.eq(4).attr("class", "single");
				_time_border_icon.animate({
					"left" : 38
				}, 500);
				_time_border_middle.html("短期临时圈子（活动）时长默认为3天");
				_date_icon.animate({
					"left" : "176"
				}, 500);
				_ri_main.animate({
					"top" : "0"
				}, 500);
				days_Reload(_days3_button,"days3_light","days3_normal",1);
			} else if ($(this).attr("number") == 2) {
				//中期
				$(this).attr("class", "single_active");
				_date_select_button.eq(1).attr("class", "single");
				_date_select_button.eq(3).attr("class", "single");
				_date_select_button.eq(4).attr("class", "single");
				_time_border_icon.animate({
					"left" : 98
				}, 500);
				_time_border_middle.html("中期临时圈子（活动）时长默认为7天");
				_date_icon.animate({
					"left" : "226"
				}, 500);
				_ri_main.animate({
					"top" : "-60"
				}, 500);
				days_Reload(_days7_button,"days7_light","days7_normal",3);
			} else if ($(this).attr("number") == 3) {
				//中长期
				$(this).attr("class", "single_active");
				_date_select_button.eq(1).attr("class", "single");
				_date_select_button.eq(2).attr("class", "single");
				_date_select_button.eq(4).attr("class", "single");
				_time_border_icon.animate({
					"left" : 166
				}, 500);
				_time_border_middle.html("中长期临时圈子（活动）时长默认为15天");
				_date_icon.animate({
					"left" : "306"
				}, 500);
				_ri_main.animate({
					"top" : "-120"
				}, 500);
				days_Reload(_days15_button,"days15_light","days15_normal",7);
			} else if ($(this).attr("number") == 4) {
				//长期
				$(this).attr("class", "single_active");
				_date_select_button.eq(1).attr("class", "single");
				_date_select_button.eq(2).attr("class", "single");
				_date_select_button.eq(3).attr("class", "single");
				_time_border_icon.animate({
					"left" : 231
				}, 500);
				_time_border_middle.html("长期临时圈子（活动）时长默认为30天");
				_date_icon.animate({
					"left" : "309"
				}, 500);
				_ri_main.animate({
					"top" : "-180"
				}, 500);
				days_Reload(_days30_button,"days30_light","days30_normal",14);
			}
			if ($(this).attr("number") == 7) {
				//单日活动
				$(this).attr("class", "single_active");
				_date_select_button.eq(8).attr("class", "single");
				short_acti.css("display","block");
				long_acti.css("display","none");
			} else if ($(this).attr("number") == 8) {
				//数日活动
				$(this).attr("class", "single_active");
				_date_select_button.eq(7).attr("class", "single");
				long_acti.css("display","block");
				short_acti.css("display","none");
			}
		});
	}
	for (var i = 0; i < _info_complete_button.length; i++) {
		_info_complete_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_info_complete_number = $(this).attr("number");
			for (var j = 0; j < _info_complete_button.length; j++) {
				if (_info_complete_button.eq(j).attr("number") == _info_complete_number) {
					_info_complete_button.eq(j).attr("class", "single_active");
				} else {
					_info_complete_button.eq(j).attr("class", "single");
				}
			}
		});
	}
	//活动时间变量
	var _days3_main = $(".days3_main");
	var _days3_button = _days3_main.children(".days3").children(".days3_normal,.days3_light");
	var _days7_main = $(".days7_main");
	var _days7_button = _days7_main.children(".days7").children(".days7_normal,.days7_light");
	var _days15_main = $(".days15_main");
	var _days15_button = _days15_main.children(".days15").children(".days15_normal,.days15_light");
	var _days30_main = $(".days30_main");
	var _days30_button = _days30_main.children(".days30").children(".days30_normal,.days30_light");
	var _date_icon = $(".date_icon");
	var _left_number = 0;
	function days_Reload(_days_button,_days_light,_days_normal,_number){
		for(var i=0;i<_days_button.length;i++){
			if(_days_button.eq(i).attr("number")==_number){
				_days_button.eq(i).attr("class", _days_light);
			} else {
				_days_button.eq(i).attr("class", _days_normal);
			}
		}
	}
	for (var i = 0; i < _days3_button.length; i++) {
		_days3_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_left_number = $(this).attr("number");
			_left = 176 + (_left_number - 1) * 60;
			_date_icon.animate({
				"left" : _left
			}, 500);
			for (var j = 0; j < _days3_button.length; j++) {
				if (_days3_button.eq(j).attr("number") == _left_number) {
					_days3_button.eq(j).attr("class", "days3_light");
				} else {
					_days3_button.eq(j).attr("class", "days3_normal");
				}
			}
		});
	}
	
	for (var i = 0; i < _days7_button.length; i++) {
		_days7_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_left_number = $(this).attr("number");
			_left = 226 + (_left_number - 3) * 40;
			_date_icon.animate({
				"left" : _left
			}, 500);
			for (var j = 0; j < _days7_button.length; j++) {
				if (_days7_button.eq(j).attr("number") == _left_number) {
					_days7_button.eq(j).attr("class", "days7_light");
				} else {
					_days7_button.eq(j).attr("class", "days7_normal");
				}
			}
		});
	}
	
	for (var i = 0; i < _days15_button.length; i++) {
		_days15_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_left_number = $(this).attr("number");
			_left = 306 + (_left_number - 7) * 30;
			_date_icon.animate({
				"left" : _left
			}, 500);
			for (var j = 0; j < _days15_button.length; j++) {
				if (_days15_button.eq(j).attr("number") == _left_number) {
					_days15_button.eq(j).attr("class", "days15_light");
				} else {
					_days15_button.eq(j).attr("class", "days15_normal");
				}
			}
		});
	}
	
	for (var i = 0; i < _days30_button.length; i++) {
		_days30_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			_left_number = $(this).attr("number");
			_left = 309 + (_left_number - 14) * 16;
			_date_icon.animate({
				"left" : _left
			}, 500);
			for (var j = 0; j < _days30_button.length; j++) {
				if (_days30_button.eq(j).attr("number") == _left_number) {
					_days30_button.eq(j).attr("class", "days30_light");
				} else {
					_days30_button.eq(j).attr("class", "days30_normal");
				}
			}
		});
	}
	
	_info_ul.eq(0).slideDown("normal");
	for (var i = 0; i < _info_li.length; i++) {
		_info_li.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 0) {
				$(this).attr("class", "jiben_active");
				_info_li.eq(1).attr("class", "xiugai");
				_info_li.eq(2).attr("class", "xuanze");
				_step_scroll.animate({
					top : "0"
				}, 300);
			} else if ($(this).attr("number") == 1) {
				_info_li.eq(0).attr("class", "jiben");
				$(this).attr("class", "xiugai_active");
				_info_li.eq(2).attr("class", "xuanze");
				_step_scroll.animate({
					top : "-500"
				}, 300);
			} else if ($(this).attr("number") == 2) {
				_info_li.eq(0).attr("class", "jiben");
				_info_li.eq(1).attr("class", "xiugai");
				$(this).attr("class", "xuanze_active");
				_step_scroll.animate({
					top : "-1000"
				}, 300);
			}
		});
	}
	for (var i = 0; i < _info_div.length; i++) {
		_info_div.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 0) {
				$(this).attr("class", "account_active");
				_info_div.eq(1).attr("class", "privacy");
				_info_ul.eq(0).slideDown("normal");
				_info_ul.eq(1).slideUp("normal");
			} else if ($(this).attr("number") == 1) {
				$(this).attr("class", "privacy_active");
				_info_div.eq(0).attr("class", "account");
				_info_ul.eq(1).slideDown("normal");
				_info_ul.eq(0).slideUp("normal");
			}
		});
	}
	_info_save.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//基本信息保存
	});
	_info_cancel.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//基本信息取消
	});
	_pic_upload_save.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//修改头像保存
	});
	_pic_upload_cancel.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//修改头像取消
	});
	_tab_save.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//选择标签保存
	});
	_tab_cancel.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//选择标签取消
	});
	
	//第一步方法
	_setbg();
	_check_active.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (_check_control) {
			$(this).attr("class", "check_active");
			_check_no.attr("class", "check_no");
			_check_control = false;
		}
	});
	_check_no.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (!_check_control) {
			$(this).attr("class", "check_active");
			_check_active.attr("class", "check_no");
			_check_control = true;
		}
	});
	_city_select.mouseover(function () {
		_city_timer_stop();
	}).click(function () {
		_city_object.slideDown("normal");
	}).mouseleave(function () {
		_city_timer = setTimeout("_removeCity()", 300);
	});
	
	_city_object.mouseover(function () {
		_city_timer_stop();
	}).mouseleave(function () {
		_city_timer = setTimeout("_removeCity()", 300);
	});
	_reg_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_step_scroll.animate({
			top : "-500"
		}, 300);
	});
	
	function _city_timer_stop() {
		clearTimeout(_city_timer);
	}
	
	//第二步方法
	_back_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_step_scroll.animate({
			top : "0"
		}, 300);
	});
	_save_complete.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		var _href = $(this).children("a").attr("href");
		window.location.href = _href;
	});
});
$(window).resize(function () {
	_setbg();
});

function _setbg() {
	var _height = $(document).height() - 75;
	var object = $("#background");
	object.css("height", _height);
}

function _removeCity() {
	var _city = $(".city_object");
	_city.slideUp("normal");
}

function longSelect(){
	var long_acti = $("#long_acti");
	var number;
	addLong("days3");
	addLong("days7");
	addLong("days15");
	addLong("days30");
	function addLong($object){
		var select_cache = long_acti.find("."+$object).children();
		for(var i=0;i<select_cache.length;i++){
			select_cache.eq(i).attr("number",i).mouseover(function(){
				$(this).css("cursor","pointer");
			}).click(function(){
				if(number==null){
					for(var k=0;k<select_cache.length;k++){
						select_cache.eq(k).attr("class",$object+"_long_normal");
					}
					number = $(this).attr("number");
					$(this).attr("class",$object+"_long_light");
				} else {
					if(parseInt($(this).attr("number"))>parseInt(number)){
						for(var k=0;k<parseInt($(this).attr("number"))-parseInt(number);k++){
							select_cache.eq(parseInt(number)+k+1).attr("class",$object+"_long_light");
						}
						number=null;
					} else {
						for(var k=0;k<parseInt(number)-parseInt($(this).attr("number"));k++){
							select_cache.eq(parseInt($(this).attr("number"))+k).attr("class",$object+"_long_light");
						}
						number=null;
					}
				}
			});
		}
	}
}
