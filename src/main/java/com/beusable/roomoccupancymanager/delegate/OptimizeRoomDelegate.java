package com.beusable.roomoccupancymanager.delegate;

import com.beusable.roomoccupancy.model.OptimizeRequest;
import com.beusable.roomoccupancy.model.OptimizeResponse;
import com.beusable.roomoccupancymanager.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptimizeRoomDelegate implements com.beusable.roomoccupancy.api.OptimizeApiDelegate {

    private final RoomService roomService;

    @Override
    public ResponseEntity<OptimizeResponse> optimizeRooms(OptimizeRequest optimizeRequest) {
        OptimizeResponse optimizeResponse = roomService.optimizeRooms(optimizeRequest);
        return new ResponseEntity<>(optimizeResponse, HttpStatus.OK);
    }
}
