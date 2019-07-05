package com.triapp.Models;

/**
 * Created by Developer on 04-08-2017.
 */

public class DistrinctListModel {

    private  String strDistrictName;
    private int  intStateID;
    private Long  districtID;

    public String getStrDistrictName() {
        return strDistrictName;
    }

    public void setStrDistrictName(String strDistrictName) {
        this.strDistrictName = strDistrictName;
    }

    public Long getIntDistrinctID() {
        return districtID;
    }

    public void setIntDistrinctID(Long districtID) {
        this.districtID = districtID;
    }

    public int getIntStateID() {
        return intStateID;
    }

    public void setIntStateID(int intStateID) {
        this.intStateID = intStateID;
    }
}
