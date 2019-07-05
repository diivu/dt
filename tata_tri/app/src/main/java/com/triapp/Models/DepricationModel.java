package com.triapp.Models;

/**
 * Created by Developer on 8/19/2017.
 */

public class DepricationModel {

    private Long id;
    private Long businessPlanId;
    private String typeOfAsset;
    private Double initialValue;
    private Long percentagePerAnnum;
    private Long expectedLife;
    private Double depreciationValue;
    private long puchaseDate;

    private Double bookValue;

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

    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public String getTypeOfAsset() {
        return typeOfAsset;
    }

    public void setTypeOfAsset(String typeOfAsset) {
        this.typeOfAsset = typeOfAsset;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Long getPercentagePerAnnum() {
        return percentagePerAnnum;
    }

    public void setPercentagePerAnnum(Long percentagePerAnnum) {
        this.percentagePerAnnum = percentagePerAnnum;
    }

    public Long getExpectedLife() {
        return expectedLife;
    }

    public void setExpectedLife(Long expectedLife) {
        this.expectedLife = expectedLife;
    }

    public Double getDepreciationValue() {
        return depreciationValue;
    }

    public void setDepreciationValue(Double depreciationValue) {
        this.depreciationValue = depreciationValue;
    }

    public long getPuchaseDate() {
        return puchaseDate;
    }

    public void setPuchaseDate(long puchaseDate) {
        this.puchaseDate = puchaseDate;
    }

    public Double getBookValue() {
        return bookValue;
    }

    public void setBookValue(Double bookValue) {
        this.bookValue = bookValue;
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
