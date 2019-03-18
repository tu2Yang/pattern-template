package com.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        List<?> result = null;
        try {
            // 创建连接
            Connection conn = this.getConnection();
            // 创建语句集
            PreparedStatement pstm = this.createStatement(conn, sql);
            // 执行语句集
            ResultSet rs = this.executeQuery(pstm, values);
            // 处理结果集
            result = this.parseResultSet(rs, rowMapper);
            // 关闭结果集
            this.closeResultSet(rs);
            this.closePrepareStatment(pstm);
            this.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    public PreparedStatement createStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    public ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

    protected List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum ++));
        }
        return result;
    }

    public void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    public void closePrepareStatment(PreparedStatement pstm) throws Exception {
        pstm.close();
    }

    public void closeConnection(Connection conn) throws Exception {
        conn.close();
    }

}
