package com.iqoption.deposit.light.menu.scan;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.deposit.a.bc;
import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import com.iqoption.deposit.r.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, aXE = {"Lcom/iqoption/deposit/light/menu/scan/ScanCardLightViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/deposit/databinding/ItemScanCardLightBinding;", "listener", "Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;", "(Lcom/iqoption/deposit/databinding/ItemScanCardLightBinding;Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;)V", "getBinding", "()Lcom/iqoption/deposit/databinding/ItemScanCardLightBinding;", "getListener", "()Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;", "bind", "", "scanItem", "Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "deposit_release"})
/* compiled from: ScanCardLightViewHolder.kt */
public final class b extends ViewHolder {
    private final com.iqoption.deposit.menu.a.a bYl;
    private final bc caQ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: ScanCardLightViewHolder.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ ScanItem bYo;
        final /* synthetic */ b caR;

        a(b bVar, ScanItem scanItem) {
            this.caR = bVar;
            this.bYo = scanItem;
        }

        public final void onClick(View view) {
            this.caR.acZ().d(this.bYo);
        }
    }

    public b(bc bcVar, com.iqoption.deposit.menu.a.a aVar) {
        h.e(bcVar, "binding");
        h.e(aVar, "listener");
        super(bcVar.getRoot());
        this.caQ = bcVar;
        this.bYl = aVar;
    }

    public final com.iqoption.deposit.menu.a.a acZ() {
        return this.bYl;
    }

    public final void c(ScanItem scanItem) {
        int i;
        h.e(scanItem, "scanItem");
        switch (scanItem) {
            case CAMERA:
                i = e.ic_scan_light;
                break;
            case NFC:
                i = e.ic_nfc_light;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.caQ.bZR.setImageResource(i);
        this.caQ.bZS.setText(scanItem.getTitleRes());
        this.caQ.getRoot().setOnClickListener(new a(this, scanItem));
    }
}
