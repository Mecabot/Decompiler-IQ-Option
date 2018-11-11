package com.iqoption.quiz.model;

import com.iqoption.core.f;

/* compiled from: QuizConstant */
public interface d {
    public static final boolean DEBUG = f.Dp().DJ();
    public static final String dlu = (DEBUG ? "build29334.sandbox3.mobbtech.com:10081" : "game-api.iqoption.com");
    public static final String dlv;
    public static final String dlw = (DEBUG ? "https://wowzaprod107-i.akamaihd.net/hls/live/627769/ec482402/playlist.m3u8" : "https://wowzaprod107-i.akamaihd.net/hls/live/627769/ce966c27/playlist.m3u8");

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DEBUG ? "http" : "https");
        stringBuilder.append("://");
        stringBuilder.append(dlu);
        dlv = stringBuilder.toString();
    }
}
