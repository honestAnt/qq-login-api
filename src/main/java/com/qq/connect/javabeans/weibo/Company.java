/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class Company
implements Serializable {
    private static final long serialVersionUID = -8645673045632578193L;
    private String beginYear = "";
    private String companyName = "";
    private String departmentName = "";
    private String endYear = "";
    private String id = "";

    public Company(String beginYear, String companyName, String departmentName, String endYear, String id) {
        this.beginYear = beginYear;
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.endYear = endYear;
        this.id = id;
    }

    public String toString() {
        return "Company{beginYear='" + this.beginYear + '\'' + ", companyName='" + this.companyName + '\'' + ", departmentName='" + this.departmentName + '\'' + ", endYear='" + this.endYear + '\'' + ", id='" + this.id + '\'' + '}';
    }

    public String getBeginYear() {
        return this.beginYear;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getEndYear() {
        return this.endYear;
    }

    public String getID() {
        return this.id;
    }
}

