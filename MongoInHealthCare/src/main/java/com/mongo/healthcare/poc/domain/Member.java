package com.mongo.healthcare.poc.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "clinicaldata")
@JsonIgnoreProperties(ignoreUnknown = false)
public class Member {

	@Id
	@JsonProperty("_id")
	private String id;
	@JsonProperty("personId")
	private String personId;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	@JsonProperty("adminGender")
	private String adminGender;
	@JsonProperty("maritalStatus")
	private String maritalStatus;
	@JsonProperty("religiousAffiliation")
	private String religiousAffiliation;
	@JsonProperty("race")
	private String race;
	@JsonProperty("ethnicity")
	private String ethnicity;
	@JsonProperty("personalAddress")
	private String personalAddress;
	@JsonProperty("telephone")
	private String telephone;
	@JsonProperty("vitalSigns")
	private List<VitalSign> vitalSigns = new ArrayList<VitalSign>();
	@JsonProperty("allergies")
	private List<Allergy> allergies = new ArrayList<Allergy>();
	@JsonProperty("immunizations")
	private List<Immunization> immunizations = new ArrayList<Immunization>();
	@JsonProperty("planOfCares")
	private List<PlanOfCare> planOfCares = new ArrayList<PlanOfCare>();
	@JsonProperty("medications")
	private List<Medication> medications = new ArrayList<Medication>();
	@JsonProperty("procedures")
	private List<Procedure> procedures = new ArrayList<Procedure>();
	@JsonProperty("diagnosticResults")
	private List<DiagnosticResult> diagnosticResults = new ArrayList<DiagnosticResult>();
	@JsonProperty("conditions")
	private List<Condition> conditions = new ArrayList<Condition>();
	@JsonProperty("patientHealthCareProviders")
	private List<PatientHealthCareProvider> patientHealthCareProviders = new ArrayList<PatientHealthCareProvider>();
	@JsonProperty("patientInsuranceProvider")
	private List<PatientInsuranceProvider> patientInsuranceProvider = new ArrayList<PatientInsuranceProvider>();

	@JsonProperty("_id")
	public String getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("personId")
	public String getPersonId() {
		return personId;
	}

	@JsonProperty("personId")
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Member withPersonId(String personId) {
		this.personId = personId;
		return this;
	}

	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Member withGender(String gender) {
		this.gender = gender;
		return this;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Member withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Member withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@JsonProperty("dateOfBirth")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("dateOfBirth")
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Member withDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	@JsonProperty("adminGender")
	public String getAdminGender() {
		return adminGender;
	}

	@JsonProperty("adminGender")
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public Member withAdminGender(String adminGender) {
		this.adminGender = adminGender;
		return this;
	}

	@JsonProperty("maritalStatus")
	public String getMaritalStatus() {
		return maritalStatus;
	}

	@JsonProperty("maritalStatus")
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Member withMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
		return this;
	}

	@JsonProperty("religiousAffiliation")
	public String getReligiousAffiliation() {
		return religiousAffiliation;
	}

	@JsonProperty("religiousAffiliation")
	public void setReligiousAffiliation(String religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

	public Member withReligiousAffiliation(String religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
		return this;
	}

	@JsonProperty("race")
	public String getRace() {
		return race;
	}

	@JsonProperty("race")
	public void setRace(String race) {
		this.race = race;
	}

	public Member withRace(String race) {
		this.race = race;
		return this;
	}

	@JsonProperty("ethnicity")
	public String getEthnicity() {
		return ethnicity;
	}

	@JsonProperty("ethnicity")
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Member withEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
		return this;
	}

	@JsonProperty("personalAddress")
	public String getPersonalAddress() {
		return personalAddress;
	}

	@JsonProperty("personalAddress")
	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	public Member withPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
		return this;
	}

	@JsonProperty("telephone")
	public String getTelephone() {
		return telephone;
	}

	@JsonProperty("telephone")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Member withTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	@JsonProperty("vitalSigns")
	public List<VitalSign> getVitalSigns() {
		return vitalSigns;
	}

	@JsonProperty("vitalSigns")
	public void setVitalSigns(List<VitalSign> vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public Member withVitalSigns(List<VitalSign> vitalSigns) {
		this.vitalSigns = vitalSigns;
		return this;
	}

	@JsonProperty("allergies")
	public List<Allergy> getAllergies() {
		return allergies;
	}

	@JsonProperty("allergies")
	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public Member withAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
		return this;
	}

	@JsonProperty("immunizations")
	public List<Immunization> getImmunizations() {
		return immunizations;
	}

	@JsonProperty("immunizations")
	public void setImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}

	public Member withImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
		return this;
	}

	@JsonProperty("planOfCares")
	public List<PlanOfCare> getPlanOfCares() {
		return planOfCares;
	}

	@JsonProperty("planOfCares")
	public void setPlanOfCares(List<PlanOfCare> planOfCares) {
		this.planOfCares = planOfCares;
	}

	public Member withPlanOfCares(List<PlanOfCare> planOfCares) {
		this.planOfCares = planOfCares;
		return this;
	}

	@JsonProperty("medications")
	public List<Medication> getMedications() {
		return medications;
	}

	@JsonProperty("medications")
	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

	public Member withMedications(List<Medication> medications) {
		this.medications = medications;
		return this;
	}

	@JsonProperty("procedures")
	public List<Procedure> getProcedures() {
		return procedures;
	}

	@JsonProperty("procedures")
	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

	public Member withProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
		return this;
	}

	@JsonProperty("diagnosticResults")
	public List<DiagnosticResult> getDiagnosticResults() {
		return diagnosticResults;
	}

	@JsonProperty("diagnosticResults")
	public void setDiagnosticResults(List<DiagnosticResult> diagnosticResults) {
		this.diagnosticResults = diagnosticResults;
	}

	public Member withDiagnosticResults(List<DiagnosticResult> diagnosticResults) {
		this.diagnosticResults = diagnosticResults;
		return this;
	}

	@JsonProperty("conditions")
	public List<Condition> getConditions() {
		return conditions;
	}

	@JsonProperty("conditions")
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Member withConditions(List<Condition> conditions) {
		this.conditions = conditions;
		return this;
	}

	@JsonProperty("patientHealthCareProviders")
	public List<PatientHealthCareProvider> getPatientHealthCareProviders() {
		return patientHealthCareProviders;
	}

	@JsonProperty("patientHealthCareProviders")
	public void setPatientHealthCareProviders(
			List<PatientHealthCareProvider> patientHealthCareProviders) {
		this.patientHealthCareProviders = patientHealthCareProviders;
	}

	public Member withPatientHealthCareProviders(
			List<PatientHealthCareProvider> patientHealthCareProviders) {
		this.patientHealthCareProviders = patientHealthCareProviders;
		return this;
	}

	@JsonProperty("patientInsuranceProvider")
	public List<PatientInsuranceProvider> getPatientInsuranceProvider() {
		return patientInsuranceProvider;
	}

	@JsonProperty("patientInsuranceProvider")
	public void setPatientInsuranceProvider(
			List<PatientInsuranceProvider> patientInsuranceProvider) {
		this.patientInsuranceProvider = patientInsuranceProvider;
	}

	public Member withPatientInsuranceProvider(
			List<PatientInsuranceProvider> patientInsuranceProvider) {
		this.patientInsuranceProvider = patientInsuranceProvider;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
