package com.br.projeto.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public final class MessageProperties {
	
	static Resource resource = new ClassPathResource("messages.properties");
	
	public static String getKey(String key) throws IOException {
		Properties loadedProperties = PropertiesLoaderUtils.loadProperties(resource);
        if(!loadedProperties.isEmpty()) {
        	return loadedProperties.get(key).toString();
        }
		
		return "";
	}
}
