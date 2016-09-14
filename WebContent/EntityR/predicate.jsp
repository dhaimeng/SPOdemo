<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RDF fusion</title>
<% String json=(String)request.getAttribute("json");%>
<script type="text/javascript" charset="UTF-8">          
       var var1=<%=json%>;    
       
</script> 
<link href="../css/index.css" rel="stylesheet" type="text/css"/> 
<link href="../css/predicate.css" rel="stylesheet" type="text/css"/> 
<link rel="shortcut icon" href="../img/logo.ico">
<script language="javascript" type="text/javascript" src="../JS/jit/jit.js"></script>
<script language="javascript" type="text/javascript" src="../JS/jit/jquery2.0.3jquery.js"></script>
<script language="javascript" type="text/javascript" src="../JS/jit/rdf.js"></script>
</head>
<body onload="init();">
<div id="header" >
  <div id="top_welcom">
   RDF data fusion and truth discovery system 
  </div>   
  <div id="nav">
  	&nbsp;&nbsp;<b><a href="index.html" >Home</a></b>
  	&nbsp;&nbsp;|<b><a href="Subject.html">Entity co-reference</a></b>
  	&nbsp;&nbsp;|<b>Schema alignment</b>
  	&nbsp;&nbsp;|<b><a href="Object.jsp">Conflict resolution</a></b>
  </div>
</div>
<div id="container" >
	<div id="left-container">
			<div id="log"></div>
			<div id="infovis"></div>    
	</div>
	<div id="right-container">
			<div id="inner-details"></div>			
	</div>
	
</div>
<div id="footer">
	©2016 &nbsp;&nbsp;<a href="http://labs.xjtudlc.com/labs/zscl.html"onclick="window.open(this.href); return false;">
	Knowledge Discovering Group </a>, Xi'an JiaoTong University, P.R.China
</div>
</body>
</html>