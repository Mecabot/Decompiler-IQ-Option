package com.iqoption.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.iqoption.activity.TradeRoomActivity;

/* compiled from: IQDialogFragment */
public class e extends DialogFragment {
    protected boolean cvL = false;

    @Nullable
    public TradeRoomActivity getTradeRoomActivity() {
        FragmentActivity activity = zzakw();
        return activity instanceof TradeRoomActivity ? (TradeRoomActivity) activity : null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.cvL = true;
        bundle.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(bundle);
    }
}
