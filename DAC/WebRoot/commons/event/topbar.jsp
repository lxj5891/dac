<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="topbar">
	<div class="fill">
    	<div class="navigation">
        	<a href="index.do" class="home"><span></span></a>
          	<a href="create.do">发布</a>
            <a href="#">好友活动</a>
            <a href="#">活动墙</a>
            <a href="#">设置</a>
            <a href="#">徽章</a>
            <div id="logged_in_user">
            <div class="user_name">Shi Yan -</div><a href="/sun/">登出</a>
            </div>
        </div>
    </div>
</div>