<%@ taglib uri ="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<html>
<head>
<title>My Spring Web About Page</title>
</head>
<body>
<h1>About Page</h1>
<p><strong>Web Master</strong><em>${webmaster}</em></p>
<p><strong>Development Team</strong></p>
<ol>
<c:forEach items = "${devTeam}" var="ele">
<li>${ele}</li>
</c:forEach>
</ol>
<p><strong>Admin Mail Id</strong><em>${adminMailId}</em></p>
<a href = "home">Back To Home</a>
<!-- $ is called JSP Expressionn Language -->
</body>
</html>