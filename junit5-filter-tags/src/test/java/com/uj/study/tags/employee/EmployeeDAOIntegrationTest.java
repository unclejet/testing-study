package com.uj.study.tags.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author ：unclejet
 * @date ：Created in 2020/3/3 5:59
 * @description：
 * @modified By：
 * @version:
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringJdbcConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EmployeeDAOIntegrationTest {
    @Autowired
    private EmployeeDAO employeeDao;

    @Test
    @Tag("IntegrationTest")
    public void testAddEmployeeUsingSimpelJdbcInsert() {
        final Employee emp = new Employee();
        emp.setId(12);
        emp.setFirstName("testFirstName");
        emp.setLastName("testLastName");
        emp.setAddress("testAddress");

        Assertions.assertEquals(employeeDao.addEmplyeeUsingSimpelJdbcInsert(emp), 1);
    }

    @Test
    @Tag("UnitTest")
    public void givenNumberOfEmployeeWhenCountEmployeeThenCountMatch() {
        int countOfEmployees = employeeDao.getCountOfEmployees();
        Assertions.assertEquals(4, countOfEmployees);
    }
}
