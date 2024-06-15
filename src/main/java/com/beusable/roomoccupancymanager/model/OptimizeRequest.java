package com.beusable.roomoccupancymanager.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptimizeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer economyRoomsAvailable;

    private Integer premiumRoomsAvailable;

    private List<Integer> guests = new ArrayList<>();

}

