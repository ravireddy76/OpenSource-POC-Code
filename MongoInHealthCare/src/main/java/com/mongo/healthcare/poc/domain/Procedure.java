package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Procedure {

    @JsonProperty("entryDateTime")
    private String entryDateTime;
    @JsonProperty("procedureCode")
    private String procedureCode;
    @JsonProperty("procedureDescription")
    private String procedureDescription;
    @JsonProperty("infoSource")
    private String infoSource;
 
    @JsonProperty("entryDateTime")
    public String getEntryDateTime() {
        return entryDateTime;
    }

    @JsonProperty("entryDateTime")
    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Procedure withEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
        return this;
    }

    @JsonProperty("procedureCode")
    public String getProcedureCode() {
        return procedureCode;
    }

    @JsonProperty("procedureCode")
    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public Procedure withProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
        return this;
    }

    @JsonProperty("procedureDescription")
    public String getProcedureDescription() {
        return procedureDescription;
    }

    @JsonProperty("procedureDescription")
    public void setProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
    }

    public Procedure withProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
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

    public Procedure withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
