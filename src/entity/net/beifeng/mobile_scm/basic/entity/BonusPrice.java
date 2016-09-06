package net.beifeng.mobile_scm.basic.entity;

import java.io.Serializable;

public class BonusPrice implements Serializable {

    private static final long serialVersionUID = 6552897622196938591L;
    
    private String bonusTypeId;
    private String bonusTypeName;
    private Double bonusPrice;

    private String id;
    private String mobTypeId;

    public String getBonusTypeId() {
        return bonusTypeId;
    }

    public void setBonusTypeId(String bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }

    public String getBonusTypeName() {
        return bonusTypeName;
    }

    public void setBonusTypeName(String bonusTypeName) {
        this.bonusTypeName = bonusTypeName;
    }

    public Double getBonusPrice() {
        return bonusPrice;
    }

    public void setBonusPrice(Double bonusPrice) {
        this.bonusPrice = bonusPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobTypeId() {
        return mobTypeId;
    }

    public void setMobTypeId(String mobTypeId) {
        this.mobTypeId = mobTypeId;
    }

}
