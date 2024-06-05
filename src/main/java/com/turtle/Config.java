package com.turtle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;

import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@Configuration
@EnableReactiveMethodSecurity(useAuthorizationManager=true)
public class Config {
  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http
              .cors(cors -> cors.disable())
              .csrf(csrf -> csrf.disable())
              .httpBasic(httpBasic -> httpBasic.disable())
              .formLogin(formLogin -> formLogin.disable())
              .logout(logout -> logout.disable())
              .authorizeExchange(authorizeExchange ->
                authorizeExchange
                  .pathMatchers( "/**").permitAll()
                  .pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                  .anyExchange().authenticated()
              )
              .exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint((swe, e) -> {
                  // log.info("Unauthorized ", e);
                  return Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED));
                })
                .accessDeniedHandler((swe, e) -> {
                  // log.info("Access Denied ", e);
                  return Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN));
                })
              )
              .build();
  }
}
