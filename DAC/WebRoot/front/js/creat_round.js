$(document).ready(function () {
	creat_round_check();
	creat_friend_check();
});

function creat_round_check(){
	var _check_object = $("#check_object div");
	for(var i=0;i<_check_object.length;i++){
		_check_object.eq(i).click(function(){
			for(var k=0;k<_check_object.length;k++){
				_check_object.eq(k).attr("class","check_no");
			}	
			$(this).attr("class","check_active");
		});
	}
}

function creat_friend_check(){
	var _friend_pics = $("#friend_pics .pic");
	var _this;
	for(var i=0;i<_friend_pics.length;i++){
		_friend_pics.eq(i).mouseover(function(){
			$(this).css("cursor","pointer");
		}).click(function(){
			_this = $(this).children(".pic_mask");
			if(_this.css("display")=="block"){
				_this.css("display","none");
			} else {
				_this.css("display","block");
			}
		});
	}
}