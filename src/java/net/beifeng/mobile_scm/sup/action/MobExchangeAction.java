package net.beifeng.mobile_scm.sup.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;

import net.beifeng.mobile_scm.basic.entity.Mobtype;
import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.sto.entity.StoMobstock;
import net.beifeng.mobile_scm.sup.entity.MobExchange;
import net.beifeng.mobile_scm.sup.entity.MobExchangeSns;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.system.entity.SysUsers;

public class MobExchangeAction extends BasicAction implements
        ModelDriven<MobExchange> {

    private static final long serialVersionUID = 5491288617286302658L;

    private List<Supplier> supList;
    private List<Mobtype> mtList;
    private List<String> colorList;

    private MobExchange mobExchange = new MobExchange();

    private List<MobExchangeSns> exchangeSnList;

    public String list() throws Exception {
        // 处理起止时间
        // 获取相关下拉列表
        // 获取当前用户查询范围
        // 根据相关条件分页查询换机单
        paginatedQuery("mobEx.getInvoice");
        return "list";
    }

    @SuppressWarnings("unchecked")
    public String toAdd() throws SQLException {
        supList = dao.queryList("sup.getSup", null);
        mtList = dao.queryList("mobType.getType", null);
        return "add";
    }

    public String add() throws SQLException {
        mobExchange.setInvoiceid("MEX-" + new Date().getTime());
        mobExchange.setStatus(0);
        mobExchange.setInputuserid(((SysUsers) session.get("loginUser"))
                .getUserId());
        mobExchange.setInputdate(new Date());
        dao.addObj("mobEx.addInvoice", mobExchange);

        // 供应商交易明细处理
        // ....

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String snManage() throws SQLException {
        // 获取单据完全信息
        Map map = new HashMap();
        map.put("mobEx", mobExchange);
        mobExchange = (MobExchange) dao.queryObject("mobEx.getInvoice", map);
        // 获取关联串号信息
        exchangeSnList = dao.queryList("mobEx.getSns", mobExchange
                .getInvoiceid());

        colorList = dao.queryList("color.getColor", null);

        String errInfo = request.getParameter("errInfo");
        errMap.put("snNotExist", errInfo);

        return "snManage";
    }

    public String addSn() throws SQLException {
        // 获取参数
        String oldSn1 = request.getParameter("oldsn1");
        String newSn1 = request.getParameter("newsn1");
        String newSn2 = request.getParameter("newsn2");
        String newColor = request.getParameter("newcolor");

        // 校验参数
        SysUsers loginUser = (SysUsers) session.get("loginUser");
        String orgId = (String) dao.queryObject("user.getOrgIdByUserId",
                loginUser.getUserId());

        Map map = new HashMap();
        map.put("orgId", orgId);
        map.put("status", 1);
        map.put("sn1", oldSn1);

        StoMobstock mobstock = (StoMobstock) dao.queryObject(
                "mobStock.findStockByPk", map);
        if (mobstock == null) {
            errMap.put("snNotExist", "串号不存在");
        } else {// 完成添加
            MobExchangeSns sn = new MobExchangeSns();
            sn.setInvoiceid(mobExchange.getInvoiceid());
            sn.setOldsn1(oldSn1);
            sn.setOldsn2(mobstock.getSn2());
            sn.setOldcolor(mobstock.getColor());
            sn.setNewsn1(newSn1);
            sn.setNewsn2(newSn2);
            sn.setNewcolor(newSn1 == null ? null : newColor);
            dao.addObj("", sn);
            
            //更新换机单
            dao.editObj("", mobExchange.getInvoiceid());
            // update sup_mobExSns amount=amount+1, totalmoney=(amount+1)*unitprice where invoiceid=#value#
            
            //同步更新交易明细
            //..
            
            //处理库存状态 - 2
            //update sto_mobstock set status=2 where sn1=#sn1#
            
            
        }

        return SUCCESS;
    }

    public String delSn() {
        
        //获取参数
        
        //删除串号表中串号
        
        
        //更新换机单
        //dao.editObj("", mobExchange.getInvoiceid());
        // update sup_mobExSns amount=amount-1, totalmoney=(amount-1)*unitprice where invoiceid=#value#
        
        //同步更新交易明细
        //..
        
        //处理库存状态 - 1
        //update sto_mobstock set status=1 where sn1=#sn1#
        return SUCCESS;
    }

    public String updateSn() {
        //更新串号表,添入新串号
        //update sns set newsn1=..., newsn2=.. , newcolor=.. where invoicid=#invoiceid# and oldsn1=#oldsn1#
        return SUCCESS;
    }

    public String check() {
        // 换机单审核人,审核日期,状态
        // 交易明细相关记录状态

        //校验. newsn1是否已经输入
     
        // update sn1=newsn1, sn2=newsn2,color=newcolor,status=1 where sn1=oldsn1

      
        return SUCCESS;
    }

    public String del() {
        // 删除换机单及对应串号列表
        // 删除交易明细记录
        // 恢复库存中对应串号状态为1
        return SUCCESS;
    }

    public List<Supplier> getSupList() {
        return supList;
    }

    public List<Mobtype> getMtList() {
        return mtList;
    }

    @Override
    public MobExchange getModel() {
        return mobExchange;
    }

    public MobExchange getMobExchange() {
        return mobExchange;
    }

    public List<MobExchangeSns> getExchangeSnList() {
        return exchangeSnList;
    }

    public List<String> getColorList() {
        return colorList;
    }

}
