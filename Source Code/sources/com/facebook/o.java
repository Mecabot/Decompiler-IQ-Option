package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.x;
import com.google.android.gms.common.Scopes;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProfileCache */
final class o {
    private final SharedPreferences wv = h.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    o() {
    }

    n jO() {
        String string = this.wv.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new n(new JSONObject(string));
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    void b(n nVar) {
        x.a((Object) nVar, Scopes.PROFILE);
        JSONObject iu = nVar.iu();
        if (iu != null) {
            this.wv.edit().putString("com.facebook.ProfileManager.CachedProfile", iu.toString()).apply();
        }
    }

    void clear() {
        this.wv.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
