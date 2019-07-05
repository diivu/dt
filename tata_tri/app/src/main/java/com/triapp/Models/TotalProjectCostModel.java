package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Svep Developer on 09-10-2017.
 */

public class TotalProjectCostModel implements Serializable {


    private Long entrepreneurId ;
    private Long businessplanId ;
    private Double totalProjectCost;

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }

    public Long getBusinessplanId() {
        return businessplanId;
    }

    public void setBusinessplanId(Long businessplanId) {
        this.businessplanId = businessplanId;
    }

    public Double getTotalProjectCost() {
        return totalProjectCost;
    }

    public void setTotalProjectCost(Double totalProjectCost) {
        this.totalProjectCost = totalProjectCost;
    }
}
