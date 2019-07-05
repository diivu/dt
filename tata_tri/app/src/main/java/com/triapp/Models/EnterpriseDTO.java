package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Developer on 9/20/2017.
 */

public class EnterpriseDTO implements Serializable {

    private Long id;
    private Long entrepreneurId;
    private Long userProfileId;
    private Long businessDescriptorId;
    private String businessDescriptorName;
    private String shgMemberName;
    private String firstName;
    private String lastName;
    private String middleName;
    private String shgName;
    private String villageName;
    private String gramPanchayatName;
    private long dob;
    private String address;
    private String pincode;

    private String trainingAttanded;
    private long enrollmentDate;
    private String phoneNo;
    private String emailId;
    private String aadharNo;
    private String seccId;
    private String mgnregaNo;
    private String artisanNo;
    private String bankAccNo;
    private String bankName;
    private String branchName;
    private String ifsc;
    private String socialGroupName;
    private String religionName;
    private String fullName;
    private String shgMemberRelationshipName;


    private String panNo;
    private String education;
    private String gender;
    private String maritalStatus;
    private boolean haveDisability;
    private String businessDetail;
    private Long createdBy;
    private long createdDate;
    private double longitude;
    private double latitude;
    private boolean isSHGMember;
    private String trainingAttended;


    private long 	enterpriseStartDate;
    private String enterpriseName;
    private String businessType;
    private String enterpriseType;
    private String enterpriseFromation;
    private Long svepFundDate;
    private double 	totalAmountInvestment;
    private double 	ownFundInvestment;
    private double loanFromOtherSources;
    private double loanFromSvep;
    private String areaOfPerImp;
    private double loanFundPerImp;
    private double ownFundPerImp;
    private double currAnnualIncome;
    private double expAnnualIncome;
    private double loanSourcePerImp;
    private double totalAnnualIncome;
    private String prevBusiness;
    private double prevAnnualIncome;
    private double loanOutstandingFromSHG;
    private double loanOutstandingFromBank;
    private double loanOutstandingFromOtherSources;
    private double grossMargin;
    private boolean bankAccountSeeded;
    private double annualIncomeHouseHoldMembers;
    private boolean officeBearerShg;
    private String shgPosition;
    private boolean officeBearerVo;
    private String voPosition;
    private boolean officeBearerClf;
    private String clfPosition;
    private boolean cifAvailed;
    private double cifAvailedAmount;
    private long sinceDate;
    private String voName;
    public EnterpriseDTO() {

    }

