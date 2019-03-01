package com.ford.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    System.out.println("Configure Security.");
    http.cors().and().authorizeRequests().anyRequest().permitAll().and().csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    System.out.println("CORS Configuration");
    ArrayList<String> allowAll = new ArrayList<>();
    allowAll.add("*");

    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedHeaders(allowAll);
    corsConfig.setAllowedMethods(allowAll);
    corsConfig.setAllowedOrigins(allowAll);
    corsConfig.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
  }
}