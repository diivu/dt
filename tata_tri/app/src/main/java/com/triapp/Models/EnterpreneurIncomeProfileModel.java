package com.triapp.Models;

public class EnterpreneurIncomeProfileModel {

    private Long enterpreneurID;
    private Double latitude;
    private Double longitude;
    private String annualIncome;
    private Long annualIncomeID;
    private String selfIncome;
    private Long selfIncomeID;
    private Long createdBy;
    private Long createdDate;


    public Long getEnterpreneurID() {
        return enterpreneurID;
    }

    public void setEnterpreneurID(Long enterpreneurID) {
        this.enterpreneurID = enterpreneurID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Long getAnnualIncomeID() {
        return annualIncomeID;
    }

    public void setAnnualIncomeID(Long annualIncomeID) {
        this.annualIncomeID = annualIncomeID;
    }

    public String getSelfIncome() {
        return selfIncome;
    }

    public void setSelfIncome(String selfIncome) {
        this.selfIncome = selfIncome;
    }

    public Long getSelfIncomeID() {
        return selfIncomeID;
    }

    public void setSelfIncomeID(Long selfIncomeID) {
        this.selfIncomeID = selfIncomeID;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }
}
