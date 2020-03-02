package com.uj.study.tags.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author ：unclejet
 * @date ：Created in 2020/3/2 13:16
 * @description：
 * @modified By：
 * @version:
 */
@Configuration
@ComponentScan("com.uj.study.tags.employee")
public class SpringJdbcConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:jdbc/schema.sql").addScript("classpath:jdbc/test-data.sql").build();
    }
}
