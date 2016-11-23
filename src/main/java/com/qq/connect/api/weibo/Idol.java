/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.weibo;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.GeneralResultBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONObject;

public class Idol
extends QQConnect {
    private static final long serialVersionUID = -6124397423510235640L;

    public Idol(String token, String openID) {
        super(token, openID);
    }

    private GeneralResultBean sendRequest(String openid, String parameter, int flag, int flag2) throws QQConnectException {
        PostParameter[] parameters = null;
        parameters = flag == 1 ? new PostParameter[]{new PostParameter("name", parameter), new PostParameter("openid", openid), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")} : (flag2 == 1 ? new PostParameter[]{new PostParameter("fopenids", parameter), new PostParameter("openid", openid), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")} : new PostParameter[]{new PostParameter("fopenid", parameter), new PostParameter("openid", openid), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")});
        String url = "";
        url = flag2 == 1 ? "addIdolURL" : "delIdolURL";
        return new GeneralResultBean(this.client.post(QQConnectConfig.getValue(url), parameters).asJSONObject());
    }

    public GeneralResultBean addIdolByName(String name) throws QQConnectException {
        return this.sendRequest(this.client.getOpenID(), name, 1, 1);
    }

    public GeneralResultBean addIdolByOpenID(String fopenids) throws QQConnectException {
        return this.sendRequest(this.client.getOpenID(), fopenids, 2, 1);
    }

    public GeneralResultBean delIdolByName(String name) throws QQConnectException {
        return this.sendRequest(this.client.getOpenID(), name, 1, 2);
    }

    public GeneralResultBean delIdolByOpenID(String fopenids) throws QQConnectException {
        return this.sendRequest(this.client.getOpenID(), fopenids, 2, 2);
    }
}