    public EnterpriseDTO(String fullName) {

        this.fullName=fullName;
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

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Long getBusinessDescriptorId() {
        return businessDescriptorId;
    }

    public void setBusinessDescriptorId(Long businessDescriptorId) {
        this.businessDescriptorId = businessDescriptorId;
    }

    public String getBusinessDescriptorName() {
        return businessDescriptorName;
    }

    public void setBusinessDescriptorName(String businessDescriptorName) {
        this.businessDescriptorName = businessDescriptorName;
    }

    public String getShgMemberName() {
        return shgMemberName;
    }

    public void setShgMemberName(String shgMemberName) {
        this.shgMemberName = shgMemberName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getShgName() {
        return shgName;
    }

    public void setShgName(String shgName) {
        this.shgName = shgName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getGramPanchayatName() {
        return gramPanchayatName;
    }

    public void setGramPanchayatName(String gramPanchayatName) {
        this.gramPanchayatName = gramPanchayatName;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getTrainingAttanded() {
        return trainingAttanded;
    }

    public void setTrainingAttanded(String trainingAttanded) {
        this.trainingAttanded = trainingAttanded;
    }

    public long getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(long enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getSeccId() {
        return seccId;
    }

    public void setSeccId(String seccId) {
        this.seccId = seccId;
    }

    public String getMgnregaNo() {
        return mgnregaNo;
    }

    public void setMgnregaNo(String mgnregaNo) {
        this.mgnregaNo = mgnregaNo;
    }

    public String getArtisanNo() {
        return artisanNo;
    }

    public void setArtisanNo(String artisanNo) {
        this.artisanNo = artisanNo;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
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

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getSocialGroupName() {
        return socialGroupName;
    }

    public void setSocialGroupName(String socialGroupName) {
        this.socialGroupName = socialGroupName;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShgMemberRelationshipName() {
        return shgMemberRelationshipName;
    }

    public void setShgMemberRelationshipName(String shgMemberRelationshipName) {
        this.shgMemberRelationshipName = shgMemberRelationshipName;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isHaveDisability() {
        return haveDisability;
    }

    public void setHaveDisability(boolean haveDisability) {
        this.haveDisability = haveDisability;
    }

    public String getBusinessDetail() {
        return businessDetail;
    }

    public void setBusinessDetail(String businessDetail) {
        this.businessDetail = businessDetail;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isSHGMember() {
        return isSHGMember;
    }

    public void setSHGMember(boolean SHGMember) {
        isSHGMember = SHGMember;
    }

    public String getTrainingAttended() {
        return trainingAttended;
    }

    public void setTrainingAttended(String trainingAttended) {
        this.trainingAttended = trainingAttended;
    }

    public long getEnterpriseStartDate() {
        return enterpriseStartDate;
    }

    public void setEnterpriseStartDate(long enterpriseStartDate) {
        this.enterpriseStartDate = enterpriseStartDate;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getEnterpriseFromation() {
        return enterpriseFromation;
    }

    public void setEnterpriseFromation(String enterpriseFromation) {
        this.enterpriseFromation = enterpriseFromation;
    }

    public Long getSvepFundDate() {
        return svepFundDate;
    }

    public void setSvepFundDate(Long svepFundDate) {
        this.svepFundDate = svepFundDate;
    }

    public double getTotalAmountInvestment() {
        return totalAmountInvestment;
    }

    public void setTotalAmountInvestment(double totalAmountInvestment) {
        this.totalAmountInvestment = totalAmountInvestment;
    }

    public double getOwnFundInvestment() {
        return ownFundInvestment;
    }

    public void setOwnFundInvestment(double ownFundInvestment) {
        this.ownFundInvestment = ownFundInvestment;
    }

    public double getLoanFromOtherSources() {
        return loanFromOtherSources;
    }

    public void setLoanFromOtherSources(double loanFromOtherSources) {
        this.loanFromOtherSources = loanFromOtherSources;
    }

    public double getLoanFromSvep() {
        return loanFromSvep;
    }

    public void setLoanFromSvep(double loanFromSvep) {
        this.loanFromSvep = loanFromSvep;
    }

    public String getAreaOfPerImp() {
        return areaOfPerImp;
    }

    public void setAreaOfPerImp(String areaOfPerImp) {
        this.areaOfPerImp = areaOfPerImp;
    }

    public double getLoanFundPerImp() {
        return loanFundPerImp;
    }

    public void setLoanFundPerImp(double loanFundPerImp) {
        this.loanFundPerImp = loanFundPerImp;
    }

    public double getOwnFundPerImp() {
        return ownFundPerImp;
    }

    public void setOwnFundPerImp(double ownFundPerImp) {
        this.ownFundPerImp = ownFundPerImp;
    }

    public double getCurrAnnualIncome() {
        return currAnnualIncome;
    }

    public void setCurrAnnualIncome(double currAnnualIncome) {
        this.currAnnualIncome = currAnnualIncome;
    }

    public double getExpAnnualIncome() {
        return expAnnualIncome;
    }

    public void setExpAnnualIncome(double expAnnualIncome) {
        this.expAnnualIncome = expAnnualIncome;
    }

    public double getLoanSourcePerImp() {
        return loanSourcePerImp;
    }

    public void setLoanSourcePerImp(double loanSourcePerImp) {
        this.loanSourcePerImp = loanSourcePerImp;
    }

    public double getTotalAnnualIncome() {
        return totalAnnualIncome;
    }

    public void setTotalAnnualIncome(double totalAnnualIncome) {
        this.totalAnnualIncome = totalAnnualIncome;
    }

    public String getPrevBusiness() {
        return prevBusiness;
    }

    public void setPrevBusiness(String prevBusiness) {
        this.prevBusiness = prevBusiness;
    }

    public double getPrevAnnualIncome() {
        return prevAnnualIncome;
    }

    public void setPrevAnnualIncome(double prevAnnualIncome) {
        this.prevAnnualIncome = prevAnnualIncome;
    }

    public double getLoanOutstandingFromSHG() {
        return loanOutstandingFromSHG;
    }

    public void setLoanOutstandingFromSHG(double loanOutstandingFromSHG) {
        this.loanOutstandingFromSHG = loanOutstandingFromSHG;
    }

    public double getLoanOutstandingFromBank() {
        return loanOutstandingFromBank;
    }

    public void setLoanOutstandingFromBank(double loanOutstandingFromBank) {
        this.loanOutstandingFromBank = loanOutstandingFromBank;
    }

    public double getLoanOutstandingFromOtherSources() {
        return loanOutstandingFromOtherSources;
    }

    public void setLoanOutstandingFromOtherSources(double loanOutstandingFromOtherSources) {
        this.loanOutstandingFromOtherSources = loanOutstandingFromOtherSources;
    }

    public double getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(double grossMargin) {
        this.grossMargin = grossMargin;
    }

    public boolean isBankAccountSeeded() {
        return bankAccountSeeded;
    }

    public void setBankAccountSeeded(boolean bankAccountSeeded) {
        this.bankAccountSeeded = bankAccountSeeded;
    }

    public double getAnnualIncomeHouseHoldMembers() {
        return annualIncomeHouseHoldMembers;
    }

    public void setAnnualIncomeHouseHoldMembers(double annualIncomeHouseHoldMembers) {
        this.annualIncomeHouseHoldMembers = annualIncomeHouseHoldMembers;
    }

    public boolean isOfficeBearerShg() {
        return officeBearerShg;
    }

    public void setOfficeBearerShg(boolean officeBearerShg) {
        this.officeBearerShg = officeBearerShg;
    }

    public String getShgPosition() {
        return shgPosition;
    }

    public void setShgPosition(String shgPosition) {
        this.shgPosition = shgPosition;
    }

    public boolean isOfficeBearerVo() {
        return officeBearerVo;
    }

    public void setOfficeBearerVo(boolean officeBearerVo) {
        this.officeBearerVo = officeBearerVo;
    }

    public String getVoPosition() {
        return voPosition;
    }

    public void setVoPosition(String voPosition) {
        this.voPosition = voPosition;
    }

    public boolean isOfficeBearerClf() {
        return officeBearerClf;
    }

    public void setOfficeBearerClf(boolean officeBearerClf) {
        this.officeBearerClf = officeBearerClf;
    }

    public String getClfPosition() {
        return clfPosition;
    }

    public void setClfPosition(String clfPosition) {
        this.clfPosition = clfPosition;
    }

    public boolean isCifAvailed() {
        return cifAvailed;
    }

    public void setCifAvailed(boolean cifAvailed) {
        this.cifAvailed = cifAvailed;
    }

    public double getCifAvailedAmount() {
        return cifAvailedAmount;
    }

    public void setCifAvailedAmount(double cifAvailedAmount) {
        this.cifAvailedAmount = cifAvailedAmount;
    }

    public long getSinceDate() {
        return sinceDate;
    }

    public void setSinceDate(long sinceDate) {
        this.sinceDate = sinceDate;
    }

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }
}
