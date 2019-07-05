package com.triapp.Models;

import java.io.Serializable;

/**
 * Created by Svep Developer on 09-10-2017.
 */

public class EventMemberModel implements Serializable {

  private String memberName;
  private Long memberBirthdate;
  private String memberPhoneNumber;
  private Long memberID;
  private Long mobileUserID;
  private double latitude;
  private double longitude;
  private Long createdBy;
  private Long eventID;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getMemberBirthdate() {
        return memberBirthdate;
    }

    public void setMemberBirthdate(Long memberBirthdate) {
        this.memberBirthdate = memberBirthdate;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public Long getMobileUserID() {
        return mobileUserID;
    }

    public void setMobileUserID(Long mobileUserID) {
        this.mobileUserID = mobileUserID;
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }
}
