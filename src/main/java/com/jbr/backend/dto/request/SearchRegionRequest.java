package com.jbr.backend.dto.request;

public class SearchRegionRequest {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String format(){
        return this.province+"-"+this.city;
    }
}
