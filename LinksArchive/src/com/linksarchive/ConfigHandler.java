package com.linksarchive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigHandler {
	private Properties properties;
	private String configFileName;
	private ConfigModel configMdl;
	
	ConfigHandler(ConfigModel configMdl) {
		properties = new Properties();
		configFileName = "config.properties";
		loadConfig();
		this.configMdl = configMdl;
	}
	
	private void loadConfig() {
		try {
		    properties.load(new FileInputStream(configFileName));
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		    return;
		} catch (IOException ex) {
		    ex.printStackTrace();
		    return;
		}
	}
	
}
