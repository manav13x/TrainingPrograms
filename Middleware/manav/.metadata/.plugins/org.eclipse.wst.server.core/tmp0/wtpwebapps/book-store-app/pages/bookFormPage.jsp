<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="../header" />
<h1>Emplyoee Form</h1>
<main> <form:form action="saveBook" modelAttribute="book"
	method="POST">
	<div>
		<form:label path="bcode">Book</form:label>
		<c:choose>
			<c:when test="${book.bcode==0}">
				<form:input path="bcode" type="number" />
			</c:when>
			<c:otherwise>
				<form:input path="bcode" type="number" readonly="true" />
			</c:otherwise>
		</c:choose>

	</div>
	<div>
		<form:label path="title">Title</form:label>
		<form:input path="title" />
	</div>
	<div>
		<form:label path="price">Price</form:label>
		<form:input path="price" type="decimal" />
	</div>
	<div>
		<form:label path="category">Category</form:label>
		<form:select path="category">
			<form:option value="">-----Select--------</form:option>
			<form:options items="${possibCatgs}" />
		</form:select>
	</div>
	<div>
		<form:label path="type">Type</form:label>
		<form:radiobuttons path="type" items="${possibTypes}" />
	</div>
	<div>
		<form:button type="submit">Save</form:button>
	</div>
</form:form> </main>
<jsp:include page="../footer" />