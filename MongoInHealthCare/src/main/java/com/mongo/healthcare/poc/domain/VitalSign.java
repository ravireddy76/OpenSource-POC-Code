package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class VitalSign {

    @JsonProperty("status")
    private String status;
    @JsonProperty("vitalSignCode")
    private String vitalSignCode;
    @JsonProperty("interpretationCode")
    private String interpretationCode;
    @JsonProperty("referenceRange")
    private String referenceRange;
    @JsonProperty("effectiveTime")
    private String effectiveTime;
    @JsonProperty("infoSource")
    private String infoSource;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public VitalSign withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("vitalSignCode")
    public String getVitalSignCode() {
        return vitalSignCode;
    }

    @JsonProperty("vitalSignCode")
    public void setVitalSignCode(String vitalSignCode) {
        this.vitalSignCode = vitalSignCode;
    }

    public VitalSign withVitalSignCode(String vitalSignCode) {
        this.vitalSignCode = vitalSignCode;
        return this;
    }

    @JsonProperty("interpretationCode")
    public String getInterpretationCode() {
        return interpretationCode;
    }

    @JsonProperty("interpretationCode")
    public void setInterpretationCode(String interpretationCode) {
        this.interpretationCode = interpretationCode;
    }

    public VitalSign withInterpretationCode(String interpretationCode) {
        this.interpretationCode = interpretationCode;
        return this;
    }

    @JsonProperty("referenceRange")
    public String getReferenceRange() {
        return referenceRange;
    }

    @JsonProperty("referenceRange")
    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    public VitalSign withReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
        return this;
    }

    @JsonProperty("effectiveTime")
    public String getEffectiveTime() {
        return effectiveTime;
    }

    @JsonProperty("effectiveTime")
    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public VitalSign withEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
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

    public VitalSign withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
