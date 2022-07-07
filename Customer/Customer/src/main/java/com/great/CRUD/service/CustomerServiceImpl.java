package com.great.CRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.CRUD.model.Customer;
import com.great.CRUD.repository.CustomerRepository;
@Service

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	 
	
	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer = null;
		if(optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException("Customer not found for id :: " + id);
		}
		return customer;
	}
	@Override
	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById(id);
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}



}
