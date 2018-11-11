package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.x;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessTokenCache */
class b {
    private final SharedPreferences wv;
    private final a ww;
    private m wx;

    /* compiled from: AccessTokenCache */
    static class a {
        a() {
        }

        public m iC() {
            return new m(h.getApplicationContext());
        }
    }

    b(SharedPreferences sharedPreferences, a aVar) {
        this.wv = sharedPreferences;
        this.ww = aVar;
    }

    public b() {
        this(h.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new a());
    }

    public a iw() {
        if (ix()) {
            return iy();
        }
        if (!iz()) {
            return null;
        }
        a iA = iA();
        if (iA == null) {
            return iA;
        }
        d(iA);
        iB().clear();
        return iA;
    }

    public void d(a aVar) {
        x.a((Object) aVar, "accessToken");
        try {
            this.wv.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", aVar.iu().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public void clear() {
        this.wv.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (iz()) {
            iB().clear();
        }
    }

    private boolean ix() {
        return this.wv.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private a iy() {
        String string = this.wv.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string == null) {
            return null;
        }
        try {
            return a.c(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private boolean iz() {
        return h.iX();
    }

    private a iA() {
        Bundle jL = iB().jL();
        return (jL == null || !m.c(jL)) ? null : a.b(jL);
    }

    private m iB() {
        if (this.wx == null) {
            synchronized (this) {
                if (this.wx == null) {
                    this.wx = this.ww.iC();
                }
            }
        }
        return this.wx;
    }
}
