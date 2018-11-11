package com.iqoption.view.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.iqoption.activity.TradeRoomActivity;

/* compiled from: TradeFragmentHorizontalScrollView */
public class c extends BaseHorizontalScrollView {
    public c(Context context) {
        super(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        if (!(context instanceof TradeRoomActivity)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The context must be TradeRoomActivity, but was ");
            stringBuilder.append(context);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    @NonNull
    public TradeRoomActivity getTradeRoomActivity() {
        return (TradeRoomActivity) getContext();
    }
}
