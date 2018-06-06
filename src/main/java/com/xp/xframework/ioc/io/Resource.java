package com.xp.xframework.ioc.io;

public interface Resource extends InputStreamSource{

	boolean exists();
	
	default boolean isFile() {
		return false;
	}	
}
