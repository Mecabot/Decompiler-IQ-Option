package com.iqoption.withdrawal.common.history;

import com.iqoption.microservice.withdraw.response.l;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, aXE = {"Lcom/iqoption/withdrawal/common/history/PayoutItem;", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryAdapterItem;", "payout", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "mask", "", "minorUnits", "", "cancellationInProgress", "", "(Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;Ljava/lang/String;IZ)V", "getCancellationInProgress", "()Z", "getMask", "()Ljava/lang/String;", "getMinorUnits", "()I", "getPayout", "()Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getViewType", "hashCode", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryAdapterItems.kt */
public final class e extends k {
    private final int aVo;
    private final l dRe;
    private final boolean dRf;
    private final String mask;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (h.E(this.dRe, eVar.dRe) && h.E(this.mask, eVar.mask)) {
                if ((this.aVo == eVar.aVo ? 1 : null) != null) {
                    if ((this.dRf == eVar.dRf ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getViewType() {
        return 1;
    }

    public int hashCode() {
        l lVar = this.dRe;
        int i = 0;
        int hashCode = (lVar != null ? lVar.hashCode() : 0) * 31;
        String str = this.mask;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (((hashCode + i) * 31) + this.aVo) * 31;
        i = this.dRf;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PayoutItem(payout=");
        stringBuilder.append(this.dRe);
        stringBuilder.append(", mask=");
        stringBuilder.append(this.mask);
        stringBuilder.append(", minorUnits=");
        stringBuilder.append(this.aVo);
        stringBuilder.append(", cancellationInProgress=");
        stringBuilder.append(this.dRf);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final l aNG() {
        return this.dRe;
    }

    public final String getMask() {
        return this.mask;
    }

    public final int getMinorUnits() {
        return this.aVo;
    }

    public final boolean aNH() {
        return this.dRf;
    }

    public e(l lVar, String str, int i, boolean z) {
        h.e(lVar, "payout");
        h.e(str, "mask");
        super();
        this.dRe = lVar;
        this.mask = str;
        this.aVo = i;
        this.dRf = z;
    }
}
