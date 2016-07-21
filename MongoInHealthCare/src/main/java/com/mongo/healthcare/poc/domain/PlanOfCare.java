package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class PlanOfCare {

    @JsonProperty("plannedActivity")
    private String plannedActivity;
    @JsonProperty("plannedEffectiveDate")
    private String plannedEffectiveDate;
    @JsonProperty("infoSource")
    private String infoSource;
 
    @JsonProperty("plannedActivity")
    public String getPlannedActivity() {
        return plannedActivity;
    }

    @JsonProperty("plannedActivity")
    public void setPlannedActivity(String plannedActivity) {
        this.plannedActivity = plannedActivity;
    }

    public PlanOfCare withPlannedActivity(String plannedActivity) {
        this.plannedActivity = plannedActivity;
        return this;
    }

    @JsonProperty("plannedEffectiveDate")
    public String getPlannedEffectiveDate() {
        return plannedEffectiveDate;
    }

    @JsonProperty("plannedEffectiveDate")
    public void setPlannedEffectiveDate(String plannedEffectiveDate) {
        this.plannedEffectiveDate = plannedEffectiveDate;
    }

    public PlanOfCare withPlannedEffectiveDate(String plannedEffectiveDate) {
        this.plannedEffectiveDate = plannedEffectiveDate;
        return this;
    }

    @JsonProperty("infoSource")
    public String getInfoSource() {
        return infoSource;
    }

    @JsonProperty("infoSource")
    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public PlanOfCare withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
