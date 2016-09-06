package net.beifeng.mobile_scm.sup.action;

import net.beifeng.mobile_scm.system.action.BasicAction;

public class PriceEnsureAction extends BasicAction {

    public String list() throws Exception {
        // 准备和处理起止时间,供应商,机型相关列表数据用于查询
        // 分页查询历史单据
        return "list"; // 进入一个列表页面
    }

    /**
     * 转到添加保价单页面(单据的添加页面,不包括串号处理)
     * 
     * @return
     * @throws Exception
     */
    public String toAdd() throws Exception {
        // 初始化相关列表用于页面select列表
        return "add"; // 添加单据页面:供应商\机型\保价单价\备注
    }

    /**
     * 保存单据信息
     * 
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        // 添充单据其它信息:单号,录入人,机构...
        // 保存单据 dao.add()...
        // 同步生成交易明细

        // 转到串号管理页面
        return "snManage"; // redirect类型result, 单据ID参数传递到管理ACTION
    }

    /**
     * 串号管理,(进入点:添加完新单据,修改单据)
     * 
     * @return
     * @throws Exception
     */
    public String snManage() throws Exception {
        // 从参数中获得单据ID
        // 根据单据ID查询出单据详细信息,用于显示在页面顶部
        
        //根据单据ID查询出所有已添加串号,将串号列表显示在页面(页面上可以删除串号)
        
        //查询串号按钮 -- 打开窗口,窗口页面中显示出所有可以保价串号
        
        
        return "snManage";
    }
    
    /**
     * 在弹出窗口中显示各类串号
     * @return
     * @throws Exception
     */
    public String querySn() throws Exception {
        //查询对应供应商\机型\当前用户部门    ,所有未保价串号
        //查询已保价串号 -- 供应商\机型\起止日期 ,不重复的
        //退机\换机 列表, 到全部未保列表筛选
        return "querySn"; //此页面中分类显示串号
    }
    
    public String addSn() {
        //串号加入表,更新单据表,交易明细的数量,金额
        return "snManage";
    }
    
    public String check() {
        //库存成本
        //如果保价串号在库存中存在,库本成本=原成本-保价单价
        //update sto_mobStock set cost=cost-#unitPrice# where sn1=#sn1#
        return SUCCESS;
    }
    
    public void delSn() {
        //从参数获取到sn1,单据号码
        //从串号表中删除对应行(条件:sn1=#sn1# and invoiceid=#invoiceid#);
        //单据的数量\总金额字段减一
        //out对象输出一个成功信息
    }
}
