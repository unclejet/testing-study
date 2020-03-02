package com.uj.study.tags.employee;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/26 13:14
 * @description：
 * @modified By：
 * @version:
 */
@RunWith(JUnitPlatform.class)
@SelectPackages("com.uj.study.tags.employee")
@IncludeTags("UnitTest")
public class EmployeeDAOTestSuite {
}
