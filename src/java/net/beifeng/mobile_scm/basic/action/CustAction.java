package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Customer;
import net.beifeng.mobile_scm.basic.service.CustService;
import net.beifeng.mobile_scm.basic.service.CustTypeService;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class CustAction extends BasicAction {

    private List custTypeList;
    private Customer cust;

    private CustTypeService custTypeService;
    private CustService custService;

    public String list() throws Exception {
        custTypeList = custTypeService.getType();
        paginatedQuery("cust.getCust");
        return "list";
    }

    public String toAdd() throws Exception {
        custTypeList = custTypeService.getType();
        return "add";
    }

    public String addCust() throws Exception {
        if (custService.getCustById(cust.getCustid()) != null) {
            errMap.put("dupCustId", "编号已存在");
            custTypeList = custTypeService.getType();
            return "add";
        }

        custService.addCust(cust);
        return "succ";
    }

    public String toEdit() throws Exception {
        custTypeList = custTypeService.getType();
        cust = custService.getCustById(cust.getCustid());
        return "edit";
    }

    public String editCust() throws Exception {
        custService.editCust(cust);
        return "succ";
    }

    public String delCust() throws Exception {
        custService.delCustById(cust.getCustid());
        return "succ";
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public List getCustTypeList() {
        return custTypeList;
    }

    public void setCustTypeService(CustTypeService custTypeService) {
        this.custTypeService = custTypeService;
    }

    public void setCustService(CustService custService) {
        this.custService = custService;
    }
}
