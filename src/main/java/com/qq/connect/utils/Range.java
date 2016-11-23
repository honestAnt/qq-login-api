/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils;

class Range {
    Range() {
    }

    public static int[] range(int n) {
        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            result[i] = i++;
        }
        return result;
    }

    public static int[] range(int start, int end) {
        int sz = end - start;
        int[] result = new int[sz];
        for (int i = 0; i < sz; ++i) {
            result[i] = start + i;
        }
        return result;
    }

    public static int[] range(int start, int end, int step) {
        int sz = (end - start) / step;
        int[] result = new int[sz];
        for (int i = 0; i < sz; ++i) {
            result[i] = start + i * step;
        }
        return result;
    }
}

