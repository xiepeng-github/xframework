package com.xp.xframework.ioc.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.xp.xframework.ioc.utils.ClassUtils;
import com.xp.xframework.ioc.utils.StringUtils;

public class ClassPathResource implements InputStreamSource{

	private final String path;
	
	//@Nullable
	private ClassLoader classLoader;
	
	//@Nullable
	private Class<?> clazz;
	
	public ClassPathResource(String path) {
		this(path, (ClassLoader) null);
	}
	
	public ClassPathResource(String path, ClassLoader classLoader) {
		String pathToUse = StringUtils.cleanPath(path);
		if (pathToUse.startsWith("/")) {
			pathToUse = pathToUse.substring(1);
		}
		this.path = pathToUse;
		this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
		
		InputStream is;
		if (this.clazz != null) {
			is = this.clazz.getResourceAsStream(this.path);
		}
		else if (this.classLoader != null) {
			is = this.classLoader.getResourceAsStream(this.path);
		}
		else {
			is = ClassLoader.getSystemResourceAsStream(this.path);
		}
		if (is == null) {
			throw new FileNotFoundException(getDescription() + " cannot be opened because it does not exist");
		}
		return is;
	}
	
	public String getDescription() {
		StringBuilder builder = new StringBuilder("class path resource [");
		String pathToUse = path;
		if (this.clazz != null && !pathToUse.startsWith("/")) {
			builder.append(ClassUtils.classPackageAsResourcePath(this.clazz));
			builder.append('/');
		}
		if (pathToUse.startsWith("/")) {
			pathToUse = pathToUse.substring(1);
		}
		builder.append(pathToUse);
		builder.append(']');
		return builder.toString();
	}	
	

}
