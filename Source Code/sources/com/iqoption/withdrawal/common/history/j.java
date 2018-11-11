package com.iqoption.withdrawal.common.history;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.app.a;
import com.iqoption.d.amn;
import com.iqoption.d.amp;
import com.iqoption.microservice.withdraw.response.l;
import com.iqoption.portfolio.component.o;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u0018J\u0016\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006("}, aXE = {"Lcom/iqoption/withdrawal/common/history/WithdrawHistoryAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewHolder;", "context", "Landroid/content/Context;", "cancelClickListener", "Lcom/iqoption/withdrawal/common/history/CancelClickListener;", "(Landroid/content/Context;Lcom/iqoption/withdrawal/common/history/CancelClickListener;)V", "getContext", "()Landroid/content/Context;", "iqAccount", "Lcom/iqoption/app/IQAccount;", "kotlin.jvm.PlatformType", "items", "", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryAdapterItem;", "uiConfig", "Lcom/iqoption/portfolio/component/UIConfig;", "getItemCount", "", "getItemViewType", "position", "item", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "adapterData", "Lcom/iqoption/withdrawal/common/history/AdapterData;", "showError", "showProgress", "updateItems", "newItems", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryAdapter.kt */
public final class j extends Adapter<n> {
    private o cYW;
    private final Context context;
    private final b dRh;
    private final a dRl = a.aL(this.context);
    private List<? extends k> nj = m.emptyList();

    public j(Context context, b bVar) {
        h.e(context, "context");
        h.e(bVar, "cancelClickListener");
        this.context = context;
        this.dRh = bVar;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.cYW = new o(recyclerView.getContext());
    }

    public int getItemCount() {
        return this.nj.size();
    }

    public int getItemViewType(int i) {
        return hA(i).getViewType();
    }

    private final k hA(int i) {
        return (k) this.nj.get(i);
    }

    /* renamed from: ah */
    public n onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(this.context);
        ViewDataBinding inflate;
        switch (i) {
            case 0:
                inflate = DataBindingUtil.inflate(from, R.layout.withdraw_history_title_item, viewGroup, false);
                h.d(inflate, "DataBindingUtil.inflate(…itle_item, parent, false)");
                return new i((amp) inflate);
            case 1:
                inflate = DataBindingUtil.inflate(from, R.layout.withdraw_history_payout_item, viewGroup, false);
                h.d(inflate, "DataBindingUtil.inflate(…yout_item, parent, false)");
                amn amn = (amn) inflate;
                o oVar = this.cYW;
                if (oVar == null) {
                    h.lS("uiConfig");
                }
                return new f(amn, oVar, this.dRh);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected viewType: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(n nVar, int i) {
        h.e(nVar, "holder");
        k hA;
        if (nVar instanceof i) {
            i iVar = (i) nVar;
            hA = hA(i);
            if (hA == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.withdrawal.common.history.TitleItem");
            }
            iVar.a((h) hA);
        } else if (nVar instanceof f) {
            f fVar = (f) nVar;
            hA = hA(i);
            if (hA == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.withdrawal.common.history.PayoutItem");
            }
            fVar.a((e) hA);
        }
    }

    public final void arc() {
        String string = this.context.getString(R.string.loading);
        h.d(string, "context.getString(R.string.loading)");
        bF(l.cr(new h(string)));
    }

    public final void zy() {
        String string = this.context.getString(R.string.unable_to_load_transactions);
        h.d(string, "context.getString(R.stri…ble_to_load_transactions)");
        bF(l.cr(new h(string)));
    }

    public final void a(a aVar) {
        String string;
        h.e(aVar, "adapterData");
        List arrayList = new ArrayList();
        List<l> aND = aVar.aND();
        if (aND.isEmpty()) {
            string = this.context.getString(R.string.you_have_no_transactions_yet);
        } else {
            string = this.context.getString(R.string.withdrawal_requests);
        }
        h.d(string, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        arrayList.add(new h(string));
        Set aNE = aVar.aNE();
        for (l lVar : aND) {
            String currency = lVar.getCurrency();
            String eg = this.dRl.eg(currency);
            int g = com.iqoption.util.l.g(this.dRl.eh(currency));
            h.d(eg, "mask");
            arrayList.add(new e(lVar, eg, g, aNE.contains(Long.valueOf(lVar.getId()))));
        }
        bF(arrayList);
    }

    private final void bF(List<? extends k> list) {
        List list2 = this.nj;
        this.nj = list;
        DiffUtil.calculateDiff(new d(list2, list)).dispatchUpdatesTo((Adapter) this);
    }
}
