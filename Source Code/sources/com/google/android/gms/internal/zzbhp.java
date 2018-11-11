package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.util.zzr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class zzbhp {
    protected static <O, I> I zza(zzbhq<I, O> zzbhq, Object obj) {
        return zzbhq.zzgix != null ? zzbhq.convertBack(obj) : obj;
    }

    private static void zza(StringBuilder stringBuilder, zzbhq zzbhq, Object obj) {
        String zzbhp;
        if (zzbhq.zzgio == 11) {
            zzbhp = ((zzbhp) zzbhq.zzgiu.cast(obj)).toString();
        } else if (zzbhq.zzgio == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(zzq.zzha((String) obj));
            zzbhp = "\"";
        } else {
            stringBuilder.append(obj);
            return;
        }
        stringBuilder.append(zzbhp);
    }

    private static void zza(StringBuilder stringBuilder, zzbhq zzbhq, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(stringBuilder, zzbhq, obj);
            }
        }
        stringBuilder.append("]");
    }

    public String toString() {
        Map zzabz = zzabz();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : zzabz.keySet()) {
            String str2;
            zzbhq zzbhq = (zzbhq) zzabz.get(str2);
            if (zza(zzbhq)) {
                Object zza = zza(zzbhq, zzb(zzbhq));
                stringBuilder.append(stringBuilder.length() == 0 ? "{" : ",");
                stringBuilder.append("\"");
                stringBuilder.append(str2);
                stringBuilder.append("\":");
                if (zza == null) {
                    str2 = "null";
                } else {
                    switch (zzbhq.zzgiq) {
                        case 8:
                            stringBuilder.append("\"");
                            str2 = zzc.zzj((byte[]) zza);
                            break;
                        case 9:
                            stringBuilder.append("\"");
                            str2 = zzc.zzk((byte[]) zza);
                            break;
                        case 10:
                            zzr.zza(stringBuilder, (HashMap) zza);
                            continue;
                        default:
                            if (!zzbhq.zzgip) {
                                zza(stringBuilder, zzbhq, zza);
                                break;
                            }
                            zza(stringBuilder, zzbhq, (ArrayList) zza);
                            continue;
                    }
                    stringBuilder.append(str2);
                    str2 = "\"";
                }
                stringBuilder.append(str2);
            }
        }
        stringBuilder.append(stringBuilder.length() > 0 ? "}" : "{}");
        return stringBuilder.toString();
    }

    protected boolean zza(zzbhq zzbhq) {
        if (zzbhq.zzgiq != 11) {
            return zzgy(zzbhq.zzgis);
        }
        String str;
        if (zzbhq.zzgir) {
            str = zzbhq.zzgis;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        str = zzbhq.zzgis;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract Map<String, zzbhq<?, ?>> zzabz();

    protected Object zzb(zzbhq zzbhq) {
        String str = zzbhq.zzgis;
        if (zzbhq.zzgiu == null) {
            return zzgx(zzbhq.zzgis);
        }
        zzgx(zzbhq.zzgis);
        zzbq.zza(true, "Concrete field shouldn't be value object: %s", zzbhq.zzgis);
        boolean z = zzbhq.zzgir;
        try {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            str = str.substring(1);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 4);
            stringBuilder.append("get");
            stringBuilder.append(toUpperCase);
            stringBuilder.append(str);
            return getClass().getMethod(stringBuilder.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzgx(String str);

    protected abstract boolean zzgy(String str);
}
