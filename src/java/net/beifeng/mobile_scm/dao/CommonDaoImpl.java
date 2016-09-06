package net.beifeng.mobile_scm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

@SuppressWarnings("unchecked")
public class CommonDaoImpl extends SqlMapClientTemplate implements CommonDao {

    public Object queryObject(String sqlId, Object parameter)
            throws SQLException {
        return getSqlMapClient().queryForObject(sqlId, parameter);
    }

    @Override
    public List queryList(String sqlId, Object parameter) throws SQLException {
        return getSqlMapClient().queryForList(sqlId, parameter);
    }

    @Override
    public Object addObj(String sqlId, Object parameter) throws SQLException {
        return getSqlMapClient().insert(sqlId, parameter);
    }

    @Override
    public int editObj(String sqlId, Object parameter) throws SQLException {
        return getSqlMapClient().update(sqlId, parameter);
    }

    @Override
    public int del(String sqlId, Object parameter) throws SQLException {
        return getSqlMapClient().delete(sqlId, parameter);
    }

    @Override
    public int batchInsert(String sqlId, Object[] paraObjects)
            throws SQLException {

        if (paraObjects == null || paraObjects.length == 0) {
            return 0;
        }

        SqlMapClient client = getSqlMapClient();
        client.startBatch();
        for (Object o : paraObjects) {
            client.insert(sqlId, o);
        }
        return client.executeBatch();
    }

    @Override
    public int batchInsert(String sqlId, Collection paraCollection)
            throws SQLException {
        if (paraCollection == null || paraCollection.size() == 0) {
            return 0;
        }

        Object[] paraObjects = new Object[paraCollection.size()];
        paraObjects = paraCollection.toArray(paraObjects);
        return batchInsert(sqlId, paraObjects);
    }

    @Override
    public List queryPaginatedList(String sqlId, Object parameter, int skip,
            int pageSize) throws SQLException {
        return getSqlMapClient().queryForList(sqlId, parameter, skip, pageSize);
    }

    @Override
    public int getTotalRecordCnt(String sqlId, Object parameter)

    {

        SqlMapClientImpl clientImpl = (SqlMapClientImpl) getSqlMapClient();
        MappedStatement mappedStatement = clientImpl.getMappedStatement(sqlId);

        Sql sql = mappedStatement.getSql();

        StatementScope statementScope = new StatementScope(new SessionScope());
        mappedStatement.initRequest(statementScope);

        String strSql = sql.getSql(statementScope, parameter);
        // select * from sys_log where accName=? and beginDate=?
        strSql = "select count(1) from (" + strSql + ") tmp";

        Object[] vals = null;
        if (parameter != null) {
            vals = sql.getParameterMap(statementScope, parameter)
                    .getParameterObjectValues(statementScope, parameter);
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int cnt = 0;

        try {
            conn = clientImpl.getDataSource().getConnection();
            ps = conn.prepareStatement(strSql);
            if (vals != null && vals.length > 0) {
                for (int i = 0; i < vals.length; i++) {
                    ps.setObject(i + 1, vals[i]);
                }
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return cnt;
    }

    @Override
    public int batchUpdate(String sqlId, Object[] paraObjects)
            throws SQLException {
        if (paraObjects == null || paraObjects.length == 0) {
            return 0;
        }

        SqlMapClient client = getSqlMapClient();
        client.startBatch();
        for (Object o : paraObjects) {
            client.update(sqlId, o);
        }
        return client.executeBatch();
    }

    @Override
    public int batchUpdate(String sqlId, Collection paraCollection)
            throws SQLException {
        if (paraCollection == null || paraCollection.size() == 0) {
            return 0;
        }

        Object[] paraObjects = new Object[paraCollection.size()];
        paraObjects = paraCollection.toArray(paraObjects);
        return batchUpdate(sqlId, paraObjects);
    }

}
