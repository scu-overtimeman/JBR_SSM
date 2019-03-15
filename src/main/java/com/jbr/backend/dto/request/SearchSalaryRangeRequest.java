package com.jbr.backend.dto.request;

public class SearchSalaryRangeRequest {
    private String ceiling;
    private String floor;

    public String getCeiling() {
        return ceiling;
    }

    public void setCeiling(String ceiling) {
        this.ceiling = ceiling;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
