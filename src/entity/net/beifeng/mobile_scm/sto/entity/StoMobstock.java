package net.beifeng.mobile_scm.sto.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StoMobstock {

    private String sn1;

    private String sn2;

    private String mobtypeid;
    private String mobTypeName;

    private String color;

    private String config;

    private String firstsupplierid;
    private String firstSupName;

    private Date firstintime;

    private String lastsupplierid;

    private Date lastintime;

    private BigDecimal buyprice;

    private BigDecimal cost;

    private BigDecimal lossamount;

    private String orgid;

    private Integer status;

    public String getSn1() {
        return sn1;
    }

    public void setSn1(String sn1) {
        this.sn1 = sn1;
    }

    public String getSn2() {
        return sn2;
    }

    public void setSn2(String sn2) {
        this.sn2 = sn2;
    }

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid;
    }

    public String getColor() {
        return color;
    }

    public String getMobTypeName() {
        return mobTypeName;
    }

    public void setMobTypeName(String mobTypeName) {
        this.mobTypeName = mobTypeName;
    }

    public String getFirstSupName() {
        return firstSupName;
    }

    public void setFirstSupName(String firstSupName) {
        this.firstSupName = firstSupName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getFirstsupplierid() {
        return firstsupplierid;
    }

    public void setFirstsupplierid(String firstsupplierid) {
        this.firstsupplierid = firstsupplierid;
    }

    public Date getFirstintime() {
        return firstintime;
    }

    public void setFirstintime(Date firstintime) {
        this.firstintime = firstintime;
    }

    public String getLastsupplierid() {
        return lastsupplierid;
    }

    public void setLastsupplierid(String lastsupplierid) {
        this.lastsupplierid = lastsupplierid;
    }

    public Date getLastintime() {
        return lastintime;
    }

    public void setLastintime(Date lastintime) {
        this.lastintime = lastintime;
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getLossamount() {
        return lossamount;
    }

    public void setLossamount(BigDecimal lossamount) {
        this.lossamount = lossamount;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}