package com.niit.springmvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.model.Cart;
import com.spring.model.Customer;
import com.spring.services.CartItemService;
import com.spring.services.CartService;
import com.spring.services.CartServiceImpl;
import com.spring.services.CustomerServices;

@Controller
public class CartController {
@Autowired
private CustomerServices customerServices;
@Autowired
private CartService cartService;

public CartService getCartService() {
	return cartService;
}

public void setCartService(CartService cartService) {
	this.cartService = cartService;
}

/*private CartServiceImpl cartService;

public CartServiceImpl getCartService() {
	return cartService;
}

public void setCartService(CartServiceImpl cartService) {
	this.cartService = cartService;
}*/

public CustomerServices getCustomerServices() {
		return customerServices;
	}

	public void setCustomerServices(CustomerServices customerServices) {
		this.customerServices = customerServices;
	}

@RequestMapping("/cart/getCartId")
public String getCartId(Model model){
	User user=(User)SecurityContextHolder
	  .getContext().getAuthentication().getPrincipal();
	String username=user.getUsername();
	Customer customer=customerServices .getCustomerByUsername(username);
	Cart cart=customer.getCart();
	int cartId=cart.getCartId();
	model.addAttribute("cartId",cartId);
	/*model.addAttribute("cartId", cartId);customer.getCart().getCartId()*/
	return "cart";
}
@RequestMapping("/cart/getCart/{cartId}")
public @ResponseBody Cart getCart(@PathVariable(value="cartId") int cartId){
	System.out.println("Get Cart in CartController ");
	Cart cart=cartService.getCartByCartId(cartId);
	System.out.println("cart id " +cart.getCartId());
	System.out.println(" list of items " + cart.getCartItems());
	return cart;
}

/*@RequestMapping("/cart/getCart/{cartId}")
public @ResponseBody Cart getCartItems(
		@PathVariable(value="cartId") int cartId){
	return cartService.getCartByCartId(cartId);
}*/
}
//@RequestMapping("/cart/removecartitem/{cartItemId}")
//@ResponseStatus(value=HttpStatus.NO_CONTENT)
//public void removeCartItem(
//	@PathVariable(value="cartItemId") int cartItemId){
//	cartItemService.removeCartItem(cartItemId);
//}

//@RequestMapping("/cart/removeAllItems/{cartId}")
//@ResponseStatus(value=HttpStatus.NO_CONTENT)
///public void removeAllCartItems(@PathVariable(value="cartId") int cartId){
	//Cart cart=cartService.getCartByCartId(cartId);
	//cartItemService.removeAllCartItems(cart);
//}







