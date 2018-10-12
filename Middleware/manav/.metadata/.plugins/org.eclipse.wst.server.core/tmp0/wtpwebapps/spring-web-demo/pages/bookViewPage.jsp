<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Book View page</title>
</head>
<body>
<h1>Book page</h1>
	<table>
	<tr>
	<td>BCode</td>
	<td>${book.bcode}</td>
	</tr>
		<tr>
	<td>BTitle</td>
	<td>${book.title}</td>
	</tr>
		<tr>
	<td>Category</td>
	<td>${book.category}</td>
	</tr>
		<tr>
	<td>Price</td>
	<td>${book.price}</td>
	</tr>
		<tr>
	<td>Type</td>
	<td>${book.type}</td>
	</tr>
	</table>
</body>
</html>