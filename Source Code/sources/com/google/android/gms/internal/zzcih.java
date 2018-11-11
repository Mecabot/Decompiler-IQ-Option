package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzcih extends zzcli {
    zzcih(zzckj zzckj) {
        super(zzckj);
    }

    private final Boolean zza(double d, zzcnu zzcnu) {
        try {
            return zza(new BigDecimal(d), zzcnu, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(long j, zzcnu zzcnu) {
        try {
            return zza(new BigDecimal(j), zzcnu, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(zzcns zzcns, String str, zzcoc[] zzcocArr, long j) {
        if (zzcns.zzjtb != null) {
            Boolean zza = zza(j, zzcns.zzjtb);
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (zzcnt zzcnt : zzcns.zzjsz) {
            if (TextUtils.isEmpty(zzcnt.zzjtg)) {
                zzayp().zzbaw().zzj("null or empty param name in filter. event", zzayk().zzjp(str));
                return null;
            }
            hashSet.add(zzcnt.zzjtg);
        }
        Map arrayMap = new ArrayMap();
        for (zzcoc zzcoc : zzcocArr) {
            if (hashSet.contains(zzcoc.name)) {
                Object obj;
                Object obj2;
                if (zzcoc.zzjum != null) {
                    obj = zzcoc.name;
                    obj2 = zzcoc.zzjum;
                } else if (zzcoc.zzjsl != null) {
                    obj = zzcoc.name;
                    obj2 = zzcoc.zzjsl;
                } else if (zzcoc.zzgim != null) {
                    obj = zzcoc.name;
                    obj2 = zzcoc.zzgim;
                } else {
                    zzayp().zzbaw().zze("Unknown value for param. event, param", zzayk().zzjp(str), zzayk().zzjq(zzcoc.name));
                    return null;
                }
                arrayMap.put(obj, obj2);
            }
        }
        for (zzcnt zzcnt2 : zzcns.zzjsz) {
            boolean equals = Boolean.TRUE.equals(zzcnt2.zzjtf);
            String str2 = zzcnt2.zzjtg;
            if (TextUtils.isEmpty(str2)) {
                zzayp().zzbaw().zzj("Event has empty param name. event", zzayk().zzjp(str));
                return null;
            }
            Object obj3 = arrayMap.get(str2);
            Boolean zza2;
            if (obj3 instanceof Long) {
                if (zzcnt2.zzjte == null) {
                    zzayp().zzbaw().zze("No number filter for long param. event, param", zzayk().zzjp(str), zzayk().zzjq(str2));
                    return null;
                }
                zza2 = zza(((Long) obj3).longValue(), zzcnt2.zzjte);
                if (zza2 == null) {
                    return null;
                }
                if (((1 ^ zza2.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 instanceof Double) {
                if (zzcnt2.zzjte == null) {
                    zzayp().zzbaw().zze("No number filter for double param. event, param", zzayk().zzjp(str), zzayk().zzjq(str2));
                    return null;
                }
                zza2 = zza(((Double) obj3).doubleValue(), zzcnt2.zzjte);
                if (zza2 == null) {
                    return null;
                }
                if (((1 ^ zza2.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 instanceof String) {
                if (zzcnt2.zzjtd != null) {
                    zza2 = zza((String) obj3, zzcnt2.zzjtd);
                } else if (zzcnt2.zzjte != null) {
                    String str3 = (String) obj3;
                    if (zzcno.zzkr(str3)) {
                        zza2 = zza(str3, zzcnt2.zzjte);
                    } else {
                        zzayp().zzbaw().zze("Invalid param value for number filter. event, param", zzayk().zzjp(str), zzayk().zzjq(str2));
                        return null;
                    }
                } else {
                    zzayp().zzbaw().zze("No filter for String param. event, param", zzayk().zzjp(str), zzayk().zzjq(str2));
                    return null;
                }
                if (zza2 == null) {
                    return null;
                }
                if (((1 ^ zza2.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 == null) {
                zzayp().zzbba().zze("Missing param for filter. event, param", zzayk().zzjp(str), zzayk().zzjq(str2));
                return Boolean.valueOf(false);
            } else {
                zzayp().zzbaw().zze("Unknown param type. event, param", zzayk().zzjp(str), zzayk().zzjq(str2));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private static Boolean zza(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        CharSequence str4;
        boolean startsWith;
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!(z || i == 1)) {
            str4 = str4.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str4).matches());
                } catch (PatternSyntaxException unused) {
                    zzayp().zzbaw().zzj("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                startsWith = str4.startsWith(str2);
                break;
            case 3:
                startsWith = str4.endsWith(str2);
                break;
            case 4:
                startsWith = str4.contains(str2);
                break;
            case 5:
                startsWith = str4.equals(str2);
                break;
            case 6:
                startsWith = list.contains(str4);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    private final Boolean zza(String str, zzcnu zzcnu) {
        if (!zzcno.zzkr(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzcnu, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzcnw zzcnw) {
        zzbq.checkNotNull(zzcnw);
        if (str == null || zzcnw.zzjtp == null || zzcnw.zzjtp.intValue() == 0) {
            return null;
        }
        List list;
        if (zzcnw.zzjtp.intValue() == 6) {
            if (zzcnw.zzjts == null || zzcnw.zzjts.length == 0) {
                return null;
            }
        } else if (zzcnw.zzjtq == null) {
            return null;
        }
        int intValue = zzcnw.zzjtp.intValue();
        boolean z = zzcnw.zzjtr != null && zzcnw.zzjtr.booleanValue();
        String toUpperCase = (z || intValue == 1 || intValue == 6) ? zzcnw.zzjtq : zzcnw.zzjtq.toUpperCase(Locale.ENGLISH);
        String str2 = toUpperCase;
        if (zzcnw.zzjts == null) {
            list = null;
        } else {
            String[] strArr = zzcnw.zzjts;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                List arrayList = new ArrayList();
                for (String toUpperCase2 : strArr) {
                    arrayList.add(toUpperCase2.toUpperCase(Locale.ENGLISH));
                }
                list = arrayList;
            }
        }
        return zza(str, intValue, z, str2, list, intValue == 1 ? str2 : null);
    }

    /* JADX WARNING: Missing block: B:35:0x0070, code:
            if (r3 != null) goto L_0x0072;
     */
    private static java.lang.Boolean zza(java.math.BigDecimal r7, com.google.android.gms.internal.zzcnu r8, double r9) {
        /*
        com.google.android.gms.common.internal.zzbq.checkNotNull(r8);
        r0 = r8.zzjth;
        r1 = 0;
        if (r0 == 0) goto L_0x00ec;
    L_0x0008:
        r0 = r8.zzjth;
        r0 = r0.intValue();
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = r8.zzjth;
        r0 = r0.intValue();
        r2 = 4;
        if (r0 != r2) goto L_0x0023;
    L_0x001a:
        r0 = r8.zzjtk;
        if (r0 == 0) goto L_0x0022;
    L_0x001e:
        r0 = r8.zzjtl;
        if (r0 != 0) goto L_0x0028;
    L_0x0022:
        return r1;
    L_0x0023:
        r0 = r8.zzjtj;
        if (r0 != 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r0 = r8.zzjth;
        r0 = r0.intValue();
        r3 = r8.zzjth;
        r3 = r3.intValue();
        if (r3 != r2) goto L_0x0059;
    L_0x0036:
        r3 = r8.zzjtk;
        r3 = com.google.android.gms.internal.zzcno.zzkr(r3);
        if (r3 == 0) goto L_0x0058;
    L_0x003e:
        r3 = r8.zzjtl;
        r3 = com.google.android.gms.internal.zzcno.zzkr(r3);
        if (r3 != 0) goto L_0x0047;
    L_0x0046:
        return r1;
    L_0x0047:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0058 }
        r4 = r8.zzjtk;	 Catch:{ NumberFormatException -> 0x0058 }
        r3.<init>(r4);	 Catch:{ NumberFormatException -> 0x0058 }
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0058 }
        r8 = r8.zzjtl;	 Catch:{ NumberFormatException -> 0x0058 }
        r4.<init>(r8);	 Catch:{ NumberFormatException -> 0x0058 }
        r8 = r3;
        r3 = r1;
        goto L_0x006b;
    L_0x0058:
        return r1;
    L_0x0059:
        r3 = r8.zzjtj;
        r3 = com.google.android.gms.internal.zzcno.zzkr(r3);
        if (r3 != 0) goto L_0x0062;
    L_0x0061:
        return r1;
    L_0x0062:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x00ec }
        r8 = r8.zzjtj;	 Catch:{ NumberFormatException -> 0x00ec }
        r3.<init>(r8);	 Catch:{ NumberFormatException -> 0x00ec }
        r8 = r1;
        r4 = r8;
    L_0x006b:
        if (r0 != r2) goto L_0x0070;
    L_0x006d:
        if (r8 != 0) goto L_0x0072;
    L_0x006f:
        return r1;
    L_0x0070:
        if (r3 == 0) goto L_0x00ec;
    L_0x0072:
        r2 = -1;
        r5 = 0;
        r6 = 1;
        switch(r0) {
            case 1: goto L_0x00e0;
            case 2: goto L_0x00d4;
            case 3: goto L_0x008b;
            case 4: goto L_0x0079;
            default: goto L_0x0078;
        };
    L_0x0078:
        return r1;
    L_0x0079:
        r8 = r7.compareTo(r8);
        if (r8 == r2) goto L_0x0086;
    L_0x007f:
        r7 = r7.compareTo(r4);
        if (r7 == r6) goto L_0x0086;
    L_0x0085:
        r5 = 1;
    L_0x0086:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x008b:
        r0 = 0;
        r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r8 == 0) goto L_0x00c8;
    L_0x0091:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r0 = new java.math.BigDecimal;
        r1 = 2;
        r0.<init>(r1);
        r8 = r8.multiply(r0);
        r8 = r3.subtract(r8);
        r8 = r7.compareTo(r8);
        if (r8 != r6) goto L_0x00c3;
    L_0x00aa:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r9 = new java.math.BigDecimal;
        r9.<init>(r1);
        r8 = r8.multiply(r9);
        r8 = r3.add(r8);
        r7 = r7.compareTo(r8);
        if (r7 != r2) goto L_0x00c3;
    L_0x00c2:
        r5 = 1;
    L_0x00c3:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00c8:
        r7 = r7.compareTo(r3);
        if (r7 != 0) goto L_0x00cf;
    L_0x00ce:
        r5 = 1;
    L_0x00cf:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00d4:
        r7 = r7.compareTo(r3);
        if (r7 != r6) goto L_0x00db;
    L_0x00da:
        r5 = 1;
    L_0x00db:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00e0:
        r7 = r7.compareTo(r3);
        if (r7 != r2) goto L_0x00e7;
    L_0x00e6:
        r5 = 1;
    L_0x00e7:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00ec:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcih.zza(java.math.BigDecimal, com.google.android.gms.internal.zzcnu, double):java.lang.Boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x07d8  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x07d5  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x07e7  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x07de  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x07d5  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x07d8  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x07de  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x07e7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ac  */
    @android.support.annotation.WorkerThread
    final com.google.android.gms.internal.zzcoa[] zza(java.lang.String r59, com.google.android.gms.internal.zzcob[] r60, com.google.android.gms.internal.zzcog[] r61) {
        /*
        r58 = this;
        r7 = r58;
        r15 = r59;
        r13 = r60;
        r14 = r61;
        com.google.android.gms.common.internal.zzbq.zzgv(r59);
        r11 = new java.util.HashSet;
        r11.<init>();
        r12 = new android.support.v4.util.ArrayMap;
        r12.<init>();
        r10 = new android.support.v4.util.ArrayMap;
        r10.<init>();
        r9 = new android.support.v4.util.ArrayMap;
        r9.<init>();
        r1 = r58.zzayj();
        r1 = r1.zzjm(r15);
        if (r1 == 0) goto L_0x00fc;
    L_0x0029:
        r2 = r1.keySet();
        r2 = r2.iterator();
    L_0x0031:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00fc;
    L_0x0037:
        r3 = r2.next();
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        r4 = java.lang.Integer.valueOf(r3);
        r4 = r1.get(r4);
        r4 = (com.google.android.gms.internal.zzcof) r4;
        r5 = java.lang.Integer.valueOf(r3);
        r5 = r10.get(r5);
        r5 = (java.util.BitSet) r5;
        r6 = java.lang.Integer.valueOf(r3);
        r6 = r9.get(r6);
        r6 = (java.util.BitSet) r6;
        if (r5 != 0) goto L_0x0079;
    L_0x0061:
        r5 = new java.util.BitSet;
        r5.<init>();
        r6 = java.lang.Integer.valueOf(r3);
        r10.put(r6, r5);
        r6 = new java.util.BitSet;
        r6.<init>();
        r8 = java.lang.Integer.valueOf(r3);
        r9.put(r8, r6);
    L_0x0079:
        r23 = r1;
        r8 = 0;
    L_0x007c:
        r1 = r4.zzjvo;
        r1 = r1.length;
        r1 = r1 << 6;
        if (r8 >= r1) goto L_0x00c4;
    L_0x0083:
        r1 = r4.zzjvo;
        r1 = com.google.android.gms.internal.zzcno.zza(r1, r8);
        if (r1 == 0) goto L_0x00b5;
    L_0x008b:
        r1 = r58.zzayp();
        r1 = r1.zzbba();
        r24 = r2;
        r2 = "Filter already evaluated. audience ID, filter ID";
        r25 = r9;
        r9 = java.lang.Integer.valueOf(r3);
        r26 = r10;
        r10 = java.lang.Integer.valueOf(r8);
        r1.zze(r2, r9, r10);
        r6.set(r8);
        r1 = r4.zzjvp;
        r1 = com.google.android.gms.internal.zzcno.zza(r1, r8);
        if (r1 == 0) goto L_0x00bb;
    L_0x00b1:
        r5.set(r8);
        goto L_0x00bb;
    L_0x00b5:
        r24 = r2;
        r25 = r9;
        r26 = r10;
    L_0x00bb:
        r8 = r8 + 1;
        r2 = r24;
        r9 = r25;
        r10 = r26;
        goto L_0x007c;
    L_0x00c4:
        r24 = r2;
        r25 = r9;
        r26 = r10;
        r1 = new com.google.android.gms.internal.zzcoa;
        r1.<init>();
        r2 = java.lang.Integer.valueOf(r3);
        r12.put(r2, r1);
        r2 = 0;
        r3 = java.lang.Boolean.valueOf(r2);
        r1.zzjug = r3;
        r1.zzjuf = r4;
        r2 = new com.google.android.gms.internal.zzcof;
        r2.<init>();
        r1.zzjue = r2;
        r2 = r1.zzjue;
        r3 = com.google.android.gms.internal.zzcno.zza(r5);
        r2.zzjvp = r3;
        r1 = r1.zzjue;
        r2 = com.google.android.gms.internal.zzcno.zza(r6);
        r1.zzjvo = r2;
        r1 = r23;
        r2 = r24;
        goto L_0x0031;
    L_0x00fc:
        r25 = r9;
        r26 = r10;
        if (r13 == 0) goto L_0x0596;
    L_0x0102:
        r4 = new android.support.v4.util.ArrayMap;
        r4.<init>();
        r5 = r13.length;
        r1 = 0;
        r8 = 0;
        r16 = 0;
        r17 = 0;
    L_0x010e:
        if (r1 >= r5) goto L_0x0596;
    L_0x0110:
        r9 = r13[r1];
        r10 = r9.name;
        r6 = r9.zzjui;
        r2 = r58.zzayr();
        r3 = com.google.android.gms.internal.zzciz.zzjjv;
        r2 = r2.zzc(r15, r3);
        if (r2 == 0) goto L_0x02fa;
    L_0x0122:
        r58.zzayl();
        r2 = "_eid";
        r2 = com.google.android.gms.internal.zzcno.zzb(r9, r2);
        r3 = r2;
        r3 = (java.lang.Long) r3;
        if (r3 == 0) goto L_0x0132;
    L_0x0130:
        r2 = 1;
        goto L_0x0133;
    L_0x0132:
        r2 = 0;
    L_0x0133:
        if (r2 == 0) goto L_0x0141;
    L_0x0135:
        r30 = r1;
        r1 = "_ep";
        r1 = r10.equals(r1);
        if (r1 == 0) goto L_0x0143;
    L_0x013f:
        r1 = 1;
        goto L_0x0144;
    L_0x0141:
        r30 = r1;
    L_0x0143:
        r1 = 0;
    L_0x0144:
        if (r1 == 0) goto L_0x02a7;
    L_0x0146:
        r58.zzayl();
        r1 = "_en";
        r1 = com.google.android.gms.internal.zzcno.zzb(r9, r1);
        r10 = r1;
        r10 = (java.lang.String) r10;
        r1 = android.text.TextUtils.isEmpty(r10);
        if (r1 == 0) goto L_0x016f;
    L_0x0158:
        r1 = r58.zzayp();
        r1 = r1.zzbau();
        r2 = "Extra parameter without an event name. eventId";
        r1.zzj(r2, r3);
        r33 = r4;
        r23 = r5;
        r22 = r30;
        r21 = 0;
        goto L_0x0298;
    L_0x016f:
        if (r16 == 0) goto L_0x0187;
    L_0x0171:
        if (r8 == 0) goto L_0x0187;
    L_0x0173:
        r1 = r3.longValue();
        r19 = r8.longValue();
        r21 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1));
        if (r21 == 0) goto L_0x0180;
    L_0x017f:
        goto L_0x0187;
    L_0x0180:
        r57 = r16;
        r16 = r8;
        r8 = r57;
        goto L_0x01b1;
    L_0x0187:
        r1 = r58.zzayj();
        r1 = r1.zzb(r15, r3);
        if (r1 == 0) goto L_0x0283;
    L_0x0191:
        r2 = r1.first;
        if (r2 != 0) goto L_0x0197;
    L_0x0195:
        goto L_0x0283;
    L_0x0197:
        r2 = r1.first;
        r2 = (com.google.android.gms.internal.zzcob) r2;
        r1 = r1.second;
        r1 = (java.lang.Long) r1;
        r17 = r1.longValue();
        r58.zzayl();
        r1 = "_eid";
        r1 = com.google.android.gms.internal.zzcno.zzb(r2, r1);
        r1 = (java.lang.Long) r1;
        r16 = r1;
        r8 = r2;
    L_0x01b1:
        r1 = 1;
        r19 = r17 - r1;
        r17 = 0;
        r1 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1));
        if (r1 > 0) goto L_0x0208;
    L_0x01bb:
        r1 = r58.zzayj();
        r1.zzwj();
        r2 = r1.zzayp();
        r2 = r2.zzbba();
        r3 = "Clearing complex main event info. appId";
        r2.zzj(r3, r15);
        r2 = r1.getWritableDatabase();	 Catch:{ SQLiteException -> 0x01e8 }
        r3 = "delete from main_event_params where app_id=?";
        r32 = r4;
        r31 = r6;
        r6 = 1;
        r4 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x01e6 }
        r21 = 0;
        r4[r21] = r15;	 Catch:{ SQLiteException -> 0x01e4 }
        r2.execSQL(r3, r4);	 Catch:{ SQLiteException -> 0x01e4 }
        goto L_0x01fe;
    L_0x01e4:
        r0 = move-exception;
        goto L_0x01f0;
    L_0x01e6:
        r0 = move-exception;
        goto L_0x01ee;
    L_0x01e8:
        r0 = move-exception;
        r32 = r4;
        r31 = r6;
        r6 = 1;
    L_0x01ee:
        r21 = 0;
    L_0x01f0:
        r2 = r0;
        r1 = r1.zzayp();
        r1 = r1.zzbau();
        r3 = "Error clearing complex main event";
        r1.zzj(r3, r2);
    L_0x01fe:
        r23 = r5;
        r22 = r30;
        r13 = r31;
        r33 = r32;
        r14 = 1;
        goto L_0x0225;
    L_0x0208:
        r32 = r4;
        r31 = r6;
        r6 = 1;
        r21 = 0;
        r1 = r58.zzayj();
        r22 = r30;
        r13 = r17;
        r2 = r15;
        r23 = r5;
        r33 = r32;
        r4 = r19;
        r13 = r31;
        r14 = 1;
        r6 = r8;
        r1.zza(r2, r3, r4, r6);
    L_0x0225:
        r1 = r8.zzjui;
        r1 = r1.length;
        r2 = r13.length;
        r1 = r1 + r2;
        r1 = new com.google.android.gms.internal.zzcoc[r1];
        r2 = r8.zzjui;
        r3 = r2.length;
        r4 = 0;
        r5 = 0;
    L_0x0231:
        if (r4 >= r3) goto L_0x0249;
    L_0x0233:
        r6 = r2[r4];
        r58.zzayl();
        r14 = r6.name;
        r14 = com.google.android.gms.internal.zzcno.zza(r9, r14);
        if (r14 != 0) goto L_0x0245;
    L_0x0240:
        r14 = r5 + 1;
        r1[r5] = r6;
        r5 = r14;
    L_0x0245:
        r4 = r4 + 1;
        r14 = 1;
        goto L_0x0231;
    L_0x0249:
        if (r5 <= 0) goto L_0x0269;
    L_0x024b:
        r2 = r13.length;
        r3 = 0;
    L_0x024d:
        if (r3 >= r2) goto L_0x0259;
    L_0x024f:
        r4 = r13[r3];
        r6 = r5 + 1;
        r1[r5] = r4;
        r3 = r3 + 1;
        r5 = r6;
        goto L_0x024d;
    L_0x0259:
        r2 = r1.length;
        if (r5 != r2) goto L_0x025d;
    L_0x025c:
        goto L_0x0263;
    L_0x025d:
        r1 = java.util.Arrays.copyOf(r1, r5);
        r1 = (com.google.android.gms.internal.zzcoc[]) r1;
    L_0x0263:
        r30 = r1;
        r24 = r8;
        r5 = r10;
        goto L_0x027b;
    L_0x0269:
        r1 = r58.zzayp();
        r1 = r1.zzbaw();
        r2 = "No unique parameters in main event. eventName";
        r1.zzj(r2, r10);
        r24 = r8;
        r5 = r10;
        r30 = r13;
    L_0x027b:
        r27 = r16;
        r28 = r19;
        r19 = 0;
        goto L_0x030e;
    L_0x0283:
        r33 = r4;
        r23 = r5;
        r22 = r30;
        r21 = 0;
        r1 = r58.zzayp();
        r1 = r1.zzbau();
        r2 = "Extra parameter without existing main event. eventName, eventId";
        r1.zze(r2, r10, r3);
    L_0x0298:
        r14 = r11;
        r47 = r12;
        r45 = r25;
        r48 = r26;
        r39 = r33;
        r10 = r61;
        r25 = 0;
        goto L_0x0582;
    L_0x02a7:
        r33 = r4;
        r23 = r5;
        r13 = r6;
        r22 = r30;
        r21 = 0;
        if (r2 == 0) goto L_0x02f7;
    L_0x02b2:
        r58.zzayl();
        r1 = "_epc";
        r4 = 0;
        r2 = java.lang.Long.valueOf(r4);
        r1 = com.google.android.gms.internal.zzcno.zzb(r9, r1);
        if (r1 != 0) goto L_0x02c4;
    L_0x02c3:
        r1 = r2;
    L_0x02c4:
        r1 = (java.lang.Long) r1;
        r16 = r1.longValue();
        r1 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r1 > 0) goto L_0x02df;
    L_0x02ce:
        r1 = r58.zzayp();
        r1 = r1.zzbaw();
        r2 = "Complex event with zero extra param count. eventName";
        r1.zzj(r2, r10);
        r8 = r3;
        r19 = r4;
        goto L_0x02ed;
    L_0x02df:
        r1 = r58.zzayj();
        r2 = r15;
        r8 = r3;
        r19 = r4;
        r4 = r16;
        r6 = r9;
        r1.zza(r2, r3, r4, r6);
    L_0x02ed:
        r27 = r8;
        r24 = r9;
        r5 = r10;
        r30 = r13;
        r28 = r16;
        goto L_0x030e;
    L_0x02f7:
        r19 = 0;
        goto L_0x0305;
    L_0x02fa:
        r22 = r1;
        r33 = r4;
        r23 = r5;
        r13 = r6;
        r19 = 0;
        r21 = 0;
    L_0x0305:
        r27 = r8;
        r5 = r10;
        r30 = r13;
        r24 = r16;
        r28 = r17;
    L_0x030e:
        r1 = r58.zzayj();
        r2 = r9.name;
        r1 = r1.zzae(r15, r2);
        if (r1 != 0) goto L_0x0367;
    L_0x031a:
        r1 = r58.zzayp();
        r1 = r1.zzbaw();
        r2 = "Event aggregate wasn't created during raw event logging. appId, event";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r59);
        r4 = r58.zzayk();
        r4 = r4.zzjp(r5);
        r1.zze(r2, r3, r4);
        r1 = new com.google.android.gms.internal.zzcit;
        r10 = r9.name;
        r2 = 1;
        r13 = 1;
        r4 = r9.zzjuj;
        r16 = r4.longValue();
        r31 = 0;
        r4 = 0;
        r6 = 0;
        r34 = 0;
        r9 = 0;
        r8 = r1;
        r35 = r25;
        r9 = r15;
        r36 = r26;
        r37 = r11;
        r38 = r12;
        r11 = r2;
        r25 = r19;
        r2 = 1;
        r3 = r61;
        r2 = r15;
        r15 = r16;
        r17 = r31;
        r19 = r4;
        r20 = r6;
        r21 = r34;
        r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21);
        goto L_0x0378;
    L_0x0367:
        r37 = r11;
        r38 = r12;
        r2 = r15;
        r35 = r25;
        r36 = r26;
        r3 = r61;
        r25 = r19;
        r1 = r1.zzban();
    L_0x0378:
        r4 = r58.zzayj();
        r4.zza(r1);
        r8 = r1.zzjhs;
        r10 = r33;
        r1 = r10.get(r5);
        r1 = (java.util.Map) r1;
        if (r1 != 0) goto L_0x039d;
    L_0x038b:
        r1 = r58.zzayj();
        r1 = r1.zzaj(r2, r5);
        if (r1 != 0) goto L_0x039a;
    L_0x0395:
        r1 = new android.support.v4.util.ArrayMap;
        r1.<init>();
    L_0x039a:
        r10.put(r5, r1);
    L_0x039d:
        r11 = r1;
        r1 = r11.keySet();
        r12 = r1.iterator();
    L_0x03a6:
        r1 = r12.hasNext();
        if (r1 == 0) goto L_0x0571;
    L_0x03ac:
        r1 = r12.next();
        r1 = (java.lang.Integer) r1;
        r13 = r1.intValue();
        r1 = java.lang.Integer.valueOf(r13);
        r14 = r37;
        r1 = r14.contains(r1);
        if (r1 == 0) goto L_0x03d6;
    L_0x03c2:
        r1 = r58.zzayp();
        r1 = r1.zzbba();
        r4 = "Skipping failed audience ID";
        r6 = java.lang.Integer.valueOf(r13);
        r1.zzj(r4, r6);
        r37 = r14;
        goto L_0x03a6;
    L_0x03d6:
        r1 = java.lang.Integer.valueOf(r13);
        r15 = r38;
        r1 = r15.get(r1);
        r1 = (com.google.android.gms.internal.zzcoa) r1;
        r4 = java.lang.Integer.valueOf(r13);
        r6 = r36;
        r4 = r6.get(r4);
        r4 = (java.util.BitSet) r4;
        r2 = java.lang.Integer.valueOf(r13);
        r39 = r10;
        r10 = r35;
        r2 = r10.get(r2);
        r2 = (java.util.BitSet) r2;
        if (r1 != 0) goto L_0x042a;
    L_0x03fe:
        r1 = new com.google.android.gms.internal.zzcoa;
        r1.<init>();
        r2 = java.lang.Integer.valueOf(r13);
        r15.put(r2, r1);
        r2 = 1;
        r4 = java.lang.Boolean.valueOf(r2);
        r1.zzjug = r4;
        r4 = new java.util.BitSet;
        r4.<init>();
        r1 = java.lang.Integer.valueOf(r13);
        r6.put(r1, r4);
        r1 = new java.util.BitSet;
        r1.<init>();
        r2 = java.lang.Integer.valueOf(r13);
        r10.put(r2, r1);
        r2 = r1;
    L_0x042a:
        r16 = 1;
        r1 = java.lang.Integer.valueOf(r13);
        r1 = r11.get(r1);
        r1 = (java.util.List) r1;
        r1 = r1.iterator();
    L_0x043a:
        r17 = r1.hasNext();
        if (r17 == 0) goto L_0x0563;
    L_0x0440:
        r17 = r1.next();
        r40 = r11;
        r11 = r17;
        r11 = (com.google.android.gms.internal.zzcns) r11;
        r41 = r1;
        r1 = r58.zzayp();
        r42 = r12;
        r12 = 2;
        r1 = r1.zzae(r12);
        if (r1 == 0) goto L_0x0492;
    L_0x0459:
        r1 = r58.zzayp();
        r1 = r1.zzbba();
        r12 = "Evaluating filter. audience, filter, event";
        r43 = r2;
        r2 = java.lang.Integer.valueOf(r13);
        r3 = r11.zzjsx;
        r44 = r6;
        r6 = r58.zzayk();
        r45 = r10;
        r10 = r11.zzjsy;
        r6 = r6.zzjp(r10);
        r1.zzd(r12, r2, r3, r6);
        r1 = r58.zzayp();
        r1 = r1.zzbba();
        r2 = "Filter definition";
        r3 = r58.zzayk();
        r3 = r3.zza(r11);
        r1.zzj(r2, r3);
        goto L_0x0498;
    L_0x0492:
        r43 = r2;
        r44 = r6;
        r45 = r10;
    L_0x0498:
        r1 = r11.zzjsx;
        if (r1 == 0) goto L_0x052a;
    L_0x049c:
        r1 = r11.zzjsx;
        r1 = r1.intValue();
        r10 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r1 <= r10) goto L_0x04a8;
    L_0x04a6:
        goto L_0x052a;
    L_0x04a8:
        r1 = r11.zzjsx;
        r1 = r1.intValue();
        r1 = r4.get(r1);
        if (r1 == 0) goto L_0x04d7;
    L_0x04b4:
        r1 = r58.zzayp();
        r1 = r1.zzbba();
        r2 = "Event filter already evaluated true. audience ID, filter ID";
        r3 = java.lang.Integer.valueOf(r13);
        r6 = r11.zzjsx;
        r1.zze(r2, r3, r6);
        r11 = r40;
        r1 = r41;
        r12 = r42;
        r2 = r43;
        r6 = r44;
        r10 = r45;
        r3 = r61;
        goto L_0x043a;
    L_0x04d7:
        r12 = r41;
        r1 = r7;
        r3 = r43;
        r6 = r59;
        r10 = 1;
        r2 = r11;
        r46 = r12;
        r10 = r61;
        r12 = r3;
        r3 = r5;
        r47 = r15;
        r15 = r4;
        r4 = r30;
        r16 = r5;
        r48 = r44;
        r5 = r8;
        r1 = r1.zza(r2, r3, r4, r5);
        r2 = r58.zzayp();
        r2 = r2.zzbba();
        r3 = "Event filter result";
        if (r1 != 0) goto L_0x0503;
    L_0x0500:
        r4 = "null";
        goto L_0x0504;
    L_0x0503:
        r4 = r1;
    L_0x0504:
        r2.zzj(r3, r4);
        if (r1 != 0) goto L_0x0511;
    L_0x0509:
        r1 = java.lang.Integer.valueOf(r13);
        r14.add(r1);
        goto L_0x054e;
    L_0x0511:
        r2 = r11.zzjsx;
        r2 = r2.intValue();
        r12.set(r2);
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x054e;
    L_0x0520:
        r1 = r11.zzjsx;
        r1 = r1.intValue();
        r15.set(r1);
        goto L_0x054e;
    L_0x052a:
        r16 = r5;
        r47 = r15;
        r46 = r41;
        r12 = r43;
        r48 = r44;
        r10 = r61;
        r15 = r4;
        r1 = r58.zzayp();
        r1 = r1.zzbaw();
        r2 = "Invalid event filter ID. appId, id";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r59);
        r4 = r11.zzjsx;
        r4 = java.lang.String.valueOf(r4);
        r1.zze(r2, r3, r4);
    L_0x054e:
        r3 = r10;
        r2 = r12;
        r4 = r15;
        r5 = r16;
        r11 = r40;
        r12 = r42;
        r10 = r45;
        r1 = r46;
        r15 = r47;
        r6 = r48;
        r16 = 1;
        goto L_0x043a;
    L_0x0563:
        r2 = r59;
        r36 = r6;
        r35 = r10;
        r37 = r14;
        r38 = r15;
        r10 = r39;
        goto L_0x03a6;
    L_0x0571:
        r39 = r10;
        r45 = r35;
        r48 = r36;
        r14 = r37;
        r47 = r38;
        r10 = r3;
        r16 = r24;
        r8 = r27;
        r17 = r28;
    L_0x0582:
        r1 = r22 + 1;
        r15 = r59;
        r13 = r60;
        r11 = r14;
        r5 = r23;
        r4 = r39;
        r25 = r45;
        r12 = r47;
        r26 = r48;
        r14 = r10;
        goto L_0x010e;
    L_0x0596:
        r47 = r12;
        r10 = r14;
        r45 = r25;
        r48 = r26;
        r14 = r11;
        if (r10 == 0) goto L_0x0851;
    L_0x05a0:
        r1 = new android.support.v4.util.ArrayMap;
        r1.<init>();
        r2 = r10.length;
        r3 = 0;
    L_0x05a7:
        if (r3 >= r2) goto L_0x0851;
    L_0x05a9:
        r4 = r10[r3];
        r5 = r4.name;
        r5 = r1.get(r5);
        r5 = (java.util.Map) r5;
        if (r5 != 0) goto L_0x05ce;
    L_0x05b5:
        r5 = r58.zzayj();
        r6 = r4.name;
        r8 = r59;
        r5 = r5.zzak(r8, r6);
        if (r5 != 0) goto L_0x05c8;
    L_0x05c3:
        r5 = new android.support.v4.util.ArrayMap;
        r5.<init>();
    L_0x05c8:
        r6 = r4.name;
        r1.put(r6, r5);
        goto L_0x05d0;
    L_0x05ce:
        r8 = r59;
    L_0x05d0:
        r6 = r5.keySet();
        r6 = r6.iterator();
    L_0x05d8:
        r9 = r6.hasNext();
        if (r9 == 0) goto L_0x083f;
    L_0x05de:
        r9 = r6.next();
        r9 = (java.lang.Integer) r9;
        r9 = r9.intValue();
        r11 = java.lang.Integer.valueOf(r9);
        r11 = r14.contains(r11);
        if (r11 == 0) goto L_0x0604;
    L_0x05f2:
        r11 = r58.zzayp();
        r11 = r11.zzbba();
        r12 = "Skipping failed audience ID";
        r9 = java.lang.Integer.valueOf(r9);
        r11.zzj(r12, r9);
        goto L_0x05d8;
    L_0x0604:
        r11 = java.lang.Integer.valueOf(r9);
        r12 = r47;
        r11 = r12.get(r11);
        r11 = (com.google.android.gms.internal.zzcoa) r11;
        r13 = java.lang.Integer.valueOf(r9);
        r15 = r48;
        r13 = r15.get(r13);
        r13 = (java.util.BitSet) r13;
        r49 = r1;
        r1 = java.lang.Integer.valueOf(r9);
        r50 = r2;
        r2 = r45;
        r1 = r2.get(r1);
        r1 = (java.util.BitSet) r1;
        if (r11 != 0) goto L_0x0659;
    L_0x062e:
        r1 = new com.google.android.gms.internal.zzcoa;
        r1.<init>();
        r11 = java.lang.Integer.valueOf(r9);
        r12.put(r11, r1);
        r11 = 1;
        r13 = java.lang.Boolean.valueOf(r11);
        r1.zzjug = r13;
        r13 = new java.util.BitSet;
        r13.<init>();
        r1 = java.lang.Integer.valueOf(r9);
        r15.put(r1, r13);
        r1 = new java.util.BitSet;
        r1.<init>();
        r11 = java.lang.Integer.valueOf(r9);
        r2.put(r11, r1);
    L_0x0659:
        r11 = java.lang.Integer.valueOf(r9);
        r11 = r5.get(r11);
        r11 = (java.util.List) r11;
        r11 = r11.iterator();
    L_0x0667:
        r16 = r11.hasNext();
        if (r16 == 0) goto L_0x0833;
    L_0x066d:
        r16 = r11.next();
        r51 = r5;
        r5 = r16;
        r5 = (com.google.android.gms.internal.zzcnv) r5;
        r52 = r6;
        r6 = r58.zzayp();
        r10 = 2;
        r6 = r6.zzae(r10);
        if (r6 == 0) goto L_0x06bf;
    L_0x0684:
        r6 = r58.zzayp();
        r6 = r6.zzbba();
        r10 = "Evaluating filter. audience, filter, property";
        r53 = r11;
        r11 = java.lang.Integer.valueOf(r9);
        r54 = r2;
        r2 = r5.zzjsx;
        r55 = r12;
        r12 = r58.zzayk();
        r56 = r15;
        r15 = r5.zzjtn;
        r12 = r12.zzjr(r15);
        r6.zzd(r10, r11, r2, r12);
        r2 = r58.zzayp();
        r2 = r2.zzbba();
        r6 = "Filter definition";
        r10 = r58.zzayk();
        r10 = r10.zza(r5);
        r2.zzj(r6, r10);
        goto L_0x06c7;
    L_0x06bf:
        r54 = r2;
        r53 = r11;
        r55 = r12;
        r56 = r15;
    L_0x06c7:
        r2 = r5.zzjsx;
        if (r2 == 0) goto L_0x0801;
    L_0x06cb:
        r2 = r5.zzjsx;
        r2 = r2.intValue();
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r2 <= r6) goto L_0x06d7;
    L_0x06d5:
        goto L_0x0803;
    L_0x06d7:
        r2 = r5.zzjsx;
        r2 = r2.intValue();
        r2 = r13.get(r2);
        if (r2 == 0) goto L_0x0706;
    L_0x06e3:
        r2 = r58.zzayp();
        r2 = r2.zzbba();
        r10 = "Property filter already evaluated true. audience ID, filter ID";
        r11 = java.lang.Integer.valueOf(r9);
        r5 = r5.zzjsx;
        r2.zze(r10, r11, r5);
    L_0x06f6:
        r5 = r51;
        r6 = r52;
        r11 = r53;
        r2 = r54;
        r12 = r55;
        r15 = r56;
        r10 = r61;
        goto L_0x0667;
    L_0x0706:
        r2 = r5.zzjto;
        if (r2 != 0) goto L_0x0724;
    L_0x070a:
        r2 = r58.zzayp();
        r2 = r2.zzbaw();
        r10 = "Missing property filter. property";
    L_0x0714:
        r11 = r58.zzayk();
        r12 = r4.name;
        r11 = r11.zzjr(r12);
        r2.zzj(r10, r11);
    L_0x0721:
        r2 = 0;
        goto L_0x07c9;
    L_0x0724:
        r10 = java.lang.Boolean.TRUE;
        r11 = r2.zzjtf;
        r10 = r10.equals(r11);
        r11 = r4.zzjum;
        if (r11 == 0) goto L_0x0751;
    L_0x0730:
        r11 = r2.zzjte;
        if (r11 != 0) goto L_0x073f;
    L_0x0734:
        r2 = r58.zzayp();
        r2 = r2.zzbaw();
        r10 = "No number filter for long property. property";
        goto L_0x0714;
    L_0x073f:
        r11 = r4.zzjum;
        r11 = r11.longValue();
        r2 = r2.zzjte;
        r2 = r7.zza(r11, r2);
    L_0x074b:
        r2 = zza(r2, r10);
        goto L_0x07c9;
    L_0x0751:
        r11 = r4.zzjsl;
        if (r11 == 0) goto L_0x0771;
    L_0x0755:
        r11 = r2.zzjte;
        if (r11 != 0) goto L_0x0764;
    L_0x0759:
        r2 = r58.zzayp();
        r2 = r2.zzbaw();
        r10 = "No number filter for double property. property";
        goto L_0x0714;
    L_0x0764:
        r11 = r4.zzjsl;
        r11 = r11.doubleValue();
        r2 = r2.zzjte;
        r2 = r7.zza(r11, r2);
        goto L_0x074b;
    L_0x0771:
        r11 = r4.zzgim;
        if (r11 == 0) goto L_0x07bd;
    L_0x0775:
        r11 = r2.zzjtd;
        if (r11 != 0) goto L_0x07b4;
    L_0x0779:
        r11 = r2.zzjte;
        if (r11 != 0) goto L_0x0788;
    L_0x077d:
        r2 = r58.zzayp();
        r2 = r2.zzbaw();
        r10 = "No string or number filter defined. property";
        goto L_0x0714;
    L_0x0788:
        r11 = r4.zzgim;
        r11 = com.google.android.gms.internal.zzcno.zzkr(r11);
        if (r11 == 0) goto L_0x0799;
    L_0x0790:
        r11 = r4.zzgim;
        r2 = r2.zzjte;
        r2 = r7.zza(r11, r2);
        goto L_0x074b;
    L_0x0799:
        r2 = r58.zzayp();
        r2 = r2.zzbaw();
        r10 = "Invalid user property value for Numeric number filter. property, value";
        r11 = r58.zzayk();
        r12 = r4.name;
        r11 = r11.zzjr(r12);
        r12 = r4.zzgim;
        r2.zze(r10, r11, r12);
        goto L_0x0721;
    L_0x07b4:
        r11 = r4.zzgim;
        r2 = r2.zzjtd;
        r2 = r7.zza(r11, r2);
        goto L_0x074b;
    L_0x07bd:
        r2 = r58.zzayp();
        r2 = r2.zzbaw();
        r10 = "User property has no value, property";
        goto L_0x0714;
    L_0x07c9:
        r10 = r58.zzayp();
        r10 = r10.zzbba();
        r11 = "Property filter result";
        if (r2 != 0) goto L_0x07d8;
    L_0x07d5:
        r12 = "null";
        goto L_0x07d9;
    L_0x07d8:
        r12 = r2;
    L_0x07d9:
        r10.zzj(r11, r12);
        if (r2 != 0) goto L_0x07e7;
    L_0x07de:
        r2 = java.lang.Integer.valueOf(r9);
        r14.add(r2);
        goto L_0x06f6;
    L_0x07e7:
        r10 = r5.zzjsx;
        r10 = r10.intValue();
        r1.set(r10);
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x06f6;
    L_0x07f6:
        r2 = r5.zzjsx;
        r2 = r2.intValue();
        r13.set(r2);
        goto L_0x06f6;
    L_0x0801:
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
    L_0x0803:
        r1 = r58.zzayp();
        r1 = r1.zzbaw();
        r2 = "Invalid property filter ID. appId, id";
        r10 = com.google.android.gms.internal.zzcjj.zzjs(r59);
        r5 = r5.zzjsx;
        r5 = java.lang.String.valueOf(r5);
        r1.zze(r2, r10, r5);
        r1 = java.lang.Integer.valueOf(r9);
        r14.add(r1);
        r1 = r49;
        r2 = r50;
        r5 = r51;
        r6 = r52;
        r45 = r54;
        r47 = r55;
        r48 = r56;
        r10 = r61;
        goto L_0x05d8;
    L_0x0833:
        r45 = r2;
        r47 = r12;
        r48 = r15;
        r1 = r49;
        r2 = r50;
        goto L_0x05d8;
    L_0x083f:
        r49 = r1;
        r50 = r2;
        r54 = r45;
        r55 = r47;
        r56 = r48;
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r3 = r3 + 1;
        r10 = r61;
        goto L_0x05a7;
    L_0x0851:
        r8 = r59;
        r54 = r45;
        r55 = r47;
        r1 = r48;
        r2 = r1.size();
        r2 = new com.google.android.gms.internal.zzcoa[r2];
        r3 = r1.keySet();
        r3 = r3.iterator();
        r4 = 0;
    L_0x0868:
        r5 = r3.hasNext();
        if (r5 == 0) goto L_0x0957;
    L_0x086e:
        r5 = r3.next();
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r6 = java.lang.Integer.valueOf(r5);
        r6 = r14.contains(r6);
        if (r6 != 0) goto L_0x0868;
    L_0x0882:
        r6 = java.lang.Integer.valueOf(r5);
        r9 = r55;
        r6 = r9.get(r6);
        r6 = (com.google.android.gms.internal.zzcoa) r6;
        if (r6 != 0) goto L_0x0895;
    L_0x0890:
        r6 = new com.google.android.gms.internal.zzcoa;
        r6.<init>();
    L_0x0895:
        r10 = r4 + 1;
        r2[r4] = r6;
        r4 = java.lang.Integer.valueOf(r5);
        r6.zzjst = r4;
        r4 = new com.google.android.gms.internal.zzcof;
        r4.<init>();
        r6.zzjue = r4;
        r4 = r6.zzjue;
        r11 = java.lang.Integer.valueOf(r5);
        r11 = r1.get(r11);
        r11 = (java.util.BitSet) r11;
        r11 = com.google.android.gms.internal.zzcno.zza(r11);
        r4.zzjvp = r11;
        r4 = r6.zzjue;
        r11 = java.lang.Integer.valueOf(r5);
        r12 = r54;
        r11 = r12.get(r11);
        r11 = (java.util.BitSet) r11;
        r11 = com.google.android.gms.internal.zzcno.zza(r11);
        r4.zzjvo = r11;
        r4 = r58.zzayj();
        r6 = r6.zzjue;
        r4.zzyk();
        r4.zzwj();
        com.google.android.gms.common.internal.zzbq.zzgv(r59);
        com.google.android.gms.common.internal.zzbq.checkNotNull(r6);
        r11 = r6.zzhs();	 Catch:{ IOException -> 0x093c }
        r11 = new byte[r11];	 Catch:{ IOException -> 0x093c }
        r13 = r11.length;	 Catch:{ IOException -> 0x093c }
        r15 = 0;
        r13 = com.google.android.gms.internal.zzflk.zzp(r11, r15, r13);	 Catch:{ IOException -> 0x093c }
        r6.zza(r13);	 Catch:{ IOException -> 0x093c }
        r13.zzcyx();	 Catch:{ IOException -> 0x093c }
        r6 = new android.content.ContentValues;
        r6.<init>();
        r13 = "app_id";
        r6.put(r13, r8);
        r13 = "audience_id";
        r5 = java.lang.Integer.valueOf(r5);
        r6.put(r13, r5);
        r5 = "current_results";
        r6.put(r5, r11);
        r5 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x092e }
        r11 = "audience_filter_values";
        r13 = 5;
        r15 = 0;
        r5 = r5.insertWithOnConflict(r11, r15, r6, r13);	 Catch:{ SQLiteException -> 0x092c }
        r16 = -1;
        r11 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1));
        if (r11 != 0) goto L_0x0950;
    L_0x091a:
        r5 = r4.zzayp();	 Catch:{ SQLiteException -> 0x092c }
        r5 = r5.zzbau();	 Catch:{ SQLiteException -> 0x092c }
        r6 = "Failed to insert filter results (got -1). appId";
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r59);	 Catch:{ SQLiteException -> 0x092c }
        r5.zzj(r6, r11);	 Catch:{ SQLiteException -> 0x092c }
        goto L_0x0950;
    L_0x092c:
        r0 = move-exception;
        goto L_0x0930;
    L_0x092e:
        r0 = move-exception;
        r15 = 0;
    L_0x0930:
        r5 = r0;
        r4 = r4.zzayp();
        r4 = r4.zzbau();
        r6 = "Error storing filter results. appId";
        goto L_0x0949;
    L_0x093c:
        r0 = move-exception;
        r15 = 0;
        r5 = r0;
        r4 = r4.zzayp();
        r4 = r4.zzbau();
        r6 = "Configuration loss. Failed to serialize filter results. appId";
    L_0x0949:
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r59);
        r4.zze(r6, r11, r5);
    L_0x0950:
        r55 = r9;
        r4 = r10;
        r54 = r12;
        goto L_0x0868;
    L_0x0957:
        r1 = java.util.Arrays.copyOf(r2, r4);
        r1 = (com.google.android.gms.internal.zzcoa[]) r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcih.zza(java.lang.String, com.google.android.gms.internal.zzcob[], com.google.android.gms.internal.zzcog[]):com.google.android.gms.internal.zzcoa[]");
    }

    protected final boolean zzazq() {
        return false;
    }
}
