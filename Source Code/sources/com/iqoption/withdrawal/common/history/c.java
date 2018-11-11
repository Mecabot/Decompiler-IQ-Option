package com.iqoption.withdrawal.common.history;

import io.card.payment.CardType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, aXE = {"Lcom/iqoption/withdrawal/common/history/CardData;", "", "cardType", "Lio/card/payment/CardType;", "lastDigits", "", "(Lio/card/payment/CardType;Ljava/lang/String;)V", "getCardType", "()Lio/card/payment/CardType;", "getLastDigits", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryHolders.kt */
public final class c {
    private final CardType bVS;
    private final String dRd;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.dRd, r3.dRd) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.withdrawal.common.history.c;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.withdrawal.common.history.c) r3;
        r0 = r2.bVS;
        r1 = r3.bVS;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.dRd;
        r3 = r3.dRd;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r3 = 0;
        return r3;
    L_0x001f:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.history.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        CardType cardType = this.bVS;
        int i = 0;
        int hashCode = (cardType != null ? cardType.hashCode() : 0) * 31;
        String str = this.dRd;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CardData(cardType=");
        stringBuilder.append(this.bVS);
        stringBuilder.append(", lastDigits=");
        stringBuilder.append(this.dRd);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(CardType cardType, String str) {
        h.e(cardType, "cardType");
        h.e(str, "lastDigits");
        this.bVS = cardType;
        this.dRd = str;
    }

    public final String aNF() {
        return this.dRd;
    }

    public final CardType getCardType() {
        return this.bVS;
    }
}
