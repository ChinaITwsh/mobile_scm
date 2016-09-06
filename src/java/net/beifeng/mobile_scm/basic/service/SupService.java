package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.basic.entity.Suppliertype;

public interface SupService {

    boolean dupId(String supid) throws SQLException;

    void addSup(Supplier supplier) throws SQLException;

    Supplier getSupById(String supid) throws SQLException;

    void editSup(Supplier supplier) throws SQLException;

    void delSup(String supid) throws SQLException;

    List getSupByType(Suppliertype suptype) throws SQLException;

}
