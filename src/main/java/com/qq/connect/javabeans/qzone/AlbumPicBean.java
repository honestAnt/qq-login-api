/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.qzone;

import com.qq.connect.QQConnectException;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;

public class AlbumPicBean
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private String albumID = "";
    private String lloc = "";
    private String sloc = "";
    private String largeURL = "";
    private String smallURL = "";
    private int height = 0;
    private int width = 0;
    private String msg = "";

    public AlbumPicBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    private void init(JSONObject json) throws QQConnectException {
        if (json != null) {
            try {
                this.ret = json.getInt("ret");
                if (0 != this.ret) {
                    this.msg = json.getString("msg");
                } else {
                    this.msg = "";
                    this.albumID = json.getString("albumid");
                    this.lloc = json.getString("lloc");
                    this.sloc = json.getString("sloc");
                    this.largeURL = json.getString("large_url");
                    this.smallURL = json.getString("small_url");
                    this.height = json.getInt("height");
                    this.width = json.getInt("width");
                }
            }
            catch (JSONException jsone) {
                throw new QQConnectException(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }
    }

    public int getRet() {
        return this.ret;
    }

    public String getAlbumID() {
        return this.albumID;
    }

    public String getLloc() {
        return this.lloc;
    }

    public String getSloc() {
        return this.sloc;
    }

    public String getLargeURL() {
        return this.largeURL;
    }

    public String getSmallURL() {
        return this.smallURL;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String getMsg() {
        return this.msg;
    }
}

