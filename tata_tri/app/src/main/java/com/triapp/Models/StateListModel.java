package com.triapp.Models;

/**
 * Created by Developer on 04-08-2017.
 */

public class StateListModel {


    private Long intStateID ;
    private String strStateName ,strStateCode;

    public Long getIntStateID() {
        return intStateID;
    }

    public void setIntStateID(Long intStateID) {
        this.intStateID = intStateID;
    }

    public String getStrStateName() {
        return strStateName;
    }

    public void setStrStateName(String strStateName) {
        this.strStateName = strStateName;
    }

    public String getStrStateCode() {
        return strStateCode;
    }

    public void setStrStateCode(String strStateCode) {
        this.strStateCode = strStateCode;
    }
}
