package com.iqoption.chat.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.ext.a;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"openImage", "", "url", "", "subTitle", "invoke", "com/iqoption/chat/fragment/RoomFragment$onViewCreated$9$5"})
/* compiled from: RoomFragment.kt */
final class RoomFragment$onViewCreated$$inlined$apply$lambda$7 extends Lambda implements m<String, String, l> {
    final /* synthetic */ x this$0;

    RoomFragment$onViewCreated$$inlined$apply$lambda$7(x xVar) {
        this.this$0 = xVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        Z((String) obj, (String) obj2);
        return l.etX;
    }

    public final void Z(String str, String str2) {
        h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
        h.e(str2, "subTitle");
        FragmentManager p = a.p(this.this$0);
        FragmentTransaction beginTransaction = p.beginTransaction();
        h.d(beginTransaction, "ft");
        l Y = l.aGr.Y(str, str2);
        str2 = l.aGr.Ll();
        beginTransaction.add(R.id.dialogLayer, Y, str2);
        beginTransaction.addToBackStack(str2);
        beginTransaction.commitAllowingStateLoss();
        p.executePendingTransactions();
    }
}
