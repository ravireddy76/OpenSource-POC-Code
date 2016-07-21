package com.mongo.healthcare.poc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Medication {

    @JsonProperty("codedProduct")
    private String codedProduct;
    @JsonProperty("lotNumber")
    private Integer lotNumber;
    @JsonProperty("brandName")
    private String brandName;
    @JsonProperty("drugManufacturer")
    private String drugManufacturer;
    @JsonProperty("doseValue")
    private Integer doseValue;
    @JsonProperty("doseLimit")
    private Integer doseLimit;
    @JsonProperty("doseHigh")
    private Integer doseHigh;
    @JsonProperty("doseLow")
    private Integer doseLow;
    @JsonProperty("dispenseDate")
    private String dispenseDate;
    @JsonProperty("providerId")
    private String providerId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("prescriptionNumber")
    private Integer prescriptionNumber;
    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("infoSource")
    private String infoSource;
 
    @JsonProperty("codedProduct")
    public String getCodedProduct() {
        return codedProduct;
    }

    @JsonProperty("codedProduct")
    public void setCodedProduct(String codedProduct) {
        this.codedProduct = codedProduct;
    }

    public Medication withCodedProduct(String codedProduct) {
        this.codedProduct = codedProduct;
        return this;
    }

    @JsonProperty("lotNumber")
    public Integer getLotNumber() {
        return lotNumber;
    }

    @JsonProperty("lotNumber")
    public void setLotNumber(Integer lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Medication withLotNumber(Integer lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    @JsonProperty("brandName")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brandName")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Medication withBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    @JsonProperty("drugManufacturer")
    public String getDrugManufacturer() {
        return drugManufacturer;
    }

    @JsonProperty("drugManufacturer")
    public void setDrugManufacturer(String drugManufacturer) {
        this.drugManufacturer = drugManufacturer;
    }

    public Medication withDrugManufacturer(String drugManufacturer) {
        this.drugManufacturer = drugManufacturer;
        return this;
    }

    @JsonProperty("doseValue")
    public Integer getDoseValue() {
        return doseValue;
    }

    @JsonProperty("doseValue")
    public void setDoseValue(Integer doseValue) {
        this.doseValue = doseValue;
    }

    public Medication withDoseValue(Integer doseValue) {
        this.doseValue = doseValue;
        return this;
    }

    @JsonProperty("doseLimit")
    public Integer getDoseLimit() {
        return doseLimit;
    }

    @JsonProperty("doseLimit")
    public void setDoseLimit(Integer doseLimit) {
        this.doseLimit = doseLimit;
    }

    public Medication withDoseLimit(Integer doseLimit) {
        this.doseLimit = doseLimit;
        return this;
    }

    @JsonProperty("doseHigh")
    public Integer getDoseHigh() {
        return doseHigh;
    }

    @JsonProperty("doseHigh")
    public void setDoseHigh(Integer doseHigh) {
        this.doseHigh = doseHigh;
    }

    public Medication withDoseHigh(Integer doseHigh) {
        this.doseHigh = doseHigh;
        return this;
    }

    @JsonProperty("doseLow")
    public Integer getDoseLow() {
        return doseLow;
    }

    @JsonProperty("doseLow")
    public void setDoseLow(Integer doseLow) {
        this.doseLow = doseLow;
    }

    public Medication withDoseLow(Integer doseLow) {
        this.doseLow = doseLow;
        return this;
    }

    @JsonProperty("dispenseDate")
    public String getDispenseDate() {
        return dispenseDate;
    }

    @JsonProperty("dispenseDate")
    public void setDispenseDate(String dispenseDate) {
        this.dispenseDate = dispenseDate;
    }

    public Medication withDispenseDate(String dispenseDate) {
        this.dispenseDate = dispenseDate;
        return this;
    }

    @JsonProperty("providerId")
    public String getProviderId() {
        return providerId;
    }

    @JsonProperty("providerId")
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Medication withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Medication withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @JsonProperty("prescriptionNumber")
    public Integer getPrescriptionNumber() {
        return prescriptionNumber;
    }

    @JsonProperty("prescriptionNumber")
    public void setPrescriptionNumber(Integer prescriptionNumber) {
        this.prescriptionNumber = prescriptionNumber;
    }

    public Medication withPrescriptionNumber(Integer prescriptionNumber) {
        this.prescriptionNumber = prescriptionNumber;
        return this;
    }

    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Medication withFrequency(String frequency) {
        this.frequency = frequency;
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

    public Medication withInfoSource(String infoSource) {
        this.infoSource = infoSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
