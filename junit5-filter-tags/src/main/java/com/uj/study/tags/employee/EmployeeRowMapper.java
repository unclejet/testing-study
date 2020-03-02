package com.uj.study.tags.employee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ：unclejet
 * @date ：Created in 2020/3/2 13:26
 * @description：
 * @modified By：
 * @version:
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Employee employee = new Employee();

        employee.setId(rs.getInt("ID"));
        employee.setFirstName(rs.getString("FIRST_NAME"));
        employee.setLastName(rs.getString("LAST_NAME"));
        employee.setAddress(rs.getString("ADDRESS"));

        return employee;
    }
}
