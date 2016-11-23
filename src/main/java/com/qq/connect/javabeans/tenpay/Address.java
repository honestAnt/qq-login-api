/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.tenpay;

import java.io.Serializable;

public class Address
implements Serializable {
    private static final long serialVersionUID = 4742904673643859727L;
    private String regionID = "0";
    private int usedCount = 0;
    private String name = "";
    private String tel = "";
    private String zipcode = "";
    private String mobile = "";
    private String addrStreet = "";
    private String lastUseTime = "";
    private String modTime = "";
    private String createTime = "";
    private String index = "";

    public Address(String regionID, int usedCount, String name, String tel, String zipcode, String mobile, String addrStreet, String lastUseTime, String modTime, String createTime, String index) {
        this.regionID = regionID;
        this.usedCount = usedCount;
        this.name = name;
        this.tel = tel;
        this.zipcode = zipcode;
        this.mobile = mobile;
        this.addrStreet = addrStreet;
        this.lastUseTime = lastUseTime;
        this.modTime = modTime;
        this.createTime = createTime;
        this.index = index;
    }

    public Address() {
    }

    public String getRegionID() {
        return this.regionID;
    }

    public int getUsedCount() {
        return this.usedCount;
    }

    public String getName() {
        return this.name;
    }

    public String getTel() {
        return this.tel;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getAddrStreet() {
        return this.addrStreet;
    }

    public String getLastUseTime() {
        return this.lastUseTime;
    }

    public String getModTime() {
        return this.modTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getIndex() {
        return this.index;
    }
}

