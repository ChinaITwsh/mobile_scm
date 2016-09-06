package net.beifeng.mobile_scm.sup.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.sto.entity.StoMobstock;
import net.beifeng.mobile_scm.sup.entity.Mobstockin;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;

public class MobStockInServiceImpl implements MobStockInService {

    @Override
    public void addInvoice(Mobstockin msi, Suptradedetail suptradedetail,
            List<Map> snList, List<StoMobstock> mobStockList, CommonDao dao) throws SQLException {
        dao.addObj("mobStockIn.addMsi", msi);
        dao.addObj("supTradeDetail.addDetail", suptradedetail);
        dao.batchInsert("mobStockIn.addSns", snList);
        dao.batchInsert("mobStock.addStock", mobStockList);

    }

}
