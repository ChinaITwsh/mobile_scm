package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.system.entity.SysRole;

public interface RoleManageService {
    
    List<SysRole> getRoleList(SysRole role, Integer[] status)
            throws SQLException;

    void addRole(SysRole role) throws SQLException;

    void editRole(SysRole role) throws SQLException;

    void delRole(SysRole role) throws SQLException;

    void restoreRole(SysRole role) throws SQLException;

    List<Map<String, Object>> getPrivMenuIds(String roleId) throws SQLException;

    List<Map<String, Object>> getPrivActionIds(String roleId)
            throws SQLException;

    void relateMenuPriv(String roleId, String[] menuIds) throws SQLException;

    void relateActionPriv(String roleId, String[] actionIds)
            throws SQLException;
}
