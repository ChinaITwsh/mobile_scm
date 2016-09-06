package net.beifeng.mobile_scm.system.entity;

import java.io.Serializable;
import java.util.List;

public class SysMenu implements Serializable {

    /** 菜单类别:含子菜单 */
    public static final int MENUTYPE_PARENT = 1;
    /** 菜单类别:最终菜单 */
    public static final int MENUTYPE_NODE = 2;
    /** 菜单类别:分隔线 */
    public static final int MENUTYPE_LINE = 3;

    private static final long serialVersionUID = 5279636789577162911L;

    private String menuId;
    private String menuName;
    private Integer type;
    private String typeName;
    private SysAction action;
    private String parentId;
    private Integer sortOrder;
    private String remark;

    private List<SysMenu> subMenuList;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        if (type != null) {
            switch (type) {
            case MENUTYPE_PARENT:
                this.typeName = "有子菜单";
                break;
            case MENUTYPE_NODE:
                this.typeName = "无子菜单";
                break;
            case MENUTYPE_LINE:
                this.typeName = "分隔线";
                break;
            }
        }
        this.type = type;
    }

    public SysAction getAction() {
        return action;
    }

    public void setAction(SysAction action) {
        this.action = action;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SysMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SysMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
