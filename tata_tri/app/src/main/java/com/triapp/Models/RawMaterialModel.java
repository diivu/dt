package com.triapp.Models;

/**
 * Created by Developer on 8/18/2017.
 */

public class RawMaterialModel {

    private Long id;
    private String item;
    private double quantity;
    private double rate;
    private double totalValue;
    private Long businessPlanId;
    private int forMonths;
    private int isEditable;



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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
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

    public int getForMonths() {
        return forMonths;
    }

    public void setForMonths(int forMonths) {
        this.forMonths = forMonths;
    }


    public int getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(int isEditable) {
        this.isEditable = isEditable;
    }


}
