package com.triapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Developer on 8/11/2017.
 */

public class EducationQualificationModel implements Serializable {

    private Long id;
    private Long entrepreneurId,businessPlanId;
    private Long businessDescriptorId;
    private String qualificationName;
    private String universityName;
    private String passingYear;
    private String majorSubject;
    private String entrepreneurName;
    private String businessPlanName;
    private String villageName;
    private String voName;
    private String shgName;
    private String typeName;
    private String createdDate;
    private int loanAmount;


    private int code;
    private Object data;
    private String message;
    private String description;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }

    public String getShgName() {
        return shgName;
    }

    public void setShgName(String shgName) {
        this.shgName = shgName;
    }




    private ArrayList<EducationQualificationModel> educationQualificationList;

    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public String getEntrepreneurName() {
        return entrepreneurName;
    }

    public void setEntrepreneurName(String entrepreneurName) {
        this.entrepreneurName = entrepreneurName;
    }

    public String getBusinessPlanName() {
        return businessPlanName;
    }

    public void setBusinessPlanName(String businessPlanName) {
        this.businessPlanName = businessPlanName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }

    public Long getBusinessDescriptorId() {
        return businessDescriptorId;
    }

    public void setBusinessDescriptorId(Long businessDescriptorId) {
        this.businessDescriptorId = businessDescriptorId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getMajorSubject() {
        return majorSubject;
    }

    public void setMajorSubject(String majorSubject) {
        this.majorSubject = majorSubject;
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
