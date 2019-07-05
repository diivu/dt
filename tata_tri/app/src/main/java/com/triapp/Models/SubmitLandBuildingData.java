package com.triapp.Models;

import java.util.ArrayList;

/**
 * Created by Developer on 8/17/2017.
 */

public class SubmitLandBuildingData {

    private Long businessPlanId;
    private ArrayList<LandBuildingModel> landBuildingExpensesList;
    private Long entrepreneurId;

    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public ArrayList<LandBuildingModel> getLandBuildingExpensesList() {
        return landBuildingExpensesList;
    }

    public void setLandBuildingExpensesList(ArrayList<LandBuildingModel> landBuildingExpensesList) {
        this.landBuildingExpensesList = landBuildingExpensesList;
    }

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }
}
