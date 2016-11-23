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

public class Blog
extends QQConnect {
    private static final long serialVersionUID = -6962921164439096289L;

    public Blog(String token, String openID) {
        super(token, openID);
    }

    private GeneralResultBean addBlog(PostParameter[] parameters) throws QQConnectException {
        return new GeneralResultBean(this.client.post(QQConnectConfig.getValue("addBlogURL"), parameters).asJSONObject());
    }

    public GeneralResultBean addBlog(String title, String content) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("title", title));
        postParameterArray.add(new PostParameter("content", content));
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return this.addBlog(postParameterArray.toArray(new PostParameter[1]));
    }
}

