package com.mongo.healthcare.poc.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongo.healthcare.poc.domain.Member;


/**
 * ClinicalDataRepositoryCustomImpl class used as a custom repository implementation 
 * for given collection in order to filter or search data precisely by using
 * complex custom queries on MongoDB collections.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 12:41:56 November 15, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
public class ClinicalDataRepositoryCustomImpl implements
		ClinicalDataRepositoryCustom {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	
	/**
	 * Method to filter the all members data by allergy substance and health
	 * care insurance provider.
	 * 
	 * @param allergySubstance
	 * @param insuranceProvider
	 * @return {@link List<Member>}
	 */
	public List<Member> findMembersByAllergies(String allergySubstance,
			String insuranceProvider) {		
		
		/* Build the search query with criteria conditions.*/
		Query searchQuery = new Query(Criteria.where("allergies.substance")
				.is(allergySubstance).andOperator(Criteria.where("patientInsuranceProvider.insuranceProvider").is(insuranceProvider)));

		List<Member> searchedMemberList = mongoTemplate.find(searchQuery,Member.class);
		return searchedMemberList;
	}
	
}
