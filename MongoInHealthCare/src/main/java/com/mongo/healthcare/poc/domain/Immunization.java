package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Immunization {

    @JsonProperty("statusCode")
    private String statusCode;
    @JsonProperty("effectiveTime")
    private String effectiveTime;
    @JsonProperty("routeCode")
    private String routeCode;
    @JsonProperty("doseQuantity")
    private Integer doseQuantity;
    @JsonProperty("substance")
    private String substance;
    @JsonProperty("infoSource")
    private String infoSource;
 
    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Immunization withStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public Immunization withEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
        return this;
    }

    @JsonProperty("routeCode")
    public String getRouteCode() {
        return routeCode;
    }

    @JsonProperty("routeCode")
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public Immunization withRouteCode(String routeCode) {
        this.routeCode = routeCode;
        return this;
    }

    @JsonProperty("doseQuantity")
    public Integer getDoseQuantity() {
        return doseQuantity;
    }

    @JsonProperty("doseQuantity")
    public void setDoseQuantity(Integer doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public Immunization withDoseQuantity(Integer doseQuantity) {
        this.doseQuantity = doseQuantity;
        return this;
    }

    @JsonProperty("substance")
    public String getSubstance() {
        return substance;
    }

    @JsonProperty("substance")
    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public Immunization withSubstance(String substance) {
        this.substance = substance;
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

    public Immunization withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
