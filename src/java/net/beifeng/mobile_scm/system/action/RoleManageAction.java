package net.beifeng.mobile_scm.system.action;

import java.util.List;

import net.beifeng.mobile_scm.system.entity.SysRole;
import net.beifeng.mobile_scm.system.service.RoleManageService;

public class RoleManageAction extends BasicAction {

    private static final long serialVersionUID = -7331090889627206758L;
    
    private Integer[] status;
    private RoleManageService roleManageService;
    private SysRole role;
    private List<SysRole> roleList;  
  
    
    public String listRole() throws Exception {
        // 处理状态
        if (status == null) {
            status = new Integer[] { SysRole.ROLESTAT_ENABLE,
                    SysRole.ROLESTAT_DISABLE };
        }
    
        // 查询角色
        roleList = roleManageService.getRoleList(role, status);
        // 常量

        return "list";
    }
    
    public String toAddRole() throws Exception {
        return "addPage";
    }
    
    public String addRole() throws Exception {

        roleManageService.addRole(role);
        return "succ";
    }
    

    public String toEditRole() throws Exception {
        role = roleManageService.getRoleList(role, null).get(0);
        return "editPage";
    }


    public String editRole() throws Exception {
        roleManageService.editRole(role);
        return "succ";
    }
    
    public String delRole() throws Exception {
        roleManageService.delRole(role);
        return "succ";
    }

    public String restoreRole() throws Exception {
        roleManageService.restoreRole(role);
        return "succ";
    }
    
    public Integer[] getStatus() {
        return status;
    }

    public void setStatus(Integer[] status) {
        this.status = status;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleManageService(RoleManageService roleManageService) {
        this.roleManageService = roleManageService;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public SysRole getRole() {
        return role;
    }

  
}
