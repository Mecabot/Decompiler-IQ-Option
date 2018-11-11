package com.iqoption.core.connect.http.cookie.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0016J\u0016\u0010\u0014\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/connect/http/cookie/persistence/SharedPrefsCookiePersistor;", "Lcom/iqoption/core/connect/http/cookie/persistence/CookiePersistor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "clear", "", "createCookieKey", "", "cookie", "Lokhttp3/Cookie;", "loadAll", "", "migrateCookies", "cookies", "", "removeAll", "saveAll", "core_release"})
/* compiled from: SharedPrefsCookiePersistor.kt */
public final class b implements a {
    private final SharedPreferences wv;

    private b(SharedPreferences sharedPreferences) {
        this.wv = sharedPreferences;
    }

    public b(Context context) {
        h.e(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("CookiePersistence", 0);
        h.d(sharedPreferences, "context.getSharedPrefere…e\", Context.MODE_PRIVATE)");
        this(sharedPreferences);
    }

    public List<Cookie> Sx() {
        ArrayList arrayList = new ArrayList();
        Map all = this.wv.getAll();
        h.d(all, "sharedPreferences.all");
        for (Entry value : all.entrySet()) {
            Object value2 = value.getValue();
            if (value2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            Cookie gg = new SerializableCookie().gg((String) value2);
            if (gg != null) {
                arrayList.add(gg);
            }
        }
        return arrayList;
    }

    public void C(Collection<Cookie> collection) {
        h.e(collection, "cookies");
        Editor edit = this.wv.edit();
        for (Cookie cookie : collection) {
            if (cookie.persistent()) {
                edit.putString(e(cookie), new SerializableCookie().d(cookie));
            }
        }
        edit.apply();
    }

    public void z(Collection<Cookie> collection) {
        h.e(collection, "cookies");
        Editor edit = this.wv.edit();
        for (Cookie e : collection) {
            edit.remove(e(e));
        }
        edit.apply();
    }

    private final String e(Cookie cookie) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cookie.secure() ? "https" : "http");
        stringBuilder.append("://");
        stringBuilder.append(cookie.domain());
        stringBuilder.append(cookie.path());
        stringBuilder.append("|");
        stringBuilder.append(cookie.name());
        return stringBuilder.toString();
    }

    public void clear() {
        this.wv.edit().clear().apply();
    }
}
