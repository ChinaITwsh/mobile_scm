package net.beifeng.mobile_scm.sup.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.sup.entity.MobReturn;
import net.beifeng.mobile_scm.sup.entity.Suptradedetail;

public class MobReturnServiceImpl implements MobReturnService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public void add(MobReturn mobReturn, Suptradedetail suptradedetail,
            List<Map> snList) throws SQLException {
        dao.addObj("mobReturn.add", mobReturn);
        dao.addObj("supTradeDetail.addDetail", suptradedetail);
        dao.batchInsert("mobReturn.addSns", snList);
        dao.batchUpdate("mobStock.editStat", snList);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
