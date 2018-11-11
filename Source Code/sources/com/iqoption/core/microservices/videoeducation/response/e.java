package com.iqoption.core.microservices.videoeducation.response;

/* compiled from: Platforms */
public class e {
    public static boolean gL(String str) {
        return "all".equalsIgnoreCase(str);
    }

    public static boolean gO(String str) {
        return "mobile".equalsIgnoreCase(str);
    }

    public static boolean gP(String str) {
        return gO(str) || gL(str);
    }
}
