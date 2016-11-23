/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils;

import com.qq.connect.utils.QQConnectConfig;

public class Version {
    private static String VERSION = "2.0.0.0";
    private static final String TITLE = "qq_connect_sdk";

    public static String getVersion() {
        return VERSION;
    }

    public String toString() {
        return "qq_connect_sdk " + VERSION;
    }

    static {
        try {
            VERSION = QQConnectConfig.getValue("version");
        }
        catch (Exception e) {
            VERSION = "2.0.0.0";
        }
        if (VERSION.equals("")) {
            VERSION = "2.0.0.0";
        }
    }
}

