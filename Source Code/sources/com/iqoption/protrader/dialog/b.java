package com.iqoption.protrader.dialog;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/protrader/dialog/ProTraderDialogFactory;", "", "()V", "showDialog", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "type", "Lcom/iqoption/protrader/dialog/ProTraderDialogType;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderDialogFactory.kt */
public final class b {
    public static final b deg = new b();

    private b() {
    }

    public static final void a(FragmentActivity fragmentActivity, ProTraderDialogType proTraderDialogType) {
        h.e(fragmentActivity, "activity");
        h.e(proTraderDialogType, Param.TYPE);
        switch (c.aoS[proTraderDialogType.ordinal()]) {
            case 1:
                a.ded.u(fragmentActivity);
                return;
            case 2:
                d.dei.u(fragmentActivity);
                return;
            default:
                return;
        }
    }
}
