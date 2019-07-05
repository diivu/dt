package com.triapp.Models;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Developer on 9/21/2017.
 */

public class BusinessPlanDTO implements Serializable {

    private String nameOfEntrepreneur;
    private String address;
    private String firstName;
    private String middleName;
    private String lastName;
    private long dateOfBirth;
    private String age;
    private Long id;

//kl

    private Long businessPlanId;//1
    private Long executiveProjectSummaryId;
    private String executiveProjectSummary;//2
    private String govtLicense;//3
    private String nameOfUnit;//4
    private String addressOfUnit;//5
    private Long entrepreneurId;//6
    private Long businessDescriptorId;//7
    private String businessDescriptorName;//8
    private Long natureOfUnitId;//9
    private String natureOfUnitName;//10
    private Long placeId;//11
    private Long typeOfUnitId;//12
    private String typeOfUnitName;//13
    private String placeName;//14
    private String status;
    private Long stateId;//15
    private Long districtId;//16
    private Long blockId;//16
    private Long villageId;//17
    private Long grampanchayatId;
    private String pincode;//18

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


    private String voName;
    private Long createdBy;
    private long createdDate;

    private String shgName;
    private String villageName;
    private String blockName;
    private String phoneNo;
    private String emailId;
    private String aadharNo;
    private String education;
    private String voterId;
    private String panNo;

    private long enrollmentDate;
    private String gender;
    private String mgnregaNo;
    private String artisanNo;

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
    private double loanAmount;
    private String applyingFor;
    private String telephoneNo;
    private String addressProof;
    private String socialCategory;
    private long flag;
    private String purposeOfLoan;
    private double loanAmountCEF;
    private double loanAmountOther;
    private String registerNo;
    private long licenseDate;

    private double loanDisbursalAmount;
    private String loanCriteria;
    private Date loanDisbursalDate;

    private Date loanStartDate;
    private double approveLoanAmount;
    private double interestRate;
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
  //  private List<MasterBpPreoperativeExpenditureParticulars> masterBpPreoperativeExpenditureParticulars;


    private int code;
    private Object data;
    private String message;
    private String description;

    public String getNameOfEntrepreneur() {
        return nameOfEntrepreneur;
    }

    public void setNameOfEntrepreneur(String nameOfEntrepreneur) {
        this.nameOfEntrepreneur = nameOfEntrepreneur;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
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

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public long getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(long enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
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

    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
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

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public double getApproveLoanAmount() {
        return approveLoanAmount;
    }

    public void setApproveLoanAmount(double approveLoanAmount) {
        this.approveLoanAmount = approveLoanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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

    public Long getGrampanchayatId() {
        return grampanchayatId;
    }

    public void setGrampanchayatId(Long grampanchayatId) {
        this.grampanchayatId = grampanchayatId;
    }
}
