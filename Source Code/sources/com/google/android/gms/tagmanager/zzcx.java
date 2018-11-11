package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.internal.Hide;
import java.util.HashMap;
import java.util.Map;

@Hide
public class zzcx {
    private static String zzkqd;
    static Map<String, String> zzkqe = new HashMap();

    static void zzae(Context context, String str) {
        zzfu.zze(context, "gtm_install_referrer", "referrer", str);
        zzag(context, str);
    }

    public static String zzaf(Context context, String str) {
        if (zzkqd == null) {
            synchronized (zzcx.class) {
                if (zzkqd == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    zzkqd = sharedPreferences != null ? sharedPreferences.getString("referrer", "") : "";
                }
            }
        }
        return zzaw(zzkqd, str);
    }

    public static void zzag(Context context, String str) {
        String zzaw = zzaw(str, "conv");
        if (zzaw != null && zzaw.length() > 0) {
            zzkqe.put(zzaw, str);
            zzfu.zze(context, "gtm_click_referrers", zzaw, str);
        }
    }

    public static String zzaw(String str, String str2) {
        if (str2 == null) {
            return str.length() > 0 ? str : null;
        } else {
            String str3 = "http://hostname/?";
            str = String.valueOf(str);
            return Uri.parse(str.length() != 0 ? str3.concat(str) : new String(str3)).getQueryParameter(str2);
        }
    }

    public static void zzlx(String str) {
        synchronized (zzcx.class) {
            zzkqd = str;
        }
    }
}
