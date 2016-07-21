package com.mongo.healthcare.poc.hub.utils;

import org.springframework.http.HttpStatus;

/**
 * ControllerResponse class used to get the service response information with in
 * the enterprise application.
 * 
 * @author rreddy [{@link MailTo rreddy@htconsultancy.us}]
 * @Date-Time 11:35:17 December 08, 2013 CST
 * @CopyRight (C) All rights reserved to Partnera. It's Illegal to reproduce this code.
 */
public class ControllerResponse {

	/* Property for service response value. */
	String responseText;

	/* Property for http status code. */
	HttpStatus statusCode;

	/* Property to track the service status. */
	Boolean status = true;

	
	/** Default constructor **/
	public ControllerResponse() {
		
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

		
	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";
		String retValue = "";
		retValue = "ControllerResponse ( " + super.toString() + TAB
				+ "responseText = " + this.responseText + TAB + "statusCode = "
				+ this.statusCode + TAB + "status = " + this.status + TAB
				+ " )";
		return retValue;
	}

}
