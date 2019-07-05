package com.triapp.Models;

/**
 * Created by Developer on 8/18/2017.
 */

public class ManPowerModel {

    private Long id;
    private Long number;
    private double wagesPerMonth;
    private double annualExpenses;
    private Long manpowerParticularId;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double getWagesPerMonth() {
        return wagesPerMonth;
    }

    public void setWagesPerMonth(double wagesPerMonth) {
        this.wagesPerMonth = wagesPerMonth;
    }

    public double getAnnualExpenses() {
        return annualExpenses;
    }

    public void setAnnualExpenses(double annualExpenses) {
        this.annualExpenses = annualExpenses;
    }

    public Long getManpowerParticularId() {
        return manpowerParticularId;
    }

    public void setManpowerParticularId(Long manpowerParticularId) {
        this.manpowerParticularId = manpowerParticularId;
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
