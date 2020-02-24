package com.uj.study.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/20 13:19
 * @description：
 * Let's now run the same test in an Eclipse version that supports JUnit5. In this case, we don't need the @RunWith annotation anymore and we can write the test without a runner:
 * @modified By：
 * @version:
 */
class GreetingsJunit5Test {
    @Test
    void whenCallingSayHello_thenReturnHello() {
        assertTrue("Hello".equals(Greetings.sayHello()));
    }
}