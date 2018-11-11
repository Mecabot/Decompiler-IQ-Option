package com.iqoption.chat.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0014\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/chat/fragment/ReturnButtonController;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "button", "Landroid/view/View;", "(Landroid/view/View;)V", "animationListener", "com/iqoption/chat/fragment/ReturnButtonController$animationListener$1", "Lcom/iqoption/chat/fragment/ReturnButtonController$animationListener$1;", "endTranslation", "", "isButtonShown", "", "maxScrollPixels", "", "totalScroll", "hideButton", "", "isFirstItemVisible", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrolled", "dx", "dy", "showButton", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ReturnButtonController.kt */
public final class t extends OnScrollListener {
    private static final String TAG = "t";
    public static final a aHT = new a();
    private final float aHN = com.iqoption.core.ext.a.e(this.aHS, (int) R.dimen.dp50);
    private final b aHO = new b(this);
    private final int aHP = com.iqoption.core.ext.a.b(this.aHS, 50.0f);
    private int aHQ;
    private boolean aHR;
    private final View aHS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/chat/fragment/ReturnButtonController$Companion;", "", "()V", "MAX_SCROLL", "", "TAG", "", "kotlin.jvm.PlatformType", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ReturnButtonController.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/chat/fragment/ReturnButtonController$animationListener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ReturnButtonController.kt */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ t aHU;

        b(t tVar) {
            this.aHU = tVar;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.aHU.aHS.getTranslationY() == this.aHU.aHN) {
                this.aHU.aHS.setVisibility(8);
            }
        }
    }

    public t(View view) {
        h.e(view, "button");
        this.aHS = view;
        view = this.aHS;
        if (this.aHR) {
            view.setVisibility(0);
            view.setTranslationY(0.0f);
            return;
        }
        view.setVisibility(8);
        view.setTranslationY(this.aHN);
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dy: ");
        stringBuilder.append(i2);
        stringBuilder.append(", total: ");
        stringBuilder.append(this.aHQ);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        if (a(recyclerView)) {
            Qc();
            return;
        }
        this.aHQ += i2;
        int i3 = this.aHQ > this.aHP ? this.aHP : this.aHQ < 0 ? 0 : this.aHQ;
        this.aHQ = i3;
        i3 = this.aHQ;
        if (i3 == this.aHP) {
            Qb();
        } else if (i3 == 0) {
            Qc();
        }
    }

    private final boolean a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            h.aXZ();
        }
        return recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) == 0;
    }

    private final void Qb() {
        if (!this.aHR) {
            this.aHR = true;
            this.aHS.setVisibility(0);
            this.aHS.animate().translationY(0.0f).setInterpolator(d.aQV).start();
        }
    }

    private final void Qc() {
        if (this.aHR) {
            this.aHR = false;
            this.aHS.setVisibility(0);
            this.aHS.animate().translationY(this.aHN).setListener(this.aHO).setInterpolator(d.aQW).start();
        }
    }
}
