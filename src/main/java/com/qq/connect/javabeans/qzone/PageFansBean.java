/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.qzone;

import com.qq.connect.QQConnectException;
import com.qq.connect.QQConnectResponse;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;

public class PageFansBean
extends QQConnectResponse
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private String msg = "";
    private boolean fans = false;

    public boolean isFans() {
        return this.fans;
    }

    public int getRet() {
        return this.ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public PageFansBean(JSONObject json) throws QQConnectException {
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
                    this.fans = json.getInt("isfans") == 1;
                }
            }
            catch (JSONException jsone) {
                throw new QQConnectException(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.fans ? 0 : String.valueOf(this.fans).hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        PageFansBean other = (PageFansBean)obj;
        if (this.fans != other.fans) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "PageFansInfo [pageFans : " + this.fans + " , " + "]";
    }
}

