package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Dept;
import net.beifeng.mobile_scm.basic.entity.Emp;
import net.beifeng.mobile_scm.basic.entity.EmpType;
import net.beifeng.mobile_scm.basic.service.DeptManageService;
import net.beifeng.mobile_scm.basic.service.EmpManageService;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class EmpManageAction extends BasicAction {

    private static final long serialVersionUID = -2000410200908211474L;

    private EmpManageService empManageService;
    private DeptManageService deptManageService;

    private Emp emp;
    private List<Emp> empList;

    private List<EmpType> empTypeList;
    private List<Dept> deptList;

    public String listEmp() throws Exception {
        empList = empManageService.getEmpList(emp);
        return "list";
    }

    public String toAddEmp() throws Exception {
        empTypeList = empManageService.getEmpTypeList();
        deptList = deptManageService.getDeptList(null);
        return "add";
    }

    public String addEmp() throws Exception {
        empManageService.addEmp(emp);
        return "succ";
    }

    public String toEditEmp() throws Exception {
        empTypeList = empManageService.getEmpTypeList();
        deptList = deptManageService.getDeptList(null);
        emp = empManageService.getEmpList(emp).get(0);
        return "edit";
    }
    
    public String editEmp() throws Exception {
        empManageService.editEmp(emp);
        return "succ";
    }

    public String delEmp() throws Exception {
        empManageService.delEmp(emp);
        return "succ";
    }
    
    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpManageService(EmpManageService empManageService) {
        this.empManageService = empManageService;
    }

    public List<EmpType> getEmpTypeList() {
        return empTypeList;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptManageService(DeptManageService deptManageService) {
        this.deptManageService = deptManageService;
    }

}
