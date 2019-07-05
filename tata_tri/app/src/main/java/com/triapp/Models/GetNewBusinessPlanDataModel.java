package com.triapp.Models;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Developer on 05-02-2018.
 */

public class GetNewBusinessPlanDataModel {


    private int code;
    private String message;
    private Object description;
    private ArrayList<DataBean> data;

    public static GetNewBusinessPlanDataModel objectFromData(String str) {

        return new Gson().fromJson(str, GetNewBusinessPlanDataModel.class);
    }

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

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private Long id;
        private Long entrepreneurId;
        private String enterpriseName;
        private Long stateCode;
        private Long districtCode;
        private Long blockCode;
        private Long villageCode;
        private Long grampanchayatCode;
        private String address;
        private String pincode;
        private Long businessDescriptorId;
        private Long natureOfUnitId;
        private Long placeId;
        private String isGovtLicense;
        private Long govtLicenseDate;
        private String govtLicenseRegNo;
        private String otherIncomeDescription;
        private double otherIncomeAmountYearly;
        private int marketSurveyExpense;
        private int stationaryExpense;
        private int legalExpense;
        private int establishmentExpense;
        private double otherExpense;
        private Long createdBy;
        private Long createdDate;
        private double Longitude;
        private double latitude;
        private ArrayList<ProductionAndRevenuesBean> productionAndRevenues;
        private ArrayList<LandBuildingExpensesBean> landBuildingExpenses;
        private ArrayList<PlantAndMachineriesBean> plantAndMachineries;
        private ArrayList<FurnituresBean> furnitures;
        private ArrayList<RawMaterialsBean> rawMaterials;
        private ArrayList<UtilitiesBean> utilities;
        private ArrayList<ManpowersBean> manpowers;
        private ArrayList<AdministrativeExpensesBean> administrativeExpenses;
        private ArrayList<SellingDistributionExpensesBean> sellingDistributionExpenses;
        private ArrayList<WorkingCapitalsBean> workingCapitals;
        private ArrayList<FinanceMeansBean> financeMeans;
        private ArrayList<InterestsBean> interests;
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
        private double loanAmount;
        private String registerNo;
        private long licenseDate;

        private double approveLoanAmount;


        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
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

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public Long getStateCode() {
            return stateCode;
        }

        public void setStateCode(Long stateCode) {
            this.stateCode = stateCode;
        }

        public Long getDistrictCode() {
            return districtCode;
        }

        public void setDistrictCode(Long districtCode) {
            this.districtCode = districtCode;
        }

        public Long getBlockCode() {
            return blockCode;
        }

        public void setBlockCode(Long blockCode) {
            this.blockCode = blockCode;
        }

        public Long getVillageCode() {
            return villageCode;
        }

        public void setVillageCode(Long villageCode) {
            this.villageCode = villageCode;
        }

        public Long getGrampanchayatCode() {
            return grampanchayatCode;
        }

