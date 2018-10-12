<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Book Form page</title>
</head>
<body>
<h1>Book Form</h1>
	<form:form action="book" modelAttribute="book" method="POST">
	<div>
		<form:label path="bcode">Book</form:label>
		<form:input path="bcode" type="number"/>
	</div>
		<div>
		<form:label path="title">Title</form:label>
		<form:input path="title"/>
	</div>
		<div>
		<form:label path="price">Price</form:label>
		<form:input path="price" type="decimal"/>
	</div>
		<div>
		<form:label path="category">Category</form:label>
		<form:select path="category">
		<form:option value="">-----Select--------</form:option>
			<form:options items="${possibCatgs}"/>
		</form:select>
	</div>
		<div>
		<form:label path="type">Type</form:label>
		<form:radiobuttons path="type" items="${possibTypes}"/>
	</div>
	<div>
		<form:button type="submit">Save</form:button>
	</div>
	</form:form>
</body>
</html>