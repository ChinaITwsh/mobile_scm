package net.beifeng.mobile_scm.sto.action;

import net.beifeng.mobile_scm.system.action.BasicAction;

public class MobMoveAction extends BasicAction {

    public String list() throws Exception {
        //历史单据查询参数准备
        //。。
        //分页查询单据
        return "list";
    }
    
    public String toAdd() throws Exception {
        //初始化相关列表值
        return "add";
    }
    
    public String add() {
        
        //-------事务处理（service实现)
        
        //填充单据ID，录入人，录入日期字段
        //串号列表获取分析
        
        //给调出部门生成一个销售单
        //销售单相关信息从调拔单来取
        
        //给调入部门生成一个入库单
        //信息也是从调拨单获取
        
        //修改库存信息
        //机构编码改为调入部门编码
        //尾期供应商、尾期供应日期改为调出部门和当前日期
        //成本价改为调拔价
        
        return SUCCESS;
    }
}
