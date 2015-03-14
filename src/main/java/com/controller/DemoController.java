package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.svc.DemoSvc;

@Controller
public class DemoController {
	@Autowired
	DemoSvc demoSvc;

	@RequestMapping("/test")
	public String displayBeans(ModelMap map) {
		List<String> beanList = demoSvc.getBeanList();
		map.addAttribute("beans", beanList);
		return "beanList";
	}

}
