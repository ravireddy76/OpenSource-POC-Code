package com.poc.rest.springboot.service;

import com.poc.rest.springboot.domain.Customer;
import com.poc.rest.springboot.utils.CustomerStorage;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * CustomerServiceImpl class is implementation for customer service interface with in enterprise application.
 *
 * @author RaviReddy
 * @Date-Time 09:28:18 June 10, 2016 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customers = CustomerStorage.buildSampleCustomers(20);


    /**
     * Method to search customer by customer id.
     *
     * @param customerId
     * @return {@link Customer}
     */
    @Override
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
    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

}
