package com.microblink.recognition;

import android.support.annotation.Keep;

/* compiled from: line */
public enum Right {
    TIMESTAMP_USED(0, "licence key is time restricted"),
    PING_USED(1, "licence key requires regular network ping"),
    ALLOW_CUSTOM_UI(2, "allow custom camera overlay when using library"),
    ALLOW_MULTIPLE_APPS(3, "allow using license key in multiple applications"),
    ALLOW_REMOVE_OVERLAY(4, "allow removing overlay from RecognizerView");
    
    int IIIIlIllIl;
    private String lllllIlIll;

    private Right(int i, String str) {
        this.IIIIlIllIl = i;
        this.lllllIlIll = str;
    }

    public final String toString() {
        return this.lllllIlIll;
    }

    @Keep
    public static Right fromIntValue(int i) {
        switch (i) {
            case 0:
                return TIMESTAMP_USED;
            case 1:
                return PING_USED;
            case 2:
                return ALLOW_CUSTOM_UI;
            case 3:
                return ALLOW_MULTIPLE_APPS;
            case 4:
                return ALLOW_REMOVE_OVERLAY;
            default:
                return null;
        }
    }
}
