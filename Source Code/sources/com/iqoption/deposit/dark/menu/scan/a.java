package com.iqoption.deposit.dark.menu.scan;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.deposit.a.ba;
import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import com.iqoption.deposit.r.g;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, aXE = {"Lcom/iqoption/deposit/dark/menu/scan/ScanCardDarkAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/iqoption/deposit/dark/menu/scan/ScanCardDarkViewHolder;", "listener", "Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;", "(Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;)V", "items", "", "Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "getListener", "()Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "deposit_release"})
/* compiled from: ScanCardDarkAdapter.kt */
public final class a extends Adapter<b> {
    private final com.iqoption.deposit.menu.a.a bYl;
    private final List<ScanItem> nj = m.listOf(ScanItem.CAMERA, ScanItem.NFC);

    public a(com.iqoption.deposit.menu.a.a aVar) {
        h.e(aVar, "listener");
        this.bYl = aVar;
    }

    /* renamed from: q */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), g.item_scan_card, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…scan_card, parent, false)");
        return new b((ba) inflate, this.bYl);
    }

    public int getItemCount() {
        return this.nj.size();
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        h.e(bVar, "holder");
        bVar.c((ScanItem) this.nj.get(i));
    }
}
