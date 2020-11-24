<%@page import="by.grodno.pvt.site.webappsample.service.Dep"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="fragments/header.jsp"%>


<a href="http://localhost:8080/webappsample/jstl11" class="badge badge-danger"> << Back  </a>
<c:if test="${requestScope.deps != null}">
    <c:set var="currDep" scope="request"
           value="${requestScope.deps[0]}" />
<form action = "dep" method = "POST">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputdepname">Department Name:</label>
            <input type = "text" class="form-control" id="inputdepname" value="${requestScope.currDep.depName}" name = "depName">
        </div>
        <div class="form-group col-md-6">
            <label for="inputdepinfo">Information by Department:</label>
            <input type = "text" class="form-control" id="inputdepinfo" value="${requestScope.currDep.depInf}" name = "depInf" >
        </div>
    </div>
       <input type="hidden" name="id" value="${requestScope.currDep.id}">
    <input type = "submit" value = "Submit" />

</form>
    </c:if>

    <br />


</body>
</html>
