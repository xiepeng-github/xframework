package com.xp.xframework.ioc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

import com.xp.xframework.ioc.utils.StringUtils;

public class FileSystemResource implements InputStreamSource {

	private final File file;

	private final String path;

	public FileSystemResource(File file) {
		//Assert.notNull(file, "File must not be null");
		this.file = file;
		this.path = StringUtils.cleanPath(file.getPath());
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
		try {
			return Files.newInputStream(this.file.toPath());
		}
		catch (NoSuchFileException ex) {
			throw new FileNotFoundException(ex.getMessage());
		}
	}

}
