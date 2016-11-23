/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans.weibo;

import java.io.Serializable;

public class Education
implements Serializable {
    private static final long serialVersionUID = -7543591029987598302L;
    private String id = "";
    private String year = "";
    private String schoolID = "";
    private String departmentID = "";
    private String level = "";

    public String getID() {
        return this.id;
    }

    public String toString() {
        return "Education{id='" + this.id + '\'' + ", year='" + this.year + '\'' + ", schoolID='" + this.schoolID + '\'' + ", departmentID='" + this.departmentID + '\'' + ", level='" + this.level + '\'' + '}';
    }

    public Education(String id, String year, String schoolID, String departmentID, String level) {
        this.id = id;
        this.year = year;
        this.schoolID = schoolID;
        this.departmentID = departmentID;
        this.level = level;
    }

    public String getYear() {
        return this.year;
    }

    public String getSchoolID() {
        return this.schoolID;
    }

    public String getDepartmentID() {
        return this.departmentID;
    }

    public String getLevel() {
        return this.level;
    }
}

