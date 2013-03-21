$(document).ready(function () {
	alert_object("message","asd", "123123");
})

function alert_object(_type, _title, _main) {
	if (_type == "message") {
		var _alert_object_div = '<div id="alert_object"><div class="alert_object_bottom"><div class="alert_object_middle"><div class="top_bg">' + _title + '</div><div class="main_bg">' + _main + '</div></div></div></div>';
		$("div:first").before(_alert_object_div);
	}
	if (_type == "check_message") {
		var _alert_object_div = '<div id="alert_object"><div class="alert_object_bottom"><div class="alert_object_middle"><div class="check_main_bg"><div class="check_main_tx">' + _title + '</div><div class="check_main_button"><div class="button"><span>确认</span>&nbsp;&nbsp;<span>取消</span></div></div></div></div></div>';
		$("div:first").before(_alert_object_div);
		var _check_main_button = $(".check_main_button span");
		_check_main_button.eq(0).mouseover(function(){
			$(this).css("cursor","pointer");
		}).click(function(){
			_alert_object.slideUp("normal");
			return true;
		});
		_check_main_button.eq(1).mouseover(function(){
			$(this).css("cursor","pointer");
		}).click(function(){
			_alert_object.slideUp("normal");
			return false;
		});
	}
	var _x;
	var _y;
	var _alert_object;
	var _object_x;
	var _object_y;
	var _timer;
	var setTimer = function () {
		if (_type == "message"){
			_timer = setTimeout(function () {
				_alert_object.slideUp("normal");
			}, 1500);
		}
	};
	function resize() {
		_x = $(document).width() / 2;
		_y = $(document).height() / 2;
		_alert_object = $("#alert_object");
		_object_x = _alert_object.outerWidth() / 2;
		_object_y = _alert_object.outerHeight() / 2;
		_alert_object.css("left", _x - _object_x).css("top", _y - _object_y);
		_alert_object.slideDown("normal");
	}
	resize();
	setTimer();
	$(window).resize(function () {
		resize();
	});
	
}
