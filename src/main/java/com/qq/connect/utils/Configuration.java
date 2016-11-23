/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils;

import com.qq.connect.utils.Version;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static Properties defaultProperty;
    private static boolean DALVIK;

    static void init() {
        defaultProperty = new Properties();
        defaultProperty.setProperty("qqConnect.debug", "false");
        defaultProperty.setProperty("qqConnect.clientURL", "https://graph.qq.com/user/get_user_info");
        defaultProperty.setProperty("qqConnect.http.useSSL", "false");
        defaultProperty.setProperty("qqConnect.http.connectionTimeout", "20000");
        defaultProperty.setProperty("qqConnect.http.readTimeout", "120000");
        defaultProperty.setProperty("qqConnect.http.retryCount", "3");
        defaultProperty.setProperty("qqConnect.http.retryIntervalSecs", "10");
        defaultProperty.setProperty("qqConnect.async.numThreads", "1");
        defaultProperty.setProperty("qqConnect.clientVersion", Version.getVersion());
        try {
            Class.forName("dalvik.system.VMRuntime");
            defaultProperty.setProperty("qqConnect.dalvik", "true");
        }
        catch (ClassNotFoundException cnfe) {
            defaultProperty.setProperty("qqConnect.dalvik", "false");
        }
        DALVIK = Configuration.getBoolean("qqConnect.dalvik");
        String qqConnectProps = "qqconnectconfig.properties";
        boolean loaded = Configuration.loadProperties(defaultProperty, "." + File.separatorChar + qqConnectProps) || Configuration.loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/WEB-INF/" + qqConnectProps)) || Configuration.loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/" + qqConnectProps));
    }

    private static boolean loadProperties(Properties props, String path) {
        try {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                props.load(new FileInputStream(file));
                return true;
            }
        }
        catch (Exception ignore) {
            // empty catch block
        }
        return false;
    }

    private static boolean loadProperties(Properties props, InputStream is) {
        try {
            props.load(is);
            return true;
        }
        catch (Exception ignore) {
            return false;
        }
    }

    public static boolean isDalvik() {
        return DALVIK;
    }

    public static boolean useSSL() {
        return Configuration.getBoolean("qqConnect.http.useSSL");
    }

    public static String getScheme() {
        return Configuration.useSSL() ? "https://" : "http://";
    }

    public static String getCilentVersion() {
        return Configuration.getProperty("qqConnect.clientVersion");
    }

    public static String getClientURL() {
        return Configuration.getProperty("qqConnect.clientURL");
    }

    public static int getReadTimeout() {
        return Configuration.getIntProperty("qqConnect.http.readTimeout");
    }

    public static int getRetryCount() {
        return Configuration.getIntProperty("qqConnect.http.retryCount");
    }

    public static int getRetryIntervalSecs() {
        return Configuration.getIntProperty("qqConnect.http.retryIntervalSecs");
    }

    public static String getUser() {
        return Configuration.getProperty("qqConnect.user");
    }

    public static String getPassword() {
        return Configuration.getProperty("qqConnect.password");
    }

    public static String getUserAgent() {
        return Configuration.getProperty("qqConnect.http.userAgent");
    }

    public static String getOAuthConsumerKey() {
        return Configuration.getProperty("qqConnect.oauth.consumerKey");
    }

    public static String getOAuthConsumerSecret() {
        return Configuration.getProperty("qqConnect.oauth.consumerSecret");
    }

    public static boolean getBoolean(String name) {
        String value = Configuration.getProperty(name);
        return Boolean.valueOf(value);
    }

    public static int getIntProperty(String name) {
        String value = Configuration.getProperty(name);
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static long getLongProperty(String name) {
        String value = Configuration.getProperty(name);
        try {
            return Long.parseLong(value);
        }
        catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static String getProperty(String name) {
        return defaultProperty.getProperty(name);
    }

    public static int getNumberOfAsyncThreads() {
        return Configuration.getIntProperty("qqConnect.async.numThreads");
    }

    public static boolean getDebug() {
        return Configuration.getBoolean("qqConnect.debug");
    }

    static {
        Configuration.init();
    }
}

