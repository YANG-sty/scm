package com.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BuyOrderDetail implements Serializable {
    private static final long serialVersionUID = 3317029645649226338L;
    private String bodId;

    private String goodsId;

    private String goodsName;

    private String goodsUnit;

    private String goodsType;

    private String goodsColor;

    private Integer bodAmount;

    private BigDecimal bodBuyPrice;

    private BigDecimal bodTotalPrice;

    private String boId;

    private String bodImeiList;

    public String getBodId() {
        return bodId;
    }

    public void setBodId(String bodId) {
        this.bodId = bodId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public Integer getBodAmount() {
        return bodAmount;
    }

    public void setBodAmount(Integer bodAmount) {
        this.bodAmount = bodAmount;
    }

    public BigDecimal getBodBuyPrice() {
        return bodBuyPrice;
    }

    public void setBodBuyPrice(BigDecimal bodBuyPrice) {
        this.bodBuyPrice = bodBuyPrice;
    }

    public BigDecimal getBodTotalPrice() {
        return bodTotalPrice;
    }

    public void setBodTotalPrice(BigDecimal bodTotalPrice) {
        this.bodTotalPrice = bodTotalPrice;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getBodImeiList() {
        return bodImeiList;
    }

    public void setBodImeiList(String bodImeiList) {
        this.bodImeiList = bodImeiList;
    }

    public BuyOrderDetail() {
    }

    public BuyOrderDetail(String bodId, String goodsId, String goodsName, String goodsUnit, String goodsType, String goodsColor, Integer bodAmount, BigDecimal bodBuyPrice, BigDecimal bodTotalPrice, String boId, String bodImeiList) {
        this.bodId = bodId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsUnit = goodsUnit;
        this.goodsType = goodsType;
        this.goodsColor = goodsColor;
        this.bodAmount = bodAmount;
        this.bodBuyPrice = bodBuyPrice;
        this.bodTotalPrice = bodTotalPrice;
        this.boId = boId;
        this.bodImeiList = bodImeiList;
    }
}