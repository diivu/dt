package com.triapp.Models;

/**
 * Created by Developer on 8/19/2017.
 */

public class WorkingCapitalModel {
    private Long id;
    private Long duration;
    private Long quantity;
    private Double amount;
    private Long workingCapitalParticularId;
    private Long businessPlanId;
    private Double rate;
    private String rateDescriprion;

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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getWorkingCapitalParticularId() {
        return workingCapitalParticularId;
    }

    public void setWorkingCapitalParticularId(Long workingCapitalParticularId) {
        this.workingCapitalParticularId = workingCapitalParticularId;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getRateDescriprion() {
        return rateDescriprion;
    }

    public void setRateDescriprion(String rateDescriprion) {
        this.rateDescriprion = rateDescriprion;
    }
}
