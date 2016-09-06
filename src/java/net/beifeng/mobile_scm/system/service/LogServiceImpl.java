package net.beifeng.mobile_scm.system.service;

import java.awt.print.Pageable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.beifeng.mobile_scm.dao.CommonDao;
import net.beifeng.mobile_scm.entity.Pagination;
import net.beifeng.mobile_scm.system.entity.SysLog;
import net.beifeng.mobile_scm.utils.DateUtils;

public class LogServiceImpl implements LogService {

    private CommonDao dao;

    @SuppressWarnings("unchecked")
    @Override
    public List<SysLog> getLogList(Date beginDate, Date endDate, String accName, Pagination pagination)
            throws Exception {
        Map paraMap = new HashMap();
        paraMap.put("beginDate", DateUtils.toDayStart(beginDate));
        paraMap.put("endDate", DateUtils.toDayEnd(endDate));
        paraMap.put("accName", accName);
        
        int totalRecordCnt = dao.getTotalRecordCnt("log.getLog", paraMap);    
        
        int skip = pagination.getPageIndex() - 1 * pagination.getPageSize();
        
        return dao.queryPaginatedList("log.getLog", paraMap, skip, pagination.getPageSize());
    }

    @Override
    public void clearLog() throws Exception {
        Calendar monthBegin = Calendar.getInstance();
        monthBegin.set(Calendar.DAY_OF_MONTH, 1);
        monthBegin.set(Calendar.HOUR_OF_DAY, 0);
        monthBegin.set(Calendar.MINUTE, 0);
        monthBegin.set(Calendar.SECOND, 0);
        monthBegin.set(Calendar.MILLISECOND, 0);
        dao.del("log.delLog", monthBegin);
    }

   
    public void setDao(CommonDao dao) {
        this.dao = dao;
    }

}
