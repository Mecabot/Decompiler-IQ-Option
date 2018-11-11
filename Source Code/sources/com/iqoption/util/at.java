package com.iqoption.util;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, aXE = {"unexpectedCase", "", "value", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MatchingUtils.kt */
public final class at {
    public static final Void bJ(Object obj) {
        h.e(obj, b.VALUE);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected case: ");
        stringBuilder.append(obj);
        throw new IllegalStateException(stringBuilder.toString());
    }
}
