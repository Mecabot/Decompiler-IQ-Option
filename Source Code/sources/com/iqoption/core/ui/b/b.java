package com.iqoption.core.ui.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.graphics.animation.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/ui/animation/EnterExitAnimationProvider;", "Lcom/iqoption/core/ui/animation/AnimationProvider;", "Lcom/iqoption/core/ui/animation/EnterExitAnimatable;", "delegate", "Lcom/iqoption/core/ui/fragment/IQFragment;", "(Lcom/iqoption/core/ui/fragment/IQFragment;)V", "getDelegate", "()Lcom/iqoption/core/ui/fragment/IQFragment;", "enterAnimationDuration", "", "getEnterAnimationDuration", "()J", "exitAnimationDuration", "getExitAnimationDuration", "createAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onEnterAnimation", "", "onExitAnimation", "core_release"})
/* compiled from: EnterExitAnimationProvider.kt */
public final class b implements a {
    private final com.iqoption.core.ui.fragment.b bba;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, aXE = {"com/iqoption/core/ui/animation/EnterExitAnimationProvider$createAnimation$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "core_release"})
    /* compiled from: EnterExitAnimationProvider.kt */
    public static final class a implements AnimationListener {
        final /* synthetic */ b bbb;
        final /* synthetic */ boolean bbc;
        final /* synthetic */ View bbd;
        final /* synthetic */ long bbe;

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        a(b bVar, boolean z, View view, long j) {
            this.bbb = bVar;
            this.bbc = z;
            this.bbd = view;
            this.bbe = j;
        }

        public void onAnimationStart(Animation animation) {
            if (this.bbc) {
                View view = this.bbd;
                h.d(view, Promotion.ACTION_VIEW);
                view.setAlpha(1.0f);
                this.bbb.KF();
                return;
            }
            this.bbb.KG();
        }
    }

    public void KF() {
        this.bba.KF();
    }

    public void KG() {
        this.bba.KG();
    }

    public long Yw() {
        return this.bba.Yw();
    }

    public long Yx() {
        return this.bba.Yx();
    }

    public b(com.iqoption.core.ui.fragment.b bVar) {
        h.e(bVar, "delegate");
        this.bba = bVar;
    }

    public Animation a(int i, boolean z, int i2) {
        if (i2 != 0) {
            return this.bba.dS(i2);
        }
        if (i != 0 || !this.bba.KE()) {
            return null;
        }
        long Yw = z ? Yw() : Yx();
        if (Yw == 0) {
            return null;
        }
        View view = this.bba.getView();
        if (view == null) {
            return null;
        }
        c cVar = new c();
        if (z) {
            h.d(view, Promotion.ACTION_VIEW);
            view.setAlpha(0.0f);
        }
        cVar.setDuration(Yw);
        cVar.setAnimationListener(new a(this, z, view, Yw));
        return cVar;
    }
}
