package dev.action;

import java.util.List;

import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.system.entity.MenuType;
import net.beifeng.mobile_scm.system.entity.SysAction;
import net.beifeng.mobile_scm.system.entity.SysMenu;
import net.beifeng.mobile_scm.system.service.MenuManageService;

public class MenuManageAction extends BasicAction {

    private static final long serialVersionUID = 6944768555539680414L;

    private MenuManageService menuManageService;

    private SysMenu menuTree;
    private SysMenu menu;
    private SysMenu parentMenu;
    private List<SysMenu> subMenuList;
    private List<SysAction> normalActionList;
    private List<SysAction> authorActionList;
    private List<MenuType> menuTypeList;
    private boolean refreshTree;

    private SysAction action;

    public String init() {
        return "managePage";
    }

    public String menuTree() throws Exception {
        menuTree = genRoot();
        menuTree.setSubMenuList(menuManageService.getMenuTree(menuTree
                .getMenuId(), null));
        return "menuTree";
    }

    public String menuDetail() throws Exception {
        List<SysMenu> retList = null;
        if (menu.getMenuId().equals("root")) {
            menu = genRoot();
        } else {
            retList = menuManageService.getMenu(menu);
            if (retList != null && retList.size() == 1) {
                menu = retList.get(0);
            }
        }

        SysMenu paraMenu = new SysMenu();

        // 查询父菜单
        if (menu.getParentId() != null) {
            if (menu.getParentId().equals("root")) {
                parentMenu = genRoot();
            } else {
                paraMenu.setMenuId(menu.getParentId());
                retList = menuManageService.getMenu(paraMenu);
                parentMenu = retList.get(0);
            }
        }
        // 查询子菜单
        if (menu.getType() == SysMenu.MENUTYPE_PARENT) {
            paraMenu.setMenuId(null);
            paraMenu.setParentId(menu.getMenuId());
            subMenuList = menuManageService.getMenu(paraMenu);
        }
        // 查询动作
        if (menu.getType() == SysMenu.MENUTYPE_NODE) {
            SysAction paraAction = new SysAction();
            paraAction.setMenuId(menu.getMenuId());
            paraAction.setType(SysAction.ACTIONTYPE_NORMAL);
            normalActionList = menuManageService.getActions(paraAction);

            paraAction.setType(SysAction.ACTIONTYPE_AUTHOR);
            authorActionList = menuManageService.getActions(paraAction);
        }
        return "menuDetail";
    }

    public String toAddSubMenu() throws Exception {
        List<SysMenu> retList = null;
        if (menu.getMenuId().equals("root")) {
            menu = genRoot();
        } else {
            retList = menuManageService.getMenu(menu);
            if (retList != null && retList.size() == 1) {
                menu = retList.get(0);
            }
        }

        menuTypeList = menuManageService.getMenuTypeList();
        return "addMenuPage";
    }

    public String addMenu() throws Exception {
        menuManageService.addMenu(menu);
        return "succ";
    }

    public String toEditMenu() throws Exception {
        List<SysMenu> retList = menuManageService.getMenu(menu);
        SysMenu paraMenu = new SysMenu();
        if (retList != null && retList.size() > 0) {
            menu = retList.get(0);
            paraMenu.setMenuId(menu.getParentId());
            if (paraMenu.getMenuId().equals("root")) {
                parentMenu = genRoot();
            } else {
                parentMenu = menuManageService.getMenu(paraMenu).get(0);
            }
        }
        menuTypeList = menuManageService.getMenuTypeList();

        return "editMenuPage";
    }

    public String editMenu() throws Exception {
        menuManageService.editMenu(menu);
        // 为保证编辑后回到原菜单级别而设置此项
        menu.setParentId(menu.getMenuId());
        return "succ";
    }

    public String delMenu() throws Exception {
        menuManageService.delMenu(menu.getMenuId(), menu.getType());
        return "succ";
    }

    public String upMenu() throws Exception {
        menu = menuManageService.getMenu(menu).get(0);
        menuManageService.moveMenu(menu, -1);
        return "succ";
    }

    public String downMenu() throws Exception {
        menu = menuManageService.getMenu(menu).get(0);
        menuManageService.moveMenu(menu, 1);
        return "succ";
    }

    public String toAddAction() throws Exception {
        menu = menuManageService.getMenu(menu).get(0);
        return "addActionPage";
    }

    public String addAction() throws Exception {
        menuManageService.addAction(action);
        return "actionSucc";
    }

    public String toEditAction() throws Exception {
        menu = new SysMenu();
        action = menuManageService.getActions(action).get(0);
        menu.setMenuId(action.getMenuId());
        menu = menuManageService.getMenu(menu).get(0);
        return "editActionPage";
    }

    public String editAction() throws Exception {
        menuManageService.editAction(action);
        return "actionSucc";
    }

    public String delAction() throws Exception {
        action = menuManageService.getActions(action).get(0);
        menuManageService.delActoin(action);
        return "actionSucc";
    }

    private SysMenu genRoot() {
        SysMenu rootMenu = new SysMenu();
        rootMenu.setMenuId("root");
        rootMenu.setMenuName((String) application.getAttribute("sysname"));
        rootMenu.setType(SysMenu.MENUTYPE_PARENT);
        rootMenu.setRemark("系统菜单根对象");
        return rootMenu;
    }

    public void setMenuManageService(MenuManageService menuManageService) {
        this.menuManageService = menuManageService;
    }

    public SysMenu getMenuTree() {
        return menuTree;
    }

    public void setMenu(SysMenu menu) {
        this.menu = menu;
    }

    public SysMenu getMenu() {
        return menu;
    }

    public SysMenu getParentMenu() {
        return parentMenu;
    }

    public List<SysMenu> getSubMenuList() {
        return subMenuList;
    }

    public List<SysAction> getNormalActionList() {
        return normalActionList;
    }

    public List<SysAction> getAuthorActionList() {
        return authorActionList;
    }

    public List<MenuType> getMenuTypeList() {
        return menuTypeList;
    }

    public boolean isRefreshTree() {
        return refreshTree;
    }

    public void setRefreshTree(boolean refreshTree) {
        this.refreshTree = refreshTree;
    }

    public SysAction getAction() {
        return action;
    }

    public void setAction(SysAction action) {
        this.action = action;
    }
}
