package net.beifeng.mobile_scm.system.service;

import java.util.Date;
import java.util.List;

import net.beifeng.mobile_scm.entity.Pagination;
import net.beifeng.mobile_scm.system.entity.SysLog;

public interface LogService {

    List<SysLog> getLogList(Date beginDate, Date endDate, String accName, Pagination pagination)
            throws Exception;
    
    void clearLog() throws Exception;
}
