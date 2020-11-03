<%@page import="by.grodno.pvt.site.webappsample.service.Dep"%>

<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@ include file="fragments/header.jsp"%>

	<br />


	<c:if test="${requestScope.deps != null}">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Num</th>
					<th scope="col">Department</th>
					<th scope="col">Description</th>
					<th colspan="2" scope="col">Actions</th>
				</tr>
			</thead>

<c:forEach var="i" begin="1" end="${fn:length(requestScope.deps)}">
	<c:set var="currDep" scope="request"
		   value="${requestScope.deps[i-1]}" />
	<tr>
	<td scope="row">${i}</td>
	<td>${requestScope.currDep.depName}</td>
	<td>${requestScope.currDep.depInf}</td>
		<td><a class="btn btn-danger"
			   href="http://localhost:8080/webappsample/dep/delete?number=${requestScope.currDep.id}">Delete
			Department</a></td>
		<td>
			<a class="btn btn-danger"
			   href="http://localhost:8080/webappsample/dep/edit?number=${requestScope.currDep.id}">Edit
				Department</a>
		</td>

		</c:forEach>
		</table>
		</c:if>
	<a class="btn btn-primary"
		href="http://localhost:8080/webappsample/jstl21.jsp">Add department</a>

	<br />
	<br />

</body>
</html>
