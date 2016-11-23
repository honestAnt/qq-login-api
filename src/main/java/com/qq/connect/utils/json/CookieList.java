/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils.json;

import com.qq.connect.utils.json.Cookie;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import com.qq.connect.utils.json.JSONTokener;
import java.util.Iterator;

public class CookieList {
    public static JSONObject toJSONObject(String string) throws JSONException {
        JSONObject o = new JSONObject();
        JSONTokener x = new JSONTokener(string);
        while (x.more()) {
            String name = Cookie.unescape(x.nextTo('='));
            x.next('=');
            o.put(name, Cookie.unescape(x.nextTo(';')));
            x.next();
        }
        return o;
    }

    public static String toString(JSONObject o) throws JSONException {
        boolean b = false;
        Iterator keys = o.keys();
        StringBuffer sb = new StringBuffer();
        while (keys.hasNext()) {
            String s = keys.next().toString();
            if (o.isNull(s)) continue;
            if (b) {
                sb.append(';');
            }
            sb.append(Cookie.escape(s));
            sb.append("=");
            sb.append(Cookie.escape(o.getString(s)));
            b = true;
        }
        return sb.toString();
    }
}

