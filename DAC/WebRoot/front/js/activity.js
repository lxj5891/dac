$(document).ready(function () {

	//全局方法调用
	Add_nevigation();
//	Add_idCard();
	Add_myButton();
	Add_activityListButton();
	Add_fri();
	Add_white_button();
	Add_activity();
	Add_doingButton();
	Add_hotActivity_button();
	Add_mapButton();
	Add_mapIcon();
//	Add_friList();
	Add_head_pic();
	Add_friends_list();
	Add_status();
	people_tabs();
	//全局滚动变量
	var hot_recommend_div = $(".recommend > div");
	var hot_drag = hot_recommend_div.eq(0);
	var hot_scroll = hot_recommend_div.eq(2);
	var hot_main = hot_scroll.children(".recommend_main");
	var hot_dragArray = hot_main.children(".recommend_div");
	
	var _list_scroll = $(".list_scroll");
	var _list_main = _list_scroll.children(".list_main");
	var _list_single = _list_main.children(".list_single");
	var _list_single_drag = $(".list_single_drag");
	
	var _friList_scroll = $(".friList_scroll");
	var _friList_main = _friList_scroll.children(".friList_main");
	var _friList_single = _friList_main.children(".friSingle");
	var _fri_drag = _friList_scroll.children(".fri_drag");
	
	var white_body2 = $("#activity .white .body2");
	var white_scroll = white_body2.children("._scroll");
	var white_drag = white_body2.children(".drag");
	var white_main = white_scroll.children("._main");
	var white_singleHeight = white_main.children("._singleHeight");
	
	var _locker_rec = $(".locker_rec > div");
	var _locker_rec_drag = _locker_rec.eq(0);
	var _locker_rec_scroll = _locker_rec.eq(2);
	var _locker_rec_main = _locker_rec_scroll.children(".locker_rec_main");
	var _locker_height_array = _locker_rec_main.children(".locker_rec_div");
	
	//全局滚动条调用
	_allDrag(_locker_rec_main, _locker_height_array, _locker_rec_scroll, _locker_rec_drag, 54, 382);
	_allDrag(hot_main, hot_dragArray, hot_scroll, hot_drag, 30, 384);
	_allDrag(white_main, white_singleHeight, white_scroll, white_drag, 0, 125);
	_allDrag(_friList_main, _friList_single, _friList_scroll, _fri_drag, 0, 190);
	_allDrag(_list_main, _list_single, _list_scroll, _list_single_drag, 0, 360);
	
	$(".see_tongbu").mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		var id = $(this).attr("no");
		location.href="home.do?command=other&homePersonId="+id;
	});
	
	$(".card_name").mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		var id = $(this).attr("no");
		location.href="home.do?command=other&homePersonId="+id;
	});
	
});
