package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.system.entity.SysUsers;

public interface UserManageService {

    List<SysUsers> getAccList(SysUsers acc, String accName, Integer[] statList) throws SQLException;

    void addAcc(String empId, SysUsers acc) throws SQLException;

    void editAcc(SysUsers acc) throws SQLException;

    void delAcc(SysUsers acc) throws SQLException;

    void restoreAcc(SysUsers acc) throws SQLException;

    void updatePass(SysUsers loginUser) throws SQLException;

}
