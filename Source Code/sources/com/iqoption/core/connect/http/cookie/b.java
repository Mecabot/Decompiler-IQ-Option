package com.iqoption.core.connect.http.cookie;

import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/DecoratedCookieJar;", "Lcom/iqoption/core/connect/http/cookie/ClearableCookieJar;", "userJar", "Lcom/iqoption/core/connect/http/cookie/PersistentCookieJar;", "(Lcom/iqoption/core/connect/http/cookie/PersistentCookieJar;)V", "appCookies", "", "Lokhttp3/Cookie;", "getAppCookies", "()Ljava/util/List;", "clear", "", "clearAppCookies", "loadForRequest", "", "url", "Lokhttp3/HttpUrl;", "putAppCookie", "cookie", "removeAppCookie", "removeCookie", "saveFromResponse", "cookies", "core_release"})
/* compiled from: DecoratedCookieJar.kt */
public final class b implements a {
    private final List<Cookie> aNI = new ArrayList();
    private final c aNW;

    public b(c cVar) {
        h.e(cVar, "userJar");
        this.aNW = cVar;
    }

    public final List<Cookie> St() {
        return this.aNI;
    }

    public void clear() {
        this.aNW.clear();
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        h.e(httpUrl, PlusShare.KEY_CALL_TO_ACTION_URL);
        h.e(list, "cookies");
        this.aNW.saveFromResponse(httpUrl, list);
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        h.e(httpUrl, PlusShare.KEY_CALL_TO_ACTION_URL);
        return u.b((Collection) this.aNI, (Iterable) this.aNW.loadForRequest(httpUrl));
    }

    public final void a(Cookie cookie) {
        h.e(cookie, "cookie");
        int i = 0;
        for (Cookie name : this.aNI) {
            if (h.E(name.name(), cookie.name())) {
                break;
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            this.aNI.set(i, cookie);
        } else {
            this.aNI.add(cookie);
        }
    }

    public final void b(Cookie cookie) {
        h.e(cookie, "cookie");
        this.aNW.b(cookie);
        c(cookie);
    }

    public final void c(Cookie cookie) {
        h.e(cookie, "cookie");
        this.aNI.remove(cookie);
    }

    public final void Su() {
        this.aNI.clear();
    }
}
