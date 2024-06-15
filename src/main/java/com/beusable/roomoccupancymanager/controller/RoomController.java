package com.beusable.roomoccupancymanager.controller;

import com.beusable.roomoccupancymanager.exception.InvalidRequestException;
import com.beusable.roomoccupancymanager.model.OptimizeRequest;
import com.beusable.roomoccupancymanager.model.OptimizeResponse;
import com.beusable.roomoccupancymanager.service.RoomService;
import com.beusable.roomoccupancymanager.validation.RequestValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    private  RequestValidator requestValidator;

    @PostMapping("/rooms/optimize")
    ResponseEntity<OptimizeResponse> optimizeRooms(@Valid @RequestBody OptimizeRequest optimizeRequest) {

        if (requestValidator.invalidRequest(optimizeRequest)) {
            throw new InvalidRequestException();
        }

        return new ResponseEntity<>(roomService.optimizeRooms(optimizeRequest), HttpStatus.OK);

    }

}
