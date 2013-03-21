function setInput(){
	var _input = $("#login").find("#input").children();
	var _input_object = _input.find("input");
	var _color_lock = false;

	for(var i=0;i<_input.length;i++){
		_input.eq(i).attr("number",i).mouseenter(function(){
			setTextColor($(this),"#000");
		}).mouseleave(function(){
			setTextColor($(this),"#888");
		});
	}

	for(var i=0;i<_input_object.length;i++){
		_input_object.eq(i).attr("number",i).focus(function(){
			setInputColor($(this),"#000",true,"input_active");
		}).blur(function(){
			setInputColor($(this),"#888",false,"input_normal");
		});
	}

	function setTextColor(_this,_color){
		if(!_color_lock){
			var _input_style = _this.find(".input_style");
			_this.css("color",_color);
			_input_style.css("color",_color);
		}
	}

	function setInputColor(_this,_color,_lock,_class){
		_color_lock = _lock;
		var _cache = _this.attr("number");
		_input_object.eq(_cache).css("color",_color);
		_input.eq(_cache).css("color",_color).attr("class",_class);
	}
}

function setRememberButton(){
	var _ctrl_button = $("#login").find("#ctrl").children("div");
	_ctrl_button.click(function(){
		if($(this).attr("id")=="ctrl_active"){
			$(this).attr("id","ctrl_normal").next().html("不记住账号");
		} else {
			$(this).attr("id","ctrl_active").next().html("记住账号");
		}
	});
}

function setSelectButton(_number){
	var _select = $("#select");
	var _buttons = _select.children();
	var _cache = _buttons.eq(_number);
	for(var i=0;i<_buttons.length;i++){
		_buttons.eq(i).click(function(){
			if($(this).attr("class")=="normal"){
				_cache.attr("class","normal");
				$(this).attr("class","active");
				_cache = $(this);
				if($(this).html()=="选择你的城市"){
					cityIn();
				} else {
//					schoolIn();
				}
			}
		});
	}
}

function cityIn(){
	var _city = $("#city");
	var _school = $("#school");
	_city.fadeIn();
	_school.fadeOut();
}

function schoolIn(){
	var _city = $("#city");
	var _school = $("#school");
	_school.fadeIn();
	_city.fadeOut();
}

function setChangeCity(){
	var _city;
	var _city_name;
	var _city_hot = $("#city_hot");
	var _hot_single = _city_hot.children(".hot_single");
	for(var i=0;i<_hot_single.length;i++){
		_hot_single.eq(i).mouseenter(function(){
			_city_name = $(this).attr("cityName");
			_city = $("#"+_city_name);
			_city.attr("id",_city_name+"_active");
			$(this).children().css("display","block");
		}).mouseleave(function(){
			_city.attr("id",_city_name);
			$(this).children().css("display","none");
		});
	}
}

function setLabel(){
	var _obejct = $(".label_object");
	var _cut_object = $("#cut_object");
	var _cut = _cut_object.children("#cut");
	var _center_contain = $("#center_contain");
	var _cache;
	var _handle_cache;
	function LabelBehav(_type){
		_handle_cache = _cache.find("."+_type+"label_handle");
		_handle_cache.animate({top:"+=10px"},200).fadeOut("200",function(){
			_handle_cache.remove();
		});
		_cache.parent().find(".box_normal").attr("class","box_"+_type+"active");
	}
	for(var i=0;i<_obejct.length;i++){
		_obejct.eq(i).mouseenter(function(){
			if($(this).find(".Rlabel_handle").length>0||$(this).find(".Ylabel_handle").length>0){
				_cut_object.css("left",$(this).parent().position().left+55).stop(true,true).fadeIn("400");
			}
		}).mouseleave(function(){
			_cut_object.css("display","none");
			_cut.stop(true,true).css("display","block").css("left","0px");
		}).click(function(){
			_cut.animate({left:"-=40px"},200).fadeOut("200");
			_cache = $(this);
			if(_cache.find(".Rlabel").length>0){
				LabelBehav("R");
			} else {
				LabelBehav("Y");
			}
			//投票操作
			var check=VOTE.vote($(this).attr('code'));
			if(check==1){
				//投票数自加
				var voteCount=$(this).parent().children('.Rtext');
				var voteCounts=voteCount.html();
				voteCounts.split("票");
				var counts=parseInt(voteCounts[0]);
				counts++;
				voteCount.html(counts+"票");
				
			}
		});
	}
}