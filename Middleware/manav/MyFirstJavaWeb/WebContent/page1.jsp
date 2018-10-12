<%@ page import = "java.time.LocalDate" %>
<%@ page import = "java.time.Period" %>
<html>
<head>
<title>My Jsp Page</title>
</head>
<body>
	<% String userName = request.getParameter("unm"); %>
	<% String dobStr = request.getParameter("dob"); %>
	<% LocalDate dob  = LocalDate.parse(dobStr); %>
	<% Period age =Period.between(dob,LocalDate.now()); %>
	<h2> Hello <%= userName %></h2>
	<h3>Yoou are just< <%=age.getYears() %> old now/h3>
	
</body>
</html>