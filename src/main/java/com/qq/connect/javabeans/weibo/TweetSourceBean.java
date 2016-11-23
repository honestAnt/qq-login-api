/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import com.qq.connect.javabeans.Avatar;
import com.qq.connect.javabeans.weibo.Music;
import com.qq.connect.javabeans.weibo.TweetInfo;
import com.qq.connect.javabeans.weibo.Video;
import java.io.Serializable;

public class TweetSourceBean
implements Serializable {
    private static final long serialVersionUID = -356352137054008452L;
    private TweetInfo ti = null;
    private boolean vip = false;
    private boolean essence = false;
    private int mCount = 0;
    private String name = "";
    private String nick = "";
    private String openID = "";
    private int count = 0;
    private Avatar avatar = null;

    public TweetSourceBean(String cityCode, int count, String countryCode, String from, String fromUrl, String geo, Avatar avatar, String id, String image, boolean vip, boolean essence, float latitude, String location, float longitude, int mcount, Music music, String name, String nick, String openid, String origText, String provinceCode, boolean self, int status, String text, long timeStamp, int type, Video video) {
        this.ti = new TweetInfo(cityCode, countryCode, "", "", from, fromUrl, geo, id, image, latitude, location, longitude, music, origText, provinceCode, self, status, text, timeStamp, type, video);
        this.count = count;
        this.avatar = avatar;
        this.vip = vip;
        this.essence = essence;
        this.mCount = mcount;
        this.name = name;
        this.nick = nick;
        this.openID = openid;
    }

    public TweetSourceBean() {
    }

    public String getOpenID() {
        return this.openID;
    }

    public String getNick() {
        return this.nick;
    }

    public String getName() {
        return this.name;
    }

    public int getMCount() {
        return this.mCount;
    }

    public boolean isEssence() {
        return this.essence;
    }

    public boolean isVip() {
        return this.vip;
    }

    public int getCount() {
        return this.count;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public String getCityCode() {
        return this.ti.getCityCode();
    }

    public String getCountryCode() {
        return this.ti.getCountryCode();
    }

    public String getFrom() {
        return this.ti.getFrom();
    }

    public String getFromURL() {
        return this.ti.getFromURL();
    }

    public String getGeo() {
        return this.ti.getGeo();
    }

    public String getID() {
        return this.ti.getID();
    }

    public String getImage() {
        return this.ti.getImage();
    }

    public float getLatitude() {
        return this.ti.getLatitude();
    }

    public float getLongitude() {
        return this.ti.getLongitude();
    }

    public String getLocation() {
        return this.ti.getLocation();
    }

    public Music getMusic() {
        return this.ti.getMusic();
    }

    public String getOrigText() {
        return this.ti.getOrigText();
    }

    public String getProvinceCode() {
        return this.ti.getProvinceCode();
    }

    public boolean isSelf() {
        return this.ti.isSelf();
    }

    public int getStatus() {
        return this.ti.getStatus();
    }

    public String getText() {
        return this.ti.getText();
    }

    public long getTimestamp() {
        return this.ti.getTimestamp();
    }

    public int getType() {
        return this.ti.getType();
    }

    public Video getVideo() {
        return this.ti.getVideo();
    }

    public String toString() {
        return "TweetSourceBean{ti=" + this.ti + ", vip=" + this.vip + ", essence=" + this.essence + ", mCount=" + this.mCount + ", name='" + this.name + '\'' + ", nick='" + this.nick + '\'' + ", openID='" + this.openID + '\'' + ", count=" + this.count + ", avatar=" + this.avatar + '}';
    }
}

