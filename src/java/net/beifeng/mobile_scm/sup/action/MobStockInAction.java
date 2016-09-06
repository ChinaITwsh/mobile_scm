package net.beifeng.mobile_scm.sup.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import net.beifeng.mobile_scm.basic.entity.Mobtype;
import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.basic.entity.Suppliertype;
import net.beifeng.mobile_scm.sto.entity.StoMobstock;
import net.beifeng.mobile_scm.sup.entity.Mobstockin;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;
import net.beifeng.mobile_scm.sup.service.MobStockInService;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.utils.DateUtils;
import net.beifeng.mobile_scm.utils.StringUtils;

import com.opensymphony.xwork2.ModelDriven;

public class MobStockInAction extends BasicAction implements
        ModelDriven<Mobstockin> {

    private static final long serialVersionUID = -1066190073518137076L;

    private List<Suppliertype> supTypeList;
    private List<Supplier> supList;
    private List<String> brandList;
    private List<Mobtype> mobTypeList;
    private List<String> configList;
    private List<String> colorList;

    private Date startDate;
    private Date endDate;

    private Mobstockin msi = new Mobstockin();

    private String[] sns;

    private String[] orgScope;

    private MobStockInService mobStockInService;

    public String list() throws Exception {
        getLists(); // 获取各个列表
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

        paginatedQuery("mobStockIn.getMobStockIn");
        return "list";
    }

    public String toAdd() throws Exception {
        getLists();
        return "add";
    }

    public void findRefPrice() throws Exception {
        String typeid = msi.getMobtypeid();
        Map paraMap = new HashMap();
        Mobtype mobtype = new Mobtype();
        mobtype.setMobtypeid(typeid);
        paraMap.put("mobType", mobtype);
        mobtype = (Mobtype) dao.queryObject("mobType.getType", paraMap);

        PrintWriter out = response.getWriter();
        if (mobtype == null || mobtype.getBuyprice() == null) {
            out.print("");
        } else {
            out.print(mobtype.getBuyprice());
        }
    }

    public void dupSn() throws Exception {
        String sn1 = request.getParameter("sn1");
        String sn2 = request.getParameter("sn2");
        String method = request.getParameter("method");

        PrintWriter out = response.getWriter();

        Integer cnt = (Integer) dao.queryObject("mobStock.findDupSn1", sn1);
        if (cnt > 0) {
            out.print("dup");
            return;
        }

        if (method.equals("double")) {
            cnt = (Integer) dao.queryObject("mobStock.findDupSn2", sn2);
            if (cnt > 0) {
                out.print("dup");
                return;
            }
        }

        out.print("succ");

    }

    public void add() throws Exception {

        msi.setInvoiceid("MIS-"
                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        msi.setInputdate(new Date());
        String userId = ((SysUsers) session.get("loginUser")).getUserId();
        msi.setInputuserid(userId);
        msi.setStatus(Mobstockin.STAT_NOTCHECK);
        msi.setOrgid((String) dao.queryObject("user.getOrgIdByUserId", userId));

        // 交易明细
        Suptradedetail suptradedetail = new Suptradedetail();
        BeanUtils.copyProperties(suptradedetail, msi);
        suptradedetail.setTradetype(Suptradedetail.TRADETYPE_MOBSTOCKIN);
        suptradedetail.setType(msi.getMobtypeid());
        suptradedetail.setUnitprice(msi.getBuyprice());

        List<Map> snList = new ArrayList<Map>();
        List<StoMobstock> mobStockList = new ArrayList<StoMobstock>();
        if (sns != null && sns.length > 0) {
            for (int i = 0; i < sns.length; i++) {
                // 串号表
                String[] sn = sns[i].split(",");
                Map snMap = new HashMap();
                snMap.put("id", StringUtils.uniqueKey());
                snMap.put("invoiceid", msi.getInvoiceid());
                snMap.put("sn1", sn[0]);
                snMap.put("sn2", sn[1]);
                snList.add(snMap);
                // 库存表
                StoMobstock mobstock = new StoMobstock();
                mobstock.setSn1(sn[0]);
                mobstock.setSn2(sn[1]);
                BeanUtils.copyProperties(mobstock, msi);
                mobstock.setFirstsupplierid(msi.getSupplierid());
                mobstock.setFirstintime(msi.getInputdate());
                mobstock.setCost(msi.getBuyprice());
                mobstock.setLossamount(new BigDecimal(0));
                mobStockList.add(mobstock);
            }
        }

        mobStockInService.addInvoice(msi, suptradedetail, snList, mobStockList, dao);
    }

    public String check() throws Exception {
        msi.getInvoiceid();
        
        //--事务管理, service里完成
        
        //取出当前登录用户ID,获得当前时间
        //checkUserId, checkDate
        //更新状态 status = 已审  
        // --更新msi以上三个字段
        
        //交易明细表status\ checkUserId \ checkDate同步更新
        
        //库存表 状态 更新成 已审
        return "succ";
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
        // 配置列表
        configList = dao.queryList("config.getConfig", null);
        // 颜色列表
        colorList = dao.queryList("color.getColor", null);
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

    public void setOrgScope(String[] orgScope) {
        this.orgScope = orgScope;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMsi(Mobstockin msi) {
        this.msi = msi;
    }

    @Override
    public Mobstockin getModel() {
        // TODO Auto-generated method stub
        return msi;
    }

    public List<String> getConfigList() {
        return configList;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setSns(String[] sns) {
        this.sns = sns;
    }

}
