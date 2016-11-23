/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import com.qq.connect.javabeans.weibo.Music;
import com.qq.connect.javabeans.weibo.Video;
import java.io.Serializable;

public class TweetInfo
implements Serializable {
    private static final long serialVersionUID = -356352137054008452L;
    private String cityCode = "";
    private String countryCode = "";
    private String emotionType = "";
    private String emotionUrl = "";
    private String from = "";
    private String fromURL = "";
    private String geo = "";
    private String id = "";
    private String image = "";
    private float latitude = 0.0f;
    private String location = "";
    private float longitude = 0.0f;
    private Music music = null;
    private String origText = "";
    private String provinceCode = "";
    private boolean self = false;
    private int status = 0;
    private String text = "";
    private long timestamp = 0;
    private int type = 0;
    private Video video = null;

    public String toString() {
        return "TweetInfo{cityCode='" + this.cityCode + '\'' + ", countryCode='" + this.countryCode + '\'' + ", emotionType='" + this.emotionType + '\'' + ", emotionUrl='" + this.emotionUrl + '\'' + ", from='" + this.from + '\'' + ", fromURL='" + this.fromURL + '\'' + ", geo='" + this.geo + '\'' + ", id='" + this.id + '\'' + ", image='" + this.image + '\'' + ", latitude=" + this.latitude + ", location='" + this.location + '\'' + ", longitude=" + this.longitude + ", music=" + this.music + ", origText='" + this.origText + '\'' + ", provinceCode='" + this.provinceCode + '\'' + ", self=" + this.self + ", status=" + this.status + ", text='" + this.text + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", video=" + this.video + '}';
    }

    public TweetInfo(String cityCode, String countryCode, String emotionType, String emotionUrl, String from, String fromURL, String geo, String id, String image, float latitude, String location, float longitude, Music music, String origText, String provinceCode, boolean self, int status, String text, long timestamp, int type, Video video) {
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.emotionType = emotionType;
        this.emotionUrl = emotionUrl;
        this.from = from;
        this.fromURL = fromURL;
        this.geo = geo;
        this.id = id;
        this.image = image;
        this.latitude = latitude;
        this.location = location;
        this.longitude = longitude;
        this.music = music;
        this.origText = origText;
        this.provinceCode = provinceCode;
        this.self = self;
        this.text = text;
        this.status = status;
        this.timestamp = timestamp;
        this.type = type;
        this.video = video;
    }

    public TweetInfo() {
        this.music = new Music("", "", "");
        this.video = new Video("", "", "", "", "");
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getEmotionType() {
        return this.emotionType;
    }

    public String getEmotionURL() {
        return this.emotionUrl;
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

    public String getID() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public String getLocation() {
        return this.location;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public Music getMusic() {
        return this.music;
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

    public String getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getType() {
        return this.type;
    }

    public int getStatus() {
        return this.status;
    }

    public Video getVideo() {
        return this.video;
    }
}

