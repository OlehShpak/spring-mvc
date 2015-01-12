package com.shpak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.shpak.utils.PerformanceLoggingAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({ "com.shpak.utils" })
public class ServiceConfig {

	@Bean
	public PerformanceLoggingAspect  performanceLoggingAspect() {
	        return new PerformanceLoggingAspect();
	}


}
