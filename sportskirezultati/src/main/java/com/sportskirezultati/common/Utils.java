package com.sportskirezultati.common;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * Util methods.
 */
@Slf4j
public class Utils {

  private Utils() {
  }

  public static String generateJwtToken(String username, Long jwtExpiration, String jwtSecret) {
    return Jwts.builder().setSubject(username).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpiration)).signWith(
            SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public static boolean validateJwtToken(String token, String jwtSecret) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (SignatureException e) {
      log.error("Neispravan jwt token: {}", token);
    }

    return false;
  }

  public static String getUsernameFromJwtToken(String token, String jwtSecret) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }
}
