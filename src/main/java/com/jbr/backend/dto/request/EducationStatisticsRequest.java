package com.jbr.backend.dto.request;

public class EducationStatisticsRequest {
    private String career;

    public EducationStatisticsRequest(String career) {
        this.career = career;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
