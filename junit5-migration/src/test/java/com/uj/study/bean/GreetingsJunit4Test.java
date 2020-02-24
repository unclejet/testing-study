package com.uj.study.bean;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/20 13:19
 * @description：
 * We can run JUnit5 tests with any other older JUnit environment using the @RunWith annotation.
 *
 * Let's see an example of running these tests in an Eclipse version that only supports JUnit4.
 * @modified By：
 * @version:
 * The JUnitPlatform class is a JUnit4-based runner that let us run JUnit4 tests on the JUnit Platform.
 */
@RunWith(JUnitPlatform.class)
class GreetingsJunit4Test {

    @Test
    void whenCallingSayHello_thenReturnHello() {
        assertTrue("Hello".equals(Greetings.sayHello()));
    }
}