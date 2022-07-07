package com.great.CRUD.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.great.CRUD.model.*;
import com.great.CRUD.service.CustomerService;
import com.great.CRUD.controller.*;

@Controller
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	
     //display list of customers
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "index";
	}
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id,Model model){
		//get customer from service
		Customer customer = customerService.getCustomerById(id);
		
		//set customer as a model Attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "update_customer";
	}
	@GetMapping("/deleteCustomer/{id}")
		public String deleteCustomer(@PathVariable (value = "id") long id) {
		//call delete Customer Method
		this.customerService.deleteCustomerById(id);
		return "redirect:/";
		
		
	}

//	@PostMapping("/customers/{id}")
//	public String updateCustomer(@PathVariable Long id,
//			@ModelAttribute("customer") Customer customer,
//			Model model) {
//		
//		// get student from database by id
//		Customer existingCustomer = customerService.getCustomerById(id);
//		existingCustomer.setId(id);
//		existingCustomer.setFirstName(customer.getFirstName());
//		existingCustomer.setLastName(customer.getLastName());
//		existingCustomer.setEmail(customer.getEmail());
//		
//		// save updated student object
//		customerService.updateCustomer(existingCustomer);
//		return "redirect:/";	
//	
//	
//	
//}
}