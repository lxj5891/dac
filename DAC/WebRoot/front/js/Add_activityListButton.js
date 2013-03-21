//该区域所有活动图片列表方法
function Add_activityListButton() {
	var activityList_button = $(".activity_list > span");
	var activity_list_pic = $(".activity_list_pic").children("ul");
	var activity_list_pic_selec = activity_list_pic.children("li");
	var activity_list_pics = activity_list_pic_selec.length - 5;
	var past_pic = 0;
	activityList_button.eq(0).click(function () {
		if (past_pic <= 0) {
			return false;
		} else {
			activity_list_pic.animate({
				"left" : "+=34"
			}, 400);
			past_pic--;
		}
	});
	activityList_button.eq(1).click(function () {
		if (past_pic >= activity_list_pics) {
			return false;
		} else {
			activity_list_pic.animate({
				"left" : "-=34"
			}, 400);
			past_pic++;
		}
	});
	for (var i = 0; i < activityList_button.length; i++) {
		activityList_button.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		});
	}
	for (var i = 0; i < activity_list_pic_selec.length; i++) {
		activity_list_pic_selec.eq(i).attr("number", i);
		activity_list_pic_selec.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			var _this_number = $(this).attr("number");
			$(this).css("border-color", "#666");
			for (var k = 0; k < activity_list_pic_selec.length; k++) {
				if (activity_list_pic_selec.eq(k).attr("number") != _this_number) {
					activity_list_pic_selec.eq(k).css("border-color", "#FFF");
				}
			}
		});
	}
}

//该区域所有活动_响应、关注、留言方法
function Add_doingButton() {
	var doing_button = $(".white .body > span");
	for (var i = 0; i < doing_button.length; i++) {
		doing_button.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		});
	}
}
