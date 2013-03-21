//该区域所有活动_详细信息、活动简介方法
function Add_white_button() {
	var white_body1 = $("#activity .white .body");
	var white_body2 = $("#activity .white .body2");
	var white_button = $(".white_button2");
	white_button.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		if (white_button.attr("control")=="false") {
			Goto();
		} else {
			Return();
		}
	});
}

function Goto(){
	var white_button = $(".white_button2");
	var white_body1 = $("#activity .white .body");
	var white_body2 = $("#activity .white .body2");
	white_button.attr("class", "white_button1");
	white_body2.fadeIn("normal");
	white_body1.fadeOut("normal");
	white_button.attr("control","true");
}
function Return(refreshInformation){
	var white_button = $(".white_button1");
	var white_body1 = $("#activity .white .body");
	var white_body2 = $("#activity .white .body2");
	white_button.attr("class", "white_button2");
	white_body1.fadeIn("normal");
	white_body2.fadeOut("normal",refreshInformation);
	white_button.attr("control","false");
}
function Judge(refreshInformation){
	if($(".white_button1").attr("control")=="true"){
		Return(refreshInformation);
	}else{
		refreshInformation();
	}
}
