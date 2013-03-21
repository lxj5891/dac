<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/admin/user/init.jsp"%>
<form id="pagerForm" method="post" action="${app}?command=list">
	<input type="hidden" name="pageNum" value="${allUsers.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="page">
	<div class="pageHeader">
		<br/>
		<h1>用户管理</h1>
		<br/>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${app}?command=addview&pageCount=${allUsers.pageCount}" target="navTab" rel="add" ><span>选择系统</span></a></li>
				<li><a class="add" href="${app}?command=adddialog&pageCount=${allUsers.pageCount}" target="dialog" rel="add" mask="true"><span>添加邀请</span></a></li>
				<li><a class="delete" href="${app}?command=delete&&userId={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="${app}?command=editview&&userId={sid_user}" target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>导入EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" layouth="124">
			<thead>
				<tr>
					<th width="50">序号</th>
					<th width="80">重要度</th>
					<th width="30%">描述</th>
					<th width="80">类型</th>
					<th width="150">邀请日期</th>
					<th width="150">开发完成日期</th>
					<th width="100">反映日期</th>
					<th width="80">发布时间</th>
					<th width="80">进度</th>
					<th width="80">邀请者</th>
					<th width="80">分析者</th>
					<th width="80">实施者</th>
					<th width="80">进行现状</th>
					<th width="150">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${opers}" varStatus="t">
				<tr target="sid_user" rel="${l.ID}">
					<td>${l.SEQ}</td>
					<td>${l.STATUS}</td>
					<td>${l.OPER_DES}</td>
					<td>${l.OPER_TYPE}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${l.IN_DATE}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${l.START_DATE}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${l.OPEN_DATE}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${l.END_DATE}"/></td>
					<td>${l.FROM_USER}</td>					
					<td>${l.ANALYSE_USER}</td>
					<td>${l.OPER_USER}</td>
					<td>${l.NOW_STS}</td>
					<td>${l.state eq 1 ?'可用':'禁用'}</td>
					<td>
						<a title="删除" target="ajaxTodo" href="${app}?command=delete&&userId=${l.id}" class="btnDel">删除</a>
						<a title="编辑" target="navTab" href="${app}?command=editview&&userId=${l.id}" class="btnEdit">编辑</a>
					</td>
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>共${allUsers.rowCount}条 </span>
			</div>

			<div class="pagination" targetType="navTab" totalCount="${allUsers.rowCount}" numPerPage="20" pageNumShown="10" currentPage="${allUsers.pageNum}"></div>
		</div>
	</div>
</div>