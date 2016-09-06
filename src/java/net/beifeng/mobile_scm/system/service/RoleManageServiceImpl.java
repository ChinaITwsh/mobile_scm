package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.system.entity.SysRole;
import net.beifeng.mobile_scm.utils.StringUtils;

@SuppressWarnings("unchecked")
public class RoleManageServiceImpl implements RoleManageService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public List<SysRole> getRoleList(SysRole role, Integer[] status)
            throws SQLException {
        Map paraMap = new HashMap();
        paraMap.put("role", role);
        paraMap.put("status", status);
        return dao.queryList("role.getRole", paraMap);
    }

    @Override
    public void addRole(SysRole role) throws SQLException {
        // Id
        if (role.getRoleId() == null) {
            role.setRoleId(StringUtils.uniqueKey());
        }
        dao.addObj("role.addRole", role);
    }

    @Override
    public void editRole(SysRole role) throws SQLException {
        dao.editObj("role.editRole", role);
    }

    @Override
    public void delRole(SysRole role) throws SQLException {
        role.setStatus(SysRole.ROLESTAT_DEL);
        dao.editObj("role.editRole", role);
    }

    @Override
    public void restoreRole(SysRole role) throws SQLException {
        role.setStatus(SysRole.ROLESTAT_ENABLE);
        dao.editObj("role.editRole", role);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> getPrivActionIds(String roleId)
            throws SQLException {
        Map paraMap = new HashMap();
        paraMap.put("roleId", roleId);
        return dao.queryList("role.getActions", paraMap);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> getPrivMenuIds(String roleId)
            throws SQLException {
        Map paraMap = new HashMap();
        paraMap.put("roleId", roleId);
        return dao.queryList("role.getMenus", paraMap);
    }

    @Override
    public void relateActionPriv(String roleId, String[] actionIds)
            throws SQLException {
        relatePriv(roleId, actionIds, "sys_roleaction");
    }

    @Override
    public void relateMenuPriv(String roleId, String[] menuIds)
            throws SQLException {
        relatePriv(roleId, menuIds, "sys_rolemenu");
    }

    private void relatePriv(String roleId, String[] objIds, String tablename)
            throws SQLException {

        Map paraMap = new HashMap();
        paraMap.put("roleId", roleId);

        // 先删除原权限
        paraMap.put("table", tablename);
        dao.del("role.delRelate", paraMap);
        // 添加新权限
        if (objIds != null && objIds.length > 0) {
            Object[] paraObjects = new Object[objIds.length];
            for (int i = 0; i < paraObjects.length; i++) {
                Map para = new HashMap();
                para.put("table", tablename);
                para.put("id", StringUtils.uniqueKey());
                para.put("roleId", roleId);
                para.put("objId", objIds[i]);
                paraObjects[i] = para;
            }
            dao.batchInsert("role.addRelate", paraObjects);
        }

    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
