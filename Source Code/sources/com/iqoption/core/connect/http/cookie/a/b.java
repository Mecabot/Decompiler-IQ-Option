package com.iqoption.core.connect.http.cookie.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/cache/IdentifiableCookie;", "", "cookie", "Lokhttp3/Cookie;", "(Lokhttp3/Cookie;)V", "getCookie", "()Lokhttp3/Cookie;", "equals", "", "other", "hashCode", "", "Companion", "core_release"})
/* compiled from: IdentifiableCookie.kt */
public final class b {
    public static final a aOb = new a();
    private final Cookie aOa;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/cache/IdentifiableCookie$Companion;", "", "()V", "decorateAll", "", "Lcom/iqoption/core/connect/http/cookie/cache/IdentifiableCookie;", "cookies", "", "Lokhttp3/Cookie;", "core_release"})
    /* compiled from: IdentifiableCookie.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final List<b> A(Collection<Cookie> collection) {
            h.e(collection, "cookies");
            ArrayList arrayList = new ArrayList(collection.size());
            for (Cookie bVar : collection) {
                arrayList.add(new b(bVar));
            }
            return arrayList;
        }
    }

    public b(Cookie cookie) {
        h.e(cookie, "cookie");
        this.aOa = cookie;
    }

    public final Cookie Sv() {
        return this.aOa;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (h.E(bVar.aOa.name(), this.aOa.name()) && h.E(bVar.aOa.domain(), this.aOa.domain()) && h.E(bVar.aOa.path(), this.aOa.path()) && bVar.aOa.secure() == this.aOa.secure() && bVar.aOa.hostOnly() == this.aOa.hostOnly()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((527 + this.aOa.name().hashCode()) * 31) + this.aOa.domain().hashCode()) * 31) + this.aOa.path().hashCode()) * 31) + (this.aOa.secure() ^ 1)) * 31) + (this.aOa.hostOnly() ^ 1);
    }
}
