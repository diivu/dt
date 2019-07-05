package com.triapp.Models;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Developer on 11-01-2018.
 */

public class GrowthPlanGrowthPurposeListModel {


    private int code;
    private DataBean data;
    private String message;
    private Object description;

    public static GrowthPlanGrowthPurposeListModel objectFromData(String str) {

        return new Gson().fromJson(str, GrowthPlanGrowthPurposeListModel.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public static class DataBean {
        private List<ListGPPurposeBean> listGPPurpose;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public List<ListGPPurposeBean> getListGPPurpose() {
            return listGPPurpose;
        }

        public void setListGPPurpose(List<ListGPPurposeBean> listGPPurpose) {
            this.listGPPurpose = listGPPurpose;
        }

        public static class ListGPPurposeBean {
            private Long id;
            private String value;

            public static ListGPPurposeBean objectFromData(String str) {

                return new Gson().fromJson(str, ListGPPurposeBean.class);
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
