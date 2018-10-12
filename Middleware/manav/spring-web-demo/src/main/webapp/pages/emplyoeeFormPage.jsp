<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Intrest Input  Form Page</title>
</head>
<body>
	<form:form action="emp" modelAttribute="emp" method="POST">
	<div>
		<form:label path="empId">Emp ID</form:label>
		<form:input path="empId" type="number"/>
	</div>
		<div>
		<form:label path="name">EmpName</form:label>
		<form:input path="name"/>
	</div>
		<div>
		<form:label path="basic">Basic</form:label>
		<form:input path="basic" type="decimal"/>
	</div>
			<div>
		<form:label path="experience">Experience</form:label>
		<form:input path="experience" type="decimal"/>
	</div>
		</div>
		<div>
		<form:label path="dept">Department</form:label>
		<form:select path="dept">
		<form:option value="">-----Select--------</form:option>
			<form:options items="${possibDept}"/>
		</form:select>
	</div>
		<div>
		<form:label path="gender">Type</form:label>
		<form:radiobuttons path="gender" items="${possibGen}"/>
	</div>
	<div>
		<form:button type="submit">Save</form:button>
	</div>
	</form:form>
</body>
</html>