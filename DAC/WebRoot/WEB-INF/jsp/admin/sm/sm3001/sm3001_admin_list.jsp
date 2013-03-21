<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<script type="text/javascript">
var d ;
function viewPhoto(obj) {
	$("#dialog_img").attr("src",obj);
	d = $( "#dialog-modal" ).dialog({
		height: 600,
		width: 500
	});
}
function viewPhotoClose(){
	d.dialog('destroy');
}
</script>

<form id="pagerForm" method="post" action="${AppBase}">
	<input type="hidden" name="pageNum" value="${list.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>
<div class="pageHeader">
<div class="accountInfo">
	<div class="alertInfo">
	</div>
	<div class="right">
		<p>共有${totCount}项邀请、待审核的邀请有${appCount}项.</p>
		<p>${today }</p>
	</div>
	<p><span>邀请活动 </span></p>
	<p><a href="demo_page2.html" target="dialog">COMBO运营</a></p>
</div>	
</div>

              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}/add" target="navTab" rel="add" mask="true"><span>添加邀请者</span></a></li>
                          
                          <li><a title="确实要审核这些记录吗?" class="edit" href="${AppBase}/append" target="selectedTodo" rel="Id"  postType="string"   mask="true"><span>审核</span></a></li>
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="148">
                      <thead>
                          <tr>
                          	<th width="30"><input type="checkbox" group="Id" class="checkboxCtrl"></th>
								<th width="30">序号</th>
								<th width="90">编号</th>
								<th width="60">姓名</th>
								<th width="60">学校</th>
								<th width="120">邮箱</th>
								<th width="60">邀请人</th>
								<th width="120">发布时间</th>
								<th width="70">审核状态</th>
								<th width="70">邮件状态</th>
								<th width="70">用户状态</th>
								<th width="120">登录时间</th>
								<th width="50">照片</th>
								<th width="60">操作</th>
                          </tr>
                      </thead>
                      <tbody>
		<c:forEach var="g" items="${list.list}" varStatus="t">
		<tr target="sid_Id" rel="${g.id}">
			<td><c:if test="${g.typeid == null||g.typeid == 0}"><input name="Id" value="${g.id}" type="checkbox"></c:if></td>
			<td>${t.index+1}</td>
			<td>${g.seq}</td>
			<td>${g.NAME}</td>
			<td>${g.school}</td>
			<td>${g.EMAIL}</td>
			<td>${g.realname}</td>
			
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.UPDATETIME}"/>
			</td>
			
			<td>${g.typeid==0||g.typeid==null ? "未审核":""}${g.typeid==1 ? "审核通过":""}${g.typeid==2 ? "删除中":""}</td>
			<td>${g.emailid==null?"未发送":"已发送"}</td>
			<td>${g.login==1 ? "已登录":"未登录"}</td>
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.logindate}"/>
			</td>
			<td><a href="javascript:viewPhoto('${g.FILEPATH}')" title="${g.FILEPATH}" onmouseover="viewPhoto('${g.FILEPATH}');" onmouseout="viewPhotoClose();">查看</a></td>
			<td>
				<a title="删除" target="ajaxTodo" href="${AppBase}/delete/${g.id}" class="btnDel">删除</a>
			</td>
		</tr>
		</c:forEach>
                      </tbody>
                  </table>
                  <div class="panelBar">
                      <div class="pages">
                         	<span>共${list.rowCount}条</span>
                      </div>
                      <div class="pagination" targetType="navTab" rel="" totalCount="${list.rowCount}" numPerPage="20" pageNumShown="5" currentPage="${list.pageNum}"></div>
                  </div>
              </div>
              
<div id="dialog-modal" title="查看照片">
	<img id="dialog_img" width="300px" />
</div>