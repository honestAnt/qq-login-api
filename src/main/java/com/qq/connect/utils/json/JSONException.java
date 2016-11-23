/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils.json;

public class JSONException
extends Exception {
    private Throwable cause;

    public JSONException(String message) {
        super(message);
    }

    public JSONException(Throwable t) {
        super(t.getMessage());
        this.cause = t;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }
}

