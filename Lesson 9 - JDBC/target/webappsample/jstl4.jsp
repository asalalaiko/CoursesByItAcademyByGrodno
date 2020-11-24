<%@page import="by.grodno.pvt.site.webappsample.service.User"%>
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


<a href="http://localhost:8080/webappsample/jstl1" class="badge badge-danger"> << Back  </a>
<c:if test="${requestScope.users != null}">
    <c:set var="currUser" scope="request"
           value="${requestScope.users[0]}" />
<form action = "user" method = "POST">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputfirstname">First Name:</label>
            <input type = "text" class="form-control" id="inputfirstname" value="${requestScope.currUser.firstName}" name = "firstName">
        </div>
        <div class="form-group col-md-6">
            <label for="inputlastname">Last Name:</label>
            <input type = "text" class="form-control" id="inputlastname" value="${requestScope.currUser.lastName}" name = "lastName" >
        </div>
    </div>
    <div class="form-group">
        <label for="inputBirthDate">Birthdate</label>
        <input type="text" class="form-control" id="inputBirthDate" value="
                <%Date userBirth = ((User) request.getAttribute("currUser")).getBirthdate();
                    if (userBirth != null) {
                    out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
                        }
                    %>
" name = "birthdate">
    </div>

    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Sex:</legend>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="male" id="male"
                    <c:if test="${requestScope.currUser.male}"> checked value="true" </c:if> value="true"
                    <label class="form-check-label" for="male">
                         Male
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="male" id="female"
                    <c:if test="${requestScope.currUser.male == false}"> checked value="false"></c:if>
                    <label class="form-check-label" for="female" >
                        Female
                    </label>
                </div>
            </div>
        </div>
    </fieldset>
    <div class="form-group">
        <label for="inputSalary">Salary: </label>
        <input type="text" class="form-control" id="inputSalary" value="${requestScope.currUser.salary}" name = "salary">
    </div>

    <div class="form-group">
        ${requestScope.currUser.department}

    </div>

    <input type="hidden" name="id" value="${requestScope.currUser}">


    <input type = "submit" value = "Submit" />

</form>
    </c:if>

    <br />


</body>
</html>
