package com.iqoption.chat.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.iqoption.core.k;
import com.iqoption.core.l;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/chat/fragment/BadgeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "date", "getDate", "()J", "setDate", "(J)V", "drawable", "Lcom/iqoption/chat/fragment/DateDrawable;", "init", "", "resourcer", "Lcom/iqoption/core/Resourcer;", "dateComparator", "Lcom/iqoption/chat/fragment/DateComparator;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BadgeView.kt */
public final class BadgeView extends View {
    private f aFw;

    public BadgeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BadgeView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        h.e(context, "context");
        super(context, attributeSet, i);
        if (isInEditMode()) {
            a(new l(context), new e());
            f fVar = this.aFw;
            if (fVar != null) {
                fVar.setDate(0);
            }
        }
    }

    public final long getDate() {
        f fVar = this.aFw;
        return fVar != null ? fVar.getDate() : -1;
    }

    public final void setDate(long j) {
        f fVar = this.aFw;
        if (fVar != null && fVar.getDate() != j) {
            fVar.setDate(j);
            requestLayout();
        }
    }

    public final void a(k kVar, e eVar) {
        h.e(kVar, "resourcer");
        h.e(eVar, "dateComparator");
        this.aFw = new f(kVar, eVar);
    }

    protected void onMeasure(int i, int i2) {
        f fVar = this.aFw;
        i2 = 0;
        i = fVar != null ? fVar.getIntrinsicWidth() : 0;
        f fVar2 = this.aFw;
        if (fVar2 != null) {
            i2 = fVar2.getIntrinsicHeight();
        }
        setMeasuredDimension(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f fVar = this.aFw;
        if (fVar != null) {
            fVar.draw(canvas);
        }
    }
}
