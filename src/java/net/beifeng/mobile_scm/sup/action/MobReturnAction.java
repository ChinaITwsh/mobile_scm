package net.beifeng.mobile_scm.sup.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Mobtype;
import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.basic.entity.Suppliertype;
import net.beifeng.mobile_scm.sto.entity.StoMobstock;
import net.beifeng.mobile_scm.sup.entity.MobReturn;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;
import net.beifeng.mobile_scm.sup.service.MobReturnService;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.utils.DateUtils;
import net.beifeng.mobile_scm.utils.StringUtils;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;

public class MobReturnAction extends BasicAction implements
        ModelDriven<MobReturn> {

    private List<Suppliertype> supTypeList;
    private List<Supplier> supList;
    private List<String> brandList;
    private List<Mobtype> mobTypeList;

    private Date startDate;
    private Date endDate;

    private MobReturn mobReturn = new MobReturn();

    private StoMobstock mobstock;

    private String[] orgScope;

    private String[] sns;

    private MobReturnService mobReturnService;

    public String list() throws Exception {
        getLists();
        // 起止时间（一周以前到本周）
        if (endDate == null) {
            endDate = new Date();
        }
        if (startDate == null) {
            startDate = new Date(endDate.getTime() - 7 * 24 * 60 * 60 * 1000);
        }
        endDate = DateUtils.toDayEnd(endDate);
        startDate = DateUtils.toDayStart(startDate);

        // 查询最新的入库单
        SysUsers loginUser = (SysUsers) session.get("loginUser");
        String queryScope = loginUser.getQueryScope();
        orgScope = queryScope.split(",");

        paginatedQuery("mobReturn.getMobReturn");

        return "list";
    }

    public String toAdd() throws Exception {
        getLists();
        return "add";
    }

    @SuppressWarnings("unchecked")
    public String snExist() throws Exception {
        String sn1 = request.getParameter("sn1");

        SysUsers loginUser = (SysUsers) session.get("loginUser");
        String orgId = (String) dao.queryObject("user.getOrgIdByUserId",
                loginUser.getUserId());

        Map map = new HashMap();
        map.put("orgId", orgId);
        map.put("status", 1);
        map.put("sn1", sn1);

        mobstock = (StoMobstock) dao.queryObject("mobStock.findStockByPk", map);

        return "exist";
    }

    public void addString() throws Exception {

        SysUsers loginUser = (SysUsers) session.get("loginUser");

        // 退机单
        mobReturn.setInvoiceid("MR-"
                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        mobReturn.setStatus(0);
        mobReturn.setInputuserid(loginUser.getUserId());
        mobReturn.setInputdate(new Date());
        mobReturn.setOrgid((String) dao.queryObject("user.getOrgIdByUserId",
                loginUser.getUserId()));

        // 交易明细
        Suptradedetail suptradedetail = new Suptradedetail();
        BeanUtils.copyProperties(suptradedetail, mobReturn);
        suptradedetail.setTradetype(Suptradedetail.TRADETYPE_MOBRETURN);

        suptradedetail.setType(mobReturn.getMptypeid());
        suptradedetail.setUnitprice(mobReturn.getReturnprice());

        // 串号
        List<Map> snList = new ArrayList<Map>();
        for (String strSn : sns) {
            String[] tmp = strSn.split(",");
            Map map = new HashMap();
            map.put("sn1", tmp[0]);
            if (tmp.length > 1) {
                map.put("sn2", tmp[1]);
            }
            map.put("id", StringUtils.uniqueKey());
            map.put("invoiceid", mobReturn.getInvoiceid());
            map.put("stat", 3);
            snList.add(map);
        }

        mobReturnService.add(mobReturn, suptradedetail, snList);

        response.getWriter().print("mobReturn_list.do");
    }

    public String check() {
        // 退机单机审核人,审核日期,状态
        // 修改交易明细表状态
        // 库存. 串号列表删除库存
        return SUCCESS;
    }

    public String delInvoice() {
        // 删除退机单表信息,
        // 退机单关联串号表信息删除
        // 交易明细信息删除
        // 库存.状态改回1.
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    private void getLists() throws SQLException {
        // 供应商类别列表
        supTypeList = dao.queryList("supType.getType", null);
        // 供应商列表
        supList = dao.queryList("sup.getSup", null);
        // 品牌列表
        brandList = dao.queryList("brand.getBrand", null);
        // 手机型号列表
        mobTypeList = dao.queryList("mobType.getType", null);
    }

    public List<Suppliertype> getSupTypeList() {
        return supTypeList;
    }

    public List<Supplier> getSupList() {
        return supList;
    }

    public List<String> getBrandList() {
        return brandList;
    }

    public List<Mobtype> getMobTypeList() {
        return mobTypeList;
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

    public void setOrgScope(String[] orgScope) {
        this.orgScope = orgScope;
    }

    @Override
    public MobReturn getModel() {
        return mobReturn;
    }

    public void setMobReturn(MobReturn mobReturn) {
        this.mobReturn = mobReturn;
    }

    public StoMobstock getMobstock() {
        return mobstock;
    }

    public void setSns(String[] sns) {
        this.sns = sns;
    }

    public void setMobReturnService(MobReturnService mobReturnService) {
        this.mobReturnService = mobReturnService;
    }

}
