package com.beusable.roomoccupancymanager.service;

import com.beusable.roomoccupancymanager.model.OptimizeRequest;
import com.beusable.roomoccupancymanager.model.OptimizeResponse;
import com.beusable.roomoccupancymanager.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;
    @Test
    void testOptimizeRooms() {
        OptimizeRequest optimizeRequest = new OptimizeRequest();
        optimizeRequest.setGuests(Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209));
        OptimizeResponse optimizeResponse;


        optimizeRequest.setEconomyRoomsAvailable(23);
        optimizeRequest.setPremiumRoomsAvailable(7);
        optimizeResponse = roomService.optimizeRooms(optimizeRequest);

        assertEquals(optimizeResponse.getAmountPaidEconomy(), 189);
        assertEquals(optimizeResponse.getAmountPaidPremium(), 1054);
        assertEquals(optimizeResponse.getUsageEconomy(), 4);
        assertEquals(optimizeResponse.getUsagePremium(), 6);

    }
}
