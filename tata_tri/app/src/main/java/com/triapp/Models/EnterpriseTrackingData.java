package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Svep Developer on 09-10-2017.
 */

public class EnterpriseTrackingData implements Serializable {


    private String enterpriseName;
    private Long enterpriseID;
    private Long enterpreneurID;
    private Long mobileUserID;
    private String status;
    private double turnOver;
    private double profite;
    private double peopleEmployed;
    private double capitalDeployed;
    private double returnOnInvestment;
    private double profiteAsPercentage;
    private Long currentTime;
    private double latitude;
    private double longitude;


    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Long getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(Long enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public Long getEnterpreneurID() {
        return enterpreneurID;
    }

    public void setEnterpreneurID(Long enterpreneurID) {
        this.enterpreneurID = enterpreneurID;
    }

    public Long getMobileUserID() {
        return mobileUserID;
    }

    public void setMobileUserID(Long mobileUserID) {
        this.mobileUserID = mobileUserID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(double turnOver) {
        this.turnOver = turnOver;
    }

    public double getProfite() {
        return profite;
    }

    public void setProfite(double profite) {
        this.profite = profite;
    }

    public double getPeopleEmployed() {
        return peopleEmployed;
    }

    public void setPeopleEmployed(double peopleEmployed) {
        this.peopleEmployed = peopleEmployed;
    }

    public double getCapitalDeployed() {
        return capitalDeployed;
    }

    public void setCapitalDeployed(double capitalDeployed) {
        this.capitalDeployed = capitalDeployed;
    }

    public double getReturnOnInvestment() {
        return returnOnInvestment;
    }

    public void setReturnOnInvestment(double returnOnInvestment) {
        this.returnOnInvestment = returnOnInvestment;
    }

    public double getProfiteAsPercentage() {
        return profiteAsPercentage;
    }

    public void setProfiteAsPercentage(double profiteAsPercentage) {
        this.profiteAsPercentage = profiteAsPercentage;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
