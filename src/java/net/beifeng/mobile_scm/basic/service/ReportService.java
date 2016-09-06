package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.entity.CountReport;
import net.beifeng.mobile_scm.entity.SaleReport;
import net.beifeng.mobile_scm.utils.DateUtils;

public class ReportService {

    private CommonDao dao;

    public void generateReport() throws SQLException {
        Date now = new Date();

        Date endTime = DateUtils.toDayStart(now);
        Date startTime = new Date(endTime.getTime() - 24 * 60 * 60 * 1000);

        Map map = new HashMap();
        map.put("startTime", startTime);
        map.put("endTime", endTime);

        List<CountReport> countList = new ArrayList<CountReport>();

        List<SaleReport> reportList = dao.queryList("查询销售单", map);
        Iterator<SaleReport> reportIterator = reportList.iterator();
        while (reportIterator.hasNext()) {
            // 用于取得总成本价
            SaleReport sr = reportIterator.next();
            List<String> sn1List = dao.queryList("查询销售单串号一", sr.getInvoiceid());
            Double totalcost = 0.;
            Iterator<String> sn1Iterator = sn1List.iterator();
            while (sn1Iterator.hasNext()) {
                String sn1 = sn1Iterator.next();
                Double cost = (Double) dao.queryObject("按SN1到库存表中查成本", sn1);
                if (cost == null) {
                    cost = (Double) dao.queryObject("按SN1到历史库存表中查成本", sn1);
                }
                totalcost += cost;
            }
            sr.setTotalcost(totalcost);

            // 用于汇总
            boolean hasCount = false;
            String orgId = sr.getOrgid();
            for (int i = 0; i < countList.size(); i++) {
                if (countList.get(i).getOrgid().equals(orgId)) {
                    if (countList.get(i).getMobtypeid().endsWith(
                            sr.getMobtypeid())) {
                        CountReport cr = countList.get(i);
                        cr.setAmount(cr.getAmount() + sr.getAmount());
                        cr.setTotalcost(cr.getTotalcost() + sr.getTotalcost());
                        cr.setTotalmoney(cr.getTotalmoney()
                                + sr.getTotalmoney());
                        // 平均价，毛利
                        hasCount = true;
                        break;
                    }
                }

                if (!hasCount) {

                    CountReport cr = new CountReport();
                    cr.setOrgid(sr.getOrgid());
                    cr.setAmount(sr.getAmount());
                    cr.setMobtypeid(sr.getMobtypeid());
                    cr.setTotalcost(sr.getTotalcost());
                    cr.setTotalmoney(sr.getTotalmoney());
                    cr.setMl(cr.getTotalmoney() - cr.getTotalcost());
                    countList.add(cr);
                }
            }
        }
        
        //将汇总信息存入数据库，以备以后查询
        dao.batchInsert("批量存入汇总信息", countList); 
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
