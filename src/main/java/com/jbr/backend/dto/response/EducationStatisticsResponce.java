package com.jbr.backend.dto.response;

public class EducationStatisticsResponce {
    private String education;
    private String count;

    public EducationStatisticsResponce(String education, String count) {
        this.education = education;
        this.count = count;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
