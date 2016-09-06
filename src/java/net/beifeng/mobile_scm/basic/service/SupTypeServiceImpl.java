package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Suppliertype;
import net.beifeng.mobile_scm.dao.CommonDao;

public class SupTypeServiceImpl implements SupTypeService {

    private CommonDao dao;

    @Override
    public List getType() throws SQLException {        
        return dao.queryList("supType.getType", null);
    }

    @Override
    public Suppliertype getType(String suptypeid) throws SQLException {        
        return (Suppliertype) dao.queryObject("supType.getTypeById", suptypeid);
    }

    @Override
    public void addType(Suppliertype suppliertype) throws SQLException {
        dao.addObj("supType.addType", suppliertype);
    }

    @Override
    public boolean dupId(String suptypeid) throws SQLException {
        List retList = dao.queryList("supType.getTypeById", suptypeid);
        if (retList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void editType(Suppliertype supType) throws SQLException {
        dao.editObj("supType.editType", supType);        
    }

    @Override
    public void delType(String suptypeid) throws SQLException {
       dao.del("supType.delType", suptypeid);
        
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
