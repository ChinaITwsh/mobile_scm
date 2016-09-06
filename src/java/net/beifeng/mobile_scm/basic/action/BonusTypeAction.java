package net.beifeng.mobile_scm.basic.action;

import net.beifeng.mobile_scm.basic.entity.Bonustype;
import net.beifeng.mobile_scm.system.action.BasicAction;
import net.beifeng.mobile_scm.utils.StringUtils;

public class BonusTypeAction extends BasicAction {

   
    private static final long serialVersionUID = -6250938161354629258L;
    private Bonustype bonustype;

    public String list() throws Exception {
        paginatedQuery("bonusType.getType");
        return "list";
    }

    public String toAdd() throws Exception {
        return "add";
    }

    public String addType() throws Exception {
        bonustype.setBonustypeid(StringUtils.uniqueKey());
        dao.addObj("bonusType.addType", bonustype);
        return "succ";
    }

    public String toEdit() throws Exception {
        bonustype = (Bonustype) dao.queryObject("bonusType.getTypeById",
                bonustype.getBonustypeid());
        return "edit";
    }

    public String editType() throws Exception {
        dao.editObj("bonusType.editType", bonustype);
        return "succ";
    }

    public String delType() throws Exception {
        dao.del("bonusType.delType", bonustype.getBonustypeid());
        return "succ";
    }

    public Bonustype getBonustype() {
        return bonustype;
    }

    public void setBonustype(Bonustype bonustype) {
        this.bonustype = bonustype;
    }

}
