package com.airbnb.lottie;

import java.util.Map;

/* compiled from: TextDelegate */
public class w {
    private final Map<String, String> ko;
    private boolean kp;

    private String getText(String str) {
        return str;
    }

    public final String ac(String str) {
        if (this.kp && this.ko.containsKey(str)) {
            return (String) this.ko.get(str);
        }
        String text = getText(str);
        if (this.kp) {
            this.ko.put(str, text);
        }
        return text;
    }
}
