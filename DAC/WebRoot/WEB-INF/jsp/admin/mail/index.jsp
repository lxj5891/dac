<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/user/init.jsp"%>
<h2 class="contentTitle">发送邮件</h2>
<form action="mail.do?command=send" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
			<input name="pageCount" type="hidden" value="${pageCount}">
			<div class="pageFormContent" layoutH="98">
			
				<p>
					<label>邮件标题：</label>
					<input name="title" class="required" minlength="6" maxlength="20"  type="text" size="30"/>
				</p>
				<div class="divider"></div>
				<p style="width:auto;height: auto;">
					<label>选择收件人：</label>
					<select NAME="id" MULTIPLE size=6>
					<c:forEach var="l" items="${users}" varStatus="t">
						<option value='${l.ID}'>${l.NAME}(${l.EMAIL})</option>
					</c:forEach>
					</select>
					<span class="info">(按CTRL键 ，可以多选)</span>
				</p>
				<div class="unit">
							<textarea class="editor" name="content" rows="20" cols="120"
								upLinkUrl="upload.php" upLinkExt="zip,rar,txt" 
								upImgUrl="upload.php" upImgExt="jpg,jpeg,gif,png" 
								upFlashUrl="upload.php" upFlashExt="swf"
								upMediaUrl="upload.php" upMediaExt:"avi">

							</textarea>
						</div>
				</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">发送</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	
</div>
</form>