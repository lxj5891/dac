//显示locker方法
function Add_locker() {
	var _locker = $("#locker");
	var _locker_bg = $("#locker .locker_bg");
	_locker.fadeIn("normal");
	_locker_bg.fadeTo(10, 0.5);
}

////隐藏locker方法
function Remove_locker() {
	var _locker = $("#locker");
	var _locker_bg = $("#locker .locker_bg");
	_locker.fadeOut("normal");
	_locker_bg.fadeTo(10, 0.5);
}
