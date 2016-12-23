<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


	<%-- <c:if test="${registrationSuccess !=null}">
${registrationSuccess }
</c:if>
	<c:if test="${logout!=null }">
${logout }
</c:if> --%>
<style>
.modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;

  </style>
</head>
<body>
<c:if test="${registrationSuccess !=null}">
${registrationSuccess }
</c:if>
	<c:if test="${logout!=null }">
${logout }
</c:if>
<%-- <form name="loginForm" method="post"
		action="<c:url value="/j_spring_security_check" />" method="post">
		<c:if test="${not empty error}"> --%>
<%-- ${error}
<!--  <div class="error"style="color: #ff0000;">${error}</div>-->
		</c:if>
 --%>
<div class="container">
 <!--  <h2>Modal Login Example</h2> -->
  Trigger the modal with a button
  <button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        
	<form name="loginForm" method="post"
		action="<c:url value="/j_spring_security_check" />" method="post"> 
            <div class="form-group">
              <label for="username"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" id="username" name="j_username" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" id="password" name="j_password" placeholder="Enter password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
        </form>
        </div>
        <!-- <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? <a href="#">Sign Up</a></p>
          <p>Forgot <a href="#">Password?</a></p>
        </div> -->
      </div>
      
    </div>
  </div> 
</div>
 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

<%-- 
	<form name="loginForm" method="post"
		action="<c:url value="/j_spring_security_check" />" method="post">
		<c:if test="${not empty error}"> --%>
<%-- ${error} --%>
<!--  <div class="error"style="color: #ff0000;">${error}</div>-->
		<%-- </c:if> --%>
		<!-- Enter Username <input type="text" name="j_username"/>
Enter password <input type="password" name="j_password"/>
		 -->
		<!-- <div class="form-group">
			<label for="username">User: </label> <input type="text" id="username"
				name="j_username" class="form-control" />
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" id="password" name="j_password" class="form-control" />
		</div> -->
		<!-- <input type="submit" value="Submit" class="btn btn-default" > -->
	</form>
	<%@include file="/WEB-INF/views/footer.jsp"%>

</body>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<c:if test="${registrationSuccess !=null}">
${registrationSuccess }
</c:if>
	<c:if test="${logout!=null }">
${logout }
</c:if>

	<form name="loginForm" method="post"
		action="<c:url value="/j_spring_security_check" />" method="post">
		<c:if test="${not empty error}">
${error}
<!--  <div class="error"style="color: #ff0000;">${error}</div>-->
		</c:if>
		<div class="container">
		<div class="wrapper">
		<div class="form-group">
		Enter Username <input type="text" name="j_username"/></div>
		<div class="form-group">
Enter password <input type="password" name="j_password"/></div>
		
		<!-- <div class="form-group">
			<label for="username">User: </label> <input type="text" id="username"
				name="j_username" class="form-control" />
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" id="password" name="j_password" class="form-control" />
		</div> -->
		<div class="form-group">
		<input type="submit" value="Submit" class="btn btn-primary" ></div>
		</div>
		</div>
	</form>
	<%@include file="/WEB-INF/views/footer.jsp"%>

</body>
</html> --%>