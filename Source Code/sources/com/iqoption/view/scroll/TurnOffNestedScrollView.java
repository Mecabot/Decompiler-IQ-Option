package com.iqoption.view.scroll;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, aXE = {"Lcom/iqoption/view/scroll/TurnOffNestedScrollView;", "Landroid/support/v4/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scrollable", "", "getScrollable", "()Z", "setScrollable", "(Z)V", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TurnOffNestedScrollView.kt */
public class TurnOffNestedScrollView extends NestedScrollView {
    private boolean dIE;

    public TurnOffNestedScrollView(Context context) {
        this(context, null, 0, 6, null);
    }

    public TurnOffNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TurnOffNestedScrollView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public TurnOffNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        h.e(context, "context");
        super(context, attributeSet, i);
        this.dIE = true;
    }

    public final boolean getScrollable() {
        return this.dIE;
    }

    public final void setScrollable(boolean z) {
        this.dIE = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.e(motionEvent, "ev");
        if (motionEvent.getAction() != 0 || this.dIE) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h.e(motionEvent, "ev");
        if (this.dIE) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
