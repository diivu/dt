package com.triapp.Models;

/**
 * Created by Developer on 8/18/2017.
 */

public class EquipmentFurnitureModel {

    private Long id;
    private String particulars;
    private Long numbers;
    private double price;
    private double amount;
    private String supplierNameAddress;
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

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSupplierNameAddress() {
        return supplierNameAddress;
    }

    public void setSupplierNameAddress(String supplierNameAddress) {
        this.supplierNameAddress = supplierNameAddress;
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
