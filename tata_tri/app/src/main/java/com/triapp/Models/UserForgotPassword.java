package com.triapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserForgotPassword {

    @Expose
    private List<ClientForgatPas> clientForgatPass = null;

    public List<ClientForgatPas> getClientForgatPass() {
        return clientForgatPass;
    }

    public void setClientForgatPass(List<ClientForgatPas> clientForgatPass) {
        this.clientForgatPass = clientForgatPass;
    }

    public class ClientForgatPas {

        @SerializedName("mobilenumber")
        @Expose
        private String mobilenumber;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("Password")
        @Expose
        private String password;
        @SerializedName("returnMessage")
        @Expose
        private String returnMessage;

        public String getMobilenumber() {
            return mobilenumber;
        }

        public void setMobilenumber(String mobilenumber) {
            this.mobilenumber = mobilenumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getReturnMessage() {
            return returnMessage;
        }

        public void setReturnMessage(String returnMessage) {
            this.returnMessage = returnMessage;
        }

    }
}
