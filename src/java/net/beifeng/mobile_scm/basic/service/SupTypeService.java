package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Suppliertype;

public interface SupTypeService {

    boolean dupId(String suptypeid) throws SQLException;

    void addType(Suppliertype suppliertype) throws SQLException;

    Suppliertype getType(String suptypeid) throws SQLException;

    void editType(Suppliertype supType) throws SQLException;

    void delType(String suptypeid) throws SQLException;

    List getType() throws SQLException;
}
