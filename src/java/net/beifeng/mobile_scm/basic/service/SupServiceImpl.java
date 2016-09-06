package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.basic.entity.Suppliertype;
import net.beifeng.mobile_scm.dao.CommonDao;

public class SupServiceImpl implements SupService {

    private CommonDao dao;

    @Override
    public void addSup(Supplier supplier) throws SQLException {
        dao.addObj("sup.addSup", supplier);

    }

    @Override
    public void delSup(String supid) throws SQLException {
        dao.del("sup.delSupById", supid);

    }

    @Override
    public boolean dupId(String supid) throws SQLException {
        List retList = dao.queryList("sup.getSupById", supid);
        if (retList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void editSup(Supplier supplier) throws SQLException {
        dao.editObj("sup.editSup", supplier);

    }

    @Override
    public Supplier getSupById(String supid) throws SQLException {
        return (Supplier) dao.queryObject("sup.getSupById", supid);
    }

    @Override
    public List getSupByType(Suppliertype suptype) throws SQLException {
        Map paraMap = new HashMap();
        Supplier supplier = new Supplier();
        supplier.setSupType(suptype);
        paraMap.put("supplier", supplier);
        return dao.queryList("sup.getSup", paraMap);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
