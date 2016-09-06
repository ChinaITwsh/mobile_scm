package net.beifeng.mobile_scm.system.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysUsers implements Serializable {

    private static final long serialVersionUID = 5881636385786395662L;

    /** 帐号状态：永久性删除 */
    public static final int STAT_PDEL = -1;
    /** 帐号状态：删除 */
    public static final int STAT_DEL = 0;
    /** 帐号状态：启用 */
    public static final int STAT_ENABLE = 1;
    /** 帐号状态：停用 */
    public static final int STAT_DISABLE = 2;

    private String userId;
    private String account;
    private String passwd;
    private String remark;
    private Integer status;
    private String statName;
    private Date createTime;
    private String createTimeStr;

    private String skin;

    private String queryScope;

    private List<String> queryScopeList;
    private String queryScopeName;

    private List<SysRole> roleList;
    private List<String> roleIdList;

    private String empName;

    public String getQueryScope() {
        return queryScope;
    }

    public void setQueryScope(String queryScope) {
        if (queryScope != null) {
            String[] tmp = queryScope.split(",");
            queryScopeList = Arrays.asList(tmp);
        }
        this.queryScope = queryScope;
    }

    public List<String> getQueryScopeList() {
        return queryScopeList;
    }

    public void setQueryScopeList(List<String> queryScopeList) {
        if (queryScopeList != null && queryScopeList.size() > 0) {
            Iterator<String> tmpIterator = queryScopeList.iterator();
            StringBuilder sb = new StringBuilder();
            while (tmpIterator.hasNext()) {
                String tmp = tmpIterator.next();
                sb.append(tmp).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            this.queryScope = sb.toString();
        }
        this.queryScopeList = queryScopeList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public String getQueryScopeName() {
        return queryScopeName;
    }

    public void setQueryScopeName(String queryScopeName) {
        this.queryScopeName = queryScopeName;
    }

    public void setStatus(Integer status) {
        if (status != null) {
            switch (status) {
            case STAT_DEL:
                statName = "已删除";
                break;
            case STAT_DISABLE:
                statName = "禁用";
                break;
            case STAT_ENABLE:
                statName = "启用";
                break;
            }
        }
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        createTimeStr = new SimpleDateFormat("yyyy-MM-dd").format(createTime);
        this.createTime = createTime;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        if (roleList != null && roleList.size() > 0) {
            this.roleIdList = new ArrayList<String>();
            for (int i = 0; i < roleList.size(); i++) {
                roleIdList.add(roleList.get(i).getRoleId());
            }
        }
        this.roleList = roleList;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }

}
