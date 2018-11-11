package com.iqoption.core.util.a;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/util/link/LinkTouchMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "()V", "pressedSpan", "Lcom/iqoption/core/util/link/TouchableSpan;", "getPressedSpan", "textView", "Landroid/widget/TextView;", "spannable", "Landroid/text/Spannable;", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "", "positionWithinTag", "position", "", "tag", "", "core_release"})
/* compiled from: LinkTouchMovementMethod.kt */
public final class c extends LinkMovementMethod {
    private g bhk;

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        h.e(textView, "textView");
        h.e(spannable, "spannable");
        h.e(motionEvent, "event");
        int action = motionEvent.getAction();
        g gVar;
        if (action == 0) {
            this.bhk = a(textView, spannable, motionEvent);
            gVar = this.bhk;
            if (gVar != null) {
                gVar.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(gVar), spannable.getSpanEnd(gVar));
            }
        } else if (action != 2) {
            g gVar2 = this.bhk;
            if (gVar2 != null) {
                gVar2.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.bhk = (g) null;
            Selection.removeSelection(spannable);
        } else {
            gVar = a(textView, spannable, motionEvent);
            g gVar3 = this.bhk;
            if (!(gVar3 == null || (h.E(gVar, gVar3) ^ 1) == 0)) {
                gVar3.setPressed(false);
                this.bhk = (g) null;
                Selection.removeSelection(spannable);
            }
        }
        return true;
    }

    private final g a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        g[] gVarArr = (g[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, g.class);
        g gVar = (g) null;
        h.d(gVarArr, "link");
        if (((gVarArr.length == 0 ? 1 : 0) ^ 1) == 0) {
            return gVar;
        }
        Object obj = gVarArr[0];
        h.d(obj, "link[0]");
        return a(offsetForHorizontal, spannable, obj) ? gVarArr[0] : gVar;
    }

    private final boolean a(int i, Spannable spannable, Object obj) {
        return i >= spannable.getSpanStart(obj) && i <= spannable.getSpanEnd(obj);
    }
}
