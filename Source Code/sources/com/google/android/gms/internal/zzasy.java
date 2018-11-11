package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Hide
public final class zzasy {
    private final Map<String, String> zzbwu;
    private final List<zzasf> zzedi;
    private final long zzedj;
    private final long zzedk;
    private final int zzedl;
    private final boolean zzedm;
    private final String zzedn;

    @Hide
    public zzasy(zzarh zzarh, Map<String, String> map, long j, boolean z) {
        this(zzarh, map, j, z, 0, 0, null);
    }

    @Hide
    public zzasy(zzarh zzarh, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzarh, map, j, z, j2, i, null);
    }

    @Hide
    public zzasy(zzarh zzarh, Map<String, String> map, long j, boolean z, long j2, int i, List<zzasf> list) {
        zzbq.checkNotNull(zzarh);
        zzbq.checkNotNull(map);
        this.zzedk = j;
        this.zzedm = z;
        this.zzedj = j2;
        this.zzedl = i;
        this.zzedi = list != null ? list : Collections.emptyList();
        this.zzedn = zzt(list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (zzn(entry.getKey())) {
                String zza = zza(zzarh, entry.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(zzarh, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!zzn(entry2.getKey())) {
                String zza2 = zza(zzarh, entry2.getKey());
                if (zza2 != null) {
                    hashMap.put(zza2, zzb(zzarh, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.zzedn)) {
            zzatt.zzb(hashMap, "_v", this.zzedn);
            if (this.zzedn.equals("ma4.0.0") || this.zzedn.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzbwu = Collections.unmodifiableMap(hashMap);
    }

    private static String zza(zzarh zzarh, Object obj) {
        if (obj == null) {
            return null;
        }
        obj = obj.toString();
        if (obj.startsWith("&")) {
            obj = obj.substring(1);
        }
        int length = obj.length();
        if (length > 256) {
            obj = obj.substring(0, 256);
            zzarh.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj);
        }
        return TextUtils.isEmpty(obj) ? null : obj;
    }

    private static String zzb(zzarh zzarh, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        zzarh.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    private final String zzk(String str, String str2) {
        zzbq.zzgv(str);
        zzbq.checkArgument(str.startsWith("&") ^ 1, "Short param name required");
        str = (String) this.zzbwu.get(str);
        return str != null ? str : str2;
    }

    private static boolean zzn(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private static String zzt(List<zzasf> list) {
        Object value;
        if (list != null) {
            for (zzasf zzasf : list) {
                if ("appendVersion".equals(zzasf.getId())) {
                    value = zzasf.getValue();
                    break;
                }
            }
        }
        value = null;
        return TextUtils.isEmpty(value) ? null : value;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ht=");
        stringBuilder.append(this.zzedk);
        if (this.zzedj != 0) {
            stringBuilder.append(", dbId=");
            stringBuilder.append(this.zzedj);
        }
        if (this.zzedl != 0) {
            stringBuilder.append(", appUID=");
            stringBuilder.append(this.zzedl);
        }
        List arrayList = new ArrayList(this.zzbwu.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            stringBuilder.append(", ");
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append((String) this.zzbwu.get(str));
        }
        return stringBuilder.toString();
    }

    public final int zzaal() {
        return this.zzedl;
    }

    public final long zzaam() {
        return this.zzedj;
    }

    public final long zzaan() {
        return this.zzedk;
    }

    public final List<zzasf> zzaao() {
        return this.zzedi;
    }

    public final boolean zzaap() {
        return this.zzedm;
    }

    public final long zzaaq() {
        return zzatt.zzeo(zzk("_s", "0"));
    }

    public final String zzaar() {
        return zzk("_m", "");
    }

    public final Map<String, String> zzjq() {
        return this.zzbwu;
    }
}
