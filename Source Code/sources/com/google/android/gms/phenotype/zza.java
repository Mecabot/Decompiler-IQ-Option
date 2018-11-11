package com.google.android.gms.phenotype;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zza {
    private static String[] zzids = new String[]{"key", b.VALUE};
    private static final ConcurrentHashMap<Uri, zza> zzkft = new ConcurrentHashMap();
    private final Uri uri;
    private final ContentResolver zzkfu;
    private final ContentObserver zzkfv;
    private final Object zzkfw = new Object();
    private volatile Map<String, String> zzkfx;

    private zza(ContentResolver contentResolver, Uri uri) {
        this.zzkfu = contentResolver;
        this.uri = uri;
        this.zzkfv = new zzb(this, null);
    }

    public static zza zza(ContentResolver contentResolver, Uri uri) {
        zza zza = (zza) zzkft.get(uri);
        if (zza == null) {
            zza = new zza(contentResolver, uri);
            zza zza2 = (zza) zzkft.putIfAbsent(uri, zza);
            if (zza2 == null) {
                zza.zzkfu.registerContentObserver(zza.uri, false, zza.zzkfv);
                return zza;
            }
            zza = zza2;
        }
        return zza;
    }

    private final Map<String, String> zzbeg() {
        Map<String, String> hashMap = new HashMap();
        Cursor query = this.zzkfu.query(this.uri, zzids, null, null, null);
        if (query == null) {
            return hashMap;
        }
        while (query.moveToNext()) {
            try {
                hashMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return hashMap;
    }

    public final Map<String, String> zzbee() {
        Map<String, String> zzbeg = PhenotypeFlag.zzh("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzbeg() : this.zzkfx;
        if (zzbeg != null) {
            return zzbeg;
        }
        synchronized (this.zzkfw) {
            zzbeg = this.zzkfx;
            if (zzbeg == null) {
                zzbeg = zzbeg();
                this.zzkfx = zzbeg;
            }
        }
        return zzbeg;
    }

    public final void zzbef() {
        synchronized (this.zzkfw) {
            this.zzkfx = null;
        }
    }
}
