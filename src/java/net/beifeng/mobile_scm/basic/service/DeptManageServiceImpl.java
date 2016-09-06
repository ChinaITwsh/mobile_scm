package net.beifeng.mobile_scm.basic.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.basic.entity.Dept;
import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.utils.StringUtils;

public class DeptManageServiceImpl implements DeptManageService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public List<Dept> getDeptList(Dept dept) throws SQLException {

        Map paraMap = new HashMap();
        paraMap.put("dept", dept);
        // paraMap.put("scope", ..);
        return dao.queryList("dept.getDept", paraMap);
    }

    @Override
    public void addDept(Dept dept) throws SQLException {
        if (dept.getDeptId() == null) {
            dept.setDeptId(StringUtils.uniqueKey());
        }
        dao.addObj("dept.addDept", dept);
    }

    @Override
    public void editDept(Dept dept) throws SQLException {
        dao.editObj("dept.editDept", dept);
    }

    @Override
    public void delDept(Dept dept) throws SQLException {
        dao.del("dept.delDept", dept);
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
