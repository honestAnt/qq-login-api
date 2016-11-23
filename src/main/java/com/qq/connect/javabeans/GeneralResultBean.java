/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans;

import com.qq.connect.QQConnectException;
import com.qq.connect.QQConnectResponse;
import com.qq.connect.utils.json.JSONException;
import com.qq.connect.utils.json.JSONObject;
import java.io.Serializable;

public class GeneralResultBean
extends QQConnectResponse
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private int ret = 0;
    private String msg = "";
    private int errcode = 0;

    public int getErrCode() {
        return this.errcode;
    }

    public String toString() {
        return "GeneralResultBean{ret=" + this.ret + ", msg='" + this.msg + '\'' + ", errcode=" + this.errcode + '}';
    }

    public int getRet() {
        return this.ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public GeneralResultBean(JSONObject json) throws QQConnectException {
        this.init(json);
    }

    private void init(JSONObject json) throws QQConnectException {
        if (json != null) {
            try {
                this.ret = json.getInt("ret");
                if (0 != this.ret) {
                    this.msg = json.getString("msg");
                    this.errcode = json.getInt("errcode");
                } else {
                    this.msg = "";
                }
            }
            catch (JSONException jsone) {
                throw new QQConnectException(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }
    }
}

