function Add_mapButton() {
	var map_tab = $(".map .tab");
	var map_object = map_tab.children("div");
	var map_button1 = map_object.eq(0);
	var map_button2 = map_object.eq(1);
	var map_button_control = true;
	var getActivity_icon = $(".activity_icon");
	var getFriends_icon = $(".friends_icon");
	var map_block = map_object.eq(2);
	//该区域变量
	var _acfr_main = $(".acfr_main");
	map_button1.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
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
	});
	map_button2.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_acfr_main.animate({
			"left" : "-565"
		}, 500);
		if (map_button_control) {
			map_block.animate({
				"left" : "57"
			}, 500);
			getActivity_icon.slideUp("slow");
			getFriends_icon.slideDown("slow");
			map_button_control = false;
		}
	});
}
function Add_mapIcon() {
		var map_div = $(".map > div");
		var activity_icon = map_div.eq(1);
		var firends_icon = map_div.eq(2);
		var getFriends_icon = $(".friends_icon");
//		activity_array();
//		friends_array();
		for (var i = 0; i < getFriends_icon.children("div").length; i++) {
			getFriends_icon.children("div").eq(i).mouseover(function () {
				$(this).css("cursor", "pointer");
			}).click(function () {
				//地图好友点击
			});
		}
//		function friends_array() {
//			Add_firends(1, 150, 240);
//			Add_firends(1, 250, 340);
//			Add_firends(1, 220, 320);
//			Add_firends(1, 310, 120);
//			Add_firends(1, 420, 270);
//			Add_firends(2, 180, 330);
//			Add_firends(2, 240, 180);
//			Add_firends(2, 168, 198);
//			Add_firends(2, 370, 370);
//			Add_firends(2, 227, 290);
//			Add_firends(2, 310, 315);
//		}
		function Add_firends(_class, _left, _top) {
			if (_class == 1) {
				var icon = $("<div class='friends_icon1'></div>");
			} else if (_class == 2) {
				var icon = $("<div class='friends_icon2'></div>");
			}
			firends_icon.append(icon);
			firends_icon.children("div").last().css("left", _left).css("top", _top);
		}
//		function activity_array() {
//			Add_activityIcon("orange", 150, 240);
//			Add_activityIcon("orange", 300, 300);
//			Add_activityIcon("orange", 240, 120);
//			Add_activityIcon("orange", 430, 260);
//			Add_activityIcon("orange", 350, 160);
//			Add_activityIcon("orange", 190, 360);
//			Add_activityIcon("orange", 400, 160);
//			Add_activityIcon("blue", 180, 270);
//			Add_activityIcon("blue", 210, 300);
//			Add_activityIcon("blue", 310, 120);
//			Add_activityIcon("blue", 450, 320);
//			Add_activityIcon("blue", 270, 200);
//			Add_activityIcon("green", 340, 240);
//			Add_activityIcon("green", 280, 390);
//			Add_activityIcon("green", 380, 270);
//		}
		function Add_activityIcon(_color, _left, _top) {
			if (_color == "orange") {
				var icon = $("<div class='orange_activity'></div>");
			} else if (_color == "blue") {
				var icon = $("<div class='blue_activity'></div>");
			} else if (_color == "green") {
				var icon = $("<div class='green_activity'></div>");
			}
			activity_icon.append(icon);
			activity_icon.children("div").last().css("left", _left).css("top", _top);
		}
	}