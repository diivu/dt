package com.triapp.Models;

/**
 * Created by Developer on 18-08-2017.
 */

public class ReligionListModel {

    private int id ,religionID;
    private String religionName;

    public ReligionListModel() {

    }

    public ReligionListModel(String religionName) {
        this.religionName = religionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReligionID() {
        return religionID;
    }

    public void setReligionID(int religionID) {
        this.religionID = religionID;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }
}
