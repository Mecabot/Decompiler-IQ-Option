package com.iqoption.deposit.card;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/airbnb/lottie/LottieComposition;", "invoke"})
/* compiled from: NfcScanFragment.kt */
final class NfcScanFragment$onFirstAnimationComplete$1 extends Lambda implements b<g, l> {
    final /* synthetic */ e this$0;

    NfcScanFragment$onFirstAnimationComplete$1(e eVar) {
        this.this$0 = eVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        h((g) obj);
        return l.etX;
    }

    public final void h(g gVar) {
        h.e(gVar, "it");
        if (this.this$0.isAdded()) {
            LottieAnimationView lottieAnimationView = e.c(this.this$0).cax;
            lottieAnimationView.setComposition(gVar);
            lottieAnimationView.w(true);
            lottieAnimationView.cT();
        }
    }
}
