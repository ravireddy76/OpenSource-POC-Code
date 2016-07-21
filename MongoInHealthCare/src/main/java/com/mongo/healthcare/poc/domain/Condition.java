package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Condition {

    @JsonProperty("conditionOccuredDate")
    private String conditionOccuredDate;
    @JsonProperty("conditionName")
    private String conditionName;
    @JsonProperty("conditionCode")
    private Integer conditionCode;
    @JsonProperty("infoSource")
    private String infoSource;
 
    @JsonProperty("conditionOccuredDate")
    public String getConditionOccuredDate() {
        return conditionOccuredDate;
    }

    @JsonProperty("conditionOccuredDate")
    public void setConditionOccuredDate(String conditionOccuredDate) {
        this.conditionOccuredDate = conditionOccuredDate;
    }

    public Condition withConditionOccuredDate(String conditionOccuredDate) {
        this.conditionOccuredDate = conditionOccuredDate;
        return this;
    }

    @JsonProperty("conditionName")
    public String getConditionName() {
        return conditionName;
    }

    @JsonProperty("conditionName")
    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public Condition withConditionName(String conditionName) {
        this.conditionName = conditionName;
        return this;
    }

    @JsonProperty("conditionCode")
    public Integer getConditionCode() {
        return conditionCode;
    }

    @JsonProperty("conditionCode")
    public void setConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
    }

    public Condition withConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
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

    public Condition withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
