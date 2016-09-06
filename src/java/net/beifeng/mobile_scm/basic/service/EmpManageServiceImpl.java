package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Emp;
import net.beifeng.mobile_scm.basic.entity.EmpType;
import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.utils.StringUtils;

public class EmpManageServiceImpl implements EmpManageService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public List<Emp> getEmpList(Emp emp) throws SQLException {

        Map paraMap = new HashMap();
        paraMap.put("emp", emp);

        return dao.queryList("emp.getEmp", paraMap);
    }

    @Override
    public void addEmp(Emp emp) throws SQLException {
        if (emp.getEmpId() == null) {
            emp.setEmpId(StringUtils.uniqueKey());
        }
        dao.addObj("emp.addEmp", emp);
    }

    @Override
    public List<EmpType> getEmpTypeList() {
        List<EmpType> retList = new ArrayList<EmpType>();
        retList.add(new EmpType(Emp.EMPTYPE_SALES, "业务员"));
        retList.add(new EmpType(Emp.EMPTYPE_OTHER, "其它"));
        return retList;
    }

    @Override
    public void delEmp(Emp emp) throws SQLException {

        // 更改帐号状态为永久删除
        Emp paraEmp = getEmpList(emp).get(0);
        SysUsers user = paraEmp.getUser();
        if (user != null) {
            String userId = user.getUserId();
            if (userId != null) {
                SysUsers paraUser = new SysUsers();
                paraUser.setUserId(userId);
                paraUser.setStatus(SysUsers.STAT_PDEL);
                dao.editObj("user.editAcc", paraUser);
            }
        }

        dao.del("emp.delEmp", emp);
    }

    @Override
    public void editEmp(Emp emp) throws SQLException {
        dao.editObj("emp.editEmp", emp);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
