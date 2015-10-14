package com.alucarweb.util;

import java.io.IOException;
import java.util.Properties;

public class AlucarConfig {

	public enum Property {
		AWS_ACCESS_KEY_ID,
		AWS_SECRET_ACCESS_KEY,
		IMAGES_URL,
		IMAGES_FOLDER,
		ALUCAR_BUCKET
		;
	}

	private final Properties properties = new Properties();
	private static AlucarConfig INSTANCE = new AlucarConfig();

	private AlucarConfig() {
		try {
			properties.load(AlucarConfig.class.getResourceAsStream("alucar.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AlucarConfig getInstance() {
		return INSTANCE;
	}

	Properties getProperties() {
		return properties;
	}

	public static String get(Property key) {
		return getValue(key);
	}

	private static String getValue(Property key) {
		return INSTANCE.getProperties().getProperty(key.toString());
	}
}
