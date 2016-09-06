package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Emp;
import net.beifeng.mobile_scm.basic.entity.EmpType;

public interface EmpManageService {

    List<Emp> getEmpList(Emp emp) throws SQLException;

    void addEmp(Emp emp) throws SQLException;

    List<EmpType> getEmpTypeList();

    void delEmp(Emp emp) throws SQLException;

    void editEmp(Emp emp) throws SQLException;

}
