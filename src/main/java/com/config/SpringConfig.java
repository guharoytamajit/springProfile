package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.model.Foo;

@Configuration
@ComponentScan("com")
@ImportResource(value = "classpath:com/config/applicationContext.xml")
public class SpringConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	@Profile("dev")
	public Foo devBean3() {
		return new Foo();
	}

	@Bean
	@Profile("prod")
	public Foo prodBean3() {
		return new Foo();
	}

	@Bean
	@Profile("def")
	public Foo defaultBean1() {
		return new Foo();
	}

	@Bean
	@Profile("def")
	public Foo defaultBean2() {
		return new Foo();
	}
}
