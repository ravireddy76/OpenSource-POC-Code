package com.poc.rest.springboot.domain;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Customer domain object is used to store/retrieve customer information.
 * 
 * @author RaviReddy
 * @Date-Time 09:28:18 June 10, 2016 CST
 * @CopyRight (C) All rights reserved to RaviReddy POC World. It's Illegal to reproduce this code.
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = -6633442539754014842L;
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String address;
	private String zipCode;
	private String contactNumber;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     *
     * @return a <code>String</code> representation of this object.
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
