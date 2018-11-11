package com.iqoption.deposit.constructor.selector.integer;

import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, aXE = {"Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "fieldName", "", "value", "isSelected", "", "(Ljava/lang/String;IZ)V", "getFieldName", "()Ljava/lang/String;", "id", "getId", "()Ljava/lang/Integer;", "()Z", "getValue", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "deposit_release"})
/* compiled from: SelectorIntegerAdapterItem.kt */
public final class b implements d<Integer> {
    private final String fieldName;
    private final boolean isSelected;
    private final int value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(this.fieldName, bVar.fieldName)) {
                if ((this.value == bVar.value ? 1 : null) != null) {
                    if ((this.isSelected == bVar.isSelected ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.fieldName;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.value) * 31;
        int i = this.isSelected;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SelectorIntegerAdapterItem(fieldName=");
        stringBuilder.append(this.fieldName);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", isSelected=");
        stringBuilder.append(this.isSelected);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(String str, int i, boolean z) {
        h.e(str, "fieldName");
        this.fieldName = str;
        this.value = i;
        this.isSelected = z;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    /* renamed from: Je */
    public Integer Jf() {
        return Integer.valueOf(this.value);
    }
}
