package net.beifeng.mobile_scm.basic.entity;

public class Mobtype {

    private String mobtypeid;

    private String brand;

    private String mobtypename;

    private Double buyprice;

    private String remark;
    
    private String[] bonusList; 

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMobtypename() {
        return mobtypename;
    }

    public void setMobtypename(String mobtypename) {
        this.mobtypename = mobtypename;
    }

    public Double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String[] getBonusList() {
        return bonusList;
    }

    public void setBonusList(String[] bonusList) {
        this.bonusList = bonusList;
    }

}