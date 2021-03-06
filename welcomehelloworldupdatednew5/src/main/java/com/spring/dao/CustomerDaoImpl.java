package com.spring.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Authorities;
import com.spring.model.Book;
import com.spring.model.Cart;
import com.spring.model.Customer;
import com.spring.model.Users;
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
@Autowired
private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

	public void addCustomer(Customer customer) {
		System.out.println("adding customer in dao");
		Session session=sessionFactory.openSession();
		//customer - has users, billingaddress, shippingaddress
				//insert the users , billingaddress, shippingaddress
				customer.getUsers().setEnabled(true);
				

		Authorities authorities=new Authorities();//transient-heapmemory
		String username=customer.getUsers().getUsername();
		authorities.setUsername(username);
		authorities.setAuthorities("ROLE_USER");
		
		Cart cart = new Cart();//new cart
		//It is to set CartId for Customer table
		customer.setCart(cart);//set the cart to the customer
		//if we omit this statement, then it will insert null for customerid in cart
		//to set the customerid in cart table
		cart.setCustomer(customer); 
		
		

		//authorities.setUsername(customer.getUsers().getUsername());
	//	authorities.setAuthorities("ROLE_USER");
	//	Users users=customer.getUsers();
	//	users.setEnabled(true);
		session.save(customer);
		session.save(authorities);
		session.flush();
//session.close();
	}
	public List<Customer> getAllCustomers() {
		Session session=sessionFactory.openSession();
		List<Customer> customerList= 
				session.createQuery("from Customer").list();
		//select * from customer 
		//list of records.list() // into list of customer objects
		session.close();
		return customerList;
	}
	/*public List<Customer> getAllCustomers() {
		Session session=sessionFactory.openSession();
		List<Customer> customers=session.createQuery("from Customer").list();
		return customers;
	}*/

	public Customer getCustomerByUsername(String username) {
		Session session=sessionFactory.openSession();
		//using username - get users details
		Query query=session.createQuery("from Users where username=?");
		query.setString(0, username);
		//select * from users where username='adam';
		Users users=(Users)query.uniqueResult();
		
		//From users get Customer details
		
		Customer customer=users.getCustomer();
		session.close();
		return customer;
		
		
		
}

	public Customer getCustomerbyCustomerId(int CustomerId) {
		 Session session=sessionFactory.openSession();
			
			  Customer customer=(Customer) session.get(Customer.class, CustomerId);  
			session.close();
			return customer;
		
	}

	}








