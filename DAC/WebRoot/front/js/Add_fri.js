//该区域所有好友方法
function Add_fri() {
	var _return_icon = $(".return_icon");
	var _acfr_main = $(".acfr_main");
	_return_icon.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_acfr_main.animate({
			"left" : "-565"
		}, 500);
	});
}
