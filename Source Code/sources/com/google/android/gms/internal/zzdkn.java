package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class zzdkn {
    private final List<zzdkj> zzlcg;
    private final List<zzdkj> zzlch;
    private final List<zzdkj> zzlci;
    private final List<zzdkj> zzlcj;
    private final List<zzdkj> zzldo;
    private final List<zzdkj> zzldp;
    private final List<String> zzldq;
    private final List<String> zzldr;
    private final List<String> zzlds;
    private final List<String> zzldt;

    private zzdkn(List<zzdkj> list, List<zzdkj> list2, List<zzdkj> list3, List<zzdkj> list4, List<zzdkj> list5, List<zzdkj> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
        this.zzlcg = Collections.unmodifiableList(list);
        this.zzlch = Collections.unmodifiableList(list2);
        this.zzlci = Collections.unmodifiableList(list3);
        this.zzlcj = Collections.unmodifiableList(list4);
        this.zzldo = Collections.unmodifiableList(list5);
        this.zzldp = Collections.unmodifiableList(list6);
        this.zzldq = Collections.unmodifiableList(list7);
        this.zzldr = Collections.unmodifiableList(list8);
        this.zzlds = Collections.unmodifiableList(list9);
        this.zzldt = Collections.unmodifiableList(list10);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlcg);
        String valueOf2 = String.valueOf(this.zzlch);
        String valueOf3 = String.valueOf(this.zzlci);
        String valueOf4 = String.valueOf(this.zzlcj);
        String valueOf5 = String.valueOf(this.zzldo);
        String valueOf6 = String.valueOf(this.zzldp);
        StringBuilder stringBuilder = new StringBuilder((((((String.valueOf(valueOf).length() + 102) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length());
        stringBuilder.append("Positive predicates: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("  Negative predicates: ");
        stringBuilder.append(valueOf2);
        stringBuilder.append("  Add tags: ");
        stringBuilder.append(valueOf3);
        stringBuilder.append("  Remove tags: ");
        stringBuilder.append(valueOf4);
        stringBuilder.append("  Add macros: ");
        stringBuilder.append(valueOf5);
        stringBuilder.append("  Remove macros: ");
        stringBuilder.append(valueOf6);
        return stringBuilder.toString();
    }

    public final List<zzdkj> zzbkf() {
        return this.zzlcg;
    }

    public final List<zzdkj> zzbkg() {
        return this.zzlch;
    }

    public final List<zzdkj> zzbkh() {
        return this.zzlci;
    }

    public final List<zzdkj> zzbki() {
        return this.zzlcj;
    }

    public final List<zzdkj> zzbkz() {
        return this.zzldo;
    }

    public final List<zzdkj> zzbla() {
        return this.zzldp;
    }
}
