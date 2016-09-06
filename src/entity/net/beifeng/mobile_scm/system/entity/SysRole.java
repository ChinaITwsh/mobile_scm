package net.beifeng.mobile_scm.system.entity;

import java.io.Serializable;

public class SysRole implements Serializable {

    /** 角色状态：启用 */
    public static final int ROLESTAT_ENABLE = 1;
    /** 角色状态：停用 */
    public static final int ROLESTAT_DISABLE = 2;
    /** 角色状态：删除 */
    public static final int ROLESTAT_DEL = 3;

    private static final long serialVersionUID = 7596779519126371333L;
    private String roleId;
    private String roleName;
    private String remark;
    private Integer status;
    private String statName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if (status != null) {
            switch (status) {
            case ROLESTAT_ENABLE:
                statName = "已启用";
                break;
            case ROLESTAT_DISABLE:
                statName = "已停用";
                break;
            case ROLESTAT_DEL:
                statName = "已删除";
                break;
            }
        }
        this.status = status;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

}
