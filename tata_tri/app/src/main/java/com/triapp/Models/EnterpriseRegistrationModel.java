package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Svep Developer on 09-10-2017.
 */

public class EnterpriseRegistrationModel implements Serializable {


    private String enterpreneurName;
    private String enterpriseName;
    private Long enterpreneurID;
    private Long enterpriseID;
    private Long blockID;
    private Long villageID;
    private Long enterpriseStartingDate;
    private String uploadEnterpriseImage;
    private double latitude;
    private double longitude;
    private Long createdDate;

    public String getEnterpreneurName() {
        return enterpreneurName;
    }

    public void setEnterpreneurName(String enterpreneurName) {
        this.enterpreneurName = enterpreneurName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Long getEnterpreneurID() {
        return enterpreneurID;
    }

    public void setEnterpreneurID(Long enterpreneurID) {
        this.enterpreneurID = enterpreneurID;
    }

    public Long getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(Long enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public Long getBlockID() {
        return blockID;
    }

    public void setBlockID(Long blockID) {
        this.blockID = blockID;
    }

    public Long getVillageID() {
        return villageID;
    }

    public void setVillageID(Long villageID) {
        this.villageID = villageID;
    }

    public Long getEnterpriseStartingDate() {
        return enterpriseStartingDate;
    }

    public void setEnterpriseStartingDate(Long enterpriseStartingDate) {
        this.enterpriseStartingDate = enterpriseStartingDate;
    }

    public String getUploadEnterpriseImage() {
        return uploadEnterpriseImage;
    }

    public void setUploadEnterpriseImage(String uploadEnterpriseImage) {
        this.uploadEnterpriseImage = uploadEnterpriseImage;
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

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }
}
