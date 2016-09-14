<%@ page language="java" import="java.util.*" import="java.io.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HashMap<String,HashSet<String>> hm=(HashMap<String,HashSet<String>>)request.getAttribute("SPO");
	Object[] key =(Object[])request.getAttribute("key");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"/ href="../css/index.css" > 
<link rel="shortcut icon" href="../img/logo.ico">
<script language="javascript" type="text/javascript" ></script>
<title>RDF fusion</title>
</head>
<body>
<div id="header">
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
<div id="container">
	<div id="searchResult">
		<div id="schemaInfo" style="height:100px;font-size: 25px;text-align: center;">
			These entities are equal to Beijing 
			& Select the entitis you want to merge
		</div>
		<form id="Result">
			<%
				String path=request.getRealPath("/localData/EntityData/Beijing.txt");
				try{
					FileReader fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					String pre=br.readLine();
					while(pre!=null){ %>
						<p><input type="checkbox"></input>
						<a href=<%=pre %> onclick="window.open(this.href); return false;" ><%=pre %></a></p>
						<%pre=br.readLine();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			%>		
		</form>
		<div id="Info" style="padding:15px;font-size: 20px;text-align: center;">
			Crowling the equal entities of Beijing ,return the follow result(only keep the useful information).
		</div>
		<!-- <form id="Result"> -->	
	
		<!--  </form> -->
		<div>
			<%for(int i=0;i<hm.size();i++) {
				if(hm.get(key[i]).size()>0){
					String a=key[i].toString();%>
					<%=a %>
					<br>
					<% Iterator it=hm.get(key[i]).iterator();
					while(it.hasNext()) { 
						String b=it.next().toString().replace("<", "&lt;");%>
						<%=b%>
						<br>
					<%} 
				}
			}
			%>		
		</div>
	</div>
	<div id="merge">
	
	</div>
</div>
<div id="footer">
	©2016 &nbsp;&nbsp;<a href="http://labs.xjtudlc.com/labs/zscl.html"onclick="window.open(this.href); return false;">
	Knowledge Discovering Group </a>, Xi'an JiaoTong University, P.R.China
</div>
</body>	
</body>
</html>