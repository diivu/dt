package com.triapp.Models;

import java.util.List;

/**
 * Created by Developer on 9/15/2017.
 */

public class EducationJobProfileDTO {

    private Long entrepreneurId;

    private List<EducationQualificationModel> educationalQualifications;

    private List<SpecialTrainingModel> specialTrainings;

    private List<WorkExperienceModel> workExperiences;

    private int code;
    private Object data;
    private String message;
    private String description;

    public Long getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(Long entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }

    public List<EducationQualificationModel> getEducationalQualifications() {
        return educationalQualifications;
    }

    public void setEducationalQualifications(List<EducationQualificationModel> educationalQualifications) {
        this.educationalQualifications = educationalQualifications;
    }

    public List<SpecialTrainingModel> getSpecialTrainings() {
        return specialTrainings;
    }

    public void setSpecialTrainings(List<SpecialTrainingModel> specialTrainings) {
        this.specialTrainings = specialTrainings;
    }

    public List<WorkExperienceModel> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperienceModel> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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
}
