package com.sys.entity;

import java.io.Serializable;

/**
 * 系统参数
 * @author y_zzu 2020-01-07-14:01
 */
public class SysParam implements Serializable {
    private static final long serialVersionUID = -6193297452174233687L;

    private Long sysParamId;
    private String sysParamField;
    private String sysParamValue;
    private String sysParamText;
    private String sysParamType;

    public SysParam(Long sysParamId, String sysParamField, String sysParamValue, String sysParamText, String sysParamType) {
        this.sysParamId = sysParamId;
        this.sysParamField = sysParamField;
        this.sysParamValue = sysParamValue;
        this.sysParamText = sysParamText;
        this.sysParamType = sysParamType;
    }

    public SysParam() {
    }

    public Long getSysParamId() {
        return sysParamId;
    }

    @Override
    public String toString() {
        return "SysParam{" +
                "sysParamId=" + sysParamId +
                ", sysParamField='" + sysParamField + '\'' +
                ", sysParamValue='" + sysParamValue + '\'' +
                ", sysParamText='" + sysParamText + '\'' +
                ", sysParamType='" + sysParamType + '\'' +
                '}';
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getSysParamField() {
        return sysParamField;
    }

    public void setSysParamField(String sysParamField) {
        this.sysParamField = sysParamField;
    }

    public String getSysParamValue() {
        return sysParamValue;
    }

    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue;
    }

    public String getSysParamText() {
        return sysParamText;
    }

    public void setSysParamText(String sysParamText) {
        this.sysParamText = sysParamText;
    }

    public String getSysParamType() {
        return sysParamType;
    }

    public void setSysParamType(String sysParamType) {
        this.sysParamType = sysParamType;
    }
}
