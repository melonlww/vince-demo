package com.xima.design.pattern.行为型.模板模式_Template.s3实例_orm框架;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class StudentDao extends JdbcTemplate {
    
    public StudentDao(DataSource dataSource) {
        super(dataSource);
    }
    
    public List<?> selectAll() {
        String sql = "select * from student where age = ?";
        return super.executeQuery(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws Exception {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }
        }, new Object[]{1});
    
    }
}
