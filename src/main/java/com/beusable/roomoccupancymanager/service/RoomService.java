package com.beusable.roomoccupancymanager.service;

import com.beusable.roomoccupancymanager.model.OptimizeRequest;
import com.beusable.roomoccupancymanager.model.OptimizeResponse;
import com.beusable.roomoccupancymanager.util.ProposalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoomService {
    private final static Logger logger = LoggerFactory.getLogger(RoomService.class);

    public OptimizeResponse optimizeRooms(OptimizeRequest optimizeRequest) {
        logger.info("optimizeRooms() {}", optimizeRequest);

        List<Integer> economyRoomOffers = new ArrayList<>();
        List<Integer> premiumRoomOffers = new ArrayList<>();

        List<Integer> guestListOrdered = ProposalUtils.getGuestOrdered(optimizeRequest);

        List<Integer> higherOffers = ProposalUtils.getHighOffers(guestListOrdered);

        List<Integer> lowerOffers = ProposalUtils.getLowOffers(guestListOrdered);

        higherOffers.forEach(offer -> {
            if (premiumRoomOffers.size() < optimizeRequest.getPremiumRoomsAvailable()) {
                premiumRoomOffers.add(offer);
                guestListOrdered.remove(offer);
            }
        });

        AtomicInteger economyLeftOver = new AtomicInteger(lowerOffers.size() - optimizeRequest.getEconomyRoomsAvailable());
         lowerOffers.forEach(offer ->
        {
            if (economyLeftOver.get() > 0 && premiumRoomOffers.size() < optimizeRequest.getPremiumRoomsAvailable()) {
                premiumRoomOffers.add(offer);
                guestListOrdered.remove(offer);
                economyLeftOver.decrementAndGet();
            } else if (economyRoomOffers.size() < optimizeRequest.getEconomyRoomsAvailable()) {
                economyRoomOffers.add(offer);
                guestListOrdered.remove(offer);
            }
        });

        return OptimizeResponse.builder()
                .usageEconomy(economyRoomOffers.size())
                .usagePremium(premiumRoomOffers.size())
                .amountPaidEconomy(economyRoomOffers.stream().mapToInt(Integer::intValue).sum())
                .amountPaidPremium(premiumRoomOffers.stream().mapToInt(Integer::intValue).sum()).build();

    }
}
