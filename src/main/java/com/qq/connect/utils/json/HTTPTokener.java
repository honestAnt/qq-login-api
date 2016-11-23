/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils.json;

import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONTokener;

public class HTTPTokener
extends JSONTokener {
    public HTTPTokener(String s) {
        super(s);
    }

    public String nextToken() throws JSONException {
        char c;
        StringBuffer sb = new StringBuffer();
        while (Character.isWhitespace(c = this.next())) {
        }
        if (c == '\"' || c == '\'') {
            char q = c;
            do {
                if ((c = this.next()) < ' ') {
                    throw this.syntaxError("Unterminated string.");
                }
                if (c == q) {
                    return sb.toString();
                }
                sb.append(c);
            } while (true);
        }
        while (c != '\u0000' && !Character.isWhitespace(c)) {
            sb.append(c);
            c = this.next();
        }
        return sb.toString();
    }
}

