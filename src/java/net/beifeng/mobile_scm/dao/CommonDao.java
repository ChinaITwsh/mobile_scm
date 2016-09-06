package net.beifeng.mobile_scm.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public interface CommonDao {
    public Object queryObject(String sqlId, Object parameter)
            throws SQLException;

    public List queryList(String sqlId, Object parameter) throws SQLException;

    public Object addObj(String sqlId, Object parameter) throws SQLException;

    public int editObj(String sqlId, Object parameter) throws SQLException;

    public int del(String sqlId, Object parameter) throws SQLException;

    public int batchInsert(String sqlId, Object[] paraObjects)
            throws SQLException;

    public int batchInsert(String sqlId, Collection paraCollection)
            throws SQLException;

    public int batchUpdate(String sqlId, Object[] paraObjects)
            throws SQLException;

    public int batchUpdate(String sqlId, Collection paraCollection)
            throws SQLException;

    public List queryPaginatedList(String sqlId, Object parameter, int skip,
            int pageSize) throws SQLException;

    public int getTotalRecordCnt(String sqlId, Object parameter);
}
