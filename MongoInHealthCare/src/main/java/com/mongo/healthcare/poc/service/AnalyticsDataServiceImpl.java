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
import com.mongo.healthcare.poc.representation.MemberHealthDataRep;
import com.mongo.healthcare.poc.utils.DataMappingUtil;
import com.mongo.healthcare.poc.utils.JSONUtil;

/**
 * AnalyticsDataServiceImpl class used to implement and expose service end points to
 * handle analytics data for <b>Clinical Data </b> with in the enterprise application.
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 11:41:56 June 10, 2014 CST
 * @CopyRight (C) All rights reserved to Ravi POC World. It's Illegal to reproduce this code.
 */
@Component
@Path("/analyticsdata")
public class AnalyticsDataServiceImpl implements AnalyticsDataService {

	/* Property for inject the dao repository.*/
	@Resource
	protected ClinicalDataRepository clinicalDataRepository;
	
	
	@GET
	@Path("/searchConditionCode")
	@Produces("application/json")
	public String membersConditionAnalyticsData(
			@QueryParam("conditionCode") String conditionCode) throws Exception {

		Integer condCode = Integer.parseInt(conditionCode);
		List<Member> membersList = clinicalDataRepository
				.findMembersByConditionCode(condCode);
		
		/* Translate member health data representation.*/
		List<MemberHealthDataRep> memberHealthDataList = DataMappingUtil.memberToMemberHealthDataRep(membersList);
		String response = JSONUtil.serializeJson(memberHealthDataList);
		return response;
	}
	
	
	/**
	 * Method to search members by medication usage analytics data.
	 * 
	 * @param medicationCode
	 * @return String
	 * @throws Exception
	 */
	@GET
	@Path("/searchByMedication")
	@Produces("application/json")
	public String membersMedicationAnalyticsData(@QueryParam("medicationName") String medicationName)
			throws Exception{
		List<Member> membersList = clinicalDataRepository.findMembersByMedication(medicationName);		
		List<MemberHealthDataRep> memberHealthDataList = DataMappingUtil.memberToMemberHealthDataRep(membersList);
		//MedicationRep medicationRep = DataMappingUtil.buildMedicationUsageStatics(membersList);
		String response = JSONUtil.serializeJson(memberHealthDataList);
		return response;

	}

}
