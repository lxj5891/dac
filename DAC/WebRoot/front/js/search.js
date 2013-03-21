$(document).ready(function () {

	//全局方法调用
	Add_nevigation();
	Add_head_pic();
	Add_search_tab();//添加搜索分类
	Add_search_percent("percent");//添加正文百分比
	Add_search_percent("r_percent");//添加又侧百分比
	Add_search_advance();//添加高级搜索
	Add_search_check("check");//搜索单选框
	Add_search_check("acti_check");//搜索单选框
	Add_hot_button();//热门标签
	Add_search_list();//下拉列表
	
});

function Add_search_tab(){
	var search_type = $("#search .search_type");
//	search_type.eq(0).css("background","#8CCAF1");
	for(var i=0;i<search_type.length;i++){
		search_type.eq(i).mouseover(function(){
			$(this).css("cursor","pointer");
		}).click(function(){
			for(var j=0;j<search_type.length;j++){
				search_type.eq(j).css("background","none");
			}
			$(this).css("background","#8CCAF1");
		});
	}
}

function Add_search_percent($percent){
	var $percent_string = "#main ." + $percent + "_num";
	var $percent_bg_string = "." + $percent + "_g";
	var percent_num = $($percent_string);
	for(var i=0;i<percent_num.length;i++){
		percent_num.eq(i).parent().find($percent_bg_string).css("width",percent_num.eq(i).html());
	}
}

function Add_search_advance(){
	var _advance_selection = $("#advance_selection").children("div");
	var _advance_main = $("#advance_main").children("div");
	var _select;
	var _select_object;
	for(var i=0;i<_advance_selection.length;i++){
		if(_advance_selection.eq(i).attr("class")=="ad_selection_active"){
			_select = _advance_selection.eq(i);
			_select_object = _advance_main.eq(i);
			_select_object.css("display","block");
		}
		_advance_selection.eq(i).attr("number",i).mouseover(function(){
			$(this).css("cursor","pointer");
		}).click(function(){
			$('#Curentpages').attr("num",$(this).attr("number"));
			if($(this).attr("class")=="ad_selection"){
				_select.attr("class","ad_selection");
				_select_object.css("display","none");
				_select = $(this).attr("class","ad_selection_active");
				_select_object = _advance_main.eq($(this).attr("number"));
				_select_object.css("display","block");
			}
		});
	}
}

function Add_search_check($check){
	var $check_string = "#" + $check + "_object div";
	var _check_object = $($check_string);
	for(var i=0;i<_check_object.length;i++){
		_check_object.eq(i).click(function(){
			for(var k=0;k<_check_object.length;k++){
				_check_object.eq(k).attr("class","check_no");
			}
			$(this).attr("class","check_active");
		});
	}
}

function Add_hot_button(){
	var _advance_main = $("#advance_main");
	var _hot_button = _advance_main.find(".hot_button");
	var _hot_object = _advance_main.find(".hot_tab");
	for(var i=0;i<_hot_button.length;i++){
		_hot_button.eq(i).attr("number",i).click(function(){
			switch($(this).attr("number")){
				case "0":
					_hot_object.eq(0).stop(true,true).slideToggle("300");
					break;
				case "1":
					_hot_object.eq(1).stop(true,true).slideToggle("300");
					break;
				case "2":
					_hot_object.eq(2).stop(true,true).slideToggle("300");
					break;
			}
		});
	}
}

function Add_search_list(){
	var _advance_main = $("#advance_main");
	var _list_bg_right = _advance_main.find(".list_bg_right");
	var $slideup = true;
	var $all = $("*");
	var $length = 0;
	var _selection_bg_left = _advance_main.find(".selection_bg_left");
	var _cache;
	for(var j=0;j<_list_bg_right.length;j++){
		var _list_area = _list_bg_right.eq(j).parent().find(".list_area");
		var _selection_bg_main = _list_area.children("div");
		_cache = _list_bg_right.length-j;
		_list_bg_right.eq(j).parent().css("z-index",_cache);
		_list_bg_right.eq(j).mouseenter(function(){
			$slideup = false;
		}).mouseleave(function(){
			$slideup = true;
		}).click(function(){
			_cache = $(this).parent().find(".selection_bg_left");
			for(var k=0;k<_selection_bg_left.length;k++){
				
				
				
				
				if(_selection_bg_left.eq(k).css("display")=="block"){
					_selection_bg_left.eq(k).stop(true,true).slideUp(100);
				}
			}
			if(_cache.css("display")!="block"){
				_cache.stop(true,true).slideToggle(100);
			}
		});
		for(var i=0;i<_selection_bg_main.length;i++){
			$length = ($length>_selection_bg_main.eq(i).html().length)? $length:_selection_bg_main.eq(i).html().length;
			_selection_bg_main.eq(i).mouseenter(function(){
				$(this).css("background","#e1eff8");
			}).mouseleave(function(){
				$(this).css("background","none");
			}).click(function(){
				_cache = $(this).parent().parent().parent().parent().parent();
				_cache.parent().find(".list_bg_main").html($(this).html());
				//判断省份
				var provinceCode=$(this).attr("code");
				var currenPage=$("#Curentpages").attr("num");
				if(currenPage=="0"){
					if(provinceCode=="110000"){
						$('.list_bg_main').eq(1).html("北京市");
					}
					else if(provinceCode=="210000"){
						$('.list_bg_main').eq(1).html("大连市");
					}
					else if(provinceCode=="310000"){
						$('.list_bg_main').eq(1).html("上海市");
					}
					else if(provinceCode=="510000"){
						$('.list_bg_main').eq(1).html("成都市");
					}
					else if(provinceCode=="610000"){
						$('.list_bg_main').eq(1).html("西安市");
					}
				}
				else{
					if(provinceCode=="110000"){
						$('.list_bg_main').eq(9).html("北京市");
					}
					else if(provinceCode=="210000"){
						$('.list_bg_main').eq(9).html("大连市");
					}
					else if(provinceCode=="310000"){
						$('.list_bg_main').eq(9).html("上海市");
					}
					else if(provinceCode=="510000"){
						$('.list_bg_main').eq(9).html("成都市");
					}
					else if(provinceCode=="610000"){
						$('.list_bg_main').eq(9).html("西安市");
					}
				}
				
				
				_cache.stop(true,true).slideUp(100);
			});
		}
		_cache = 14*$length+18;
		_list_area.css("width",_cache);
		
		$all.click(function(){
			if($slideup){
				for(var m=0;m<_selection_bg_left.length;m++){
					if(_selection_bg_left.eq(m).css("display")=="block"){
						_selection_bg_left.eq(m).stop(true,true).slideUp(100);
					}
				}
			}
		});
	}
}