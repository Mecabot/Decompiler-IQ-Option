package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class zzaa {
    private static final Lock zzeok = new ReentrantLock();
    private static zzaa zzeol;
    private final Lock zzeom = new ReentrantLock();
    private final SharedPreferences zzeon;

    private zzaa(Context context) {
        this.zzeon = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzaa zzbs(Context context) {
        zzbq.checkNotNull(context);
        zzeok.lock();
        try {
            if (zzeol == null) {
                zzeol = new zzaa(context.getApplicationContext());
            }
            zzaa zzaa = zzeol;
            return zzaa;
        } finally {
            zzeok.unlock();
        }
    }

    private final GoogleSignInAccount zzfe(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = zzfg(zzp("googleSignInAccount", str));
        if (str != null) {
            try {
                return GoogleSignInAccount.zzfa(str);
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    private final GoogleSignInOptions zzff(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = zzfg(zzp("googleSignInOptions", str));
        if (str != null) {
            try {
                return GoogleSignInOptions.zzfb(str);
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    private final void zzfh(String str) {
        this.zzeom.lock();
        try {
            this.zzeon.edit().remove(str).apply();
        } finally {
            this.zzeom.unlock();
        }
    }

    private static String zzp(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public final void clear() {
        this.zzeom.lock();
        try {
            this.zzeon.edit().clear().apply();
        } finally {
            this.zzeom.unlock();
        }
    }

    final void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzbq.checkNotNull(googleSignInAccount);
        zzbq.checkNotNull(googleSignInOptions);
        String zzace = googleSignInAccount.zzace();
        zzo(zzp("googleSignInAccount", zzace), googleSignInAccount.zzacg());
        zzo(zzp("googleSignInOptions", zzace), googleSignInOptions.zzack());
    }

    public final GoogleSignInAccount zzacx() {
        return zzfe(zzfg("defaultGoogleSignInAccount"));
    }

    public final GoogleSignInOptions zzacy() {
        return zzff(zzfg("defaultGoogleSignInAccount"));
    }

    public final void zzacz() {
        String zzfg = zzfg("defaultGoogleSignInAccount");
        zzfh("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zzfg)) {
            zzfh(zzp("googleSignInAccount", zzfg));
            zzfh(zzp("googleSignInOptions", zzfg));
        }
    }

    protected final String zzfg(String str) {
        this.zzeom.lock();
        try {
            str = this.zzeon.getString(str, null);
            return str;
        } finally {
            this.zzeom.unlock();
        }
    }

    protected final void zzo(String str, String str2) {
        this.zzeom.lock();
        try {
            this.zzeon.edit().putString(str, str2).apply();
        } finally {
            this.zzeom.unlock();
        }
    }
}
