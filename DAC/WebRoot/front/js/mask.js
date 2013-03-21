function setPosMask(_object,_index){
	$(_object).before("<div id='position_mask' style='width:  100%; height: 100%; position: fixed; left: 0; top: 0; background: #000; z-index: "+_index+";'></div>");
	$("#position_mask").fadeTo(200,0.4);
}
function removePosMask(){
	$("#position_mask").fadeTo(200,0.0,function(){
		$(this).remove();
	});
}