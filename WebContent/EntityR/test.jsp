<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String json=(String)request.getAttribute("json"); %>
<script type="text/javascript" charset="UTF-8">          
       var var1=<%=json%>;    
       console.log(var1); 
</script> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="../JS/jit/test.js"></script>
<title>Insert title here</title>
</head>
<body onload="init();">
	<div><%=json.length() %></div>
 	
</body>
</html>