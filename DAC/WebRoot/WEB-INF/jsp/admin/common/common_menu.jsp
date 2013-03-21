<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div class="accordion" fillSpace="sideBar">
	<div class="accordionHeader">
		<h2><span>Folder</span>典型页面</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree treeFolder">
			<c:forEach items="${leftMenuList}" var="m"> 
			<li><a href="${m.action}" target="navTab" rel="demo_upload">${m.name}</a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="accordionHeader">
		<h2><span>Folder</span>流程演示</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree">
			<li><a href="newPage1.html" target="dialog" rel="dlg_page">列表</a></li>
		</ul>
	</div>
</div>