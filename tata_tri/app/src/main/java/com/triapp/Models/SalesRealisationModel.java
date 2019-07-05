package com.triapp.Models;

/**
 * Created by Developer on 8/25/2017.
 */

public class SalesRealisationModel {

    private long businessPlanId;
    private String particulars;
    private double quantity;
    private double amount;
    private Long id;
    private long entrepreneurId;

    private int code;
    private Object data;
    private String message;
    private String description;

    public long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }
}
