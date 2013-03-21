//全局滚动条方法
function _allDrag(_drag_main, _drag_singleHeight, _scroll_object, _drag_object, _dragStart, _dragEnd) {
	var _document_objects = $("*");
	var _drag_offset = _dragEnd - _dragStart;
	var _scroll_main_height = _scroll_object.height();
	_drag_object.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).mousedown(function (e) {
		var _height = 0;
		var y = e.pageY - _drag_object.position().top;
		for (var i = 0; i < _drag_singleHeight.length; i++) {
			_height += _drag_singleHeight.eq(i).outerHeight();
		}
		_document_objects.css("-moz-user-select", "none");
		$(document).bind("selectstart", function () {
			return false;
		}).bind("mousemove", function (e) {
			if(_height > _scroll_main_height){
				var ratio = (_height - _scroll_main_height) / _drag_offset;
				var _dragHeight = (_drag_object.position().top - _dragStart) * ratio;
				_drag_object.css("top", e.pageY - y);
				if (_drag_object.position().top <= _dragStart) {
					_drag_object.css("top", _dragStart);
				}
				if (_drag_object.position().top >= _dragEnd) {
					_drag_object.css("top", _dragEnd);
				}
				_drag_main.css("top", -_dragHeight);
			}
		}).mouseup(function () {
			$(document).unbind("mousemove").unbind("selectstart");
			_document_objects.css("-moz-user-select", "auto");
		});
	});
}
