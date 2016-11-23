/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class PrivateFlag
implements Serializable {
    private static final long serialVersionUID = 1;
    private int privateFlag = 0;

    public PrivateFlag(int i) {
        this.privateFlag = i;
    }

    public int getPrivateFlag() {
        return this.privateFlag;
    }

    public String getPrivateDesc() {
        switch (this.privateFlag) {
            case 0: {
                return "\u4ec5\u6709\u5076\u50cf";
            }
            case 1: {
                return "\u540d\u4eba,\u542c\u4f17";
            }
            case 2: {
                return "\u6240\u6709\u4eba";
            }
        }
        return "";
    }

    public String toString() {
        return "PrivateFlag{privateFlag=" + this.privateFlag + '}';
    }
}

