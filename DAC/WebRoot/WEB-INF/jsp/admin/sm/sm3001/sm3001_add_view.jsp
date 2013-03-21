<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<script type="text/javascript" src="/antony/uploadify/scripts/swfobject.js">
</script>
<script type="text/javascript">
swfobject.embedSWF("/antony/static/uploads/uploads.swf", "uploadify", 353, 280, '11.0.1', "/antony/uploadify/scripts/expressInstall.swf", null, {'quality':'high','wmode':'opaque','allowScriptAccess':'sameDomain'});
function displayImage(str){
	$("#imgUri").val("http://www.ycombo.com/antony/uploads"+str);
	$("#divUploads").hide();
	$("#imgUploads").attr("src","http://www.ycombo.com/antony/uploads"+str);
	$("#imgUploads").css("display","block");
}

function checkEmail(){
	var email = $("#emailInput").val();
	alert(email);
	LYD.openLink({
			url:"/antony/admin/sm/sm3001/checkemail",
			params:{email:email},
			success:function(msg){
				callbackCheckEmail(msg);
			}
		});
}
function callbackCheckEmail(msg){
	if(msg.status == "200"){
		$("#uidInput").val(msg.UID);
		$("#schoolInput").val(msg.SCHOOL);
		$("#passInput").val(msg.PASSWD);
		$("#nameInput").val(msg.USERTRUENAME);
		$("#imgUri").val("http://www.ycombo.com/combo/"+msg.LIMG);
		$("#hdemailflag").val(msg.emailflag);
		$("#hdid").val(msg.eid);
		$("#hdseq").val(msg.seq);
		$("#imgUploads").css("display","block");
		$("#imgUploads").attr("src","http://www.ycombo.com/combo/"+msg.LIMG);
		DWZ.ajaxDone(msg);
	}else{
		$("#passInput").val('');
		$("#nameInput").val('');
		$("#imgUri").val('');
		$("#hdemailflag").val(msg.emailflag);
		DWZ.ajaxDone(msg);
	}
		
}
</script>
<h2 class="contentTitle">添加邀请者</h2>
<form action="${AppBase}/add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
  <div class="pageContent">
		<div class="pageFormContent" layoutH="97">
			<p>
				<label>编号：</label>
				<input id="hdemailflag" name="emailflag" type="hidden" value="${emailflag}" >
				<input id="hdid" name="id" class="text" type="hidden" size="30"  value="" readonly="readonly"/>
				<input id="hdseq" name="seq" class="text" type="text" size="30"  value="${seq}" readonly="readonly"/>
			</p>
			<div class="divider"></div>
			<p>
				<label>邮箱：</label>
				<input id="emailInput" name="email"  type="text" size="30" class="required email"/>
			</p>
			<p>
				<a class="button" href="javascript:checkEmail();"><span>验证邮箱</span></a>
			</p>
			<div class="divider"></div>
			<p>
				<label>姓名：</label>
				<input id="nameInput" name="name" type="text" size="30" />
			</p>
			<p>
				<label>UID：</label>
				<input id="uidInput" name="uid" type="text" size="30" readonly="readonly" />
			</p>
			<p>
				<label>学校：</label>
				<input id="schoolInput" name="school" type="text" size="30" />
			</p>
			
			<p>
				<label>邀请人：</label>
				<input name="userid" class="required" type="hidden" size="30" value="${loginUser.id} " readonly="readonly"/>
				<input name="username" class="required" type="text" size="30" value="${loginUser.realname} " readonly="readonly"/>
			</p>
			<p>
				<label>初始密码：</label>
				<input id="passInput" name="pass" type="text" size="30" value="123456" readonly="readonly"/>
			</p>
			<div class="divider"></div>
			<p>
				<label>上传照片：</label>
				<input id="imgUri" name="filepath"  type="text" size="30" readonly="readonly"/>
			</p>
			<div class="divider"></div>
			<div id="divUploads">
				<div id="uploadify"></div>
			</div>
			<p>
				<label>头像：</label>
				<img id="imgUploads" src="/antony/uploads/20121105/10759456-F0F3-7323-F4F5-DD58D51BA533.png" style="display:none"/>
			</p>
			
		</div>
		<div class="formBar">
			<ul>
				
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">继续添加</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">返回</button></div></div></li>
			</ul>
		</div>
	</div>
</form>

