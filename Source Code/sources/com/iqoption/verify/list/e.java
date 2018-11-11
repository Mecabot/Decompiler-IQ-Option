package com.iqoption.verify.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.d.ala;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\fJ\u0014\u0010\u001d\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/verify/list/VerifyCardViewHolder;", "context", "Landroid/content/Context;", "verifyCardListener", "Lcom/iqoption/verify/list/VerifyCardListener;", "(Landroid/content/Context;Lcom/iqoption/verify/list/VerifyCardListener;)V", "getContext", "()Landroid/content/Context;", "items", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "getItemCount", "", "item", "position", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickedCard", "clickedCard", "setData", "cards", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VarifyCardsAdapter.kt */
public final class e extends Adapter<c> {
    private final Context context;
    private final b dxJ;
    private List<q> nj = m.emptyList();

    public e(Context context, b bVar) {
        h.e(context, "context");
        h.e(bVar, "verifyCardListener");
        this.context = context;
        this.dxJ = bVar;
    }

    public int getItemCount() {
        return this.nj.size();
    }

    private final q gJ(int i) {
        return (q) this.nj.get(i);
    }

    /* renamed from: aa */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        ala ala = (ala) DataBindingUtil.inflate(LayoutInflater.from(this.context), R.layout.verify_card_item, viewGroup, false);
        h.d(ala, "binding");
        return new c(ala, this.dxJ);
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i, List<Object> list) {
        h.e(cVar, "holder");
        h.e(list, "payloads");
        cVar.g(gJ(i));
        if (!list.isEmpty() && list.get(0) == ItemState.CLICKED) {
            cVar.aGS();
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        h.e(cVar, "holder");
        onBindViewHolder(cVar, i, new ArrayList());
    }

    public final void aR(List<q> list) {
        h.e(list, "cards");
        List list2 = this.nj;
        this.nj = list;
        DiffUtil.calculateDiff(new a(list2, list)).dispatchUpdatesTo((Adapter) this);
    }

    public final void j(q qVar) {
        int i = u.i(this.nj, (Object) qVar);
        if (i >= 0) {
            notifyItemChanged(i, ItemState.CLICKED);
        }
    }
}
