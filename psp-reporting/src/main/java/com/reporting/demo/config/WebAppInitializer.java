package com.reporting.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.scan("com.reporting.demo");
		container.addListener(new ContextLoaderListener(rootContext));

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		
	}

}