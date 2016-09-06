package net.beifeng.mobile_scm.sup.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.sup.entity.Bill;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.utils.DateUtils;

public class BillAction extends BasicAction {

    private Date startDate;
    private Date endDate;

    private List<Supplier> supList;

    private String supId;

    private List<Bill> billList;

    @SuppressWarnings("unchecked")
    public String showBill() throws Exception {

        // 起止时间（一周以前到本周）
        if (endDate == null) {
            endDate = new Date();
        }
        if (startDate == null) {
            startDate = new Date(endDate.getTime() - 7 * 24 * 60 * 60 * 1000);
        }
        endDate = DateUtils.toDayEnd(endDate);
        startDate = DateUtils.toDayStart(startDate);

        supList = dao.queryList("sup.getSup", null);

        Map para = new HashMap();
        para.put("startDate", startDate);
        para.put("endDate", endDate);
        para.put("supId", supId);

        double initBalance = 0;
        Double initOut = (Double) dao
                .queryObject("detail.getAllOut", startDate);
        if (initOut == null) {
            initOut = 0.;
        }
        Double initIn = (Double) dao.queryObject("detail.getAllIn", startDate);
        if (initOut == null) {
            initIn = 0.;
        }
        initBalance = initOut - initIn;

        List<Suptradedetail> detailList = dao.queryList("detail.getDetail",
                para);

        billList = new ArrayList<Bill>();
        for (Date cur = startDate; cur.compareTo(endDate) < 0; cur = new Date(
                cur.getTime() + 24 * 60 * 60 * 1000)) {
            int lastBillIndex = billList.size() - 1;
            double preBalance = 0;
            if (lastBillIndex < 0) {
                preBalance = initBalance;
            } else {
                billList.get(lastBillIndex).getLastBalance();
            }

            billList.add(countBill(cur, detailList, preBalance));
        }

        return SUCCESS;

    }

    private Bill countBill(Date date, List<Suptradedetail> list,
            double initBalance) {
        Date startTime = date;
        Date endTime = new Date(startTime.getTime() + 24 * 60 * 60 * 1000);

        Bill bill = new Bill();
        bill.setInitBalance(initBalance);
        double out = 0;
        double in = 0;

        Iterator<Suptradedetail> detailIterator = list.iterator();
        while (detailIterator.hasNext()) {
            Suptradedetail suptradedetail = detailIterator.next();
            if (suptradedetail.getInputdate().compareTo(startTime) > 0
                    && suptradedetail.getInputdate().compareTo(endTime) < 0) {
                switch (suptradedetail.getTradetype()) {
                case Suptradedetail.TRADETYPE_MOBRETURN:
                    in += suptradedetail.getTotalmoney().doubleValue();
                    break;
                case Suptradedetail.TRADETYPE_MOBSTOCKIN:
                    out += out + suptradedetail.getTotalmoney().doubleValue();
                }
            }
        }
        bill.setLastBalance(initBalance + in - out);
        return bill;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Supplier> getSupList() {
        return supList;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public List<Bill> getBillList() {
        return billList;
    }

}
