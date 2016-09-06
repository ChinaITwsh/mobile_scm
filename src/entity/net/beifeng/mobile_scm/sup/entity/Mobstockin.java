package net.beifeng.mobile_scm.sup.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Mobstockin {

    /** 审核状态 - 未审 **/
    public static final int STAT_NOTCHECK = 0;
    /** 审核状态 - 已审 **/
    public static final int STAT_CHECKED = 1;

    private String invoiceid;

    private String supTypeId;
    private String supplierid;
    private String supName;

    private String brand;
    private String mobtypeid;
    private String mobTypeName;

    private String color;

    private String config;

    private BigDecimal buyprice;

    private Long amount;

    private Double totalmoney;

    private Date inputdate;

    private String inputuserid;
    private String inputUserName;

    private Date checkdate;

    private String checkuserid;
    private String checkUserName;

    private Integer status;
    private String statName;

    private String remark;

    private String orgid;
    private String orgName;

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getMobTypeName() {
        return mobTypeName;
    }

    public void setMobTypeName(String mobTypeName) {
        this.mobTypeName = mobTypeName;
    }

    public String getInputUserName() {
        return inputUserName;
    }

    public void setInputUserName(String inputUserName) {
        this.inputUserName = inputUserName;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
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

    public void setColor(String color) {
        this.color = color;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getInputuserid() {
        return inputuserid;
    }

    public void setInputuserid(String inputuserid) {
        this.inputuserid = inputuserid;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getCheckuserid() {
        return checkuserid;
    }

    public void setCheckuserid(String checkuserid) {
        this.checkuserid = checkuserid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if (status != null) {
            if (status == STAT_CHECKED) {
                this.statName = "已审核";
            } else if (status == STAT_NOTCHECK) {
                this.statName = "未审核";
            }
        }
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getSupTypeId() {
        return supTypeId;
    }

    public void setSupTypeId(String supTypeId) {
        this.supTypeId = supTypeId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}