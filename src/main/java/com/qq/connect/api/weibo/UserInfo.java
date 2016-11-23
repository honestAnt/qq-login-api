/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.weibo;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.weibo.FansIdolsBean;
import com.qq.connect.javabeans.weibo.UserInfoBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONObject;
import java.util.ArrayList;

public class UserInfo
extends QQConnect {
    private static final long serialVersionUID = -6124397423510235640L;

    public UserInfo(String token, String openID) {
        super(token, openID);
    }

    private UserInfoBean getUserInfo(String openid) throws QQConnectException {
        return new UserInfoBean(this.client.get(QQConnectConfig.getValue("getWeiboUserInfoURL"), new PostParameter[]{new PostParameter("openid", openid), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("access_token", this.client.getToken()), new PostParameter("format", "json")}).asJSONObject());
    }

    public UserInfoBean getUserInfo() throws QQConnectException {
        return this.getUserInfo(this.client.getOpenID());
    }

    public /* varargs */ FansIdolsBean getFansList(int reqnum, int startIndex, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("reqnum", reqnum));
        postParameterArray.add(new PostParameter("startindex", startIndex));
        for (String parameter : parameters) {
            if (parameter.indexOf("mode=") == 0) {
                postParameterArray.add(new PostParameter("mode", parameter.substring(5)));
                continue;
            }
            if (parameter.indexOf("install=") == 0) {
                postParameterArray.add(new PostParameter("install", parameter.substring(8)));
                continue;
            }
            if (parameter.indexOf("sex=") == 0) {
                postParameterArray.add(new PostParameter("sex", parameter.substring(4)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        PostParameter[] parameters1 = postParameterArray.toArray(new PostParameter[1]);
        return new FansIdolsBean(this.client.get(QQConnectConfig.getValue("getFansListURL"), parameters1).asJSONObject());
    }

    public /* varargs */ FansIdolsBean getIdolsList(int reqnum, int startIndex, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("reqnum", reqnum));
        postParameterArray.add(new PostParameter("startindex", startIndex));
        for (String parameter : parameters) {
            if (parameter.indexOf("mode=") == 0) {
                postParameterArray.add(new PostParameter("mode", parameter.substring(5)));
                continue;
            }
            if (parameter.indexOf("install=") == 0) {
                postParameterArray.add(new PostParameter("install", parameter.substring(8)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        PostParameter[] parameters1 = postParameterArray.toArray(new PostParameter[1]);
        return new FansIdolsBean(this.client.get(QQConnectConfig.getValue("getIdolsListURL"), parameters1).asJSONObject());
    }
}

