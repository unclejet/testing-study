package com.uj.study.tags.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class EmployeeDAOIntegrationWithMockTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    private EmployeeDAO employeeDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        employeeDAO = new EmployeeDAO();
        employeeDAO.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    @Tag("UnitTest")
    public void givenNumberOfEmployeeWhenCountEmployeeThenCountMatch() {

        // given
        Mockito.when(jdbcTemplate.queryForObject(Mockito.any(String.class), Mockito.eq(Integer.class)))
                .thenReturn(1);

        // when
        int countOfEmployees = employeeDAO.getCountOfEmployees();

        // then
        Assertions.assertEquals(1, countOfEmployees);
    }
}
