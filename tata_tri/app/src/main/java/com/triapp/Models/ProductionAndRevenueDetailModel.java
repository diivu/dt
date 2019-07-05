package com.triapp.Models;

import java.util.ArrayList;

/**
 * Created by Developer on 25-08-2017.
 */

public class ProductionAndRevenueDetailModel {

    private ArrayList<ProductionAndRevenueDetailModel> data;


    public void setData(ArrayList<ProductionAndRevenueDetailModel> data) {
        this.data = data;
    }

    public ArrayList<ProductionAndRevenueDetailModel> getData() {
        return data;
    }

    public static class ProductionAndRevenueDetailModelBean {

        private Long id;
        private Long businessPlanId;
        private String productName;
        private String workingUnites;
        private String enterdWorkingUnits;
        private double perDayEightHours;
        private double totalProduction;
        private double perDaySixtyPercent ;
        private double totalUtilization;
        private double salePricePerUnit;
        private double amount;
        private int isEditble;
        private int salePercentage;
        private double costPrice;
        private double totalCostOfGoods;


        public double getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(double costPrice) {
            this.costPrice = costPrice;
        }

        public double getTotalCostOfGoods() {
            return totalCostOfGoods;
        }

        public void setTotalCostOfGoods(double totalCostOfGoods) {
            this.totalCostOfGoods = totalCostOfGoods;
        }

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

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getWorkingUnites() {
            return workingUnites;
        }

        public void setWorkingUnites(String workingUnites) {
            this.workingUnites = workingUnites;
        }

        public double getPerDayEightHours() {
            return perDayEightHours;
        }

        public void setPerDayEightHours(double perDayEightHours) {
            this.perDayEightHours = perDayEightHours;
        }

        public double getTotalProduction() {
            return totalProduction;
        }

        public void setTotalProduction(double totalProduction) {
            this.totalProduction = totalProduction;
        }

        public double getPerDaySixtyPercent() {
            return perDaySixtyPercent;
        }

        public void setPerDaySixtyPercent(double perDaySixtyPercent) {
            this.perDaySixtyPercent = perDaySixtyPercent;
        }

        public double getTotalUtilization() {
            return totalUtilization;
        }

        public void setTotalUtilization(double totalUtilization) {
            this.totalUtilization = totalUtilization;
        }

        public double getSalePricePerUnit() {
            return salePricePerUnit;
        }

        public void setSalePricePerUnit(double salePricePerUnit) {
            this.salePricePerUnit = salePricePerUnit;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int isEditble() {
            return isEditble;
        }

        public void setEditble(int editble) {
            isEditble = editble;
        }

        public String getEnterdWorkingUnits() {
            return enterdWorkingUnits;
        }

        public void setEnterdWorkingUnits(String enterdWorkingUnits) {
            this.enterdWorkingUnits = enterdWorkingUnits;
        }

        public int getIsEditble() {
            return isEditble;
        }

        public void setIsEditble(int isEditble) {
            this.isEditble = isEditble;
        }

        public int getSalePercentage() {
            return salePercentage;
        }

        public void setSalePercentage(int salePercentage) {
            this.salePercentage = salePercentage;
        }
    }
}
