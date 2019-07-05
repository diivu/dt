package com.triapp.Models;

/**
 * Created by Developer on 8/17/2017.
 */

public class SaveEnterpriseModel {

    private String nameOfUnit;
    private String addressOfUnit;
    private Long entrepreneurId;
    private String govtLicense;
    private Long natureOfUnitId;
    private long licenseDate;
    private String registerNo;
    private int flag;
    private Long stateId;
    private Long districtId;
    private Long blockId;
    private Long villageId;
    private String pincode;
    private String type;
    private String sector;
    private Long businessPlanId;
    private Long createdDate;
    private int syncStatus;
    private int isModelBusinessPlan;
    private int isBusinessPlanSubmited;


    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }


    public String getGovtLicense() {
        return govtLicense;
    }

    public void setGovtLicense(String govtLicense) {
        this.govtLicense = govtLicense;
    }

    public String getNameOfUnit() {
        return nameOfUnit;
    }

    public void setNameOfUnit(String nameOfUnit) {
        this.nameOfUnit = nameOfUnit;
    }

    public String getAddressOfUnit() {
        return addressOfUnit;
    }

    public void setAddressOfUnit(String addressOfUnit) {
        this.addressOfUnit = addressOfUnit;
    }

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }

    public Long getNatureOfUnitId() {
        return natureOfUnitId;
    }

    public void setNatureOfUnitId(Long natureOfUnitId) {
        this.natureOfUnitId = natureOfUnitId;
    }


    public long getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(long licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }


    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIsModelBusinessPlan() {
        return isModelBusinessPlan;
    }

    public void setIsModelBusinessPlan(int isModelBusinessPlan) {
        this.isModelBusinessPlan = isModelBusinessPlan;
    }

    public int getIsBusinessPlanSubmited() {
        return isBusinessPlanSubmited;
    }

    public void setIsBusinessPlanSubmited(int isBusinessPlanSubmited) {
        this.isBusinessPlanSubmited = isBusinessPlanSubmited;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }
}
