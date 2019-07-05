package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Developer on 7/28/2017.
 */

public class ExpanditureModel implements Serializable {

    private Long id;
    private String itemType;
    private double monthlyExpence;
    private double annualExpence;
    private Long entrepreneurId;
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getMonthlyExpence() {
        return monthlyExpence;
    }

    public void setMonthlyExpence(double monthlyExpence) {
        this.monthlyExpence = monthlyExpence;
    }

    public double getAnnualExpence() {
        return annualExpence;
    }

    public void setAnnualExpence(double annualExpence) {
        this.annualExpence = annualExpence;
    }

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
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
