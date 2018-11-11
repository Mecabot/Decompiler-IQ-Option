package com.google.android.gms.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzfjn {
    private static final zzfjn zzprm = new zzfjn();
    private final zzfjw zzprn;
    private final ConcurrentMap<Class<?>, zzfjv<?>> zzpro = new ConcurrentHashMap();

    private zzfjn() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzfjw zzfjw = null;
        for (int i = 0; i <= 0; i++) {
            zzfjw = zzua(strArr[0]);
            if (zzfjw != null) {
                break;
            }
        }
        if (zzfjw == null) {
            zzfjw = new zzfiq();
        }
        this.zzprn = zzfjw;
    }

    public static zzfjn zzdbf() {
        return zzprm;
    }

    private static zzfjw zzua(String str) {
        try {
            return (zzfjw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> zzfjv<T> zzl(Class<T> cls) {
        zzfhz.zzc(cls, "messageType");
        zzfjv<T> zzfjv = (zzfjv) this.zzpro.get(cls);
        if (zzfjv != null) {
            return zzfjv;
        }
        zzfjv = this.zzprn.zzk(cls);
        zzfhz.zzc(cls, "messageType");
        zzfhz.zzc(zzfjv, "schema");
        zzfjv<T> zzfjv2 = (zzfjv) this.zzpro.putIfAbsent(cls, zzfjv);
        return zzfjv2 != null ? zzfjv2 : zzfjv;
    }
}
