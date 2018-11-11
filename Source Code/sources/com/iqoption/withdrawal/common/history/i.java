package com.iqoption.withdrawal.common.history;

import android.widget.TextView;
import com.iqoption.d.amp;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lcom/iqoption/withdrawal/common/history/TitleViewHolder;", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewHolder;", "binding", "Lcom/iqoption/databinding/WithdrawHistoryTitleItemBinding;", "(Lcom/iqoption/databinding/WithdrawHistoryTitleItemBinding;)V", "getBinding", "()Lcom/iqoption/databinding/WithdrawHistoryTitleItemBinding;", "bind", "", "item", "Lcom/iqoption/withdrawal/common/history/TitleItem;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryHolders.kt */
public final class i extends n {
    private final amp dRk;

    public i(amp amp) {
        h.e(amp, "binding");
        super(amp);
        this.dRk = amp;
    }

    public final void a(h hVar) {
        h.e(hVar, "item");
        TextView textView = this.dRk.bUZ;
        h.d(textView, "binding.withdrawHistoryTitle");
        textView.setText(hVar.getText());
    }
}
