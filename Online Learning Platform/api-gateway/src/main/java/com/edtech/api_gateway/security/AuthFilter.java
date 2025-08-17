package com.edtech.api_gateway.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import reactor.core.publisher.Mono;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthFilter implements GlobalFilter {

  private final JwtUtil jwtUtil;
  private final AntPathMatcher pathMatcher = new AntPathMatcher();

  public AuthFilter(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    String path = request.getURI().getPath();

    // Public (no token required)
    if (pathMatcher.match("/auth/**", path)
        || pathMatcher.match("/actuator/**", path)
        || pathMatcher.match("/eureka/**", path)
        || "OPTIONS".equalsIgnoreCase(request.getMethodValue())) {
      return chain.filter(exchange);
    }

    // Expect Bearer token for all other paths
    String authHeader = request.getHeaders().getFirst("Authorization");
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
      return exchange.getResponse().setComplete();
    }

    String token = authHeader.substring(7);
    if (!jwtUtil.validateToken(token)) {
      exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
      return exchange.getResponse().setComplete();
    }

    // (optional) you can add username to headers for downstream services
    // String username = jwtUtil.getUsername(token);
    // ServerHttpRequest mutated = exchange.getRequest().mutate()
    //     .header("X-User", username).build();
    // return chain.filter(exchange.mutate().request(mutated).build());

    return chain.filter(exchange);
  }
}
