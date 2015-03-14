package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.model.Foo;

@Configuration
@Profile("prod")
@ImportResource(value = "classpath:com/config/applicationContext3.xml")
public class SpringProdRootConfig {

	@Bean
	public Foo prodBean1() {
		return new Foo();
	}

	@Bean
	public Foo prodBean2() {
		return new Foo();
	}
}