        public void setGrampanchayatCode(Long grampanchayatCode) {
            this.grampanchayatCode = grampanchayatCode;
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

        public String getIsGovtLicense() {
            return isGovtLicense;
        }

        public void setIsGovtLicense(String isGovtLicense) {
            this.isGovtLicense = isGovtLicense;
        }

        public Long getGovtLicenseDate() {
            return govtLicenseDate;
        }

        public void setGovtLicenseDate(Long govtLicenseDate) {
            this.govtLicenseDate = govtLicenseDate;
        }

        public String getGovtLicenseRegNo() {
            return govtLicenseRegNo;
        }

        public void setGovtLicenseRegNo(String govtLicenseRegNo) {
            this.govtLicenseRegNo = govtLicenseRegNo;
        }

        public String getOtherIncomeDescription() {
            return otherIncomeDescription;
        }

        public void setOtherIncomeDescription(String otherIncomeDescription) {
            this.otherIncomeDescription = otherIncomeDescription;
        }

        public double getOtherIncomeAmountYearly() {
            return otherIncomeAmountYearly;
        }

        public void setOtherIncomeAmountYearly(double otherIncomeAmountYearly) {
            this.otherIncomeAmountYearly = otherIncomeAmountYearly;
        }

        public int getMarketSurveyExpense() {
            return marketSurveyExpense;
        }

        public void setMarketSurveyExpense(int marketSurveyExpense) {
            this.marketSurveyExpense = marketSurveyExpense;
        }

        public int getStationaryExpense() {
            return stationaryExpense;
        }

        public void setStationaryExpense(int stationaryExpense) {
            this.stationaryExpense = stationaryExpense;
        }

        public int getLegalExpense() {
            return legalExpense;
        }

        public void setLegalExpense(int legalExpense) {
            this.legalExpense = legalExpense;
        }

        public int getEstablishmentExpense() {
            return establishmentExpense;
        }

        public void setEstablishmentExpense(int establishmentExpense) {
            this.establishmentExpense = establishmentExpense;
        }

        public double getOtherExpense() {
            return otherExpense;
        }

        public void setOtherExpense(double otherExpense) {
            this.otherExpense = otherExpense;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public Long getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Long createdDate) {
            this.createdDate = createdDate;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setLongitude(double Longitude) {
            this.Longitude = Longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public ArrayList<ProductionAndRevenuesBean> getProductionAndRevenues() {
            return productionAndRevenues;
        }

        public void setProductionAndRevenues(ArrayList<ProductionAndRevenuesBean> productionAndRevenues) {
            this.productionAndRevenues = productionAndRevenues;
        }

        public ArrayList<LandBuildingExpensesBean> getLandBuildingExpenses() {
            return landBuildingExpenses;
        }

        public void setLandBuildingExpenses(ArrayList<LandBuildingExpensesBean> landBuildingExpenses) {
            this.landBuildingExpenses = landBuildingExpenses;
        }

        public ArrayList<PlantAndMachineriesBean> getPlantAndMachineries() {
            return plantAndMachineries;
        }

        public void setPlantAndMachineries(ArrayList<PlantAndMachineriesBean> plantAndMachineries) {
            this.plantAndMachineries = plantAndMachineries;
        }

        public ArrayList<FurnituresBean> getFurnitures() {
            return furnitures;
        }

        public void setFurnitures(ArrayList<FurnituresBean> furnitures) {
            this.furnitures = furnitures;
        }

        public ArrayList<RawMaterialsBean> getRawMaterials() {
            return rawMaterials;
        }

        public void setRawMaterials(ArrayList<RawMaterialsBean> rawMaterials) {
            this.rawMaterials = rawMaterials;
        }

        public ArrayList<UtilitiesBean> getUtilities() {
            return utilities;
        }

        public void setUtilities(ArrayList<UtilitiesBean> utilities) {
            this.utilities = utilities;
        }

        public ArrayList<ManpowersBean> getManpowers() {
            return manpowers;
        }

        public void setManpowers(ArrayList<ManpowersBean> manpowers) {
            this.manpowers = manpowers;
        }

        public ArrayList<AdministrativeExpensesBean> getAdministrativeExpenses() {
            return administrativeExpenses;
        }

        public void setAdministrativeExpenses(ArrayList<AdministrativeExpensesBean> administrativeExpenses) {
            this.administrativeExpenses = administrativeExpenses;
        }

        public ArrayList<SellingDistributionExpensesBean> getSellingDistributionExpenses() {
            return sellingDistributionExpenses;
        }

        public void setSellingDistributionExpenses(ArrayList<SellingDistributionExpensesBean> sellingDistributionExpenses) {
            this.sellingDistributionExpenses = sellingDistributionExpenses;
        }

        public ArrayList<WorkingCapitalsBean> getWorkingCapitals() {
            return workingCapitals;
        }

        public void setWorkingCapitals(ArrayList<WorkingCapitalsBean> workingCapitals) {
            this.workingCapitals = workingCapitals;
        }

        public ArrayList<FinanceMeansBean> getFinanceMeans() {
            return financeMeans;
        }

        public void setFinanceMeans(ArrayList<FinanceMeansBean> financeMeans) {
            this.financeMeans = financeMeans;
        }

        public ArrayList<InterestsBean> getInterests() {
            return interests;
        }

        public void setInterests(ArrayList<InterestsBean> interests) {
            this.interests = interests;
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

        public double getApproveLoanAmount() {
            return approveLoanAmount;
        }

        public void setApproveLoanAmount(double approveLoanAmount) {
            this.approveLoanAmount = approveLoanAmount;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public static class ProductionAndRevenuesBean {
            private Long id;
            private Long businessPlanId;
            private String productName;
            private String workingUnites;
            private String enteredWorkingUnit;
            private double perDayEightHours;
            private double totalProduction;
            private double perDaySixtyPercent;
            private double totalUtilization;
            private double salePricePerUnit;
            private double amount;
            private int editble;
            private String workingUnitsType;
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

            public String getWorkingUnitsType() {
                return workingUnitsType;
            }

            public void setWorkingUnitsType(String workingUnitsType) {
                this.workingUnitsType = workingUnitsType;
            }

            public String getEnteredWorkingUnit() {
                return enteredWorkingUnit;
            }

            public void setEnteredWorkingUnit(String enteredWorkingUnit) {
                this.enteredWorkingUnit = enteredWorkingUnit;
            }

            public static ProductionAndRevenuesBean objectFromData(String str) {

                return new Gson().fromJson(str, ProductionAndRevenuesBean.class);
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
                return editble;
            }

            public void setEditble(int editble) {
                this.editble = editble;
            }

            public int getSalePercentage() {
                return salePercentage;
            }

            public void setSalePercentage(int salePercentage) {
                this.salePercentage = salePercentage;
            }
        }

        public static class LandBuildingExpensesBean {
            private Object createdBy;
            private Object modifiedBy;
            private Long createdDate;
            private int id;
            private Long area;
            private double price;
            private double amount;
            private Object status;
            private String ownership;
            private int preOperativeMonths;
            private Long landBuildingExpensesParticularId;
            private Long businessPlanId;
            private boolean deleted;

            public static LandBuildingExpensesBean objectFromData(String str) {

                return new Gson().fromJson(str, LandBuildingExpensesBean.class);
            }

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

            public Long getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(Long createdDate) {
                this.createdDate = createdDate;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Long getArea() {
                return area;
            }

            public void setArea(Long area) {
                this.area = area;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
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

            public int getPreOperativeMonths() {
                return preOperativeMonths;
            }

            public void setPreOperativeMonths(int preOperativeMonths) {
                this.preOperativeMonths = preOperativeMonths;
            }

            public Long getLandBuildingExpensesParticularId() {
                return landBuildingExpensesParticularId;
            }

            public void setLandBuildingExpensesParticularId(Long landBuildingExpensesParticularId) {
                this.landBuildingExpensesParticularId = landBuildingExpensesParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }
        }

        public static class PlantAndMachineriesBean {
            private Long id;
            private Long businessPlanID;
            private String perticuler;
            private Long machineryNo;
            private double price;
            private double amount;
            private Long expectedLife;
            private Long purchaseDate;
            private Long scrapValue;
            private double depriciation;
            private double bookValue;
            private String suppliersNameAndAddress;
            private double taxTransporatation;
            private double electrification;
            private String uploadQuotation;
            private int isDataEditable;
            private byte[] file;

            public byte[] getFile() {
                return file;
            }

            public void setFile(byte[] file) {
                this.file = file;
            }

            public static PlantAndMachineriesBean objectFromData(String str) {

                return new Gson().fromJson(str, PlantAndMachineriesBean.class);
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public Long getBusinessPlanID() {
                return businessPlanID;
            }

            public void setBusinessPlanID(Long businessPlanID) {
                this.businessPlanID = businessPlanID;
            }

            public String getPerticuler() {
                return perticuler;
            }

            public void setPerticuler(String perticuler) {
                this.perticuler = perticuler;
            }

            public Long getMachineryNo() {
                return machineryNo;
            }

            public void setMachineryNo(Long machineryNo) {
                this.machineryNo = machineryNo;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Long getExpectedLife() {
                return expectedLife;
            }

            public void setExpectedLife(Long expectedLife) {
                this.expectedLife = expectedLife;
            }

            public Long getPurchaseDate() {
                return purchaseDate;
            }

            public void setPurchaseDate(Long purchaseDate) {
                this.purchaseDate = purchaseDate;
            }

            public Long getScrapValue() {
                return scrapValue;
            }

            public void setScrapValue(Long scrapValue) {
                this.scrapValue = scrapValue;
            }

            public double getDepriciation() {
                return depriciation;
            }

            public void setDepriciation(double depriciation) {
                this.depriciation = depriciation;
            }

            public double getBookValue() {
                return bookValue;
            }

            public void setBookValue(double bookValue) {
                this.bookValue = bookValue;
            }

            public String getSuppliersNameAndAddress() {
                return suppliersNameAndAddress;
            }

            public void setSuppliersNameAndAddress(String suppliersNameAndAddress) {
                this.suppliersNameAndAddress = suppliersNameAndAddress;
            }

            public double getTaxTransporatation() {
                return taxTransporatation;
            }

            public void setTaxTransporatation(double taxTransporatation) {
                this.taxTransporatation = taxTransporatation;
            }

            public double getElectrification() {
                return electrification;
            }

            public void setElectrification(double electrification) {
                this.electrification = electrification;
            }

            public String getUploadQuotation() {
                return uploadQuotation;
            }

            public void setUploadQuotation(String uploadQuotation) {
                this.uploadQuotation = uploadQuotation;
            }

            public int getIsDataEditable() {
                return isDataEditable;
            }

            public void setIsDataEditable(int isDataEditable) {
                this.isDataEditable = isDataEditable;
            }
        }

        public static class FurnituresBean {
            private Long id;
            private Long businessPlanID;
            private String perticuler;
            private Long machineryNo;
            private double price;
            private double amount;
            private Long expectedLife;
            private Long purchaseDate;
            private Long scrapValue;
            private double depriciation;
            private double bookValue;
            private String suppliersNameAndAddress;
            private int isDataEditable;
            private String uploadQuotation;
            private byte[] file;


            public byte[] getFile() {
                return file;
            }

            public void setFile(byte[] file) {
                this.file = file;
            }

            public static FurnituresBean objectFromData(String str) {

                return new Gson().fromJson(str, FurnituresBean.class);
            }

            public String getUploadQuotation() {
                return uploadQuotation;
            }

            public void setUploadQuotation(String uploadQuotation) {
                this.uploadQuotation = uploadQuotation;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public Long getBusinessPlanID() {
                return businessPlanID;
            }

            public void setBusinessPlanID(Long businessPlanID) {
                this.businessPlanID = businessPlanID;
            }

            public String getPerticuler() {
                return perticuler;
            }

            public void setPerticuler(String perticuler) {
                this.perticuler = perticuler;
            }

            public Long getMachineryNo() {
                return machineryNo;
            }

            public void setMachineryNo(Long machineryNo) {
                this.machineryNo = machineryNo;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Long getExpectedLife() {
                return expectedLife;
            }

            public void setExpectedLife(Long expectedLife) {
                this.expectedLife = expectedLife;
            }

            public Long getPurchaseDate() {
                return purchaseDate;
            }

            public void setPurchaseDate(Long purchaseDate) {
                this.purchaseDate = purchaseDate;
            }

            public Long getScrapValue() {
                return scrapValue;
            }

            public void setScrapValue(Long scrapValue) {
                this.scrapValue = scrapValue;
            }

            public double getDepriciation() {
                return depriciation;
            }

            public void setDepriciation(double depriciation) {
                this.depriciation = depriciation;
            }

            public double getBookValue() {
                return bookValue;
            }

            public void setBookValue(double bookValue) {
                this.bookValue = bookValue;
            }

            public String getSuppliersNameAndAddress() {
                return suppliersNameAndAddress;
            }

            public void setSuppliersNameAndAddress(String suppliersNameAndAddress) {
                this.suppliersNameAndAddress = suppliersNameAndAddress;
            }

            public int getIsDataEditable() {
                return isDataEditable;
            }

            public void setIsDataEditable(int isDataEditable) {
                this.isDataEditable = isDataEditable;
            }
        }

        public static class RawMaterialsBean {
            private Long id;
            private String item;
            private Long quantity;
            private double rate;
            private double totalValue;
            private Long forMonths;
            private Long businessPlanId;
            private int isEditable;

            public static RawMaterialsBean objectFromData(String str) {

                return new Gson().fromJson(str, RawMaterialsBean.class);
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getItem() {
                return item;
            }

            public void setItem(String item) {
                this.item = item;
            }

            public Long getQuantity() {
                return quantity;
            }

            public void setQuantity(Long quantity) {
                this.quantity = quantity;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public double getTotalValue() {
                return totalValue;
            }

            public void setTotalValue(double totalValue) {
                this.totalValue = totalValue;
            }

            public Long getForMonths() {
                return forMonths;
            }

            public void setForMonths(Long forMonths) {
                this.forMonths = forMonths;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }

            public int getIsEditable() {
                return isEditable;
            }

            public void setIsEditable(int isEditable) {
                this.isEditable = isEditable;
            }
        }

        public static class UtilitiesBean {
            private int id;
            private Long utilitiesParticularId;
            private Long businessPlanId;
            private double annualExpenditure;
            private String remarks;

            public static UtilitiesBean objectFromData(String str) {

                return new Gson().fromJson(str, UtilitiesBean.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Long getUtilitiesParticularId() {
                return utilitiesParticularId;
            }

            public void setUtilitiesParticularId(Long utilitiesParticularId) {
                this.utilitiesParticularId = utilitiesParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }

            public double getAnnualExpenditure() {
                return annualExpenditure;
            }

            public void setAnnualExpenditure(double annualExpenditure) {
                this.annualExpenditure = annualExpenditure;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }
        }

        public static class ManpowersBean {
            private Long id;
            private int number;
            private double wagesPerMonth;
            private double annualExpenses;
            private Long manpowerParticularId;
            private Long businessPlanId;

            public static ManpowersBean objectFromData(String str) {

                return new Gson().fromJson(str, ManpowersBean.class);
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public double getWagesPerMonth() {
                return wagesPerMonth;
            }

            public void setWagesPerMonth(double wagesPerMonth) {
                this.wagesPerMonth = wagesPerMonth;
            }

            public double getAnnualExpenses() {
                return annualExpenses;
            }

            public void setAnnualExpenses(double annualExpenses) {
                this.annualExpenses = annualExpenses;
            }

            public Long getManpowerParticularId() {
                return manpowerParticularId;
            }

            public void setManpowerParticularId(Long manpowerParticularId) {
                this.manpowerParticularId = manpowerParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }
        }

        public static class AdministrativeExpensesBean {
            private int id;
            private String remarks;
            private double amount;
            private Long administrativeExpensesParticularId;
            private Long businessPlanId;

            public static AdministrativeExpensesBean objectFromData(String str) {

                return new Gson().fromJson(str, AdministrativeExpensesBean.class);
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

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Long getAdministrativeExpensesParticularId() {
                return administrativeExpensesParticularId;
            }

            public void setAdministrativeExpensesParticularId(Long administrativeExpensesParticularId) {
                this.administrativeExpensesParticularId = administrativeExpensesParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }
        }

        public static class SellingDistributionExpensesBean {
            private int id;
            private String remarks;
            private double amount;
            private Long sellingDistributionExpenseParticularId;
            private Long businessPlanId;

            public static SellingDistributionExpensesBean objectFromData(String str) {

                return new Gson().fromJson(str, SellingDistributionExpensesBean.class);
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

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Long getSellingDistributionExpenseParticularId() {
                return sellingDistributionExpenseParticularId;
            }

            public void setSellingDistributionExpenseParticularId(Long sellingDistributionExpenseParticularId) {
                this.sellingDistributionExpenseParticularId = sellingDistributionExpenseParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }
        }

        public static class WorkingCapitalsBean {
            private int id;
            private Long duration;
            private Long quantity;
            private double amount;
            private double rate;
            private String rateDescriprion;
            private Long workingCapitalParticularId;
            private Long businessPlanId;

            public static WorkingCapitalsBean objectFromData(String str) {

                return new Gson().fromJson(str, WorkingCapitalsBean.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Long getDuration() {
                return duration;
            }

            public void setDuration(Long duration) {
                this.duration = duration;
            }

            public Long getQuantity() {
                return quantity;
            }

            public void setQuantity(Long quantity) {
                this.quantity = quantity;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public String getRateDescriprion() {
                return rateDescriprion;
            }

            public void setRateDescriprion(String rateDescriprion) {
                this.rateDescriprion = rateDescriprion;
            }

            public Long getWorkingCapitalParticularId() {
                return workingCapitalParticularId;
            }

            public void setWorkingCapitalParticularId(Long workingCapitalParticularId) {
                this.workingCapitalParticularId = workingCapitalParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }
        }

        public static class FinanceMeansBean {
            private Long createdBy;
            private Long modifiedBy;
            private Long createdDate;
            private Long id;
            private String remarks;
            private double amount;
            private Long businessPlanId;
            private Long financeMeansParticularId;
            private boolean deleted;

            public static FinanceMeansBean objectFromData(String str) {

                return new Gson().fromJson(str, FinanceMeansBean.class);
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

            public Long getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(Long createdDate) {
                this.createdDate = createdDate;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
                this.businessPlanId = businessPlanId;
            }

            public Long getFinanceMeansParticularId() {
                return financeMeansParticularId;
            }

            public void setFinanceMeansParticularId(Long financeMeansParticularId) {
                this.financeMeansParticularId = financeMeansParticularId;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }
        }

        public static class InterestsBean {
            private Long createdBy;
            private Long modifiedBy;
            private Long createdDate;
            private Long id;
            private double loanAmount;
            private Long interestRate;
            private int loanPeriod;
            private double totalInterest;
            private Long moratoriumPeriod;
            private Long interestParticularId;
            private Long businessPlanId;
            private boolean deleted;

            public static InterestsBean objectFromData(String str) {

                return new Gson().fromJson(str, InterestsBean.class);
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

            public Long getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(Long createdDate) {
                this.createdDate = createdDate;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public double getLoanAmount() {
                return loanAmount;
            }

            public void setLoanAmount(double loanAmount) {
                this.loanAmount = loanAmount;
            }

            public Long getInterestRate() {
                return interestRate;
            }

            public void setInterestRate(Long interestRate) {
                this.interestRate = interestRate;
            }

            public int getLoanPeriod() {
                return loanPeriod;
            }

            public void setLoanPeriod(int loanPeriod) {
                this.loanPeriod = loanPeriod;
            }

            public double getTotalInterest() {
                return totalInterest;
            }

            public void setTotalInterest(double totalInterest) {
                this.totalInterest = totalInterest;
            }

            public Long getMoratoriumPeriod() {
                return moratoriumPeriod;
            }

            public void setMoratoriumPeriod(Long moratoriumPeriod) {
                this.moratoriumPeriod = moratoriumPeriod;
            }

            public Long getInterestParticularId() {
                return interestParticularId;
            }

            public void setInterestParticularId(Long interestParticularId) {
                this.interestParticularId = interestParticularId;
            }

            public Long getBusinessPlanId() {
                return businessPlanId;
            }

            public void setBusinessPlanId(Long businessPlanId) {
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
}
