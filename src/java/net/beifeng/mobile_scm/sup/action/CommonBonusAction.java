package net.beifeng.mobile_scm.sup.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.text.StrTokenizer;

import com.opensymphony.xwork2.ModelDriven;

import net.beifeng.mobile_scm.basic.entity.Bonustype;
import net.beifeng.mobile_scm.basic.entity.Mobtype;
import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.sup.entity.CommonBonus;
import net.beifeng.mobile_scm.sup.entity.CommonBonusSn;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.utils.DateUtils;

public class CommonBonusAction extends BasicAction implements
        ModelDriven<CommonBonus> {

    private List<Supplier> supList;
    private List<Mobtype> mtList;
    private List<Bonustype> bonusTypeList;
    private Date startDate;
    private Date endDate;

    private CommonBonus commonBonus = new CommonBonus();
    List<CommonBonusSn> snList;

    public String list() throws Exception {
        // 查询单据起止日期设定
        // 供应商类别、供应商列表
        // 品牌、机型列表
        // 当前用户查询范围设置
        // 分页查询一般返利单
        return "list";
    }

    @SuppressWarnings("unchecked")
    public String toAdd() throws Exception {
        supList = dao.queryList("sup.getSup", null);
        mtList = dao.queryList("mobType.getType", null);
        bonusTypeList = dao.queryList("bonusType.getType", null);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        startDate = DateUtils.toDayStart(c.getTime());
        endDate = DateUtils.toDayEnd(new Date());
        return "add";
    }

    public String addInvoice() throws Exception {

        // 填充一般返利单其它字段
        commonBonus.setInvoiceid("CB-" + new Date().getTime());
        commonBonus.setInputuserid("");
        commonBonus.setInputdate(new Date());
        commonBonus.setStatus((byte) 0);
        commonBonus.setOrgid("");
        dao.addObj("commonBonus.addInvoice", commonBonus);

        // 生成一条交易明细记录
        // ....

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String snManage() throws Exception {
        commonBonus = (CommonBonus) dao.queryObject("commonBonus.getInvoice",
                commonBonus.getInvoiceid());
        snList = dao
                .queryList("commonBonus.getSns", commonBonus.getInvoiceid());

        Set<String> addedSn1Set = new HashSet<String>();
        Iterator<CommonBonusSn> snIterator = snList.iterator();
        while (snIterator.hasNext()) {
            addedSn1Set.add(snIterator.next().getSn1());
        }
        session.put("addedSn1Set", addedSn1Set);

        return "snManage";
    }

    @SuppressWarnings("unchecked")
    public String toQuerySn() throws Exception {

        commonBonus.setEnddate(DateUtils.toDayEnd(commonBonus.getEnddate()));
        commonBonus.setOrgid((String) dao.queryObject("user.getOrgIdByUserId",
                ((SysUsers) session.get("loginUser")).getUserId()));// 此处获得当前登录用户的机构ID
        List<CommonBonusSn> allSns = dao.queryList(
                "commonBonus.getAllStockInSns", commonBonus);
        // -------------
        // select from mobstockin m join mobstockinsn s on
        // m.invoiceid=s.invoiceid where m.inputdata>#startdate# and m.inputdate
        // <#enddate# and m.supid=#supid# and m.mtid=#mtid# and orgid=#curorgid#
        // --------------

        // 查询出所有此期间内退机记录, 换机记录
        List<String> returnSnList = dao.queryList("commonBonus.getReturnSn",
                commonBonus);
        Set<String> returnSnSet = new HashSet<String>(returnSnList);

        List<String> exSnList = dao.queryList("commonBonus.getExSn",
                commonBonus);
        Set<String> exSnSet = new HashSet<String>(exSnList);

        Set<String> addedSn1Set = (Set<String>) session.get("addedSn1Set");

        Iterator<CommonBonusSn> allSnIterator = allSns.iterator();

        // List normal = new ArrayList();
        List returnM = new ArrayList();
        List ex = new ArrayList();
        while (allSnIterator.hasNext()) {
            CommonBonusSn sn = allSnIterator.next();
            if (addedSn1Set.contains(sn.getSn1())) {
                allSns.remove(sn);
            } else if (returnSnSet.contains(sn.getSn1())) {
                // sn 加入退机列表
                returnM.add(sn);
                allSns.remove(sn);
            } else if (exSnSet.contains(sn.getSn1())) {
                // sn加入换机列表
                ex.add(sn);
                allSns.remove(sn);
            }
        }
        request.setAttribute("normalSn", allSns);
        request.setAttribute("returnSn", returnM);
        request.setAttribute("exSn", ex);
        return "querySn";
    }

    public String check() {
        // 库存中对应串号成本=原成本-返利单价
        return "succ";
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

    public List<Bonustype> getBonusTypeList() {
        return bonusTypeList;
    }

    public List<Mobtype> getMtList() {
        return this.mtList;
    }

    public List<CommonBonusSn> getSnList() {
        return snList;
    }

    @Override
    public CommonBonus getModel() {
        return commonBonus;
    }

    public CommonBonus getCommonBonus() {
        return commonBonus;
    }

}
