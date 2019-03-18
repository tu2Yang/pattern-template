package com.pattern.template.jdbc;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T mapRow(ResultSet re, int rowNum) throws  Exception;

}
