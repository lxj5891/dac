<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/root/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>COMBO之家</title>
		<link href="${base}/themes/css/login.css" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<div id="login">
			<div id="login_header">
				<h1 class="login_logo">
					<a href="http://demo.dwzjs.com"><img
							src="${base}/themes/default/images/login_logo.gif" />
					</a>
				</h1>
				<div class="login_headerContent">
					<div class="navList">
						<ul>
							<li>
								<a href="#">设为首页</a>
							</li>
							<li>
								<a href="http://www.521team.com">反馈</a>
							</li>
						</ul>
					</div>
					<h2 class="login_title">
						<img src="${base}/themes/default/images/login_title.png" />
					</h2>
				</div>
			</div>
			<div id="login_content">
				<div class="loginForm">
					<form action="/antony/admin/login.do" method="post">
						<c:if test="${errorInfo != null}">
							<p>
								<h2>
									${errorInfo}
								</h2>
							</p>
						</c:if>
						<p>
							<label>
								用户名：
							</label>
							<input type="text" name="username" size="20" class="login_input"/>
						</p>
						<p>
							<label>
								密码：
							</label>
							<input type="password" name="password" size="20" class="login_input"/>
						</p>
						<p>
							<label>
								验证码：
							</label>
							<input class="code" name="code" type="hidden" size="5"  value="0000" />
							<span style="display: none"><img src="${base}/commons/admin/CheckCode.jsp" 
										alt="" width="75" height="24" />
							</span>
						</p>
						<div class="login_bar">
							<input class="sub" type="submit" value=" " />
						</div>
					</form>
				</div>
				<div class="login_banner">
					<img src="${base}/themes/default/images/login_banner.jpg" />
				</div>
				<div class="login_main">
					<ul class="helpList">
					</ul>
					<div class="login_inner">
					</div>
				</div>
			</div>
			<div id="login_footer">
				COMBO团队  版权所有. ZHETAI KAIYU DECORATION CO.LTD All rights reserved. 技术支持：YCOMBO运营服务
			</div>
		</div>
	</body>
</html>