package com.google.android.gms.internal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

public final class zzap {
    static List<zzl> zza(Map<String, String> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    static Map<String, String> zza(List<zzl> list) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (zzl zzl : list) {
            treeMap.put(zzl.getName(), zzl.getValue());
        }
        return treeMap;
    }

    public static zzc zzb(zzp zzp) {
        long j;
        Object obj;
        long j2;
        Object obj2;
        zzp zzp2 = zzp;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzp2.zzab;
        String str = (String) map.get("Date");
        long zzf = str != null ? zzf(str) : 0;
        str = (String) map.get("Cache-Control");
        int i = 0;
        if (str != null) {
            String[] split = str.split(",");
            j = 0;
            obj = null;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                        i++;
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    obj = 1;
                }
            }
            obj2 = 1;
        } else {
            j = 0;
            obj = null;
            j2 = 0;
            obj2 = null;
        }
        str = (String) map.get("Expires");
        long zzf2 = str != null ? zzf(str) : 0;
        str = (String) map.get("Last-Modified");
        long zzf3 = str != null ? zzf(str) : 0;
        str = (String) map.get("ETag");
        if (obj2 != null) {
            long j3 = currentTimeMillis + (j * 1000);
            currentTimeMillis = obj != null ? j3 : j3 + (j2 * 1000);
            zzf2 = j3;
        } else if (zzf <= 0 || zzf2 < zzf) {
            currentTimeMillis = 0;
            zzf2 = currentTimeMillis;
        } else {
            zzf2 = currentTimeMillis + (zzf2 - zzf);
            currentTimeMillis = zzf2;
        }
        zzc zzc = new zzc();
        zzc.data = zzp2.data;
        zzc.zza = str;
        zzc.zze = zzf2;
        zzc.zzd = currentTimeMillis;
        zzc.zzb = zzf;
        zzc.zzc = zzf3;
        zzc.zzf = map;
        zzc.zzg = zzp2.allHeaders;
        return zzc;
    }

    static String zzb(long j) {
        return zzo().format(new Date(j));
    }

    public static String zzb(Map<String, String> map) {
        String str = "ISO-8859-1";
        String str2 = (String) map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    private static long zzf(String str) {
        try {
            return zzo().parse(str).getTime();
        } catch (Throwable e) {
            zzaf.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    private static SimpleDateFormat zzo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
