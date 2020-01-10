package com.sys.entity;

import java.io.Serializable;

/**
 * 仓库表
 * @author y_zzu 2020-01-07-14:38
 */
public class StoreHouse implements Serializable {
    private static final long serialVersionUID = -6088725478451530411L;

    private String shId;

    private String shName;

    private String shResponsible;

    private String shPhone;

    private String shAddress;

    private String shType;

    private String shRemark;

    public StoreHouse(String shId, String shName, String shResponsible, String shPhone, String shAddress, String shType, String shRemark) {
        this.shId = shId;
        this.shName = shName;
        this.shResponsible = shResponsible;
        this.shPhone = shPhone;
        this.shAddress = shAddress;
        this.shType = shType;
        this.shRemark = shRemark;
    }

    @Override
    public String toString() {
        return "StoreHouse{" +
                "shId='" + shId + '\'' +
                ", shName='" + shName + '\'' +
                ", shResponsible='" + shResponsible + '\'' +
                ", shPhone='" + shPhone + '\'' +
                ", shAddress='" + shAddress + '\'' +
                ", shType='" + shType + '\'' +
                ", shRemark='" + shRemark + '\'' +
                '}';
    }

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName;
    }

    public String getShResponsible() {
        return shResponsible;
    }

    public void setShResponsible(String shResponsible) {
        this.shResponsible = shResponsible;
    }

    public String getShPhone() {
        return shPhone;
    }

    public void setShPhone(String shPhone) {
        this.shPhone = shPhone;
    }

    public String getShAddress() {
        return shAddress;
    }

    public void setShAddress(String shAddress) {
        this.shAddress = shAddress;
    }

    public String getShType() {
        return shType;
    }

    public void setShType(String shType) {
        this.shType = shType;
    }

    public String getShRemark() {
        return shRemark;
    }

    public void setShRemark(String shRemark) {
        this.shRemark = shRemark;
    }
}
