package com.sportskirezultati.config;

import com.sportskirezultati.auth.AuthEntryPointJwt;
import com.sportskirezultati.auth.AuthTokenFilter;
import com.sportskirezultati.common.EndpointUrls;
import com.sportskirezultati.common.Role;
import com.sportskirezultati.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class Config {

  private final UserDetailsService userDetailsService;

  private final UserService userService;

  private final AuthEntryPointJwt unauthorizedHandler;

  private final AuthTokenFilter authenticationJwtTokenFilter;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(EndpointUrls.SPORT_API + "/**").authenticated()
        .antMatchers(EndpointUrls.SEARCH_API + "/**").authenticated()
        .antMatchers(EndpointUrls.FRIENDS_API + "/**").authenticated()
        .antMatchers(EndpointUrls.PROFILE_API + "/**").authenticated()
        .antMatchers(EndpointUrls.ADMIN_API + "/**").hasRole(Role.ADMIN.getCode())
        .antMatchers(EndpointUrls.MOD_API + "/**")
        .hasAnyRole(Role.MOD.getCode(), Role.ADMIN.getCode())
        .antMatchers(EndpointUrls.AUTH_URL + "/**").permitAll()
        .and()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
        AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(userDetailsService);
    authenticationManagerBuilder.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());

    return authenticationManagerBuilder.build();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedMethods("*");
      }
    };
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
