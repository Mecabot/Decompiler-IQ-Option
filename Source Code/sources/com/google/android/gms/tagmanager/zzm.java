package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzm extends zzgi {
    private static final String ID = zzbh.ARBITRARY_PIXEL.toString();
    private static final String URL = zzbi.URL.toString();
    private static final String zzkmw = zzbi.ADDITIONAL_PARAMS.toString();
    private static final String zzkmx = zzbi.UNREPEATABLE.toString();
    private static String zzkmy;
    private static final Set<String> zzkmz = new HashSet();
    private final Context mContext;
    private final zza zzkna;

    public interface zza {
        zzby zzbfi();
    }

    static {
        String str = ID;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 17);
        stringBuilder.append("gtm_");
        stringBuilder.append(str);
        stringBuilder.append("_unrepeatable");
        zzkmy = stringBuilder.toString();
    }

    public zzm(Context context) {
        this(context, new zzn(context));
    }

    private zzm(Context context, zza zza) {
        super(ID, URL);
        this.zzkna = zza;
        this.mContext = context;
    }

    private final synchronized boolean zzlg(String str) {
        if (zzkmz.contains(str)) {
            return true;
        }
        if (!this.mContext.getSharedPreferences(zzkmy, 0).contains(str)) {
            return false;
        }
        zzkmz.add(str);
        return true;
    }

    public final void zzz(Map<String, zzbt> map) {
        String zzd = map.get(zzkmx) != null ? zzgk.zzd((zzbt) map.get(zzkmx)) : null;
        if (zzd == null || !zzlg(zzd)) {
            String str;
            Builder buildUpon = Uri.parse(zzgk.zzd((zzbt) map.get(URL))).buildUpon();
            zzbt zzbt = (zzbt) map.get(zzkmw);
            if (zzbt != null) {
                Object zzi = zzgk.zzi(zzbt);
                if (zzi instanceof List) {
                    for (Object next : (List) zzi) {
                        if (next instanceof Map) {
                            for (Entry entry : ((Map) next).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            str = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                            zzd = String.valueOf(buildUpon.build().toString());
                            zzdj.e(zzd.length() != 0 ? str.concat(zzd) : new String(str));
                            return;
                        }
                    }
                }
                str = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                zzd = String.valueOf(buildUpon.build().toString());
                zzdj.e(zzd.length() != 0 ? str.concat(zzd) : new String(str));
                return;
            }
            str = buildUpon.build().toString();
            this.zzkna.zzbfi().zzlr(str);
            String str2 = "ArbitraryPixel: url = ";
            str = String.valueOf(str);
            zzdj.v(str.length() != 0 ? str2.concat(str) : new String(str2));
            if (zzd != null) {
                synchronized (zzm.class) {
                    zzkmz.add(zzd);
                    zzfu.zze(this.mContext, zzkmy, zzd, "true");
                }
            }
        }
    }
}
