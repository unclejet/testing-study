package com.uj.study.jmockit;


import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AppManagerStaticMethodUnitTest {

    private AppManager appManager;

    @Before
    public void setUp() {
        appManager = new AppManager();
    }

    @Test
    public void givenAppManager_whenStaticMethodCalled_thenValidateExpectedResponse() {
        new MockUp<AppManager>() {
            @Mock
            public boolean isResponsePositive(String value) {
                return false;
            }
        };

        assertFalse(appManager.managerResponse("Why are you coming late?"));
    }

    /**
     * jmockit canceled call static private method.
     * because they think this type of call is bad coding practice.
     * so, use version before 1.35 will have DEencapsulation.invoke method
     * Version 1.35 (Sep 24, 2017):
     * Deprecated the StrictExpectations class. Existing tests should instead use Expectations, possibly adding a "new FullVerifications() {}" block at the end, if detecting unrecorded invocations is still desired.
     * Deprecated the "invoke" and "newInstance" methods from the Deencapsulation class. These are simple Reflection-backed convenience methods, which are no longer useful in the overall context of JMockit APIs.
     * Deprecated the MockUp(T) constructor. (Use of this constructor causes the given instance of type T to be the only one affected by the fake implementations.) This feature was never intended for the faking API in the first place, it's been rarely used, and has no demonstrable use cases; existing tests that happen to use it should instead use real (non-faked) instances.
     */
    @Test
    public void givenAppManager_whenPrivateStaticMethod_thenValidateExpectedResponse() {
//        int response = Deencapsulation.invoke(AppManager.class, "stringToInteger", "110");
//        assertEquals(110, response);
    }
}
