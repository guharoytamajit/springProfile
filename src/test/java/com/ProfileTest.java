package com;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.SpringConfig;
import com.config.SpringDevRootConfig;
import com.config.SpringProdRootConfig;
import com.svc.DemoSvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class,
		SpringDevRootConfig.class, SpringProdRootConfig.class })
@ActiveProfiles(profiles = { "prod", "def" })
public class ProfileTest {
	@Autowired
	Environment env;
	@Autowired
	DemoSvc demoSvc;

	@Test
	public void testProfile() {
		String[] activeProfiles = env.getActiveProfiles();
		System.out.println("activeProfiles  " + Arrays.asList(activeProfiles));
		System.out.println("Bean list:");
		System.out.println(demoSvc.getBeanList());
	}

}
