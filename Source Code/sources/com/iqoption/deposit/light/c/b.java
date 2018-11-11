package com.iqoption.deposit.light.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ext.a;
import com.iqoption.deposit.a.aw;
import com.iqoption.deposit.b.c;
import com.iqoption.deposit.r;
import com.iqoption.deposit.r.e;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/deposit/light/presets/PresetLightViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/deposit/databinding/ItemPresetLightBinding;", "listener", "Lcom/iqoption/deposit/light/presets/OnPresetLightClickListener;", "(Lcom/iqoption/deposit/databinding/ItemPresetLightBinding;Lcom/iqoption/deposit/light/presets/OnPresetLightClickListener;)V", "getBinding", "()Lcom/iqoption/deposit/databinding/ItemPresetLightBinding;", "bound", "Lcom/iqoption/deposit/presets/PresetItem;", "bind", "", "item", "deposit_release"})
/* compiled from: PresetLightViewHolder.kt */
public final class b extends ViewHolder {
    private c cbj;
    private final aw cbk;

    public final aw adB() {
        return this.cbk;
    }

    public b(aw awVar, final a aVar) {
        h.e(awVar, "binding");
        h.e(aVar, "listener");
        super(awVar.getRoot());
        this.cbk = awVar;
        this.cbk.getRoot().setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b cbl;

            public final void onClick(View view) {
                a aVar = aVar;
                c a = this.cbl.cbj;
                if (a == null) {
                    h.aXZ();
                }
                aVar.a(a);
                FrameLayout frameLayout = this.cbl.adB().bZN;
                h.d(frameLayout, "binding.presetContainer");
                frameLayout.setSelected(true);
            }
        });
    }

    public final void b(c cVar) {
        int i;
        h.e(cVar, "item");
        this.cbj = cVar;
        TextView textView = this.cbk.bZM;
        textView.setText(com.iqoption.core.util.c.a(new BigDecimal(cVar.adX().UO()), 0, cVar.aaH().getMask(), true, false, null, 25, null));
        if (cVar.getSelected()) {
            i = r.c.black;
        } else {
            i = r.c.deposit_dark_grey;
        }
        Context context = textView.getContext();
        h.d(context, "context");
        textView.setTextColor(a.i(context, i));
        FrameLayout frameLayout = this.cbk.bZN;
        frameLayout.setSelected(cVar.getSelected());
        Context context2;
        ImageView imageView;
        if (h.E(cVar.adX().UP(), "vip")) {
            context2 = frameLayout.getContext();
            h.d(context2, "context");
            frameLayout.setBackground(a.l(context2, e.bg_grey_orange_rounded));
            imageView = this.cbk.bZO;
            h.d(imageView, "binding.presetVipBadge");
            a.L(imageView);
            return;
        }
        context2 = frameLayout.getContext();
        h.d(context2, "context");
        frameLayout.setBackground(a.l(context2, e.bg_grey_green_rounded));
        imageView = this.cbk.bZO;
        h.d(imageView, "binding.presetVipBadge");
        a.M(imageView);
    }
}
