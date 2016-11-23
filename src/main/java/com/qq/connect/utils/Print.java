/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils;

import java.io.PrintStream;

public class Print {
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print() {
        System.out.println();
    }

    public static void printnl(Object obj) {
        System.out.print(obj);
    }

    public static /* varargs */ PrintStream printf(String format, Object ... objects) {
        return System.out.printf(format, objects);
    }
}

