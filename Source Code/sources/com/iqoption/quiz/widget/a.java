package com.iqoption.quiz.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.LruCache;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, aXE = {"Lcom/iqoption/quiz/widget/LetterDrawable;", "Landroid/graphics/drawable/Drawable;", "state", "Lcom/iqoption/quiz/widget/LetterDrawableState;", "(Lcom/iqoption/quiz/widget/LetterDrawableState;)V", "defaultIntrinsicSize", "", "defaultPaintSize", "rect", "Landroid/graphics/RectF;", "rectInset", "", "textOffset", "textSize", "getTextSize", "()I", "calcTextOffset", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "Companion", "quiz_release"})
/* compiled from: LetterDrawable.kt */
public final class a extends Drawable {
    private static final int MAX_SIZE = 48;
    private static final LruCache<String, b> doR = new LruCache(MAX_SIZE);
    private static final Rect doS = new Rect();
    public static final a doT = new a();
    private final int doM = this.doQ.getContext().getResources().getDimensionPixelSize(com.iqoption.quiz.ae.a.dp32);
    private final int doN = this.doQ.getContext().getResources().getDimensionPixelSize(com.iqoption.quiz.ae.a.dp48);
    private final float doO;
    private float doP;
    private final b doQ;
    private final RectF kt;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/quiz/widget/LetterDrawable$Companion;", "", "()V", "MAX_SIZE", "", "TMP_RECT", "Landroid/graphics/Rect;", "cache", "Landroid/support/v4/util/LruCache;", "", "Lcom/iqoption/quiz/widget/LetterDrawableState;", "get", "Lcom/iqoption/quiz/widget/LetterDrawable;", "params", "quiz_release"})
    /* compiled from: LetterDrawable.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a a(b bVar) {
            h.e(bVar, "params");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.getName());
            stringBuilder.append('-');
            stringBuilder.append(bVar.aDa());
            stringBuilder.append('-');
            stringBuilder.append(bVar.isRound());
            String stringBuilder2 = stringBuilder.toString();
            b bVar2 = (b) a.doR.get(stringBuilder2);
            if (bVar2 != null) {
                return bVar2.newDrawable();
            }
            a aVar = new a(bVar);
            a.doR.put(stringBuilder2, aVar.doQ);
            return aVar;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public a(b bVar) {
        h.e(bVar, "state");
        this.doQ = bVar;
        this.doO = this.doQ.aDc().getStyle() == Style.FILL ? 0.0f : this.doQ.aDc().getStrokeWidth() / ((float) 2);
        this.kt = new RectF();
        aCY();
    }

    private final int getTextSize() {
        return (int) (((float) ((this.doM * Math.min(getBounds().width(), getBounds().height())) / this.doN)) * 0.5f);
    }

    private final void aCY() {
        this.doQ.aDb().setTextSize((float) getTextSize());
        this.doQ.aDb().getTextBounds(this.doQ.getName(), 0, this.doQ.getName().length(), doS);
        this.doP = (float) ((doS.height() / 2) + doS.top);
    }

    protected void onBoundsChange(Rect rect) {
        h.e(rect, "bounds");
        super.onBoundsChange(rect);
        this.kt.set(rect);
        this.kt.inset(this.doO, this.doO);
        aCY();
    }

    public void draw(Canvas canvas) {
        h.e(canvas, "canvas");
        if (this.doQ.isRound()) {
            canvas.drawOval(this.kt, this.doQ.aDc());
        } else {
            canvas.drawPaint(this.doQ.aDc());
        }
        this.doQ.aDb().setTextSize((float) getTextSize());
        Canvas canvas2 = canvas;
        canvas2.drawText(this.doQ.getName(), 0, this.doQ.getName().length(), this.kt.centerX(), this.kt.centerY() - this.doP, this.doQ.aDb());
    }

    public int getIntrinsicWidth() {
        return this.doN;
    }

    public int getIntrinsicHeight() {
        return this.doN;
    }

    public ConstantState getConstantState() {
        return this.doQ;
    }
}
