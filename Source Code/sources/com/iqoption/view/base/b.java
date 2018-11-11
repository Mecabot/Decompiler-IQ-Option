package com.iqoption.view.base;

import android.content.Context;
import android.util.AttributeSet;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.fragment.cr;
import java.lang.ref.WeakReference;

/* compiled from: TradeFragmentFrameLayout */
public class b extends a {
    private WeakReference<cr> ckC;

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public cr getTradeFragment() {
        if (this.ckC == null) {
            this.ckC = new WeakReference(((TradeRoomActivity) getContext()).getTradeFragment());
        }
        cr crVar = (cr) this.ckC.get();
        if (crVar != null) {
            return crVar;
        }
        this.ckC = null;
        return ((TradeRoomActivity) getContext()).getTradeFragment();
    }
}
