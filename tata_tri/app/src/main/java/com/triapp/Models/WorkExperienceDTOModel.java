package com.triapp.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 8/14/2017.
 */

public class WorkExperienceDTOModel {

    private Long businessPlanId;
    private Long entrepreneurId;

    private List<WorkExperienceModel> workExperienceList;
    private ArrayList<MachinaryModel> machineryList;
    private ArrayList<EquipmentFurnitureModel> equipmentFurnitureList;
    private ArrayList<RawMaterialModel> rawMaterialList;
    private ArrayList<UtilitiesModel> utilities;
    private ArrayList<ManPowerModel> manpowers;
    private ArrayList<AdministrativeModel> administrativeExpenses;
    private ArrayList<SellingDistributionExpensModel> sellingDistributionExpenses;
    private ArrayList<DepricationModel> depreciationList;
    private ArrayList<WorkingCapitalModel> workingCapitals;
    private ArrayList<MeansOfFinanceModel> financeMeans;
    private ArrayList<IntrestModel> interests;
    private List<ProductionDetailsModel> establishedProductionCapacityList;
    private List<SalesRealisationModel> bpSalesRealisationList;


    public Long getBusinessPlanId() {
        return businessPlanId;
    }


    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public List<WorkExperienceModel> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperienceModel> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public ArrayList<MachinaryModel> getMachineryList() {
        return machineryList;
    }

    public void setMachineryList(ArrayList<MachinaryModel> machineryList) {
        this.machineryList = machineryList;
    }

    public ArrayList<EquipmentFurnitureModel> getEquipmentFurnitureList() {
        return equipmentFurnitureList;
    }

    public void setEquipmentFurnitureList(ArrayList<EquipmentFurnitureModel> equipmentFurnitureList) {
        this.equipmentFurnitureList = equipmentFurnitureList;
    }

    public ArrayList<RawMaterialModel> getRawMaterialList() {
        return rawMaterialList;
    }

    public void setRawMaterialList(ArrayList<RawMaterialModel> rawMaterialList) {
        this.rawMaterialList = rawMaterialList;
    }

    public ArrayList<UtilitiesModel> getUtilitiesList() {
        return utilities;
    }

    public void setUtilitiesList(ArrayList<UtilitiesModel> utilities) {
        this.utilities = utilities;
    }

    public ArrayList<ManPowerModel> getManpowerList() {
        return manpowers;
    }

    public void setManpowerList(ArrayList<ManPowerModel> manpowers) {
        this.manpowers = manpowers;
    }

    public ArrayList<AdministrativeModel> getAdministrativeExpensesList() {
        return administrativeExpenses;
    }

    public void setAdministrativeExpensesList(ArrayList<AdministrativeModel> administrativeExpenses) {
        this.administrativeExpenses = administrativeExpenses;
    }

    public ArrayList<SellingDistributionExpensModel> getSellingDistributionExpensesList() {
        return sellingDistributionExpenses;
    }

    public void setSellingDistributionExpensesList(ArrayList<SellingDistributionExpensModel> sellingDistributionExpenses) {
        this.sellingDistributionExpenses = sellingDistributionExpenses;
    }

    public ArrayList<DepricationModel> getDepreciationList() {
        return depreciationList;
    }

    public void setDepreciationList(ArrayList<DepricationModel> depreciationList) {
        this.depreciationList = depreciationList;
    }

    public ArrayList<WorkingCapitalModel> getWorkingCapitalList() {
        return workingCapitals;
    }

    public void setWorkingCapitalList(ArrayList<WorkingCapitalModel> workingCapitals) {
        this.workingCapitals = workingCapitals;
    }

    public ArrayList<MeansOfFinanceModel> getFinanceMeansList() {
        return financeMeans;
    }

    public void setFinanceMeansList(ArrayList<MeansOfFinanceModel> financeMeans) {
        this.financeMeans = financeMeans;
    }

    public ArrayList<IntrestModel> getInterestList() {
        return  interests;
    }

    public void setInterestList(ArrayList<IntrestModel> interests) {
        this. interests =  interests;
    }

    public List<ProductionDetailsModel> getEstablishedProductionCapacityList() {
        return establishedProductionCapacityList;
    }

    public void setEstablishedProductionCapacityList(List<ProductionDetailsModel> establishedProductionCapacityList) {
        this.establishedProductionCapacityList = establishedProductionCapacityList;
    }

    public List<SalesRealisationModel> getBpSalesRealisationList() {
        return bpSalesRealisationList;
    }

    public void setBpSalesRealisationList(List<SalesRealisationModel> bpSalesRealisationList) {
        this.bpSalesRealisationList = bpSalesRealisationList;
    }

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }
}
