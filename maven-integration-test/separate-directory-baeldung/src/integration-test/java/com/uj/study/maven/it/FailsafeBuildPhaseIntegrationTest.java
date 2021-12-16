package com.uj.study.maven.it;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FailsafeBuildPhaseIntegrationTest {

    @Test
    public void whenTestExecutes_thenPreAndPostIntegrationBuildPhasesAreExecuted() {
        assertTrue(true);
    }
}
