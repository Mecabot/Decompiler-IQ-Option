package com.iqoption.dto.entity.iqbus;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.util.p;
import com.iqoption.util.bb;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0004"}, aXE = {"PRIVATE_KEY", "", "decrypt", "source", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyInitUtils.kt */
public final class VerifyInitUtilsKt {
    private static final String PRIVATE_KEY = "\n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";

    public static final String decrypt(String str) {
        h.e(str, b.SOURCE);
        str = bb.aC(str, PRIVATE_KEY);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h.d(str, "decryptedConfig");
        return p.ae(str, "{\"token\"");
    }
}
