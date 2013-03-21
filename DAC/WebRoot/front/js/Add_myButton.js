//My按钮方法
function Add_myButton() {
	var my_button = $(".mywidth").children();
	var _animate_main = $(".animate_main");
	var _school_icon = $("#school_icon");
	my_button.eq(0).children().animate({
		"height" : "18"
	}, "fast");
	for (var i = 0; i < my_button.length; i++) {
		my_button.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "mycity") {
				$(this).children().animate({
					"height" : "18"
				}, "fast");
				my_button.eq(1).children().animate({
					"height" : "7"
				}, "fast");
				_animate_main.animate({
					"left" : 0
				}, 500);
				_school_icon.fadeOut(100);
			}
			if ($(this).attr("class") == "myschool") {
				$(this).children().animate({
					"height" : "18"
				}, "fast");
				my_button.eq(0).children().animate({
					"height" : "7"
				}, "fast");
				_animate_main.animate({
					"left" : -570
				}, 500,function(){
					_school_icon.fadeIn(100);
				});
			}
		});
	}
}
