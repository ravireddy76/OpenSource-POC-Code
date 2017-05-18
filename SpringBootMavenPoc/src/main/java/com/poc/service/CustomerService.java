package com.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.poc.domain.Customer;
import com.poc.utils.CustomerStorage;

@Service
public class CustomerService {
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
