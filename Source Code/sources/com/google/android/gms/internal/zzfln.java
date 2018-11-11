package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzfln<M extends zzflm<M>, T> {
    public final int tag;
    private int type;
    protected final Class<T> zznro;
    private zzfhu<?, ?> zzppk;
    protected final boolean zzpvm;

    private zzfln(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, i2, false);
    }

    private zzfln(int i, Class<T> cls, zzfhu<?, ?> zzfhu, int i2, boolean z) {
        this.type = i;
        this.zznro = cls;
        this.tag = i2;
        this.zzpvm = false;
        this.zzppk = null;
    }

    public static <M extends zzflm<M>, T extends zzfls> zzfln<M, T> zza(int i, Class<T> cls, long j) {
        return new zzfln(11, cls, (int) j, false);
    }

    private final Object zzbj(zzflj zzflj) {
        String valueOf;
        Class componentType = this.zzpvm ? this.zznro.getComponentType() : this.zznro;
        StringBuilder stringBuilder;
        try {
            zzfls zzfls;
            switch (this.type) {
                case 10:
                    zzfls = (zzfls) componentType.newInstance();
                    zzflj.zza(zzfls, this.tag >>> 3);
                    return zzfls;
                case 11:
                    zzfls = (zzfls) componentType.newInstance();
                    zzflj.zza(zzfls);
                    return zzfls;
                default:
                    int i = this.type;
                    stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 33);
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 33);
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfln)) {
            return false;
        }
        zzfln zzfln = (zzfln) obj;
        return this.type == zzfln.type && this.zznro == zzfln.zznro && this.tag == zzfln.tag && this.zzpvm == zzfln.zzpvm;
    }

    public final int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zznro.hashCode()) * 31) + this.tag) * 31) + this.zzpvm;
    }

    protected final void zza(Object obj, zzflk zzflk) {
        try {
            zzflk.zzmy(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzfls) obj).zza(zzflk);
                    zzflk.zzac(i, 4);
                    return;
                case 11:
                    zzflk.zzb((zzfls) obj);
                    return;
                default:
                    int i2 = this.type;
                    StringBuilder stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i2);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final T zzbq(List<zzflu> list) {
        if (list == null) {
            return null;
        }
        if (this.zzpvm) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                zzflu zzflu = (zzflu) list.get(i);
                if (zzflu.zzjwl.length != 0) {
                    arrayList.add(zzbj(zzflj.zzbe(zzflu.zzjwl)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.zznro.cast(Array.newInstance(this.zznro.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zznro.cast(zzbj(zzflj.zzbe(((zzflu) list.get(list.size() - 1)).zzjwl)));
        }
    }

    protected final int zzcw(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzflk.zzlw(i) << 1) + ((zzfls) obj).zzhs();
            case 11:
                return zzflk.zzb(i, (zzfls) obj);
            default:
                i = this.type;
                StringBuilder stringBuilder = new StringBuilder(24);
                stringBuilder.append("Unknown type ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
