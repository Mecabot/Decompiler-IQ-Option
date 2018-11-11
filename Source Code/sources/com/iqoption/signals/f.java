package com.iqoption.signals;

import com.google.android.gms.plus.PlusShare;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/signals/SignalTitleItem;", "Lcom/iqoption/signals/AdapterItem;", "title", "", "(Ljava/lang/String;)V", "id", "getId", "()Ljava/lang/String;", "getTitle", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: _AdapterItems.kt */
public final class f extends a {
    private final String id;
    private final String title;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.title, ((com.iqoption.signals.f) r2).title) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.signals.f;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.signals.f) r2;
        r0 = r1.title;
        r2 = r2.title;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.signals.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.title;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignalTitleItem(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(String str) {
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        super();
        this.title = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("title:");
        stringBuilder.append(this.title);
        this.id = stringBuilder.toString();
    }

    public final String getTitle() {
        return this.title;
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
