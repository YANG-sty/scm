package com.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AccountRecords implements Serializable {
    private static final long serialVersionUID = 3861938393081948939L;
    private String arId;

    private Integer supId;

    private Date arDate;

    private String arOrderId;

    private String arBusType;

    private BigDecimal arPayable;

    private BigDecimal arPaid;

    private BigDecimal arArrears;

    private BigDecimal arDiscount;

    private String arAttn;

    private Integer arOperator;

    private String arRemark;

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Date getArDate() {
        return arDate;
    }

    public void setArDate(Date arDate) {
        this.arDate = arDate;
    }

    public String getArOrderId() {
        return arOrderId;
    }

    public void setArOrderId(String arOrderId) {
        this.arOrderId = arOrderId;
    }

    public String getArBusType() {
        return arBusType;
    }

    public void setArBusType(String arBusType) {
        this.arBusType = arBusType;
    }

    public BigDecimal getArPayable() {
        return arPayable;
    }

    public void setArPayable(BigDecimal arPayable) {
        this.arPayable = arPayable;
    }

    public BigDecimal getArPaid() {
        return arPaid;
    }

    public void setArPaid(BigDecimal arPaid) {
        this.arPaid = arPaid;
    }

    public BigDecimal getArArrears() {
        return arArrears;
    }

    public void setArArrears(BigDecimal arArrears) {
        this.arArrears = arArrears;
    }

    public BigDecimal getArDiscount() {
        return arDiscount;
    }

    public void setArDiscount(BigDecimal arDiscount) {
        this.arDiscount = arDiscount;
    }

    public String getArAttn() {
        return arAttn;
    }

    public void setArAttn(String arAttn) {
        this.arAttn = arAttn;
    }

    public Integer getArOperator() {
        return arOperator;
    }

    public void setArOperator(Integer arOperator) {
        this.arOperator = arOperator;
    }

    public String getArRemark() {
        return arRemark;
    }

    public void setArRemark(String arRemark) {
        this.arRemark = arRemark;
    }

    public AccountRecords() {
    }

    public AccountRecords(String arId, Integer supId, Date arDate, String arOrderId, String arBusType, BigDecimal arPayable, BigDecimal arPaid, BigDecimal arArrears, BigDecimal arDiscount, String arAttn, Integer arOperator, String arRemark) {
        this.arId = arId;
        this.supId = supId;
        this.arDate = arDate;
        this.arOrderId = arOrderId;
        this.arBusType = arBusType;
        this.arPayable = arPayable;
        this.arPaid = arPaid;
        this.arArrears = arArrears;
        this.arDiscount = arDiscount;
        this.arAttn = arAttn;
        this.arOperator = arOperator;
        this.arRemark = arRemark;
    }
}