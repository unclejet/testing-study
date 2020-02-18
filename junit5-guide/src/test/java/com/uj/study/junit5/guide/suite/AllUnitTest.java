package com.uj.study.junit5.guide.suite;

import com.uj.study.junit5.guide.AssertionTest;
import com.uj.study.junit5.guide.ExceptionUnitTest;
import com.uj.study.junit5.guide.GroupUnitTest;
import com.uj.study.junit5.guide.JUnit5BeforeAfterUnitTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectPackages("com.uj.study.junit5")
 @SelectClasses({AssertionTest.class, JUnit5BeforeAfterUnitTest.class, ExceptionUnitTest.class, GroupUnitTest.class})
public class AllUnitTest {

}
