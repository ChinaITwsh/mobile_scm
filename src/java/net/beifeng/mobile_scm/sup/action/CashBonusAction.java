package net.beifeng.mobile_scm.sup.action;

import net.beifeng.mobile_scm.system.action.BasicAction;

public class CashBonusAction extends BasicAction {

    private String list() throws Exception {
        
        // 起止日期
        // 供应商类别列表\供应商列表

        // 当前用户查询范围

        // 查询现金返利单
        
        return "list";
    }
    
    private String toAdd() throws Exception {
        //供应商类别列表\供应商列表
        //起止日期
        return "add";
    }
    
    //查询所有可以计算返利的付款信息
    private String queryPay() throws Exception {
        //本部门的,可以计算返利的,还没计算过的
        return "payList";        
    }
    
    private String add() throws Exception {
        //返利单生成
        //同步交易明细
        //付款单标注为已计算过返利
        return SUCCESS;
    }
}
