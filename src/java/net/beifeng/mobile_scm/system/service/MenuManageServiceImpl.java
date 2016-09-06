package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.system.entity.MenuType;
import net.beifeng.mobile_scm.system.entity.SysAction;
import net.beifeng.mobile_scm.system.entity.SysMenu;
import net.beifeng.mobile_scm.system.entity.SysRole;
import net.beifeng.mobile_scm.utils.StringUtils;

public class MenuManageServiceImpl implements MenuManageService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    
    public List<SysMenu> getMenuTree(String parentId, List<SysRole> roleList)
            throws SQLException {

        Map<String, Object> paraMap = new HashMap<String, Object>();
        SysMenu paraMenu = new SysMenu();
        paraMenu.setParentId(parentId);
        paraMap.put("menu", paraMenu);
        paraMap.put("roleList", roleList);

        List<SysMenu> menuList = dao.queryList("menu.getMenu", paraMap);

        if (menuList != null && menuList.size() > 0) {
            Iterator<SysMenu> menuIterator = menuList.iterator();
            while (menuIterator.hasNext()) {
                SysMenu menu = menuIterator.next();
                menu.setSubMenuList(getMenuTree(menu.getMenuId(), roleList));
            }
        }

        return menuList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysMenu> getMenu(SysMenu menu) throws SQLException {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("menu", menu);
        return dao.queryList("menu.getMenu", paraMap);
    }

    @Override
    public List<MenuType> getMenuTypeList() {
        List<MenuType> retList = new ArrayList<MenuType>();
        retList.add(new MenuType(SysMenu.MENUTYPE_PARENT, "有子菜单"));
        retList.add(new MenuType(SysMenu.MENUTYPE_NODE, "无子菜单"));
        retList.add(new MenuType(SysMenu.MENUTYPE_LINE, "分隔线"));
        return retList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysAction> getActions(SysAction paraAction) throws SQLException {
        return dao.queryList("menu.getAction", paraAction);
    }

    @Override
    public void addMenu(SysMenu menu) throws SQLException {
        // 菜单ID
        if (menu.getMenuId() == null) {
            menu.setMenuId(StringUtils.uniqueKey());
        }

        // 分隔线
        if (menu.getType() == SysMenu.MENUTYPE_LINE) {
            menu.setMenuName("--分隔线--");
        }

        // Action
        SysAction action = menu.getAction();
        if (action == null) {
            action = new SysAction();
            menu.setAction(action);
        }
        if (menu.getType() == SysMenu.MENUTYPE_NODE) {
            action.setActionId(StringUtils.uniqueKey());
            action.setType(SysAction.ACTIONTYPE_NORMAL);
            action.setRemark("菜单所属动作");
            action.setMenuId(menu.getMenuId());
            dao.addObj("menu.addAction", action);
        } else {
            action.setActionId(null);
        }

        // Sort Order
        if (menu.getSortOrder() == null) {
            Integer max = (Integer) dao.queryObject("menu.getMaxOrder", menu
                    .getParentId());
            menu.setSortOrder(max == null ? 1 : max + 1);
        }

        dao.addObj("menu.addMenu", menu);
    }

    @Override
    public void editMenu(SysMenu menu) throws SQLException {

        if (menu.getType() == SysMenu.MENUTYPE_NODE) {
            dao.editObj("menu.editAction", menu.getAction());
        }

        dao.editObj("menu.editMenu", menu);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delMenu(String menuId, int type) throws SQLException {

        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("menuId", menuId);

        // 删除本菜单
        paraMap.put("table", "sys_menu");
        dao.del("menu.delMenu", paraMap);
        paraMap.put("table", "sys_rolemenu");
        dao.del("menu.delMenu", paraMap);

        // 删除关联动作
        if (type == SysMenu.MENUTYPE_NODE) {
            delActionsByMenu(menuId);
        } else if (type == SysMenu.MENUTYPE_PARENT) {
            // 获得子菜单列表, 递归删除
            List<SysMenu> menuList = getMenuTree(menuId, null);

            if (menuList != null && menuList.size() > 0) {
                Iterator<SysMenu> menuIterator = menuList.iterator();
                while (menuIterator.hasNext()) {
                    SysMenu subMenu = menuIterator.next();
                    delMenu(subMenu.getMenuId(), subMenu.getType());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void delActionsByMenu(String menuId) throws SQLException {
        SysAction paraAction = new SysAction();
        paraAction.setMenuId(menuId);
        List<SysAction> actions = dao.queryList("menu.getAction", paraAction);

        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("actions", actions);
        paraMap.put("table", "sys_roleAction");
        dao.del("menu.delActionList", paraMap);
        paraMap.put("table", "sys_action");
        dao.del("menu.delActionList", paraMap);
    }

    @Override
    public void delActoin(SysAction action) throws SQLException {
        dao.del("menu.delAction", action);
        dao.del("menu.delRoleAction", action.getActionId());
    }

    @Override
    public void moveMenu(SysMenu menu, int i) throws SQLException {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("parentId", menu.getParentId());
        paraMap.put("sortOrder", menu.getSortOrder());

        SysMenu neibMenu = null;
        if (i == 1) {
            // 找到相邻的下一个菜单
            paraMap.put("fun", "min");
            paraMap.put("symbol", ">");
            neibMenu = (SysMenu) dao.queryObject("menu.getNeibMenu", paraMap);
        } else if (i == -1) {
            // 找到相邻的上一个菜单
            paraMap.put("fun", "max");
            paraMap.put("symbol", "<");
            neibMenu = (SysMenu) dao.queryObject("menu.getNeibMenu", paraMap);
        }

        if (neibMenu != null) { // 有相邻菜单交换order

            SysMenu paraMenu = new SysMenu();

            paraMenu.setMenuId(menu.getMenuId());
            paraMenu.setSortOrder(neibMenu.getSortOrder());
            dao.editObj("menu.editMenu", paraMenu);

            paraMenu.setMenuId(neibMenu.getMenuId());
            paraMenu.setSortOrder(menu.getSortOrder());
            dao.editObj("menu.editMenu", paraMenu);
        }
    }

    @Override
    public void addAction(SysAction action) throws SQLException {
        // ID
        if (action.getActionId() == null) {
            action.setActionId(StringUtils.uniqueKey());
        }

        dao.addObj("menu.addAction", action);
    }

    @Override
    public void editAction(SysAction action) throws SQLException {
        dao.editObj("menu.editAction", action);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
