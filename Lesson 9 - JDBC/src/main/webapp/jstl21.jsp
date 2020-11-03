<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

   <body>
      <%@ include file="fragments/header.jsp"%>

      <a href="http://localhost:8080/webappsample/jstl11" class="badge badge-danger"> << Back  </a>

      <form action = "dep" method = "POST">

            <div class="form-group col-md-6">
               <label for="inputdepname">Department Name:</label>
               <input type = "text" class="form-control" id="inputdepname" placeholder="Department" name = "depName">
               </div>

            <div class="form-group col-md-6">
               <label for="inputdepinfo"> Information by Department</label>
               <input type = "text" class="form-control" id="inputdepinfo" placeholder="Department info..." name = "depInf">
             </div>
         <div class="form-group col-md-6">
           <input type = "submit" value = "Submit" />
         </div>

        </form>
   </body>
</html>

