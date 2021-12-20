package com.uj.study.themepark;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/12/20 上午8:32
 * @description：
 */
class RideStatusServiceTest {
    @ParameterizedTest(name = "{index} gets {0} ride status")
    @ValueSource(strings = {"rollercoaster", "logflume", "teacups"})
    public void getsRideStatus(String ride) {
        RideStatusService rideStatusService = new RideStatusService();
        String rideStatus = rideStatusService.getRideStatus(ride);
        assertNotNull(rideStatus);
    }

    @Test
    public void unknownRideCausesFailure() {
        RideStatusService rideStatusService = new RideStatusService();

        assertThrows(IllegalArgumentException.class, () -> {
            rideStatusService.getRideStatus("dodgems");
        });
    }
}