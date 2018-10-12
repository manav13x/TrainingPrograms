<%@ taglib uri = "http://java.sun.com/jstl/core_rt"  prefix="c"%>
<jsp:include page = "../header"/>
<main>
	<h3>Books List</h3>
	<c:choose>
	<c:when test="${books==null || books.size()==0 }">
		<h4>No books Found</h4>
	</c:when>
	<c:otherwise>
		<h4>${books.size()} Books(s) Found/</h4>
	<table>
		<tr>
			<th>Book#</th>
			<th>Title</th>
			<th>Price</th>
			<th>Category</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${books}" var="book"> 
		<tr>
			<td>${book.bcode}</td>
			<td>${book.title}</td>
			<td>${book.price}</td>
			<td>${book.category}</td>
			<td>${book.type}</td>
			<td>
				<a href = "editBook?bcode=${book.bcode}">Edit</a>
			</td>
			<td>
				<a href = "deleteBook?bcode=${book.bcode}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
</main>
<jsp:include page="../footer"/>