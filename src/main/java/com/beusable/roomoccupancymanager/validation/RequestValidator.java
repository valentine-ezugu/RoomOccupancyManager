package com.beusable.roomoccupancymanager.validation;

import com.beusable.roomoccupancymanager.model.OptimizeRequest;


public class RequestValidator {

    public static  boolean invalidRequest(OptimizeRequest optimizeRequest) {
         return optimizeRequest.getEconomyRoomsAvailable() == null
                 || optimizeRequest.getPremiumRoomsAvailable() == null
                 || optimizeRequest.getGuests() == null;
    }
}
