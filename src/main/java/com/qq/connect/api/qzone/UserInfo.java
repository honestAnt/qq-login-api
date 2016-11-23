/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.qzone;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONObject;

public class UserInfo
extends QQConnect {
    private static final long serialVersionUID = -6124397423510235640L;

    public UserInfo(String token, String openID) {
        super(token, openID);
    }

    private UserInfoBean getUserInfo(String openid) throws QQConnectException {
        return new UserInfoBean(this.client.get(QQConnectConfig.getValue("getUserInfoURL"), new PostParameter[]{new PostParameter("openid", openid), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")}).asJSONObject());
    }

    public UserInfoBean getUserInfo() throws QQConnectException {
        return this.getUserInfo(this.client.getOpenID());
    }
}

