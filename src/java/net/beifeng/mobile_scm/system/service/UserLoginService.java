package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import net.beifeng.mobile_scm.system.entity.SysUsers;

public interface UserLoginService {

    SysUsers validateUser(String account, String passwd) throws SQLException;

    Set<String> getActionList(List<String> roleIdList) throws SQLException;

}
