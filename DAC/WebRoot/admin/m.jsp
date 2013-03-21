
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.io.ByteArrayInputStream"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL"%>

<%@ page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@ page import="javax.xml.parsers.ParserConfigurationException"%>

<%@ page import="org.w3c.dom.Document"%>
<%@ page import="org.w3c.dom.Element"%>
<%@ page import="org.w3c.dom.Node"%>
<%@ page import="org.w3c.dom.NodeList"%>
<%@ page import="org.xml.sax.SAXException"%>
<%@ page import="java.lang.*"%>



<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
		try {
		response.setContentType("text/html");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
			.newInstance();

			DocumentBuilder db = factory.newDocumentBuilder();
			String u = "http://hpwapv.dskcc.net/approval/service/document.asmx/DocListForMyService?userID=06534&title=&pageNumber=&pageSize=";
			URL url = new URL(u);
			HttpURLConnection urlConnection = (HttpURLConnection) url
			.openConnection();

			Document doc = db.parse(urlConnection.getInputStream());

			Element elmtInfo = doc.getDocumentElement();
			NodeList nodes = elmtInfo.getChildNodes();
			Node result = nodes.item(0);
			String dr = result.toString().substring(5,
			result.toString().length() - 1);
			//out.print(dr);
			Document ddoc = db.parse(new ByteArrayInputStream(dr
			.getBytes("utf-8")));

			NodeList es = ddoc.getElementsByTagName("rnum");
			NodeList TITLEes = ddoc.getElementsByTagName("TITLE");
			NodeList DOC_IDes = ddoc.getElementsByTagName("DOC_ID");
			for(int i = 0 ;i<es.getLength();i++){
				out.print("DOC_ID:"+DOC_IDes.item(i).getFirstChild().getNodeValue());
				out.print("        -");
				out.print("TITLE:"+TITLEes.item(i).getFirstChild().getNodeValue());
				
				out.print("<br>");
			}
			System.out.println("ddddddddddddddddddddddddddddddd");
				} catch (ParserConfigurationException e) {
				} catch (SAXException e) {
				} catch (IOException e) {
				}
			} catch (Exception e) {
		
			}
%>
