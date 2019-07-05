package com.triapp.Models;

/**
 * Created by Developer on 18-08-2017.
 */

public class CastListModel {

    private int id ,castID;
    private String castName;

    public CastListModel() {
    }

    public CastListModel(String castName) {
        this.castName = castName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCastID() {
        return castID;
    }

    public void setCastID(int castID) {
        this.castID = castID;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }
}
