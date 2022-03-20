package com.h2soft.springjava.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml 대신하는 클래스

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	//root-context.xml 대신하는 선언
	@Override
	protected Class<?>[] getRootConfigClasses() {		
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {		
		return new String[] {"/"};
	}

}
