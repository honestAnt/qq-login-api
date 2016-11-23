/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.weibo;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.weibo.RepostInfoBean;
import com.qq.connect.javabeans.weibo.WeiboBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.ImageItem;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONObject;
import java.util.ArrayList;

public class Weibo
extends QQConnect {
    private static final long serialVersionUID = -3088533004308446275L;

    public Weibo(String token, String openID) {
        super(token, openID);
    }

    private WeiboBean send(PostParameter[] parameters, String targetUrl) throws QQConnectException {
        return new WeiboBean(this.client.post(QQConnectConfig.getValue(targetUrl), parameters).asJSONObject());
    }

    public WeiboBean delWeibo(String weiboID) throws QQConnectException {
        return this.send(new PostParameter[]{new PostParameter("id", weiboID), new PostParameter("format", "json"), new PostParameter("access_token", this.client.getToken()), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("openid", this.client.getOpenID())}, "delTURL");
    }

    public /* varargs */ WeiboBean addWeibo(String content, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("content", content));
        for (String parameter : parameters) {
            if (parameter.indexOf("clientip") == 0) {
                postParameterArray.add(new PostParameter("clientip", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("longitude") == 0) {
                postParameterArray.add(new PostParameter("longitude", parameter.substring(10)));
                continue;
            }
            if (parameter.indexOf("latitude") == 0) {
                postParameterArray.add(new PostParameter("latitude", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("syncflag") == 0) {
                postParameterArray.add(new PostParameter("syncflag", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("compatibleflag") == 0) {
                postParameterArray.add(new PostParameter("compatibleflag", parameter.substring(6)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return this.send(postParameterArray.toArray(new PostParameter[1]), "addTURL");
    }

    public RepostInfoBean getRepostList(int flag, String rootID, int pageFlag, String pageTime, int reqNum, String twitterID) throws QQConnectException {
        PostParameter[] parameters = null;
        parameters = new PostParameter[]{new PostParameter("flag", flag), new PostParameter("rootid", rootID), new PostParameter("pageflag", pageFlag), new PostParameter("pagetime", pageTime), new PostParameter("reqnum", reqNum), new PostParameter("twitterid", twitterID), new PostParameter("format", "json"), new PostParameter("access_token", this.client.getToken()), new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")), new PostParameter("openid", this.client.getOpenID())};
        return new RepostInfoBean(this.client.get(QQConnectConfig.getValue("getRepostListURL"), parameters).asJSONObject());
    }

    public /* varargs */ WeiboBean addPicWeibo(String content, byte[] pic, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("content", content));
        for (String parameter : parameters) {
            if (parameter.indexOf("clientip=") == 0) {
                postParameterArray.add(new PostParameter("clientip", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("longitude=") == 0) {
                postParameterArray.add(new PostParameter("longitude", parameter.substring(10)));
                continue;
            }
            if (parameter.indexOf("latitude=") == 0) {
                postParameterArray.add(new PostParameter("latitude", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("syncflag=") == 0) {
                postParameterArray.add(new PostParameter("syncflag", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("compatibleflag=") == 0) {
                postParameterArray.add(new PostParameter("compatibleflag", parameter.substring(6)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        ImageItem image = new ImageItem("pic", pic);
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return new WeiboBean(this.client.multPartURL(QQConnectConfig.getValue("addPicTURL"), postParameterArray.toArray(new PostParameter[1]), image).asJSONObject());
    }
}

