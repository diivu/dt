package com.triapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Developer on 8/17/2017.
 */

public class ParticularsEditedAnswerModel implements Serializable {

    private Long id;
    //private double amount;
    private Long preoperativeExpenditureParticularId;
    private Long businessPlanId;
    private long entrepreneurId;
    ArrayList<SelectedParticularsModel> preoperativeExpenditureList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }*/

    public Long getPreoperativeExpenditureParticularId() {
        return preoperativeExpenditureParticularId;
    }

    public void setPreoperativeExpenditureParticularId(Long preoperativeExpenditureParticularId) {
        this.preoperativeExpenditureParticularId = preoperativeExpenditureParticularId;
    }

    public Long getBusinessPlanId() {
        return businessPlanId;
    }

    public void setBusinessPlanId(Long businessPlanId) {
        this.businessPlanId = businessPlanId;
    }

    public long getEntrepreneurId() {

        return entrepreneurId;
    }

    public void setEntrepreneurId(long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }

    public ArrayList<SelectedParticularsModel> getListOfPreoperativeExpenditureParticular() {
        return preoperativeExpenditureList;
    }

    public void setListOfPreoperativeExpenditureParticular(ArrayList<SelectedParticularsModel> preoperativeExpenditureList) {
        this.preoperativeExpenditureList = preoperativeExpenditureList;
    }
}
