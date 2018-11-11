package com.iqoption.deposit.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/airbnb/lottie/LottieComposition;", "invoke"})
/* compiled from: NfcScanFragment.kt */
final class NfcScanFragment$initViews$1 extends Lambda implements b<g, l> {
    final /* synthetic */ e this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/deposit/card/NfcScanFragment$initViews$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "deposit_release"})
    /* compiled from: NfcScanFragment.kt */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ LottieAnimationView bWs;
        final /* synthetic */ NfcScanFragment$initViews$1 bWt;
        final /* synthetic */ g bWu;

        a(LottieAnimationView lottieAnimationView, NfcScanFragment$initViews$1 nfcScanFragment$initViews$1, g gVar) {
            this.bWs = lottieAnimationView;
            this.bWt = nfcScanFragment$initViews$1;
            this.bWu = gVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.bWs.b(this);
            if (this.bWt.this$0.isAdded()) {
                this.bWt.this$0.abs();
            }
        }
    }

    NfcScanFragment$initViews$1(e eVar) {
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
            lottieAnimationView.cT();
            lottieAnimationView.a(new a(lottieAnimationView, this, gVar));
        }
    }
}
