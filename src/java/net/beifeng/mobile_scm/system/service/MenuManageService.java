package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.system.entity.MenuType;
import net.beifeng.mobile_scm.system.entity.SysAction;
import net.beifeng.mobile_scm.system.entity.SysMenu;
import net.beifeng.mobile_scm.system.entity.SysRole;

public interface MenuManageService {

    List<SysMenu> getMenuTree(String parentId, List<SysRole> roleList)
            throws SQLException;

    List<SysMenu> getMenu(SysMenu menu) throws SQLException;

    List<SysAction> getActions(SysAction paraAction) throws SQLException;

    List<MenuType> getMenuTypeList();

    void addMenu(SysMenu menu) throws SQLException;

    void editMenu(SysMenu menu) throws SQLException;

    void delMenu(String menuId, int type) throws SQLException;

    void moveMenu(SysMenu menu, int i) throws SQLException;

    void addAction(SysAction action) throws SQLException;

    void editAction(SysAction action) throws SQLException;

    void delActoin(SysAction action) throws SQLException;
}
