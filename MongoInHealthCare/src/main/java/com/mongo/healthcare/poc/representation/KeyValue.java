package com.mongo.healthcare.poc.representation;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * KeyValue is used as a to store key value information.
 * 
 * @author Ravi Reddy
 * @Date-Time 21:10:35 May 19, 2014 CST
 * @CopyRight (C) All rights reserved to Ravi POC World Inc. It's Illegal to reproduce this code.
 */
public class KeyValue implements Serializable {
	private static final long serialVersionUID = 8077175324714172832L;
	
	private String key;
	private String value;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
