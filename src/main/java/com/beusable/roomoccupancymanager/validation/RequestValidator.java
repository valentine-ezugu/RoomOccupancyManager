package com.beusable.roomoccupancymanager.validation;

import com.beusable.roomoccupancymanager.model.OptimizeRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    public   boolean invalidRequest(OptimizeRequest optimizeRequest) {
         return optimizeRequest.getEconomyRoomsAvailable() == null
                 || optimizeRequest.getPremiumRoomsAvailable() == null
                 || optimizeRequest.getGuests() == null;
    }
}
