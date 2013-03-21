//好友列表方法
function Add_friends_list() {
	var _friends_list = $("#friends_list");
	var _friends_list_div = _friends_list.children("div");
	var _list_tab_main = $(".list_tab_main");
	var _list_div = _list_tab_main.children(".list_zhiding_main").children("div");
	var _list_scroll = $(".list_scroll");
	var _list_main = _list_scroll.children(".list_main");
	var _list_single = _list_main.children(".list_single");
	var _list_check_man = _list_div.eq(1);
	var _list_check_woman = _list_div.eq(2);
	var _list_check_look = _list_div.last();
	var _list_quanbu_main_div = $(".list_quanbu_main").children("div");
	for (var i = 0; i < _friends_list_div.length; i++) {
		_friends_list_div.eq(i).attr("number", i).mouseover(function () {
			if ($(this).attr("number") == 0 || $(this).attr("number") == 1 || $(this).attr("number") == 5 || $(this).attr("number") == 6) {}
			else {
				$(this).css("cursor", "pointer");
			}
		}).click(function () {
			if ($(this).attr("number") == 2 && _list_tab_main.css("left") != "0px") {
				$(this).attr("class", "button_tongbu_active");
				_friends_list_div.eq(3).attr("class", "button_zhiding");
				_friends_list_div.eq(4).attr("class", "button_quanbu");
				_list_tab_main.animate({
					"left" : "0"
				}, 500);
				//
			} else if ($(this).attr("number") == 3 && _list_tab_main.css("left") != "-100px") {
				$(this).attr("class", "button_zhiding_active");
				_friends_list_div.eq(2).attr("class", "button_tongbu");
				_friends_list_div.eq(4).attr("class", "button_quanbu");
				_list_tab_main.animate({
					"left" : "-100"
				}, 500);
			} else if ($(this).attr("number") == 4 && _list_tab_main.css("left") != "-200px") {
				$(this).attr("class", "button_quanbu_active");
				_friends_list_div.eq(2).attr("class", "button_tongbu");
				_friends_list_div.eq(3).attr("class", "button_zhiding");
				_list_tab_main.animate({
					"left" : "-200"
				}, 500);
			}
		});
	}
	for (var i = 0; i < _list_single.length; i++) {
		var _ed = _list_single.eq(i).children(".single_banner").children("div").eq(0);
		var _width = _list_single.eq(i).children(".single_banner").children("div").eq(2).html();
		_ed.css("width", _width);
	}
	
	_list_check_man.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if ($(this).attr("class") == "list_check") {
			$(this).attr("class", "list_check_active");
			_list_check_woman.attr("class", "list_check");
		}
	});
	_list_check_woman.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if ($(this).attr("class") == "list_check") {
			$(this).attr("class", "list_check_active");
			_list_check_man.attr("class", "list_check");
		}
	});
	_list_check_look.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//查找
	});
	for (var i = 0; i < _list_quanbu_main_div.length; i++) {
		_list_quanbu_main_div.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			var _number = $(this).attr("number");
			for (var x = 0; x < _list_quanbu_main_div.length; x++) {
				if (_list_quanbu_main_div.eq(x).attr("number") == _number) {
					_list_quanbu_main_div.eq(x).css("color", "#96c842");
				} else if (_list_quanbu_main_div.eq(x).attr("number") != _number) {
					_list_quanbu_main_div.eq(x).css("color", "#656363");
				}
			}
		});
	}
}
