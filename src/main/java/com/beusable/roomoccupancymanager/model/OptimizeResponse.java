package com.beusable.roomoccupancymanager.model;

import lombok.*;

import java.io.Serializable;

/**
 * OptimizeResponse
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OptimizeResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer usageEconomy;

  private Integer amountPaidEconomy;

  private Integer usagePremium;

  private Integer amountPaidPremium;

}

