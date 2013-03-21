<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">编辑页面</h2>
<form action="${AppBase}?command=edit" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input name="id" type="hidden" value="${zhaopinId}" />
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="title"  type="text" size="100" value="${zhaopin.title}"/></dd>
		</dl>
		<div class="divider"></div>
			<table width="90%" border="0">
              <tr height="40px">
                <td><label>内容：</label></td>
                <td colspan="3">
                <textarea class="editor" name="content" rows="20" cols="96"
					uplinkurl="/servlet/UploadFileServlet" uplinkext="zip,rar,txt" 
					upimgurl="/servlet/UploadFileServlet" upimgext="jpg,jpeg,gif,png" 
					upflashurl="/servlet/UploadFileServlet" upflashext="swf"
					upmediaurl="/servlet/UploadFileServlet" upmediaext:"avi">
					${zhaopin.content}
					</textarea></td>
                </tr>
            
            </table>

			
  </div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
			</ul>
		</div>
	</div>

</form>
