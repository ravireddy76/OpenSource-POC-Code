package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Allergy {

    @JsonProperty("type")
    private String type;
    @JsonProperty("substance")
    private String substance;
    @JsonProperty("reaction")
    private String reaction;
    @JsonProperty("status")
    private String status;
    @JsonProperty("infoSource")
    private String infoSource;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Allergy withType(String type) {
        this.type = type;
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

    public Allergy withSubstance(String substance) {
        this.substance = substance;
        return this;
    }

    @JsonProperty("reaction")
    public String getReaction() {
        return reaction;
    }

    @JsonProperty("reaction")
    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Allergy withReaction(String reaction) {
        this.reaction = reaction;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Allergy withStatus(String status) {
        this.status = status;
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

    public Allergy withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
