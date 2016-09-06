package net.beifeng.mobile_scm.sup.entity;

import java.util.Date;

public class Bill {

    private Date date;
    private Double initBalance;
    private Double out;
    private Double in;
    private Double lastBalance;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getInitBalance() {
        return initBalance;
    }

    public void setInitBalance(Double initBalance) {
        this.initBalance = initBalance;
    }

    public Double getOut() {
        return out;
    }

    public void setOut(Double out) {
        this.out = out;
    }

    public Double getIn() {
        return in;
    }

    public void setIn(Double in) {
        this.in = in;
    }

    public Double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(Double lastBalance) {
        this.lastBalance = lastBalance;
    }

}
