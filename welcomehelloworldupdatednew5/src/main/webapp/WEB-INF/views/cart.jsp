 <%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp"%>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js">

</script>
<script src="<c:url value="/resources/js/Controller.js"></c:url>"></script>
<head>
<meta shttp-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-wrapper">
<div class="container">
<section>
<div class="jumbotron">
<div class="container">
<h3>Cart</h3>
<p>All the selected books in your shopping cart</p>
</div>
</div>
Cart Id is<c:out value="${cartId }"/>

<div ng-app="myapp" ng-controller="bookController">
<div ng-init="getCart(${cartId})">
<a class="btn btn-danger pull-left" ng-click = "clearCart()">
<span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a><br>
<a href="<c:url value="/order/${cartId}" />" class="btn btn-success pull-right">
<span class="glyphicon glyphicon-shopping-cart"></span> 
Check out</a>

List of Cart Items

<table class="table table-hover">

<tr>
<th>TITLE</th>
<th>Price</th>
<th> QUANTITY</th>
<th>TOTAL PRICE</th>
<th>Action</th>
</tr>

<tr ng-repeat="cartItem in cart.cartItems">
<td>{{cartItem.book.title}}</td>
<td>{{cartItem.book.price}}</td>
<td>{{cartItem.quantity}}</td>
<td>{{cartItem.totalPrice}}</td>
<td><a href="#" class="label label-danger" ng-click="removeFromCart(cartItem.cartItemId)"><span class="glyphicon glyphicon-remove"></span>Remove</a>
</tr>

</table>
TOTAL PRICE {{calculateGrandTotal()}}
</div>
<a href="<c:url value="/getAllBooks" />" >Continue shopping</a>
</div>
</body>

<%-- </section>
<div ng-app="myapp" ng-controller="bookController">

<div ng-init="getCart(${cartId})">
<br>
List of books purchased
<div>
<a class="btn btn-danger pull-left" ng-click="clearCart()">
<span class="glyphicon glyphicon-remove-sign"></span> Clear Cart
</a>
</div>
<table class="table table-hover">
<thead>



</body> --%>
</html>