package com.triapp.Models;

/**
 * Created by Developer on 04-08-2017.
 */

public class VillegeListModel {

    private Long villegeId,villegeBlockId;
    private String villegeName;
    private String villageCode;
    private String gpCode;

    public Long getVillegeId() {
        return villegeId;
    }

    public void setVillegeId(Long villegeId) {
        this.villegeId = villegeId;
    }

    public Long getVillegeBlockId() {
        return villegeBlockId;
    }

    public void setVillegeBlockId(Long villegeBlockId) {
        this.villegeBlockId = villegeBlockId;
    }

    public String getVillegeName() {
        return villegeName;
    }

    public void setVillegeName(String villegeName) {
        this.villegeName = villegeName;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getGpCode() {
        return gpCode;
    }

    public void setGpCode(String gpCode) {
        this.gpCode = gpCode;
    }
}
