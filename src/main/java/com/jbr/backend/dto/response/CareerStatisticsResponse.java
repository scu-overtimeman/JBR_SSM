package com.jbr.backend.dto.response;

public class CareerStatisticsResponse {
    private String position;
    private String count;

    public CareerStatisticsResponse(String position, String count) {
        this.position = position;
        this.count = count;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
