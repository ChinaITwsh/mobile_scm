package net.beifeng.mobile_scm.system.action;

import java.io.PrintWriter;
import java.util.List;

import net.beifeng.mobile_scm.system.entity.SysAction;
import net.beifeng.mobile_scm.system.entity.SysMenu;
import net.beifeng.mobile_scm.system.entity.SysRole;
import net.beifeng.mobile_scm.system.service.MenuManageService;
import net.beifeng.mobile_scm.system.service.RoleManageService;

public class PrivManageAction extends BasicAction {

    private static final long serialVersionUID = 5153832442050946195L;

    private RoleManageService roleManageService;
    private MenuManageService menuManageService;

    private SysMenu menuTree;
    private List<SysRole> roleList;

    private String menuId;
    private List<SysAction> actions;

    private Object[] privileges;
    private String roleId;

    private String[] menuIds;
    private String[] actionIds;
    
    public String init() throws Exception {
        roleList = roleManageService.getRoleList(null,
                new Integer[] { SysRole.ROLESTAT_ENABLE });
        return "init";
    }

    public String loadTree() throws Exception {
        menuTree = new SysMenu();
        menuTree.setMenuId("root");
        menuTree.setMenuName((String) application.getAttribute("sysname"));
        menuTree.setType(SysMenu.MENUTYPE_PARENT);
        menuTree.setSubMenuList(menuManageService.getMenuTree(menuTree
                .getMenuId(), null));
        return "menuTree";
    }

    public String loadAction() throws Exception {
        SysAction paraAction = new SysAction();
        paraAction.setMenuId(menuId);
        paraAction.setType(SysAction.ACTIONTYPE_AUTHOR);
        actions = menuManageService.getActions(paraAction);
        return "actions";
    }

    public String loadPrivs() throws Exception {
        privileges = new Object[2];
        privileges[0] = roleManageService.getPrivMenuIds(roleId);
        privileges[1] = roleManageService.getPrivActionIds(roleId);
        return "privs";
    }

    public void savePrivs() throws Exception {
        roleManageService.relateMenuPriv(roleId, menuIds);
        roleManageService.relateActionPriv(roleId, actionIds);
        PrintWriter out = response.getWriter();
        out.print("succ");
        out.close();
    }

    public void setRoleManageService(RoleManageService roleManageService) {
        this.roleManageService = roleManageService;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setMenuManageService(MenuManageService menuManageService) {
        this.menuManageService = menuManageService;
    }

    public SysMenu getMenuTree() {
        return menuTree;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public List<SysAction> getActions() {
        return actions;
    }

    public Object[] getPrivileges() {
        return privileges;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setMenuIds(String[] menuIds) {
        this.menuIds = menuIds;
    }

    public void setActionIds(String[] actionIds) {
        this.actionIds = actionIds;
    }

}
