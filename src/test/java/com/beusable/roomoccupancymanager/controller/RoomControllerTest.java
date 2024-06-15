package com.beusable.roomoccupancymanager.controller;

import com.beusable.roomoccupancymanager.exception.InvalidRequestException;
import com.beusable.roomoccupancymanager.model.OptimizeRequest;
import com.beusable.roomoccupancymanager.service.RoomService;
import com.beusable.roomoccupancymanager.validation.RequestValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RoomController.class)
class RoomControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private RoomService roomService;

    @MockBean
    RequestValidator requestValidator;

    private static final String URL = "/rooms/optimize";


    @Test
    public void whenValidInput_Optimize() throws Exception {
        OptimizeRequest optimizeRequest = new OptimizeRequest();
        optimizeRequest.setGuests(Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209));
        optimizeRequest.setPremiumRoomsAvailable(8);
        optimizeRequest.setEconomyRoomsAvailable(3);
        mockMvc.perform(post(URL).contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(optimizeRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void whenNullInput_thenReturns400() throws Exception {
        OptimizeRequest optimizeRequest = new OptimizeRequest();
        optimizeRequest.setEconomyRoomsAvailable(null);
        optimizeRequest.setGuests(null);
        optimizeRequest.setPremiumRoomsAvailable(null);
        mockMvc.perform(post(URL)
                        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(optimizeRequest))).andExpect(status()
                        .isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidRequestException));

    }

}
