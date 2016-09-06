package net.beifeng.mobile_scm.system.action;

import java.sql.SQLException;
import java.util.List;

import net.beifeng.mobile_scm.basic.entity.Dept;
import net.beifeng.mobile_scm.basic.entity.Emp;
import net.beifeng.mobile_scm.basic.service.DeptManageService;
import net.beifeng.mobile_scm.basic.service.EmpManageService;
import net.beifeng.mobile_scm.entity.Message;
import net.beifeng.mobile_scm.system.entity.SysRole;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.system.service.RoleManageService;
import net.beifeng.mobile_scm.system.service.UserManageService;

public class AccountManageAction extends BasicAction {

    private static final long serialVersionUID = -8288164357813929629L;

    private UserManageService userManageService;

    private DeptManageService deptManageService;

    private EmpManageService empManageService;
    private RoleManageService roleManageService;

    private List<SysUsers> accList;
    private SysUsers acc;

    private String empId;
    private String empName;

    private List<String> skinList;
    private List<Dept> deptList;

    private List<SysRole> roleList;

    private String oldPass;
    private String newPass;

    public String listAcc() throws Exception {
        accList = userManageService.getAccList(acc, null,
                new Integer[] { SysUsers.STAT_ENABLE, SysUsers.STAT_DISABLE,
                        SysUsers.STAT_DEL });
        return "list";
    }

    public String toAddAcc() throws Exception {
        empName = getEmpNameById(empId);
        deptList = deptManageService.getDeptList(null);
        roleList = roleManageService.getRoleList(null,
                new Integer[] { SysRole.ROLESTAT_ENABLE });
        return "add";
    }

    public String addAcc() throws Exception {

        String curAccount = acc.getAccount();
        if (userManageService.getAccList(null, curAccount, null).size() > 0) {
            errMap.put("dupAcc", "这在帐号已存在，不允许重复");
        }

        if (acc.getRoleIdList() == null || acc.getRoleIdList().size() == 0) {
            errMap.put("nullRole", "请选择角色");
        }

        if (acc.getQueryScopeList() == null
                || acc.getQueryScopeList().size() == 0) {
            errMap.put("nullScope", "请选择查询范围");
        }

        if (errMap.size() > 0) {
            return toAddAcc();
        }

        userManageService.addAcc(empId, acc);
        return "succ";
    }

    public String toEditAcc() throws Exception {
        deptList = deptManageService.getDeptList(null);
        roleList = roleManageService.getRoleList(null,
                new Integer[] { SysRole.ROLESTAT_ENABLE });
        acc = userManageService.getAccList(acc, null, null).get(0);
        return "edit";
    }

    public String editAcc() throws Exception {

        SysUsers paraAcc = new SysUsers();
        paraAcc.setUserId(acc.getUserId());

        String oldAccName = userManageService.getAccList(paraAcc, null, null)
                .get(0).getAccount();
        if (!oldAccName.equals(acc.getAccount())) {
            if (userManageService.getAccList(null, acc.getAccount(), null)
                    .size() > 0) {
                errMap.put("dupAcc", "这在帐号已存在，不允许重复");
            }
        }

        if (acc.getRoleIdList() == null || acc.getRoleIdList().size() == 0) {
            errMap.put("nullRole", "请选择角色");
        }

        if (acc.getQueryScopeList() == null
                || acc.getQueryScopeList().size() == 0) {
            errMap.put("nullScope", "请选择查询范围");
        }

        if (errMap.size() > 0) {
            deptList = deptManageService.getDeptList(null);
            roleList = roleManageService.getRoleList(null,
                    new Integer[] { SysRole.ROLESTAT_ENABLE });
            return "edit";
        }

        userManageService.editAcc(acc);
        return "succ";
    }

    public String delAcc() throws Exception {
        userManageService.delAcc(acc);
        return "succ";
    }

    public String restoreAcc() throws Exception {
        userManageService.restoreAcc(acc);
        return "succ";
    }

    public String toModifyPasswd() throws Exception {
        return "modifyPasswd";
    }

    public String modifyPasswd() throws Exception {
        // session取出当前登录用户
        SysUsers loginUser = (SysUsers) session.get("loginUser");
        // 用当前登录用户密码与oldPass比较
        if (!loginUser.getPasswd().equals(oldPass)) {
            errMap.put("oldPassErr", "原密码不正确");
            return "modifyPasswd";
        }

        // 更新密码（用newPass)
        loginUser.setPasswd(newPass);
        userManageService.updatePass(loginUser);

        mess = new Message();
        mess.setTitle("修改成功");
        mess.setContent("密码修改成功完成");
        mess.setLink("welcome.do");
        return "message";
    }

    // private List<String> genSkinList() {
    // List<String> skinList = new ArrayList<String>();
    // skinList.add("default");
    // return skinList;
    // }

    private String getEmpNameById(String empId) throws SQLException {
        Emp paraEmp = new Emp();
        paraEmp.setEmpId(empId);
        return empManageService.getEmpList(paraEmp).get(0).getEmpName();
    }

    public SysUsers getAcc() {
        return acc;
    }

    public void setAcc(SysUsers acc) {
        this.acc = acc;
    }

    public List<SysUsers> getAccList() {
        return accList;
    }

    public void setRoleManageService(RoleManageService roleManageService) {
        this.roleManageService = roleManageService;
    }

    public void setUserManageService(UserManageService userManageService) {
        this.userManageService = userManageService;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public List<String> getSkinList() {
        return skinList;
    }

    public void setDeptManageService(DeptManageService deptManageService) {
        this.deptManageService = deptManageService;
    }

    public void setEmpManageService(EmpManageService empManageService) {
        this.empManageService = empManageService;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

}
