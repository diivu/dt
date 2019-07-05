package com.triapp.Models;

/**
 * Created by Developer on 8/17/2017.
 */

public class SelectedParticularsModel {

    private Long id;
    private String name;
    private Double amount;
    private Long preoperativeExpenditureParticularId;


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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPreoperativeExpenditureParticularId() {
        return preoperativeExpenditureParticularId;
    }

    public void setPreoperativeExpenditureParticularId(Long preoperativeExpenditureParticularId) {
        this.preoperativeExpenditureParticularId = preoperativeExpenditureParticularId;
    }
}
