package com.iqoption.withdrawal.common.fields.verify;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.iqoption.core.ext.a;
import com.iqoption.d.uu;
import com.iqoption.x.R;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u001c\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyWarningAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyWarningHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/iqoption/withdrawal/common/fields/verify/WarningListener;", "(Landroid/content/Context;Lcom/iqoption/withdrawal/common/fields/verify/WarningListener;)V", "getContext", "()Landroid/content/Context;", "items", "", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "screenWidth", "", "getItemCount", "item", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "cards", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawVerifyWarningAdapter.kt */
public final class h extends Adapter<i> {
    private final Context context;
    private int dQW;
    private final f dQX;
    private List<? extends d> nj = m.emptyList();

    public h(Context context, f fVar) {
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(fVar, "listener");
        this.context = context;
        this.dQX = fVar;
    }

    public int getItemCount() {
        return this.nj.size();
    }

    private final d hz(int i) {
        return (d) this.nj.get(i);
    }

    /* renamed from: ag */
    public i onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        return new i((uu) a.a(viewGroup, (int) R.layout.fragment_withdraw_verify_page, viewGroup, false, 4, null), this.dQX);
    }

    /* renamed from: a */
    public void onBindViewHolder(i iVar, int i) {
        kotlin.jvm.internal.h.e(iVar, "holder");
        iVar.a(hz(i), this.dQW);
    }

    public final void c(List<? extends d> list, int i) {
        kotlin.jvm.internal.h.e(list, "cards");
        this.dQW = i;
        List list2 = this.nj;
        this.nj = list;
        DiffUtil.calculateDiff(new b(list2, list)).dispatchUpdatesTo((Adapter) this);
    }
}
