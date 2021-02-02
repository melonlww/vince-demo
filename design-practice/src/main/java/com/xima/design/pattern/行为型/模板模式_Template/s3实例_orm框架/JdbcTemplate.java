package com.xima.design.pattern.行为型.模板模式_Template.s3实例_orm框架;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public final List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            //1.获取连接
            Connection conn = this.getConnection();
            //2.创建语句集
            PreparedStatement pstm = this.createPreparedStatement(conn, sql);
            //3.执行语句集
            ResultSet rs = this.executeSql(pstm, values);
            //4.处理结果集
            List<?> result = this.parseResultSet(rs, rowMapper);
            //5.关闭结果集
            rs.close();
            pstm.close();
            conn.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    private ResultSet executeSql(PreparedStatement pstm, Object[] values) throws SQLException {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                Object val = values[i];
                if (val instanceof String) {
                    pstm.setString(i + 1, (String) val);
                } else if (val instanceof Integer) {
                    pstm.setInt(i + 1, (Integer) val);
                }
            }
        }
        return pstm.executeQuery();
    }

    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
