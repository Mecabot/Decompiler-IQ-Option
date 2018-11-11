package com.iqoption.core.microservices.videoeducation.response;

import java.util.Locale;

/* compiled from: Locales */
final class d {
    public static boolean gL(String str) {
        return "all_ALL".equalsIgnoreCase(str);
    }

    public static boolean gM(String str) {
        return Locale.getDefault().toString().equalsIgnoreCase(str);
    }

    public static boolean gN(String str) {
        return gM(str) || gL(str);
    }
}
