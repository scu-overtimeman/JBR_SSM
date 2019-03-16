package com.jbr.backend.entity;

import javax.persistence.*;

@Table(name = "`data_source`")
public class DataSource {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`url`")
    private String url;

    @Column(name = "`checked`")
    private Boolean checked;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * @param checked
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", checked=" + checked +
                '}';
    }
}