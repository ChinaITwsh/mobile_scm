package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Supplier;
import net.beifeng.mobile_scm.basic.service.SupService;
import net.beifeng.mobile_scm.basic.service.SupTypeService;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class SupAction extends BasicAction {

    private List supTypeList;

    private Supplier supplier;

    private SupTypeService supTypeService;
    private SupService supService;

    public String list() throws Exception {
        supTypeList = supTypeService.getType();
        paginatedQuery("sup.getSup");
        return "list";
    }
    
    public String toAdd() throws Exception {
        supTypeList = supTypeService.getType();        
        return "add";
    }
    
    public String addSup() throws Exception {
        
        if (supService.dupId(supplier.getSupid())) {
            supTypeList = supTypeService.getType();        
            errMap.put("supplierId", "这个编号已存在");
            return "add";
        }
        
        supService.addSup(supplier);
        
        return "succ";
    }
    
    public String toEdit() throws Exception {
        supplier = supService.getSupById(supplier.getSupid());
        supTypeList = supTypeService.getType();        
        return "edit";
    }
    
    public String editSup() throws Exception {
        supService.editSup(supplier);
        return "succ";
    }
    
    public String delSup() throws Exception {
        supService.delSup(supplier.getSupid());
        return "succ";
    }

    public List getSupTypeList() {
        return supTypeList;
    }   
    

    public void setSupTypeService(SupTypeService supTypeService) {
        this.supTypeService = supTypeService;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setSupService(SupService supService) {
        this.supService = supService;
    }

}
