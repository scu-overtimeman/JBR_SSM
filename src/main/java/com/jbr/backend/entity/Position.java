package com.jbr.backend.entity;

public class Position {

    private String name;
    private String org;
    private String salaryFloor;
    private String salaryCeiling;
    private String edu;
    private String location;

    public Position(String name, String org, String salaryFloor, String salaryCeiling, String edu, String location) {
        this.name = name;
        this.org = org;
        this.salaryFloor = salaryFloor;
        this.salaryCeiling = salaryCeiling;
        this.edu = edu;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getSalaryFloor() {
        return salaryFloor;
    }

    public void setSalaryFloor(String salaryFloor) {
        this.salaryFloor = salaryFloor;
    }

    public String getSalaryCeiling() {
        return salaryCeiling;
    }

    public void setSalaryCeiling(String salaryCeiling) {
        this.salaryCeiling = salaryCeiling;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", org='" + org + '\'' +
                ", salaryFloor='" + salaryFloor + '\'' +
                ", salaryCeiling='" + salaryCeiling + '\'' +
                ", edu='" + edu + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
