package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Customer;
import net.beifeng.mobile_scm.dao.CommonDao;

public class CustServiceImpl implements CustService {

    private CommonDao dao;

    @Override
    public void addCust(Customer cust) throws SQLException {
        dao.addObj("cust.addCust", cust);
    }

    @Override
    public void delCustById(String custid) throws SQLException {
        dao.del("cust.delById", custid);

    }

    @Override
    public void editCust(Customer cust) throws SQLException {
        dao.editObj("cust.editCust", cust);

    }

    @Override
    public Customer getCustById(String custid) throws SQLException {
        return (Customer) dao.queryObject("cust.getCustById", custid);
    }

    @Override
    public List getCust(Customer cust) throws SQLException {
        Map paraMap = new HashMap();
        paraMap.put("cust", cust);
        return dao.queryList("cust.getCust", paraMap);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
