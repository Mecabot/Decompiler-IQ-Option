package com.iqoption.deposit.b;

import android.widget.TextView;
import com.iqoption.deposit.a.ay;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/presets/PresetWithBadgeViewHolder;", "Lcom/iqoption/deposit/presets/BasePresetViewHolder;", "Lcom/iqoption/deposit/databinding/ItemPresetWithBadgeBinding;", "binding", "listener", "Lcom/iqoption/deposit/presets/OnPresetClickListener;", "(Lcom/iqoption/deposit/databinding/ItemPresetWithBadgeBinding;Lcom/iqoption/deposit/presets/OnPresetClickListener;)V", "presetAmount", "Landroid/widget/TextView;", "deposit_release"})
/* compiled from: PresetWithBadgeViewHolder.kt */
public final class e extends a<ay> {
    public e(ay ayVar, b bVar) {
        h.e(ayVar, "binding");
        h.e(bVar, "listener");
        super(ayVar, bVar);
    }

    public TextView adW() {
        return ((ay) getBinding()).bZL.bZM;
    }
}
