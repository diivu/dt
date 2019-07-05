package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Svep Developer on 09-10-2017.
 */

public class CampaignDataModel implements Serializable {

    private Long id;
    private Long campaignID;
    private String campaignName;
    private Long campaignDate;
    private String campaignAddress;
    private String campaignMoreInfo;
    private double latitude;
    private double longitude;
    private Long mobileUserID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Long campaignID) {
        this.campaignID = campaignID;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Long getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(Long campaignDate) {
        this.campaignDate = campaignDate;
    }

    public String getCampaignAddress() {
        return campaignAddress;
    }

    public void setCampaignAddress(String campaignAddress) {
        this.campaignAddress = campaignAddress;
    }

    public String getCampaignMoreInfo() {
        return campaignMoreInfo;
    }

    public void setCampaignMoreInfo(String campaignMoreInfo) {
        this.campaignMoreInfo = campaignMoreInfo;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Long getMobileUserID() {
        return mobileUserID;
    }

    public void setMobileUserID(Long mobileUserID) {
        this.mobileUserID = mobileUserID;
    }
}
