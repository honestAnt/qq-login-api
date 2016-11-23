/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.weibo;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.weibo.UserInfoBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONObject;

public class OtherUserInfo
extends QQConnect {
    private static final long serialVersionUID = -6124397423510235640L;

    public OtherUserInfo(String token, String openID) {
        super(token, openID);
    }

    private UserInfoBean getUserInfo(String openid, String parameter, int flag) throws QQConnectException {
        PostParameter[] parameters = null;
        parameters = flag == 1 ? new PostParameter[]{new PostParameter("openid", openid), new PostParameter("name", parameter), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")} : new PostParameter[]{new PostParameter("openid", openid), new PostParameter("fopenid", parameter), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")};
        return new UserInfoBean(this.client.get(QQConnectConfig.getValue("getWeiboOtherUserInfoURL"), parameters).asJSONObject());
    }

    public UserInfoBean getUserInfoByName(String name) throws QQConnectException {
        return this.getUserInfo(this.client.getOpenID(), name, 1);
    }

    public UserInfoBean getUserInfoByOpenID(String fopenid) throws QQConnectException {
        return this.getUserInfo(this.client.getOpenID(), fopenid, 2);
    }
}

