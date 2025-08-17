package com.edtech.user_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

  private final Key key;
  private final long expMillis;

  public JwtService(
      @Value("${jwt.secret}") String secret,
      @Value("${jwt.exp.minutes}") long expMinutes) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.expMillis = expMinutes * 60_000L;
  }

  public String generateToken(String username) {
    long now = System.currentTimeMillis();
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(now))
        .setExpiration(new Date(now + expMillis))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }
}
