package com.edtech.api_gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

  private final Key key;

  public JwtUtil(@Value("${jwt.secret}") String secret) {
    // HS256 key from secret
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  public String getUsername(String token) {
    Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
            .parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
