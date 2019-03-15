package com.jbr.backend.dto.response;

public class PSResponse {
    private String position;
    private String salary;

    public PSResponse(String position, String salary) {
        this.position = position;
        this.salary = salary;
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
