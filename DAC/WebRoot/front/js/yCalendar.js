var yCalendar = function () {
	
	var _yCalendar = $("#yCalendar");
	var _c_name;
	
	//时间初始化
	var $date = new Date();
	var _year = $date.getFullYear();
	var _month = $date.getMonth() + 1;
	var _day = $date.getDate();
	var _getday = $date.getDay();
	
	//今天日期
	var this_year = _year;
	var this_month = _month;
	var this_day = _day;
	
	var _data; //总data
	var _data_line = "";
	var _data_line_data = "";
	var _data_bottom_line = "";
	var _date_top = "";
	
	var _data_line_length = 20;
	var _blank_control = false;
	var _blank_number = 0;
	
	var $this_week = 0;
	var monthArray;
	var $backcolor = "#FF1414";
	var date_line_num = 0;
	
	var _weekCN = ["一", "二", "三", "四", "五", "六", "日"];
	
	//活动变量
	var activityCache;
	
	getThisWeek();
	
	function getThisWeek() {
		var _today = 0;
		if (_year % 400 == 0 || _year % 4 == 0 && _year % 100 != 0) {
			monthArray = new Array(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		} else {
			monthArray = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		}
		for (var i = 0; i < _month - 1; i++) {
			_today += monthArray[i];
		}
		$this_week = parseInt((_today + _day) / 7+1);
		if (_getday > 1) {
			_day = _day - (_getday - 1);
			if (_day <= 0) {
				_day += monthArray[_month];
				_month--;
			}
		} else if (_getday == 0) {
			_day = _day - 6;
			if (_day <= 0) {
				if (_month == 1) {
					_day += monthArray[11];
					_month = 12;
					_year--;
				} else {
					_day += monthArray[_month];
					_month--;
				}
			}
		}
	}
	//刷出框架
	for (var i = 0; i < 7; i++) {
		if (_getday != 0 && i == (_getday - 1)) {
			_data_bottom_line += '<div id="c_bottom_active"></div>';
			if (i == 5) {
				_date_top += '<div id="week_active"><div id="weekend_front_active">' + _weekCN[i] + '</div></div>';
			} else {
				_date_top += '<div id="week_active">' + _weekCN[i] + '</div>';
			}
		} else if (_getday == 0 && i == 6) {
			_data_bottom_line += '<div id="c_bottom_active"></div>';
			_date_top += '<div id="week_active"><div id="weekend_back_active">' + _weekCN[i] + '</div></div>';
		} else {
			_data_bottom_line += '<div id="c_bottom"></div>';
			if (i == 5) {
				_date_top += '<div id="week"><div id="weekend_front">' + _weekCN[i] + '</div></div>';
			} else if (i == 6) {
				_date_top += '<div id="week"><div id="weekend_back">' + _weekCN[i] + '</div></div>';
			} else {
				_date_top += '<div id="week">' + _weekCN[i] + '</div>';
			}
		}
	}
	this.drawMain = function () {
		//刷出内容
		for (var k = 0; k < _data_line_length; k++) {
			for (var i = 0; i < 7; i++) {
				if (_blank_control) {
					if (_blank_number >= 6) {
						_blank_control = false;
						_blank_number = -1;
					}
					if (_getday != 0 && i == (_getday - 1) || _getday == 0 && i == 6) {
						_data_line_data += '<div class="date_active_blank"></div>';
						_blank_number++;
					} else {
						_data_line_data += '<div class="date_normal_blank"></div>';
						_blank_number++;
					}
				} else {
					if (_getday != 0 && i == (_getday - 1) || _getday == 0 && i == 6) {
						if (_month == (this_month) && _day == this_day && _year == this_year) {
							_data_line_data += '<div class="date_active"' + 'date="' + _year + ',' + _month + ',' + _day + '"' + ' style="background:#eff4f8;"><div class="today_txt">' + _month + "月" + _day + "今天" + '</div></div>';
						} else {
							_data_line_data += '<div class="date_active"' + 'date="' + _year + ',' + _month + ',' + _day + '"' + '><div class="active_txt">' + _month + "月" + _day + '</div></div>';
						}
					} else {
						if (k == 0) {
							if (_day > this_day) {
								_data_line_data += '<div class="date_normal"' + 'date="' + _year + ',' + _month + ',' + _day + '"' + '>' + _month + "月" + _day + '</div>';
							} else {
								_data_line_data += '<div class="date_normal"' + 'date="' + _year + ',' + _month + ',' + _day + '"' + '><span class="had_color">' + _month + "月" + _day + '</span></div>';
							}
						} else {
							_data_line_data += '<div class="date_normal"' + 'date="' + _year + ',' + _month + ',' + _day + '"' + '>' + _month + "月" + _day + '</div>';
						}
					}
					_day++;
					if (_day > monthArray[_month - 1]) {
						_day = 1;
						_month++;
						if (_month > 12) {
							_month = 1;
							$this_week = 1;
							_year++;
							if (_year % 400 == 0 || _year % 4 == 0 && _year % 100 != 0) {
								monthArray = new Array(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
							} else {
								monthArray = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
							}
						}
						_blank_control = true;
					}
				}
			}
			if (_blank_control) {
				date_line_num++
				_data_line += '<div class="date_line"' + 'number="' + date_line_num + '"' + '>' +
				'<div id="week_left">' + $this_week + '</div>' +//空行周
				_data_line_data +
				'<div id="week_right"></div>' +
				'</div>';
				_data_line_data = "";
			} else {
				date_line_num++
				_data_line += '<div class="date_line"' + 'number="' + date_line_num + '"' + '>' +
				'<div id="week_left">' + $this_week + '</div>' +
				_data_line_data +
				'<div id="week_right"></div>' +
				'</div>';
				_data_line_data = "";
				$this_week++;
			}
		}
	}
	this.setName = function ($name) {
		_c_name = $name + "的日程提醒";
	}
	
	this.startShow = function () {
		_data = '<div id="c_top">' +
			'<div id="y_name">' + _c_name + '</div>' +
			'<div id="c_right">' +
			'<div class="week_active">1周</div>' +
			'<div class="week_normal">3周</div>' +
			'<div class="week_normal">6周</div>' +
			'<div class="week_normal">12周</div>' +
			'<div class="week_normal">24周</div>' +
			'<div class="week_normal">48周</div>' +
			'</div>' +
			'</div>' +
			'<div id="c_main">' +
			'<div id="c_date_top">' +
			'<div id="week_left">周</div>' + _date_top +
			'<div id="week_right"></div>' +
			'</div>' + _data_line +
			'<div id="c_bottom_line">' +
			'<div id="c_bottom_left"></div>' + _data_bottom_line + '<div id="c_bottom_right"></div>' +
			'</div>' +
			'<div id="y_banner"></div>' +
			'</div>';
		_yCalendar.append(_data);
	}
	
	this.setTime = function ($time) {
		_data_line_length = $time;
	}
	
	this.addActivity = function ($type, $date, $title, $time) {
		activityCache = _yCalendar.find(".date_normal,.date_active");
		for (var i = 0; i < activityCache.length; i++) {
			if (activityCache.eq(i).attr("date") == $date) {
				//普通宽度
				if (activityCache.eq(i).attr("class") == "date_normal") {
					if ($type == "short") {
						if (activityCache.eq(i).attr("active") == "long") {
							activityCache.eq(i).attr("active", "short").append('<div class="list_style_long">' + $title + '</div>');
						} else {
							activityCache.eq(i).attr("active", "short").wrapInner('<div class="activity_normal_txt"></div>').append('<div class="list_style">' + $title + '</div>');
						}
					}
					if ($type == "long") {
						var cache_normal = i + 1;
						for (var n = 0; n < $time; n++) {
							//检测下一个
							if (activityCache.eq(cache_normal).attr("class") == "date_normal") {
								if (activityCache.eq(cache_normal).attr("active") == "short") {
									activityCache.eq(cache_normal).attr("active", "long").append('<div class="d_line"></div>').children(".list_style").attr("class", "list_style_long");
								} else if (activityCache.eq(cache_normal).attr("active") == "long") {
									activityCache.eq(cache_normal).children(".d_line").css("background", $backcolor);
								} else {
									activityCache.eq(cache_normal).attr("active", "long").wrapInner('<div class="activity_normal_txt"></div>').append('<div class="d_line"></div>');
								}
							}
							//检测下一个
							if (activityCache.eq(cache_normal).attr("class") == "date_active") {
								if (activityCache.eq(cache_normal).attr("active") == "short") {
									activityCache.eq(cache_normal).attr("active", "long").append('<div class="d_line_long"></div>').find(".list_active_style").attr("class", "list_active_style_long");
								} else if (activityCache.eq(cache_normal).attr("active") == "long") {
									activityCache.eq(cache_normal).find(".d_line_long").css("background", $backcolor);
								} else if (activityCache.eq(cache_normal).attr("date") == this_year + ',' + this_month + ',' + this_day) {
									activityCache.eq(cache_normal).attr("active", "long").children().append('<div class="d_line_long"></div>');
								} else {
									activityCache.eq(cache_normal).attr("active", "long").children().wrapInner('<div class="activity_active_txt"></div>').append('<div class="d_line_long"></div>');
								}
							}
							cache_normal++;
						}
						//添加自己
						if (activityCache.eq(i).attr("active") == "long") {
							activityCache.eq(i).append('<div class="list_style_long">' + $title + '</div>').find(".d_line").css("background", $backcolor);
						} else {
							activityCache.eq(i).attr("active", "long").wrapInner('<div class="activity_normal_txt"></div>').append('<div class="list_style_long">' + $title + '</div><div class="d_line"></div>');
						}
					}
				}
				//加大宽度
				if (activityCache.eq(i).attr("class") == "date_active") {
					if ($type == "short") {
						if ($date == this_year + ',' + this_month + ',' + this_day) {
							activityCache.eq(i).attr("active", "short").children().append('<div class="list_active_style">' + $title + '</div>');
						} else if (activityCache.eq(i).attr("active") == "long") {
							activityCache.eq(i).attr("active", "short").children().append('<div class="list_active_style_long">' + $title + '</div>');
						} else {
							activityCache.eq(i).attr("active", "short").children().wrapInner('<div class="activity_active_txt"></div>').append('<div class="list_active_style">' + $title + '</div>');
						}
					}
					if ($type == "long") {
						var cache_active = i + 1;
						for (var m = 0; m < $time; m++) {
							//检测下一个
							if (activityCache.eq(cache_active).attr("class") == "date_normal") {
								if (activityCache.eq(cache_active).attr("active") == "short") {
									activityCache.eq(cache_active).attr("active", "long").append('<div class="d_line"></div>').children(".list_style").attr("class", "list_style_long");
								} else if (activityCache.eq(cache_active).attr("active") == "long") {
									activityCache.eq(cache_active).attr("active", "long").children(".d_line").css("background", $backcolor);
								} else {
									activityCache.eq(cache_active).attr("active", "long").wrapInner('<div class="activity_normal_txt"></div>').append('<div class="d_line"></div>');
								}
							}
							//检测下一个
							if (activityCache.eq(cache_active).attr("class") == "date_active") {
								if (activityCache.eq(cache_active).attr("active") == "short") {
									activityCache.eq(cache_active).attr("active", "long").append('<div class="d_line_long"></div>');
								} else if (activityCache.eq(cache_active).attr("active") == "long") {
									activityCache.eq(cache_active).attr("active", "long").find(".d_line_long").css("background", $backcolor);
								} else {
									activityCache.eq(cache_active).attr("active", "long").children().wrapInner('<div class="activity_active_txt"></div>').append('<div class="d_line_long"></div>');
								}
							}
							cache_active++;
						}
						//添加自己
						if ($date == this_year + ',' + this_month + ',' + this_day) {
							activityCache.eq(i).attr("active", "long").append('<div class="list_style_long">' + $title + '</div><div class="d_line_long"></div>');
						} else if (activityCache.eq(i).attr("active") == "long") {
							activityCache.eq(i).append('<div class="list_style_long">' + $title + '</div>').find(".d_line_long").css("background", $backcolor);
						} else {
							activityCache.eq(i).attr("active", "long").children().wrapInner('<div class="activity_active_txt"></div>').append('<div class="list_active_style_long">' + $title + '</div><div class="d_line_long"></div>');
						}
					}
				}
			}
		}
	}
	
	this.dateClick = function () {
		var activityAll = _yCalendar.find(".date_normal,.date_active,.date_normal_blank,.date_active_blank");
		var date_lineArray = _yCalendar.find(".date_line");
		
		var click_cache;
		var click_prev_object;
		
		var mouseover_cache;
		var mouseover_cache2;
		var mouseover_cache3;
		
		var click_control = true;
		var click_blank = false;
		
		var yCalendar_t;
		
		var date_list_cache;
		var date_list_creat = true;
		var date_list_remove_cache;
		var date_list_data = '<div class="date_list">' +
			'<div class="date_list_bottom">' +
			'<div class="date_main">' +
			'<div class="list_object"><div class="task_icon">和杨昌钊去看脚换药<span>理工桥北门诊所</span><span>PM 17:45</span><div class="del_button"></div></div></div>' +
			'<div class="list_object"><div class="task_icon">和杨昌钊去看脚换药<span>理工桥北门诊所</span><span>PM 17:45</span><div class="del_button"></div></div></div>' +
			'<div class="list_object"><div class="activity_icon">和杨昌钊去看脚换药<span>理工桥北门诊所</span><span>PM 17:45</span><div class="del_button"></div></div></div>' +
			'<div class="create_button">+ 创建当日新的日程提醒</div>' +
			'</div>' +
			'</div>' +
			'</div>';
		
		for (var i = 0; i < activityAll.length; i++) {
			activityAll.eq(i).attr("number", i);
		}
		for (var i = 0; i < activityCache.length; i++) {
			activityCache.eq(i).click(function () {
				if (mouseover_cache != null || mouseover_cache2 != null || mouseover_cache3 != null) {
					mouseover_cache.css("border-bottom", "1px solid #DDDDDD").css("border-right", "1px solid #DDDDDD");
					mouseover_cache2.css("border-right", "1px solid #DDDDDD");
					if (mouseover_cache3 != null) {
						mouseover_cache3.css("border-bottom", "1px solid #DDDDDD");
					}
					if (mouseover_cache.attr("number") == $(this).attr("number")) {
						//激活取消
						if (!date_list_creat) {
							date_list_cache.next().stop(true, true).slideUp(300, function () {
								date_list_creat = true;
								date_list_cache.next().remove();
							});
							yCalendar_t = $(this).find(".yCalendar_t");
							if(yCalendar_t.length>0){
								yCalendar_t.remove();
							}
						}
						if (click_control) {
							click_control = false;
						} else {
							click_control = true;
						}
					} else {
						//激活交换
						click_control = true;
						if (!date_list_creat) {
							date_list_remove_cache = date_list_cache.next();
							date_list_cache.next().stop(true, true).slideUp(300, function () {
								date_list_creat = true;
								if(click_blank){
									date_list_cache.next().remove();
									click_blank = false;
								}
							});
							if(yCalendar_t!=null){
								yCalendar_t.remove();
							}
							if ($(this).find(".list_active_style_long,.list_style_long,.list_active_style,.list_style").length > 0) {
								$(this).append('<div class="yCalendar_t" style="left:'+parseInt(($(this).width()/2)-9)+'px"></div>');
								yCalendar_t = $(this).children(".yCalendar_t");
								date_list_cache = date_lineArray.eq($(this).parent().attr("number") - 1);
								date_list_cache.after(date_list_data);
								date_list_cache.next().stop(true, true).slideDown(300, function () {
									date_list_creat = false;
									date_list_remove_cache.remove();
								});
								//框
								var create_button = _yCalendar.find(".create_button");
								var _click_html;
								if($(this).find(".activity_normal_txt").length>0){
										_click_html = $(this).find(".activity_normal_txt").html();
									} else if($(this).find(".active_txt").length>0) {
										_click_html = $(this).find(".active_txt").html();
									}
								var _thisLineNumber = $(this).parent().attr("number");
								create_button.click(function(){
									//创建当日新的日程提醒
									var _clickArray = _click_html.split("月");
									var _thisTop;
									if(_thisLineNumber!=null){
										_thisTop = (_thisLineNumber-1)*47;
									} else {
										_thisTop = 0;
									}
									var _info = '<div class="info_object"'+'style="top:'+_thisTop+'px;"'+'>'+
									'<div class="title">活动日程隐私设置</div>'+
									'<div class="info_object_bottom">'+
										'<div class="info_object_main">'+
											'<div class="info_object_contain">'+
												'<div class="info_white_bg">'+
													'<div class="date_now">'+
														'<div class="month">'+_clickArray[0]+'月'+'</div>'+
														'<div class="day">'+_clickArray[1]+'</div>'+
													'</div>'+
													'<div class="info_right">'+
														'<div><span class="black">日程提醒名称：</span></div>'+
														'<div class="input_bg">'+
															'<input class="input_style" type="text">'+
														'</div>'+
														'<div class="clear"></div>'+
														'<div class="single">'+
															'<div class="info_discribe">添加描述</div>'+
														'</div>'+
														'<div class="single">'+
														'<div><span class="black">提醒结束日期</span></div>'+
															'<div class="list_bg_left">'+
																'<div class="list_bg_right">'+
																	'<div class="list_bg_main">请进行选择</div>'+
																'</div>'+
																'<div class="selection_bg_left">'+
																	'<div class="selection_bg_right">'+
																		'<div class="selection_bg_main">'+
																			'<div class="list_area_border">'+
																				'<div class="list_area">'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																				'</div>'+
																			'</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
															'<div class="list_bg_left">'+
																'<div class="list_bg_right">'+
																	'<div class="list_bg_main">请进行选择</div>'+
																'</div>'+
																'<div class="selection_bg_left">'+
																	'<div class="selection_bg_right">'+
																		'<div class="selection_bg_main">'+
																			'<div class="list_area_border">'+
																				'<div class="list_area">'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																				'</div>'+
																			'</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
															'<div class="list_bg_left">'+
																'<div class="list_bg_right">'+
																	'<div class="list_bg_main">请进行选择</div>'+
																'</div>'+
																'<div class="selection_bg_left">'+
																	'<div class="selection_bg_right">'+
																		'<div class="selection_bg_main">'+
																			'<div class="list_area_border">'+
																				'<div class="list_area">'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																				'</div>'+
																			'</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
															'<div class="clear"></div>'+
														'</div>'+
															'<div><span class="black">需要提醒的好友：</span></div>'+
														'<div class="input_bg">'+
															'<input class="input_style" type="text">'+
														'</div>'+
													'</div>'+
												'</div>'+
												'<div class="clear"></div>'+
												'<div class="info_gray_bg">'+
													'<div class="gray_txt" style="margin-bottom:10px;">隐私<br/>（选择可见的对象）</div>'+
													'<div class="list_bg_left" style="margin:7px 0 0 0;">'+
														'<div class="list_bg_right">'+
															'<div class="list_bg_main">请进行选择</div>'+
														'</div>'+
														'<div class="selection_bg_left">'+
															'<div class="selection_bg_right">'+
																'<div class="selection_bg_main">'+
																	'<div class="list_area_border">'+
																		'<div class="list_area">'+
																			'<div>所有人可见</div>'+
																			'<div>我的好友可见</div>'+
																			'<div>仅我自己</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
														'</div>'+
													'</div>'+
													'<div class="clear"></div>'+
													'<label>发送私信通知好友</label>'+
													'<input type="checkbox" title="发送私信通知好友" tabindex="5">'+
													'<div class="clear"></div>'+
													'<div id="gray_buttons">'+
														'<div class="gray_cancel"></div>'+
														'<div class="gray_creat"></div>'+
													'</div>'+
													'<div class="clear"></div>'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div>';
									_yCalendar.append(_info);
									var gray_button = _yCalendar.find("#gray_buttons").children();
									var info_discribe = _yCalendar.find(".info_discribe");
									info_discribe.click(function(){
										$(this).parent().append('<textarea name="" id="textarea_style"></textarea>');
										$(this).remove();
									})
									gray_button.eq(0).click(function(){
										_yCalendar.children(".info_object").remove();
										//点击取消
									})
									gray_button.eq(1).click(function(){
										alert("gray_creat");
										//点击创建
									});
								});
								//框
							} else {
								click_blank = true;
							}
						}
					}
				}
				//总控
				if (click_control) {
					click_cache = $(this).attr("number") - 7;
					click_prev_object = $(this).parent().prev().find(".date_normal,.date_active,.date_normal_blank,.date_active_blank");
					mouseover_cache = $(this);
					mouseover_cache2 = $(this).prev();
					if ($(this).parent().attr("number") != 1) {
						for (var k = 0; k < click_prev_object.length; k++) {
							if (click_prev_object.eq(k).attr("number") == click_cache) {
								mouseover_cache3 = click_prev_object.eq(k);
								mouseover_cache3.css("border-bottom", "1px solid #84888b");
							}
						}
					}
					mouseover_cache.css("border-bottom", "1px solid #84888b").css("border-right", "1px solid #84888b");
					if (mouseover_cache2.attr("class") == "date_normal_blank" || mouseover_cache2.attr("class") == "date_active_blank") {
						if(mouseover_cache2.attr("class")=="date_normal_blank"){
							mouseover_cache2.css("width", 72).css("border-right", "1px solid #84888b");
						}
						if(mouseover_cache2.attr("class")=="date_active_blank"){
							mouseover_cache2.css("width", 110).css("border-right", "1px solid #84888b");
						}
					} else {
						mouseover_cache2.css("border-right", "1px solid #84888b");
					}
					if(date_list_creat){
						if ($(this).find(".list_active_style_long,.list_style_long,.list_active_style,.list_style").length > 0) {
							$(this).append('<div class="yCalendar_t" style="left:'+parseInt(($(this).width()/2)-9)+'px"></div>');
							yCalendar_t = $(this).children(".yCalendar_t");
							date_list_cache = date_lineArray.eq($(this).parent().attr("number") - 1);
							date_list_cache.after(date_list_data);
							date_list_cache.next().stop(true, true).slideDown(300, function () {
								date_list_creat = false;
							});
							//首次列表弹出
							//框
								var create_button = _yCalendar.find(".create_button");
								var _click_html;
								if($(this).find(".activity_normal_txt").length>0){
										_click_html = $(this).find(".activity_normal_txt").html();
									} else if($(this).find(".active_txt").length>0) {
										_click_html = $(this).find(".active_txt").html();
									}
								var _thisLineNumber = $(this).parent().attr("number");
								create_button.click(function(){
									//创建当日新的日程提醒
									var _clickArray = _click_html.split("月");
									var _thisTop;
									if(_thisLineNumber!=null){
										_thisTop = (_thisLineNumber-1)*47;
									} else {
										_thisTop = 0;
									}
									var _info = '<div class="info_object"'+'style="top:'+_thisTop+'px;"'+'>'+
									'<div class="title">活动日程隐私设置</div>'+
									'<div class="info_object_bottom">'+
										'<div class="info_object_main">'+
											'<div class="info_object_contain">'+
												'<div class="info_white_bg">'+
													'<div class="date_now">'+
														'<div class="month">'+_clickArray[0]+'月'+'</div>'+
														'<div class="day">'+_clickArray[1]+'</div>'+
													'</div>'+
													'<div class="info_right">'+
														'<div><span class="black">日程提醒名称：</span></div>'+
														'<div class="input_bg">'+
															'<input class="input_style" type="text">'+
														'</div>'+
														'<div class="clear"></div>'+
														'<div class="single">'+
															'<div class="info_discribe">添加描述</div>'+
														'</div>'+
														'<div class="single">'+
														'<div><span class="black">提醒结束日期</span></div>'+
															'<div class="list_bg_left">'+
																'<div class="list_bg_right">'+
																	'<div class="list_bg_main">请进行选择</div>'+
																'</div>'+
																'<div class="selection_bg_left">'+
																	'<div class="selection_bg_right">'+
																		'<div class="selection_bg_main">'+
																			'<div class="list_area_border">'+
																				'<div class="list_area">'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																				'</div>'+
																			'</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
															'<div class="list_bg_left">'+
																'<div class="list_bg_right">'+
																	'<div class="list_bg_main">请进行选择</div>'+
																'</div>'+
																'<div class="selection_bg_left">'+
																	'<div class="selection_bg_right">'+
																		'<div class="selection_bg_main">'+
																			'<div class="list_area_border">'+
																				'<div class="list_area">'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																				'</div>'+
																			'</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
															'<div class="list_bg_left">'+
																'<div class="list_bg_right">'+
																	'<div class="list_bg_main">请进行选择</div>'+
																'</div>'+
																'<div class="selection_bg_left">'+
																	'<div class="selection_bg_right">'+
																		'<div class="selection_bg_main">'+
																			'<div class="list_area_border">'+
																				'<div class="list_area">'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																					'<div>1900</div>'+
																				'</div>'+
																			'</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
															'<div class="clear"></div>'+
														'</div>'+
															'<div><span class="black">需要提醒的好友：</span></div>'+
														'<div class="input_bg">'+
															'<input class="input_style" type="text">'+
														'</div>'+
													'</div>'+
												'</div>'+
												'<div class="clear"></div>'+
												'<div class="info_gray_bg">'+
													'<div class="gray_txt" style="margin-bottom:10px;">隐私<br/>（选择可见的对象）</div>'+
													'<div class="list_bg_left" style="margin:7px 0 0 0;">'+
														'<div class="list_bg_right">'+
															'<div class="list_bg_main">请进行选择</div>'+
														'</div>'+
														'<div class="selection_bg_left">'+
															'<div class="selection_bg_right">'+
																'<div class="selection_bg_main">'+
																	'<div class="list_area_border">'+
																		'<div class="list_area">'+
																			'<div>所有人可见</div>'+
																			'<div>我的好友可见</div>'+
																			'<div>仅我自己</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
														'</div>'+
													'</div>'+
													'<div class="clear"></div>'+
													'<label>发送私信通知好友</label>'+
													'<input type="checkbox" title="发送私信通知好友" tabindex="5">'+
													'<div class="clear"></div>'+
													'<div id="gray_buttons">'+
														'<div class="gray_cancel"></div>'+
														'<div class="gray_creat"></div>'+
													'</div>'+
													'<div class="clear"></div>'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div>';
									_yCalendar.append(_info);
									var gray_button = _yCalendar.find("#gray_buttons").children();
									var info_discribe = _yCalendar.find(".info_discribe");
									info_discribe.click(function(){
										$(this).parent().append('<textarea name="" id="textarea_style"></textarea>');
										$(this).remove();
									})
									gray_button.eq(0).click(function(){
										_yCalendar.children(".info_object").remove();
										//点击取消
									})
									gray_button.eq(1).click(function(){
										alert("gray_creat");
										//点击创建
									});
								});
								//框
						} else {
							//点击空白
							var _click_html;
							if($(this).find(".activity_normal_txt").length>0){
								_click_html = $(this).find(".activity_normal_txt").html();
							} else if($(this).find(".active_txt").length>0) {
								_click_html = $(this).find(".active_txt").html();
							} else {
								_click_html = $(this).html();
							}
							var _clickArray = _click_html.split("月");
							var _thisLineNumber = $(this).parent().attr("number");
							var _thisTop = (_thisLineNumber-1)*47;
							var _info = '<div class="info_object"'+'style="top:'+_thisTop+'px;"'+'>'+
							'<div class="title">活动日程隐私设置</div>'+
							'<div class="info_object_bottom">'+
								'<div class="info_object_main">'+
									'<div class="info_object_contain">'+
										'<div class="info_white_bg">'+
											'<div class="date_now">'+
												'<div class="month">'+_clickArray[0]+'月'+'</div>'+
												'<div class="day">'+_clickArray[1]+'</div>'+
											'</div>'+
											'<div class="info_right">'+
												'<div><span class="black">日程提醒名称：</span></div>'+
												'<div class="input_bg">'+
													'<input class="input_style" type="text">'+
												'</div>'+
												'<div class="clear"></div>'+
												'<div class="single">'+
													'<div class="info_discribe">添加描述</div>'+
												'</div>'+
												'<div class="single">'+
												'<div><span class="black">提醒结束日期</span></div>'+
													'<div class="list_bg_left">'+
														'<div class="list_bg_right">'+
															'<div class="list_bg_main">请进行选择</div>'+
														'</div>'+
														'<div class="selection_bg_left">'+
															'<div class="selection_bg_right">'+
																'<div class="selection_bg_main">'+
																	'<div class="list_area_border">'+
																		'<div class="list_area">'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
														'</div>'+
													'</div>'+
													'<div class="list_bg_left">'+
														'<div class="list_bg_right">'+
															'<div class="list_bg_main">请进行选择</div>'+
														'</div>'+
														'<div class="selection_bg_left">'+
															'<div class="selection_bg_right">'+
																'<div class="selection_bg_main">'+
																	'<div class="list_area_border">'+
																		'<div class="list_area">'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
														'</div>'+
													'</div>'+
													'<div class="list_bg_left">'+
														'<div class="list_bg_right">'+
															'<div class="list_bg_main">请进行选择</div>'+
														'</div>'+
														'<div class="selection_bg_left">'+
															'<div class="selection_bg_right">'+
																'<div class="selection_bg_main">'+
																	'<div class="list_area_border">'+
																		'<div class="list_area">'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																			'<div>1900</div>'+
																		'</div>'+
																	'</div>'+
																'</div>'+
															'</div>'+
														'</div>'+
													'</div>'+
													'<div class="clear"></div>'+
												'</div>'+
													'<div><span class="black">需要提醒的好友：</span></div>'+
												'<div class="input_bg">'+
													'<input class="input_style" type="text">'+
												'</div>'+
											'</div>'+
										'</div>'+
										'<div class="clear"></div>'+
										'<div class="info_gray_bg">'+
											'<div class="gray_txt" style="margin-bottom:10px;">隐私<br/>（选择可见的对象）</div>'+
											'<div class="list_bg_left" style="margin:7px 0 0 0;">'+
												'<div class="list_bg_right">'+
													'<div class="list_bg_main">请进行选择</div>'+
												'</div>'+
												'<div class="selection_bg_left">'+
													'<div class="selection_bg_right">'+
														'<div class="selection_bg_main">'+
															'<div class="list_area_border">'+
																'<div class="list_area">'+
																	'<div>所有人可见</div>'+
																	'<div>我的好友可见</div>'+
																	'<div>仅我自己</div>'+
																'</div>'+
															'</div>'+
														'</div>'+
													'</div>'+
												'</div>'+
											'</div>'+
											'<div class="clear"></div>'+
											'<label>发送私信通知好友</label>'+
											'<input type="checkbox" title="发送私信通知好友" tabindex="5">'+
											'<div class="clear"></div>'+
											'<div id="gray_buttons">'+
												'<div class="gray_cancel"></div>'+
												'<div class="gray_creat"></div>'+
											'</div>'+
											'<div class="clear"></div>'+
										'</div>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>';
							_yCalendar.append(_info);
							var gray_button = _yCalendar.find("#gray_buttons").children();
							var info_discribe = _yCalendar.find(".info_discribe");
							info_discribe.click(function(){
								$(this).parent().append('<textarea name="" id="textarea_style"></textarea>');
								$(this).remove();
							})
							gray_button.eq(0).click(function(){
								_yCalendar.children(".info_object").remove();
								//点击取消
							})
							gray_button.eq(1).click(function(){
								alert("gray_creat");
								//点击创建
							});
						}
					}
				}
			});
		}
	}
	
	this.weekClick = function () {
		var _weekArray = _yCalendar.find("#c_right").children();
		var _top_cache;
		var date_line = _yCalendar.find("#c_main").children(".date_line");
		for (var i = 0; i < _weekArray.length; i++) {
			if (_weekArray.eq(i).attr("class") == "week_active") {
				_top_cache = _weekArray.eq(i);
			}
			_weekArray.eq(i).click(function () {
				_top_cache.attr("class", "week_normal");
				_top_cache = $(this).attr("class", "week_active");
				_data_line_length = parseInt($(this).html());
				date_line.remove();
			});
		}
	}
	
	this.yList = function(){
		var _list_bg_right = _yCalendar.find(".list_bg_right");
		var $slideup = true;
		var $all = $("*");
		var $length = 0;
		var _selection_bg_left = _yCalendar.find(".selection_bg_left");
		var _cache;
		for(var j=0;j<_list_bg_right.length;j++){
			var _list_area = _list_bg_right.eq(j).parent().find(".list_area");
			var _selection_bg_main = _list_area.children("div");
			_cache = _list_bg_right.length-j;
			_list_bg_right.eq(j).parent().css("z-index",_cache);
			_list_bg_right.eq(j).mouseenter(function(){
				$slideup = false;
			}).mouseleave(function(){
				$slideup = true;
			}).click(function(){
				_cache = $(this).parent().find(".selection_bg_left");
				for(var k=0;k<_selection_bg_left.length;k++){
					if(_selection_bg_left.eq(k).css("display")=="block"){
						_selection_bg_left.eq(k).stop(true,true).slideUp(100);
					}
				}
				if(_cache.css("display")!="block"){
					_cache.stop(true,true).slideToggle(100);
				}
			});
			for(var i=0;i<_selection_bg_main.length;i++){
				$length = ($length>_selection_bg_main.eq(i).html().length)? $length:_selection_bg_main.eq(i).html().length;
				_selection_bg_main.eq(i).mouseenter(function(){
					$(this).css("background","#e1eff8");
				}).mouseleave(function(){
					$(this).css("background","none");
				}).click(function(){
					_cache = $(this).parent().parent().parent().parent().parent();
					_cache.parent().find(".list_bg_main").html($(this).html());
					_cache.stop(true,true).slideUp(100);
				});
			}
			_cache = 14*$length+18;
			_list_area.css("width",_cache);
			
			$all.click(function(){
				if($slideup){
					for(var m=0;m<_selection_bg_left.length;m++){
						if(_selection_bg_left.eq(m).css("display")=="block"){
							_selection_bg_left.eq(m).stop(true,true).slideUp(100);
						}
					}
				}
			});
		}
	}
	this.alert = function(){
		alert("asd");
	}
}
