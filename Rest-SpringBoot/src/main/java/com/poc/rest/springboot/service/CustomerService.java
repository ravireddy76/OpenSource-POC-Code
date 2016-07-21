package com.poc.rest.springboot.service;

import com.poc.rest.springboot.domain.Customer;

import java.util.List;

/**
 * CustomerService class is acts delegate serve the request and response to the controller class with in enterprise application.
 *
 * @author RaviReddy
 * @Date-Time 09:28:18 June 10, 2016 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
public interface CustomerService {

    Customer getCustomerById(String customerId);

    List<Customer> getAllCustomers();

}
