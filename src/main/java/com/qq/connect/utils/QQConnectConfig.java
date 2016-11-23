/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import javax.naming.ConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QQConnectConfig {

    private static PropertiesConfiguration config = null;

    static {
        try {
            config = new PropertiesConfiguration("qqconnectconfig.properties");
            config.setReloadingStrategy(new FileChangedReloadingStrategy());
        } catch (org.apache.commons.configuration.ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return config.getString(key);
    }

    public static void updateProperties(String key, String value) {
        config.setProperty(key, value);
    }

}

