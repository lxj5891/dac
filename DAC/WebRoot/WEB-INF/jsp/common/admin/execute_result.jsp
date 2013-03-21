<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="org.antonyframework.web.common.ExecuteResult,java.util.List"%>
<%
ExecuteResult executeResult = (ExecuteResult)request.getAttribute("result");
System.out.println(executeResult);
List<String> list = executeResult.getMessages();
String message  = "";
for(String s:list){
	message = s;
}
%>
{
	"statusCode":"<%=executeResult.getResult()%>",
	"message":"<%=message%>",
	"navTabId":"",
	"rel":"",
	"callbackType":"",
	"forwardUrl":"",
	"confirmMsg":""
}
