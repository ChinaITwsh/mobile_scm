package net.beifeng.mobile_scm.sup.action;

import com.opensymphony.xwork2.ModelDriven;

import net.beifeng.mobile_scm.sup.entity.Pay;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class PayAction extends BasicAction implements ModelDriven<Pay> {

    private Pay pay = new Pay();

    public String list() throws Exception {
        // 起止日期
        // 供应商类别列表\供应商列表

        // 当前用户查询范围

        // 查询付款单
        paginatedQuery("pay.getPay");
        return "list";
    }

    public String toAdd() throws Exception {
        // 初始化供应商类别
        // 供应商
        // 帐户列表

        return "add";
    }
    
    public String add() throws Exception {
        
        //完成其它字段的填充,新增付款单
        
        //同步交易明细        
        
        return SUCCESS;
    }
    
    public String del() throws Exception {
        //删除单据记录
        //删除交易明细
        return SUCCESS;
    }
    
    public String check() throws Exception {
        //---事务
        //单据审核人,日期填入,状态1
        //同步交易明细
        
        //**减少帐户余额
        
        return SUCCESS;
    }

    @Override
    public Pay getModel() {
        return pay;
    }
}
