package com.iqoption.kyc;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, aXE = {"Lcom/iqoption/kyc/CountryUtils;", "", "()V", "canChangeCountry", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CountryUtils.kt */
public final class a {
    public static final a cJj = new a();

    private a() {
    }

    public static final boolean aoz() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        if (!Cw.Dh()) {
            h.d(Cw, "account");
            if (Cw.Di() != 0) {
                return false;
            }
        }
        return true;
    }
}
