package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzfgk<MessageType extends zzfgj<MessageType, BuilderType>, BuilderType extends zzfgk<MessageType, BuilderType>> implements zzfjd {
    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfhz.checkNotNull(iterable);
        if (iterable instanceof zzfil) {
            List zzdap = ((zzfil) iterable).zzdap();
            zzfil zzfil = (zzfil) list;
            int size = list.size();
            for (Object next : zzdap) {
                if (next == null) {
                    int size2 = zzfil.size() - size;
                    StringBuilder stringBuilder = new StringBuilder(37);
                    stringBuilder.append("Element at index ");
                    stringBuilder.append(size2);
                    stringBuilder.append(" is null.");
                    String stringBuilder2 = stringBuilder.toString();
                    for (int size3 = zzfil.size() - 1; size3 >= size; size3--) {
                        zzfil.remove(size3);
                    }
                    throw new NullPointerException(stringBuilder2);
                } else if (next instanceof zzfgs) {
                    zzfil.zzba((zzfgs) next);
                } else {
                    zzfil.add((String) next);
                }
            }
        } else if (iterable instanceof zzfjm) {
            list.addAll((Collection) iterable);
        } else {
            zzb((Iterable) iterable, (List) list);
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size = list.size();
        for (Object next : iterable) {
            if (next == null) {
                int size2 = list.size() - size;
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Element at index ");
                stringBuilder.append(size2);
                stringBuilder.append(" is null.");
                String stringBuilder2 = stringBuilder.toString();
                for (int size3 = list.size() - 1; size3 >= size; size3--) {
                    list.remove(size3);
                }
                throw new NullPointerException(stringBuilder2);
            }
            list.add(next);
        }
    }

    protected abstract BuilderType zza(MessageType messageType);

    /* renamed from: zza */
    public abstract BuilderType zzb(zzfhb zzfhb, zzfhm zzfhm);

    /* renamed from: zzcxj */
    public abstract BuilderType clone();

    public final /* synthetic */ zzfjd zzd(zzfjc zzfjc) {
        if (zzczu().getClass().isInstance(zzfjc)) {
            return zza((zzfgj) zzfjc);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
