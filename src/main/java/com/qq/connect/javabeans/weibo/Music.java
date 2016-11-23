/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class Music
implements Serializable {
    private static final long serialVersionUID = 1;
    private String author = "";
    private String url = "";
    private String title = "";

    public String getAuthor() {
        return this.author;
    }

    public String toString() {
        return "Music{author='" + this.author + '\'' + ", url='" + this.url + '\'' + ", title='" + this.title + '\'' + '}';
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public Music(String author, String url, String title) {
        this.author = author;
        this.url = url;
        this.title = title;
    }
}

