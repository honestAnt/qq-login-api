//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qq.connect.javabeans.qzone;

import com.qq.connect.QQConnectException;
import com.qq.connect.QQConnectResponse;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;

public class AlbumBean extends QQConnectResponse implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private String msg = "";
    private String albumid = "";
    private String classid = "";
    private Long createTime = Long.valueOf(0L);
    private String desc = "";
    private String name = "";
    private int priv = 0;
    private String coverurl = "";
    private int picnum = 0;

    public String getAlbumID() {
        return this.albumid;
    }

    public String getClassID() {
        return this.classid;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public int getPriv() {
        return this.priv;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getCoverurl() {
        return this.coverurl;
    }

    public int getPicnum() {
        return this.picnum;
    }

    public int getRet() {
        return this.ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public AlbumBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    public AlbumBean(String albumid, String classid, Long createtime, String desc, String name, int priv, String coverurl, int picnum) throws QQConnectException {
        this.ret = 0;
        this.msg = "";
        this.albumid = albumid;
        this.classid = classid;
        this.createTime = createtime;
        this.desc = desc;
        this.name = name;
        this.priv = priv;
        this.coverurl = coverurl;
        this.picnum = picnum;
    }

    public AlbumBean(int ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }

    private void init(JSONObject json) throws QQConnectException {
        if(json != null) {
            try {
                this.ret = json.getInt("ret");
                if(0 != this.ret) {
                    this.msg = json.getString("msg");
                } else {
                    this.msg = "";
                    this.albumid = json.getString("albumid");
                    this.classid = json.getString("classid");
                    this.createTime = Long.valueOf(json.getLong("createtime"));
                    this.desc = json.getString("desc");
                    this.name = json.getString("name");
                    this.priv = json.getInt("priv");
                    this.coverurl = json.getString("coverurl");
                    this.picnum = json.getInt("picnum");
                }
            } catch (JSONException var3) {
                throw new QQConnectException(var3.getMessage() + ":" + json.toString(), var3);
            }
        }

    }
}
