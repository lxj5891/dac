<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="flex/swfobject.js"></script>
<script src="js/xmlhttp.js" type="text/JavaScript"></script>
<script type="text/javascript">
function thisMovie(movieName) {  
    if (navigator.appName.indexOf("Microsoft") != -1) {  
        return window[movieName];  
    } else {  
        return document[movieName];  
  }  
}  

function javaScript(){  
	thisMovie("flashcontent").testJs("12323");  
}  


function InitMf()
{
 var mf_change=false; 
  try { 
   mf_change = new ActiveXObject("Msxml2.XMLHTTP"); 
  } catch (e) { 
   try { 
     mf_change = new ActiveXObject("Microsoft.XMLHTTP"); 
   } catch (E) { 
    mf_change = false; 
   } 
  }
  if (!mf_change && typeof XMLHttpRequest!='undefined') { 
   mf_change = new XMLHttpRequest(); 
  } 
  return mf_change;
}

function load(){
	var myDiv = document.getElementById("qwe");
	var myList = document.getElementById("list");
	var xmlHttp = InitMf();
	xmlHttp.open("GET", "x.xml", true);
 	xmlHttp.onreadystatechange=function() {
      var xml = xmlHttp.responseXML;
      var nodes = xml.getElementsByTagName("Document");//获得总结点
      myDiv.innerHTML = "";
      for(var i = 0 ; i < nodes.length ; i++){
    	  alert(nodes[i].getElementsByTagName("DOC_ID")[0].text+":"
    			 + nodes[i].getElementsByTagName("TITLE")[0].text  
    	  )
    	  myDiv.innerHTML = myDiv.innerHTML + 
    	  nodes[i].getElementsByTagName("DOC_ID")[0].text+":"
			 + nodes[i].getElementsByTagName("TITLE")[0].text +"<br>" ;
      }
      
    	  
 	 }
 	alert(myList.innerHTML)
 	xmlHttp.send(null);
}
function goDetail(){
	var resultProcessMethod = "rentRMDetail";
	var url = "http://localhost:8080/antony/m.jsp";
	alert(1);
	xmlHttpPost(url, null ,resultProcessMethod);
}
function rentRMDetail(result){
	var myDiv = document.getElementById("qwe");
	alert(result);
 	if(result){
 		myDiv.innerHTML = result;
 		
 		
	}
}
swfobject.embedSWF("/antony/flex/Main.swf", "flashcontent", "300", "120", "10.0.0", "front/js/swfobject/expressInstall.swf");
</script>
</head>
<body>
	<a href="javascript:goDetail();">load</a>
	<table id="list">
		<tr>
			<td>ID</td>
			<td>TITLE</td>
		</tr>
		<tr>
			<td>123</td>
			<td>123</td>
		</tr>
	</table>
	<div id="qwe"></div>

	<div id="flashcontent"></div>
	<br>
	<a href="javascript:javaScript();">javaScript</a>
</body>
</html>