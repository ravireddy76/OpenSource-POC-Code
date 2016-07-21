package com.mongo.healthcare.poc.representation;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MedicationRep implements Serializable {
	private static final long serialVersionUID = -2932742754913402175L;

	private String totalMembers;
	private List<KeyValue> medicationStatics;

	/* Default constructor. */
	public MedicationRep() {

	}

	public String getTotalMembers() {
		return totalMembers;
	}

	public void setTotalMembers(String totalMembers) {
		this.totalMembers = totalMembers;
	}

	public List<KeyValue> getMedicationStatics() {
		return medicationStatics;
	}

	public void setMedicationStatics(List<KeyValue> medicationStatics) {
		this.medicationStatics = medicationStatics;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
