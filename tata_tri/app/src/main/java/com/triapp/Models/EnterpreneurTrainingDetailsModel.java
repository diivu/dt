package com.triapp.Models;
import java.io.Serializable;
import java.util.List;

/**
 * Created by win on 09-Feb-18.
 */
public class EnterpreneurTrainingDetailsModel {

    private int code;
    private List<DataBean> data;
    private String message;
    private Object description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
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

    public static class DataBean implements Serializable
    {
        private Long id;
        private String trainingName;
        private Long trainingStartDate;
        private Long trainingEndDate;
        private String trainingDescription;
        private Double longitude;
        private Double latitude;
        private Long entrepreneurId;
        private Long createdBy;
        private Long createdDate;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTrainingName() {
            return trainingName;
        }

        public void setTrainingName(String trainingName) {
            this.trainingName = trainingName;
        }

        public Long getTrainingStartDate() {
            return trainingStartDate;
        }

        public void setTrainingStartDate(Long trainingStartDate) {
            this.trainingStartDate = trainingStartDate;
        }

        public Long getTrainingEndDate() {
            return trainingEndDate;
        }

        public void setTrainingEndDate(Long trainingEndDate) {
            this.trainingEndDate = trainingEndDate;
        }

        public String getTrainingDescription() {
            return trainingDescription;
        }

        public void setTrainingDescription(String trainingDescription) {
            this.trainingDescription = trainingDescription;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Long getEntrepreneurId() {
            return entrepreneurId;
        }

        public void setEntrepreneurId(Long entrepreneurId) {
            this.entrepreneurId = entrepreneurId;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public Long getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Long createdDate) {
            this.createdDate = createdDate;
        }
    }

}
