package com.mongo.healthcare.poc.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

import com.mongo.healthcare.poc.data.repository.ClinicalDataRepository;
import com.mongo.healthcare.poc.domain.Member;
import com.mongo.healthcare.poc.representation.MedicationRep;
import com.mongo.healthcare.poc.utils.DataMappingUtil;
import com.mongo.healthcare.poc.utils.JSONUtil;


/**
 * ClinicalDataServiceImpl class used to implement and expose service end points and 
 * handle CRUD operations for <b>Clinical Data </b> with in the enterprise application.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 12:41:56 November 15, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
@Component
@Path("/cdService")
public class ClinicalDataServiceImpl implements ClinicalDataService {

	/* Property for inject the dao repository.*/
	@Resource
	protected ClinicalDataRepository clinicalDataRepository;
	
	
	/**
	 * Method to search members by condition name.
	 * 
	 * @param conditionName
	 * @return {@link String}
	 * @throws Exception
	 */
	@GET
	@Path("/searchConditionName")
	@Produces("application/json")
	public String searchMembersByConditionName(
			@QueryParam("conditionName") String conditionName) throws Exception {
		List<Member> membersList = clinicalDataRepository
				.findMembersByConditionName(conditionName);
		
		String response = JSONUtil.serializeJson(membersList);
		return response;
	}
	
	
	/**
	 * Method to search members by condition code.
	 * 
	 * @param conditionCode
	 * @return {@link String}
	 * @throws Exception
	 */
	@GET
	@Path("/searchConditionCode")
	@Produces("application/json")
	public String searchMembersByConditionCode(
			@QueryParam("conditionCode") String conditionCode) throws Exception {
		Integer condCode = Integer.parseInt(conditionCode);
		List<Member> membersList = clinicalDataRepository
				.findMembersByConditionCode(condCode);

		String response = JSONUtil.serializeJson(membersList);
		return response;
	}
	
	
	/**
	 * Method to search members by medication.
	 * 
	 * @param medication
	 * @return {@link String}
	 * @throws Exception
	 */
	@GET
	@Path("/searchMedication")
	@Produces("application/json")
	public String searchMembersByMedication(
			@QueryParam("medication") String medication) throws Exception {
		List<Member> membersList = clinicalDataRepository.findMembersByMedication(medication);
		String response = JSONUtil.serializeJson(membersList);
		return response;
	}
	
	
	/**
	 * Method to search members by allergies.
	 * 
	 * @param allergySubstance
	 * @param hciProvider
	 * @return {@link String}
	 * @throws Exception
	 */
	@GET
	@Path("/searchAllergies")
	@Produces("application/json")
	public String searchMembersByAllergies(@QueryParam("allergySubstance") String allergySubstance,
			@QueryParam("hciprovider") String hciProvider) throws Exception {
		List<Member> membersList = clinicalDataRepository
				.findMembersByAllergies(allergySubstance, hciProvider);		

		String response = JSONUtil.serializeJson(membersList);
		return response;
	}

}
