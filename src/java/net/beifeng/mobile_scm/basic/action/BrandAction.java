package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.system.action.BasicAction;

@SuppressWarnings("unchecked")
public class BrandAction extends BasicAction {

    private static final long serialVersionUID = 7127254389350822834L;
    private List brandList;
    private String brand;

    public String list() throws Exception {
        brandList = dao.queryList("brand.getBrand", null);
        return "list";
    }

    public String addBrand() throws Exception {
        if (dao.queryObject("brand.getBrand", brand) != null) {
            errMap.put("dupBrand", "品牌名称已存在");
            brandList = dao.queryList("brand.getBrand", null);
            return "list";
        } else {
            dao.addObj("brand.addBrand", brand);
            return "succ";
        }
    }

    public String delBrand() throws Exception {
        dao.del("brand.delBrand", new String(brand.getBytes("iso8859-1"),
                "utf-8"));
        return "succ";
    }

    public List getBrandList() {
        return brandList;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
