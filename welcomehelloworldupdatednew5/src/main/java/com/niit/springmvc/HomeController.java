package com.niit.springmvc;


	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Book;
import com.spring.model.Customer;
import com.spring.services.BookServices;
import com.spring.services.CustomerServices;

	@Controller
	public class HomeController {
		@Autowired
		private CustomerServices customerServices;
		
		public CustomerServices getCustomerService() {
			return customerServices;
		}

		public void setCustomerService(CustomerServices customerServices) {
			this.customerServices = customerServices;
		}

		
	@RequestMapping("/home")
	public String homePage(){
		return "home";
		//web-inf/views/home
	}
	@RequestMapping("/aboutus")
	public String aboutUs(){
		return "aboutus";
		
	}
	@RequestMapping("/getCustomerByUsername/{customerName}")
	public ModelAndView getCustomerByUsername(@PathVariable(value= "customerName") String customerName){
		Customer c=customerServices.getCustomerByUsername(customerName);
		return new ModelAndView("profile","customerObj",c);
	}
	
	
	@RequestMapping("/header")
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout, 
			Model model){
			if(error!=null)
		model.addAttribute("error","Invalid username and password");
		
		if(logout!=null)
			model.addAttribute("logout","You have logged out successfully");
		return "header";
	}
	}
	



