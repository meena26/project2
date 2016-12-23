package com.spring.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Cart;
import com.spring.model.CartItem;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

@Autowired
private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public void addCartItem(CartItem cartItem) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
	}
	public void removeCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=
			(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		Cart cart=cartItem.getCart();
		List<CartItem> cartItems=cart.getCartItems();
		cartItems.remove(cartItem);
		
		session.flush();
		session.close();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems=cart.getCartItems();
		for(CartItem cartItem:cartItems){
			removeCartItem(cartItem.getCartItemId());
		}

	}



	public void quickBuyItem(CartItem cartItem) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
	}
		
	}





