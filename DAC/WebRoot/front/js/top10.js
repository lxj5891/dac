function top10() {
	var _school_scroll = $("#school_scroll");
	var _page = _school_scroll.find("#page");
	var _main = _school_scroll.find("#main");
	var _singleArray = _main.find(".single");
	var _arrowArray = _school_scroll.find("#control").children();
	var _cache;
	var _pageArray;
	var _pageCache;
	
	for (var i = 0; i < _singleArray.length; i++) {
		if (i == _singleArray.length - 1) {
			_page.append("<div class='active'></div>");
		} else {
			_page.append("<div class='normal'></div>");
		}
		_pageArray = _page.children();
	}
	for (var j = 0; j < _pageArray.length; j++) {
		if (_pageArray.eq(j).attr("class") == "active") {
			_pageCache = _pageArray.eq(j);
		}
	}
	_cache = _singleArray.length;
	for (var i = 0; i < _arrowArray.length; i++) {
		_arrowArray.eq(i).click(function () {
			switch ($(this).attr("id")) {
			case "arrow_next":
				if (_cache > 1) {
					_main.animate({
						left : "-=" + _singleArray.eq(_cache - 1).outerWidth() + "px"
					}, 300);
					_cache--;
					_pageCache.attr("class", "normal");
					_pageArray.eq(_cache - 1).attr("class", "active");
					_pageCache = _pageArray.eq(_cache - 1);
				}
				break;
			case "arrow_pre":
				if (_cache < _arrowArray.length + 1) {
					_main.animate({
						left : "+=" + _singleArray.eq(_cache - 1).outerWidth() + "px"
					}, 300);
					_cache++;
					_pageCache.attr("class", "normal");
					_pageArray.eq(_cache - 1).attr("class", "active");
					_pageCache = _pageArray.eq(_cache - 1);
				}
				break;
			}
		})
	}
}

function top10_main(){
	var _school_ten = $("#school_ten");
	var _normal = _school_ten.find(".selection").children();
	var _loveArray = _school_ten.find(".love_icon").children();
	var _cache;
	for(var i=0;i<_normal.length;i++){
		if(i==0){
			_cache = _normal.eq(i).attr("class","active");
		}
		_normal.eq(i).click(function(){
			if($(this).attr("class")!=_cache.attr("class")){
				_cache.attr("class","normal");
				_cache = $(this).attr("class","active");
			}
		});
	}
	for(var i=0;i<_loveArray.length;i++){
		_loveArray.eq(i).click(function(){
			$(this).attr("class","love_active")
		});
	}
}
