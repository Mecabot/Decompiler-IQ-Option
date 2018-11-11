package com.iqoption.withdrawal.common.history;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, aXE = {"Lcom/iqoption/withdrawal/common/history/TitleItem;", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryAdapterItem;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getViewType", "", "hashCode", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryAdapterItems.kt */
public final class h extends k {
    private final String text;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.text, ((com.iqoption.withdrawal.common.history.h) r2).text) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.withdrawal.common.history.h;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.withdrawal.common.history.h) r2;
        r0 = r1.text;
        r2 = r2.text;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.history.h.equals(java.lang.Object):boolean");
    }

    public int getViewType() {
        return 0;
    }

    public int hashCode() {
        String str = this.text;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TitleItem(text=");
        stringBuilder.append(this.text);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public h(String str) {
        kotlin.jvm.internal.h.e(str, "text");
        super();
        this.text = str;
    }

    public final String getText() {
        return this.text;
    }
}
