package com.poc.jersey.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.poc.jersey.rest.delegate.CustomerDelegator;
import com.poc.jersey.rest.domain.Customer;

/**
 * CustomerResource class is used as a service to expose outside world in the form of web service call
 * to handle request/response with in enterprise application. 
 * 
 * @author RaviReddy
 * @Date-Time 09:28:18 June 10, 2015 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
@Named
@Path("/customer")
public class CustomerResource {
	
	@Inject
	CustomerDelegator customerDelegator;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCsutomer(Customer customer) {
		System.out.println("Customer Information Is Created....");
		System.out.println("X-X-X-X--- Customer -X-X-X-X");
		System.out.println(customer.toString());

		return Response.ok(customer).build();
	}
	
	@GET
	@Path("/customerId/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerById(@PathParam("customerId") String customerId){
		Customer customer = customerDelegator.getCustomerById(customerId);
		return Response.ok(customer).build();
	}
	
	
	@GET
	@Path("/allcustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomers(){
		List<Customer> customers = customerDelegator.getAllCustomers();
		return Response.ok(customers).build();
	}
	
}
	
	

