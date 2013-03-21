//上传头像方法
function Add_head_pic() {
	var id_person_box_main = $(".id_person_box_main .pic");
	var pic_upload_mask = $(".pic_upload_mask");
	var pic_upload_close = $(".pic_upload_close");
	var pic_upload_save = $(".pic_upload_save");
	var pic_upload_cancel = $(".pic_upload_cancel");
	var pic_upload_explorer_button_ben = $(".pic_upload_explorer_object_pic .button_bendi");
	var pic_upload_explorer_button_pai = $(".pic_upload_explorer_object_pic .button_paizhao");
	id_person_box_main.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		pic_upload_mask.slideDown("normal");
		//setPosMask(2);
	});
	pic_upload_close.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		pic_upload_mask.slideUp("normal");
	});
	pic_upload_explorer_button_ben.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//本地上传
	});
	pic_upload_explorer_button_pai.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//拍照上传
	});
	pic_upload_save.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		//保存
	});
	pic_upload_cancel.mouseover(function () {
		$(this).css("cursor", "pointer");
	}).click(function () {
		pic_upload_mask.slideUp("normal");
	});
}
