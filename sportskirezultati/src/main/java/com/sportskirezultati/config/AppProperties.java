package com.sportskirezultati.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * App properties.
 */
@Component
@ConfigurationProperties(prefix = "sportski-rezultati")
@Data
public class AppProperties {

  private Long jwtExpiration;
  private String secretKey;
  private Long refreshExpiration;

  private Double basePoints;
  private Double minimalBet;

  private String rapidBaseUrl;

  private String rapidApiHost;
  private String rapidApiKey;

  private List<Integer> supportedLeagues;
  private Integer profileBetsCount;

  private String betCheckCron;
  private String banRemoveCron;

  private Integer numberOfBetsForHistoryView;
}
