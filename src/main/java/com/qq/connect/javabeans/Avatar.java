/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans;

import java.io.Serializable;

public class Avatar
implements Serializable {
    private static final long serialVersionUID = -8402565179459840811L;
    private String avatarURL30 = "";
    private String avatarURL50 = "";
    private String avatarURL100 = "";

    public Avatar(String avatarURL) {
        if (avatarURL.equals("")) {
            return;
        }
        this.avatarURL30 = avatarURL + "/30";
        this.avatarURL50 = avatarURL + "/50";
        this.avatarURL100 = avatarURL + "/100";
    }

    public Avatar(String avatarURL30, String avatarURL50, String avatarURL100) {
        this.avatarURL30 = avatarURL30;
        this.avatarURL50 = avatarURL50;
        this.avatarURL100 = avatarURL100;
    }

    public String getAvatarURL30() {
        return this.avatarURL30;
    }

    public String getAvatarURL50() {
        return this.avatarURL50;
    }

    public String getAvatarURL100() {
        return this.avatarURL100;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.avatarURL30 == null ? 0 : this.avatarURL30.hashCode());
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
        Avatar other = (Avatar)obj;
        if (this.getAvatarURL30() == null ? other.getAvatarURL30() != null : !this.getAvatarURL30().equals(other.getAvatarURL30())) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "AvatarInfo [figureurl30 : " + this.getAvatarURL30() + " , " + "figureurl50 : " + this.getAvatarURL50() + " , " + "figureurl100 : " + this.getAvatarURL100() + " , " + "]";
    }
}

