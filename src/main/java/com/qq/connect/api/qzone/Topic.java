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

public class Topic
extends QQConnect {
    private static final long serialVersionUID = -3088533004308446275L;

    public Topic(String token, String openID) {
        super(token, openID);
    }

    private GeneralResultBean addTopic(PostParameter[] parameters) throws QQConnectException {
        return new GeneralResultBean(this.client.post(QQConnectConfig.getValue("addTopicURL"), parameters).asJSONObject());
    }

    public /* varargs */ GeneralResultBean addTopic(String con, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("con", con));
        for (String parameter : parameters) {
            if (parameter.indexOf("richtype=") == 0) {
                postParameterArray.add(new PostParameter("richtype", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("richval=") == 0) {
                postParameterArray.add(new PostParameter("richval", parameter.substring(8)));
                continue;
            }
            if (parameter.indexOf("lbs_nm=") == 0) {
                postParameterArray.add(new PostParameter("lbs_nm", parameter.substring(7)));
                continue;
            }
            if (parameter.indexOf("lbs_x=") == 0) {
                postParameterArray.add(new PostParameter("lbs_x", parameter.substring(6)));
                continue;
            }
            if (parameter.indexOf("lbs_y=") == 0) {
                postParameterArray.add(new PostParameter("lbs_y", parameter.substring(6)));
                continue;
            }
            if (parameter.indexOf("third_source=") == 0) {
                postParameterArray.add(new PostParameter("third_source", parameter.substring(13)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return this.addTopic(postParameterArray.toArray(new PostParameter[1]));
    }
}

