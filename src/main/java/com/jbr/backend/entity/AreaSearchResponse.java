package com.jbr.backend.entity;

public class AreaSearchResponse {
    private String location;
    private String position;
    private String salary;

    public AreaSearchResponse(String location, String position, String salary) {
        this.location = location;
        this.position = position;
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
