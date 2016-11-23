/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenID
extends QQConnect {
    private static final long serialVersionUID = 6913005509508673584L;

    public OpenID(String token) {
        this.client.setToken(token);
    }

    private String getUserOpenID(String accessToken) throws QQConnectException {
        String openid = "";
        String jsonp = this.client.get(QQConnectConfig.getValue("getOpenIDURL"), new PostParameter[]{new PostParameter("access_token", accessToken)}).asString();
        Matcher m = Pattern.compile("\"openid\"\\s*:\\s*\"(\\w+)\"").matcher(jsonp);
        if (!m.find()) {
            throw new QQConnectException("server error!");
        }
        openid = m.group(1);
        return openid;
    }

    public String getUserOpenID() throws QQConnectException {
        String accessToken = this.client.getToken();
        return this.getUserOpenID(accessToken);
    }
}

