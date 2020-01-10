package com.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Supplier implements Serializable {

    private static final long serialVersionUID = 5581641364756567036L;

    private Integer supId;

    private String supName;

    private String supLinkman;

    private String supPhone;

    private String supAddress;

    private String supRemark;

    private BigDecimal supPay;

    private String supType;

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupLinkman() {
        return supLinkman;
    }

    public void setSupLinkman(String supLinkman) {
        this.supLinkman = supLinkman;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getSupRemark() {
        return supRemark;
    }

    public void setSupRemark(String supRemark) {
        this.supRemark = supRemark;
    }

    public BigDecimal getSupPay() {
        return supPay;
    }

    public void setSupPay(BigDecimal supPay) {
        this.supPay = supPay;
    }

    public String getSupType() {
        return supType;
    }

    public void setSupType(String supType) {
        this.supType = supType;
    }

    public Supplier() {
    }

    public Supplier(Integer supId, String supName, String supLinkman, String supPhone, String supAddress, String supRemark, BigDecimal supPay, String supType) {
        this.supId = supId;
        this.supName = supName;
        this.supLinkman = supLinkman;
        this.supPhone = supPhone;
        this.supAddress = supAddress;
        this.supRemark = supRemark;
        this.supPay = supPay;
        this.supType = supType;
    }
}