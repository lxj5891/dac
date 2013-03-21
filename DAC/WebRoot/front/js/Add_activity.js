//右下角活动推荐方法
function Add_activity() {
	var activity_mask_remove = $("#remove_mask_button");
	var activity_mask_button = activity_mask_remove.children("#activity_mask_button");
	var activity_mask = $("#activity_mask");
	//右下角变量
	var _hot_toggle = $("#hot_toggle");
	var _animate_main = $(".animate_main");
	var _school_more = $(".school_more");
	var _school_top_tab = $(".school_top_title_s").children();
	var _school_ten = $("#school_ten");
	var _school_ten_main_icon = $("#school_ten_main_icon");
	
	Add_activity_button();
	
	function Add_activity_button() {
		activity_mask_button.mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
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
		});
	}
	
	function _activity_mask() {
		activity_mask_remove.css("display", "block");
		activity_mask.animate({
			"height" : "45"
		}, 500);
		activity_mask_button.animate({
			"top" : "45"
		}, 500);
	}
	for (var i = 0; i < _school_top_tab.length; i++) {
		_school_top_tab.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			for (var j = 0; j < _school_top_tab.length; j++) {
				_school_top_tab.eq(j).attr("class", "single");
			}
			if ($(this).attr("class") == "single") {
				$(this).attr("class", "single_active");
			}
		});
	}
	_school_more.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		_hot_toggle.slideUp("normal", function () {
			_school_ten.slideDown("normal",function(){
				_school_ten_main_icon.fadeIn(150);
			});
		});
		_activity_mask();
	});
}

function people_tabs(){
	var people_tabs = $("#people_tabs").children();
	people_tabs.click(function(){
		if($(this).attr("id")=="people_friend"){
			$(this).attr("id","people_unknow");
		} else {
			$(this).attr("id","people_friend");
		}
	});
}
