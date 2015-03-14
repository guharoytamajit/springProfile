package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringConfig;
import com.config.SpringDevRootConfig;
import com.config.SpringProdRootConfig;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringConfig.class);
		applicationContext.register(SpringDevRootConfig.class);
		applicationContext.register(SpringProdRootConfig.class);
		applicationContext.getEnvironment().addActiveProfile("dev");
		applicationContext.getEnvironment().addActiveProfile("def");
		applicationContext.refresh();
		String[] beanNames = applicationContext
				.getBeanNamesForType(Object.class);
		List<String> beanList = Arrays.asList(beanNames);
		Collections.sort(beanList);
		System.out.println(beanList);
	}
}
