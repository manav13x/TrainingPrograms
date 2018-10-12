<%@ taglib uri = "http://java.sun.com/jstl/core_rt"  prefix="c"%>
<jsp:include page = "../header"/>
<main>
	<h3>Emplyoee List</h3>
	<c:choose>
	<c:when test="${emps==null || emps.size()==0 }">
		<h4>No Emplyoee Found</h4>
	</c:when>
	<c:otherwise>
		<h4>${emps.size()} Emplyoees(s) Found/</h4>
	<table>
		<tr>
			<th>Emp#</th>
			<th>Name</th>
			<th>Basic</th>
			<th>Hra</th>
			<th>Dept</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${emps}" var="emp"> 
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.ename}</td>
			<td>${emp.basic}</td>
			<td>${emp.hra}</td>
			<td>${emp.dept}</td>
			<td>
				<a href = "editEmp?empId=${emp.empId}">Edit</a>
			</td>
			<td>
				<a href = "deleteEmp?empId=${emp.empId}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
</main>
<jsp:include page="../footer"/>