package com.gotprint.nms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class NMSSecurityConfig extends WebSecurityConfigurerAdapter
{

   @Autowired
   AuthenticationEntryPoint authenticationEntryPoint;

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
   {
      auth.inMemoryAuthentication().withUser("nms").password("$2a$04$BmMV84QSoTrOajVRpfvqOuJsJ.txhRcWAikUZt8GjY0WpmeBaZqcG").authorities("ROLE_USER");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception
   {
      http.authorizeRequests().antMatchers("/securityNone").permitAll().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(
         authenticationEntryPoint);
   }

   @Bean
   public BCryptPasswordEncoder encoder()
   {
      return new BCryptPasswordEncoder();
   }
}
