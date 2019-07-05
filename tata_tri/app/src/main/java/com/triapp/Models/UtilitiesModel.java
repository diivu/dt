package com.triapp.Models;

/**
 * Created by Developer on 8/18/2017.
 */

public class UtilitiesModel {

    private Long id;
    private Long utilitiesParticularId;
    private double annualExpenditure;
    private String remarks;
    private Long businessPlanId;

    private int code;
    private Object data;
    private String message;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUtilitiesParticularId() {
        return utilitiesParticularId;
    }

    public void setUtilitiesParticularId(Long utilitiesParticularId) {
        this.utilitiesParticularId = utilitiesParticularId;
    }

    public double getAnnualExpenditure() {
        return annualExpenditure;
    }

    public void setAnnualExpenditure(double annualExpenditure) {
        this.annualExpenditure = annualExpenditure;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
