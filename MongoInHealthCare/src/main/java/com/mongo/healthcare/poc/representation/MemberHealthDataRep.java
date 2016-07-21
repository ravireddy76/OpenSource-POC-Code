package com.mongo.healthcare.poc.representation;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MemberHealthDataRep implements Serializable {
	private static final long serialVersionUID = 5024977858305562422L;
	
	private String memberId;
	private String memberName;
	private String vitalSignsCount;
	private String allergiesCount;
	private String immunizationsCount;
	private String planOfCaresCount;
	private String medicationsCount;
	private String proceduresCount;
	private String diagnosticResultsCount;
	private String conditionsCount;
	private String memberAddress;
	private String dateOfBirth;
	private String gender;
	private String maritalStatus;
	private String race;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getVitalSignsCount() {
		return vitalSignsCount;
	}
	public void setVitalSignsCount(String vitalSignsCount) {
		this.vitalSignsCount = vitalSignsCount;
	}
	public String getAllergiesCount() {
		return allergiesCount;
	}
	public void setAllergiesCount(String allergiesCount) {
		this.allergiesCount = allergiesCount;
	}
	public String getImmunizationsCount() {
		return immunizationsCount;
	}
	public void setImmunizationsCount(String immunizationsCount) {
		this.immunizationsCount = immunizationsCount;
	}
	public String getPlanOfCaresCount() {
		return planOfCaresCount;
	}
	public void setPlanOfCaresCount(String planOfCaresCount) {
		this.planOfCaresCount = planOfCaresCount;
	}
	public String getMedicationsCount() {
		return medicationsCount;
	}
	public void setMedicationsCount(String medicationsCount) {
		this.medicationsCount = medicationsCount;
	}
	public String getProceduresCount() {
		return proceduresCount;
	}
	public void setProceduresCount(String proceduresCount) {
		this.proceduresCount = proceduresCount;
	}
	public String getDiagnosticResultsCount() {
		return diagnosticResultsCount;
	}
	public void setDiagnosticResultsCount(String diagnosticResultsCount) {
		this.diagnosticResultsCount = diagnosticResultsCount;
	}
	public String getConditionsCount() {
		return conditionsCount;
	}
	public void setConditionsCount(String conditionsCount) {
		this.conditionsCount = conditionsCount;
	}	
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
