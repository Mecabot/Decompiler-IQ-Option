package com.iqoption.signals;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.d.aje;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bR+\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/signals/SignalItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/SignalItemBinding;", "onClick", "Lkotlin/Function1;", "Lcom/iqoption/signals/SignalItem;", "", "(Lcom/iqoption/databinding/SignalItemBinding;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "bound", "getBound", "()Lcom/iqoption/signals/SignalItem;", "setBound", "(Lcom/iqoption/signals/SignalItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "colorNegative", "", "colorPositive", "dotsDrawable", "Lcom/iqoption/signals/SignalItemViewHolder$DotsDrawable;", "DotsDrawable", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SignalItemViewHolder.kt */
public final class d extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "bound", "getBound()Lcom/iqoption/signals/SignalItem;"))};
    private final kotlin.e.d bXV;
    private final int dre = com.iqoption.core.ext.a.b((ViewHolder) this, (int) R.color.green);
    private final int drf = com.iqoption.core.ext.a.b((ViewHolder) this, (int) R.color.red);
    private final b drg = new b(com.iqoption.core.ext.a.c((ViewHolder) this, (int) R.dimen.dp1), com.iqoption.core.ext.a.c((ViewHolder) this, (int) R.dimen.dp7) / 2.0f, com.iqoption.core.ext.a.c((ViewHolder) this, (int) R.dimen.dp7));

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, aXE = {"Lcom/iqoption/signals/SignalItemViewHolder$DotsDrawable;", "Landroid/graphics/drawable/Drawable;", "dotStrokeWidth", "", "dotRadius", "dotOffset", "(FFF)V", "value", "", "color", "getColor", "()I", "setColor", "(I)V", "fillCount", "getFillCount", "setFillCount", "paint", "Landroid/graphics/Paint;", "strokeRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Companion", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SignalItemViewHolder.kt */
    public static final class b extends Drawable {
        public static final a drk = new a();
        private final float bfA;
        private final float drh;
        @IntRange(from = 1, to = 2)
        private int dri = 1;
        private final float drj;
        private final Paint kx;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/signals/SignalItemViewHolder$DotsDrawable$Companion;", "", "()V", "DOT_MAX", "", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: SignalItemViewHolder.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public b(float f, float f2, float f3) {
            this.bfA = f2;
            this.drj = f3;
            Paint paint = new Paint(1);
            paint.setStrokeWidth(f);
            this.kx = paint;
            this.drh = this.bfA - (f / 2.0f);
        }

        public final void setColor(int i) {
            this.kx.setColor(i);
            invalidateSelf();
        }

        public final void gy(int i) {
            if (this.dri != i) {
                this.dri = i;
                invalidateSelf();
            }
        }

        public int getIntrinsicWidth() {
            float f = (float) 2;
            return c.ae(((this.bfA * f) * f) + (this.drj * ((float) 1)));
        }

        public int getIntrinsicHeight() {
            return c.ae(((float) 2) * this.bfA);
        }

        public void draw(Canvas canvas) {
            if (canvas != null) {
                canvas.save();
                canvas.translate(this.bfA, this.bfA);
                for (int i = 0; i < 2; i++) {
                    float f;
                    if (i < this.dri) {
                        this.kx.setStyle(Style.FILL);
                        f = this.bfA;
                    } else {
                        this.kx.setStyle(Style.STROKE);
                        f = this.drh;
                    }
                    if (i != 0) {
                        canvas.translate(this.drj + (this.bfA * ((float) 2)), 0.0f);
                    }
                    canvas.drawCircle(0.0f, 0.0f, f, this.kx);
                }
                canvas.restore();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ kotlin.jvm.a.b dgJ;
        final /* synthetic */ d this$0;

        public a(d dVar, kotlin.jvm.a.b bVar) {
            this.this$0 = dVar;
            this.dgJ = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.dgJ.invoke(this.this$0.aEb());
        }
    }

    public final c aEb() {
        return (c) this.bXV.b(this, apP[0]);
    }

    public final void b(c cVar) {
        h.e(cVar, "<set-?>");
        this.bXV.a(this, apP[0], cVar);
    }

    public d(aje aje, kotlin.jvm.a.b<? super c, l> bVar) {
        h.e(aje, "binding");
        h.e(bVar, "onClick");
        super(aje.getRoot());
        View root = aje.getRoot();
        h.d(root, "binding.root");
        root.setOnClickListener(new a(this, bVar));
        aje.bTr.setImageDrawable(this.drg);
        this.bXV = c.h(new SignalItemViewHolder$$special$$inlined$bindable$1(aje, this));
    }
}
