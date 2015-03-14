package com.svc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class DemoSvc implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public List<String> getBeanList() {
		String[] beanNames = applicationContext
				.getBeanNamesForType(Object.class);
		List<String> beanList = Arrays.asList(beanNames);
		Collections.sort(beanList);
		return beanList;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}
}
