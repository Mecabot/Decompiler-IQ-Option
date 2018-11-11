package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.google.android.gms.common.internal.Hide;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Hide
public final class zze implements zzo {
    private static final Uri zzduv;
    private final LogPrinter zzduw = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzduv = builder.build();
    }

    public final void zzb(zzg zzg) {
        List arrayList = new ArrayList(zzg.zzvy());
        Collections.sort(arrayList, new zzf(this));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            obj = ((zzi) obj).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj);
            }
        }
        this.zzduw.println(stringBuilder.toString());
    }

    public final Uri zzvu() {
        return zzduv;
    }
}
