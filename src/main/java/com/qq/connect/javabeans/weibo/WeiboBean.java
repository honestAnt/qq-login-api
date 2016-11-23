//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qq.connect.javabeans.weibo;

import com.qq.connect.QQConnectException;
import com.qq.connect.QQConnectResponse;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;

public class WeiboBean extends QQConnectResponse implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private String msg = "";
    private int errcode = 0;
    private String id = "";
    private Long time = Long.valueOf(0L);
    private String imageURL = "";

    public String getImageURL() {
        return this.imageURL;
    }

    public int getErrcode() {
        return this.errcode;
    }

    public String getID() {
        return this.id;
    }

    public Long getTime() {
        return this.time;
    }

    public int getRet() {
        return this.ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public WeiboBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    private void init(JSONObject json) throws QQConnectException {
        if(json != null) {
            try {
                this.ret = json.getInt("ret");
                if(0 != this.ret) {
                    this.msg = json.getString("msg");
                    this.errcode = json.getInt("errcode");
                } else {
                    this.msg = json.getString("msg");
                    this.errcode = 0;
                    JSONObject jsone = json.getJSONObject("data");
                    this.id = jsone.getString("id");
                    this.time = Long.valueOf(jsone.getLong("time"));
                    this.imageURL = json.getString("imgurl");
                    jsone = null;
                }
            } catch (JSONException var3) {
                throw new QQConnectException(var3.getMessage() + ":" + json.toString(), var3);
            }
        }

    }

    public String toString() {
        return "WeiboBean{ret=" + this.ret + ", msg=\'" + this.msg + '\'' + ", errcode=" + this.errcode + ", id=\'" + this.id + '\'' + ", time=" + this.time + ", imageURL=\'" + this.imageURL + '\'' + '}';
    }
}
