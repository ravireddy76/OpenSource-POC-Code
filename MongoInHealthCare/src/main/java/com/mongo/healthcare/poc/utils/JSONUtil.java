package com.mongo.healthcare.poc.utils;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSONUtil class used to handle serialize and de-serialize the JSON.
 * 
 * @author ravi reddy [{@link MailTo ravireddy76@gmail.comc}]
 * @Date-Time 17:12:18 October 14, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
public class JSONUtil {
	private static final Logger log = LoggerFactory.getLogger(JSONUtil.class);

	
	/**
	 * Serializes an object to a JSON string
	 * 
	 * @param object
	 *            The object to be serialized
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static <T> String serializeJson(T object)
			throws JsonGenerationException, JsonMappingException, IOException {
		String returnString = "";

		if (object != null) {
			if (log.isDebugEnabled()) {
				log.debug("Serializing an instance of: "
						+ object.getClass().getName() + " to JSON");
			}

			returnString = new ObjectMapper().writeValueAsString(object);

			if (log.isDebugEnabled()) {
				log.debug("Successfully serialized class to:  " + returnString);
			}
		}
		return returnString;
	}

	
	/**
	 * Deserializes the json string to the object type specified in clazz
	 * 
	 * @param clazz
	 * @param json
	 * @return
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 */
	public static <T> T deserializeJson(Class<T> clazz, String json)
			throws IOException, JsonParseException, JsonMappingException {
		T deSerializedValue = null;

		if (StringUtils.isNotBlank(json)) {
			deSerializedValue = (T) new ObjectMapper().readValue(json, clazz);
		}
		return deSerializedValue;
	}
	
}
