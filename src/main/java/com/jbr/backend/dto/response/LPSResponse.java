package com.jbr.backend.dto.response;

public class LPSResponse {
    private String location;

    private String count;

    public LPSResponse(String location, String count) {
        this.location = location;
        this.count = count;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LPSResponse{" +
                "location='" + location + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
