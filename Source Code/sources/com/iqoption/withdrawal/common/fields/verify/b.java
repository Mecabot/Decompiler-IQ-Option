package com.iqoption.withdrawal.common.fields.verify;

import android.support.v7.util.DiffUtil.Callback;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/DiffUtilCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "oldItems", "", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "newItems", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawVerifyWarningAdapter.kt */
final class b extends Callback {
    private final List<d> dxB;
    private final List<d> dxC;

    public b(List<? extends d> list, List<? extends d> list2) {
        h.e(list, "oldItems");
        h.e(list2, "newItems");
        this.dxB = list;
        this.dxC = list2;
    }

    public int getOldListSize() {
        return this.dxB.size();
    }

    public int getNewListSize() {
        return this.dxC.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return ((d) this.dxB.get(i)).aNr() == ((d) this.dxC.get(i2)).aNr();
    }

    public boolean areContentsTheSame(int i, int i2) {
        return h.E((d) this.dxB.get(i), (d) this.dxC.get(i2));
    }
}
