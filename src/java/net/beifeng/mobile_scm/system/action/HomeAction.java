package net.beifeng.mobile_scm.system.action;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.system.entity.SysMenu;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.system.service.MenuManageService;
import net.beifeng.mobile_scm.utils.DoLog;

import com.opensymphony.xwork2.ActionContext;

public class HomeAction extends BasicAction {

    private static final long serialVersionUID = 7071566986229355381L;

    private MenuManageService menuManageService;

    private List<SysMenu> menuList;

    public String execute() throws SQLException {

        if (ActionContext.getContext().getSession().get("loginUser") == null) {
            return "login";
        }

        return "success";
    }

    @DoLog(false)
    public String loadMenu() throws Exception {
        SysUsers user = (SysUsers) session.get("loginUser");
        if (user == null) {
            return "login";
        }

        menuList = menuManageService.getMenuTree("root", null);
        return "menuTree";
    }

    public void setMenuManageService(MenuManageService menuManageService) {
        this.menuManageService = menuManageService;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

}
