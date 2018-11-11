package com.iqoption.deposit.old;

import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\b\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, aXE = {"Lcom/iqoption/deposit/old/PayMethodItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "selected", "", "(Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;Z)V", "id", "getId", "()Ljava/lang/String;", "getPayMethod", "()Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PayMethodItem.kt */
public final class e implements d<String> {
    private final PayMethod bVQ;
    private boolean selected;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (h.E(this.bVQ, eVar.bVQ)) {
                if ((this.selected == eVar.selected ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        PayMethod payMethod = this.bVQ;
        int hashCode = (payMethod != null ? payMethod.hashCode() : 0) * 31;
        int i = this.selected;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PayMethodItem(payMethod=");
        stringBuilder.append(this.bVQ);
        stringBuilder.append(", selected=");
        stringBuilder.append(this.selected);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(PayMethod payMethod, boolean z) {
        h.e(payMethod, "payMethod");
        this.bVQ = payMethod;
        this.selected = z;
    }

    public final PayMethod aaT() {
        return this.bVQ;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: getId */
    public String Jf() {
        return com.iqoption.core.microservices.billing.response.deposit.e.e(this.bVQ);
    }
}
