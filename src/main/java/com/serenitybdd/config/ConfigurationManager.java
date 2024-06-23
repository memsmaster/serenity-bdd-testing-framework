package com.serenitybdd.config;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ConfigurationManager {

    private static final EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getConfigValue(String key) {
        return variables.getProperty(key);
    }

    public static String getBaseUrl() {
        return getConfigValue("webdriver.base.url");
    }

    public static String getApiBaseUrl() {
        return getConfigValue("api.base.url");
    }
}
