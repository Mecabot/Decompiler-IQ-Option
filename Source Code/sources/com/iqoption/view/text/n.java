package com.iqoption.view.text;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/view/text/LinkTouchMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "()V", "pressedSpan", "Lcom/iqoption/view/text/TouchableSpan;", "getPressedSpan", "textView", "Landroid/widget/TextView;", "spannable", "Landroid/text/Spannable;", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "", "positionWithinTag", "position", "", "tag", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LinkTouchMovementMethod.kt */
public final class n extends LinkMovementMethod {
    private y dJr;

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        h.e(textView, "textView");
        h.e(spannable, "spannable");
        h.e(motionEvent, "event");
        int action = motionEvent.getAction();
        y yVar;
        if (action == 0) {
            this.dJr = b(textView, spannable, motionEvent);
            yVar = this.dJr;
            if (yVar != null) {
                yVar.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(yVar), spannable.getSpanEnd(yVar));
            }
        } else if (action != 2) {
            y yVar2 = this.dJr;
            if (yVar2 != null) {
                yVar2.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.dJr = (y) null;
            Selection.removeSelection(spannable);
        } else {
            yVar = b(textView, spannable, motionEvent);
            y yVar3 = this.dJr;
            if (!(yVar3 == null || (h.E(yVar, yVar3) ^ 1) == 0)) {
                yVar3.setPressed(false);
                this.dJr = (y) null;
                Selection.removeSelection(spannable);
            }
        }
        return true;
    }

    private final y b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        y[] yVarArr = (y[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, y.class);
        y yVar = (y) null;
        h.d(yVarArr, "link");
        if (((yVarArr.length == 0 ? 1 : 0) ^ 1) == 0) {
            return yVar;
        }
        Object obj = yVarArr[0];
        h.d(obj, "link[0]");
        return a(offsetForHorizontal, spannable, obj) ? yVarArr[0] : yVar;
    }

    private final boolean a(int i, Spannable spannable, Object obj) {
        return i >= spannable.getSpanStart(obj) && i <= spannable.getSpanEnd(obj);
    }
}
