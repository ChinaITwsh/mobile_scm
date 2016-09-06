package net.beifeng.mobile_scm.basic.action;

import net.beifeng.mobile_scm.basic.entity.Suppliertype;
import net.beifeng.mobile_scm.basic.service.SupService;
import net.beifeng.mobile_scm.basic.service.SupTypeService;
import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class SupTypeAction extends BasicAction {

    private Suppliertype supType;

    private SupTypeService supTypeService;
    private SupService supService;

    public String list() throws Exception {
        paginatedQuery("supType.getType");
        return "list";
    }

    public String toAdd() throws Exception {
        return "add";
    }

    public String addType() throws Exception {
        if (supTypeService.dupId(supType.getSuptypeid())) {
            errMap.put("typeIdDup", "供应商类别编号已存在");
            return "add";
        }

        supTypeService.addType(supType);

        return "succ";
    }

    public String toEdit() throws Exception {
        supType = supTypeService.getType(supType.getSuptypeid());
        return "edit";
    }
    
    public String editType() throws Exception {
        supTypeService.editType(supType);
        return "succ";
    }
    
    public String delType() throws Exception {
        //根据类别ID查询此类别下是否有供应商,有不允许删除
        if (supService.getSupByType(supType).size() > 0) {
            mess = new Message();
            mess.setTitle("不能删除!");
            mess.setContent("此类别下有供应商,不允许删除!");
            mess.setLink("supType_list.do");
            return "message";
        }
        //如果无供应商,删除类别
        supTypeService.delType(supType.getSuptypeid());
        return "succ";
    }
  
    public Suppliertype getSupType() {
        return supType;
    }

    public void setSupType(Suppliertype supType) {
        this.supType = supType;
    }

    public void setSupTypeService(SupTypeService supTypeService) {
        this.supTypeService = supTypeService;
    }

    public void setSupService(SupService supService) {
        this.supService = supService;
    }
}
