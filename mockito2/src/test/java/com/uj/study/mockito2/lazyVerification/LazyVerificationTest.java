package com.uj.study.mockito2.lazyVerification;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Without VerificationCollector rule, only the first verification gets reported:
 *
 * 1
 * 2
 * 3
 * 4
 * Wanted but not invoked:
 * arrayList.add("one");
 * -> at com.baeldung.mockito.java8.LazyVerificationTest.testLazyVerification(LazyVerificationTest.java:19)
 * Actually, there were zero interactions with this mock.
 */
public class LazyVerificationTest {
    @Rule
    public VerificationCollector verificationCollector = MockitoJUnit.collector();

    @Test
    public void testLazyVerification() throws Exception {
        List mockList = mock(ArrayList.class);

//        verify(mockList).add("one");
//        verify(mockList).clear();
    }
}
