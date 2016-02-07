/*
 *
 *  * *************************************************************************|
 *  *  Copyright (c) 2015. Yaana Technologies. All rights reserved.           *|
 *  *  Yaana Technologies PROPRIETARY/CONFIDENTIAL                            *|
 *  * *************************************************************************|
 *
 */

package com.meetup.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

  @Bean
  public Module javaTimeModule() {
    return new JavaTimeModule();
  }
}
