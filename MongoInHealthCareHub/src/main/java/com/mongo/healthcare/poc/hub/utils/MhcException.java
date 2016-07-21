package com.mongo.healthcare.poc.hub.utils;


/**
 * PacnException class is used to handle exceptions occurred with in the enterprise application.
 * 
 * @author rreddy [{@link MailTo rreddy@htconsultancy.us}]
 * @Date-Time 11:35:17 December 08, 2013 CST
 * @CopyRight (C) All rights reserved to Partnera. It's Illegal to reproduce this code.
 */
public class MhcException extends Exception{

	
	private static final long serialVersionUID = 2224470283281237001L;
	private String pacnExceptionMessage = "";
	
    public MhcException() {
	    super();
    }

    public MhcException(String message) {
	    this.pacnExceptionMessage =  message;
    }		
	
	public String getPacnExceptionMessage() {
		return pacnExceptionMessage;
	}

	public void setPacnExceptionMessage(String pacnExceptionMessage) {
		this.pacnExceptionMessage = pacnExceptionMessage;
	}

	@Override
	public String getMessage() {
		return this.pacnExceptionMessage;
	}
	
}
