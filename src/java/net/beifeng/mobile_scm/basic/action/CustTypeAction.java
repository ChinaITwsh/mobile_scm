package net.beifeng.mobile_scm.basic.action;

import net.beifeng.mobile_scm.basic.entity.Customer;
import net.beifeng.mobile_scm.basic.entity.Customertype;
import net.beifeng.mobile_scm.basic.service.CustService;
import net.beifeng.mobile_scm.basic.service.CustTypeService;
import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class CustTypeAction extends BasicAction {

    private Customertype custType;

    private CustTypeService custTypeService;
    private CustService custService;

    public String list() throws Exception {
        paginatedQuery("custType.getType");
        return "list";
    }

    public String toAdd() throws Exception {
        return "add";
    }

    public String addType() throws Exception {
        if (custTypeService.getTypeById(custType.getCusttypeid()) != null) {
            errMap.put("dupTypeId", "编号已存在!");
            return "add";
        }

        custTypeService.addType(custType);
        return "succ";
    }

    public String toEdit() throws Exception {
        custType = custTypeService.getTypeById(custType.getCusttypeid());
        return "edit";
    }

    public String editType() throws Exception {
        custTypeService.editType(custType);
        return "succ";
    }

    public String delType() throws Exception {
        Customer cust = new Customer();
        cust.setCustType(custType);
        if (custService.getCust(cust).size() > 0) {
            mess = new Message();
            mess.setTitle("不能删除");
            mess.setContent("此类别下包含客户，不能删除");
            mess.setLink("custType_list.do");
            return "message";
        }
        dao.del("custType.delType", custType.getCusttypeid());
        return "succ";
    }

    public void setCustTypeService(CustTypeService custTypeService) {
        this.custTypeService = custTypeService;
    }

    public Customertype getCustType() {
        return custType;
    }

    public void setCustService(CustService custService) {
        this.custService = custService;
    }

    public void setCustType(Customertype custType) {
        this.custType = custType;
    }

}
