/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import com.qq.connect.javabeans.Avatar;
import com.qq.connect.javabeans.weibo.Music;
import com.qq.connect.javabeans.weibo.TweetSourceBean;
import com.qq.connect.javabeans.weibo.Video;
import java.io.Serializable;

public class SingleRepostInfo
implements Serializable {
    private static final long serialVersionUID = 8844167881360046175L;
    private String cityCode = "";
    private int count = 0;
    private String countryCode = "";
    private String emotionType = "";
    private String emotionURL = "";
    private String from = "";
    private String fromURL = "";
    private String geo = "";
    private Avatar avatar = null;
    private String id = "";
    private String image = "";
    private boolean realName = false;
    private boolean vip = false;
    private boolean essence = false;
    private float latitude = 0.0f;
    private float longitude = 0.0f;
    private String location = "";
    private int mcount = 0;
    private Music music = null;
    private String name = "";
    private String nick = "";
    private String openID = "";
    private String origText = "";
    private String provinceCode = "";
    private boolean self = false;
    private TweetSourceBean tsb = null;
    private int status = 0;
    private String text = "";
    private long timeStamp = 0;
    private int type = 0;
    private Video video = null;

    public String getCityCode() {
        return this.cityCode;
    }

    public int getCount() {
        return this.count;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getEmotionType() {
        return this.emotionType;
    }

    public String getEmotionURL() {
        return this.emotionURL;
    }

    public String getFrom() {
        return this.from;
    }

    public String getFromURL() {
        return this.fromURL;
    }

    public String getGeo() {
        return this.geo;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public String getID() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public boolean isRealName() {
        return this.realName;
    }

    public boolean isVip() {
        return this.vip;
    }

    public boolean isEssence() {
        return this.essence;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public String getLocation() {
        return this.location;
    }

    public int getMCount() {
        return this.mcount;
    }

    public Music getMusic() {
        return this.music;
    }

    public String getName() {
        return this.name;
    }

    public String getNick() {
        return this.nick;
    }

    public String getOpenID() {
        return this.openID;
    }

    public String getOrigText() {
        return this.origText;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public boolean isSelf() {
        return this.self;
    }

    public TweetSourceBean getTsb() {
        return this.tsb;
    }

    public int getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }

    public int getType() {
        return this.type;
    }

    public Video getVideo() {
        return this.video;
    }

    public SingleRepostInfo(String cityCode, int count, String countryCode, String emotionType, String emotionURL, String from, String fromURL, String geo, Avatar avatar, String id, String image, boolean realName, boolean vip, boolean essence, float latitude, float longitude, String location, int mcount, Music music, String name, String nick, String openID, String origText, String provinceCode, boolean self, TweetSourceBean tsb, int status, String text, String timeStamp, int type, Video video) {
        this.cityCode = cityCode;
        this.count = count;
        this.countryCode = countryCode;
        this.emotionType = emotionType;
        this.emotionURL = emotionURL;
        this.from = from;
        this.fromURL = fromURL;
        this.geo = geo;
        this.avatar = avatar;
        this.id = id;
        this.image = image;
        this.realName = realName;
        this.vip = vip;
        this.essence = essence;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.mcount = mcount;
        this.music = music;
        this.name = name;
        this.nick = nick;
        this.openID = openID;
        this.origText = origText;
        this.provinceCode = provinceCode;
        this.self = self;
        this.tsb = tsb;
        this.status = status;
        this.text = text;
        this.timeStamp = Long.valueOf(timeStamp);
        this.type = type;
        this.video = video;
    }

    public String toString() {
        return "SingleRepostInfo{cityCode='" + this.cityCode + '\'' + ", count=" + this.count + ", countryCode='" + this.countryCode + '\'' + ", emotionType='" + this.emotionType + '\'' + ", emotionURL='" + this.emotionURL + '\'' + ", from='" + this.from + '\'' + ", fromURL='" + this.fromURL + '\'' + ", geo='" + this.geo + '\'' + ", avatar=" + this.avatar + ", id='" + this.id + '\'' + ", image='" + this.image + '\'' + ", realName=" + this.realName + ", vip=" + this.vip + ", essence=" + this.essence + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", location='" + this.location + '\'' + ", mcount=" + this.mcount + ", music=" + this.music + ", name='" + this.name + '\'' + ", nick='" + this.nick + '\'' + ", openID='" + this.openID + '\'' + ", origText='" + this.origText + '\'' + ", provinceCode='" + this.provinceCode + '\'' + ", self=" + this.self + ", tsb=" + this.tsb + ", status=" + this.status + ", text='" + this.text + '\'' + ", timeStamp=" + this.timeStamp + ", type=" + this.type + ", video=" + this.video + '}';
    }
}

