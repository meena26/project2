package com.niit.springmvc;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.model.Book;
import com.spring.model.Cart;
import com.spring.model.CartItem;
import com.spring.model.Customer;
import com.spring.services.BookServices;
import com.spring.services.CartItemService;
import com.spring.services.CartService;
import com.spring.services.CustomerServices;



@Controller
public class CartItemController {
	//it needs CartItemService
	//to  get Customer details -> Cart details -> get list of cart item
	@Autowired	
	private CustomerServices customerServices;
	//to get Book details - to get the Book object -> to get the price of the book	
	@Autowired
	private BookServices bookServices;

@Autowired
private CartItemService cartItemService;
@Autowired
@Qualifier("cartService")
private  CartService cartservice;

public CartService getCartservice() {
	return cartservice;
}


public void setCartservice(CartService cartservice) {
	this.cartservice = cartservice;
}


public CartItemService getCartItemService() {
	return cartItemService;
}


public void setCartItemService(CartItemService cartItemService) {
	this.cartItemService = cartItemService;
}


public CustomerServices getCustomerServices() {
	return customerServices;
}


public void setCustomerServices(CustomerServices customerServices) {
	this.customerServices = customerServices;
}


public BookServices getBookServices() {
	return bookServices;
}


public void setBookServices(BookServices bookServices) {
	this.bookServices = bookServices;
}

@RequestMapping("/cart/quickBuy/{isbn}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public String quickBuyItem(@PathVariable(value = "isbn") int isbn){
	System.out.println("////////////////////////");
	//Is to get the username of the customer
	//User object contains details about the user -username , password, activeuser or not
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username=user.getUsername();
	Customer customer=customerServices.getCustomerByUsername(username);
	System.out.println("Customer is " + customer.getCustomerEmail() );
	Cart cart=customer.getCart();
	System.out.println(cart.getCartItems());
	
	List<CartItem> cartItems=cart.getCartItems();
	//isbn=4
	Book book=bookServices.getBookByIsbn(isbn);
	//1 1 1000 2 36
	//customer has selected the book with isbn 4
	for(int i=0;i<cartItems.size();i++){
		CartItem  cartItem=cartItems.get(i);
		//3==2
		//3==3
		if(isbn==cartItem.getBook().getIsbn()){
    		cartItem.setQuantity(cartItem.getQuantity() + 1 );
    		cartItem.setTotalPrice(cartItem.getQuantity() * book.getPrice());
    		cartItemService.addCartItem(cartItem);//update query
    		 int cartId=cartItem.getCart().getCartId();
    		 return "redirect:/order/{cartId}" +cartId;

    	}
    	
		/*if(book.getIsbn()==cartItem.getBook().getIsbn()){
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalPrice(cartItem.getQuantity() * cartItem.getBook().getPrice());
			cartItemService.addCartItem(cartItem);
			return;
		}*/
	}
	 CartItem cartItem=new CartItem();
	    cartItem.setBook(book);
	    cartItem.setQuantity(1);
	    cartItem.setTotalPrice(cartItem.getQuantity() * book.getPrice() );
		cartItem.setCart(cart);//SET CARTID IN CARTITEM TABLE (CARTID COLUMN IN CARTITEM TABLE)
		cartItemService.addCartItem(cartItem);//insert
		 int cartId=cartItem.getCart().getCartId();
		 
			return "redirect:/order/{cartId}" +cartId;
	}
	/*CartItem cartItem=new CartItem();
	cartItem.setQuantity(1);
	cartItem.setBook(book);
	cartItem.setTotalPrice(book.getPrice() * 1);
	cartItem.setCart(cart);//SET CARTID IN CARTITEM TABLE(CARTID COLUMN IN CARTITEM TABLE
	cartItemService.addCartItem(cartItem);//INSERT
	
	
}*/
@RequestMapping("/cart/add/{isbn}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void addCartItem(@PathVariable(value = "isbn") int isbn){
	//Is to get the username of the customer
	//User object contains details about the user -username , password, activeuser or not
	User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username=user.getUsername();
	Customer customer=customerServices.getCustomerByUsername(username);
	System.out.println("Customer is " + customer.getCustomerEmail() );
	Cart cart=customer.getCart();
	System.out.println(cart.getCartItems());
	
	List<CartItem> cartItems=cart.getCartItems();
	//isbn=4
	Book book=bookServices.getBookByIsbn(isbn);
	//1 1 1000 2 36
	//customer has selected the book with isbn 4
	for(int i=0;i<cartItems.size();i++){
		CartItem  cartItem=cartItems.get(i);
		//3==2
		//3==3
		if(isbn==cartItem.getBook().getIsbn()){
    		cartItem.setQuantity(cartItem.getQuantity() + 1 );
    		cartItem.setTotalPrice(cartItem.getQuantity() * book.getPrice());
    		cartItemService.addCartItem(cartItem);//update query
    		return;
    	}
    	
		/*if(book.getIsbn()==cartItem.getBook().getIsbn()){
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartItem.setTotalPrice(cartItem.getQuantity() * cartItem.getBook().getPrice());
			cartItemService.addCartItem(cartItem);
			return;
		}*/
	}
	 CartItem cartItem=new CartItem();
	    cartItem.setBook(book);
	    cartItem.setQuantity(1);
	    cartItem.setTotalPrice(cartItem.getQuantity() * book.getPrice() );
		cartItem.setCart(cart);//SET CARTID IN CARTITEM TABLE (CARTID COLUMN IN CARTITEM TABLE)
		cartItemService.addCartItem(cartItem);//insert
	}
	/*CartItem cartItem=new CartItem();
	cartItem.setQuantity(1);
	cartItem.setBook(book);
	cartItem.setTotalPrice(book.getPrice() * 1);
	cartItem.setCart(cart);//SET CARTID IN CARTITEM TABLE(CARTID COLUMN IN CARTITEM TABLE
	cartItemService.addCartItem(cartItem);//INSERT
	
	
}*/

@RequestMapping("/cart/removecartitem/{cartItemId}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void removeCartItem(
	@PathVariable(value="cartItemId") int cartItemId){
	cartItemService.removeCartItem(cartItemId);
}
@RequestMapping("/cart/removeAllItems/{cartId}")
@ResponseStatus(value=HttpStatus.NO_CONTENT)
public void removeAllCartItems(@PathVariable(value="cartId") int cartId){
	Cart cart=cartservice.getCartByCartId(cartId);

	cartItemService.removeAllCartItems(cart);
}

//@RequestMapping("/cart/removeAllItems/{cartId}")
//@ResponseStatus(value=HttpStatus.NO_CONTENT)
//public void removeAllCartItems(@PathVariable(value="cartId") int cartId){
//	Cart cart=cartService.getCartByCartId(cartId);
	//cartItemService.removeAllCartItems(cart);
@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
public void handleClientErrors (Exception ex){

}

@ExceptionHandler(Exception.class)
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
public void handleServerErrors (Exception ex){

}


}








