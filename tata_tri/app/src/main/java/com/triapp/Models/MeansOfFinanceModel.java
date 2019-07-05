package com.triapp.Models;

/**
 * Created by Developer on 8/19/2017.
 */

public class MeansOfFinanceModel {

    private Long id;
    private String remarks;
    private double amount;
    private Long businessPlanId;
    private Long financeMeansParticularId;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public Long getFinanceMeansParticularId() {
        return financeMeansParticularId;
    }

    public void setFinanceMeansParticularId(Long financeMeansParticularId) {
        this.financeMeansParticularId = financeMeansParticularId;
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
