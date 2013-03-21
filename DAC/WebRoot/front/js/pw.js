function setPw(){
	var _body = $("body");
	var _window = $(window);
	var _data = '<div id="pw">'+
	'<div id="pw_b">'+
		'<div id="pw_m">'+
			'<div class="text">原始密码：</div>'+
			'<div class="input_object"><input class="input_style" type="password" /></div><span id="v_pwd" style="width:140px; display:none; position:absolute; left:266px; top:55px;" >密码小于6位</span>'+
			'<div class="clear"></div>'+
			'<div class="text">新的密码：</div>'+
			'<div class="input_object"><input class="input_style" type="password" /></div><span id="v_pass" style="width:140px; display:none; position:absolute; left:266px; top:111px;" >密码小于6位</span>'+
			'<div class="clear"></div>'+
			'<div class="text">确认密码：</div>'+
			'<div class="input_object"><input class="input_style" type="password" /></div><span id="v_pass_check" style="width:140px; display:none; position:absolute; left:46px; top:199px;" >密码与确认密码不一致</span>'+
			'<div class="clear"></div>'+
			'<div id="button">'+
				'<div id="cancel_button"></div>'+
				'<div id="yes_button"></div>'+
			'</div>'+
		'</div>'+
	'</div>'+
'</div>';
	_body.append(_data);
	
	var pwd = $(".input_object").eq(0).children(".input_style");
	var newPwd =$(".input_object").eq(1).children(".input_style");
	var newCheckPwd =$(".input_object").eq(2).children(".input_style");
	//绑定后面语句
	newCheckPwd.bind("blur",function(){
		validatePassCheck();
	});
	newPwd.bind("blur",function(){
		validatePass();
	});
	pwd.bind("blur",function(){
		validatePwd();
	});
	
	
	var _pw_object = $("#pw");
	var _yes_button = _pw_object.find("#yes_button");
	var _cancel_button = _pw_object.find("#cancel_button");

	_yes_button.click(function(){
		console.log("确定");
		if(newPwd.val().length<=5){
			LYD.Alert("message","提示","新密码小于6位");
			return;
		}
		if(pwd.val().length<=5){
			LYD.Alert("message","提示","原密码小于6位");
			return;
		}
		if(newPwd.val()!=newCheckPwd.val()){
			LYD.Alert("message","提示","密码与确认密码不一致");
			return;
		}
		var newpwdVal = newCheckPwd.val();
		var pwdVal = pwd.val();
		LYD.a({
			params:{serviceName:'UserService',methodName:'checkUserPwd',pwd:pwdVal},
			success : function(msg){
				if(msg.status==301){
					LYD.Alert("message","提示","原密码输入错误");
				}
				else{
					LYD.a({
						params:{serviceName:'UserService',methodName:'updateUserPwd',pwd:newpwdVal},
						success:function(){
							if(msg.status==200){
								LYD.Alert("message","提示","修改密码成功");
								$.cookie('combo_checked_user_passwd',newpwdVal);
								pwd.attr("value","");
								newPwd.attr("value","");
								newCheckPwd.attr("value","");
							}
							else{
								LYD.Alert("message","提示","修改密码失败,请重试");
							}
						}
					});
				}
			}
		});
		_pw_object.fadeOut("300");
		removePosMask();
	});

	_cancel_button.click(function(){
		_pw_object.fadeOut("300");
		removePosMask();
	});

	getSize();

	_pw_object.fadeIn("300");
	_window.resize(function(){
		getSize();
	});

	function getSize(){
		var _x = $(document).width() / 2;
		var _y = $(document).height() / 2;
		var _object_x = _pw_object.outerWidth() / 2;
		var _object_y = _pw_object.outerHeight() / 2;
		_pw_object.css("left", _x - _object_x).css("top", _y - _object_y);
	}
	
	function validatePass(){
		if(newPwd.val().length<=5){
			$("#v_pass").show();
		}
		else{
			$("#v_pass").hide();
		}
	}
	function validatePwd(){
		if(pwd.val().length<=5){
			$("#v_pwd").show();
		}
		else{
			$("#v_pwd").hide();
		}
	}
	function validatePassCheck(){
		if(!(newPwd.val()==newCheckPwd.val())){
			$("#v_pass_check").show();
		}
		else{
			$("#v_pass_check").hide();
		}
	}

}