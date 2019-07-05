package com.triapp.Models;

/**
 * Created by Developer on 8/19/2017.
 */

public class SellingDistributionExpensModel {

    private Long id;
    private String remarks;
    private double amount;
    private Long sellingDistributionExpenseParticularId;
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

    public Long getSellingDistributionExpenseParticularId() {
        return sellingDistributionExpenseParticularId;
    }

    public void setSellingDistributionExpenseParticularId(Long sellingDistributionExpenseParticularId) {
        this.sellingDistributionExpenseParticularId = sellingDistributionExpenseParticularId;
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
