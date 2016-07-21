package com.poc.jersey.rest.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import com.poc.jersey.rest.delegate.CustomerDelegator;

/**
 * RestPocApplicationBinder class is used to bind all configured beans for dependency injection (DI)
 * with in enterprise application. 
 * 
 * @author RaviReddy
 * @Date-Time 09:28:18 June 11, 2015 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
public class RestPocApplicationBinder extends AbstractBinder  {

	@Override
	protected void configure() {
		bind(CustomerDelegator.class).to(CustomerDelegator.class);
	}
	
}