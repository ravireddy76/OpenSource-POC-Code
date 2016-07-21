package com.poc.jersey.rest.delegate;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import com.poc.jersey.rest.domain.Customer;
import com.poc.jersey.rest.utils.CustomerStorage;

/**
 * CustomerDelegator class is used as delegate and handle business condition for request/response
 * with in enterprise application. 
 * 
 * @author RaviReddy
 * @Date-Time 09:28:18 June 10, 2015 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
@Named
public class CustomerDelegator implements Serializable {
	private static final long serialVersionUID = -8577479188202734112L;
	private static List<Customer> customers = CustomerStorage.buildSampleCustomers(20);

	
	/**
	 * Method to search customer by customer id.
	 * 
	 * @param customerId
	 * @return {@link Customer}
	 */
	public Customer getCustomerById(String customerId) {
		Customer searchedCustomer = null;

		/* Search for customer from customer storage by id.*/
		for (Customer customer : customers) {
			if (customer.getCustomerId().equalsIgnoreCase(customerId)) {
				searchedCustomer = customer;
			}
		}

		return searchedCustomer;
	}

	/**
	 * Method to get all customer information.
	 * 
	 * @return {@link List<Customer>}
	 */
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
