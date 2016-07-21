package com.mongo.healthcare.poc.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.mongo.healthcare.poc.domain.Member;
import com.mongo.healthcare.poc.representation.KeyValue;
import com.mongo.healthcare.poc.representation.MedicationRep;
import com.mongo.healthcare.poc.representation.MemberHealthDataRep;

/**
 * DataMappingUtil class is util class to translate service data to response data for JQuery component
 * @author a6000430
 *
 */
public class DataMappingUtil implements Serializable {
	private static final long serialVersionUID = -4883549467969955175L;
	
	
	/**
	 * Method to map from Member to MemberHealthDataRep.
	 * 
	 * @param membersList
	 * @return List
	 */
	public static List<MemberHealthDataRep> memberToMemberHealthDataRep(List<Member> membersList){
		List<MemberHealthDataRep> memberHealthDataRepLsit = new ArrayList<MemberHealthDataRep>();
		
		/* Build the member health data representation.*/
		for (Member member :  membersList) {
			MemberHealthDataRep memberHealthDataRep =  new MemberHealthDataRep();
			memberHealthDataRep.setMemberId(member.getPersonId());
			memberHealthDataRep.setMemberName(member.getFirstName()+","+member.getLastName());
			memberHealthDataRep.setAllergiesCount(String.valueOf(member.getAllergies().size()));
			memberHealthDataRep.setConditionsCount(String.valueOf(member.getConditions().size()));
			memberHealthDataRep.setDiagnosticResultsCount(String.valueOf(member.getDiagnosticResults().size()));
			memberHealthDataRep.setImmunizationsCount(String.valueOf(member.getImmunizations().size()));
			memberHealthDataRep.setMedicationsCount(String.valueOf(member.getMedications().size()));	
			memberHealthDataRep.setPlanOfCaresCount(String.valueOf(member.getPlanOfCares().size()));
			memberHealthDataRep.setProceduresCount(String.valueOf(member.getProcedures().size()));
			memberHealthDataRep.setVitalSignsCount(String.valueOf(member.getVitalSigns().size()));
			memberHealthDataRep.setMemberAddress(member.getPersonalAddress());
			memberHealthDataRep.setDateOfBirth(member.getDateOfBirth());
			memberHealthDataRep.setGender(member.getGender());
			memberHealthDataRep.setMaritalStatus(member.getMaritalStatus());
			memberHealthDataRepLsit.add(memberHealthDataRep);
		}
		
		return memberHealthDataRepLsit;
	}
	
	
	
	/**
	 * Method to build the medication usage statistics data.
	 * 
	 * @param membersList
	 * @return {@link MedicationRep}
	 */
	public static MedicationRep buildMedicationUsageStatics(List<Member> membersList){
		MedicationRep medicationRep = new MedicationRep();
		int femaleCount = 0;int maleCount = 0;int divorcedCount = 0;int singleCount = 0;
		int marriedCount = 0;
		
		/* Read the searched members list to medication status data.*/
		for (Member member : membersList) {
			if(member.getAdminGender().equalsIgnoreCase("female")){
				femaleCount = femaleCount+1;
			}else if(member.getAdminGender().equalsIgnoreCase("male")){
				maleCount = maleCount+1;
			}
			
			/* Get the martial status of the member.*/
			if(member.getMaritalStatus().equalsIgnoreCase("divorced")){
				divorcedCount = divorcedCount+1;
			}else if(member.getMaritalStatus().equalsIgnoreCase("single")){
				singleCount = singleCount+1;
			}else if(member.getMaritalStatus().equalsIgnoreCase("married")){
				marriedCount = marriedCount+1;
			}
		}
		
		/* Build the map to align the data for UI component to display.*/
		Map<String,String> medicationStaticsMap = new HashMap<String,String>();
		medicationStaticsMap.put("female", String.valueOf(femaleCount));
		medicationStaticsMap.put("male", String.valueOf(maleCount));
		medicationStaticsMap.put("divorced", String.valueOf(divorcedCount));
		medicationStaticsMap.put("single", String.valueOf(singleCount));
		medicationStaticsMap.put("married", String.valueOf(marriedCount));
		
		List<KeyValue> medicationStatisticsData = medicationStatsList(medicationStaticsMap);
		medicationRep.setMedicationStatics(medicationStatisticsData);
		medicationRep.setTotalMembers(String.valueOf(membersList.size()));
		return medicationRep;
	}
	
	
	/**
	 * Method to build the key value information.
	 * 
	 * @param key
	 * @param value
	 * @return {@link KeyValue}
	 */
	public static KeyValue buildKeyValue(String key, String value){
		KeyValue keyValue = new KeyValue();
		keyValue.setKey(key);
		keyValue.setValue(value);
		return keyValue;
	}
	
	/**
	 * Method to build medication statistics data list.
	 * @param medicationMap
	 * @return List
	 */
	@SuppressWarnings({ "rawtypes" })
	private static List<KeyValue> medicationStatsList(Map<String,String> medicationMap){
		List<KeyValue> medicationKeyValueData = new ArrayList<KeyValue>();
		Iterator iter = medicationMap.entrySet().iterator();
		 
		while (iter.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iter.next();
			KeyValue medicationStatsData = buildKeyValue(mapEntry.getKey().toString(),mapEntry.getValue().toString());
			medicationKeyValueData.add(medicationStatsData);
		}
		
		return medicationKeyValueData;
	}
	
}
