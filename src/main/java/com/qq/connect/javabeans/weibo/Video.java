/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class Video
implements Serializable {
    private static final long serialVersionUID = 1378516151120961177L;
    private String picUrl = "";
    private String player = "";
    private String realUrl = "";
    private String shortUrl = "";
    private String title = "";

    public Video(String picUrl, String player, String realUrl, String shortUrl, String title) {
        this.picUrl = picUrl;
        this.player = player;
        this.realUrl = realUrl;
        this.shortUrl = shortUrl;
        this.title = title;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getRealUrl() {
        return this.realUrl;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "Video{picUrl='" + this.picUrl + '\'' + ", player='" + this.player + '\'' + ", realUrl='" + this.realUrl + '\'' + ", shortUrl='" + this.shortUrl + '\'' + ", title='" + this.title + '\'' + '}';
    }
}

