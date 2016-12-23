var myapp=angular.module("myapp",[])
.controller("bookController",function($scope,$http){

	$scope.getBooks = function(){
			alert("get book")
		   $http.get('http://localhost:6788/welcomehelloworld/getBooksList').success(function (data){
		       $scope.books = data;
		   });
		};
		/*$scope.EditCustomer = function(){
			alert("get customer")
		   $http.get('http://localhost:6789/welcomehelloworld/getCustomerByCustomerId/'+customerId).success(function (){
		       alert('edited sucessfully');
		   });
		};*/
		
		$scope.addToCart=function(isbn){
			//alert('inside add to cart')
			   $http.put('http://localhost:6788/welcomehelloworld/cart/add/'+isbn).success(function(){
				   alert('Added Successfully')
			   })
		   }
		$scope.quickBuy=function(isbn){
			//alert('inside add to cart')
			   $http.put('http://localhost:6788/welcomehelloworld/cart/quickBuy/'+isbn).success(function(){
				   alert(' Successfully')
			   })
		}
		$scope.refreshCart=function(){
			$http.get('http://localhost:6788/welcomehelloworld/cart/getCart/'+$scope.cartId).success(function(data){
				$scope.cart=data;
			})
		    } 
		    $scope.getCart=function(cartId){
		    	alert('inside getcart')
			$scope.cartId=cartId;
			$scope.refreshCart(cartId);
		    }

		    $scope.removeFromCart=function(cartItemId){
				$http.put(
		'http://localhost:6788/welcomehelloworld/cart/removecartitem/'+cartItemId)
			.success(function(){
				$scope.refreshCart();
			})
		    }

		    $scope.clearCart=function(){
				$http.put(
		'http://localhost:6788/welcomehelloworld/cart/removeAllItems/'+$scope.cartId)
			.success(function(){
				$scope.refreshCart();
			});
		    }

		    $scope.calculateGrandTotal=function(){
		    	var grandTotal=0.0
		    	for(var i=0;i<$scope.cart.cartItems.length;i++)
		    		grandTotal=grandTotal+$scope.cart.cartItems[i].totalPrice;
		    	return grandTotal;s
		    }


		});



