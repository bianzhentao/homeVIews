package com.kgc.realEstateInformationQuery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Users {
    private String cardid;

    private String name;

    private Integer gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private String password;

    private Integer status;

    public String getCardid() {
        return cardid;
    }


    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "cardid='" + cardid + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", createtime=" + createtime +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }

    public Users(String cardid, String name, Integer gender, Date createtime, String password, Integer status) {
        this.cardid = cardid;
        this.name = name;
        this.gender = gender;
        this.createtime = createtime;
        this.password = password;
        this.status = status;
    }

    public Users() {
    }
}