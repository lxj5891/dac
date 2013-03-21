//日历函数
function dates(val) {
	val.datepicker({
		changeMonth : true,
		changeYear : true
	});
};
	

function addRoundDocument(){
//round_document页面发布框
	var _out_object = $("#document .combo .new_box .tool_panel");
	var _out_object_buttons = _out_object.children(".three").children("div");
	var _slide_video = $("#document .aslide_video");
	var _slide_video_button = _slide_video.children(".yes_button");
	var _slide_audio = $("#document .aslide_audio");
	var _slide_audio_button = _slide_audio.children(".yes_button");
	var _slide_image = $("#document .aslide_image");
	var _slide_image_button = _slide_image.children(".up_load_button");
	_slide_video_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		alert("_slide_video_yes_button");
	});
	_slide_audio_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		alert("_slide_audio_yes_button");
	});
	_slide_image_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//点击本地上传
		_slide_image_button.html("继续添加");
	});
	for (var i = 0; i < _out_object_buttons.length; i++) {
		_out_object_buttons.eq(i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("class") == "_out_video") {
				if (_slide_audio.css("display") == "block") {
					_slide_audio.slideUp(200, function () {
						_slide_video.slideDown(200);
					});
				} else if (_slide_image.css("display") == "block") {
					_slide_image.slideUp(200, function () {
						_slide_video.slideDown(200);
					});
				} else {
					_slide_video.slideToggle(200);
				}
			} else if ($(this).attr("class") == "_out_audio") {
				if (_slide_video.css("display") == "block") {
					_slide_video.slideUp(200, function () {
						_slide_audio.slideDown(200);
					});
				} else if (_slide_image.css("display") == "block") {
					_slide_image.slideUp(200, function () {
						_slide_audio.slideDown(200);
					});
				} else {
					_slide_audio.slideToggle(200);
				}
			} else if ($(this).attr("class") == "_out_image") {
				if (_slide_video.css("display") == "block") {
					_slide_video.slideUp(200, function () {
						_slide_image.slideDown(200);
					});
				} else if (_slide_audio.css("display") == "block") {
					_slide_audio.slideUp(200, function () {
						_slide_image.slideDown(200);
					});
				} else {
					_slide_image.slideToggle(200);
				}
			}
		});
	}
	
	//round_document 控制函数
	$('#document .width .combo .new_box .type_panel .type_panel_select').click(function () {
		$('#document .option_box').css("display", "block");
	})
	$('#document .option_box .option1').click(function () {
		$('#document .width .combo .new_box .type_panel .type_panel_select .type_panel_select_text').html("原&nbsp;&nbsp;创");
		$('#document .option_box').css("display", "none");
	})
	$('#document .option_box .option2').click(function () {
		$('#document .width .combo .new_box .type_panel .type_panel_select .type_panel_select_text').html("分&nbsp;&nbsp;享");
		$('#document .option_box').css("display", "none");
	})
	$('#document .width .combo .new_box .two_button .out_button').click(function () {
		alert("已发布");
	})
	$('#document .width .combo .new_box .two_button .cancel_button').click(function () {
		$('.black').css("display", "none");
		$('#document').slideUp(200);
	})
	$('#document .width .combo .new_box .type_panel .save_button').click(function () {
		alert("已保存");
	})
	$('#document .width .combo .new_box .tool_panel .button_b').toggle(
		function () {
		$('#document .width .combo .new_box .text_panel .text_panel_text').css("font-weight", "bold");
	},
		function () {
		$('#document .width .combo .new_box .text_panel .text_panel_text').css("font-weight", "normal");
	})
	$('#document .width .combo .new_box .tool_panel .button_i').toggle(
		function () {
		$('#document .width .combo .new_box .text_panel .text_panel_text').css("font-style", "italic");
	},
		function () {
		$('#document .width .combo .new_box .text_panel .text_panel_text').css("font-style", "normal");
	})
	$('#document .width .combo .new_box .tool_panel .button_u').toggle(
		function () {
		$('#document .width .combo .new_box .text_panel .text_panel_text').css("text-decoration", "underline");
	},
		function () {
		$('#document .width .combo .new_box .text_panel .text_panel_text').css("text-decoration", "none");
	})
	$('#document .width .combo .new_box .new_write_here .write_text').focus(function () {
		if ($(this).attr("value") == "在这里输入日志标题") {
			$(this).attr("value", "")
		};
	})
	$('#document .width .combo .new_box .new_write_here .write_text').blur(function () {
		if ($(this).attr("value") == "") {
			$(this).attr("value", "在这里输入日志标题")
		};
	})
	//activity_search界面
	$('#background .semain_box .result .result_child .message .result_button .friend_button').click(function () {
		$(this).css("background", "url('')");
		$(this).text('已加好友');
	})
	$('#background .semain_box .result .result_child .message .result_button .agree_button').click(function () {
		$(this).css("background", "url('')");
		$(this).text('已响应');
	})
	$('#background .semain_box .result .result_child .message .result_button .care_button').click(function () {
		$(this).css("background", "url('')");
		$(this).text('已关注');
	})
	$('#background .semain_box .result .result_child .message .result_button .join_button').click(function () {
		$(this).css("background", "url('')");
		$(this).text('已加入');
	})
	$('#background .semain_box .search_textbox .power_search').click(function () {
		window.location.href = 'activity_search_main.html';
	})
	$('#background .semain_box .search_textbox .search_button').click(function () {
		alert('正在查找');
	})
	//search页面的查找滑块
	$('#background .semain_box .scroll_panel .all_button').mouseover(function () {
		$('#move_button').animate({
			left : '346px'
		}, 200)
	})
	$('#background .semain_box .scroll_panel .name_button').mouseover(function () {
		$('#move_button').animate({
			left : '498px'
		}, 200)
	});
	$('#background .semain_box .scroll_panel .round_button').mouseover(function () {
		$('#move_button').animate({
			left : '652px'
		}, 200)
	})
	$('#background .semain_box .scroll_panel .act_button').mouseover(function () {
		$('#move_button').animate({
			left : '802px'
		}, 200)
	})
	$('#move_button').click(function () {
		if ($(this).css("left") == "346px") {
			window.location.href = 'activity_search_all.html';
		} else if ($(this).css("left") == "498px") {
			window.location.href = 'activity_search_name.html';
		} else if ($(this).css("left") == "652px") {
			window.location.href = 'activity_search_round.html';
		} else if ($(this).css("left") == "802px") {
			window.location.href = 'activity_search_activity.html';
		}
	})
	
	//search_main变量
	var _activity_main = $(".activity_main");
	var _activity_main_div = _activity_main.children("div");
	var _ac_main = _activity_main.children(".ac_scroll").children(".ac_main");
	$('.left_buttons .activity_button').mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		$('.black_box').animate({
			"top" : "195px"
		}, 500);
		_ac_main.animate({
			"top" : "15"
		}, 500);
	});
	$('.left_buttons .friend_button').mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		$('.black_box').animate({
			"top" : "245px"
		}, 500);
		_ac_main.animate({
			"top" : "-595"
		}, 500);
	});
	$('.left_buttons .round_button').mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		$('.black_box').animate({
			"top" : "295px"
		}, 500);
		_ac_main.animate({
			"top" : "-1205"
		}, 500);
	});
	//tip框弹出
	$('.find_more').click(function () {
		if ($('.out_tip_box').css("display") == "none") {
			var _mainTop = $(this).offset().top - 310 + 'px';
			var _mainWidth = $(this).offset().left - 40 + 'px';
			var card_x = _mainTop;
			var card_y = _mainWidth;
			$('.out_tip_box').css("left", card_y).css("top", card_x);
			$('.out_tip_box').slideDown("normal");
			if ($('.black_tiyu').css("display") == "none") {
				$('.black_tiyu').slideUp(100, function () {
					$('.black_tiyu').css("display", "block");
				})
			}
		}
	})
	$('.out_tip_box .cancel').click(function () {
		$('.out_tip_box').slideUp("normal");
		if ($('.black_tiyu').css("display") == "block") {
			$('.black_tiyu').slideUp(100, function () {
				$('.black_tiyu').css("display", "none");
			})
		}
	})
	//tip框弹出结束
	//search_main活动select按钮
	var _date_select_button = $(".find_big .select").children("div");
	for (var i = 0; i < _date_select_button.length; i++) {
		_date_select_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 1) {
				//中型
				$(this).attr("class", "single_active");
				_date_select_button.eq(2).attr("class", "single");
				_date_select_button.eq(3).attr("class", "single");
				_date_select_button.eq(0).attr("class", "single");
			} else if ($(this).attr("number") == 2) {
				//大型
				$(this).attr("class", "single_active");
				_date_select_button.eq(1).attr("class", "single");
				_date_select_button.eq(3).attr("class", "single");
				_date_select_button.eq(0).attr("class", "single");
			} else if ($(this).attr("number") == 3) {
				//特大型
				$(this).attr("class", "single_active");
				_date_select_button.eq(0).attr("class", "single");
				_date_select_button.eq(1).attr("class", "single");
				_date_select_button.eq(2).attr("class", "single");
			} else if ($(this).attr("number") == 0) {
				//小型
				$(this).attr("class", "single_active");
				_date_select_button.eq(1).attr("class", "single");
				_date_select_button.eq(2).attr("class", "single");
				_date_select_button.eq(3).attr("class", "single");
			}
		});
	}
	//select按钮结束
	//search_main性别select按钮
	var _sex_select_button = $(".find_sex .select").children("div");
	for (var i = 0; i < _date_select_button.length; i++) {
		_sex_select_button.eq(i).attr("number", i).mouseover(function () {
			$(this).css("cursor", "pointer");
		}).click(function () {
			if ($(this).attr("number") == 0) {
				//male
				$(this).attr("class", "single_active");
				_sex_select_button.eq(1).attr("class", "single");
			} else if ($(this).attr("number") == 1) {
				//female
				$(this).attr("class", "single_active");
				_sex_select_button.eq(0).attr("class", "single");
			}
		});
	}
	$('.activity_main .ac_main .find_main .bottom_button').click(function () {
		alert("查找跳转");
	})
	$('.activity_main .ac_main .info_main .bottom_button').click(function () {
		alert("查找跳转");
	})
	$('.activity_main .ac_main .friends_main .bottom_button').click(function () {
		alert("查找跳转");
	})
	$('.out_tip_box .next_page').click(function () {
		alert("下一页");
	})
	//search_main性别select按钮结束
	//隐私
	var private_num;
	$('#private_base').children('div').children('.pri_selectbox').click(function () {
		private_num = $('.pri_selectbox').index(this);
		var ntop = $(this).offset().top - 22;
		$('.select_box').css("top", ntop);
		$('.select_box').slideToggle(200);
	})
	$('#private_base .select_box').children("div").mouseover(function () {
		$(this).css("cursor", "pointer");
		$(this).css("background", "url('images/personal_set/white_box.png')");
	}).mouseout(function () {
		$(this).css("background", "url('')");
	}).click(function () {
		if ($(this).index() == 0) {
			$('.pri_selectbox').eq(private_num).html("所有人可见");
		} else if ($(this).index() == 1) {
			$('.pri_selectbox').eq(private_num).html("好友及同城的人及学校的人可见");
		} else if ($(this).index() == 2) {
			$('.pri_selectbox').eq(private_num).html("仅我的好友");
		} else if ($(this).index() == 3) {
			$('.pri_selectbox').eq(private_num).html("仅自己");
		}
		$('#private_base .select_box').slideUp(200);
	})
	
	$('#cannot_see .scroll_box .user_button').click(function () {
		$('#cannot_see .run_box').animate({
			left : '12px'
		}, 200);
		$('#cannot_see .pingbi_active').animate({
			left : '1000px'
		}, 200);
		$('#cannot_see .pingbi_round').animate({
			left : '2000px'
		}, 200);
		$('#cannot_see .pingbi_user').animate({
			left : '0px'
		}, 200);
	});
	$('#cannot_see .scroll_box .active_button').click(function () {
		$('#cannot_see .run_box').animate({
			left : '165px'
		}, 200);
		$('#cannot_see .pingbi_round').animate({
			left : '2000px'
		}, 200);
		$('#cannot_see .pingbi_user').animate({
			left : '1000px'
		}, 200);
		$('#cannot_see .pingbi_active').css('display', 'block');
		$('#cannot_see .pingbi_active').animate({
			left : '0px'
		}, 200);
	});
	$('#cannot_see .scroll_box .round_button').click(function () {
		$('#cannot_see .run_box').animate({
			left : '318px'
		}, 200);
		$('#cannot_see .pingbi_user').animate({
			left : '1000px'
		}, 200);
		$('#cannot_see .pingbi_active').animate({
			left : '2000px'
		}, 200);
		$('#cannot_see .pingbi_round').css('display', 'block');
		$('#cannot_see .pingbi_round').animate({
			left : '0px'
		}, 200);
	});
	//隐私结束
	
	dates($('#datepicker'));
	dates($('.find_time .f_box_city'));
}
