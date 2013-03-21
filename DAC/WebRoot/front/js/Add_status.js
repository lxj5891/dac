//右下角活动推荐方法
function Add_status() {
	//状态框显示
	$('.width .id_person_box_main .icons .zhuangtai').click(function(){
		$('.width .zhuangtai_box').slideToggle(200);
		$('.notice_user').css('display','none');
	})
	$('.width .zhuangtai_box .main_box .cancel').click(function(){
		$('.width .zhuangtai_box').slideUp(200);
		$('.notice_user').css('display','none');
	})
	$('.width .zhuangtai_box .main_box .fabu_button').click(function(){
		COMMON.speak();
	})
	$('.width .zhuangtai_box .main_box .at').click(function(){
		$('.notice_user').slideToggle(200);
		var old_text=$('.input_box').val();
		$('.input_box').val(old_text+'@');
	})
	$('.width .notice_user .user_line .user_name').click(function(){
		var inform=$(this).html();
		var old_text=$('.input_box').val();
		$('.input_box').val(old_text+inform+' ');
		$('.notice_user').slideUp(200);
	})
	$('.input_box').keydown(function(e){
		if((e.keyCode == 50&&e.shiftKey)||e.keyCode == 64){$('.notice_user').slideDown(200)}
	})
}
