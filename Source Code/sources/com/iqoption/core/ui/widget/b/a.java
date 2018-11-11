package com.iqoption.core.ui.widget.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/ui/widget/viewinterface/OnTouchAlphaAndScaleEffect;", "Landroid/view/View$OnTouchListener;", "alpha", "", "scale", "(FF)V", "getAlpha", "()F", "getScale", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "Companion", "core_release"})
/* compiled from: OnTouchAlphaAndScaleEffect.kt */
public final class a implements OnTouchListener {
    public static final a bgw = new a();
    private final float alpha;
    private final float ju;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/ui/widget/viewinterface/OnTouchAlphaAndScaleEffect$Companion;", "", "()V", "DURATION", "", "core_release"})
    /* compiled from: OnTouchAlphaAndScaleEffect.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public a() {
        this(0.0f, 0.0f, 3, null);
    }

    public a(float f, float f2) {
        this.alpha = f;
        this.ju = f2;
    }

    public /* synthetic */ a(float f, float f2, int i, f fVar) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        if ((i & 2) != 0) {
            f2 = 0.95f;
        }
        this(f, f2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        h.e(view, "v");
        h.e(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            view.animate().alpha(this.alpha).scaleX(this.ju).scaleY(this.ju).setInterpolator(com.iqoption.core.graphics.animation.i.TI()).setDuration(150).start();
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(com.iqoption.core.graphics.animation.i.TI()).setDuration(300).start();
        }
        return false;
    }
}
