 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
/* .jumbotron {
    position: relative;
    background: #000 url("jumbotron-bg.png") center center;
    width: 100%;
    height: 100%;
    background-size: cover;
    overflow: hidden;
} */
<style>
.modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;

  
body {
    background-color:  #bebebe;
    background-img-src="E:/pics/k.jpg";
}
/* { 
    background-color: #8ee5ee; /* Green */
    /* color: #ffffff; */
} */
</style>

</head>
<body>
<c:if test="${registrationSuccess !=null}">
${registrationSuccess }
</c:if>
	<c:if test="${logout!=null }">
${logout }
</c:if>
<nav class="navbarnavbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li><a href="<c:url value="/home" />">Home</a></li>
				<li> <a href="<c:url value="/aboutus" />">About us</a></li>
				
				<li> <a href="<c:url value="/getCustomerByUsername/${pageContext.request.userPrincipal.name}" />">profile</a></li>
				<!--  only when the user logs in these two links will be visible -->
			
			<!--  Principal - object which contains details about the users -->
			
			
			<!--  pageContext - implicit object -->
			<!--  request - HttpServletRequest -->
			<!--  userPrincipal - Principal -->
<!--  name - property username -->			
		
		<c:if test="${pageContext.request.userPrincipal.name!=null}">
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="<c:url value="/admin/book/addBook" />">Add New Book</a></li>
				</security:authorize>
				
				<li><a href= "<c:url value="/getAllBooks"/>">Browse All Books</a></li>
				<li><a> Welcome ${pageContext.request.userPrincipal.name }</a></li>
				<%-- <li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li> --%>
			<security:authorize access="hasRole('ROLE_USER')">
			<li><a href="<c:url value="/cart/getCartId"/>">Cart</a></li>
			</security:authorize>
		
			<c:url value="/j_spring_security_logout" var="url"></c:url>
			<li><a href="${url}">logout</a>
			</c:if>
			
		
					
			<c:if test="${pageContext.request.userPrincipal.name ==null }">
			<li><a href="<c:url value="/header" ></c:url> id="myBtn"">Login</a></li>
			<c:url value="/customer/registration" var="url"></c:url>
			<li><a href= "${url }">Register</a></li>
			</c:if>
			
			
		</ul>
	</div>
	
         
	</nav>
	
<!-- <div class="jumbotron">
    <div class="container">
        <h1>Hello, world!</h1>
        <p>...</p>
    </div> -->
</div>
<div class="container">
 <!--  <h2>Modal Login Example</h2> -->
 <!--  Trigger the modal with a button
  <button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button>
 -->
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
        
	<form name="header" method="post"
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

</body>
</html>
			

