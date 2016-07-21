package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class DiagnosticResult {

    @JsonProperty("status")
    private String status;
    @JsonProperty("diagnosticValue")
    private Integer diagnosticValue;
    @JsonProperty("interpretationCode")
    private String interpretationCode;
    @JsonProperty("referenceRange")
    private String referenceRange;
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

    public DiagnosticResult withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("diagnosticValue")
    public Integer getDiagnosticValue() {
        return diagnosticValue;
    }

    @JsonProperty("diagnosticValue")
    public void setDiagnosticValue(Integer diagnosticValue) {
        this.diagnosticValue = diagnosticValue;
    }

    public DiagnosticResult withDiagnosticValue(Integer diagnosticValue) {
        this.diagnosticValue = diagnosticValue;
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

    public DiagnosticResult withInterpretationCode(String interpretationCode) {
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

    public DiagnosticResult withReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
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

    public DiagnosticResult withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
