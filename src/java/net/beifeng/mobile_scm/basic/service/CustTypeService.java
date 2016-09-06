package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Customertype;

public interface CustTypeService {

    Customertype getTypeById(String custtypeid) throws SQLException;

    void addType(Customertype custType) throws SQLException;

    void editType(Customertype custType) throws SQLException;

    List getType() throws SQLException;

}
