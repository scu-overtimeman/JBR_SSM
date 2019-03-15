package com.jbr.backend.dto.request;

public class SearchSalaryRangeRequest {
    private int ceiling = 0;
    private int floor = 0;

    public int getCeiling() {
        return ceiling;
    }

    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
