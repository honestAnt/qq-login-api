/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.qzone;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.GeneralResultBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONObject;
import java.util.ArrayList;

public class Share
extends QQConnect {
    private static final long serialVersionUID = -3088533004308446275L;

    public Share(String token, String openID) {
        super(token, openID);
    }

    private GeneralResultBean addShare(PostParameter[] parameters) throws QQConnectException {
        return new GeneralResultBean(this.client.post(QQConnectConfig.getValue("addShareURL"), parameters).asJSONObject());
    }

    public /* varargs */ GeneralResultBean addShare(String title, String url, String site, String fromUrl, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("title", title));
        postParameterArray.add(new PostParameter("url", url));
        postParameterArray.add(new PostParameter("site", site));
        postParameterArray.add(new PostParameter("fromurl", fromUrl));
        for (String parameter : parameters) {
            if (parameter.indexOf("comment") == 0) {
                postParameterArray.add(new PostParameter("comment", parameter.substring(8)));
                continue;
            }
            if (parameter.indexOf("summary") == 0) {
                postParameterArray.add(new PostParameter("summary", parameter.substring(8)));
                continue;
            }
            if (parameter.indexOf("images") == 0) {
                postParameterArray.add(new PostParameter("images", parameter.substring(7)));
                continue;
            }
            if (parameter.indexOf("type") == 0) {
                postParameterArray.add(new PostParameter("type", parameter.substring(5)));
                continue;
            }
            if (parameter.indexOf("playurl") == 0) {
                postParameterArray.add(new PostParameter("playurl", parameter.substring(8)));
                continue;
            }
            if (parameter.indexOf("nswb") == 0) {
                postParameterArray.add(new PostParameter("nswb", parameter.substring(5)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return this.addShare(postParameterArray.toArray(new PostParameter[1]));
    }
}

