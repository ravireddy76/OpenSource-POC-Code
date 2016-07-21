package com.mongo.healthcare.poc.utils;

import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class StringReadConverter implements Converter<DBObject, String> {
	
	public String convert(DBObject source) {
		return JSON.serialize(source);
	}
}
