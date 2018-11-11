package com.iqoption.chat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, aXE = {"Lcom/iqoption/chat/ProgressLottieStateSwitcher;", "Lcom/iqoption/chat/LottieStateSwitcher;", "view", "Lcom/airbnb/lottie/LottieAnimationView;", "states", "", "(Lcom/airbnb/lottie/LottieAnimationView;[F)V", "value", "", "current", "getCurrent", "()I", "setCurrent", "(I)V", "getView", "()Lcom/airbnb/lottie/LottieAnimationView;", "canBackward", "", "canForward", "reset", "", "switchBackward", "switchForward", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LottieStateSwitcher.kt */
public final class c implements b {
    private int aCH;
    private final LottieAnimationView aCI;
    private final float[] aCJ;

    public c(LottieAnimationView lottieAnimationView, float[] fArr) {
        h.e(lottieAnimationView, Promotion.ACTION_VIEW);
        h.e(fArr, "states");
        this.aCI = lottieAnimationView;
        this.aCJ = fArr;
    }

    public LottieAnimationView Ov() {
        return this.aCI;
    }

    public final void dq(int i) {
        if (this.aCH != i) {
            this.aCH = i;
            LottieAnimationView Ov = Ov();
            if (Ov.isAnimating()) {
                Ov.cW();
            }
            if (i == 0) {
                Ov.setProgress(this.aCJ[i]);
            } else {
                Ov.setMaxProgress(this.aCJ[i]);
                if (Ov.getProgress() == 0.0f) {
                    Ov.cT();
                } else {
                    Ov.cU();
                }
            }
        }
    }

    public void Or() {
        if (Ot()) {
            dq(this.aCH + 1);
        }
    }

    public void Os() {
        if (Ou()) {
            dq(this.aCH - 1);
        }
    }

    public boolean Ot() {
        return this.aCH < this.aCJ.length - 1;
    }

    public boolean Ou() {
        return this.aCH > 0;
    }

    public void reset() {
        dq(0);
    }
}
