package com.xima.springframework.aop.practice.shengsiyuan.transaction.service.impl;

import com.xima.springframework.aop.practice.shengsiyuan.transaction.bean.Student;
import com.xima.springframework.aop.practice.shengsiyuan.transaction.service.StudentService;
import com.xima.springframework.aop.practice.shengsiyuan.transaction.dao.StudentDao;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);

//        throw new RuntimeException("exception!");
    }
}
