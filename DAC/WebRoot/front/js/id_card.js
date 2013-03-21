//小名片
function Add_idCard() {
	var _tongbu_box = $(".tongbu_box");
	var _tongbu_per = _tongbu_box.children(".tongbu").children("span").html();
	var _tongbu_width = _tongbu_box.children(".tongbu_banner").children(".green");
	var id_card = $("#id_card");
	var card_show = $(".card_show");
	var _main = $("#main");
	var _card_time;
	var id_card = $("#id_card");
	var _white_people = $(".white_people");
	var _fri_click_right_pic_smallPic = $(".fri_click_right_pic").children("._smallPic");
	for (var i = 0; i < _white_people.length; i++) {
		_white_people.eq(i).children(".white_pic").mouseover(function (e) {
			$(this).css("cursor", "pointer");
			var _x = $(this).offset().left - 100;
			var _y = $(this).offset().top - 60;
			
			if (_x >= 887) {
				_x = 887;
			}
			id_card.css("left", _x).css("top", _y);
			if (id_card.css("display") == "none") {
				id_card.css("display","block");
				//id_card.slideDown("normal");
			} else {
				_card_timeClear();
			}
		}).mouseleave(function () {
			if (id_card.css("display") != "none") {
				_card_timeCount();
			}
		});
	}
	for (var i = 0; i < _fri_click_right_pic_smallPic.length; i++) {
		if(_fri_click_right_pic_smallPic.eq(i).parent().attr("round")!="true"){
		_fri_click_right_pic_smallPic.eq(i).mouseover(function (e) {
			$(this).css("cursor", "pointer");
			var _x = $(this).offset().left - 100;
			var _y = $(this).offset().top - 50;
			
			if (_x >= 887) {
				_x = 887;
			}
			id_card.css("left", _x).css("top", _y);
			if (id_card.css("display") == "none") {
				id_card.css("display","block");
				//id_card.slideDown("normal");
			} else {
				_card_timeClear();
			}
		}).mouseleave(function () {
			if (id_card.css("display") != "none") {
				_card_timeCount();
			}
		});
		}
	}
	id_card.mouseover(function () {
		_card_timeClear();
	}).mouseleave(function () {
		_card_timeCount();
	});
	
	//小名片方法
	_tongbu_width.css("width", _tongbu_per);
	var _height = id_card.outerHeight();
	id_card.mouseover(function () {
		_card_timeClear();
		//id_card.slideDown("normal");
	}).mouseleave(function () {
		_card_timeCount();
	});
	card_show.mouseover(function (e) {
		$(this).css("cursor", "pointer");
		var _x = $(this).offset().left - 100;
		var _y = $(this).offset().top - 75;
		id_card.css("left", _x).css("top", _y);
		id_card.css("display","block");
		//id_card.slideDown("normal");
		if (id_card.css("display") == "block") {
			_card_timeClear();
		}
	}).mouseleave(function () {
		_card_timeCount();
	});
}

function _card_timeCount() {
	_card_time = setTimeout("id_card_hide()", 700);
}

function id_card_hide() {
	$("#id_card").css("display","none");
	//$("#id_card").slideUp("normal");
}

function _card_timeClear() {
	clearTimeout(_card_time);
}
