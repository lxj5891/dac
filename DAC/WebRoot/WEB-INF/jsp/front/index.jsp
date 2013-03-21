<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home page</title>
<link rel="stylesheet" type="text/css" href="front/css/style.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

<script type="text/javascript" src="lyd/LYD.core.js"></script>
<script type="text/javascript" src="lyd/LYD.ajax.js"></script>
<script type="text/javascript" src="js/swfobject/swfobject.js"></script>
<script type="text/javascript">
swfobject.embedSWF("http://img.xiami.com/res/player/widget/singlePlayer.swf?dataUrl=http://www.xiami.com/widget/xml-single/uid/0/sid/1771267524","xiamimusic","200","10.0.0","js/swfobject/expressInstall.swf");
function loadmusic(id){
	var iframeDom = $("iframe");
	iframeDom.attr("src","http://img.xiami.com/res/player/widget/singlePlayer.swf?dataUrl=http://www.xiami.com/widget/xml-single/uid/0/sid/"+id);
}
function doSearch(){
	var q = $(".tp_barip").val();
	var pageNum = "1";
	LYD.openLink({
		params : {serviceName:'MusicService',methodName:'xiaomiMusic',q:q,pageNum:pageNum},
		success : function(msg){
			$(".lp_featpad").html(' ');
			for(var i = 0 ;i<msg.result.results.length;i++){
				_trace(msg.result.results[i]);
				var html = ''+
				'<img src="front/images/lp_featimg3.jpg" width="152" height="92" alt="" class="lp_featimg1" />'+
				'<span class="cp_featpara"> '+
				'	<span style="float:left; width:250px; display:inline;"><span class="cp_featname"><b><a href="javascript:loadmusic('+msg.result.results[i].song_id+');">'+msg.result.results[i].song_name+' </a></b><Br />Best Music</span>'+
				'	<span class="cp_featxt">In felis. In felis mi, ullamcorper at, cursus in, gravida vitae, purus. Praesent massa eros, euismod sed, sodales eu, tincidunt posuere</span><br />'+
				'	</span>'+
				'	<span class="cp_featview">歌曲ID'+msg.result.results[i].song_id+'<br />歌曲名称:'+msg.result.results[i].song_name+'<br />From : Best Music<br />Views : 841<br />Comments:6<br />'+
				'	<a href="#"><img src="front/images/lp_featstar.jpg" width="78" height="13" alt="" /></a></span>'+
				' </span>'+
				'<img src="front/images/lp_featline.jpg" width="634" height="1" alt="" class="lp_featline" />';
				$(".lp_featpad").append(html);
				
			}
		}
	});
}
</script>
</head>
<body>
  <div id="main_block">
  	 <div id="innerblock">
					 <!--Top Panel starts here -->
			<div id="top_panel">
					<a href="index.html" class="logo"><img src="front/images/logo.jpg" width="255" height="36" alt="" /></a><br />
				<div class="tp_navbg">
					<a href="index.html">Home</a>
					<a href="inner.html">Upload</a>
					<a href="#">Videos</a>
					<a href="#">Channels</a>
					<a href="#">News</a>
				</div>
				<div class="tp_smlgrnbg">
					<span class="tp_sign"><a href="#" class="tp_txt">Sign Up</a>
					<span class="tp_divi">|</span>
					<a href="#" class="tp_txt">Login</a>
					<span class="tp_divi">|</span>
					<a href="#" class="tp_txt">Help</a></span>
				</div>
				
				<div class="tp_barbg">
					<input name="#" type="text" class="tp_barip" onchange="doSearch();"/>
					<select name="#" class="tp_drp"><option>Videos</option></select>
					<a href="javascript:doSearch();" class="tp_search"><img src="front/images/tp_search.jpg" width="52" height="24" alt="" /></a>
					<span class="tp_welcum">Welcome <b>Guest</b></span>
				
				</div>
				
			</div>
	  
	                   <!--Top Panel ends here -->
					   
					   
					    <!--content Panel starts here -->
						
			<div id="contentpanel">
			
				<div id="lp_padd">

					
					<div class="lp_featpad">
						<div id="item">
						<img src="front/images/lp_featimg1.jpg" width="152" height="92" alt="" class="lp_featimg1"/>
								
						<span class="cp_featpara">
									<span style="float:left; width:250px; display:inline;"><span class="cp_featname"><b>Vivamus eu ipsum non diam dapibus egestas. </b><Br />Best Music</span>
									
									<span class="cp_featxt">In felis. In felis mi, ullamcorper at, cursus in, gravida vitae, purus. Praesent massa eros, euismod sed, sodales eu, tincidunt posuere</span><br />
									</span>
									<span class="cp_featview">5.5<br />Added :07.01.2009<br />From : Best Music<br />Views : 841<br />Comments:6<br />
									<a href="#"><img src="front/images/lp_featstar.jpg" width="78" height="13" alt="" /></a></span>
						</span>
						
							<img src="front/images/lp_featline.jpg" width="634" height="1" alt="" class="lp_featline" />
						</div>
						<div id="item">
						<img src="front/images/lp_featimg2.jpg" width="152" height="92" alt="" class="lp_featimg1" />
					
						<span class="cp_featpara">
									<span style="float:left; width:250px; display:inline;"><span class="cp_featname"><b>Vivamus eu ipsum non diam dapibus egestas. </b><Br />Best Music</span>
									
									<span class="cp_featxt">In felis. In felis mi, ullamcorper at, cursus in, gravida vitae, purus. Praesent massa eros, euismod sed, sodales eu, tincidunt posuere</span><br />
									</span>
									<span class="cp_featview">5.5<br />Added :07.01.2009<br />From : Best Music<br />Views : 841<br />Comments:6<br />
									<a href="#"><img src="front/images/lp_featstar.jpg" width="78" height="13" alt="" /></a></span>
						</span>
						
							<img src="front/images/lp_featline.jpg" width="634" height="1" alt="" class="lp_featline" />
						</div>
						<div id="item">
							<img src="front/images/lp_featimg3.jpg" width="152" height="92" alt="" class="lp_featimg1" />
							
								<span class="cp_featpara">
									<span style="float:left; width:250px; display:inline;"><span class="cp_featname"><b>Vivamus eu ipsum non diam dapibus egestas. </b><Br />Best Music</span>
									
									<span class="cp_featxt">In felis. In felis mi, ullamcorper at, cursus in, gravida vitae, purus. Praesent massa eros, euismod sed, sodales eu, tincidunt posuere</span><br />
									</span>
									<span class="cp_featview">5.5<br />Added :07.01.2009<br />From : Best Music<br />Views : 841<br />Comments:6<br />
									<a href="#"><img src="front/images/lp_featstar.jpg" width="78" height="13" alt="" /></a></span>
								</span>
							<img src="front/images/lp_featline.jpg" width="634" height="1" alt="" class="lp_featline" />
						</div>
					
					</div>
					
				
				</div>
				
				<div id="rp_padd">
				
						<img src="front/images/rp_top.jpg" width="282" height="10" alt="" style="float:left;" />
					<div class="rp_loginpad">
						<span class="rp_titxt">MEMBERS LOGIN</span>
						
						<span class="rp_membrusr">User name:</span>
						<input name="#" type="text" class="rp_usrip" />
							
						<span class="rp_membrpwd">Password:</span>
						<input name="#" type="password" class="rp_pwdrip" />
						<a href="#" class="rp_login"><img src="front/images/rp_login.jpg" width="39" height="17" alt="" /></a>
									
						<span class="rp_notmem"><a href="#" style="font:11px Arial, Helvetica, sans-serif; color:#FFFFFF;">Forgot your password</a></span>
					
					
					</div>
					
						<img src="front/images/rp_upbgtop.jpg" width="282" height="10" alt="" class="rp_upbgtop" />
					<div class="rp_uppad">
						<iframe src="http://img.xiami.com/res/player/widget/singlePlayer.swf?dataUrl=http://www.xiami.com/widget/xml-single/uid/0/sid/1771267524" width="270px" height="70px"> </iframe>
					</div>
					
					<img src="front/images/rp_top.jpg" width="282" height="10" alt="" class="rp_upbgtop"  />
					<div class="rp_loginpad" style="padding-bottom:0px; border-bottom:none;">
						<span class="rp_titxt">VIDEO CATEGORIES</span>
					</div>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Funny Clips</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Advertising</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Sports</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Kids</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Scary Clips</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">News</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Motorcycles</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Planes</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Birds</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Beautiful Women</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Pretty Women</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Cool TV</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
					
					<span style="float:left;"><img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
					<a href="#" class="rp_catxt">Testing Channel</a>
					<img src="front/images/rp_catline.jpg" width="262" height="1" alt="" class="rp_catline" /></span>
				
				
					<img src="front/images/rp_upbgtop.jpg" width="282" height="10" alt="" class="rp_upbgtop" />
					<div class="rp_uppad">
						<span class="rp_titxt">VIDEO OF THE WEEK</span>
					
						<img src="front/images/rp_weekimg.jpg" width="87" height="54" alt="" class="rp_weekimg" />
					
						<img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro1" />
						<a href="#" class="rp_vidxt">Testing Channel<br /><font style="color:#666666; text-decoration:none;">From : non tortor</font></a>
					
					</div>
					
					<img src="front/images/rp_upbgtop.jpg" width="282" height="10" alt="" class="rp_upbgtop" />
					<div class="rp_uppad">
						<span class="rp_titxt" style="color:#A0B92E;">WHATS NEW</span>
						
						<img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro1" />
						<a href="#" class="rp_vidxt" style="width:248px; color:#848484;"><b>Nullam gravida, lacus ut auctor ultricies;</b> nibh <br />sem elementum odio, ac sagittis turpis magna .</a>
						<img src="front/images/rp_catarro.jpg" width="5" height="5" alt="" class="rp_catarro" />
						<a href="#" class="rp_vidxt" style="width:248px; color:#848484; margin-top:8px;"><b>Nullam gravida, lacus ut auctor ultricies;</b> nibh <br />sem elementum odio, ac sagittis turpis magna .</a>
						
						
						
					</div>
				
				
				</div>
				
			</div>	
		 	 		 
					<!--content Panel ends here -->
					
					 <!--footer panel starts here -->
		
		   	
	<div id="ft_padd">
			
			
			<div class="ftr_lnks">
				<a href="index.html" class="fp_txt">Home</a>
				<p class="fp_divi">|</p>
				<a href="inner.html" class="fp_txt">Upload</a>
				<p class="fp_divi">|</p>
				<a href="#" class="fp_txt">Watch</a>
				<p class="fp_divi">|</p>
				<a href="#" class="fp_txt">Channel</a>
				<p class="fp_divi">|</p>
				<a href="#" class="fp_txt">News</a>
				<p class="fp_divi">|</p>
				<a href="#" class="fp_txt">Sign Up</a>
				<p class="fp_divi">|</p>
				<a href="#" class="fp_txt">Log In</a>						
	 
			</div> 
			
				<span class="ft_cpy">&copy;copyrights @ 2009 Funnyvideo.com All Rights Reserved.<br /><font color="#F88F05">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Powered by </font>buytemplates.net</span>
			
			
			</div>	<br />   
 	 
	                     <!--footer panel ends here -->
    </div> 
	 
	      <!--innerblock ends here -->
	 
</div>
	
	      <!--mainblock ends here -->
			
</body>
</html>
