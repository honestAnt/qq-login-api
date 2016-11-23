/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import com.qq.connect.javabeans.Avatar;
import com.qq.connect.javabeans.weibo.SimpleTweetInfo;
import com.qq.connect.javabeans.weibo.Tag;
import java.io.Serializable;
import java.util.ArrayList;

public class SingleFanIdolBean
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private String cityCode = "";
    private String provinceCode = "";
    private String countryCode = "";
    private String location = "";
    private int fansNum = 0;
    private Avatar avatar = null;
    private int idolNum = 0;
    private boolean fans = false;
    private boolean idol = false;
    private boolean realName = false;
    private boolean vip = false;
    private String name = "";
    private String nick = "";
    private String openID = "";
    private String sex = "\u7537";
    private ArrayList<Tag> tags = new ArrayList();
    private SimpleTweetInfo sti = null;

    public String toString() {
        return "SingleFanIdolBean{cityCode='" + this.cityCode + '\'' + ", provinceCode='" + this.provinceCode + '\'' + ", countryCode='" + this.countryCode + '\'' + ", location='" + this.location + '\'' + ", fansNum=" + this.fansNum + ", avatar=" + this.avatar + ", idolNum=" + this.idolNum + ", fans=" + this.fans + ", idol=" + this.idol + ", realName=" + this.realName + ", vip=" + this.vip + ", name='" + this.name + '\'' + ", nick='" + this.nick + '\'' + ", openID='" + this.openID + '\'' + ", sex='" + this.sex + '\'' + ", tags=" + this.tags + ", sti=" + this.sti + '}';
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getLocation() {
        return this.location;
    }

    public int getFansNum() {
        return this.fansNum;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public int getIdolNum() {
        return this.idolNum;
    }

    public boolean isFans() {
        return this.fans;
    }

    public boolean isIdol() {
        return this.idol;
    }

    public boolean isRealName() {
        return this.realName;
    }

    public boolean isVip() {
        return this.vip;
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

    public String getSex() {
        return this.sex;
    }

    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public SimpleTweetInfo getSti() {
        return this.sti;
    }

    public SingleFanIdolBean(String cityCode, String provinceCode, String countryCode, String location, int fansNum, Avatar avatar, int idolNum, boolean fans, boolean idol, boolean realName, boolean vip, String name, String nick, String openID, String sex, ArrayList<Tag> tags, SimpleTweetInfo sti) {
        this.cityCode = cityCode;
        this.provinceCode = provinceCode;
        this.countryCode = countryCode;
        this.location = location;
        this.fansNum = fansNum;
        this.avatar = avatar;
        this.idolNum = idolNum;
        this.fans = fans;
        this.idol = idol;
        this.realName = realName;
        this.vip = vip;
        this.name = name;
        this.nick = nick;
        this.openID = openID;
        this.sex = sex;
        this.tags = tags;
        this.sti = sti;
    }
}

