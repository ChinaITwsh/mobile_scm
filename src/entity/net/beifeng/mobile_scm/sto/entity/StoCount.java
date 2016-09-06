package net.beifeng.mobile_scm.sto.entity;

import java.io.Serializable;

public class StoCount implements Serializable {

    private static final long serialVersionUID = 1827639638504441958L;

    private String mobtypeid;
    private int amount;
    private Double buyprice;
    private Double cost;
    private Double lossamount;

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getLossamount() {
        return lossamount;
    }

    public void setLossamount(Double lossamount) {
        this.lossamount = lossamount;
    }

}
