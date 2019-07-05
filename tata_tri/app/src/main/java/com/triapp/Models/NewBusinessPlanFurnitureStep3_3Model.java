package com.triapp.Models;

/**
 * Created by Developer on 30-01-2018.
 */

public class NewBusinessPlanFurnitureStep3_3Model {

    private int code;
    private Object data;
    private String messege;
    private String description;

    private Long id;
    private Long businessPlanID;
    private Long createdby;
    private String perticuler;
    private Long machineryNo ;
    private double price;
    private double amount;
    private Long expectedLife;
    private Long purchaseDate;
    private Long scrapValue;
    private double depriciation;
    private double bookValue;
    private String suppliersNameAndAddress;
    private int  isDataEditable;
    private String uploadQuptions;

    public String getUploadQuptions() {
        return uploadQuptions;
    }

    public void setUploadQuptions(String uploadQuptions) {
        this.uploadQuptions = uploadQuptions;
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

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessPlanID() {
        return businessPlanID;
    }

    public void setBusinessPlanID(Long businessPlanID) {
        this.businessPlanID = businessPlanID;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public String getPerticuler() {
        return perticuler;
    }

    public void setPerticuler(String perticuler) {
        this.perticuler = perticuler;
    }

    public Long getMachineryNo() {
        return machineryNo;
    }

    public void setMachineryNo(Long machineryNo) {
        this.machineryNo = machineryNo;
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

    public Long getExpectedLife() {
        return expectedLife;
    }

    public void setExpectedLife(Long expectedLife) {
        this.expectedLife = expectedLife;
    }

    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getScrapValue() {
        return scrapValue;
    }

    public void setScrapValue(Long scrapValue) {
        this.scrapValue = scrapValue;
    }

    public double getDepriciation() {
        return depriciation;
    }

    public void setDepriciation(double depriciation) {
        this.depriciation = depriciation;
    }

    public double getBookValue() {
        return bookValue;
    }

    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    public String getSuppliersNameAndAddress() {
        return suppliersNameAndAddress;
    }

    public void setSuppliersNameAndAddress(String suppliersNameAndAddress) {
        this.suppliersNameAndAddress = suppliersNameAndAddress;
    }

    public int getIsDataEditable() {
        return isDataEditable;
    }

    public void setIsDataEditable(int isDataEditable) {
        this.isDataEditable = isDataEditable;
    }
}
