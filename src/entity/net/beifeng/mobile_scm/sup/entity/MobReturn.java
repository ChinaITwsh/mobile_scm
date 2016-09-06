package net.beifeng.mobile_scm.sup.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MobReturn {

    private String invoiceid;

    private Integer status;
    private String statName;

    private String supTypeId;
    private String supplierid;
    private String supName;

    private String brand;
    private String mptypeid;
    private String mobTypeName;

    private Integer amount;

    private BigDecimal returnprice;

    private BigDecimal totalmoney;

    private String inputuserid;
    private String inputUserName;

    private Date inputdate;

    private Date checkdate;

    private String checkuserid;
    private String checkUserName;

    private String remark;

    private String orgid;
    private String orgName;

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if (status != null) {
            if (status == 0) {
                this.statName = "未审核";
            } else if (status == 1) {
                this.statName = "已审核";
            }
        }
        this.status = status;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getMptypeid() {
        return mptypeid;
    }

    public void setMptypeid(String mptypeid) {
        this.mptypeid = mptypeid;
    }

    public Integer getAmount() {
        return amount;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getReturnprice() {
        return returnprice;
    }

    public void setReturnprice(BigDecimal returnprice) {
        this.returnprice = returnprice;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getInputuserid() {
        return inputuserid;
    }

    public void setInputuserid(String inputuserid) {
        this.inputuserid = inputuserid;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
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

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }
}