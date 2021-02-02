package com.xima.design.pattern.行为型.模板模式_Template.s3实例_orm框架;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
