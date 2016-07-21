package com.mongo.healthcare.poc.service;


/**
 * AnalyticsDataService interface used to define what kind of data to view on client application
 * for <b>Clinical Data </b> with in the enterprise application.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 11:32:56 June 10, 2014 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
public interface AnalyticsDataService {
	
	/**
	 * Method to search members conditions analytics data based on condition
	 * code.
	 * 
	 * @param conditionCode
	 * @return String
	 * @throws Exception
	 */
	public String membersConditionAnalyticsData(String conditionCode)
			throws Exception;
	
	
	
	/**
	 * Method to search members by medication usage analytics data.
	 * 
	 * @param medicationCode
	 * @return String
	 * @throws Exception
	 */
	public String membersMedicationAnalyticsData(String medicationName)
			throws Exception;

}
