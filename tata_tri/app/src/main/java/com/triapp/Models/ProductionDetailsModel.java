package com.triapp.Models;

/**
 * Created by Developer on 8/25/2017.
 */

public class ProductionDetailsModel {

    private Long id;
    private Long workingDays;
    private String productType;
    private double totalProduction;
    private double actualNumberOfProduction;
    private double utilizationCapacityProduction;
    private double totalUtilizationProduction;
    private double salePrice;
    private double saleAmount;
    private Long natureOfUnitProductionCapacityId;
    private Long businessPlanId;
    private Long businessDescriptorId;
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

    public Long getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Long workingDays) {
        this.workingDays = workingDays;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getTotalProduction() {
        return totalProduction;
    }

    public void setTotalProduction(double totalProduction) {
        this.totalProduction = totalProduction;
    }

    public double getActualNumberOfProduction() {
        return actualNumberOfProduction;
    }

    public void setActualNumberOfProduction(double actualNumberOfProduction) {
        this.actualNumberOfProduction = actualNumberOfProduction;
    }

    public double getUtilizationCapacityProduction() {
        return utilizationCapacityProduction;
    }

    public void setUtilizationCapacityProduction(double utilizationCapacityProduction) {
        this.utilizationCapacityProduction = utilizationCapacityProduction;
    }

    public double getTotalUtilizationProduction() {
        return totalUtilizationProduction;
    }

    public void setTotalUtilizationProduction(double totalUtilizationProduction) {
        this.totalUtilizationProduction = totalUtilizationProduction;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Long getNatureOfUnitProductionCapacityId() {
        return natureOfUnitProductionCapacityId;
    }

    public void setNatureOfUnitProductionCapacityId(Long natureOfUnitProductionCapacityId) {
        this.natureOfUnitProductionCapacityId = natureOfUnitProductionCapacityId;
    }

    public long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public long getBusinessDescriptorId() {
        return businessDescriptorId;
    }

    public void setBusinessDescriptorId(long businessDescriptorId) {
        this.businessDescriptorId = businessDescriptorId;
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
