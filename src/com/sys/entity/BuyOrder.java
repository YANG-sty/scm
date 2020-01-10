package com.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BuyOrder implements Serializable {
    private static final long serialVersionUID = 3727497970952177210L;

    public List<BuyOrderDetail> buyOrderDetails;

    public List<BuyOrderDetail> getBuyOrderDetails() {
        return buyOrderDetails;
    }

    public void setBuyOrderDetails(List<BuyOrderDetail> buyOrderDetails) {
        this.buyOrderDetails = buyOrderDetails;
    }

    private String boId;

    private Integer supId;

    private String shId;

    private Date boDate;

    private BigDecimal boPayable;

    private BigDecimal boPaid;

    private BigDecimal boArrears;

    private String boOriginal;

    private String boRemark;

    private String boAttn;

    private Integer boOperator;

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId;
    }

    public Date getBoDate() {
        return boDate;
    }

    public void setBoDate(Date boDate) {
        this.boDate = boDate;
    }

    public BigDecimal getBoPayable() {
        return boPayable;
    }

    public void setBoPayable(BigDecimal boPayable) {
        this.boPayable = boPayable;
    }

    public BigDecimal getBoPaid() {
        return boPaid;
    }

    public void setBoPaid(BigDecimal boPaid) {
        this.boPaid = boPaid;
    }

    public BigDecimal getBoArrears() {
        return boArrears;
    }

    public void setBoArrears(BigDecimal boArrears) {
        this.boArrears = boArrears;
    }

    public String getBoOriginal() {
        return boOriginal;
    }

    public void setBoOriginal(String boOriginal) {
        this.boOriginal = boOriginal;
    }

    public String getBoRemark() {
        return boRemark;
    }

    public void setBoRemark(String boRemark) {
        this.boRemark = boRemark;
    }

    public String getBoAttn() {
        return boAttn;
    }

    public void setBoAttn(String boAttn) {
        this.boAttn = boAttn;
    }

    public Integer getBoOperator() {
        return boOperator;
    }

    public void setBoOperator(Integer boOperator) {
        this.boOperator = boOperator;
    }

    public BuyOrder() {
    }

    public BuyOrder(List<BuyOrderDetail> buyOrderDetails, String boId, Integer supId, String shId, Date boDate, BigDecimal boPayable, BigDecimal boPaid, BigDecimal boArrears, String boOriginal, String boRemark, String boAttn, Integer boOperator) {
        this.buyOrderDetails = buyOrderDetails;
        this.boId = boId;
        this.supId = supId;
        this.shId = shId;
        this.boDate = boDate;
        this.boPayable = boPayable;
        this.boPaid = boPaid;
        this.boArrears = boArrears;
        this.boOriginal = boOriginal;
        this.boRemark = boRemark;
        this.boAttn = boAttn;
        this.boOperator = boOperator;
    }
}