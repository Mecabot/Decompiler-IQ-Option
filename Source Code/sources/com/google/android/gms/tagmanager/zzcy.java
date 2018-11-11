package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import java.util.Set;

final class zzcy extends zzbr {
    private static final String ID = zzbh.JOINER.toString();
    private static final String zzkpn = zzbi.ARG0.toString();
    private static final String zzkqf = zzbi.ITEM_SEPARATOR.toString();
    private static final String zzkqg = zzbi.KEY_VALUE_SEPARATOR.toString();
    private static final String zzkqh = zzbi.ESCAPE.toString();

    public zzcy() {
        super(ID, zzkpn);
    }

    private static String zza(String str, Integer num, Set<Character> set) {
        switch (zzcz.zzkqi[num - 1]) {
            case 1:
                try {
                    return zzgo.zzmm(str);
                } catch (Throwable e) {
                    zzdj.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case 2:
                str = str.replace("\\", "\\\\");
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    String str2 = "\\";
                    String valueOf = String.valueOf(ch2);
                    str = str.replace(ch2, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                return str;
            default:
                return str;
        }
    }

    private static void zza(StringBuilder stringBuilder, String str, Integer num, Set<Character> set) {
        stringBuilder.append(zza(str, num, set));
    }

    private static void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public final boolean zzbfh() {
        return true;
    }

    public final com.google.android.gms.internal.zzbt zzx(java.util.Map<java.lang.String, com.google.android.gms.internal.zzbt> r10) {
        /*
        r9 = this;
        r0 = zzkpn;
        r0 = r10.get(r0);
        r0 = (com.google.android.gms.internal.zzbt) r0;
        if (r0 != 0) goto L_0x000f;
    L_0x000a:
        r10 = com.google.android.gms.tagmanager.zzgk.zzbil();
        return r10;
    L_0x000f:
        r1 = zzkqf;
        r1 = r10.get(r1);
        r1 = (com.google.android.gms.internal.zzbt) r1;
        if (r1 == 0) goto L_0x001e;
    L_0x0019:
        r1 = com.google.android.gms.tagmanager.zzgk.zzd(r1);
        goto L_0x0020;
    L_0x001e:
        r1 = "";
    L_0x0020:
        r2 = zzkqg;
        r2 = r10.get(r2);
        r2 = (com.google.android.gms.internal.zzbt) r2;
        if (r2 == 0) goto L_0x002f;
    L_0x002a:
        r2 = com.google.android.gms.tagmanager.zzgk.zzd(r2);
        goto L_0x0031;
    L_0x002f:
        r2 = "=";
    L_0x0031:
        r3 = com.google.android.gms.tagmanager.zzda.zzkqj;
        r4 = zzkqh;
        r10 = r10.get(r4);
        r10 = (com.google.android.gms.internal.zzbt) r10;
        r4 = 0;
        if (r10 == 0) goto L_0x008a;
    L_0x003e:
        r10 = com.google.android.gms.tagmanager.zzgk.zzd(r10);
        r3 = "url";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x004d;
    L_0x004a:
        r3 = com.google.android.gms.tagmanager.zzda.zzkqk;
        goto L_0x008a;
    L_0x004d:
        r3 = "backslash";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x006c;
    L_0x0055:
        r3 = com.google.android.gms.tagmanager.zzda.zzkql;
        r4 = new java.util.HashSet;
        r4.<init>();
        zza(r4, r1);
        zza(r4, r2);
        r10 = 92;
        r10 = java.lang.Character.valueOf(r10);
        r4.remove(r10);
        goto L_0x008a;
    L_0x006c:
        r0 = "Joiner: unsupported escape type: ";
        r10 = java.lang.String.valueOf(r10);
        r1 = r10.length();
        if (r1 == 0) goto L_0x007d;
    L_0x0078:
        r10 = r0.concat(r10);
        goto L_0x0082;
    L_0x007d:
        r10 = new java.lang.String;
        r10.<init>(r0);
    L_0x0082:
        com.google.android.gms.tagmanager.zzdj.e(r10);
        r10 = com.google.android.gms.tagmanager.zzgk.zzbil();
        return r10;
    L_0x008a:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r5 = r0.type;
        r6 = 0;
        switch(r5) {
            case 2: goto L_0x00c3;
            case 3: goto L_0x009d;
            default: goto L_0x0095;
        };
    L_0x0095:
        r0 = com.google.android.gms.tagmanager.zzgk.zzd(r0);
        zza(r10, r0, r3, r4);
        goto L_0x00dd;
    L_0x009d:
        r5 = r0.zzym;
        r5 = r5.length;
        if (r6 >= r5) goto L_0x00dd;
    L_0x00a2:
        if (r6 <= 0) goto L_0x00a7;
    L_0x00a4:
        r10.append(r1);
    L_0x00a7:
        r5 = r0.zzym;
        r5 = r5[r6];
        r5 = com.google.android.gms.tagmanager.zzgk.zzd(r5);
        r7 = r0.zzyn;
        r7 = r7[r6];
        r7 = com.google.android.gms.tagmanager.zzgk.zzd(r7);
        zza(r10, r5, r3, r4);
        r10.append(r2);
        zza(r10, r7, r3, r4);
        r6 = r6 + 1;
        goto L_0x009d;
    L_0x00c3:
        r0 = r0.zzyl;
        r2 = r0.length;
        r5 = 1;
        r5 = 0;
        r7 = 1;
    L_0x00c9:
        if (r5 >= r2) goto L_0x00dd;
    L_0x00cb:
        r8 = r0[r5];
        if (r7 != 0) goto L_0x00d2;
    L_0x00cf:
        r10.append(r1);
    L_0x00d2:
        r7 = com.google.android.gms.tagmanager.zzgk.zzd(r8);
        zza(r10, r7, r3, r4);
        r5 = r5 + 1;
        r7 = 0;
        goto L_0x00c9;
    L_0x00dd:
        r10 = r10.toString();
        r10 = com.google.android.gms.tagmanager.zzgk.zzam(r10);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcy.zzx(java.util.Map):com.google.android.gms.internal.zzbt");
    }
}
