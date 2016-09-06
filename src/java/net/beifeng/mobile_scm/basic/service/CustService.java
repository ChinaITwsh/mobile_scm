package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Customer;

public interface CustService {

    Customer getCustById(String custid) throws SQLException;
    
    List getCust(Customer cust) throws SQLException;

    void addCust(Customer cust) throws SQLException;

    void editCust(Customer cust) throws SQLException;

    void delCustById(String custid) throws SQLException;

}
