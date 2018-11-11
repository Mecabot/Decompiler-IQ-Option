package com.iqoption.gdpr;

import android.content.Context;
import com.iqoption.app.af;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, aXE = {"isGdprSupportEnabled", "", "context", "Landroid/content/Context;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: GdprUtils.kt */
public final class a {
    public static final boolean bt(Context context) {
        h.e(context, "context");
        if (com.iqoption.app.managers.feature.a.eW("gdpr-support")) {
            af DX = af.DX();
            h.d(DX, "Preferences.instance()");
            if (DX.Dh() && !com.iqoption.app.a.aL(context).CZ()) {
                return true;
            }
        }
        return false;
    }
}
