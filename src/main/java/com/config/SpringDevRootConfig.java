package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.model.Foo;

@Configuration
@Profile(value = { "dev", "!prod" })
@ImportResource(value = "classpath:com/config/applicationContext2.xml")
public class SpringDevRootConfig {

	@Bean
	public Foo devBean1() {
		return new Foo();
	}

	@Bean
	public Foo devBean2() {
		return new Foo();
	}

}
