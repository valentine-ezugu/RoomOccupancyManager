package com.beusable.roomoccupancymanager.service;

import com.beusable.roomoccupancy.model.OptimizeRequest;
import com.beusable.roomoccupancy.model.OptimizeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final static Logger logger = LoggerFactory.getLogger(RoomService.class);

    public OptimizeResponse optimizeRooms(OptimizeRequest optimizeRequest) {
        return null;
    }

}
