package net.beifeng.mobile_scm.basic.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Mobtype;
import net.beifeng.mobile_scm.basic.service.MobTypeService;
import net.beifeng.mobile_scm.system.action.BasicAction;

@SuppressWarnings("unchecked")
public class MobTypeAction extends BasicAction {

    private static final long serialVersionUID = -6298010030334852281L;

    private Mobtype mobType;
    private List brandList;
    private List bonusTypeList;

    private List<Map> mobBonusList;

    private MobTypeService mobTypeService;

    public String list() throws Exception {
        brandList = dao.queryList("brand.getBrand", null);
        paginatedQuery("mobType.getType");
        return "list";
    }

    public String toAdd() throws Exception {

        brandList = dao.queryList("brand.getBrand", null);
        bonusTypeList = dao.queryList("bonusType.getType", null);

        return "add";
    }

    public String toEdit() throws Exception {

        // 型号详情
        Map paraMap = new HashMap();
        paraMap.put("mobType", mobType);
        mobType = (Mobtype) dao.queryObject("mobType.getType", paraMap);
        // 已设返利价格
        mobBonusList = mobTypeService.getBonus(mobType.getMobtypeid());
        // 品牌与返利类别list
        brandList = dao.queryList("brand.getBrand", null);
        bonusTypeList = dao.queryList("bonusType.getType", null);

        return "edit";
    }

    public void addType() throws Exception {
        mobTypeService.addType(mobType);
        response.getWriter().print("mobType_list.do");
    }

    public void editType() throws Exception {
        mobTypeService.editType(mobType);
        response.getWriter().print("mobType_list.do");
    }

    public String delType() throws Exception {
        mobTypeService.delType(mobType.getMobtypeid());
        return "succ";
    }

    public String viewBonus() throws Exception {

        mobBonusList = mobTypeService.getBonus(mobType.getMobtypeid());
        return "viewBonus";
    }

    public List getBrandList() {
        return brandList;
    }

    public Mobtype getMobType() {
        return mobType;
    }

    public void setMobType(Mobtype mobType) {
        this.mobType = mobType;
    }

    public List getBonusTypeList() {
        return bonusTypeList;
    }

    public void setMobTypeService(MobTypeService mobTypeService) {
        this.mobTypeService = mobTypeService;
    }

    public List<Map> getMobBonusList() {
        return mobBonusList;
    }

}
