package com.xima.springframework.aop.practice.shengsiyuan.transaction.dao.impl;

import com.xima.springframework.aop.practice.shengsiyuan.transaction.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import com.xima.springframework.aop.practice.shengsiyuan.transaction.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveStudent(Student student) {
        String sql = "insert into student(name,age) value (?,?)";
        this.jdbcTemplate.update(sql, student.getName(), student.getAge());
    }
}
