package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Dept;

public interface DeptManageService {

    List<Dept> getDeptList(Dept dept) throws SQLException;

    void addDept(Dept dept) throws SQLException;

    void editDept(Dept dept) throws SQLException;

    void delDept(Dept dept) throws SQLException;
}
