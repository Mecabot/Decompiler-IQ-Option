package com.iqoption.view.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/view/text/TouchableSpan;", "Landroid/text/style/ClickableSpan;", "normalTextColor", "", "pressedTextColor", "(II)V", "isPressed", "", "setPressed", "", "updateDrawState", "ds", "Landroid/text/TextPaint;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TouchableSpan.kt */
public abstract class y extends ClickableSpan {
    private boolean bgb;
    private final int bhv;
    private final int bhw;

    public y(int i, int i2) {
        this.bhv = i;
        this.bhw = i2;
    }

    public final void setPressed(boolean z) {
        this.bgb = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        h.e(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(this.bgb ? this.bhw : this.bhv);
        textPaint.setUnderlineText(false);
    }
}
