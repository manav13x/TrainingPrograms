<%@ page import = "java.time.LocalDate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Jsp Site</title>
</head>
<body>
<h3> <%=(LocalDate.now())%> </h3>

<%
	String[] myTeam = new String[] {"vamsy","venkat"};
%>
<ol>
<% 	for(String st : myTeam){%>
	<li> <%=st %> %></li>
	<%} %> 
</ol>

</body>
</html>