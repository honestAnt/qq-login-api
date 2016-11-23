/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class SimpleTweetInfo
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private String from = "";
    private String id = "";
    private String text = "";
    private long timestamp = 0;

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public SimpleTweetInfo(String from, String id, String text, long timestamp) {
        this.from = from;
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
    }

    public String toString() {
        return "SimpleTweetInfo{from='" + this.from + '\'' + ", id='" + this.id + '\'' + ", text='" + this.text + '\'' + ", timestamp=" + this.timestamp + '}';
    }
}

