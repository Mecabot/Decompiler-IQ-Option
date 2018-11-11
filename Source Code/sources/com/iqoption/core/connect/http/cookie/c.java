package com.iqoption.core.connect.http.cookie;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.ext.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/PersistentCookieJar;", "Lcom/iqoption/core/connect/http/cookie/ClearableCookieJar;", "cache", "Lcom/iqoption/core/connect/http/cookie/cache/CookieCache;", "persistor", "Lcom/iqoption/core/connect/http/cookie/persistence/CookiePersistor;", "(Lcom/iqoption/core/connect/http/cookie/cache/CookieCache;Lcom/iqoption/core/connect/http/cookie/persistence/CookiePersistor;)V", "clear", "", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "removeCookie", "cookie", "removeCookies", "removedCookies", "saveFromResponse", "cookies", "Companion", "core_release"})
/* compiled from: PersistentCookieJar.kt */
public final class c implements a {
    private static final String TAG = "com.iqoption.core.connect.http.cookie.c";
    public static final a aNZ = new a();
    private final com.iqoption.core.connect.http.cookie.a.a aNX;
    private final com.iqoption.core.connect.http.cookie.persistence.a aNY;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/PersistentCookieJar$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "isCookieExpired", "", "cookie", "Lokhttp3/Cookie;", "core_release"})
    /* compiled from: PersistentCookieJar.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(com.iqoption.core.connect.http.cookie.a.a aVar, com.iqoption.core.connect.http.cookie.persistence.a aVar2) {
        h.e(aVar, "cache");
        h.e(aVar2, "persistor");
        this.aNX = aVar;
        this.aNY = aVar2;
        this.aNX.addAll(this.aNY.Sx());
    }

    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        h.e(httpUrl, PlusShare.KEY_CALL_TO_ACTION_URL);
        h.e(list, "cookies");
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("save cookie from response ");
        stringBuilder.append(list);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        this.aNX.addAll(list);
        this.aNY.C(list);
    }

    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList;
        h.e(httpUrl, PlusShare.KEY_CALL_TO_ACTION_URL);
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator it = this.aNX.iterator();
        while (it.hasNext()) {
            Cookie cookie = (Cookie) it.next();
            if (e.f(cookie)) {
                arrayList2.add(cookie);
                it.remove();
            } else if (cookie.matches(httpUrl)) {
                arrayList.add(cookie);
            }
        }
        this.aNY.z(arrayList2);
        return arrayList;
    }

    public final synchronized void b(Cookie cookie) {
        h.e(cookie, "cookie");
        ArrayList arrayList = new ArrayList();
        arrayList.add(cookie);
        af(arrayList);
    }

    public final synchronized void af(List<Cookie> list) {
        h.e(list, "removedCookies");
        this.aNX.z(list);
        this.aNY.z(list);
    }

    public synchronized void clear() {
        this.aNX.clear();
        this.aNY.clear();
    }
}
