package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzfhq<FieldDescriptorType extends zzfhs<FieldDescriptorType>> {
    private static final zzfhq zzppc = new zzfhq(true);
    private boolean zzldh;
    private final zzfjy<FieldDescriptorType, Object> zzppa = zzfjy.zzmq(16);
    private boolean zzppb = false;

    private zzfhq() {
    }

    private zzfhq(boolean z) {
        if (!this.zzldh) {
            this.zzppa.zzbkr();
            this.zzldh = true;
        }
    }

    static int zza(zzfky zzfky, int i, Object obj) {
        i = zzfhg.zzlw(i);
        if (zzfky == zzfky.GROUP) {
            zzfhz.zzh((zzfjc) obj);
            i <<= 1;
        }
        return i + zzb(zzfky, obj);
    }

    public static Object zza(zzfhb zzfhb, zzfky zzfky, boolean z) {
        zzfle zzfle = zzfle.STRICT;
        switch (zzfkx.zzppe[zzfky.ordinal()]) {
            case 1:
                return Double.valueOf(zzfhb.readDouble());
            case 2:
                return Float.valueOf(zzfhb.readFloat());
            case 3:
                return Long.valueOf(zzfhb.zzcxz());
            case 4:
                return Long.valueOf(zzfhb.zzcxy());
            case 5:
                return Integer.valueOf(zzfhb.zzcya());
            case 6:
                return Long.valueOf(zzfhb.zzcyb());
            case 7:
                return Integer.valueOf(zzfhb.zzcyc());
            case 8:
                return Boolean.valueOf(zzfhb.zzcyd());
            case 9:
                return zzfhb.zzcyf();
            case 10:
                return Integer.valueOf(zzfhb.zzcyg());
            case 11:
                return Integer.valueOf(zzfhb.zzcyi());
            case 12:
                return Long.valueOf(zzfhb.zzcyj());
            case 13:
                return Integer.valueOf(zzfhb.zzcyk());
            case 14:
                return Long.valueOf(zzfhb.zzcyl());
            case 15:
                return zzfle.zza(zzfhb);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    static void zza(zzfhg zzfhg, zzfky zzfky, int i, Object obj) {
        if (zzfky == zzfky.GROUP) {
            zzfjc zzfjc = (zzfjc) obj;
            zzfhz.zzh(zzfjc);
            zzfhg.zze(i, zzfjc);
            return;
        }
        zzfhg.zzac(i, zzfky.zzdcj());
        switch (zzfky) {
            case DOUBLE:
                zzfhg.zzn(((Double) obj).doubleValue());
                return;
            case FLOAT:
                zzfhg.zzf(((Float) obj).floatValue());
                return;
            case INT64:
                zzfhg.zzcu(((Long) obj).longValue());
                return;
            case UINT64:
                zzfhg.zzcu(((Long) obj).longValue());
                return;
            case INT32:
                zzfhg.zzls(((Integer) obj).intValue());
                return;
            case FIXED64:
                zzfhg.zzcw(((Long) obj).longValue());
                return;
            case FIXED32:
                zzfhg.zzlv(((Integer) obj).intValue());
                return;
            case BOOL:
                zzfhg.zzdl(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((zzfjc) obj).zza(zzfhg);
                return;
            case MESSAGE:
                zzfhg.zze((zzfjc) obj);
                return;
            case STRING:
                if (obj instanceof zzfgs) {
                    zzfhg.zzay((zzfgs) obj);
                    return;
                } else {
                    zzfhg.zztw((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof zzfgs) {
                    zzfhg.zzay((zzfgs) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfhg.zzj(bArr, 0, bArr.length);
                return;
            case UINT32:
                zzfhg.zzlt(((Integer) obj).intValue());
                return;
            case SFIXED32:
                zzfhg.zzlv(((Integer) obj).intValue());
                return;
            case SFIXED64:
                zzfhg.zzcw(((Long) obj).longValue());
                return;
            case SINT32:
                zzfhg.zzlu(((Integer) obj).intValue());
                return;
            case SINT64:
                zzfhg.zzcv(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof zzfia) {
                    zzfhg.zzls(((zzfia) obj).zzhu());
                    return;
                } else {
                    zzfhg.zzls(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.zzczn()) {
            zza(fieldDescriptorType.zzczl(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fieldDescriptorType.zzczl(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfig) {
            this.zzppb = true;
        }
        this.zzppa.put((Comparable) fieldDescriptorType, obj);
    }

    /* JADX WARNING: Missing block: B:5:0x001b, code:
            if ((r3 instanceof com.google.android.gms.internal.zzfig) == false) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:9:0x0024, code:
            if ((r3 instanceof com.google.android.gms.internal.zzfia) == false) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:10:0x0026, code:
            r1 = true;
     */
    /* JADX WARNING: Missing block: B:14:0x002e, code:
            if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    private static void zza(com.google.android.gms.internal.zzfky r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.zzfhz.checkNotNull(r3);
        r0 = com.google.android.gms.internal.zzfhr.zzppd;
        r2 = r2.zzdci();
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003d;
            case 3: goto L_0x003a;
            case 4: goto L_0x0037;
            case 5: goto L_0x0034;
            case 6: goto L_0x0031;
            case 7: goto L_0x0028;
            case 8: goto L_0x001e;
            case 9: goto L_0x0015;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0043;
    L_0x0015:
        r2 = r3 instanceof com.google.android.gms.internal.zzfjc;
        if (r2 != 0) goto L_0x0026;
    L_0x0019:
        r2 = r3 instanceof com.google.android.gms.internal.zzfig;
        if (r2 == 0) goto L_0x0043;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = r3 instanceof com.google.android.gms.internal.zzfia;
        if (r2 == 0) goto L_0x0043;
    L_0x0026:
        r1 = 1;
        goto L_0x0043;
    L_0x0028:
        r2 = r3 instanceof com.google.android.gms.internal.zzfgs;
        if (r2 != 0) goto L_0x0026;
    L_0x002c:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0043;
    L_0x0030:
        goto L_0x0026;
    L_0x0031:
        r0 = r3 instanceof java.lang.String;
        goto L_0x0042;
    L_0x0034:
        r0 = r3 instanceof java.lang.Boolean;
        goto L_0x0042;
    L_0x0037:
        r0 = r3 instanceof java.lang.Double;
        goto L_0x0042;
    L_0x003a:
        r0 = r3 instanceof java.lang.Float;
        goto L_0x0042;
    L_0x003d:
        r0 = r3 instanceof java.lang.Long;
        goto L_0x0042;
    L_0x0040:
        r0 = r3 instanceof java.lang.Integer;
    L_0x0042:
        r1 = r0;
    L_0x0043:
        if (r1 != 0) goto L_0x004d;
    L_0x0045:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhq.zza(com.google.android.gms.internal.zzfky, java.lang.Object):void");
    }

    private static int zzb(zzfhs<?> zzfhs, Object obj) {
        zzfky zzczl = zzfhs.zzczl();
        int zzhu = zzfhs.zzhu();
        if (!zzfhs.zzczn()) {
            return zza(zzczl, zzhu, obj);
        }
        int i = 0;
        if (zzfhs.zzczo()) {
            for (Object obj2 : (List) obj2) {
                i += zzb(zzczl, obj2);
            }
            return (zzfhg.zzlw(zzhu) + i) + zzfhg.zzmf(i);
        }
        for (Object obj22 : (List) obj22) {
            i += zza(zzczl, zzhu, obj22);
        }
        return i;
    }

    private static int zzb(zzfky zzfky, Object obj) {
        switch (zzfky) {
            case DOUBLE:
                return zzfhg.zzo(((Double) obj).doubleValue());
            case FLOAT:
                return zzfhg.zzg(((Float) obj).floatValue());
            case INT64:
                return zzfhg.zzcx(((Long) obj).longValue());
            case UINT64:
                return zzfhg.zzcy(((Long) obj).longValue());
            case INT32:
                return zzfhg.zzlx(((Integer) obj).intValue());
            case FIXED64:
                return zzfhg.zzda(((Long) obj).longValue());
            case FIXED32:
                return zzfhg.zzma(((Integer) obj).intValue());
            case BOOL:
                return zzfhg.zzdm(((Boolean) obj).booleanValue());
            case GROUP:
                return zzfhg.zzg((zzfjc) obj);
            case MESSAGE:
                return obj instanceof zzfig ? zzfhg.zza((zzfig) obj) : zzfhg.zzf((zzfjc) obj);
            case STRING:
                return obj instanceof zzfgs ? zzfhg.zzaz((zzfgs) obj) : zzfhg.zztx((String) obj);
            case BYTES:
                return obj instanceof zzfgs ? zzfhg.zzaz((zzfgs) obj) : zzfhg.zzbd((byte[]) obj);
            case UINT32:
                return zzfhg.zzly(((Integer) obj).intValue());
            case SFIXED32:
                return zzfhg.zzmb(((Integer) obj).intValue());
            case SFIXED64:
                return zzfhg.zzdb(((Long) obj).longValue());
            case SINT32:
                return zzfhg.zzlz(((Integer) obj).intValue());
            case SINT64:
                return zzfhg.zzcz(((Long) obj).longValue());
            case ENUM:
                return obj instanceof zzfia ? zzfhg.zzmc(((zzfia) obj).zzhu()) : zzfhg.zzmc(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(Entry<FieldDescriptorType, Object> entry) {
        zzfhs zzfhs = (zzfhs) entry.getKey();
        Object value = entry.getValue();
        return (zzfhs.zzczm() != zzfld.MESSAGE || zzfhs.zzczn() || zzfhs.zzczo()) ? zzb(zzfhs, value) : value instanceof zzfig ? zzfhg.zzb(((zzfhs) entry.getKey()).zzhu(), (zzfig) value) : zzfhg.zzd(((zzfhs) entry.getKey()).zzhu(), (zzfjc) value);
    }

    public static <T extends zzfhs<T>> zzfhq<T> zzczj() {
        return zzppc;
    }

    public final /* synthetic */ Object clone() {
        Entry zzmr;
        zzfhq zzfhq = new zzfhq();
        for (int i = 0; i < this.zzppa.zzdbp(); i++) {
            zzmr = this.zzppa.zzmr(i);
            zzfhq.zza((zzfhs) zzmr.getKey(), zzmr.getValue());
        }
        for (Entry zzmr2 : this.zzppa.zzdbq()) {
            zzfhq.zza((zzfhs) zzmr2.getKey(), zzmr2.getValue());
        }
        zzfhq.zzppb = this.zzppb;
        return zzfhq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfhq)) {
            return false;
        }
        return this.zzppa.equals(((zzfhq) obj).zzppa);
    }

    public final int hashCode() {
        return this.zzppa.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzppb ? new zzfij(this.zzppa.entrySet().iterator()) : this.zzppa.entrySet().iterator();
    }

    public final int zzczk() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzppa.zzdbp(); i2++) {
            i += zzb(this.zzppa.zzmr(i2));
        }
        for (Entry zzb : this.zzppa.zzdbq()) {
            i += zzb(zzb);
        }
        return i;
    }
}
