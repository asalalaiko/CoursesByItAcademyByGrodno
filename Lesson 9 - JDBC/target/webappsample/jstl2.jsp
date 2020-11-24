<%@page import="by.grodno.pvt.site.webappsample.service.Dep"%>

<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

   <body>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      <%@ include file="fragments/header.jsp"%>

      <a href="http://localhost:8080/webappsample/jstl1" class="badge badge-danger"> << Back  </a>

      <form action = "user" method = "POST">
         <div class="form-row col-md-6">
            <div class="form-group col-md-6">
               <label for="inputfirstname">First Name:</label>
               <input type = "text" class="form-control" id="inputfirstname" placeholder="Ivan" name = "firstName">
               </div>
            <div class="form-group col-md-6">
               <label for="inputlastname">Last Name:</label>
               <input type = "text" class="form-control" id="inputlastname" placeholder="Ivanov"name = "lastName" >
               </div>
            </div>
         <div class="form-group col-md-6">
            <label for="inputBirthDate">Birthdate</label>
            <input type="text" class="form-control" id="inputBirthDate" placeholder="YYYY-MM-DD" name = "birthdate">
         </div>

         <fieldset class="form-group col-md-6">
            <div class="row">
               <legend class="col-form-label col-sm-2 pt-0">Sex:</legend>
               <div class="col-sm-10">
                  <div class="form-check">
                     <input class="form-check-input" type="radio" name="male" id="male" value="true"  >
                     <label class="form-check-label" for="male">
                        Male
                     </label>
                  </div>
                  <div class="form-check">
                     <input class="form-check-input" type="radio" name="male" id="female" value="false" >
                     <label class="form-check-label" for="female">
                        Female
                     </label>
                  </div>
               </div>
            </div>
         </fieldset>
         <div class="form-group col-md-6">
            <label for="inputSalary">Salary: </label>
            <input type="text" class="form-control" id="inputSalary" placeholder="0 .. 10000" name = "salary">
         </div>
            <div class="form-group col-md-6">
            <select class="custom-select" name="department">
               <option selected>Select departament</option>
            <c:if test="${requestScope.deps != null}">
               <c:forEach var="i" begin="1" end="${fn:length(requestScope.deps)}">
                  <c:set var="currDep" scope="request"
                         value="${requestScope.deps[i-1]}"/>
                  <option value="${requestScope.currDep.id}">${requestScope.currDep.depName}</option>
               </c:forEach>
            </c:if>
            </select>
         </div>
         <div class="form-group col-md-6">
         <input type = "submit" value = "Submit" />
         </div>
         </div>

      </form>
      <!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
   </body>
</html>

