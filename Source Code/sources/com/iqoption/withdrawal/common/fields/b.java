package com.iqoption.withdrawal.common.fields;

import android.view.View;
import android.widget.TextView;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawButtonHolder;", "", "container", "Landroid/view/View;", "(Landroid/view/View;)V", "button", "Landroid/widget/TextView;", "getButton", "()Landroid/widget/TextView;", "getContainer", "()Landroid/view/View;", "progress", "getProgress", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsFragment.kt */
public final class b {
    private final View agb;
    private final TextView bnd;
    private final View czX;

    public b(View view) {
        h.e(view, "container");
        this.agb = view;
        view = this.agb.findViewById(R.id.withdrawButton);
        h.d(view, "container.findViewById(R.id.withdrawButton)");
        this.bnd = (TextView) view;
        view = this.agb.findViewById(R.id.withdrawButtonProgress);
        h.d(view, "container.findViewById(R…d.withdrawButtonProgress)");
        this.czX = view;
    }

    public final TextView aNa() {
        return this.bnd;
    }

    public final View aNb() {
        return this.czX;
    }
}
