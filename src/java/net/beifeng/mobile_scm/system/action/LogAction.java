package net.beifeng.mobile_scm.system.action;

import java.util.Date;
import java.util.List;

import net.beifeng.mobile_scm.system.entity.SysLog;
import net.beifeng.mobile_scm.system.entity.SysUsers;
import net.beifeng.mobile_scm.system.service.UserManageService;

public class LogAction extends BasicAction {

    private static final long serialVersionUID = -5581838552112474583L;

    private Date beginDate;
    private Date endDate;
    private String accName;

    private List<SysUsers> accList;
    private List<SysLog> logList;

    private UserManageService userManageService;

    public String listLog() throws Exception {

        if (endDate == null) {
            endDate = new Date();
        }
        if (beginDate == null) {
            beginDate = new Date(endDate.getTime() - 7 * 24 * 60 * 60 * 1000);
        }

        accList = userManageService.getAccList(null, null, null);

        paginatedQuery("log.getLog");

        return "list";
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public List<SysUsers> getAccList() {
        return accList;
    }

    public List<SysLog> getLogList() {
        return logList;
    }

    public void setUserManageService(UserManageService userManageService) {
        this.userManageService = userManageService;
    }

}
