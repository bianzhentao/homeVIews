package com.kgc.realEstateInformationQuery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RealEstate {
    private Long id;

    private String cardid;

    private String projectname;

    private String address;

    private String housetype;

    private Integer area;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date buildtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public RealEstate(String cardid, String projectname, String address, String housetype, Integer area, Date buildtime) {
        this.cardid = cardid;
        this.projectname = projectname;
        this.address = address;
        this.housetype = housetype;
        this.area = area;
        this.buildtime = buildtime;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", cardid='" + cardid + '\'' +
                ", projectname='" + projectname + '\'' +
                ", address='" + address + '\'' +
                ", housetype='" + housetype + '\'' +
                ", area=" + area +
                ", buildtime=" + buildtime +
                '}';
    }

    public RealEstate() {
    }
}