package com.mongo.healthcare.poc.data.repository;

import java.util.List;

import com.mongo.healthcare.poc.domain.Member;


/**
 * ClinicalDataRepositoryCustom interface used as a custom repository for
 * given collection in order to filter or search data precisely by using
 * complex custom queries on MongoDB collections.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 12:41:56 November 15, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
public interface ClinicalDataRepositoryCustom {

	/**
	 * Method to filter the all members data by allergy substance and health care
	 * insurance provider.
	 * 
	 * @param allergySubstance
	 * @param insuranceProvider
	 * @return {@link List<Member>}
	 */
	public List<Member> findMembersByAllergies(String allergySubstance,
			String insuranceProvider);
	
}
