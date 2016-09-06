package net.beifeng.mobile_scm.sup.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import net.beifeng.mobile_scm.sup.entity.Suptradedetail;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class TradeDetailAction extends BasicAction implements
        ModelDriven<Suptradedetail> {

    private Suptradedetail suptradedetail = new Suptradedetail();
    private List<Suptradedetail> suptradedetailList;

    private Date startDate;
    private Date endDate;

    public String showDetail() throws Exception {
        // 起止日期
        // 供应商ID

        // 型号查询 -- 包含手机和配件的型号
        // dao.queryList(手机型号) ==返回javaBean,{typeid, typename}
        // dao.queryList(配件型号)
        // listMob.addAll(listPj);

        // 交易类别:入库,返利,退货,换货,保价

        // 分页查询.

        return SUCCESS;
    }

    public void setSuptradedetail(Suptradedetail suptradedetail) {
        this.suptradedetail = suptradedetail;
    }

    public List<Suptradedetail> getSuptradedetailList() {
        return suptradedetailList;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public Suptradedetail getModel() {
        return suptradedetail;
    }

}
