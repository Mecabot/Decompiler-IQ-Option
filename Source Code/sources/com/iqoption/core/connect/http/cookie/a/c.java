package com.iqoption.core.connect.http.cookie.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.a.d;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0002J\u0016\u0010\r\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\u000e\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/cache/SetCookieCache;", "Lcom/iqoption/core/connect/http/cookie/cache/CookieCache;", "()V", "cookies", "", "Lcom/iqoption/core/connect/http/cookie/cache/IdentifiableCookie;", "addAll", "", "", "Lokhttp3/Cookie;", "clear", "iterator", "", "removeAll", "updateCookies", "SetCookieCacheIterator", "core_release"})
/* compiled from: SetCookieCache.kt */
public final class c implements a {
    private final Set<b> aOc = new HashSet();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\t\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/cache/SetCookieCache$SetCookieCacheIterator;", "", "Lokhttp3/Cookie;", "cookies", "", "Lcom/iqoption/core/connect/http/cookie/cache/IdentifiableCookie;", "(Ljava/lang/Iterable;)V", "iterator", "hasNext", "", "next", "remove", "", "core_release"})
    /* compiled from: SetCookieCache.kt */
    private static final class a implements Iterator<Cookie>, d {
        private final Iterator<b> RC;

        public a(Iterable<b> iterable) {
            h.e(iterable, "cookies");
            this.RC = iterable.iterator();
        }

        public boolean hasNext() {
            return this.RC.hasNext();
        }

        /* renamed from: Sw */
        public Cookie next() {
            return ((b) this.RC.next()).Sv();
        }

        public void remove() {
            this.RC.remove();
        }
    }

    public void addAll(Collection<Cookie> collection) {
        h.e(collection, "cookies");
        B(b.aOb.A(collection));
    }

    private final void B(Collection<b> collection) {
        this.aOc.removeAll(collection);
        this.aOc.addAll(collection);
    }

    public void z(Collection<Cookie> collection) {
        h.e(collection, "cookies");
        if (this.aOc.removeAll(b.aOb.A(collection))) {
            com.iqoption.core.i.d("Cookie were removed");
        }
    }

    public void clear() {
        this.aOc.clear();
    }

    public Iterator<Cookie> iterator() {
        return new a(this.aOc);
    }
}
