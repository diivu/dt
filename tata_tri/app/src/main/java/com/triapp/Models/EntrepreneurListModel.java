package com.triapp.Models;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Developer on 7/19/2017.
 */

public class EntrepreneurListModel implements Serializable {

    private int code;
    private String message;
    private Object description;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {


        private Long id;
        private Long entrepreneurId;
        private Long userProfileId;
        private String shgId;
        private Long shgMemberRelationshipId;
        private Long userId;
        private String firstName;
        private String middleName;
        private String lastName;
        private String shgName;
        private String villageName;
        private String fullName;
        private long dob;
        private String address;
        private String pincode;
        private Long villageId;
        private Long blockId;
        private Long districtId;
        private Long stateId;
        private Long religionId;
        private Long casteId;
        private Long socialGroupId;
        private String gramPanchayatId;
        private String trainingAttanded;
        private long enrollmentDate;
        private String phoneNo;
        private String emailId;
        private String aadharNo;
        private String seccId;
        private String seccReason;
        private String mgnregaNo;
        private String artisanNo;
        private String bankAccNo;
        private String bankName;
        private String branchName;
        private String ifsc;
        private String panNo;
        private String education;
        private String username;
        private String password;
        private String gender;
        private String maritalStatus;
        private boolean haveDisability;
        private String voterId;
        private String businessDetail;
        private Long createdBy;
        private long createdDate;
        private double longitude;
        private double latitude;
        private String shgMemberName;
        private long shgMemberSince;
        private boolean officeBearerShg;
        private String shgPosition;
        private boolean officeBearerVo;
        private String voPosition;
        private boolean officeBearerClf;
        private String clfPosition;
        private String enterpriseType;
        private String aspirationalIncome;
        private String previousIncome;
        private String entrepreneurshipReason;
        private String enterpriseName;
        private Long typeOfUnitId;
        private String grampachaytName;
        private String socialGroup;
        private String voName;
        private EnterpriseDTO enterpriseDTO;
        private ShgUserDTOBean shgUserDTO;
        private VoUserDTOBean voUserDTO;
        private ClfUserDTOBean clfUserDTO;
        private boolean isSHGMember;
        private boolean group;
        private boolean mainEntrepreneur;
        private boolean isBPLCardholder;

        //-----------(New APIs Start Here....)----------------------//
        // For Family Member
        private int autoId;
        private Long modifiedBy;
        private String memberName;
        private String occupations;
        private int age;
        private String experience;
        private String relationship;
        private String entrepreneurRelationship;
        private boolean deleted;

        // For Family Income
        private String incomeSource;
        private int activeDaysOfMonth;
        private int activeMonthsOfYear;
        private Double incomePerDay;
        private Double annualIncome;
        private Long familyMemberId;

        // For Credit History
        private LoanTypeBean loanType;
        private Long LoanTypeIdGet;
        private String LoanTypeName;
        private long loanStartDate;
        private long loanEndDate;
        private int interestRate;
        private Double loanAmount;
        private Double currentOutstanding;
        private boolean loanStatus;
        private Double emiAmount;
        private Long loanTypeId;
        private String loanTypeCreditHistory;

        // For Family Expanditure
        private String itemType;
        private double monthlyExpence;
        private Double annualExpence;
        private Long itemTypeId;

        // For Businessplan
        private String nameOfEntrepreneur;
        private long dateOfBirth;
        private Long businessPlanId;//1
        private Long executiveProjectSummaryId;
        private String executiveProjectSummary;//2
        private String govtLicense;//3
        private String nameOfUnit;//4
        private String addressOfUnit;//5
        private Long businessDescriptorId;//7
        private String businessDescriptorName;//8
        private Long natureOfUnitId;//9
        private String natureOfUnitName;//10
        private Long placeId;//11
        private String typeOfUnitName;//13
        private String placeName;//14
        private String status;
        private Long grampanchayatId;
        private double tax;
        private double transportation;
        private double insurance;
        private double electrificationExpense;
        private long reasonId;
        private File momFile;
        private double currentOutstandingCH;
        private double emiAmountCH;
        private double loanAmountCH;
        private long  loanEndDateCH;
        private long loanStartDateCH;
        private double intrestRateCH;
        private double establishedProductionCapacityTotal;
        private double utilizationCapacityTotal;
        private double salesRevenueTotal;
        private double salesRealisationTotal;
        private double preoperativeExpenditureTotal;
        private double landandBuildingExpTotal;
        private double machineryTotal;
        private double machineryExpenseTotal;
        private double equipmentandFurnitureTotal;
        private double rawMaterialTotal;
        private double utilitiesTotal;
        private double manpowerTotal;
        private double administrativeExpensesTotal;
        private double sellingAndDistributionExpensesTotal;
        private double depreciationTotal;
        private double workingCapitalTotal;
        private double meansOfFinanceTotal;
        private double interestTotal;
        private double rentTotal;
        private double miscTotal;
        private double otherTotalIncome;
        private double protabilityProjectionTotal;
        private double grossProfitLossTotal;
        private double revenueDecreaseTwentyPercent;
        private double revenueDecreaseTenPercent;
        private double revenueIncreaseTenPercent;
        private double totalFamilyIncome;
        private double totalExpanditure;
        private double totalLoanAmount;
        private double currentLoan;
        private double totalCurrentLoanOutstanding;
        private double annualNetFamilyIncome;
        private double VariableCostIncreaseTwentyPercent;
        private double VariableCostIncreaseTenPercent;
        private double VariableCostDecreseFivePercent;
        private String blockName;
        private Long date;
        private Long applicationId;
        private Long loanApplicationId;
        private String businessActivity;
        private String businessActivityExisting;
        private double period;
        private String proposed;
        private String businessExperience;
        private double netSalePastYear;
        private double netSalePresentYear;
        private double netSaleNextyear;
        private double netProfitPastYear;
        private double netProfitPresentYear;
        private double netProfitNextYear;
        private String savingAccountName;
        private double savingAccountOutstandingAmout;
        private String savingAccountCustomerDetail;
        private String shgLoanName;
        private double shgLoanOutstandingAmount;
        private String shgLoanCustomerDetail;
        private String othersName;
        private double othersOutstandingAmount;
        private String othersCustomerDetail;
        private int savingAccountIntrestRate;
        private int shgIntrestRate;
        private int othersIntrestRate;
        private String applyingFor;
        private String telephoneNo;
        private String addressProof;
        private String socialCategory;
        private int flag;
        private String purposeOfLoan;
        private double loanAmountCEF;
        private double loanAmountOther;
        private String registerNo;
        private long licenseDate;
        private double loanDisbursalAmount;
        private String loanCriteria;
        private Date loanDisbursalDate;
        private double approveLoanAmount;
        private double moretoriumPeriod;
        private double noOfInstallments;
        private double suggestedPaybackAmount;
        private double approvedLoanAmount;
        private List<Integer> remainingEmiList;
        private double annualDebtRepaymentTotal;
        private List<String> loanTypeNameList;
        private List<ProductionDetailsModel> establishedProductionCapacityList;
        private List<SelectedParticularsModel> preoperativeExpenditureList;
        private List<LandBuildingModel> landBuildingExpensesList;
        private List<MachinaryModel> machineryList;
        private List<EquipmentFurnitureModel> equipmentFurnitureList;
        private List<RawMaterialModel> rawMaterialList;
        private List<UtilitiesModel> utilitiesList;
        private List<ManPowerModel> manpowerList;
        private List<AdministrativeModel> administrativeExpensesList;
        private List<SellingDistributionExpensModel> sellingDistributionExpensesList;
        private List<DepricationModel> depreciationList;
        private List<WorkingCapitalModel> workingCapitalList;
        private List<SalesRealisationModel> bpSalesRealisationList;
        private List<MeansOfFinanceModel> financeMeansList;
        private List<IntrestModel> interestList;


        //-----------(New APIs Finished Here....)----------------------//


        // Regular Model
        private List<FamilyMembersBean> familyMembers;
        private List<FamilyExpendituresBean> familyExpenditures;
        private List<FamilyIncomeBean> familyIncomes;
        private List<ListCreditHistoryBean> listCreditHistory;
        private List<?> listGrowthPlan;
        private List<ListEducationalQualificationBean> listEducationalQualification;
        private List<ListSpecialTrainingBean> listSpecialTraining;
        private List<ListWorkExperienceBean> listWorkExperience;
        private BusinessPlanDTO businessPlanDTO;


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

        public String getShgId() {
            return shgId;
        }

        public void setShgId(String shgId) {
            this.shgId = shgId;
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


        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
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

        public long getVillageId() {
            return villageId;
        }

        public void setVillageId(long villageId) {
            this.villageId = villageId;
        }

        public String getGramPanchayatId() {
            return gramPanchayatId;
        }

        public Long getSocialGroupId() {
            return socialGroupId;
        }

        public String getTrainingAttanded() {
            return trainingAttanded;
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

        public String getSeccReason() {
            return seccReason;
        }

        public void setSeccReason(String seccReason) {
            this.seccReason = seccReason;
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

        public String getVoterId() {
            return voterId;
        }

        public void setVoterId(String voterId) {
            this.voterId = voterId;
        }


        public boolean isOfficeBearerShg() {
            return officeBearerShg;
        }

        public void setOfficeBearerShg(boolean officeBearerShg) {
            this.officeBearerShg = officeBearerShg;
        }


        public boolean isOfficeBearerVo() {
            return officeBearerVo;
        }

        public void setOfficeBearerVo(boolean officeBearerVo) {
            this.officeBearerVo = officeBearerVo;
        }


        public boolean isOfficeBearerClf() {
            return officeBearerClf;
        }

        public void setOfficeBearerClf(boolean officeBearerClf) {
            this.officeBearerClf = officeBearerClf;
        }

        public String getEnterpriseType() {
            return enterpriseType;
        }

        public void setEnterpriseType(String enterpriseType) {
            this.enterpriseType = enterpriseType;
        }


        public String getEntrepreneurshipReason() {
            return entrepreneurshipReason;
        }

        public void setEntrepreneurshipReason(String entrepreneurshipReason) {
            this.entrepreneurshipReason = entrepreneurshipReason;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public Long getTypeOfUnitId() {
            return typeOfUnitId;
        }

        public Long getShgMemberRelationshipId() {
            return shgMemberRelationshipId;
        }

        public void setShgMemberRelationshipId(Long shgMemberRelationshipId) {
            this.shgMemberRelationshipId = shgMemberRelationshipId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
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

        public void setVillageId(Long villageId) {
            this.villageId = villageId;
        }

        public Long getBlockId() {
            return blockId;
        }

        public void setBlockId(Long blockId) {
            this.blockId = blockId;
        }

        public Long getDistrictId() {
            return districtId;
        }

        public void setDistrictId(Long districtId) {
            this.districtId = districtId;
        }

        public Long getStateId() {
            return stateId;
        }

        public void setStateId(Long stateId) {
            this.stateId = stateId;
        }

        public Long getReligionId() {
            return religionId;
        }

        public void setReligionId(Long religionId) {
            this.religionId = religionId;
        }

        public Long getCasteId() {
            return casteId;
        }

        public void setCasteId(Long casteId) {
            this.casteId = casteId;
        }

        public void setSocialGroupId(Long socialGroupId) {
            this.socialGroupId = socialGroupId;
        }

        public void setGramPanchayatId(String gramPanchayatId) {
            this.gramPanchayatId = gramPanchayatId;
        }

        public void setTrainingAttanded(String trainingAttanded) {
            this.trainingAttanded = trainingAttanded;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getShgMemberName() {
            return shgMemberName;
        }

        public void setShgMemberName(String shgMemberName) {
            this.shgMemberName = shgMemberName;
        }

        public long getShgMemberSince() {
            return shgMemberSince;
        }

        public void setShgMemberSince(long shgMemberSince) {
            this.shgMemberSince = shgMemberSince;
        }

        public String getShgPosition() {
            return shgPosition;
        }

        public void setShgPosition(String shgPosition) {
            this.shgPosition = shgPosition;
        }

        public String getVoPosition() {
            return voPosition;
        }

        public void setVoPosition(String voPosition) {
            this.voPosition = voPosition;
        }

        public String getClfPosition() {
            return clfPosition;
        }

        public void setClfPosition(String clfPosition) {
            this.clfPosition = clfPosition;
        }

        public String getAspirationalIncome() {
            return aspirationalIncome;
        }

        public void setAspirationalIncome(String aspirationalIncome) {
            this.aspirationalIncome = aspirationalIncome;
        }

        public String getPreviousIncome() {
            return previousIncome;
        }

        public void setPreviousIncome(String previousIncome) {
            this.previousIncome = previousIncome;
        }

        public void setTypeOfUnitId(Long typeOfUnitId) {
            this.typeOfUnitId = typeOfUnitId;
        }

        public String getGrampachaytName() {
            return grampachaytName;
        }

        public void setGrampachaytName(String grampachaytName) {
            this.grampachaytName = grampachaytName;
        }

        public String getSocialGroup() {
            return socialGroup;
        }

        public void setSocialGroup(String socialGroup) {
            this.socialGroup = socialGroup;
        }

        public String getVoName() {
            return voName;
        }

        public void setVoName(String voName) {
            this.voName = voName;
        }

        public EnterpriseDTO getEnterpriseDTO() {
            return enterpriseDTO;
        }

        public void setEnterpriseDTO(EnterpriseDTO enterpriseDTO) {
            this.enterpriseDTO = enterpriseDTO;
        }

        public ShgUserDTOBean getShgUserDTO() {
            return shgUserDTO;
        }

        public void setShgUserDTO(ShgUserDTOBean shgUserDTO) {
            this.shgUserDTO = shgUserDTO;
        }

        public VoUserDTOBean getVoUserDTO() {
            return voUserDTO;
        }

        public void setVoUserDTO(VoUserDTOBean voUserDTO) {
            this.voUserDTO = voUserDTO;
        }

        public ClfUserDTOBean getClfUserDTO() {
            return clfUserDTO;
        }

        public void setClfUserDTO(ClfUserDTOBean clfUserDTO) {
            this.clfUserDTO = clfUserDTO;
        }

        public boolean isGroup() {
            return group;
        }

        public void setGroup(boolean group) {
            this.group = group;
        }

        public boolean isMainEntrepreneur() {
            return mainEntrepreneur;
        }

        public void setMainEntrepreneur(boolean mainEntrepreneur) {
            this.mainEntrepreneur = mainEntrepreneur;
        }

        public boolean isSHGMember() {
            return isSHGMember;
        }

        public void setSHGMember(boolean SHGMember) {
            isSHGMember = SHGMember;
        }

        public boolean isBPLCardholder() {
            return isBPLCardholder;
        }

        public void setBPLCardholder(boolean BPLCardholder) {
            isBPLCardholder = BPLCardholder;
        }

        public int getAutoId() {
            return autoId;
        }

        public void setAutoId(int autoId) {
            this.autoId = autoId;
        }

        public Long getModifiedBy() {
            return modifiedBy;
        }

        public void setModifiedBy(Long modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public String getOccupations() {
            return occupations;
        }

        public void setOccupations(String occupations) {
            this.occupations = occupations;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getRelationship() {
            return relationship;
        }

        public void setRelationship(String relationship) {
            this.relationship = relationship;
        }

        public String getEntrepreneurRelationship() {
            return entrepreneurRelationship;
        }

        public void setEntrepreneurRelationship(String entrepreneurRelationship) {
            this.entrepreneurRelationship = entrepreneurRelationship;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public String getIncomeSource() {
            return incomeSource;
        }

        public void setIncomeSource(String incomeSource) {
            this.incomeSource = incomeSource;
        }

        public int getActiveDaysOfMonth() {
            return activeDaysOfMonth;
        }

        public void setActiveDaysOfMonth(int activeDaysOfMonth) {
            this.activeDaysOfMonth = activeDaysOfMonth;
        }

        public int getActiveMonthsOfYear() {
            return activeMonthsOfYear;
        }

        public void setActiveMonthsOfYear(int activeMonthsOfYear) {
            this.activeMonthsOfYear = activeMonthsOfYear;
        }

        public Double getIncomePerDay() {
            return incomePerDay;
        }

        public void setIncomePerDay(Double incomePerDay) {
            this.incomePerDay = incomePerDay;
        }

        public Double getAnnualIncome() {
            return annualIncome;
        }

        public void setAnnualIncome(Double annualIncome) {
            this.annualIncome = annualIncome;
        }

        public Long getFamilyMemberId() {
            return familyMemberId;
        }

        public void setFamilyMemberId(Long familyMemberId) {
            this.familyMemberId = familyMemberId;
        }

        public LoanTypeBean getLoanType() {
            return loanType;
        }

        public void setLoanType(LoanTypeBean loanType) {
            this.loanType = loanType;
        }

        public Long getLoanTypeIdGet() {
            return LoanTypeIdGet;
        }

        public void setLoanTypeIdGet(Long loanTypeIdGet) {
            LoanTypeIdGet = loanTypeIdGet;
        }

        public String getLoanTypeName() {
            return LoanTypeName;
        }

        public void setLoanTypeName(String loanTypeName) {
            LoanTypeName = loanTypeName;
        }

        public long getLoanStartDate() {
            return loanStartDate;
        }

        public void setLoanStartDate(long loanStartDate) {
            this.loanStartDate = loanStartDate;
        }

        public long getLoanEndDate() {
            return loanEndDate;
        }

        public String getLoanTypeCreditHistory() {
            return loanTypeCreditHistory;
        }

        public void setLoanTypeCreditHistory(String loanTypeCreditHistory) {
            this.loanTypeCreditHistory = loanTypeCreditHistory;
        }

        public void setLoanEndDate(long loanEndDate) {
            this.loanEndDate = loanEndDate;
        }

        public int getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(int interestRate) {
            this.interestRate = interestRate;
        }

        public Double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(Double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public Double getCurrentOutstanding() {
            return currentOutstanding;
        }

        public void setCurrentOutstanding(Double currentOutstanding) {
            this.currentOutstanding = currentOutstanding;
        }

        public boolean isLoanStatus() {
            return loanStatus;
        }

        public void setLoanStatus(boolean loanStatus) {
            this.loanStatus = loanStatus;
        }

        public Double getEmiAmount() {
            return emiAmount;
        }

        public void setEmiAmount(Double emiAmount) {
            this.emiAmount = emiAmount;
        }

        public Long getLoanTypeId() {
            return loanTypeId;
        }

        public void setLoanTypeId(Long loanTypeId) {
            this.loanTypeId = loanTypeId;
        }

        public static class LoanTypeBean implements Serializable {


            private Long id;
            private String name;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
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

        public Double getAnnualExpence() {
            return annualExpence;
        }

        public void setAnnualExpence(Double annualExpence) {
            this.annualExpence = annualExpence;
        }

        public Long getItemTypeId() {
            return itemTypeId;
        }

        public void setItemTypeId(Long itemTypeId) {
            this.itemTypeId = itemTypeId;
        }

        public String getNameOfEntrepreneur() {
            return nameOfEntrepreneur;
        }

        public void setNameOfEntrepreneur(String nameOfEntrepreneur) {
            this.nameOfEntrepreneur = nameOfEntrepreneur;
        }

        public long getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(long dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Long getBusinessPlanId() {
            return businessPlanId;
        }

        public void setBusinessPlanId(Long businessPlanId) {
            this.businessPlanId = businessPlanId;
        }

        public Long getExecutiveProjectSummaryId() {
            return executiveProjectSummaryId;
        }

        public void setExecutiveProjectSummaryId(Long executiveProjectSummaryId) {
            this.executiveProjectSummaryId = executiveProjectSummaryId;
        }

        public String getExecutiveProjectSummary() {
            return executiveProjectSummary;
        }

        public void setExecutiveProjectSummary(String executiveProjectSummary) {
            this.executiveProjectSummary = executiveProjectSummary;
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

        public Long getNatureOfUnitId() {
            return natureOfUnitId;
        }

        public void setNatureOfUnitId(Long natureOfUnitId) {
            this.natureOfUnitId = natureOfUnitId;
        }

        public String getNatureOfUnitName() {
            return natureOfUnitName;
        }

        public void setNatureOfUnitName(String natureOfUnitName) {
            this.natureOfUnitName = natureOfUnitName;
        }

        public Long getPlaceId() {
            return placeId;
        }

        public void setPlaceId(Long placeId) {
            this.placeId = placeId;
        }

        public String getTypeOfUnitName() {
            return typeOfUnitName;
        }

        public void setTypeOfUnitName(String typeOfUnitName) {
            this.typeOfUnitName = typeOfUnitName;
        }

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Long getGrampanchayatId() {
            return grampanchayatId;
        }

        public void setGrampanchayatId(Long grampanchayatId) {
            this.grampanchayatId = grampanchayatId;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public double getTransportation() {
            return transportation;
        }

        public void setTransportation(double transportation) {
            this.transportation = transportation;
        }

        public double getInsurance() {
            return insurance;
        }

        public void setInsurance(double insurance) {
            this.insurance = insurance;
        }

        public double getElectrificationExpense() {
            return electrificationExpense;
        }

        public void setElectrificationExpense(double electrificationExpense) {
            this.electrificationExpense = electrificationExpense;
        }

        public long getReasonId() {
            return reasonId;
        }

        public void setReasonId(long reasonId) {
            this.reasonId = reasonId;
        }

        public File getMomFile() {
            return momFile;
        }

        public void setMomFile(File momFile) {
            this.momFile = momFile;
        }

        public double getCurrentOutstandingCH() {
            return currentOutstandingCH;
        }

        public void setCurrentOutstandingCH(double currentOutstandingCH) {
            this.currentOutstandingCH = currentOutstandingCH;
        }

        public double getEmiAmountCH() {
            return emiAmountCH;
        }

        public void setEmiAmountCH(double emiAmountCH) {
            this.emiAmountCH = emiAmountCH;
        }

        public double getLoanAmountCH() {
            return loanAmountCH;
        }

        public void setLoanAmountCH(double loanAmountCH) {
            this.loanAmountCH = loanAmountCH;
        }

        public long getLoanEndDateCH() {
            return loanEndDateCH;
        }

        public void setLoanEndDateCH(long loanEndDateCH) {
            this.loanEndDateCH = loanEndDateCH;
        }

        public long getLoanStartDateCH() {
            return loanStartDateCH;
        }

        public void setLoanStartDateCH(long loanStartDateCH) {
            this.loanStartDateCH = loanStartDateCH;
        }

        public double getIntrestRateCH() {
            return intrestRateCH;
        }

        public void setIntrestRateCH(double intrestRateCH) {
            this.intrestRateCH = intrestRateCH;
        }

        public double getEstablishedProductionCapacityTotal() {
            return establishedProductionCapacityTotal;
        }

        public void setEstablishedProductionCapacityTotal(double establishedProductionCapacityTotal) {
            this.establishedProductionCapacityTotal = establishedProductionCapacityTotal;
        }

        public double getUtilizationCapacityTotal() {
            return utilizationCapacityTotal;
        }

        public void setUtilizationCapacityTotal(double utilizationCapacityTotal) {
            this.utilizationCapacityTotal = utilizationCapacityTotal;
        }

        public double getSalesRevenueTotal() {
            return salesRevenueTotal;
        }

        public void setSalesRevenueTotal(double salesRevenueTotal) {
            this.salesRevenueTotal = salesRevenueTotal;
        }

        public double getSalesRealisationTotal() {
            return salesRealisationTotal;
        }

        public void setSalesRealisationTotal(double salesRealisationTotal) {
            this.salesRealisationTotal = salesRealisationTotal;
        }

        public double getPreoperativeExpenditureTotal() {
            return preoperativeExpenditureTotal;
        }

        public void setPreoperativeExpenditureTotal(double preoperativeExpenditureTotal) {
            this.preoperativeExpenditureTotal = preoperativeExpenditureTotal;
        }

        public double getLandandBuildingExpTotal() {
            return landandBuildingExpTotal;
        }

        public void setLandandBuildingExpTotal(double landandBuildingExpTotal) {
            this.landandBuildingExpTotal = landandBuildingExpTotal;
        }

        public double getMachineryTotal() {
            return machineryTotal;
        }

        public void setMachineryTotal(double machineryTotal) {
            this.machineryTotal = machineryTotal;
        }

        public double getMachineryExpenseTotal() {
            return machineryExpenseTotal;
        }

        public void setMachineryExpenseTotal(double machineryExpenseTotal) {
            this.machineryExpenseTotal = machineryExpenseTotal;
        }

        public double getEquipmentandFurnitureTotal() {
            return equipmentandFurnitureTotal;
        }

        public void setEquipmentandFurnitureTotal(double equipmentandFurnitureTotal) {
            this.equipmentandFurnitureTotal = equipmentandFurnitureTotal;
        }

        public double getRawMaterialTotal() {
            return rawMaterialTotal;
        }

        public void setRawMaterialTotal(double rawMaterialTotal) {
            this.rawMaterialTotal = rawMaterialTotal;
        }

        public double getUtilitiesTotal() {
            return utilitiesTotal;
        }

        public void setUtilitiesTotal(double utilitiesTotal) {
            this.utilitiesTotal = utilitiesTotal;
        }

        public double getManpowerTotal() {
            return manpowerTotal;
        }

        public void setManpowerTotal(double manpowerTotal) {
            this.manpowerTotal = manpowerTotal;
        }

        public double getAdministrativeExpensesTotal() {
            return administrativeExpensesTotal;
        }

        public void setAdministrativeExpensesTotal(double administrativeExpensesTotal) {
            this.administrativeExpensesTotal = administrativeExpensesTotal;
        }

        public double getSellingAndDistributionExpensesTotal() {
            return sellingAndDistributionExpensesTotal;
        }

        public void setSellingAndDistributionExpensesTotal(double sellingAndDistributionExpensesTotal) {
            this.sellingAndDistributionExpensesTotal = sellingAndDistributionExpensesTotal;
        }

        public double getDepreciationTotal() {
            return depreciationTotal;
        }

        public void setDepreciationTotal(double depreciationTotal) {
            this.depreciationTotal = depreciationTotal;
        }

        public double getWorkingCapitalTotal() {
            return workingCapitalTotal;
        }

        public void setWorkingCapitalTotal(double workingCapitalTotal) {
            this.workingCapitalTotal = workingCapitalTotal;
        }

        public double getMeansOfFinanceTotal() {
            return meansOfFinanceTotal;
        }

        public void setMeansOfFinanceTotal(double meansOfFinanceTotal) {
            this.meansOfFinanceTotal = meansOfFinanceTotal;
        }

        public double getInterestTotal() {
            return interestTotal;
        }

        public void setInterestTotal(double interestTotal) {
            this.interestTotal = interestTotal;
        }

        public double getRentTotal() {
            return rentTotal;
        }

        public void setRentTotal(double rentTotal) {
            this.rentTotal = rentTotal;
        }

        public double getMiscTotal() {
            return miscTotal;
        }

        public void setMiscTotal(double miscTotal) {
            this.miscTotal = miscTotal;
        }

        public double getOtherTotalIncome() {
            return otherTotalIncome;
        }

        public void setOtherTotalIncome(double otherTotalIncome) {
            this.otherTotalIncome = otherTotalIncome;
        }

        public double getProtabilityProjectionTotal() {
            return protabilityProjectionTotal;
        }

        public void setProtabilityProjectionTotal(double protabilityProjectionTotal) {
            this.protabilityProjectionTotal = protabilityProjectionTotal;
        }

        public double getGrossProfitLossTotal() {
            return grossProfitLossTotal;
        }

        public void setGrossProfitLossTotal(double grossProfitLossTotal) {
            this.grossProfitLossTotal = grossProfitLossTotal;
        }

        public double getRevenueDecreaseTwentyPercent() {
            return revenueDecreaseTwentyPercent;
        }

        public void setRevenueDecreaseTwentyPercent(double revenueDecreaseTwentyPercent) {
            this.revenueDecreaseTwentyPercent = revenueDecreaseTwentyPercent;
        }

        public double getRevenueDecreaseTenPercent() {
            return revenueDecreaseTenPercent;
        }

        public void setRevenueDecreaseTenPercent(double revenueDecreaseTenPercent) {
            this.revenueDecreaseTenPercent = revenueDecreaseTenPercent;
        }

        public double getRevenueIncreaseTenPercent() {
            return revenueIncreaseTenPercent;
        }

        public void setRevenueIncreaseTenPercent(double revenueIncreaseTenPercent) {
            this.revenueIncreaseTenPercent = revenueIncreaseTenPercent;
        }

        public double getTotalFamilyIncome() {
            return totalFamilyIncome;
        }

        public void setTotalFamilyIncome(double totalFamilyIncome) {
            this.totalFamilyIncome = totalFamilyIncome;
        }

        public double getTotalExpanditure() {
            return totalExpanditure;
        }

        public void setTotalExpanditure(double totalExpanditure) {
            this.totalExpanditure = totalExpanditure;
        }

        public double getTotalLoanAmount() {
            return totalLoanAmount;
        }

        public void setTotalLoanAmount(double totalLoanAmount) {
            this.totalLoanAmount = totalLoanAmount;
        }

        public double getCurrentLoan() {
            return currentLoan;
        }

        public void setCurrentLoan(double currentLoan) {
            this.currentLoan = currentLoan;
        }

        public double getTotalCurrentLoanOutstanding() {
            return totalCurrentLoanOutstanding;
        }

        public void setTotalCurrentLoanOutstanding(double totalCurrentLoanOutstanding) {
            this.totalCurrentLoanOutstanding = totalCurrentLoanOutstanding;
        }

        public double getAnnualNetFamilyIncome() {
            return annualNetFamilyIncome;
        }

        public void setAnnualNetFamilyIncome(double annualNetFamilyIncome) {
            this.annualNetFamilyIncome = annualNetFamilyIncome;
        }

        public double getVariableCostIncreaseTwentyPercent() {
            return VariableCostIncreaseTwentyPercent;
        }

        public void setVariableCostIncreaseTwentyPercent(double variableCostIncreaseTwentyPercent) {
            VariableCostIncreaseTwentyPercent = variableCostIncreaseTwentyPercent;
        }

        public double getVariableCostIncreaseTenPercent() {
            return VariableCostIncreaseTenPercent;
        }

        public void setVariableCostIncreaseTenPercent(double variableCostIncreaseTenPercent) {
            VariableCostIncreaseTenPercent = variableCostIncreaseTenPercent;
        }

        public double getVariableCostDecreseFivePercent() {
            return VariableCostDecreseFivePercent;
        }

        public void setVariableCostDecreseFivePercent(double variableCostDecreseFivePercent) {
            VariableCostDecreseFivePercent = variableCostDecreseFivePercent;
        }

        public String getBlockName() {
            return blockName;
        }

        public void setBlockName(String blockName) {
            this.blockName = blockName;
        }

        public Long getDate() {
            return date;
        }

        public void setDate(Long date) {
            this.date = date;
        }

        public Long getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(Long applicationId) {
            this.applicationId = applicationId;
        }

        public Long getLoanApplicationId() {
            return loanApplicationId;
        }

        public void setLoanApplicationId(Long loanApplicationId) {
            this.loanApplicationId = loanApplicationId;
        }

        public String getBusinessActivity() {
            return businessActivity;
        }

        public void setBusinessActivity(String businessActivity) {
            this.businessActivity = businessActivity;
        }

        public String getBusinessActivityExisting() {
            return businessActivityExisting;
        }

        public void setBusinessActivityExisting(String businessActivityExisting) {
            this.businessActivityExisting = businessActivityExisting;
        }

        public double getPeriod() {
            return period;
        }

        public void setPeriod(double period) {
            this.period = period;
        }

        public String getProposed() {
            return proposed;
        }

        public void setProposed(String proposed) {
            this.proposed = proposed;
        }

        public String getBusinessExperience() {
            return businessExperience;
        }

        public void setBusinessExperience(String businessExperience) {
            this.businessExperience = businessExperience;
        }

        public double getNetSalePastYear() {
            return netSalePastYear;
        }

        public void setNetSalePastYear(double netSalePastYear) {
            this.netSalePastYear = netSalePastYear;
        }

        public double getNetSalePresentYear() {
            return netSalePresentYear;
        }

        public void setNetSalePresentYear(double netSalePresentYear) {
            this.netSalePresentYear = netSalePresentYear;
        }

        public double getNetSaleNextyear() {
            return netSaleNextyear;
        }

        public void setNetSaleNextyear(double netSaleNextyear) {
            this.netSaleNextyear = netSaleNextyear;
        }

        public double getNetProfitPastYear() {
            return netProfitPastYear;
        }

        public void setNetProfitPastYear(double netProfitPastYear) {
            this.netProfitPastYear = netProfitPastYear;
        }

        public double getNetProfitPresentYear() {
            return netProfitPresentYear;
        }

        public void setNetProfitPresentYear(double netProfitPresentYear) {
            this.netProfitPresentYear = netProfitPresentYear;
        }

        public double getNetProfitNextYear() {
            return netProfitNextYear;
        }

        public void setNetProfitNextYear(double netProfitNextYear) {
            this.netProfitNextYear = netProfitNextYear;
        }

        public String getSavingAccountName() {
            return savingAccountName;
        }

        public void setSavingAccountName(String savingAccountName) {
            this.savingAccountName = savingAccountName;
        }

        public double getSavingAccountOutstandingAmout() {
            return savingAccountOutstandingAmout;
        }

        public void setSavingAccountOutstandingAmout(double savingAccountOutstandingAmout) {
            this.savingAccountOutstandingAmout = savingAccountOutstandingAmout;
        }

        public String getSavingAccountCustomerDetail() {
            return savingAccountCustomerDetail;
        }

        public void setSavingAccountCustomerDetail(String savingAccountCustomerDetail) {
            this.savingAccountCustomerDetail = savingAccountCustomerDetail;
        }

        public String getShgLoanName() {
            return shgLoanName;
        }

        public void setShgLoanName(String shgLoanName) {
            this.shgLoanName = shgLoanName;
        }

        public double getShgLoanOutstandingAmount() {
            return shgLoanOutstandingAmount;
        }

        public void setShgLoanOutstandingAmount(double shgLoanOutstandingAmount) {
            this.shgLoanOutstandingAmount = shgLoanOutstandingAmount;
        }

        public String getShgLoanCustomerDetail() {
            return shgLoanCustomerDetail;
        }

        public void setShgLoanCustomerDetail(String shgLoanCustomerDetail) {
            this.shgLoanCustomerDetail = shgLoanCustomerDetail;
        }

        public String getOthersName() {
            return othersName;
        }

        public void setOthersName(String othersName) {
            this.othersName = othersName;
        }

        public double getOthersOutstandingAmount() {
            return othersOutstandingAmount;
        }

        public void setOthersOutstandingAmount(double othersOutstandingAmount) {
            this.othersOutstandingAmount = othersOutstandingAmount;
        }

        public String getOthersCustomerDetail() {
            return othersCustomerDetail;
        }

        public void setOthersCustomerDetail(String othersCustomerDetail) {
            this.othersCustomerDetail = othersCustomerDetail;
        }

        public int getSavingAccountIntrestRate() {
            return savingAccountIntrestRate;
        }

        public void setSavingAccountIntrestRate(int savingAccountIntrestRate) {
            this.savingAccountIntrestRate = savingAccountIntrestRate;
        }

        public int getShgIntrestRate() {
            return shgIntrestRate;
        }

        public void setShgIntrestRate(int shgIntrestRate) {
            this.shgIntrestRate = shgIntrestRate;
        }

        public int getOthersIntrestRate() {
            return othersIntrestRate;
        }

        public void setOthersIntrestRate(int othersIntrestRate) {
            this.othersIntrestRate = othersIntrestRate;
        }

        public String getApplyingFor() {
            return applyingFor;
        }

        public void setApplyingFor(String applyingFor) {
            this.applyingFor = applyingFor;
        }

        public String getTelephoneNo() {
            return telephoneNo;
        }

        public void setTelephoneNo(String telephoneNo) {
            this.telephoneNo = telephoneNo;
        }

        public String getAddressProof() {
            return addressProof;
        }

        public void setAddressProof(String addressProof) {
            this.addressProof = addressProof;
        }

        public String getSocialCategory() {
            return socialCategory;
        }

        public void setSocialCategory(String socialCategory) {
            this.socialCategory = socialCategory;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getPurposeOfLoan() {
            return purposeOfLoan;
        }

        public void setPurposeOfLoan(String purposeOfLoan) {
            this.purposeOfLoan = purposeOfLoan;
        }

        public double getLoanAmountCEF() {
            return loanAmountCEF;
        }

        public void setLoanAmountCEF(double loanAmountCEF) {
            this.loanAmountCEF = loanAmountCEF;
        }

        public double getLoanAmountOther() {
            return loanAmountOther;
        }

        public void setLoanAmountOther(double loanAmountOther) {
            this.loanAmountOther = loanAmountOther;
        }

        public String getRegisterNo() {
            return registerNo;
        }

        public void setRegisterNo(String registerNo) {
            this.registerNo = registerNo;
        }

        public long getLicenseDate() {
            return licenseDate;
        }

        public void setLicenseDate(long licenseDate) {
            this.licenseDate = licenseDate;
        }

        public double getLoanDisbursalAmount() {
            return loanDisbursalAmount;
        }

        public void setLoanDisbursalAmount(double loanDisbursalAmount) {
            this.loanDisbursalAmount = loanDisbursalAmount;
        }

        public String getLoanCriteria() {
            return loanCriteria;
        }

        public void setLoanCriteria(String loanCriteria) {
            this.loanCriteria = loanCriteria;
        }

        public Date getLoanDisbursalDate() {
            return loanDisbursalDate;
        }

        public void setLoanDisbursalDate(Date loanDisbursalDate) {
            this.loanDisbursalDate = loanDisbursalDate;
        }

        public double getApproveLoanAmount() {
            return approveLoanAmount;
        }

        public void setApproveLoanAmount(double approveLoanAmount) {
            this.approveLoanAmount = approveLoanAmount;
        }

        public double getMoretoriumPeriod() {
            return moretoriumPeriod;
        }

        public void setMoretoriumPeriod(double moretoriumPeriod) {
            this.moretoriumPeriod = moretoriumPeriod;
        }

        public double getNoOfInstallments() {
            return noOfInstallments;
        }

        public void setNoOfInstallments(double noOfInstallments) {
            this.noOfInstallments = noOfInstallments;
        }

        public double getSuggestedPaybackAmount() {
            return suggestedPaybackAmount;
        }

        public void setSuggestedPaybackAmount(double suggestedPaybackAmount) {
            this.suggestedPaybackAmount = suggestedPaybackAmount;
        }

        public double getApprovedLoanAmount() {
            return approvedLoanAmount;
        }

        public void setApprovedLoanAmount(double approvedLoanAmount) {
            this.approvedLoanAmount = approvedLoanAmount;
        }

        public List<Integer> getRemainingEmiList() {
            return remainingEmiList;
        }

        public void setRemainingEmiList(List<Integer> remainingEmiList) {
            this.remainingEmiList = remainingEmiList;
        }

        public double getAnnualDebtRepaymentTotal() {
            return annualDebtRepaymentTotal;
        }

        public void setAnnualDebtRepaymentTotal(double annualDebtRepaymentTotal) {
            this.annualDebtRepaymentTotal = annualDebtRepaymentTotal;
        }

        public List<String> getLoanTypeNameList() {
            return loanTypeNameList;
        }

        public void setLoanTypeNameList(List<String> loanTypeNameList) {
            this.loanTypeNameList = loanTypeNameList;
        }

        public List<ProductionDetailsModel> getEstablishedProductionCapacityList() {
            return establishedProductionCapacityList;
        }

        public void setEstablishedProductionCapacityList(List<ProductionDetailsModel> establishedProductionCapacityList) {
            this.establishedProductionCapacityList = establishedProductionCapacityList;
        }

        public List<SelectedParticularsModel> getPreoperativeExpenditureList() {
            return preoperativeExpenditureList;
        }

        public void setPreoperativeExpenditureList(List<SelectedParticularsModel> preoperativeExpenditureList) {
            this.preoperativeExpenditureList = preoperativeExpenditureList;
        }

        public List<LandBuildingModel> getLandBuildingExpensesList() {
            return landBuildingExpensesList;
        }

        public void setLandBuildingExpensesList(List<LandBuildingModel> landBuildingExpensesList) {
            this.landBuildingExpensesList = landBuildingExpensesList;
        }

        public List<MachinaryModel> getMachineryList() {
            return machineryList;
        }

        public void setMachineryList(List<MachinaryModel> machineryList) {
            this.machineryList = machineryList;
        }

        public List<EquipmentFurnitureModel> getEquipmentFurnitureList() {
            return equipmentFurnitureList;
        }

        public void setEquipmentFurnitureList(List<EquipmentFurnitureModel> equipmentFurnitureList) {
            this.equipmentFurnitureList = equipmentFurnitureList;
        }

        public List<RawMaterialModel> getRawMaterialList() {
            return rawMaterialList;
        }

        public void setRawMaterialList(List<RawMaterialModel> rawMaterialList) {
            this.rawMaterialList = rawMaterialList;
        }

        public List<UtilitiesModel> getUtilitiesList() {
            return utilitiesList;
        }

        public void setUtilitiesList(List<UtilitiesModel> utilitiesList) {
            this.utilitiesList = utilitiesList;
        }

        public List<ManPowerModel> getManpowerList() {
            return manpowerList;
        }

        public void setManpowerList(List<ManPowerModel> manpowerList) {
            this.manpowerList = manpowerList;
        }

        public List<AdministrativeModel> getAdministrativeExpensesList() {
            return administrativeExpensesList;
        }

        public void setAdministrativeExpensesList(List<AdministrativeModel> administrativeExpensesList) {
            this.administrativeExpensesList = administrativeExpensesList;
        }

        public List<SellingDistributionExpensModel> getSellingDistributionExpensesList() {
            return sellingDistributionExpensesList;
        }

        public void setSellingDistributionExpensesList(List<SellingDistributionExpensModel> sellingDistributionExpensesList) {
            this.sellingDistributionExpensesList = sellingDistributionExpensesList;
        }

        public List<DepricationModel> getDepreciationList() {
            return depreciationList;
        }

        public void setDepreciationList(List<DepricationModel> depreciationList) {
            this.depreciationList = depreciationList;
        }

        public List<WorkingCapitalModel> getWorkingCapitalList() {
            return workingCapitalList;
        }

        public void setWorkingCapitalList(List<WorkingCapitalModel> workingCapitalList) {
            this.workingCapitalList = workingCapitalList;
        }

        public List<SalesRealisationModel> getBpSalesRealisationList() {
            return bpSalesRealisationList;
        }

        public void setBpSalesRealisationList(List<SalesRealisationModel> bpSalesRealisationList) {
            this.bpSalesRealisationList = bpSalesRealisationList;
        }

        public List<MeansOfFinanceModel> getFinanceMeansList() {
            return financeMeansList;
        }

        public void setFinanceMeansList(List<MeansOfFinanceModel> financeMeansList) {
            this.financeMeansList = financeMeansList;
        }

        public List<IntrestModel> getInterestList() {
            return interestList;
        }

        public void setInterestList(List<IntrestModel> interestList) {
            this.interestList = interestList;
        }

        public List<FamilyMembersBean> getFamilyMembers() {
            return familyMembers;
        }

        public void setFamilyMembers(List<FamilyMembersBean> familyMembers) {
            this.familyMembers = familyMembers;
        }

        public List<FamilyExpendituresBean> getFamilyExpenditures() {
            return familyExpenditures;
        }

        public void setFamilyExpenditures(List<FamilyExpendituresBean> familyExpenditures) {
            this.familyExpenditures = familyExpenditures;
        }

        public List<FamilyIncomeBean> getFamilyIncomes() {
            return familyIncomes;
        }

        public void setFamilyIncomes(List<FamilyIncomeBean> familyIncomes) {
            this.familyIncomes = familyIncomes;
        }

        public List<ListCreditHistoryBean> getListCreditHistory() {
            return listCreditHistory;
        }

        public void setListCreditHistory(List<ListCreditHistoryBean> listCreditHistory) {
            this.listCreditHistory = listCreditHistory;
        }

        public List<?> getListGrowthPlan() {
            return listGrowthPlan;
        }

        public void setListGrowthPlan(List<?> listGrowthPlan) {
            this.listGrowthPlan = listGrowthPlan;
        }

        public List<ListEducationalQualificationBean> getListEducationalQualification() {
            return listEducationalQualification;
        }

        public void setListEducationalQualification(List<ListEducationalQualificationBean> listEducationalQualification) {
            this.listEducationalQualification = listEducationalQualification;
        }

        public List<ListSpecialTrainingBean> getListSpecialTraining() {
            return listSpecialTraining;
        }

        public void setListSpecialTraining(List<ListSpecialTrainingBean> listSpecialTraining) {
            this.listSpecialTraining = listSpecialTraining;
        }

        public List<ListWorkExperienceBean> getListWorkExperience() {
            return listWorkExperience;
        }

        public void setListWorkExperience(List<ListWorkExperienceBean> listWorkExperience) {
            this.listWorkExperience = listWorkExperience;
        }

        public BusinessPlanDTO getBusinessPlanDTO() {
            return businessPlanDTO;
        }

        public void setBusinessPlanDTO(BusinessPlanDTO businessPlanDTO) {
            this.businessPlanDTO = businessPlanDTO;
        }

        public static class BusinessPlanDTOBean implements Serializable {

            private Long businessPlanId;
            private String nameOfUnit;
            private String govtLicense;
            private String addressOfUnit;
            private Long entrepreneurId;
            private Long businessDescriptorId;
            private String businessDescriptorName;
            private Long natureOfUnitId;
            private String natureOfUnitName;
            private Long placeId;
            private Long typeOfUnitId;
            private String typeOfUnitName;
            private String placeName;
            private Long stateId;
            private Long districtId;
            private Long blockId;
            private Long villageId;
            private Long grampanchayatId;
            private String pincode;

            private Object nameOfEntrepreneur;
            private Object address;
            private Object firstName;
            private Object middleName;
            private Object lastName;
            private int dateOfBirth;
            private Object age;
            private Object executiveProjectSummaryId;
            private Object executiveProjectSummary;
            private Object status;
            private boolean reject;
            private boolean approve;
            private int whatIfProjectionRate;
            private int tax;
            private int transportation;
            private int insurance;
            private int electrificationExpense;
            private int reasonId;
            private Object momFile;
            private int currentOutstandingCH;
            private int emiAmountCH;
            private int loanAmountCH;
            private int loanEndDateCH;
            private int loanStartDateCH;
            private int intrestRateCH;
            private int establishedProductionCapacityTotal;
            private int utilizationCapacityTotal;
            private int salesRevenueTotal;
            private int salesRealisationTotal;
            private int preoperativeExpenditureTotal;
            private int landandBuildingExpTotal;
            private int machineryTotal;
            private int machineryExpenseTotal;
            private int equipmentandFurnitureTotal;
            private int rawMaterialTotal;
            private int utilitiesTotal;
            private int manpowerTotal;
            private int administrativeExpensesTotal;
            private int sellingAndDistributionExpensesTotal;
            private int depreciationTotal;
            private int workingCapitalTotal;
            private int meansOfFinanceTotal;
            private int interestTotal;
            private int rentTotal;
            private int miscTotal;
            private int otherTotalIncome;
            private int protabilityProjectionTotal;
            private int grossProfitLossTotal;
            private int revenueDecreaseTwentyPercent;
            private int revenueDecreaseTenPercent;
            private int revenueIncreaseTenPercent;
            private int totalFamilyIncome;
            private int totalExpanditure;
            private int totalLoanAmount;
            private int currentLoan;
            private int totalCurrentLoanOutstanding;
            private int annualNetFamilyIncome;
            private int totalEmiAmount;
            private int totalEmiAmountAnnual;
            private int netCashSurPlus;
            private int netSurPlusToSvepLoan;
            private int loanToGiven;
            private Object voName;
            private Object createdBy;
            private int createdDate;
            private Object shgName;
            private Object villageName;
            private Object blockName;
            private Object phoneNo;
            private Object emailId;
            private Object aadharNo;
            private Object education;
            private Object voterId;
            private Object panNo;
            private int enrollmentDate;
            private Object gender;
            private Object mgnregaNo;
            private Object artisanNo;
            private Object date;
            private Object applicationId;
            private Object loanApplicationId;
            private Object businessActivity;
            private Object businessActivityExisting;
            private int period;
            private Object proposed;
            private Object businessExperience;
            private int netSalePastYear;
            private int netSalePresentYear;
            private int netSaleNextyear;
            private int netProfitPastYear;
            private int netProfitPresentYear;
            private int netProfitNextYear;
            private Object savingAccountName;
            private int savingAccountOutstandingAmout;
            private Object savingAccountCustomerDetail;
            private Object shgLoanName;
            private int shgLoanOutstandingAmount;
            private Object shgLoanCustomerDetail;
            private Object othersName;
            private int othersOutstandingAmount;
            private Object othersCustomerDetail;
            private int loanAmount;
            private Object applyingFor;
            private Object telephoneNo;
            private Object addressProof;
            private Object socialCategory;
            private int flag;
            private Object purposeOfLoan;
            private int loanAmountCEF;
            private int loanAmountOther;
            private String registerNo;
            private Long licenseDate;
            private int loanDisbursalAmount;
            private Object loanCriteria;
            private Object loanDisbursalDate;
            private int opportunityHost;
            private int adjustedProfit;
            private int familyIncome;
            private int netProfit;
            private int loanRepayment;
            private int points;
            private Object remainingPoints;
            private Object worthiness;
            private Object loanStartDate;
            private int approveLoanAmount;
            private int interestRate;
            private int moretoriumPeriod;
            private int noOfInstallments;
            private int suggestedPaybackAmount;
            private int approvedLoanAmount;
            private int growthPotential;
            private int inflationRate;
            private int loanPayback;
            private boolean clfFlag;
            private Object remainingEmiList;
            private int annualDebtRepaymentTotal;
            private Object loanTypeNameList;
            private Object creditWorthyList;
            private Object masterBpPreoperativeExpenditureParticulars;
            private int variableCostIncreaseTwentyPercent;
            private int variableCostIncreaseTenPercent;
            private int variableCostDecreseFivePercent;

            private List<EstablishedProductionCapacityListBean> establishedProductionCapacityList;
            private List<PreoperativeExpenditureListBean> preoperativeExpenditureList;
            private List<LandBuildingExpensesListBean> landBuildingExpensesList;
            private List<MachineryListBean> machineryList;
            private List<EquipmentFurnitureListBean> equipmentFurnitureList;
            private List<RawMaterialListBean> rawMaterialList;
            private List<UtilitiesListBean> utilitiesList;
            private List<ManpowerListBean> manpowerList;
            private List<AdministrativeExpensesListBean> administrativeExpensesList;
            private List<SellingDistributionExpensesListBean> sellingDistributionExpensesList;
            private List<DepreciationListBean> depreciationList;
            private List<WorkingCapitalListBean> workingCapitalList;
            private List<BpSalesRealisationListBean> bpSalesRealisationList;
            private List<FinanceMeansListBean> financeMeansList;
            private List<InterestListBean> interestList;

            public Object getNameOfEntrepreneur() {
                return nameOfEntrepreneur;
            }

            public void setNameOfEntrepreneur(Object nameOfEntrepreneur) {
                this.nameOfEntrepreneur = nameOfEntrepreneur;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getFirstName() {
                return firstName;
            }

            public void setFirstName(Object firstName) {
                this.firstName = firstName;
            }

            public Object getMiddleName() {
                return middleName;
            }

            public void setMiddleName(Object middleName) {
                this.middleName = middleName;
            }

            public Object getLastName() {
                return lastName;
            }

            public void setLastName(Object lastName) {
                this.lastName = lastName;
            }

            public int getDateOfBirth() {
                return dateOfBirth;
            }

            public void setDateOfBirth(int dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }


            public Object getExecutiveProjectSummaryId() {
                return executiveProjectSummaryId;
            }

            public void setExecutiveProjectSummaryId(Object executiveProjectSummaryId) {
                this.executiveProjectSummaryId = executiveProjectSummaryId;
            }

            public Object getExecutiveProjectSummary() {
                return executiveProjectSummary;
            }

            public void setExecutiveProjectSummary(Object executiveProjectSummary) {
                this.executiveProjectSummary = executiveProjectSummary;
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


            public String getBusinessDescriptorName() {
                return businessDescriptorName;
            }

            public void setBusinessDescriptorName(String businessDescriptorName) {
                this.businessDescriptorName = businessDescriptorName;
            }

            public String getNatureOfUnitName() {
                return natureOfUnitName;
            }

            public void setNatureOfUnitName(String natureOfUnitName) {
                this.natureOfUnitName = natureOfUnitName;
            }

            public String getPlaceName() {
                return placeName;
            }

            public void setPlaceName(String placeName) {
                this.placeName = placeName;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }

            public Long getGrampanchayatId() {
                return grampanchayatId;
            }

            public void setGrampanchayatId(Long grampanchayatId) {
                this.grampanchayatId = grampanchayatId;
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

            public Long getNatureOfUnitId() {
                return natureOfUnitId;
            }

            public void setNatureOfUnitId(Long natureOfUnitId) {
                this.natureOfUnitId = natureOfUnitId;
            }

            public Long getPlaceId() {
                return placeId;
            }

            public void setPlaceId(Long placeId) {
                this.placeId = placeId;
            }

            public Long getTypeOfUnitId() {
                return typeOfUnitId;
            }

            public void setTypeOfUnitId(Long typeOfUnitId) {
                this.typeOfUnitId = typeOfUnitId;
            }

            public String getTypeOfUnitName() {
                return typeOfUnitName;
            }

            public void setTypeOfUnitName(String typeOfUnitName) {
                this.typeOfUnitName = typeOfUnitName;
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

            public boolean isReject() {
                return reject;
            }

            public void setReject(boolean reject) {
                this.reject = reject;
            }

            public boolean isApprove() {
                return approve;
            }

            public void setApprove(boolean approve) {
                this.approve = approve;
            }

            public int getWhatIfProjectionRate() {
                return whatIfProjectionRate;
            }

            public void setWhatIfProjectionRate(int whatIfProjectionRate) {
                this.whatIfProjectionRate = whatIfProjectionRate;
            }

            public int getTax() {
                return tax;
            }

            public void setTax(int tax) {
                this.tax = tax;
            }

            public int getTransportation() {
                return transportation;
            }

            public void setTransportation(int transportation) {
                this.transportation = transportation;
            }

            public int getInsurance() {
                return insurance;
            }

            public void setInsurance(int insurance) {
                this.insurance = insurance;
            }

            public int getElectrificationExpense() {
                return electrificationExpense;
            }

            public void setElectrificationExpense(int electrificationExpense) {
                this.electrificationExpense = electrificationExpense;
            }

            public int getReasonId() {
                return reasonId;
            }

            public void setReasonId(int reasonId) {
                this.reasonId = reasonId;
            }

            public Object getMomFile() {
                return momFile;
            }

            public void setMomFile(Object momFile) {
                this.momFile = momFile;
            }

            public int getCurrentOutstandingCH() {
                return currentOutstandingCH;
            }

            public void setCurrentOutstandingCH(int currentOutstandingCH) {
                this.currentOutstandingCH = currentOutstandingCH;
            }

            public int getEmiAmountCH() {
                return emiAmountCH;
            }

            public void setEmiAmountCH(int emiAmountCH) {
                this.emiAmountCH = emiAmountCH;
            }

            public int getLoanAmountCH() {
                return loanAmountCH;
            }

            public void setLoanAmountCH(int loanAmountCH) {
                this.loanAmountCH = loanAmountCH;
            }

            public int getLoanEndDateCH() {
                return loanEndDateCH;
            }

            public void setLoanEndDateCH(int loanEndDateCH) {
                this.loanEndDateCH = loanEndDateCH;
            }

            public int getLoanStartDateCH() {
                return loanStartDateCH;
            }

            public void setLoanStartDateCH(int loanStartDateCH) {
                this.loanStartDateCH = loanStartDateCH;
            }

            public int getIntrestRateCH() {
                return intrestRateCH;
            }

            public void setIntrestRateCH(int intrestRateCH) {
                this.intrestRateCH = intrestRateCH;
            }

            public int getEstablishedProductionCapacityTotal() {
                return establishedProductionCapacityTotal;
            }

            public void setEstablishedProductionCapacityTotal(int establishedProductionCapacityTotal) {
                this.establishedProductionCapacityTotal = establishedProductionCapacityTotal;
            }

            public int getUtilizationCapacityTotal() {
                return utilizationCapacityTotal;
            }

            public void setUtilizationCapacityTotal(int utilizationCapacityTotal) {
                this.utilizationCapacityTotal = utilizationCapacityTotal;
            }

            public int getSalesRevenueTotal() {
                return salesRevenueTotal;
            }

            public void setSalesRevenueTotal(int salesRevenueTotal) {
                this.salesRevenueTotal = salesRevenueTotal;
            }

            public int getSalesRealisationTotal() {
                return salesRealisationTotal;
            }

            public void setSalesRealisationTotal(int salesRealisationTotal) {
                this.salesRealisationTotal = salesRealisationTotal;
            }

            public int getPreoperativeExpenditureTotal() {
                return preoperativeExpenditureTotal;
            }

            public void setPreoperativeExpenditureTotal(int preoperativeExpenditureTotal) {
                this.preoperativeExpenditureTotal = preoperativeExpenditureTotal;
            }

            public int getLandandBuildingExpTotal() {
                return landandBuildingExpTotal;
            }

            public void setLandandBuildingExpTotal(int landandBuildingExpTotal) {
                this.landandBuildingExpTotal = landandBuildingExpTotal;
            }

            public int getMachineryTotal() {
                return machineryTotal;
            }

            public void setMachineryTotal(int machineryTotal) {
                this.machineryTotal = machineryTotal;
            }

            public int getMachineryExpenseTotal() {
                return machineryExpenseTotal;
            }

            public void setMachineryExpenseTotal(int machineryExpenseTotal) {
                this.machineryExpenseTotal = machineryExpenseTotal;
            }

            public int getEquipmentandFurnitureTotal() {
                return equipmentandFurnitureTotal;
            }

            public void setEquipmentandFurnitureTotal(int equipmentandFurnitureTotal) {
                this.equipmentandFurnitureTotal = equipmentandFurnitureTotal;
            }

            public int getRawMaterialTotal() {
                return rawMaterialTotal;
            }

            public void setRawMaterialTotal(int rawMaterialTotal) {
                this.rawMaterialTotal = rawMaterialTotal;
            }

            public int getUtilitiesTotal() {
                return utilitiesTotal;
            }

            public void setUtilitiesTotal(int utilitiesTotal) {
                this.utilitiesTotal = utilitiesTotal;
            }

            public int getManpowerTotal() {
                return manpowerTotal;
            }

            public void setManpowerTotal(int manpowerTotal) {
                this.manpowerTotal = manpowerTotal;
            }

            public int getAdministrativeExpensesTotal() {
                return administrativeExpensesTotal;
            }

            public void setAdministrativeExpensesTotal(int administrativeExpensesTotal) {
                this.administrativeExpensesTotal = administrativeExpensesTotal;
            }

            public int getSellingAndDistributionExpensesTotal() {
                return sellingAndDistributionExpensesTotal;
            }

            public void setSellingAndDistributionExpensesTotal(int sellingAndDistributionExpensesTotal) {
                this.sellingAndDistributionExpensesTotal = sellingAndDistributionExpensesTotal;
            }

            public int getDepreciationTotal() {
                return depreciationTotal;
            }

            public void setDepreciationTotal(int depreciationTotal) {
                this.depreciationTotal = depreciationTotal;
            }

            public int getWorkingCapitalTotal() {
                return workingCapitalTotal;
            }

            public void setWorkingCapitalTotal(int workingCapitalTotal) {
                this.workingCapitalTotal = workingCapitalTotal;
            }

            public int getMeansOfFinanceTotal() {
                return meansOfFinanceTotal;
            }

            public void setMeansOfFinanceTotal(int meansOfFinanceTotal) {
                this.meansOfFinanceTotal = meansOfFinanceTotal;
            }

            public int getInterestTotal() {
                return interestTotal;
            }

            public void setInterestTotal(int interestTotal) {
                this.interestTotal = interestTotal;
            }

            public int getRentTotal() {
                return rentTotal;
            }

            public void setRentTotal(int rentTotal) {
                this.rentTotal = rentTotal;
            }

            public int getMiscTotal() {
                return miscTotal;
            }

            public void setMiscTotal(int miscTotal) {
                this.miscTotal = miscTotal;
            }

            public int getOtherTotalIncome() {
                return otherTotalIncome;
            }

            public void setOtherTotalIncome(int otherTotalIncome) {
                this.otherTotalIncome = otherTotalIncome;
            }

            public int getProtabilityProjectionTotal() {
                return protabilityProjectionTotal;
            }

            public void setProtabilityProjectionTotal(int protabilityProjectionTotal) {
                this.protabilityProjectionTotal = protabilityProjectionTotal;
            }

            public int getGrossProfitLossTotal() {
                return grossProfitLossTotal;
            }

            public void setGrossProfitLossTotal(int grossProfitLossTotal) {
                this.grossProfitLossTotal = grossProfitLossTotal;
            }

            public int getRevenueDecreaseTwentyPercent() {
                return revenueDecreaseTwentyPercent;
            }

            public void setRevenueDecreaseTwentyPercent(int revenueDecreaseTwentyPercent) {
                this.revenueDecreaseTwentyPercent = revenueDecreaseTwentyPercent;
            }

            public int getRevenueDecreaseTenPercent() {
                return revenueDecreaseTenPercent;
            }

            public void setRevenueDecreaseTenPercent(int revenueDecreaseTenPercent) {
                this.revenueDecreaseTenPercent = revenueDecreaseTenPercent;
            }

            public int getRevenueIncreaseTenPercent() {
                return revenueIncreaseTenPercent;
            }

            public void setRevenueIncreaseTenPercent(int revenueIncreaseTenPercent) {
                this.revenueIncreaseTenPercent = revenueIncreaseTenPercent;
            }

            public int getTotalFamilyIncome() {
                return totalFamilyIncome;
            }

            public void setTotalFamilyIncome(int totalFamilyIncome) {
                this.totalFamilyIncome = totalFamilyIncome;
            }

            public int getTotalExpanditure() {
                return totalExpanditure;
            }

            public void setTotalExpanditure(int totalExpanditure) {
                this.totalExpanditure = totalExpanditure;
            }

            public int getTotalLoanAmount() {
                return totalLoanAmount;
            }

            public void setTotalLoanAmount(int totalLoanAmount) {
                this.totalLoanAmount = totalLoanAmount;
            }

            public int getCurrentLoan() {
                return currentLoan;
            }

            public void setCurrentLoan(int currentLoan) {
                this.currentLoan = currentLoan;
            }

            public int getTotalCurrentLoanOutstanding() {
                return totalCurrentLoanOutstanding;
            }

            public void setTotalCurrentLoanOutstanding(int totalCurrentLoanOutstanding) {
                this.totalCurrentLoanOutstanding = totalCurrentLoanOutstanding;
            }

            public int getAnnualNetFamilyIncome() {
                return annualNetFamilyIncome;
            }

            public void setAnnualNetFamilyIncome(int annualNetFamilyIncome) {
                this.annualNetFamilyIncome = annualNetFamilyIncome;
            }

            public int getTotalEmiAmount() {
                return totalEmiAmount;
            }

            public void setTotalEmiAmount(int totalEmiAmount) {
                this.totalEmiAmount = totalEmiAmount;
            }

            public int getTotalEmiAmountAnnual() {
                return totalEmiAmountAnnual;
            }

            public void setTotalEmiAmountAnnual(int totalEmiAmountAnnual) {
                this.totalEmiAmountAnnual = totalEmiAmountAnnual;
            }

            public int getNetCashSurPlus() {
                return netCashSurPlus;
            }

            public void setNetCashSurPlus(int netCashSurPlus) {
                this.netCashSurPlus = netCashSurPlus;
            }

            public int getNetSurPlusToSvepLoan() {
                return netSurPlusToSvepLoan;
            }

            public void setNetSurPlusToSvepLoan(int netSurPlusToSvepLoan) {
                this.netSurPlusToSvepLoan = netSurPlusToSvepLoan;
            }

            public int getLoanToGiven() {
                return loanToGiven;
            }

            public void setLoanToGiven(int loanToGiven) {
                this.loanToGiven = loanToGiven;
            }

            public Object getVoName() {
                return voName;
            }

            public void setVoName(Object voName) {
                this.voName = voName;
            }

            public Object getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(Object createdBy) {
                this.createdBy = createdBy;
            }

            public int getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(int createdDate) {
                this.createdDate = createdDate;
            }

            public Object getShgName() {
                return shgName;
            }

            public void setShgName(Object shgName) {
                this.shgName = shgName;
            }

            public Object getVillageName() {
                return villageName;
            }

            public void setVillageName(Object villageName) {
                this.villageName = villageName;
            }

            public Object getBlockName() {
                return blockName;
            }

            public void setBlockName(Object blockName) {
                this.blockName = blockName;
            }

            public Object getPhoneNo() {
                return phoneNo;
            }

            public void setPhoneNo(Object phoneNo) {
                this.phoneNo = phoneNo;
            }

            public Object getEmailId() {
                return emailId;
            }

            public void setEmailId(Object emailId) {
                this.emailId = emailId;
            }

            public Object getAadharNo() {
                return aadharNo;
            }

            public void setAadharNo(Object aadharNo) {
                this.aadharNo = aadharNo;
            }

            public Object getEducation() {
                return education;
            }

            public void setEducation(Object education) {
                this.education = education;
            }

            public Object getVoterId() {
                return voterId;
            }

            public void setVoterId(Object voterId) {
                this.voterId = voterId;
            }

            public Object getPanNo() {
                return panNo;
            }

            public void setPanNo(Object panNo) {
                this.panNo = panNo;
            }

            public int getEnrollmentDate() {
                return enrollmentDate;
            }

            public void setEnrollmentDate(int enrollmentDate) {
                this.enrollmentDate = enrollmentDate;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getMgnregaNo() {
                return mgnregaNo;
            }

            public void setMgnregaNo(Object mgnregaNo) {
                this.mgnregaNo = mgnregaNo;
            }

            public Object getArtisanNo() {
                return artisanNo;
            }

            public void setArtisanNo(Object artisanNo) {
                this.artisanNo = artisanNo;
            }

            public Object getDate() {
                return date;
            }

            public void setDate(Object date) {
                this.date = date;
            }

            public Object getApplicationId() {
                return applicationId;
            }

            public void setApplicationId(Object applicationId) {
                this.applicationId = applicationId;
            }

            public Object getLoanApplicationId() {
                return loanApplicationId;
            }

            public void setLoanApplicationId(Object loanApplicationId) {
                this.loanApplicationId = loanApplicationId;
            }

            public Object getBusinessActivity() {
                return businessActivity;
            }

            public void setBusinessActivity(Object businessActivity) {
                this.businessActivity = businessActivity;
            }

            public Object getBusinessActivityExisting() {
                return businessActivityExisting;
            }

            public void setBusinessActivityExisting(Object businessActivityExisting) {
                this.businessActivityExisting = businessActivityExisting;
            }

            public int getPeriod() {
                return period;
            }

            public void setPeriod(int period) {
                this.period = period;
            }

            public Object getProposed() {
                return proposed;
            }

            public void setProposed(Object proposed) {
                this.proposed = proposed;
            }

            public Object getBusinessExperience() {
                return businessExperience;
            }

            public void setBusinessExperience(Object businessExperience) {
                this.businessExperience = businessExperience;
            }

            public int getNetSalePastYear() {
                return netSalePastYear;
            }

            public void setNetSalePastYear(int netSalePastYear) {
                this.netSalePastYear = netSalePastYear;
            }

            public int getNetSalePresentYear() {
                return netSalePresentYear;
            }

            public void setNetSalePresentYear(int netSalePresentYear) {
                this.netSalePresentYear = netSalePresentYear;
            }

            public int getNetSaleNextyear() {
                return netSaleNextyear;
            }

            public void setNetSaleNextyear(int netSaleNextyear) {
                this.netSaleNextyear = netSaleNextyear;
            }

            public int getNetProfitPastYear() {
                return netProfitPastYear;
            }

            public void setNetProfitPastYear(int netProfitPastYear) {
                this.netProfitPastYear = netProfitPastYear;
            }

            public int getNetProfitPresentYear() {
                return netProfitPresentYear;
            }

            public void setNetProfitPresentYear(int netProfitPresentYear) {
                this.netProfitPresentYear = netProfitPresentYear;
            }

            public int getNetProfitNextYear() {
                return netProfitNextYear;
            }

            public void setNetProfitNextYear(int netProfitNextYear) {
                this.netProfitNextYear = netProfitNextYear;
            }

            public Object getSavingAccountName() {
                return savingAccountName;
            }

            public void setSavingAccountName(Object savingAccountName) {
                this.savingAccountName = savingAccountName;
            }

            public int getSavingAccountOutstandingAmout() {
                return savingAccountOutstandingAmout;
            }

            public void setSavingAccountOutstandingAmout(int savingAccountOutstandingAmout) {
                this.savingAccountOutstandingAmout = savingAccountOutstandingAmout;
            }

            public Object getSavingAccountCustomerDetail() {
                return savingAccountCustomerDetail;
            }

            public void setSavingAccountCustomerDetail(Object savingAccountCustomerDetail) {
                this.savingAccountCustomerDetail = savingAccountCustomerDetail;
            }

            public Object getShgLoanName() {
                return shgLoanName;
            }

            public void setShgLoanName(Object shgLoanName) {
                this.shgLoanName = shgLoanName;
            }

            public int getShgLoanOutstandingAmount() {
                return shgLoanOutstandingAmount;
            }

            public void setShgLoanOutstandingAmount(int shgLoanOutstandingAmount) {
                this.shgLoanOutstandingAmount = shgLoanOutstandingAmount;
            }

            public Object getShgLoanCustomerDetail() {
                return shgLoanCustomerDetail;
            }

            public void setShgLoanCustomerDetail(Object shgLoanCustomerDetail) {
                this.shgLoanCustomerDetail = shgLoanCustomerDetail;
            }

            public Object getOthersName() {
                return othersName;
            }

            public void setOthersName(Object othersName) {
                this.othersName = othersName;
            }

            public int getOthersOutstandingAmount() {
                return othersOutstandingAmount;
            }

            public void setOthersOutstandingAmount(int othersOutstandingAmount) {
                this.othersOutstandingAmount = othersOutstandingAmount;
            }

            public Object getOthersCustomerDetail() {
                return othersCustomerDetail;
            }

            public void setOthersCustomerDetail(Object othersCustomerDetail) {
                this.othersCustomerDetail = othersCustomerDetail;
            }

            public int getLoanAmount() {
                return loanAmount;
            }

            public void setLoanAmount(int loanAmount) {
                this.loanAmount = loanAmount;
            }

            public Object getApplyingFor() {
                return applyingFor;
            }

            public void setApplyingFor(Object applyingFor) {
                this.applyingFor = applyingFor;
            }

            public Object getTelephoneNo() {
                return telephoneNo;
            }

            public void setTelephoneNo(Object telephoneNo) {
                this.telephoneNo = telephoneNo;
            }

            public Object getAddressProof() {
                return addressProof;
            }

            public void setAddressProof(Object addressProof) {
                this.addressProof = addressProof;
            }

            public Object getSocialCategory() {
                return socialCategory;
            }

            public void setSocialCategory(Object socialCategory) {
                this.socialCategory = socialCategory;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public Object getPurposeOfLoan() {
                return purposeOfLoan;
            }

            public void setPurposeOfLoan(Object purposeOfLoan) {
                this.purposeOfLoan = purposeOfLoan;
            }

            public int getLoanAmountCEF() {
                return loanAmountCEF;
            }

            public void setLoanAmountCEF(int loanAmountCEF) {
                this.loanAmountCEF = loanAmountCEF;
            }

            public int getLoanAmountOther() {
                return loanAmountOther;
            }

            public void setLoanAmountOther(int loanAmountOther) {
                this.loanAmountOther = loanAmountOther;
            }

            public String getRegisterNo() {
                return registerNo;
            }

            public void setRegisterNo(String registerNo) {
                this.registerNo = registerNo;
            }

            public Long getLicenseDate() {
                return licenseDate;
            }

            public void setLicenseDate(Long licenseDate) {
                this.licenseDate = licenseDate;
            }

            public int getLoanDisbursalAmount() {
                return loanDisbursalAmount;
            }

            public void setLoanDisbursalAmount(int loanDisbursalAmount) {
                this.loanDisbursalAmount = loanDisbursalAmount;
            }

            public Object getLoanCriteria() {
                return loanCriteria;
            }

            public void setLoanCriteria(Object loanCriteria) {
                this.loanCriteria = loanCriteria;
            }

            public Object getLoanDisbursalDate() {
                return loanDisbursalDate;
            }

            public void setLoanDisbursalDate(Object loanDisbursalDate) {
                this.loanDisbursalDate = loanDisbursalDate;
            }

            public int getOpportunityHost() {
                return opportunityHost;
            }

            public void setOpportunityHost(int opportunityHost) {
                this.opportunityHost = opportunityHost;
            }

            public int getAdjustedProfit() {
                return adjustedProfit;
            }

            public void setAdjustedProfit(int adjustedProfit) {
                this.adjustedProfit = adjustedProfit;
            }

            public int getFamilyIncome() {
                return familyIncome;
            }

            public void setFamilyIncome(int familyIncome) {
                this.familyIncome = familyIncome;
            }

            public int getNetProfit() {
                return netProfit;
            }

            public void setNetProfit(int netProfit) {
                this.netProfit = netProfit;
            }

            public int getLoanRepayment() {
                return loanRepayment;
            }

            public void setLoanRepayment(int loanRepayment) {
                this.loanRepayment = loanRepayment;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public Object getRemainingPoints() {
                return remainingPoints;
            }

            public void setRemainingPoints(Object remainingPoints) {
                this.remainingPoints = remainingPoints;
            }

            public Object getWorthiness() {
                return worthiness;
            }

            public void setWorthiness(Object worthiness) {
                this.worthiness = worthiness;
            }

            public Object getLoanStartDate() {
                return loanStartDate;
            }

            public void setLoanStartDate(Object loanStartDate) {
                this.loanStartDate = loanStartDate;
            }

            public int getApproveLoanAmount() {
                return approveLoanAmount;
            }

            public void setApproveLoanAmount(int approveLoanAmount) {
                this.approveLoanAmount = approveLoanAmount;
            }

            public int getInterestRate() {
                return interestRate;
            }

            public void setInterestRate(int interestRate) {
                this.interestRate = interestRate;
            }

            public int getMoretoriumPeriod() {
                return moretoriumPeriod;
            }

            public void setMoretoriumPeriod(int moretoriumPeriod) {
                this.moretoriumPeriod = moretoriumPeriod;
            }

            public int getNoOfInstallments() {
                return noOfInstallments;
            }

            public void setNoOfInstallments(int noOfInstallments) {
                this.noOfInstallments = noOfInstallments;
            }

            public int getSuggestedPaybackAmount() {
                return suggestedPaybackAmount;
            }

            public void setSuggestedPaybackAmount(int suggestedPaybackAmount) {
                this.suggestedPaybackAmount = suggestedPaybackAmount;
            }

            public int getApprovedLoanAmount() {
                return approvedLoanAmount;
            }

            public void setApprovedLoanAmount(int approvedLoanAmount) {
                this.approvedLoanAmount = approvedLoanAmount;
            }

            public int getGrowthPotential() {
                return growthPotential;
            }

            public void setGrowthPotential(int growthPotential) {
                this.growthPotential = growthPotential;
            }

            public int getInflationRate() {
                return inflationRate;
            }

            public void setInflationRate(int inflationRate) {
                this.inflationRate = inflationRate;
            }

            public int getLoanPayback() {
                return loanPayback;
            }

            public void setLoanPayback(int loanPayback) {
                this.loanPayback = loanPayback;
            }

            public boolean isClfFlag() {
                return clfFlag;
            }

            public void setClfFlag(boolean clfFlag) {
                this.clfFlag = clfFlag;
            }

            public Object getRemainingEmiList() {
                return remainingEmiList;
            }

            public void setRemainingEmiList(Object remainingEmiList) {
                this.remainingEmiList = remainingEmiList;
            }

            public int getAnnualDebtRepaymentTotal() {
                return annualDebtRepaymentTotal;
            }

            public void setAnnualDebtRepaymentTotal(int annualDebtRepaymentTotal) {
                this.annualDebtRepaymentTotal = annualDebtRepaymentTotal;
            }

            public Object getLoanTypeNameList() {
                return loanTypeNameList;
            }

            public void setLoanTypeNameList(Object loanTypeNameList) {
                this.loanTypeNameList = loanTypeNameList;
            }

            public Object getCreditWorthyList() {
                return creditWorthyList;
            }

            public void setCreditWorthyList(Object creditWorthyList) {
                this.creditWorthyList = creditWorthyList;
            }

            public Object getMasterBpPreoperativeExpenditureParticulars() {
                return masterBpPreoperativeExpenditureParticulars;
            }

            public void setMasterBpPreoperativeExpenditureParticulars(Object masterBpPreoperativeExpenditureParticulars) {
                this.masterBpPreoperativeExpenditureParticulars = masterBpPreoperativeExpenditureParticulars;
            }

            public int getVariableCostIncreaseTwentyPercent() {
                return variableCostIncreaseTwentyPercent;
            }

            public void setVariableCostIncreaseTwentyPercent(int variableCostIncreaseTwentyPercent) {
                this.variableCostIncreaseTwentyPercent = variableCostIncreaseTwentyPercent;
            }

            public int getVariableCostIncreaseTenPercent() {
                return variableCostIncreaseTenPercent;
            }

            public void setVariableCostIncreaseTenPercent(int variableCostIncreaseTenPercent) {
                this.variableCostIncreaseTenPercent = variableCostIncreaseTenPercent;
            }

            public int getVariableCostDecreseFivePercent() {
                return variableCostDecreseFivePercent;
            }

            public void setVariableCostDecreseFivePercent(int variableCostDecreseFivePercent) {
                this.variableCostDecreseFivePercent = variableCostDecreseFivePercent;
            }

            public List<EstablishedProductionCapacityListBean> getEstablishedProductionCapacityList() {
                return establishedProductionCapacityList;
            }

            public void setEstablishedProductionCapacityList(List<EstablishedProductionCapacityListBean> establishedProductionCapacityList) {
                this.establishedProductionCapacityList = establishedProductionCapacityList;
            }

            public List<PreoperativeExpenditureListBean> getPreoperativeExpenditureList() {
                return preoperativeExpenditureList;
            }

            public void setPreoperativeExpenditureList(List<PreoperativeExpenditureListBean> preoperativeExpenditureList) {
                this.preoperativeExpenditureList = preoperativeExpenditureList;
            }

            public List<LandBuildingExpensesListBean> getLandBuildingExpensesList() {
                return landBuildingExpensesList;
            }

            public void setLandBuildingExpensesList(List<LandBuildingExpensesListBean> landBuildingExpensesList) {
                this.landBuildingExpensesList = landBuildingExpensesList;
            }

            public List<MachineryListBean> getMachineryList() {
                return machineryList;
            }

            public void setMachineryList(List<MachineryListBean> machineryList) {
                this.machineryList = machineryList;
            }

            public List<EquipmentFurnitureListBean> getEquipmentFurnitureList() {
                return equipmentFurnitureList;
            }

            public void setEquipmentFurnitureList(List<EquipmentFurnitureListBean> equipmentFurnitureList) {
                this.equipmentFurnitureList = equipmentFurnitureList;
            }

            public List<RawMaterialListBean> getRawMaterialList() {
                return rawMaterialList;
            }

            public void setRawMaterialList(List<RawMaterialListBean> rawMaterialList) {
                this.rawMaterialList = rawMaterialList;
            }

            public List<UtilitiesListBean> getUtilitiesList() {
                return utilitiesList;
            }

            public void setUtilitiesList(List<UtilitiesListBean> utilitiesList) {
                this.utilitiesList = utilitiesList;
            }

            public List<ManpowerListBean> getManpowerList() {
                return manpowerList;
            }

            public void setManpowerList(List<ManpowerListBean> manpowerList) {
                this.manpowerList = manpowerList;
            }

            public List<AdministrativeExpensesListBean> getAdministrativeExpensesList() {
                return administrativeExpensesList;
            }

            public void setAdministrativeExpensesList(List<AdministrativeExpensesListBean> administrativeExpensesList) {
                this.administrativeExpensesList = administrativeExpensesList;
            }

            public List<SellingDistributionExpensesListBean> getSellingDistributionExpensesList() {
                return sellingDistributionExpensesList;
            }

            public void setSellingDistributionExpensesList(List<SellingDistributionExpensesListBean> sellingDistributionExpensesList) {
                this.sellingDistributionExpensesList = sellingDistributionExpensesList;
            }

            public List<DepreciationListBean> getDepreciationList() {
                return depreciationList;
            }

            public void setDepreciationList(List<DepreciationListBean> depreciationList) {
                this.depreciationList = depreciationList;
            }

            public List<WorkingCapitalListBean> getWorkingCapitalList() {
                return workingCapitalList;
            }

            public void setWorkingCapitalList(List<WorkingCapitalListBean> workingCapitalList) {
                this.workingCapitalList = workingCapitalList;
            }

            public List<BpSalesRealisationListBean> getBpSalesRealisationList() {
                return bpSalesRealisationList;
            }

            public void setBpSalesRealisationList(List<BpSalesRealisationListBean> bpSalesRealisationList) {
                this.bpSalesRealisationList = bpSalesRealisationList;
            }

            public List<FinanceMeansListBean> getFinanceMeansList() {
                return financeMeansList;
            }

            public void setFinanceMeansList(List<FinanceMeansListBean> financeMeansList) {
                this.financeMeansList = financeMeansList;
            }

            public List<InterestListBean> getInterestList() {
                return interestList;
            }

            public void setInterestList(List<InterestListBean> interestList) {
                this.interestList = interestList;
            }

            public static class EstablishedProductionCapacityListBean implements Serializable {

                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private Long id;
                private Long workingDays;
                private String productType;
                private Double totalProduction;
                private Double actualNumberOfProduction;
                private Double utilizationCapacityProduction;
                private Double totalUtilizationProduction;
                private Double salePrice;
                private Double saleAmount;
                private Object natureOfUnitProductionCapacityId;
                private Object businessPlanId;
                private Object businessDescriptorId;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
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

                public Double getTotalProduction() {
                    return totalProduction;
                }

                public void setTotalProduction(Double totalProduction) {
                    this.totalProduction = totalProduction;
                }

                public Double getActualNumberOfProduction() {
                    return actualNumberOfProduction;
                }

                public void setActualNumberOfProduction(Double actualNumberOfProduction) {
                    this.actualNumberOfProduction = actualNumberOfProduction;
                }

                public Double getUtilizationCapacityProduction() {
                    return utilizationCapacityProduction;
                }

                public void setUtilizationCapacityProduction(Double utilizationCapacityProduction) {
                    this.utilizationCapacityProduction = utilizationCapacityProduction;
                }

                public Double getTotalUtilizationProduction() {
                    return totalUtilizationProduction;
                }

                public void setTotalUtilizationProduction(Double totalUtilizationProduction) {
                    this.totalUtilizationProduction = totalUtilizationProduction;
                }

                public Double getSalePrice() {
                    return salePrice;
                }

                public void setSalePrice(Double salePrice) {
                    this.salePrice = salePrice;
                }

                public Double getSaleAmount() {
                    return saleAmount;
                }

                public void setSaleAmount(Double saleAmount) {
                    this.saleAmount = saleAmount;
                }

                public Object getNatureOfUnitProductionCapacityId() {
                    return natureOfUnitProductionCapacityId;
                }

                public void setNatureOfUnitProductionCapacityId(Object natureOfUnitProductionCapacityId) {
                    this.natureOfUnitProductionCapacityId = natureOfUnitProductionCapacityId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public Object getBusinessDescriptorId() {
                    return businessDescriptorId;
                }

                public void setBusinessDescriptorId(Object businessDescriptorId) {
                    this.businessDescriptorId = businessDescriptorId;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }

            public static class PreoperativeExpenditureListBean implements Serializable {


                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private int id;
                private Double amount;
                private SelectedParticularsModel preoperativeExpenditureParticularId;
                private Object businessPlanId;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
                    this.modifiedBy = modifiedBy;
                }

                public long getCreatedDate() {
                    return createdDate;
                }

                public void setCreatedDate(long createdDate) {
                    this.createdDate = createdDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public Double getAmount() {
                    return amount;
                }

                public void setAmount(Double amount) {
                    this.amount = amount;
                }

                public SelectedParticularsModel getPreoperativeExpenditureParticularId() {
                    return preoperativeExpenditureParticularId;
                }

                public void setPreoperativeExpenditureParticularId(SelectedParticularsModel preoperativeExpenditureParticularId) {
                    this.preoperativeExpenditureParticularId = preoperativeExpenditureParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }

            public static class LandBuildingExpensesListBean implements Serializable {

                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private int id;
                private int area;
                private Double price;
                private Double amount;
                private Object status;
                private String ownership;
                private Object landBuildingExpensesParticularId;
                private Object businessPlanId;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
                    this.modifiedBy = modifiedBy;
                }

                public long getCreatedDate() {
                    return createdDate;
                }

                public void setCreatedDate(long createdDate) {
                    this.createdDate = createdDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getArea() {
                    return area;
                }

                public void setArea(int area) {
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

                public Object getStatus() {
                    return status;
                }

                public void setStatus(Object status) {
                    this.status = status;
                }

                public String getOwnership() {
                    return ownership;
                }

                public void setOwnership(String ownership) {
                    this.ownership = ownership;
                }

                public Object getLandBuildingExpensesParticularId() {
                    return landBuildingExpensesParticularId;
                }

                public void setLandBuildingExpensesParticularId(Object landBuildingExpensesParticularId) {
                    this.landBuildingExpensesParticularId = landBuildingExpensesParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }

            public static class MachineryListBean implements Serializable {

                private int id;
                private String particulars;
                private int numbers;
                private Double price;
                private Double amount;
                private String supplierNameAddress;
                private Double tax;
                private int electrificationExpense;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParticulars() {
                    return particulars;
                }

                public void setParticulars(String particulars) {
                    this.particulars = particulars;
                }

                public int getNumbers() {
                    return numbers;
                }

                public void setNumbers(int numbers) {
                    this.numbers = numbers;
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

                public String getSupplierNameAddress() {
                    return supplierNameAddress;
                }

                public void setSupplierNameAddress(String supplierNameAddress) {
                    this.supplierNameAddress = supplierNameAddress;
                }

                public Double getTax() {
                    return tax;
                }

                public void setTax(Double tax) {
                    this.tax = tax;
                }

                public int getElectrificationExpense() {
                    return electrificationExpense;
                }

                public void setElectrificationExpense(int electrificationExpense) {
                    this.electrificationExpense = electrificationExpense;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class EquipmentFurnitureListBean implements Serializable {

                private int id;
                private String particulars;
                private int numbers;
                private Double price;
                private Double amount;
                private String supplierNameAddress;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParticulars() {
                    return particulars;
                }

                public void setParticulars(String particulars) {
                    this.particulars = particulars;
                }

                public int getNumbers() {
                    return numbers;
                }

                public void setNumbers(int numbers) {
                    this.numbers = numbers;
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

                public String getSupplierNameAddress() {
                    return supplierNameAddress;
                }

                public void setSupplierNameAddress(String supplierNameAddress) {
                    this.supplierNameAddress = supplierNameAddress;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class RawMaterialListBean implements Serializable {

                private int id;
                private String item;
                private int quantity;
                private int rate;
                private int totalValue;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getItem() {
                    return item;
                }

                public void setItem(String item) {
                    this.item = item;
                }

                public int getQuantity() {
                    return quantity;
                }

                public void setQuantity(int quantity) {
                    this.quantity = quantity;
                }

                public int getRate() {
                    return rate;
                }

                public void setRate(int rate) {
                    this.rate = rate;
                }

                public int getTotalValue() {
                    return totalValue;
                }

                public void setTotalValue(int totalValue) {
                    this.totalValue = totalValue;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class UtilitiesListBean implements Serializable {

                private int id;
                private Object utilitiesParticularId;
                private Object businessPlanId;
                private Double annualExpenditure;
                private String remarks;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public Object getUtilitiesParticularId() {
                    return utilitiesParticularId;
                }

                public void setUtilitiesParticularId(Object utilitiesParticularId) {
                    this.utilitiesParticularId = utilitiesParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public Double getAnnualExpenditure() {
                    return annualExpenditure;
                }

                public void setAnnualExpenditure(Double annualExpenditure) {
                    this.annualExpenditure = annualExpenditure;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }
            }

            public static class ManpowerListBean implements Serializable {

                private int id;
                private int number;
                private int wagesPerMonth;
                private Double annualExpenses;
                private Object manpowerParticularId;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                public int getWagesPerMonth() {
                    return wagesPerMonth;
                }

                public void setWagesPerMonth(int wagesPerMonth) {
                    this.wagesPerMonth = wagesPerMonth;
                }

                public Double getAnnualExpenses() {
                    return annualExpenses;
                }

                public void setAnnualExpenses(Double annualExpenses) {
                    this.annualExpenses = annualExpenses;
                }

                public Object getManpowerParticularId() {
                    return manpowerParticularId;
                }

                public void setManpowerParticularId(Object manpowerParticularId) {
                    this.manpowerParticularId = manpowerParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class AdministrativeExpensesListBean implements Serializable {

                private int id;
                private String remarks;
                private Double amount;
                private Object administrativeExpensesParticularId;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public Double getAmount() {
                    return amount;
                }

                public void setAmount(Double amount) {
                    this.amount = amount;
                }

                public Object getAdministrativeExpensesParticularId() {
                    return administrativeExpensesParticularId;
                }

                public void setAdministrativeExpensesParticularId(Object administrativeExpensesParticularId) {
                    this.administrativeExpensesParticularId = administrativeExpensesParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class SellingDistributionExpensesListBean implements Serializable {

                private int id;
                private String remarks;
                private int amount;
                private Object sellingDistributionExpenseParticularId;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

                public Object getSellingDistributionExpenseParticularId() {
                    return sellingDistributionExpenseParticularId;
                }

                public void setSellingDistributionExpenseParticularId(Object sellingDistributionExpenseParticularId) {
                    this.sellingDistributionExpenseParticularId = sellingDistributionExpenseParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class DepreciationListBean implements Serializable {


                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private int id;
                private String typeOfAsset;
                private int initialValue;
                private int percentagePerAnnum;
                private int expectedLife;
                private double depreciationValue;
                private Object businessPlanId;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
                    this.modifiedBy = modifiedBy;
                }

                public long getCreatedDate() {
                    return createdDate;
                }

                public void setCreatedDate(long createdDate) {
                    this.createdDate = createdDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTypeOfAsset() {
                    return typeOfAsset;
                }

                public void setTypeOfAsset(String typeOfAsset) {
                    this.typeOfAsset = typeOfAsset;
                }

                public int getInitialValue() {
                    return initialValue;
                }

                public void setInitialValue(int initialValue) {
                    this.initialValue = initialValue;
                }

                public int getPercentagePerAnnum() {
                    return percentagePerAnnum;
                }

                public void setPercentagePerAnnum(int percentagePerAnnum) {
                    this.percentagePerAnnum = percentagePerAnnum;
                }

                public int getExpectedLife() {
                    return expectedLife;
                }

                public void setExpectedLife(int expectedLife) {
                    this.expectedLife = expectedLife;
                }

                public double getDepreciationValue() {
                    return depreciationValue;
                }

                public void setDepreciationValue(double depreciationValue) {
                    this.depreciationValue = depreciationValue;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }

            public static class WorkingCapitalListBean implements Serializable {


                private int id;
                private int duration;
                private int quantity;
                private Double amount;
                private Object workingCapitalParticularId;
                private Object businessPlanId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public int getQuantity() {
                    return quantity;
                }

                public void setQuantity(int quantity) {
                    this.quantity = quantity;
                }

                public void setAmount(Double amount) {
                    this.amount = amount;
                }

                public Object getWorkingCapitalParticularId() {
                    return workingCapitalParticularId;
                }

                public void setWorkingCapitalParticularId(Object workingCapitalParticularId) {
                    this.workingCapitalParticularId = workingCapitalParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }
            }

            public static class BpSalesRealisationListBean implements Serializable {

                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private int id;
                private int businessPlanId;
                private String particulars;
                private int quantity;
                private Double amount;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
                    this.modifiedBy = modifiedBy;
                }

                public long getCreatedDate() {
                    return createdDate;
                }

                public void setCreatedDate(long createdDate) {
                    this.createdDate = createdDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(int businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public String getParticulars() {
                    return particulars;
                }

                public void setParticulars(String particulars) {
                    this.particulars = particulars;
                }

                public int getQuantity() {
                    return quantity;
                }

                public void setQuantity(int quantity) {
                    this.quantity = quantity;
                }

                public Double getAmount() {
                    return amount;
                }

                public void setAmount(Double amount) {
                    this.amount = amount;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }

            public static class FinanceMeansListBean implements Serializable {


                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private int id;
                private String remarks;
                private Double amount;
                private Object businessPlanId;
                private Object financeMeansParticularId;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
                    this.modifiedBy = modifiedBy;
                }

                public long getCreatedDate() {
                    return createdDate;
                }

                public void setCreatedDate(long createdDate) {
                    this.createdDate = createdDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public void setAmount(Double amount) {
                    this.amount = amount;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public Object getFinanceMeansParticularId() {
                    return financeMeansParticularId;
                }

                public void setFinanceMeansParticularId(Object financeMeansParticularId) {
                    this.financeMeansParticularId = financeMeansParticularId;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }

            public static class InterestListBean implements Serializable {

                private Object createdBy;
                private Object modifiedBy;
                private long createdDate;
                private int id;
                private Double loanAmount;
                private int interestRate;
                private Double installmentAmount;
                private int moratoriumPeriod;
                private Object interestParticularId;
                private Object businessPlanId;
                private boolean deleted;

                public Object getCreatedBy() {
                    return createdBy;
                }

                public void setCreatedBy(Object createdBy) {
                    this.createdBy = createdBy;
                }

                public Object getModifiedBy() {
                    return modifiedBy;
                }

                public void setModifiedBy(Object modifiedBy) {
                    this.modifiedBy = modifiedBy;
                }

                public long getCreatedDate() {
                    return createdDate;
                }

                public void setCreatedDate(long createdDate) {
                    this.createdDate = createdDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }


                public int getInterestRate() {
                    return interestRate;
                }

                public void setInterestRate(int interestRate) {
                    this.interestRate = interestRate;
                }


                public Double getLoanAmount() {
                    return loanAmount;
                }

                public void setLoanAmount(Double loanAmount) {
                    this.loanAmount = loanAmount;
                }

                public Double getInstallmentAmount() {
                    return installmentAmount;
                }

                public void setInstallmentAmount(Double installmentAmount) {
                    this.installmentAmount = installmentAmount;
                }

                public int getMoratoriumPeriod() {
                    return moratoriumPeriod;
                }

                public void setMoratoriumPeriod(int moratoriumPeriod) {
                    this.moratoriumPeriod = moratoriumPeriod;
                }

                public Object getInterestParticularId() {
                    return interestParticularId;
                }

                public void setInterestParticularId(Object interestParticularId) {
                    this.interestParticularId = interestParticularId;
                }

                public Object getBusinessPlanId() {
                    return businessPlanId;
                }

                public void setBusinessPlanId(Object businessPlanId) {
                    this.businessPlanId = businessPlanId;
                }

                public boolean isDeleted() {
                    return deleted;
                }

                public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
                }
            }
        }

        public static class ShgUserDTOBean implements Serializable {
            private Long enterprenuerID;
            private Long id;
            private String username;
            private String password;
            private String role;

            public Long getEnterprenuerID() {
                return enterprenuerID;
            }

            public void setEnterprenuerID(Long enterprenuerID) {
                this.enterprenuerID = enterprenuerID;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class VoUserDTOBean implements Serializable {
            private Long enterprenuerID;
            private Long id;
            private String username;
            private String password;
            private String role;

            public Long getEnterprenuerID() {
                return enterprenuerID;
            }

            public void setEnterprenuerID(Long enterprenuerID) {
                this.enterprenuerID = enterprenuerID;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class ClfUserDTOBean implements Serializable {
            private Long enterprenuerID;
            private Long id;
            private String username;
            private String password;
            private String role;

            public Long getEnterprenuerID() {
                return enterprenuerID;
            }

            public void setEnterprenuerID(Long enterprenuerID) {
                this.enterprenuerID = enterprenuerID;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class FamilyMembersBean implements Serializable {

            private int autoId;
            private Long createdBy;
            private Long modifiedBy;
            private long createdDate;
            private Long id;
            private String memberName;
            private String occupations;
            private String gender;
            private int age;
            private String education;
            private String experience;
            private String relationship;
            private String entrepreneurRelationship;
            private Double longitude;
            private Double latitude;
            private Long entrepreneurId;
            private boolean deleted;


            public int getAutoId() {
                return autoId;
            }

            public void setAutoId(int autoId) {
                this.autoId = autoId;
            }

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

            public String getMemberName() {
                return memberName;
            }

            public void setMemberName(String memberName) {
                this.memberName = memberName;
            }

            public String getOccupations() {
                return occupations;
            }

            public void setOccupations(String occupations) {
                this.occupations = occupations;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }

            public String getExperience() {
                return experience;
            }

            public void setExperience(String experience) {
                this.experience = experience;
            }

            public String getRelationship() {
                return relationship;
            }

            public void setRelationship(String relationship) {
                this.relationship = relationship;
            }

            public String getEntrepreneurRelationship() {
                return entrepreneurRelationship;
            }

            public void setEntrepreneurRelationship(String entrepreneurRelationship) {
                this.entrepreneurRelationship = entrepreneurRelationship;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public Long getEntrepreneurId() {
                return entrepreneurId;
            }

            public void setEntrepreneurId(Long entrepreneurId) {
                this.entrepreneurId = entrepreneurId;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

        }

        public static class FamilyExpendituresBean implements Serializable {

            private Long createdBy;
            private Long modifiedBy;
            private long createdDate;
            private Long id;
            private String itemType;
            private double monthlyExpence;
            private Double annualExpence;
            private Long entrepreneurId;
            private Long itemTypeId;
            private Double longitude;
            private Double latitude;
            private boolean deleted;

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

            public Double getAnnualExpence() {
                return annualExpence;
            }

            public void setAnnualExpence(Double annualExpence) {
                this.annualExpence = annualExpence;
            }

            public Long getEntrepreneurId() {
                return entrepreneurId;
            }

            public void setEntrepreneurId(Long entrepreneurId) {
                this.entrepreneurId = entrepreneurId;
            }

            public Long getItemTypeId() {
                return itemTypeId;
            }

            public void setItemTypeId(Long itemTypeId) {
                this.itemTypeId = itemTypeId;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }
        }

        public static class FamilyIncomeBean implements Serializable {

            private Long createdBy;
            private Long modifiedBy;
            private Long createdDate;
            private Long id;
            private String incomeSource;
            private int activeDaysOfMonth;
            private int activeMonthsOfYear;
            private Double incomePerDay;
            private Double annualIncome;
            private Long entrepreneurId;
            private String memberName;
            private Long familyMemberId;
            private Double latitude;
            private Double longitude;
            private boolean deleted;

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

            public String getIncomeSource() {
                return incomeSource;
            }

            public void setIncomeSource(String incomeSource) {
                this.incomeSource = incomeSource;
            }

            public int getActiveDaysOfMonth() {
                return activeDaysOfMonth;
            }

            public void setActiveDaysOfMonth(int activeDaysOfMonth) {
                this.activeDaysOfMonth = activeDaysOfMonth;
            }

            public int getActiveMonthsOfYear() {
                return activeMonthsOfYear;
            }

            public void setActiveMonthsOfYear(int activeMonthsOfYear) {
                this.activeMonthsOfYear = activeMonthsOfYear;
            }

            public Double getIncomePerDay() {
                return incomePerDay;
            }

            public void setIncomePerDay(Double incomePerDay) {
                this.incomePerDay = incomePerDay;
            }

            public Double getAnnualIncome() {
                return annualIncome;
            }

            public void setAnnualIncome(Double annualIncome) {
                this.annualIncome = annualIncome;
            }

            public Long getEntrepreneurId() {
                return entrepreneurId;
            }

            public void setEntrepreneurId(Long entrepreneurId) {
                this.entrepreneurId = entrepreneurId;
            }

            public String getMemberName() {
                return memberName;
            }

            public void setMemberName(String memberName) {
                this.memberName = memberName;
            }

            public Long getFamilyMemberId() {
                return familyMemberId;
            }

            public void setFamilyMemberId(Long familyMemberId) {
                this.familyMemberId = familyMemberId;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }
        }


        public static class ListCreditHistoryBean implements Serializable {

            private Long createdBy;
            private Long modifiedBy;
            private long createdDate;
            private Long id;
            private LoanTypeBean loanType;
            private Long LoanTypeIdGet;
            private String LoanTypeName;
            private long loanStartDate;
            private long loanEndDate;
            private int interestRate;
            private Double loanAmount;
            private Double currentOutstanding;
            private boolean loanStatus;
            private Double emiAmount;
            private Double longitude;
            private Double latitude;
            private Long entrepreneurId;
            private Long loanTypeId;
            private boolean deleted;
            String loanTypeCreditHistory;

            public String getLoanTypeCreditHistory() {
                return loanTypeCreditHistory;
            }

            public void setLoanTypeCreditHistory(String loanTypeCreditHistory) {
                this.loanTypeCreditHistory = loanTypeCreditHistory;
            }

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

            public LoanTypeBean getLoanType() {
                return loanType;
            }

            public void setLoanType(LoanTypeBean loanType) {
                this.loanType = loanType;
            }

            public long getLoanStartDate() {
                return loanStartDate;
            }

            public void setLoanStartDate(long loanStartDate) {
                this.loanStartDate = loanStartDate;
            }

            public long getLoanEndDate() {
                return loanEndDate;
            }

            public void setLoanEndDate(long loanEndDate) {
                this.loanEndDate = loanEndDate;
            }

            public int getInterestRate() {
                return interestRate;
            }

            public void setInterestRate(int interestRate) {
                this.interestRate = interestRate;
            }

            public Double getLoanAmount() {
                return loanAmount;
            }

            public void setLoanAmount(Double loanAmount) {
                this.loanAmount = loanAmount;
            }

            public Double getCurrentOutstanding() {
                return currentOutstanding;
            }

            public void setCurrentOutstanding(Double currentOutstanding) {
                this.currentOutstanding = currentOutstanding;
            }

            public boolean isLoanStatus() {
                return loanStatus;
            }

            public void setLoanStatus(boolean loanStatus) {
                this.loanStatus = loanStatus;
            }

            public Double getEmiAmount() {
                return emiAmount;
            }

            public void setEmiAmount(Double emiAmount) {
                this.emiAmount = emiAmount;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public Long getEntrepreneurId() {
                return entrepreneurId;
            }

            public void setEntrepreneurId(Long entrepreneurId) {
                this.entrepreneurId = entrepreneurId;
            }

            public Long getLoanTypeId() {
                return loanTypeId;
            }

            public void setLoanTypeId(Long loanTypeId) {
                this.loanTypeId = loanTypeId;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            public Long getLoanTypeIdGet() {
                return LoanTypeIdGet;
            }

            public void setLoanTypeIdGet(Long loanTypeIdGet) {
                LoanTypeIdGet = loanTypeIdGet;
            }

            public String getLoanTypeName() {
                return LoanTypeName;
            }

            public void setLoanTypeName(String loanTypeName) {
                LoanTypeName = loanTypeName;
            }

            public static class LoanTypeBean implements Serializable {


                private Long id;
                private String name;

                public Long getId() {
                    return id;
                }

                public void setId(Long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
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

        public static class ListSpecialTrainingBean implements Serializable {

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

        public static class ListWorkExperienceBean implements Serializable {

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


}
