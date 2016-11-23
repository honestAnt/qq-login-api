/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.api.qzone;

import com.qq.connect.QQConnect;
import com.qq.connect.QQConnectException;
import com.qq.connect.javabeans.qzone.AlbumBean;
import com.qq.connect.javabeans.qzone.AlbumPicBean;
import com.qq.connect.utils.QQConnectConfig;
import com.qq.connect.utils.http.HttpClient;
import com.qq.connect.utils.http.ImageItem;
import com.qq.connect.utils.http.PostParameter;
import com.qq.connect.utils.http.Response;
import com.qq.connect.utils.json.JSONArray;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.util.ArrayList;

public class Album
extends QQConnect {
    private static final long serialVersionUID = -6962921164439096289L;

    public Album(String token, String openID) {
        super(token, openID);
    }

    private AlbumBean addAlbum(PostParameter[] parameters) throws QQConnectException {
        return new AlbumBean(this.client.post(QQConnectConfig.getValue("addAlbumURL"), parameters).asJSONObject());
    }

    public /* varargs */ AlbumBean addAlbum(String albumname, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("albumname", albumname));
        for (String parameter : parameters) {
            if (parameter.indexOf("albumdesc") == 0) {
                postParameterArray.add(new PostParameter("albumdesc", parameter.substring(10)));
                continue;
            }
            if (parameter.indexOf("priv") == 0) {
                postParameterArray.add(new PostParameter("priv", parameter.substring(5)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return this.addAlbum(postParameterArray.toArray(new PostParameter[1]));
    }

    private ArrayList<AlbumBean> listAlbum(PostParameter[] parameters) throws QQConnectException, JSONException {
        ArrayList<AlbumBean> abs = new ArrayList<AlbumBean>();
        JSONObject returnJSONObj = this.client.post(QQConnectConfig.getValue("listAlbumURL"), parameters).asJSONObject();
        int ret = returnJSONObj.getInt("ret");
        if (0 == ret) {
            int albumnum = returnJSONObj.getInt("albumnum");
            JSONArray jsonA = returnJSONObj.getJSONArray("album");
            for (int i = 0; i < albumnum; ++i) {
                JSONObject jo = jsonA.getJSONObject(i);
                abs.add(new AlbumBean(jo.getString("albumid"), jo.getString("classid"), jo.getLong("createtime"), jo.getString("desc"), jo.getString("name"), jo.getInt("priv"), jo.getString("coverurl"), jo.getInt("picnum")));
            }
        } else {
            abs.add(new AlbumBean(ret, returnJSONObj.getString("msg")));
        }
        return abs;
    }

    public ArrayList<AlbumBean> listAlbum() throws QQConnectException, JSONException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        return this.listAlbum(postParameterArray.toArray(new PostParameter[1]));
    }

    public /* varargs */ AlbumPicBean uploadPic(byte[] picture, String ... parameters) throws QQConnectException {
        ArrayList<PostParameter> postParameterArray = new ArrayList<PostParameter>();
        boolean flag = false;
        for (String parameter : parameters) {
            if (parameter.indexOf("photodesc=") == 0) {
                postParameterArray.add(new PostParameter("photodesc", parameter.substring(10)));
                continue;
            }
            if (parameter.indexOf("title=") == 0) {
                postParameterArray.add(new PostParameter("title", parameter.substring(6)));
                continue;
            }
            if (parameter.indexOf("albumid=") == 0) {
                postParameterArray.add(new PostParameter("albumid", parameter.substring(8)));
                continue;
            }
            if (parameter.indexOf("x=") == 0) {
                postParameterArray.add(new PostParameter("x", parameter.substring(2)));
                continue;
            }
            if (parameter.indexOf("y=") == 0) {
                postParameterArray.add(new PostParameter("y", parameter.substring(2)));
                continue;
            }
            if (parameter.indexOf("mobile=") == 0) {
                postParameterArray.add(new PostParameter("mobile", parameter.substring(7)));
                continue;
            }
            if (parameter.indexOf("needfeed=") == 0) {
                postParameterArray.add(new PostParameter("needfeed", parameter.substring(9)));
                continue;
            }
            if (parameter.indexOf("successnum=") == 0) {
                postParameterArray.add(new PostParameter("successnum", parameter.substring(11)));
                continue;
            }
            if (parameter.indexOf("picnum=") == 0) {
                postParameterArray.add(new PostParameter("picnum", parameter.substring(7)));
                continue;
            }
            throw new QQConnectException("you pass one illegal parameter");
        }
        ImageItem image = new ImageItem("picture", picture);
        postParameterArray.add(new PostParameter("format", "json"));
        postParameterArray.add(new PostParameter("access_token", this.client.getToken()));
        postParameterArray.add(new PostParameter("oauth_consumer_key", QQConnectConfig.getValue("app_ID")));
        postParameterArray.add(new PostParameter("openid", this.client.getOpenID()));
        PostParameter[] parameters1 = postParameterArray.toArray(new PostParameter[1]);
        return new AlbumPicBean(this.client.multPartURL(QQConnectConfig.getValue("uploadPicURL"), parameters1, image).asJSONObject());
    }
}

