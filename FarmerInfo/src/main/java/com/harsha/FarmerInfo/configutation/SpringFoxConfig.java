package com.harsha.FarmerInfo.configutation;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("FarmerInfo").apiInfo(apiInfo()).select()
				.paths(regex("/FarmerInfo.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("FarmerInfo API").description("FarmerInfo API reference for developers")
				.termsOfServiceUrl("").license("FarmerInfo License").licenseUrl("Harsha").version("1.0").build();
	}
}