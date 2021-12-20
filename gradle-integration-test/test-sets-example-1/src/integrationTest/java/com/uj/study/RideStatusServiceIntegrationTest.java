package com.uj.study;

import com.uj.study.themepark.RideStatusService;
import org.junit.jupiter.api.Test;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/12/20 上午8:37
 * @description：
 */
public class RideStatusServiceIntegrationTest {
    @Test
    public void testMainMethod() {
        RideStatusService.main(new String[]{"teacups"});
    }
}
