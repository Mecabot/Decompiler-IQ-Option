package com.facebook.internal;

/* compiled from: InternalSettings */
public class o {
    private static volatile String DW;

    public static String mc() {
        return DW;
    }

    public static boolean md() {
        return DW != null && DW.startsWith("Unity.");
    }
}
