var yCalendar = function () {
	
	var _yCalendar = $("#yCalendar");
	var _top_cache;
	var _c_name;
	
	//时间初始化
	var $date = new Date();
	var _year = $date.getFullYear();
	var _month = $date.getMonth()+1;
	var _day = $date.getDate();
	var _getday = $date.getDay();
	
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
	
	var _weekCN = ["一", "二", "三", "四", "五", "六", "日"];
	
	getThisWeek();
	
	function getThisWeek() {
		var _today = 0;
		if (_year % 400 == 0 || _year % 4 == 0 && _year % 100 != 0) {
			monthArray = new Array(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		} else {
			monthArray = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		}
		for (var i = 0; i < _month-1; i++) {
			_today += monthArray[i];
		}
		$this_week = parseInt((_today+_day) / 7);
		if (_getday > 1) {
			_day = _day - (_getday - 1);
			if(_day<=0){
				_day += monthArray[_month];
				_month--;
			}
		} else if(_getday == 0){
			_day = _day - 6;
			if(_day<=0){
				if(_month==1){
					_day += monthArray[11];
					_month=12;
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
		if (_getday != 0 && i==(_getday-1)) {
			_data_bottom_line += '<div id="c_bottom_active"></div>';
			if (i == 5) {
				_date_top += '<div id="week_active"><div id="weekend_front_active">' + _weekCN[i] + '</div></div>';
			} else {
				_date_top += '<div id="week_active">' + _weekCN[i] + '</div>';
			}
		} else if (_getday == 0 && i == 6) {
			_data_bottom_line += '<div id="c_bottom_active"></div>';
			_date_top += '<div id="week_active"><div id="weekend_back_active">'+ _weekCN[i] +'</div></div>';
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
	this.drawMain = function (){
		//刷出内容
		for (var k = 0; k < _data_line_length; k++) {
			for (var i = 0; i < 7; i++) {
				if (_blank_control) {
					if(_blank_number>=6){
						_blank_control = false;
						_blank_number = -1;
					}
					if (_getday != 0 && i == (_getday-1) || _getday == 0 && i == 6) {
						_data_line_data += '<div class="date_active_blank"></div>';
						_blank_number++;
					} else {
						_data_line_data += '<div class="date_normal_blank"></div>';
						_blank_number++;
					}
				} else {
					if (_getday != 0 && i == (_getday-1) || _getday == 0 && i == 6) {
						if (_month == ($date.getMonth()+1) && _day == $date.getDate() && _year==$date.getFullYear()) {
							_data_line_data += '<div class="date_active" style="background:#eff4f8;"><div class="today_txt">' + _month + "月" +  _day + "今天" + '</div></div>';
						} else {
							if (k == 0) {
								_data_line_data += '<div class="date_active"><div class="active_txt"><span class="had_color">' + _month + "月" + _day + "今天" + '</span></div></div>';
							} else {
								_data_line_data += '<div class="date_active"><div class="active_txt">' + _month + "月" + _day + '</div></div>';
							}
						}
					} else {
						if (k == 0) {
								alert("asd");
							_data_line_data += '<div class="date_normal"><span class="had_color">' + _month + "月" + _day + '</span></div>';
						} else {
							_data_line_data += '<div class="date_normal">' + _month + "月" + _day + '</div>';
						}
					}
					_day++;
					if (_day > monthArray[_month - 1]) {
						_day = 1;
						_month++;
						if(_month>12){
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
				_data_line += '<div class="date_line">' +
				'<div id="week_left"></div>' +
				_data_line_data +
				'<div id="week_right"></div>' +
				'</div>';
				_data_line_data = "";
			} else {
				_data_line += '<div class="date_line">' +
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
	
	this.setTop = function () {
		var _weekArray = _yCalendar.find("#c_right").children();
		for (var i = 0; i < _weekArray.length; i++) {
			if (_weekArray.eq(i).attr("class") == "week_active") {
				_top_cache = _weekArray.eq(i);
			}
			_weekArray.eq(i).click(function () {
				_top_cache.attr("class", "week_normal");
				_top_cache = $(this).attr("class", "week_active");
				_data_line_length = parseInt($(this).html());
				_yCalendar.find("#c_main").empty();
			});
		}
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
	this.setTime = function ($time){
		_data_line_length = $time;
	}
}
