package com.poc.utils;

import java.util.ArrayList;
import java.util.List;

import com.poc.domain.Customer;

public class CustomerStorage {
	/**
	 * Method to build sample customers information.
	 * 
	 * @param numberOfCustomers
	 * @return {@link List}
	 */
	public static List<Customer> buildSampleCustomers(int numberOfCustomers) {
		List<Customer> customers = new ArrayList<Customer>();

		for (int iter = 0; iter < numberOfCustomers; iter++) {
			Customer customer = new Customer();

			int countTracker = iter + 1;
			customer.setCustomerId("" + countTracker);
			customer.setFirstName("CFN-" + countTracker);
			customer.setLastName("CLN-" + countTracker);
			customer.setAddress("123" + iter + " N View Dr. Minneapolis, MN");
			customer.setZipCode("5544" + iter);
			customer.setContactNumber("952-111-222" + iter);
			customers.add(customer);
		}
		return customers;
	}
	
}
