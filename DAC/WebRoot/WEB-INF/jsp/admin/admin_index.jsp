<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>COMBO之家</title>

<link href="${base}/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${base}/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${base}/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${base}/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<link rel="stylesheet" href="${base}/themes/ui/themes/base/jquery.ui.all.css">
<script src="${base}/js/speedup.js" type="text/javascript"></script>
<script src="${base}/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="${base}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${base}/js/jquery.validate.js" type="text/javascript"></script>
<script src="${base}/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${base}/xheditor/xheditor-1.1.12-zh-cn.min.js" type="text/javascript"></script>
<script src="${base}/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="${base}/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<script src="${base}/js/dwz.core.js" type="text/javascript"></script>
<script src="${base}/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${base}/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${base}/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${base}/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.drag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.tree.js" type="text/javascript"></script>
<script src="${base}/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${base}/js/dwz.ui.js" type="text/javascript"></script>
<script src="${base}/js/dwz.theme.js" type="text/javascript"></script>
<script src="${base}/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${base}/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${base}/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${base}/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${base}/js/dwz.tab.js" type="text/javascript"></script>
<script src="${base}/js/dwz.resize.js" type="text/javascript"></script>
<script src="${base}/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${base}/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${base}/js/dwz.stable.js" type="text/javascript"></script>
<script src="${base}/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${base}/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${base}/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${base}/js/dwz.database.js" type="text/javascript"></script>
<script src="${base}/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${base}/js/dwz.effects.js" type="text/javascript"></script>
<script src="${base}/js/dwz.panel.js" type="text/javascript"></script>
<script src="${base}/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${base}/js/dwz.history.js" type="text/javascript"></script>
<script src="${base}/js/dwz.combox.js" type="text/javascript"></script>
<script src="${base}/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="${base}/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${base}/lyd/LYD.core.js" type="text/javascript"></script>
<script src="${base}/lyd/LYD.ajax.js" type="text/javascript"></script>

<script src="${base}/themes/ui/ui/jquery.ui.core.js"></script>
<script src="${base}/themes/ui/ui/jquery.ui.widget.js"></script>
<script src="${base}/themes/ui/ui/jquery.ui.mouse.js"></script>
<script src="${base}/themes/ui/ui/jquery.ui.draggable.js"></script>
<script src="${base}/themes/ui/ui/jquery.ui.position.js"></script>
<script src="${base}/themes/ui/ui/jquery.ui.resizable.js"></script>
<script src="${base}/themes/ui/ui/jquery.ui.dialog.js"></script>
<script type="text/javascript">
$(function(){
	DWZ.init("/antony/js/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"/antony/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
<style type="text/css">
	#header{height:85px}
	#leftside, #container, #splitBar, #splitBarProxy{top:90px}
</style>

</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<ul class="nav">
					<li><a href="logout.do">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<div id="navMenu">
				<ul>
					<li class="selected"><a onclick="javascript:location.replace('/antony/admin/root.do');"><span>我的主页</span></a></li>
					<c:forEach items="${topMenuList}" var="m" varStatus="mit">
						<li><a href="${m.action}"><span>${m.name}</span></a></li>
					</c:forEach>
				</ul>
			</div>
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>组件</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>市场活动</a>
								<ul>
									<li><a href="sm/sm3001/list" target="navTab" rel="page3" title="市场部社团活动">我邀请的用户</a></li>
								</ul>
							</li>
						</ul>
					</div>
					
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							

<div class="divider"></div>
<h2>常见问题及解决:</h2>
<pre style="margin:5px;line-height:1.4em">
</pre>

						</div>
						
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2010 COMBO团队</div>


</body>
</html>