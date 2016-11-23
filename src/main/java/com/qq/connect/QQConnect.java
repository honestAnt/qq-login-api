/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect;

import com.qq.connect.utils.http.HttpClient;
import java.io.Serializable;

public class QQConnect
implements Serializable {
    private static final long serialVersionUID = 2403532632395197292L;
    protected HttpClient client = new HttpClient();

    protected QQConnect() {
    }

    protected QQConnect(String token, String openID) {
        this.client.setToken(token);
        this.client.setOpenID(openID);
    }

    protected void setToken(String token) {
        this.client.setToken(token);
    }

    protected void setOpenID(String openID) {
        this.client.setOpenID(openID);
    }
}

