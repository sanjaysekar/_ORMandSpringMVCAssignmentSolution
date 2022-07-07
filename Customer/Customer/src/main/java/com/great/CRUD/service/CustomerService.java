package com.great.CRUD.service;

import java.util.List;

import com.great.CRUD.model.*;

public interface CustomerService {

	void saveCustomer(Customer customer);
    // List<Customer> getAllCustomers();
    //void saveCustomer(Customer customer);
     //Customer getCustomerById(long Id);
     //void deleteCustomerById(long id);

	List<Customer> getAllCustomers();

	Customer getCustomerById(long id);

	void deleteCustomerById(long id);

	
	
}