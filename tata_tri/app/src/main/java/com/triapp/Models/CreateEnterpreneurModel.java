package com.triapp.Models;

import java.io.Serializable;
import java.util.List;

public class CreateEnterpreneurModel {

    private int code;
    private List<DataBean> dataBeans;
    private String message;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getDataBeans() {
        return dataBeans;
    }

    public void setDataBeans(List<DataBean> dataBeans) {
        this.dataBeans = dataBeans;
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

    public static class DataBean {

        private Long enterpreneurID;
        private Long userID;
        private double latitude;
        private double longitude;
        private String enterpriseType;
        private String nameOfEntereprise;
        private String typeOfEnterprise;
        private String description;
        private String firstName;
        private String middleName;
        private String lastName;
        private Long dateOfBirth;
        private String gender;
        private String emailID;
        private Long SocialCategoryID;
        private Long stateID;
        private Long districtID;
        private Long blockID;
        private Long villegeID;
        private String residenceAddress;
        private String pinCode;
        private String aadharNo;
        private String panNo;
        private String bankAccountNo;
        private String bankName;
        private String branchName;
        private String bankIFSCCode;
        private String maritalStatus;
        private Long enrollmentDate;
        private int noOfDependent;
        private int isBusinessPlanCreated;
        private int isBusinessPlanSubmitted;
        private int isModelBusinessPlan;
        private int isEnterpriseRegistred;
        private String fullName;
        private String isEventeAttained;
        private String eventName;
        private String paricipantName;

        private List<ListEducationalQualificationBean> listEducationalQualification;
        private List<ListSpecialTrainingBean> listSpecialTrainingBean;
        private List<ListWorkExperienceBean> listWorkExperienceBean;


        public String getIsEventeAttained() {
            return isEventeAttained;
        }

        public void setIsEventeAttained(String isEventeAttained) {
            this.isEventeAttained = isEventeAttained;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getParicipantName() {
            return paricipantName;
        }

        public void setParicipantName(String paricipantName) {
            this.paricipantName = paricipantName;
        }

        public int getNoOfDependent() {
            return noOfDependent;
        }

        public void setNoOfDependent(int noOfDependent) {
            this.noOfDependent = noOfDependent;
        }

        public Long getEnrollmentDate() {
            return enrollmentDate;
        }

        public void setEnrollmentDate(Long enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
        }

        public DataBean(String fullName) {

            this.fullName = fullName;
        }

        public DataBean() {
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getIsEnterpriseRegistred() {
            return isEnterpriseRegistred;
        }

        public void setIsEnterpriseRegistred(int isEnterpriseRegistred) {
            this.isEnterpriseRegistred = isEnterpriseRegistred;
        }

        public Long getEnterpreneurID() {
            return enterpreneurID;
        }

        public void setEnterpreneurID(Long enterpreneurID) {
            this.enterpreneurID = enterpreneurID;
        }

        public Long getUserID() {
            return userID;
        }

        public void setUserID(Long userID) {
            this.userID = userID;
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

        public String getEnterpriseType() {
            return enterpriseType;
        }

        public void setEnterpriseType(String enterpriseType) {
            this.enterpriseType = enterpriseType;
        }

        public String getNameOfEntereprise() {
            return nameOfEntereprise;
        }

        public void setNameOfEntereprise(String nameOfEntereprise) {
            this.nameOfEntereprise = nameOfEntereprise;
        }

        public String getTypeOfEnterprise() {
            return typeOfEnterprise;
        }

        public void setTypeOfEnterprise(String typeOfEnterprise) {
            this.typeOfEnterprise = typeOfEnterprise;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Long getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Long dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }


        public String getEmailID() {
            return emailID;
        }

        public void setEmailID(String emailID) {
            this.emailID = emailID;
        }


        public Long getSocialCategoryID() {
            return SocialCategoryID;
        }

        public void setSocialCategoryID(Long socialCategoryID) {
            SocialCategoryID = socialCategoryID;
        }

        public Long getStateID() {
            return stateID;
        }

        public void setStateID(Long stateID) {
            this.stateID = stateID;
        }

        public Long getDistrictID() {
            return districtID;
        }

        public void setDistrictID(Long districtID) {
            this.districtID = districtID;
        }

        public Long getBlockID() {
            return blockID;
        }

        public void setBlockID(Long blockID) {
            this.blockID = blockID;
        }

        public Long getVillegeID() {
            return villegeID;
        }

        public void setVillegeID(Long villegeID) {
            this.villegeID = villegeID;
        }

        public String getResidenceAddress() {
            return residenceAddress;
        }

        public void setResidenceAddress(String residenceAddress) {
            this.residenceAddress = residenceAddress;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public String getAadharNo() {
            return aadharNo;
        }

        public void setAadharNo(String aadharNo) {
            this.aadharNo = aadharNo;
        }

        public String getPanNo() {
            return panNo;
        }

        public void setPanNo(String panNo) {
            this.panNo = panNo;
        }

        public String getBankAccountNo() {
            return bankAccountNo;
        }

        public void setBankAccountNo(String bankAccountNo) {
            this.bankAccountNo = bankAccountNo;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getBankIFSCCode() {
            return bankIFSCCode;
        }

        public void setBankIFSCCode(String bankIFSCCode) {
            this.bankIFSCCode = bankIFSCCode;
        }


        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }



        public int getIsBusinessPlanCreated() {
            return isBusinessPlanCreated;
        }

        public void setIsBusinessPlanCreated(int isBusinessPlanCreated) {
            this.isBusinessPlanCreated = isBusinessPlanCreated;
        }

        public int getIsBusinessPlanSubmitted() {
            return isBusinessPlanSubmitted;
        }

        public void setIsBusinessPlanSubmitted(int isBusinessPlanSubmitted) {
            this.isBusinessPlanSubmitted = isBusinessPlanSubmitted;
        }

        public int getIsModelBusinessPlan() {
            return isModelBusinessPlan;
        }

        public void setIsModelBusinessPlan(int isModelBusinessPlan) {
            this.isModelBusinessPlan = isModelBusinessPlan;
        }

        public List<ListEducationalQualificationBean> getListEducationalQualification() {
            return listEducationalQualification;
        }

        public void setListEducationalQualification(List<ListEducationalQualificationBean> listEducationalQualification) {
            this.listEducationalQualification = listEducationalQualification;
        }

        public List<ListSpecialTrainingBean> getListSpecialTrainingBean() {
            return listSpecialTrainingBean;
        }

        public void setListSpecialTrainingBean(List<ListSpecialTrainingBean> listSpecialTrainingBean) {
            this.listSpecialTrainingBean = listSpecialTrainingBean;
        }

        public List<ListWorkExperienceBean> getListWorkExperienceBean() {
            return listWorkExperienceBean;
        }

        public void setListWorkExperienceBean(List<ListWorkExperienceBean> listWorkExperienceBean) {
            this.listWorkExperienceBean = listWorkExperienceBean;
        }

    }


    public static class ListEducationalQualificationBean implements Serializable {

        private Long createdBy;
        private Long modifiedBy;
        private long createdDate;
        private Long id;
        private String qualificationName;
        private String universityName;
        private String passingYear;
        private String majorSubject;
        private boolean deleted;
        private Long entrepreneurId;
        private int isEditable ;

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public Long getModifiedBy() {
            return modifiedBy;
        }

        public void setModifiedBy(Long modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public long getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(long createdDate) {
            this.createdDate = createdDate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public Long getEntrepreneurId() {
            return entrepreneurId;
        }

        public void setEntrepreneurId(Long entrepreneurId) {
            this.entrepreneurId = entrepreneurId;
        }

        public void setMajorSubject(String majorSubject) {
            this.majorSubject = majorSubject;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public int getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(int isEditable) {
            this.isEditable = isEditable;
        }
    }

    public static class ListSpecialTrainingBean implements Serializable{

        private Long id;
        private String subject;
        private String institute;
        private String duration;
        private String learning;
        private Long entrepreneurId;
        private int isEditable;


        public int getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(int isEditable) {
            this.isEditable = isEditable;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getInstitute() {
            return institute;
        }

        public void setInstitute(String institute) {
            this.institute = institute;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLearning() {
            return learning;
        }

        public void setLearning(String learning) {
            this.learning = learning;
        }

        public Long getEntrepreneurId() {
            return entrepreneurId;
        }

        public void setEntrepreneurId(Long entrepreneurId) {
            this.entrepreneurId = entrepreneurId;
        }
    }

    public static class ListWorkExperienceBean implements Serializable{

        private Long id;
        private String organisation;
        private String designation;
        private String jobProfile;
        private String duration;
        private Long entrepreneurId;
        private int isEdited;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOrganisation() {
            return organisation;
        }

        public void setOrganisation(String organisation) {
            this.organisation = organisation;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getJobProfile() {
            return jobProfile;
        }

        public void setJobProfile(String jobProfile) {
            this.jobProfile = jobProfile;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Long getEntrepreneurId() {
            return entrepreneurId;
        }

        public void setEntrepreneurId(Long entrepreneurId) {
            this.entrepreneurId = entrepreneurId;
        }

        public int getIsEdited() {
            return isEdited;
        }

        public void setIsEdited(int isEdited) {
            this.isEdited = isEdited;
        }



    }


}
