package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Map;

public final class b extends zzbgl {
    @Hide
    public static final Creator<b> CREATOR = new h();
    private a Zf;
    Bundle mBundle;
    private Map<String, String> zzdvf;

    public static class a {
        private final String Zg;
        private final String[] Zh;
        private final String Zi;
        private final String Zj;
        private final String[] Zk;
        private final String Zl;
        private final String Zm;
        private final String Zn;
        private final String Zo;
        private final Uri Zp;
        private final String mTag;
        private final String zzesj;

        private a(Bundle bundle) {
            this.zzesj = c.e(bundle, "gcm.n.title");
            this.Zg = c.f(bundle, "gcm.n.title");
            this.Zh = d(bundle, "gcm.n.title");
            this.Zi = c.e(bundle, "gcm.n.body");
            this.Zj = c.f(bundle, "gcm.n.body");
            this.Zk = d(bundle, "gcm.n.body");
            this.Zl = c.e(bundle, "gcm.n.icon");
            this.Zm = c.R(bundle);
            this.mTag = c.e(bundle, "gcm.n.tag");
            this.Zn = c.e(bundle, "gcm.n.color");
            this.Zo = c.e(bundle, "gcm.n.click_action");
            this.Zp = c.P(bundle);
        }

        private static String[] d(Bundle bundle, String str) {
            Object[] g = c.g(bundle, str);
            if (g == null) {
                return null;
            }
            String[] strArr = new String[g.length];
            for (int i = 0; i < g.length; i++) {
                strArr[i] = String.valueOf(g[i]);
            }
            return strArr;
        }

        @Nullable
        public String getBody() {
            return this.Zi;
        }

        @Nullable
        public String getTitle() {
            return this.zzesj;
        }
    }

    b(Bundle bundle) {
        this.mBundle = bundle;
    }

    public final Map<String, String> getData() {
        if (this.zzdvf == null) {
            this.zzdvf = new ArrayMap();
            for (String str : this.mBundle.keySet()) {
                Object obj = this.mBundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!(str.startsWith("google.") || str.startsWith("gcm.") || str.equals("from") || str.equals("message_type") || str.equals("collapse_key"))) {
                        this.zzdvf.put(str, str2);
                    }
                }
            }
        }
        return this.zzdvf;
    }

    @Nullable
    public final String wT() {
        return this.mBundle.getString("from");
    }

    @Nullable
    public final a wU() {
        if (this.Zf == null && c.O(this.mBundle)) {
            this.Zf = new a(this.mBundle);
        }
        return this.Zf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 2, this.mBundle, false);
        zzbgo.zzai(parcel, i);
    }
}
