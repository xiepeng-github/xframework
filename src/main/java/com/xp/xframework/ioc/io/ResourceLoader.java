package com.xp.xframework.ioc.io;

import com.xp.xframework.ioc.utils.ResourceUtils;

public interface ResourceLoader {
	
	/** Pseudo URL prefix for loading from the class path: "classpath:" */
	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;

	Resource getResource(String location);

	//@Nullable
	ClassLoader getClassLoader();
}
