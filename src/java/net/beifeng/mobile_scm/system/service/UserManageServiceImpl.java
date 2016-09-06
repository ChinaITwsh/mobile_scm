package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Emp;
import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.utils.StringUtils;

public class UserManageServiceImpl implements UserManageService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public List<SysUsers> getAccList(SysUsers acc, String accName, Integer[] statList)
            throws SQLException {

        Map paraMap = new HashMap();
        paraMap.put("users", acc);
        paraMap.put("accName", accName);
        paraMap.put("statList", statList);
        List<SysUsers> accList = dao.queryList("user.getAcc", paraMap);

        if (accList != null && accList.size() > 0) {
            Iterator<SysUsers> accIterator = accList.iterator();
            while (accIterator.hasNext()) {
                SysUsers users = accIterator.next();

                // 查询范围部门名称列表获取
                List<String> deptIds = users.getQueryScopeList();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < deptIds.size(); i++) {
                    String deptId = deptIds.get(i);
                    sb.append(dao.queryObject("user.getDeptNameById", deptId))
                            .append(" ");
                }
                users.setQueryScopeName(sb.toString());

                // 查询角色列表
                users.setRoleList(dao.queryList("user.getRoles", users
                        .getUserId()));

                // 查询员工名称
                String accId = users.getUserId();
                users.setEmpName((String) dao.queryObject(
                        "user.getEmpNameByAccId", accId));
            }
        }

        return accList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addAcc(String empId, SysUsers acc) throws SQLException {
        if (acc.getUserId() == null) {
            acc.setUserId(StringUtils.uniqueKey());
        }
        acc.setCreateTime(new Date());

        dao.addObj("user.addAcc", acc);

        // 添加角色对应
        if (acc.getRoleIdList() != null && acc.getRoleIdList().size() > 0) {
            dao.batchInsert("user.addRoleRelate", genParaObjects(acc));
        }

        // 修改员工,关联帐号
        Emp emp = new Emp();
        emp.setEmpId(empId);
        emp.setUser(acc);
        dao.editObj("emp.editEmp", emp);
    }

    @Override
    public void editAcc(SysUsers acc) throws SQLException {
        // 处理角色
        if (acc.getRoleIdList() != null && acc.getRoleIdList().size() > 0) {
            dao.del("user.delRoleRelate", acc.getUserId());
            dao.batchInsert("user.addRoleRelate", genParaObjects(acc));
        }

        dao.editObj("user.editAcc", acc);
    }

    @SuppressWarnings("unchecked")
    private Object[] genParaObjects(SysUsers acc) {
        Object[] paraObjects = new Object[acc.getRoleIdList().size()];
        for (int i = 0; i < paraObjects.length; i++) {
            Map map = new HashMap();
            map.put("userId", acc.getUserId());
            map.put("roleId", acc.getRoleIdList().get(i));
            map.put("id", StringUtils.uniqueKey());
            paraObjects[i] = map;
        }
        return paraObjects;
    }

    @Override
    public void delAcc(SysUsers acc) throws SQLException {
        acc.setStatus(SysUsers.STAT_DEL);
        dao.editObj("user.editAcc", acc);
    }

    @Override
    public void restoreAcc(SysUsers acc) throws SQLException {
        acc.setStatus(SysUsers.STAT_ENABLE);
        dao.editObj("user.editAcc", acc);

    }

    @Override
    public void updatePass(SysUsers loginUser) throws SQLException {
        SysUsers paraUsers = new SysUsers();
        paraUsers.setUserId(loginUser.getUserId());
        paraUsers.setPasswd(loginUser.getPasswd());
        editAcc(paraUsers);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }
}
