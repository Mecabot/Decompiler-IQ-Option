package com.iqoption.core.connect.http.cookie.persistence;

import java.util.Collection;
import java.util.List;
import kotlin.i;
import okhttp3.Cookie;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH&¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/persistence/CookiePersistor;", "", "clear", "", "loadAll", "", "Lokhttp3/Cookie;", "removeAll", "cookies", "", "saveAll", "core_release"})
/* compiled from: CookiePersistor.kt */
public interface a {
    void C(Collection<Cookie> collection);

    List<Cookie> Sx();

    void clear();

    void z(Collection<Cookie> collection);
}
