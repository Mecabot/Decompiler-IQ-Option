package com.iqoption.quiz.c;

import android.graphics.Color;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, aXE = {"AVATAR_COLORS", "", "getAVATAR_COLORS", "()[I", "getAvatarColorForUid", "", "uid", "", "quiz_release"})
/* compiled from: AvatarColors.kt */
public final class a {
    private static final int[] dop = new int[]{Color.rgb(255, 131, 52), Color.rgb(255, 118, 118), Color.rgb(202, 118, 255), Color.rgb(0, 117, 136), Color.rgb(67, 188, 104), Color.rgb(247, 147, 26), Color.rgb(107, 117, 142), Color.rgb(9, 196, 164), Color.rgb(18, 118, 168), Color.rgb(74, 108, 201), Color.rgb(201, 74, 143), Color.rgb(201, 74, 74), Color.rgb(166, 94, 47), Color.rgb(74, 193, 201), Color.rgb(128, 201, 74), Color.rgb(153, 74, 201), Color.rgb(224, 135, 37)};

    public static final int[] aCR() {
        return dop;
    }

    public static final int jD(String str) {
        h.e(str, "uid");
        return dop[Math.abs(str.hashCode()) % dop.length];
    }
}
