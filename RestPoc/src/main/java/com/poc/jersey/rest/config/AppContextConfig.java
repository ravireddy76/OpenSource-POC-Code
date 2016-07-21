package com.poc.jersey.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 * AppContextConfig class is act like context configuration(Similar like spring context xml file) to scan packages
 * to implement Dependency Injection and IOC patterns  with in enterprise application. 
 * 
 * @author RaviReddy
 * @Date-Time 10:18:18 June 11, 2015 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
public class AppContextConfig extends ResourceConfig {

	public AppContextConfig() {
		
		/* Bind the application binder to create classes for dependency injection (DI).*/
		register(new RestPocApplicationBinder());
		
		/* Register resources and providers using package-scanning. */
		packages(true,"com.poc.jersey.rest");

		/* Enable Tracing support. */
		property(ServerProperties.TRACING, "ALL");
	}
	
}
