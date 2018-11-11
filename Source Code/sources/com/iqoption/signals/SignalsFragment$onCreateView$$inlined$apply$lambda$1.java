package com.iqoption.signals;

import android.view.View;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.d.sf;
import com.iqoption.widget.a.a;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "invoke", "com/iqoption/signals/SignalsFragment$onCreateView$1$showFilterListener$1"})
/* compiled from: SignalsFragment.kt */
final class SignalsFragment$onCreateView$$inlined$apply$lambda$1 extends Lambda implements b<View, l> {
    final /* synthetic */ sf receiver$0;
    final /* synthetic */ i this$0;

    SignalsFragment$onCreateView$$inlined$apply$lambda$1(sf sfVar, i iVar) {
        this.receiver$0 = sfVar;
        this.this$0 = iVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        H((View) obj);
        return l.etX;
    }

    public final void H(View view) {
        h.e(view, "<anonymous parameter 0>");
        if (!this.this$0.aEc().isShowing()) {
            a a = this.this$0.aEc();
            TextView textView = this.receiver$0.agA;
            h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            a.L(textView);
        }
    }
}
