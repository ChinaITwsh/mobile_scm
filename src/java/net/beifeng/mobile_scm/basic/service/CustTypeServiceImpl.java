package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Customertype;
import net.beifeng.mobile_scm.dao.CommonDao;

public class CustTypeServiceImpl implements CustTypeService {

    private CommonDao dao;

    @Override
    public void addType(Customertype custType) throws SQLException {
        dao.addObj("custType.addType", custType);
    }

    @Override
    public Customertype getTypeById(String custtypeid) throws SQLException {
        return (Customertype) dao.queryObject("custType.getTypeById",
                custtypeid);
    }

    @Override
    public void editType(Customertype custType) throws SQLException {
        dao.editObj("custType.editType", custType);        
    }

    @Override
    public List getType() throws SQLException {        
        return dao.queryList("custType.getType", null);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
