package net.beifeng.mobile_scm.basic.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.AccessoryType;
import net.beifeng.mobile_scm.system.action.BasicAction;

@SuppressWarnings("unchecked")
public class AccessoryTypeAction extends BasicAction {

    private static final long serialVersionUID = -7779105704003395247L;

    private List brandList;

    private AccessoryType accessoryType;

    public String list() throws Exception {
        brandList = dao.queryList("brand.getBrand", null);
        paginatedQuery("accessoryType.getType");
        return "list";
    }

    public String toAdd() throws Exception {
        brandList = dao.queryList("brand.getBrand", null);
        return "add";
    }

    public String addType() throws Exception {
        dao.addObj("accessoryType.addType", accessoryType);
        return "succ";
    }

    public String toEdit() throws Exception {

        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("accessoryType", accessoryType);
        accessoryType = (AccessoryType) dao.queryObject(
                "accessoryType.getType", paraMap);

        brandList = dao.queryList("brand.getBrand", null);

        return "edit";
    }

    public String editType() throws Exception {
        dao.editObj("accessoryType.editType", accessoryType);
        return "succ";
    }

    public String delType() throws Exception {
        dao.del("accessoryType.delType", accessoryType.getAccessorytypeid());
        return "succ";
    }

    public List getBrandList() {
        return brandList;
    }

    public AccessoryType getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(AccessoryType accessoryType) {
        this.accessoryType = accessoryType;
    }

}
