package com.xp.xframework.ioc.factory.json;

import com.xp.xframework.ioc.factory.BeanFactory;
import com.xp.xframework.ioc.io.ResourceLoader;

public class JsonBeanDefinitionReader {

	private final BeanFactory beanFactory;
	
	//@Nullable
	private ResourceLoader resourceLoader;

	//@Nullable
	private ClassLoader beanClassLoader;
	
	
	public JsonBeanDefinitionReader(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
		
		//if(this.beanFactory instanceof )
	}
	
	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public ClassLoader getBeanClassLoader() {
		return beanClassLoader;
	}

	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}	
}
