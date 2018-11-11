package com.iqoption.core.connect.http.cookie.a;

import java.util.Collection;
import kotlin.i;
import kotlin.jvm.internal.a.c;
import okhttp3.Cookie;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&¨\u0006\t"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/cache/CookieCache;", "", "Lokhttp3/Cookie;", "addAll", "", "cookies", "", "clear", "removeAll", "core_release"})
/* compiled from: CookieCache.kt */
public interface a extends Iterable<Cookie>, c {
    void addAll(Collection<Cookie> collection);

    void clear();

    void z(Collection<Cookie> collection);
}
