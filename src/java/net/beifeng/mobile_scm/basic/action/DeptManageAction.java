package net.beifeng.mobile_scm.basic.action;

import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Dept;
import net.beifeng.mobile_scm.basic.entity.Emp;
import net.beifeng.mobile_scm.basic.service.DeptManageService;
import net.beifeng.mobile_scm.basic.service.EmpManageService;
import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.system.action.BasicAction;

public class DeptManageAction extends BasicAction {

    private static final long serialVersionUID = -5540272703578233677L;

    private DeptManageService deptManageService;
    private EmpManageService empManageService;

    private Dept dept;

    private List<Dept> deptList;

    public String listDept() throws Exception {

        // 取出当前用户查询范围

        deptList = deptManageService.getDeptList(dept);
        return "list";
    }

    public String toAddDept() throws Exception {
        return "add";
    }

    public String addDept() throws Exception {
        deptManageService.addDept(dept);
        return "succ";
    }

    public String toEditDept() throws Exception {
        dept = deptManageService.getDeptList(dept).get(0);
        return "toEdit";
    }

    public String editDept() throws Exception {
        deptManageService.editDept(dept);
        return "succ";
    }

    public String delDept() throws Exception {
        // 判断本部门下是否有员工
        Emp paraEmp = new Emp();
        paraEmp.setDept(dept);
        if (empManageService.getEmpList(paraEmp).size() > 0) {
            // 如果有,返回提示<禁止删除部门>
            super.mess = new Message();
            super.mess.setTitle("此部门下包含员工");
            super.mess.setContent("在此部门下包含员工，不能删除此部门，请删除部门下所有员工后再删除此部门！");
            super.mess.setLink("deptManage_listDept.do");
            return "message";
        }

        deptManageService.delDept(dept);
        return "succ";
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setDeptManageService(DeptManageService deptManageService) {
        this.deptManageService = deptManageService;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setEmpManageService(EmpManageService empManageService) {
        this.empManageService = empManageService;
    }

}
