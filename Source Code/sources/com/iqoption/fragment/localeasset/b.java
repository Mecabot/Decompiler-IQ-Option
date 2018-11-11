package com.iqoption.fragment.localeasset;

import com.iqoption.core.microservices.configuration.a.c;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006 "}, aXE = {"Lcom/iqoption/fragment/localeasset/LocaleAssetContryItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "country", "Lcom/iqoption/core/microservices/configuration/response/Country;", "(Lcom/iqoption/core/microservices/configuration/response/Country;)V", "countAsset", "", "getCountAsset", "()I", "setCountAsset", "(I)V", "getCountry", "()Lcom/iqoption/core/microservices/configuration/response/Country;", "id", "getId", "()Ljava/lang/Long;", "isArea", "", "()Z", "setArea", "(Z)V", "isSeleted", "setSeleted", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LocaleAssetContryItem.kt */
public final class b implements d<Long> {
    private boolean cEj;
    private boolean cEk;
    private final c cEl;
    private int countAsset;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.cEl, ((com.iqoption.fragment.localeasset.b) r2).cEl) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.fragment.localeasset.b;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.fragment.localeasset.b) r2;
        r0 = r1.cEl;
        r2 = r2.cEl;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.localeasset.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        c cVar = this.cEl;
        return cVar != null ? cVar.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocaleAssetContryItem(country=");
        stringBuilder.append(this.cEl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(c cVar) {
        h.e(cVar, "country");
        this.cEl = cVar;
    }

    public final c amw() {
        return this.cEl;
    }

    /* renamed from: getId */
    public Long Jf() {
        return this.cEl.Jf();
    }

    public final boolean amt() {
        return this.cEj;
    }

    public final void do(boolean z) {
        this.cEj = z;
    }

    public final boolean amu() {
        return this.cEk;
    }

    public final void dp(boolean z) {
        this.cEk = z;
    }

    public final int amv() {
        return this.countAsset;
    }

    public final void eX(int i) {
        this.countAsset = i;
    }
}
