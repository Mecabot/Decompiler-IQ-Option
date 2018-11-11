package com.iqoption.quiz.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.ConstantState;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001f\u0010\u000e¨\u0006)"}, aXE = {"Lcom/iqoption/quiz/widget/LetterDrawableState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "bgPaint$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "isRound", "", "()Z", "setRound", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "textPaint", "getTextPaint", "textPaint$delegate", "equals", "other", "", "getChangingConfigurations", "hashCode", "newDrawable", "Lcom/iqoption/quiz/widget/LetterDrawable;", "Companion", "quiz_release"})
/* compiled from: LetterDrawableState.kt */
public final class b extends ConstantState {
    private static final Typeface aHw = Typeface.create("sans-serif-medium", 0);
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "textPaint", "getTextPaint()Landroid/graphics/Paint;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "bgPaint", "getBgPaint()Landroid/graphics/Paint;"))};
    public static final a doX = new a();
    private int bgColor;
    private final Context context;
    private boolean doU = true;
    private final d doV = g.f(LetterDrawableState$textPaint$2.doY);
    private final d doW = g.f(new LetterDrawableState$bgPaint$2(this));
    private String name = "";

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/widget/LetterDrawableState$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "createBgPaint", "Landroid/graphics/Paint;", "color", "", "createTextPaint", "quiz_release"})
    /* compiled from: LetterDrawableState.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final Paint aDf() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setTextAlign(Align.CENTER);
            if (b.aHw != null) {
                paint.setTypeface(b.aHw);
            }
            return paint;
        }

        private final Paint gu(int i) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i);
            return paint;
        }
    }

    public final Paint aDb() {
        d dVar = this.doV;
        j jVar = apP[0];
        return (Paint) dVar.getValue();
    }

    public final Paint aDc() {
        d dVar = this.doW;
        j jVar = apP[1];
        return (Paint) dVar.getValue();
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public b(Context context) {
        h.e(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        h.e(str, "<set-?>");
        this.name = str;
    }

    public final int aDa() {
        return this.bgColor;
    }

    public final void gt(int i) {
        this.bgColor = i;
    }

    public final boolean isRound() {
        return this.doU;
    }

    /* renamed from: aDd */
    public a newDrawable() {
        return new a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.quiz.widget.LetterDrawableState");
        }
        b bVar = (b) obj;
        if ((h.E(this.name, bVar.name) ^ 1) == 0 && this.bgColor == bVar.bgColor && this.doU == bVar.doU) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.bgColor) * 31) + Boolean.valueOf(this.doU).hashCode();
    }
}
