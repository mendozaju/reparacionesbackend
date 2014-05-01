package com.famp.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ImportResource({ "classpath*:/rest_security_config.xml","classpath*:/jpa_config.xml", "classpath*:/application-context.xml" })
@ComponentScan(basePackages = "com.famp.backend.*")
public class AppConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
