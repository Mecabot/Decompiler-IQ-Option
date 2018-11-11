package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Hide
public final class zzgk {
    private static final Object zzkuk = null;
    private static Long zzkul = new Long(0);
    private static Double zzkum = new Double(0.0d);
    private static zzgj zzkun = zzgj.zzbi(0);
    private static String zzkuo = new String("");
    private static Boolean zzkup = new Boolean(false);
    private static List<Object> zzkuq = new ArrayList(0);
    private static Map<Object, Object> zzkur = new HashMap();
    private static zzbt zzkus = zzam(zzkuo);

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzdj.e("getDouble received non-Number");
        return 0.0d;
    }

    private static String zzal(Object obj) {
        return obj == null ? zzkuo : obj.toString();
    }

    public static zzbt zzam(Object obj) {
        zzbt zzbt = new zzbt();
        if (obj instanceof zzbt) {
            return (zzbt) obj;
        }
        String str;
        boolean z = false;
        if (obj instanceof String) {
            zzbt.type = 1;
            str = (String) obj;
        } else {
            List arrayList;
            if (obj instanceof List) {
                zzbt.type = 2;
                List<Object> list = (List) obj;
                arrayList = new ArrayList(list.size());
                boolean z2 = false;
                for (Object zzam : list) {
                    zzbt zzam2 = zzam(zzam);
                    if (zzam2 == zzkus) {
                        return zzkus;
                    }
                    z2 = z2 || zzam2.zzyu;
                    arrayList.add(zzam2);
                }
                zzbt.zzyl = (zzbt[]) arrayList.toArray(new zzbt[0]);
                z = z2;
            } else if (obj instanceof Map) {
                zzbt.type = 3;
                Set<Entry> entrySet = ((Map) obj).entrySet();
                arrayList = new ArrayList(entrySet.size());
                List arrayList2 = new ArrayList(entrySet.size());
                boolean z3 = false;
                for (Entry entry : entrySet) {
                    zzbt zzam3 = zzam(entry.getKey());
                    zzbt zzam4 = zzam(entry.getValue());
                    if (zzam3 == zzkus || zzam4 == zzkus) {
                        return zzkus;
                    }
                    z3 = z3 || zzam3.zzyu || zzam4.zzyu;
                    arrayList.add(zzam3);
                    arrayList2.add(zzam4);
                }
                zzbt.zzym = (zzbt[]) arrayList.toArray(new zzbt[0]);
                zzbt.zzyn = (zzbt[]) arrayList2.toArray(new zzbt[0]);
                z = z3;
            } else if (zzan(obj)) {
                zzbt.type = 1;
                str = obj.toString();
            } else if (zzao(obj)) {
                zzbt.type = 6;
                zzbt.zzyq = zzap(obj);
            } else if (obj instanceof Boolean) {
                zzbt.type = 8;
                zzbt.zzyr = ((Boolean) obj).booleanValue();
            } else {
                String str2 = "Converting to Value from unknown object type: ";
                str = String.valueOf(obj == null ? "null" : obj.getClass().toString());
                zzdj.e(str.length() != 0 ? str2.concat(str) : new String(str2));
                return zzkus;
            }
            zzbt.zzyu = z;
            return zzbt;
        }
        zzbt.string = str;
        zzbt.zzyu = z;
        return zzbt;
    }

    private static boolean zzan(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzgj) && ((zzgj) obj).zzbid());
    }

    private static boolean zzao(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzgj) && ((zzgj) obj).zzbie());
    }

    private static long zzap(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdj.e("getInt64 received non-Number");
        return 0;
    }

    public static Object zzbif() {
        return null;
    }

    public static Long zzbig() {
        return zzkul;
    }

    public static Double zzbih() {
        return zzkum;
    }

    public static Boolean zzbii() {
        return zzkup;
    }

    public static zzgj zzbij() {
        return zzkun;
    }

    public static String zzbik() {
        return zzkuo;
    }

    public static zzbt zzbil() {
        return zzkus;
    }

    public static String zzd(zzbt zzbt) {
        return zzal(zzi(zzbt));
    }

    public static zzgj zze(zzbt zzbt) {
        Object zzi = zzi(zzbt);
        return zzi instanceof zzgj ? (zzgj) zzi : zzao(zzi) ? zzgj.zzbi(zzap(zzi)) : zzan(zzi) ? zzgj.zzb(Double.valueOf(getDouble(zzi))) : zzmj(zzal(zzi));
    }

    public static Long zzf(zzbt zzbt) {
        long zzap;
        Object zzi = zzi(zzbt);
        if (zzao(zzi)) {
            zzap = zzap(zzi);
        } else {
            zzgj zzmj = zzmj(zzal(zzi));
            if (zzmj == zzkun) {
                return zzkul;
            }
            zzap = zzmj.longValue();
        }
        return Long.valueOf(zzap);
    }

    public static Double zzg(zzbt zzbt) {
        double d;
        Object zzi = zzi(zzbt);
        if (zzan(zzi)) {
            d = getDouble(zzi);
        } else {
            zzgj zzmj = zzmj(zzal(zzi));
            if (zzmj == zzkun) {
                return zzkum;
            }
            d = zzmj.doubleValue();
        }
        return Double.valueOf(d);
    }

    public static Boolean zzh(zzbt zzbt) {
        Object zzi = zzi(zzbt);
        if (zzi instanceof Boolean) {
            return (Boolean) zzi;
        }
        String zzal = zzal(zzi);
        return "true".equalsIgnoreCase(zzal) ? Boolean.TRUE : "false".equalsIgnoreCase(zzal) ? Boolean.FALSE : zzkup;
    }

    public static Object zzi(zzbt zzbt) {
        if (zzbt == null) {
            return null;
        }
        String valueOf;
        int i = 0;
        zzbt[] zzbtArr;
        int length;
        Object zzi;
        switch (zzbt.type) {
            case 1:
                return zzbt.string;
            case 2:
                ArrayList arrayList = new ArrayList(zzbt.zzyl.length);
                zzbtArr = zzbt.zzyl;
                length = zzbtArr.length;
                while (i < length) {
                    zzi = zzi(zzbtArr[i]);
                    if (zzi == null) {
                        return null;
                    }
                    arrayList.add(zzi);
                    i++;
                }
                return arrayList;
            case 3:
                if (zzbt.zzym.length != zzbt.zzyn.length) {
                    String str = "Converting an invalid value to object: ";
                    valueOf = String.valueOf(zzbt.toString());
                    zzdj.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return null;
                }
                Map hashMap = new HashMap(zzbt.zzyn.length);
                while (i < zzbt.zzym.length) {
                    Object zzi2 = zzi(zzbt.zzym[i]);
                    zzi = zzi(zzbt.zzyn[i]);
                    if (zzi2 == null || zzi == null) {
                        return null;
                    }
                    hashMap.put(zzi2, zzi);
                    i++;
                }
                return hashMap;
            case 4:
                valueOf = "Trying to convert a macro reference to object";
                break;
            case 5:
                valueOf = "Trying to convert a function id to object";
                break;
            case 6:
                return Long.valueOf(zzbt.zzyq);
            case 7:
                StringBuilder stringBuilder = new StringBuilder();
                zzbtArr = zzbt.zzys;
                length = zzbtArr.length;
                while (i < length) {
                    String zzd = zzd(zzbtArr[i]);
                    if (zzd == zzkuo) {
                        return null;
                    }
                    stringBuilder.append(zzd);
                    i++;
                }
                return stringBuilder.toString();
            case 8:
                return Boolean.valueOf(zzbt.zzyr);
            default:
                int i2 = zzbt.type;
                StringBuilder stringBuilder2 = new StringBuilder(46);
                stringBuilder2.append("Failed to convert a value of type: ");
                stringBuilder2.append(i2);
                valueOf = stringBuilder2.toString();
                break;
        }
        zzdj.e(valueOf);
        return null;
    }

    public static zzbt zzmi(String str) {
        zzbt zzbt = new zzbt();
        zzbt.type = 5;
        zzbt.zzyp = str;
        return zzbt;
    }

    private static zzgj zzmj(String str) {
        try {
            return zzgj.zzmh(str);
        } catch (NumberFormatException unused) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 33);
            stringBuilder.append("Failed to convert '");
            stringBuilder.append(str);
            stringBuilder.append("' to a number.");
            zzdj.e(stringBuilder.toString());
            return zzkun;
        }
    }
}
