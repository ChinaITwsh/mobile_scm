package net.beifeng.mobile_scm.system.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.system.entity.SysUsers;

public class UserLoginServiceImpl implements UserLoginService {

    private UserManageService userManageService;

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public SysUsers validateUser(String account, String passwd)
            throws SQLException {

        List<SysUsers> ulist = userManageService.getAccList(null, account,
                new Integer[] { SysUsers.STAT_ENABLE });
        if (ulist != null && ulist.size() > 0) {
            SysUsers acc = ulist.get(0);
            if (acc.getPasswd().equals(passwd)) {
                return acc;
            }
        }
        return null;
    }

    @Override
    public Set<String> getActionList(List<String> roleIdList)
            throws SQLException {

        Set<String> actionList = new HashSet<String>();
        actionList
                .addAll(dao.queryList("menu.getCommonActionList", roleIdList));
        actionList
                .addAll(dao.queryList("menu.getAuthorActionList", roleIdList));

        return actionList;
    }

    public void setUserManageService(UserManageService userManageService) {
        this.userManageService = userManageService;
    }

    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
