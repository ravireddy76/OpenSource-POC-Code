package com.poc.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.poc.domain.Customer;
import com.poc.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private transient final Logger logger = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	CustomerService customerService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		logger.fine("Creating  new customer " + customer.toString());
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/customerId/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
		logger.fine("Search all customer by customerId : " + customerId);

		Customer searchedCustomer = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(searchedCustomer, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		logger.fine("Search all customers");

		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
