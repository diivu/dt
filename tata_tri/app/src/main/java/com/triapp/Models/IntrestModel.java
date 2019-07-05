package com.triapp.Models;

/**
 * Created by Developer on 8/19/2017.
 */

public class IntrestModel {

    private Long id;
    private double loanAmount;
    private Long interestRate;
    private double installmentAmount;
    private Long moratoriumPeriod;
    private Long interestParticularId;
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

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Long interestRate) {
        this.interestRate = interestRate;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Long getMoratoriumPeriod() {
        return moratoriumPeriod;
    }

    public void setMoratoriumPeriod(Long moratoriumPeriod) {
        this.moratoriumPeriod = moratoriumPeriod;
    }

    public Long getInterestParticularId() {
        return interestParticularId;
    }

    public void setInterestParticularId(Long interestParticularId) {
        this.interestParticularId = interestParticularId;
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
