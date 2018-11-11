package com.iqoption.core.ext;

import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, aXE = {"isExpired", "", "Lokhttp3/Cookie;", "isNotExpired", "core_release"})
/* compiled from: HttpExtensions.kt */
public final class e {
    public static final boolean f(Cookie cookie) {
        h.e(cookie, "$receiver");
        return cookie.expiresAt() != 0 && cookie.expiresAt() < System.currentTimeMillis();
    }
}
