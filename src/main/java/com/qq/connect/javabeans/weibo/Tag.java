/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class Tag
implements Serializable {
    private static final long serialVersionUID = 8844167881360046175L;
    private String id = "";
    private String name = "";

    public String toString() {
        return "Tag{id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Tag(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

