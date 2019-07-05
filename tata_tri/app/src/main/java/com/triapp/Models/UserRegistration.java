package com.triapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegistration {

    @SerializedName("LoginUSer")
    @Expose
    private LoginUSer loginUSer;

    public LoginUSer getLoginUSer() {
        return loginUSer;
    }

    public void setLoginUSer(LoginUSer loginUSer) {
        this.loginUSer = loginUSer;
    }

    public class LoginUSer {

        @SerializedName("returnMessage")
        @Expose
        private String returnMessage;

        public String getReturnMessage() {
            return returnMessage;
        }

        public void setReturnMessage(String returnMessage) {
            this.returnMessage = returnMessage;
        }
    }

}
