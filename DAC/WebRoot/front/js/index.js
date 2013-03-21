$(document).ready(function () {
	var _hours = 23;
	var _minutes = 1;
	var _seconds = 2;
	timeMove(_hours,_minutes,_seconds);
	setInput();
});

var _getHours;
var _getMinutes;
var _getSeconds;

function timeMove(_hours,_minutes,_seconds) {
	_getHours = _hours;
	_getMinutes = _minutes;
	_getSeconds = _seconds;
	var stringHours = _getHours + "";
	var stringMinutes = _getMinutes + "";
	var stringSeconds = _getSeconds + "";
	var _top_banner_txt = $('#top_banner span');
	var _timeString;
	var timer;
	if(_getHours<10){
		stringHours = "0"+_getHours;
	}
	if(_getMinutes<10){
		stringMinutes = "0"+_getMinutes;
	}
	if(_getSeconds<10){
		stringSeconds = "0"+_getSeconds;
	}
	_timeString = stringHours + ":" + stringMinutes + ":" + stringSeconds;
	_top_banner_txt.html(_timeString);
	if (_getSeconds == 0) {
		_getMinutes--;
		_getSeconds = 59;
		if(_getMinutes == -1){
			_getHours--;
			_getMinutes = 59;
		}
	} else {
		_getSeconds--;
	}
	timer = setTimeout("timeMove(_getHours,_getMinutes,_getSeconds)", 1000);
}
function setInput(){
	var _input_object = $('#input_object').children();
	var _button_object = $('#button_object').children();
	_input_object.eq(0).val('邮箱').focus(function(){
		if($(this).val()=='邮箱'){
			$(this).val('');
		}
	}).blur(function(){
		if($(this).val()==''){
			$(this).val('邮箱');
		}
	});
	_input_object.eq(1).val('密码').focus(function(){
		if($(this).val()=='密码'){
			$(this).val('');
		}
	}).blur(function(){
		if($(this).val()==''){
			$(this).val('密码');
		}
	});
	_button_object.eq(0).mouseover(function(){
		$(this).css('cursor','pointer');
	}).click(function(){
		alert('登录');
	});
}
