package com.harsha.FarmerInfo.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoggingInterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private LoggingInterceptor loggingInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("loggingInterceptor registered");
		registry.addInterceptor(loggingInterceptor);
	}

}
