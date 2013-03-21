<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div class="page unitBox">
						<div class="accountInfo">
							<p><span>国信致远开发团队</span></p>
							<p>官方:<a href="http://www.521team.com" target="_blank">http://www.521team.com</a></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
<h2>用户信息:</h2>
<br/>
<p>用户：李浩</p>
<p>身份：网站管理员</p>
<p>上次登录IP：127.0.0.1</p>
<p>上次登录时间：2011年11月11日  11点11分</p>

<div class="divider"></div>
<h2>快捷方式:</h2>
<br/>
<p><a href="${base}/admin/news.do?pageNum=1" target="navTab" rel="news" flesh="ture">管理新闻</a></p>
<p><a class="add" href="/admin/news.do?command=addview" target="navTab" rel="add" mask="true"><span>添加新闻</span></a></p>
<p><a class="add" href="/admin/project.do?command=addview" target="navTab" rel="add" mask="true"><span>添加精品工程</span></a></p>
<p><a href="/admin/project.do?pageNum=1" target="navTab" rel="news" flesh="ture">管理精品工程 </a></p>
<p><a href="/admin/zhaopin.do?pageNum=1" target="navTab" rel="news" flesh="ture">管理人才招聘</a></p>
<p><a class="add" href="/admin/zhaopin.do?command=addview" target="navTab" rel="add">添加招聘信息</a></p>

<div class="divider"></div>
<h2>系统信息:</h2>
<pre style="margin:5px;line-height:1.4em">
企业网站程序版本：SunDev V1.0.1 Release 20111014 [查看最新版本]
操作系统：WINNT 
服务器软件：Tomcat/6.0.16
MySQL 版本：5.0.27-community-nt
上传文件：2M
</pre>

<div class="divider"></div>
<h2>技术支持:</h2>
<pre style="margin:5px;line-height:1.4em;">
版权所有：国信致远JAVAWEB开发团队
总 策 划：李浩
开发与支持团队：李浩、杨昌钊、丁开迪
UI 设计：寻明华
</pre>

						</div>
						
					</div>