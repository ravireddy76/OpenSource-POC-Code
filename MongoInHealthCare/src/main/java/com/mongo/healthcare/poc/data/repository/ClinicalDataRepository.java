package com.mongo.healthcare.poc.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.mongo.healthcare.poc.domain.Member;


/**
 * ClinicalDataRepository class used to handle CRUD operations and database queries
 * with in the enterprise application.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 12:41:56 November 15, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
@Repository
public interface ClinicalDataRepository extends
		MongoRepository<Member, String>, ClinicalDataRepositoryCustom {

	@Query(value="{'conditions.conditionName' : ?0 }")	
	public List<Member> findMembersByConditionName(String conditionName);
	
	@Query(value="{'conditions.conditionCode' : ?0 }")	
	public List<Member> findMembersByConditionCode(Integer conditionCode);
	
	@Query(value="{'medications.brandName' : ?0 }")	
	public List<Member> findMembersByMedication(String medicationBrandName);
	
	/*@Query(value="{'$and':[{'allergies.substance' : ?0}, {'patientInsuranceProvider.insuranceProvider' : ?0}] }")	
	public List<Member> findMembersByAllergies(String allergySubstance, String insuranceProvider);*/

}
