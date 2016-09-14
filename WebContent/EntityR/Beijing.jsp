<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<String> sameEntity=(ArrayList<String>)request.getAttribute("sameEntity");
	int size=sameEntity.size();
	String key=(String)request.getAttribute("key");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"/ href="../css/index.css" > 
<link rel="shortcut icon" href="../img/logo.ico">
<script language="javascript" type="text/javascript" ></script>
<title>RDF fusion</title>
<script src="../JS/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="../JS/hot.js" type="text/javascript"></script>
</head>
<body>
<div id="header">
  <div id="top_welcom">
   RDF data fusion and truth discovery system 
  </div>   
  <div id="nav">
  	&nbsp;&nbsp;<b><a href="index.html" >Home</a></b>
  	&nbsp;&nbsp;|<b>Entity co-reference</b>
  	&nbsp;&nbsp;|<b><a href="Predicate.html">Schema alignment</a></b>
  	&nbsp;&nbsp;|<b><a href="Object.jsp">Conflict resolution</a></b>
  </div>
</div>
<div id="container">
	<div id="search">
    <form id="lookup"  action="Subject" method="post">
        <input id="input" style="width: 262px;border: 1px solid rgb(35, 76, 127);height:30px;" name="q" value=<%=key %> />
        <input type="submit" style="height:30px;background: #234C7F;color: #ffffff;border: none;font-family: Arial;cursor: pointer;" value="SUBMIT" />      
    </form>
    <p>Examples: 
        <a href="#" id="hot1" onclick="hot(1)">Beijing</a> 
        <a href="#" id="hot2" onclick="hot(2)">Statue_of_Liberty</a>
        <a href="#" id="hot3" onclick="hot(3)">Barack_Obama</a>
        <a href="#" id="hot4" onclick="hot(4)">The_Tenant_of_Wildfell_Hall</a>
        <a href="#" id="hot5" onclick="hot(5)">Mo_Yan</a>
    </p>
	<p style="font-size:25px;">we have founded <%=size %> entities equal to <%=key %></p>
	</div>
	<div id="searchResult">
		<form id="Result" action="Predicate" method="post">
			<%for(String i:sameEntity){%>
				<p><input name="a" type="checkbox" value=<%=i%>></input>
				<a href=<%=i %> onclick="window.open(this.href); return false;" ><%=i%></a></p>
			<% }%>
			<p style="font-size:23px;">Select the entities you want to merge 
			& Click next to inter Schema Alignment</p>
			<input type="submit" style="float:right;height:35px;font-size:23px;font-family: Arial;" value="next" /> 
		</form>
	</div>
</div>
<div id="footer">
	©2016 &nbsp;&nbsp;<a href="http://labs.xjtudlc.com/labs/zscl.html"onclick="window.open(this.href); return false;">
	Knowledge Discovering Group </a>, Xi'an JiaoTong University, P.R.China
</div>
</body>	
</body>
</html>