package com.mongo.healthcare.poc.hub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LookupController class used to handles request/response lookup
 * values used in drop down boxes, check boxes, radio buttons etc.
 * 
 * @author Lucky
 * @Date-Time 13:30:15 March 15, 2013 CST
 * @CopyRight (C) All rights reserved to Partnera. It's Illegal to reproduce this code.
 */

@Controller
@RequestMapping("/lookup")
public class LookupController {
	private static final Logger logger = LoggerFactory.getLogger(LookupController.class);
	
	@RequestMapping(value = "/healthPlan", method = RequestMethod.GET)
	public @ResponseBody String getHealthPaln(Model model) {
		logger.debug("Received request for health plan");
		String serviceResponse;

		try {
			serviceResponse = buildHealthPlanJson();
		} catch (Exception e) {
			logger.error(e.getMessage());
			serviceResponse = e.getMessage();
		}

		return serviceResponse;
	}
	
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public @ResponseBody String getState(Model model) {
		logger.debug("Received request for states");
		String serviceResponse;

		try {
			serviceResponse = buildStatesJson();
		} catch (Exception e) {
			logger.error(e.getMessage());
			serviceResponse = e.getMessage();
		}

		return serviceResponse;
	}
	
	@RequestMapping(value = "/gender", method = RequestMethod.GET)
	public @ResponseBody String getGender(Model model) {
		logger.debug("Received request for gender");
		String serviceResponse;

		try {
			serviceResponse = buildGenderJson();
		} catch (Exception e) {
			logger.error(e.getMessage());
			serviceResponse = e.getMessage();
		}

		return serviceResponse;
	}
	
	/**
	 * Method to build the Health Plan json data for drop down
	 * @return
	 */
	private String buildHealthPlanJson(){
		String healthPlanJson = null;
		healthPlanJson = "[{\"id\":1,\"name\":\"Horizon Direct\"},{"+
				"\"id\":2,\"name\":\"Horizon PPO\"},{"+
				"\"id\":3,\"name\":\"Horizon MyWay\"}]";
		return healthPlanJson;
	}
	
	/**
	 * Method to build the Gender json data for drop down
	 * @return
	 */
	private String buildGenderJson(){
		String genderJson = null;
		genderJson = "[{\"id\":0,\"name\":\"Gender\"},{"+
				"\"id\":\"M\",\"name\":\"Male\"},{"+
				"\"id\":\"F\",\"name\":\"Female\"}]";
		return genderJson;
	}
	
	/**
	 * Method to build the Health Plan json data for drop down
	 * @return
	 */
	private String buildStatesJson(){
		String stateJson = null;
		stateJson = "[{\"id\":0,\"name\":\"State\"},{"+
				"\"id\":\"AL\",\"name\":\"Alabama\"},{" +
				"\"id\":\"AK\",\"name\":\"Alaska\"},{" +
				"\"id\":\"AZ\",\"name\":\"Arizona\"},{" +
				"\"id\":\"AR\",\"name\":\"Arkansas\"},{" +
				"\"id\":\"CA\",\"name\":\"California\"},{" +
				"\"id\":\"CO\",\"name\":\"Colorado\"},{" +
				"\"id\":\"CT\",\"name\":\"Connecticut\"},{" +
				"\"id\":\"DE\",\"name\":\"Delaware\"},{" +
				"\"id\":\"DC\",\"name\":\"District Of Columbia\"},{" +
				"\"id\":\"FL\",\"name\":\"Florida\"},{" +
				"\"id\":\"GA\",\"name\":\"Georgia\"},{" +
				"\"id\":\"HI\",\"name\":\"Hawaii\"},{" +
				"\"id\":\"ID\",\"name\":\"Idaho\"},{" +
				"\"id\":\"IL\",\"name\":\"Illinois\"},{" +
				"\"id\":\"IN\",\"name\":\"Indiana\"},{" +
				"\"id\":\"IA\",\"name\":\"Iowa\"},{" +
				"\"id\":\"KS\",\"name\":\"Kansas\"},{" +
				"\"id\":\"KY\",\"name\":\"Kentucky\"},{" +
				"\"id\":\"LA\",\"name\":\"Louisiana\"},{" +
				"\"id\":\"ME\",\"name\":\"Maine\"},{" +
				"\"id\":\"MD\",\"name\":\"Maryland\"},{" +
				"\"id\":\"MA\",\"name\":\"Massachusetts\"},{" +
				"\"id\":\"MI\",\"name\":\"Michigan\"},{" +
				"\"id\":\"MN\",\"name\":\"Minnesota\"},{" +
				"\"id\":\"MS\",\"name\":\"Mississippi\"},{" +
				"\"id\":\"MO\",\"name\":\"Missouri\"},{" +
				"\"id\":\"MT\",\"name\":\"Montana\"},{" +
				"\"id\":\"NE\",\"name\":\"Nebraska\"},{" +
				"\"id\":\"NV\",\"name\":\"Nevada\"},{" +
				"\"id\":\"NH\",\"name\":\"New Hampshire\"},{" +
				"\"id\":\"NJ\",\"name\":\"New Jersey\"},{" +
				"\"id\":\"NM\",\"name\":\"New Mexico\"},{" +
				"\"id\":\"NY\",\"name\":\"New York\"},{" +
				"\"id\":\"NC\",\"name\":\"North Carolina\"},{" +
				"\"id\":\"ND\",\"name\":\"North Dakota\"},{" +
				"\"id\":\"OH\",\"name\":\"Ohio\"},{" +
				"\"id\":\"OK\",\"name\":\"Oklahoma\"},{" +
				"\"id\":\"OR\",\"name\":\"Oregon\"},{" +
				"\"id\":\"PA\",\"name\":\"Pennsylvania\"},{" +
				"\"id\":\"RI\",\"name\":\"Rhode Island\"},{" +
				"\"id\":\"SC\",\"name\":\"South Carolina\"},{" +
				"\"id\":\"SD\",\"name\":\"South Dakota\"},{" +
				"\"id\":\"TN\",\"name\":\"Tennessee\"},{" +
				"\"id\":\"TX\",\"name\":\"Texas\"},{" +
				"\"id\":\"UT\",\"name\":\"Utah\"},{" +
				"\"id\":\"VT\",\"name\":\"Vermont\"},{" +
				"\"id\":\"VA\",\"name\":\"Virginia\"},{" +
				"\"id\":\"WA\",\"name\":\"Washington\"},{" +
				"\"id\":\"WV\",\"name\":\"West Virginia\"},{" +
				"\"id\":\"WI\",\"name\":\"Wisconsin\"},{" +
				"\"id\":\"WY\",\"name\":\"Wyoming\"}]";
		return stateJson;
	}

}