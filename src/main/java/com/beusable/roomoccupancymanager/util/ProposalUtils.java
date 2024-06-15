package com.beusable.roomoccupancymanager.util;

import com.beusable.roomoccupancymanager.model.OptimizeRequest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProposalUtils {

    public static List<Integer> getLowOffers(List<Integer> guestList) {
        return guestList
                .stream()
                .filter(offer -> offer  < 100)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<Integer> getHighOffers(List<Integer> guestList) {
        return guestList
                .stream()
                .filter(offer -> offer  >= 100)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<Integer> getGuestOrdered(OptimizeRequest optimizeRequest) {
        return optimizeRequest.getGuests().
                stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

}
