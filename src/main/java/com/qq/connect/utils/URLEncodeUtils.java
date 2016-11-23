/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.BitSet;

public class URLEncodeUtils {
    static BitSet dontNeedEncoding;

    public static final boolean isURLEncoded(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        boolean containsPercent = false;
        for (char c : chars) {
            if (Character.isWhitespace(c)) {
                return false;
            }
            if (!dontNeedEncoding.get(c)) {
                return false;
            }
            if (c != '%') continue;
            containsPercent = true;
        }
        if (!containsPercent) {
            return false;
        }
        return true;
    }

    public static final String encodeURL(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String decodeURL(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        int i;
        dontNeedEncoding = new BitSet(256);
        for (i = 97; i <= 122; ++i) {
            dontNeedEncoding.set(i);
        }
        for (i = 65; i <= 90; ++i) {
            dontNeedEncoding.set(i);
        }
        for (i = 48; i <= 57; ++i) {
            dontNeedEncoding.set(i);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
        dontNeedEncoding.set(43);
        dontNeedEncoding.set(37);
    }
}

