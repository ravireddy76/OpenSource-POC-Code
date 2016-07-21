package com.poc.rest.springboot.controller;


import com.poc.rest.springboot.domain.Customer;
import com.poc.rest.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * CustomerController class is used as resource to expose outside world as REST web service call
 * with in enterprise application.
 *
 * @author RaviReddy
 * @Date-Time 09:28:18 June 10, 2016 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private transient final Logger logger = Logger.getLogger(CustomerController.class.getName());

    @Autowired
    CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        logger.fine("Creating  new customer "+customer.toString());
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/customerId/{customerId}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
        logger.fine("Search all customer by customerId : "+customerId);

        Customer searchedCustomer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(searchedCustomer, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.fine("Search all customers");

        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
