package com.mongo.healthcare.poc.service;



/**
 * ClinicalDataService class used to implement and expose service end points and 
 * handle CRUD operations for <b>Clinical Data </b> with in the enterprise application.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 12:41:56 November 15, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
public interface ClinicalDataService {
	
	/**
	 * Method to search members by condition name.
	 * 
	 * @param conditionName
	 * @return {@link String}
	 * @throws Exception
	 */
	public String searchMembersByConditionName(String conditionName)
			throws Exception;

	
	/**
	 * Method to search members by condition code.
	 * 
	 * @param conditionCode
	 * @return {@link String}
	 * @throws Exception
	 */
	public String searchMembersByConditionCode(String conditionCode)
			throws Exception;
	
	
	/**
	 * Method to search members by medication.
	 * 
	 * @param medication
	 * @return {@link String}
	 * @throws Exception
	 */
	public String searchMembersByMedication(String medication)
			throws Exception;
	
	
	/**
	 * Method to search members by allergies.
	 * 
	 * @param allergySubstance
	 * @param hciProvider
	 * @return {@link String}
	 * @throws Exception
	 */
	public String searchMembersByAllergies(String allergySubstance,
			String hciProvider) throws Exception;
	
}
