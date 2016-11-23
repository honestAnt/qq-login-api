/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.javabeans;

import java.io.Serializable;

public class Birthday
implements Serializable {
    private static final long serialVersionUID = 4794043997574076151L;
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return this.year;
    }

    public Birthday(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return "Birthday{year=" + this.year + ", month=" + this.month + ", day=" + this.day + '}';
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }
}

