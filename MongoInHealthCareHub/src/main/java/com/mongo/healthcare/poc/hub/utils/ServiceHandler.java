package com.mongo.healthcare.poc.hub.utils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ServiceHandler class used to get the service response by passing service end
 * points with in the enterprise application.
 * 
 * @author rreddy [{@link MailTo rreddy@htconsultancy.us}]
 * @Date-Time 11:35:17 December 08, 2013 CST
 * @CopyRight (C) All rights reserved to Partnera. It's Illegal to reproduce this code.
 */
@Service("serviceHandler")
@Configurable
public class ServiceHandler {
	private static final Logger logger = LoggerFactory.getLogger(ServiceHandler.class);

	/* Property for server name to pull from *.properties file. */
	private String serverName;

	/* Property for spring rest template. */
	@Resource
	private RestTemplate restTemplate;
	

	/**
	 * Method to get the REST service GET response.
	 * 
	 * @param serviceEndPoint
	 * @return {@link String}
	 * @throws URISyntaxException
	 * @throws UnsupportedEncodingException
	 */
	public String serviceResponse(String serviceEndPoint) {
		String endPoint = buildEndPoint(serviceEndPoint);
		String jsonResponse = restTemplate.getForObject(endPoint, String.class);
		return jsonResponse;
	}

	/**
	 * Method to get the REST service GET response for the given URI.
	 * 
	 * @param serviceEndPoint
	 * @param useUri
	 * @return {@link String}
	 * @throws URISyntaxException
	 */
	public String serviceResponse(String serviceEndPoint, boolean useUri)
			throws URISyntaxException {
		String endPoint = buildEndPoint(serviceEndPoint);
		URI uri = new URI(endPoint);
		String jsonResponse = restTemplate.getForObject(uri, String.class);
		return jsonResponse;
	}

	/**
	 * Method REST service DELETE.
	 * 
	 * @param serviceEndPoint
	 * @throws URISyntaxException
	 */
	public void serviceResponseDelete(String serviceEndPoint) {
		String endPoint = buildEndPoint(serviceEndPoint);
		restTemplate.delete(endPoint);
	}

	/**
	 * Method REST service POST.
	 * 
	 * @param serviceEndPoint
	 * @return {@link void}
	 * @throws URISyntaxException
	 */
	public ResponseEntity<String> serviceResponsePost(String serviceEndPoint,
			String jsonInput, String apiKey) {
		HttpHeaders headers = new HttpHeaders();

		String endPoint = buildEndPoint(serviceEndPoint);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("apiKey", apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInput, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(endPoint,
				entity, String.class);
		return response;
	}


	/**
	 * Method REST service PUT.
	 * 
	 * @param serviceEndPoint
	 * @return {@link void}
	 * @throws URISyntaxException
	 */
	public ResponseEntity<String> serviceResponsePut(String serviceEndPoint, String jsonData, String apiKey) {
		HttpHeaders headers = new HttpHeaders();

		String endPoint = buildEndPoint(serviceEndPoint);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("apiKey", apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		restTemplate.put(endPoint, entity);
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		return response;
	}

	
	/**
	 * Method REST service PUT.
	 * 
	 * @param serviceEndPoint
	 * @return {@link void}
	 * @throws URISyntaxException
	 */
	public void serviceResponsePut(String serviceEndPoint, String jsonData) {
		HttpHeaders headers = new HttpHeaders();

		String endPoint = buildEndPoint(serviceEndPoint);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		restTemplate.put(endPoint, entity);
	}

	
	/**
	 * Method to get response
	 * 
	 * @param serviceEndPoint
	 * @param apiKey
	 * @return Response
	 */
	public ResponseEntity<String> serviceResponse(String serviceEndPoint,
			String apiKey) {
		HttpHeaders headers = new HttpHeaders();
		String endPoint = buildEndPoint(serviceEndPoint);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("apiKey", apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(endPoint,
				HttpMethod.GET, entity, String.class);
		return response;

	}

	/**
	 * Method to set the server name value from *.properties file.
	 * 
	 * @param serverName
	 */
	@Value("#{mhcHubProperties['serverName']}")
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * Method to build the total service end point.
	 * 
	 * @param endPointKey
	 * @return {@link String}
	 */
	public String buildEndPoint(String endPointKey) {
		String serviceEndPoint = ServiceEndPoints.HTTP + this.serverName
				+ endPointKey;
		return serviceEndPoint;
	}

}
