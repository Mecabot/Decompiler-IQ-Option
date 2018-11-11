package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

public final class o {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public o(Context context) {
        Resources resources = context.getResources();
        Locale locale = (resources == null || resources.getConfiguration() == null || resources.getConfiguration().locale == null) ? Locale.getDefault() : resources.getConfiguration().locale;
        Map a = y.a(locale);
        this.a = (String) a.get("error_initializing_player");
        this.b = (String) a.get("get_youtube_app_title");
        this.c = (String) a.get("get_youtube_app_text");
        this.d = (String) a.get("get_youtube_app_action");
        this.e = (String) a.get("enable_youtube_app_title");
        this.f = (String) a.get("enable_youtube_app_text");
        this.g = (String) a.get("enable_youtube_app_action");
        this.h = (String) a.get("update_youtube_app_title");
        this.i = (String) a.get("update_youtube_app_text");
        this.j = (String) a.get("update_youtube_app_action");
    }
}
