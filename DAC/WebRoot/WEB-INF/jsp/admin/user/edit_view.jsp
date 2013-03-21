<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/user/init.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${app}?command=edit" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<input name="userId" type="hidden" value="${userId}"/>
			<table width="100%" border="0">
              <tr height="40px">
                <td>用户名：</td>
                <td><input name="userName" type="text" size="30" value="${user.username}" readOnly="readOnly"/></td>
                <td>真实姓名:</td>
                <td><input name="realName" type="text" size="30" value="${user.realname}"/></td>
              </tr>
              <tr height="40px">
                <td>电话号码：</td>
                <td><input type="text" name="phone" size="30" value="${user.phone}"/></td>
                <td>E-mail：</td>
                <td><input type="text" name="email" size="30" value="${user.email}"/></td>
              </tr>
              <tr height="40px">
                <td>用户组：</td>
                <td><select class="combox" name="userRole">
									<c:forEach var="g" items="${allGroup}" varStatus="t">
										<option value="${g.id}" ${user.userrole eq g.id ?'selected':""} > ${g.group_name} </option>
									</c:forEach>
					</select></td>
                <td height="40px">用户状态：</td>
                <td><input type="radio" name="state" ${user.state eq 1 ?'checked':""} value="1"/>可用<input type="radio" name="state" ${user.state eq 0 ?'checked':""} value="0"/>禁用</td>
              </tr>
            
            </table>
		
				<div class="divider"></div>
			<table width="100%" border="0">
              <tr height="40px">
                <td>上次登录时间：</td>
                <td>
                <input type="text" size="30" value="<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${user.lastlogintime}"/>" readOnly="readOnly"/>
                </td>
                <td>上次登录IP：</td>
                <td>
                <input type="text" size="30" value="${user.lastloginip}" readOnly="readOnly"/>
                </td>
              </tr>
            </table>

			</div>
			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>