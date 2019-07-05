package com.triapp.Models;

/**
 * Created by Developer on 8/17/2017.
 */

public class LandBuildingModel {

    private Long id;
    private Long landBuildingExpensesParticularId;
    private Long area;
    private Double price;
    private Double amount;
    private String ownership;
    private int preOperativeMonths;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLandBuildingExpensesParticularId() {
        return landBuildingExpensesParticularId;
    }

    public void setLandBuildingExpensesParticularId(Long landBuildingExpensesParticularId) {
        this.landBuildingExpensesParticularId = landBuildingExpensesParticularId;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public int getPreOperativeMonths() {
        return preOperativeMonths;
    }

    public void setPreOperativeMonths(int preOperativeMonths) {
        this.preOperativeMonths = preOperativeMonths;
    }
}
