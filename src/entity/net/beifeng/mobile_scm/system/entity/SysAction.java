package net.beifeng.mobile_scm.system.entity;

import java.io.Serializable;

public class SysAction implements Serializable {

    private static final long serialVersionUID = 8759056670497171310L;

    /** 动作类型:普通动作 */
    public static final int ACTIONTYPE_NORMAL = 1;
    /** 动作类型:授权动作 */
    public static final int ACTIONTYPE_AUTHOR = 2;

    private String actionId;
    private String actionName;
    private Integer type;
    private String menuId;
    private String remark;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
