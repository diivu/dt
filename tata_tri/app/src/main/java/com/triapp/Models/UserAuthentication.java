package com.triapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAuthentication {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public class Data {

        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("userId")
        @Expose
        private Integer userId;
        @SerializedName("crpEpId")
        @Expose
        private Integer crpEpId;
        @SerializedName("lastSyncTime")
        @Expose
        private Long lastSyncTime;
        @SerializedName("isAbleToMakeTamplateBusinessPlan")
        @Expose
        private Integer isAbleToMakeTamplateBusinessPlan;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getCrpEpId() {
            return crpEpId;
        }

        public void setCrpEpId(Integer crpEpId) {
            this.crpEpId = crpEpId;
        }

        public Long getLastSyncTime() {
            return lastSyncTime;
        }

        public void setLastSyncTime(Long lastSyncTime) {
            this.lastSyncTime = lastSyncTime;
        }

        public Integer getIsAbleToMakeTamplateBusinessPlan() {
            return isAbleToMakeTamplateBusinessPlan;
        }

        public void setIsAbleToMakeTamplateBusinessPlan(Integer isAbleToMakeTamplateBusinessPlan) {
            this.isAbleToMakeTamplateBusinessPlan = isAbleToMakeTamplateBusinessPlan;
        }
    }

}