package com;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.config.SpringConfig;
import com.config.SpringDevRootConfig;
import com.config.SpringProdRootConfig;

public class Application implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		/*
		 * <context-param> <param-name>spring.profiles.active</param-name>
		 * <param-value>dev</param-value> </context-param>
		 */
		// here we can pass comma separated multiple profile names
		servletContext.setInitParameter("spring.profiles.active", "dev");
		// we are setting the name of default profile( by default
		// spring.profiles.default="default"
		// ).If no profile is activate only "def" profile and other non-profile
		// beans will be registered
		servletContext.setInitParameter("spring.profiles.default", "def");

		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(SpringDevRootConfig.class);
		applicationContext.register(SpringProdRootConfig.class);
		servletContext
				.addListener(new ContextLoaderListener(applicationContext));
		/*
		 * we could also use XmlWebApplicationContext instead of
		 * AnnotationConfigWebApplicationContext as shown below
		 */
		/*
		 * XmlWebApplicationContext applicationContext = new
		 * XmlWebApplicationContext();
		 * applicationContext.setConfigLocation("/WEB-INF/spring-servlet.xml");
		 */

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(SpringConfig.class);
		Dynamic servlet = servletContext.addServlet("spring",
				new DispatcherServlet(webApplicationContext));
		servlet.addMapping("/");
	}
}
