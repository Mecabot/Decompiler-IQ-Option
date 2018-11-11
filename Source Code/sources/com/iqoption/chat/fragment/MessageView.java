package com.iqoption.chat.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.support.v4.text.util.LinkifyCompat;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.iqoption.util.ax;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002CDB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0014J\u0018\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0010\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u0002092\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u00188F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010)\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R$\u0010,\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR(\u0010/\u001a\u0004\u0018\u00010\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u00188F@FX\u000e¢\u0006\f\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u000e\u00102\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R$\u00103\u001a\u00020 2\u0006\u0010\t\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, aXE = {"Lcom/iqoption/chat/fragment/MessageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "linkColor", "getLinkColor", "()I", "setLinkColor", "(I)V", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "Landroid/graphics/Typeface;", "textFont", "getTextFont", "()Landroid/graphics/Typeface;", "setTextFont", "(Landroid/graphics/Typeface;)V", "textHolder", "Lcom/iqoption/chat/fragment/MessageView$TextHolder;", "", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "textTimeExtraHeight", "textTimeExtraWidth", "textTimeGap", "time", "getTime", "setTime", "timeColor", "getTimeColor", "setTimeColor", "timeFont", "getTimeFont", "setTimeFont", "timeHolder", "timeSize", "getTimeSize", "setTimeSize", "useExtraHeight", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "readAttributes", "TextHolder", "TextMetrics", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageView.kt */
public final class MessageView extends View {
    private a aHi;
    private a aHj;
    private final int aHk;
    private final int aHl;
    private final int aHm;
    private boolean aHn;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\u00020\u0001:\u0002IJB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\nJ\u000e\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\nJ\u0016\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0014J\u0016\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nJ&\u0010G\u001a\u00020\u0003*\u0004\u0018\u00010#2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148G@GX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u001a\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R$\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u0011\u0010&\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R$\u0010,\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010\t\u001a\u0004\u0018\u00010/@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00106\u001a\u0004\u0018\u0001052\b\u0010\t\u001a\u0004\u0018\u0001058F@FX\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006K"}, aXE = {"Lcom/iqoption/chat/fragment/MessageView$TextHolder;", "", "linkify", "", "(Z)V", "buffer", "Landroid/text/SpannableStringBuilder;", "getBuffer", "()Landroid/text/SpannableStringBuilder;", "value", "", "color", "getColor", "()I", "setColor", "(I)V", "isSingleLine", "()Z", "layout", "Landroid/text/Layout;", "", "letterSpacing", "getLetterSpacing", "()F", "setLetterSpacing", "(F)V", "lineCount", "getLineCount", "lineSpacingExtra", "getLineSpacingExtra", "setLineSpacingExtra", "linkColor", "getLinkColor", "setLinkColor", "measureCache", "Lcom/iqoption/chat/fragment/MessageView$TextHolder$MeasureCache;", "measuredHeight", "getMeasuredHeight", "measuredWidth", "getMeasuredWidth", "metrics", "Lcom/iqoption/chat/fragment/MessageView$TextMetrics;", "paint", "Landroid/text/TextPaint;", "size", "getSize", "setSize", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "Landroid/graphics/Typeface;", "typeface", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getLineForVertical", "offset", "getLineWidth", "line", "getOffsetForHorizontal", "measure", "outWidth", "outHeight", "isApplicable", "textHolder", "Companion", "MeasureCache", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageView.kt */
    public static final class a {
        public static final a aHv = new a();
        private final TextPaint aHo = new TextPaint(1);
        private Layout aHp;
        private final b aHq = new b();
        private b aHr;
        private final SpannableStringBuilder aHs = new SpannableStringBuilder();
        private float aHt;
        private final boolean aHu;
        private String text;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/chat/fragment/MessageView$TextHolder$Companion;", "", "()V", "BOX_HEIGHT_MAX", "", "BOX_WIDTH_MAX", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: MessageView.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, aXE = {"Lcom/iqoption/chat/fragment/MessageView$TextHolder$MeasureCache;", "", "()V", "outHeight", "", "getOutHeight", "()I", "setOutHeight", "(I)V", "outWidth", "getOutWidth", "setOutWidth", "size", "", "getSize", "()F", "setSize", "(F)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: MessageView.kt */
        private static final class b {
            private Typeface aHw;
            private int outHeight = -1;
            private int outWidth = -1;
            private float size = -1.0f;
            private String text;

            public final int PY() {
                return this.outWidth;
            }

            public final void dC(int i) {
                this.outWidth = i;
            }

            public final int PZ() {
                return this.outHeight;
            }

            public final void dD(int i) {
                this.outHeight = i;
            }

            public final float getSize() {
                return this.size;
            }

            public final void setSize(float f) {
                this.size = f;
            }

            public final Typeface getTypeface() {
                return this.aHw;
            }

            public final void setTypeface(Typeface typeface) {
                this.aHw = typeface;
            }

            public final String getText() {
                return this.text;
            }

            public final void setText(String str) {
                this.text = str;
            }
        }

        public a(boolean z) {
            this.aHu = z;
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            if ((h.E(this.text, str) ^ 1) != 0) {
                this.text = str;
                this.aHs.clear();
                this.aHs.append(this.text);
                if (this.aHu) {
                    LinkifyCompat.addLinks((Spannable) this.aHs, 1);
                }
            }
        }

        public final SpannableStringBuilder PW() {
            return this.aHs;
        }

        public final float getSize() {
            return this.aHo.getTextSize();
        }

        public final void setSize(float f) {
            this.aHo.setTextSize(f);
        }

        public final Typeface getTypeface() {
            return this.aHo.getTypeface();
        }

        public final void setTypeface(Typeface typeface) {
            this.aHo.setTypeface(typeface);
        }

        public final int getColor() {
            return this.aHo.getColor();
        }

        public final void setColor(int i) {
            this.aHo.setColor(i);
        }

        public final int getLinkColor() {
            return this.aHo.linkColor;
        }

        public final void setLinkColor(int i) {
            this.aHo.linkColor = i;
        }

        @TargetApi(21)
        public final void setLetterSpacing(float f) {
            this.aHo.setLetterSpacing(f);
        }

        public final void r(float f) {
            this.aHt = f;
        }

        public final int getMeasuredWidth() {
            Layout layout = this.aHp;
            return layout != null ? layout.getWidth() : 0;
        }

        public final int getMeasuredHeight() {
            Layout layout = this.aHp;
            return layout != null ? layout.getHeight() : 0;
        }

        public final int getLineCount() {
            Layout layout = this.aHp;
            return layout != null ? layout.getLineCount() : 1;
        }

        public final boolean PX() {
            return getLineCount() == 1;
        }

        public final float getLineWidth(int i) {
            Layout layout = this.aHp;
            return layout != null ? layout.getLineWidth(i) : 0.0f;
        }

        public final int getLineForVertical(int i) {
            Layout layout = this.aHp;
            return layout != null ? layout.getLineForVertical(i) : 0;
        }

        public final int getOffsetForHorizontal(int i, float f) {
            Layout layout = this.aHp;
            return layout != null ? layout.getOffsetForHorizontal(i, f) : 0;
        }

        public final void measure(int i, int i2) {
            if (!a(this.aHr, this, i, i2)) {
                Layout layout;
                String str = this.text;
                if (str == null) {
                    str = "";
                }
                this.aHo.getFontMetrics(this.aHq);
                Alignment alignment = Alignment.ALIGN_NORMAL;
                CharSequence charSequence = str;
                Metrics isBoring = BoringLayout.isBoring(charSequence, this.aHo);
                Object obj = (isBoring == null || isBoring.width > i) ? null : 1;
                if (obj != null) {
                    BoringLayout replaceOrMake;
                    int i3 = isBoring.width;
                    Layout layout2 = this.aHp;
                    if (layout2 instanceof BoringLayout) {
                        replaceOrMake = ((BoringLayout) layout2).replaceOrMake(this.aHs, this.aHo, i3, alignment, 1.0f, this.aHt, isBoring, false);
                    } else {
                        replaceOrMake = BoringLayout.make(this.aHs, this.aHo, i3, alignment, 1.0f, this.aHt, isBoring, false);
                    }
                    layout = replaceOrMake;
                } else {
                    layout = new StaticLayout(this.aHs, this.aHo, Math.min(c.ae(StaticLayout.getDesiredWidth(charSequence, this.aHo)), i), alignment, 1.0f, this.aHt, false);
                }
                this.aHp = layout;
                b bVar = this.aHr;
                if (bVar == null) {
                    bVar = new b();
                    this.aHr = bVar;
                }
                bVar.dC(i);
                bVar.dD(i2);
                bVar.setSize(getSize());
                bVar.setTypeface(getTypeface());
                bVar.setText(str);
            }
        }

        private final boolean a(b bVar, a aVar, int i, int i2) {
            if (bVar == null) {
                return false;
            }
            Layout layout = aVar.aHp;
            if (layout == null) {
                return false;
            }
            if (i != bVar.PY() && layout.getWidth() >= i) {
                return false;
            }
            if ((i2 == bVar.PZ() || layout.getHeight() < i2) && aVar.getSize() == bVar.getSize() && (h.E(aVar.getTypeface(), bVar.getTypeface()) ^ 1) == 0 && (h.E(aVar.text, bVar.getText()) ^ 1) == 0) {
                return true;
            }
            return false;
        }

        public final void draw(Canvas canvas) {
            h.e(canvas, "canvas");
            Layout layout = this.aHp;
            if (layout != null) {
                layout.draw(canvas);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/chat/fragment/MessageView$TextMetrics;", "Landroid/graphics/Paint$FontMetrics;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageView.kt */
    public static final class b extends FontMetrics {
    }

    public MessageView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MessageView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public MessageView(Context context, AttributeSet attributeSet, int i) {
        h.e(context, "context");
        super(context, attributeSet, i);
        this.aHi = new a(true);
        this.aHj = new a(false);
        this.aHk = com.iqoption.core.ext.a.f(this, R.dimen.dp8);
        this.aHl = com.iqoption.core.ext.a.f(this, R.dimen.dp2);
        this.aHm = com.iqoption.core.ext.a.f(this, R.dimen.dp2);
        if (attributeSet != null) {
            b(attributeSet);
        }
        if (ax.dws) {
            this.aHi.setLetterSpacing(0.01f);
            this.aHi.r(com.iqoption.core.ext.a.e((View) this, (int) R.dimen.sp6));
            this.aHj.setLetterSpacing(0.02f);
        }
    }

    public final String getText() {
        return this.aHi.getText();
    }

    public final void setText(String str) {
        String text = this.aHi.getText();
        this.aHi.setText(str);
        if ((h.E(text, str) ^ 1) != 0) {
            requestLayout();
        }
    }

    public final float getTextSize() {
        return this.aHi.getSize();
    }

    public final void setTextSize(float f) {
        float size = this.aHi.getSize();
        this.aHi.setSize(f);
        if (size != f) {
            requestLayout();
        }
    }

    public final Typeface getTextFont() {
        return this.aHi.getTypeface();
    }

    public final void setTextFont(Typeface typeface) {
        Typeface typeface2 = this.aHi.getTypeface();
        this.aHi.setTypeface(typeface);
        if ((h.E(typeface2, typeface) ^ 1) != 0) {
            requestLayout();
        }
    }

    public final int getTextColor() {
        return this.aHi.getColor();
    }

    public final void setTextColor(int i) {
        int color = this.aHi.getColor();
        this.aHi.setColor(i);
        if (color != i) {
            invalidate();
        }
    }

    public final int getLinkColor() {
        return this.aHi.getLinkColor();
    }

    public final void setLinkColor(int i) {
        int linkColor = this.aHi.getLinkColor();
        this.aHi.setLinkColor(i);
        if (linkColor != i) {
            invalidate();
        }
    }

    public final String getTime() {
        return this.aHj.getText();
    }

    public final void setTime(String str) {
        String text = this.aHj.getText();
        this.aHj.setText(str);
        if ((h.E(text, str) ^ 1) != 0) {
            requestLayout();
        }
    }

    public final float getTimeSize() {
        return this.aHj.getSize();
    }

    public final void setTimeSize(float f) {
        float size = this.aHj.getSize();
        this.aHj.setSize(f);
        if (size != f) {
            requestLayout();
        }
    }

    public final Typeface getTimeFont() {
        return this.aHj.getTypeface();
    }

    public final void setTimeFont(Typeface typeface) {
        Typeface typeface2 = this.aHj.getTypeface();
        this.aHj.setTypeface(typeface);
        if ((h.E(typeface2, typeface) ^ 1) != 0) {
            requestLayout();
        }
    }

    public final int getTimeColor() {
        return this.aHj.getColor();
    }

    public final void setTimeColor(int i) {
        int color = this.aHj.getColor();
        this.aHj.setColor(i);
        if (color != i) {
            invalidate();
        }
    }

    private final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.iqoption.b.b.MessageView);
        setText(obtainStyledAttributes.getString(1));
        setTextSize(obtainStyledAttributes.getDimension(4, com.iqoption.core.ext.a.e((View) this, (int) R.dimen.dp16)));
        if (!isInEditMode()) {
            setTextFont(com.iqoption.core.ext.a.g(this, obtainStyledAttributes.getResourceId(3, R.font.regular)));
        }
        setTextColor(obtainStyledAttributes.getColor(2, com.iqoption.core.ext.a.b((View) this, (int) R.color.chat_message_text)));
        setLinkColor(obtainStyledAttributes.getColor(0, com.iqoption.core.ext.a.b((View) this, (int) R.color.chat_message_link)));
        setTime(obtainStyledAttributes.getString(5));
        setTimeSize(obtainStyledAttributes.getDimension(8, com.iqoption.core.ext.a.e((View) this, (int) R.dimen.dp10)));
        if (!isInEditMode()) {
            setTimeFont(com.iqoption.core.ext.a.g(this, obtainStyledAttributes.getResourceId(7, R.font.regular)));
        }
        setTimeColor(obtainStyledAttributes.getColor(6, com.iqoption.core.ext.a.b((View) this, (int) R.color.chat_message_time)));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        super.onMeasure(r10, r11);
        r0 = android.view.View.MeasureSpec.getMode(r10);
        r10 = android.view.View.MeasureSpec.getSize(r10);
        r1 = r9.getPaddingStart();
        r2 = r9.getPaddingEnd();
        r1 = r1 + r2;
        r2 = r9.getPaddingTop();
        r3 = r9.getPaddingBottom();
        r2 = r2 + r3;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r5 = 0;
        r6 = 1;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r0 == r4) goto L_0x002f;
    L_0x0028:
        if (r0 == 0) goto L_0x002c;
    L_0x002a:
        if (r0 == r3) goto L_0x0031;
    L_0x002c:
        r10 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
    L_0x002f:
        r0 = 0;
        goto L_0x0032;
    L_0x0031:
        r0 = 1;
    L_0x0032:
        r10 = r10 - r1;
        r8 = android.view.View.MeasureSpec.getMode(r11);
        r11 = android.view.View.MeasureSpec.getSize(r11);
        if (r8 == r4) goto L_0x0044;
    L_0x003d:
        if (r8 == 0) goto L_0x0041;
    L_0x003f:
        if (r8 == r3) goto L_0x0046;
    L_0x0041:
        r11 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
    L_0x0044:
        r3 = 0;
        goto L_0x0047;
    L_0x0046:
        r3 = 1;
    L_0x0047:
        r11 = r11 - r2;
        r4 = r9.aHi;
        r4.measure(r10, r11);
        r4 = r9.aHj;
        r4.measure(r7, r7);
        r9.aHn = r5;
        if (r0 == 0) goto L_0x0057;
    L_0x0056:
        goto L_0x00b2;
    L_0x0057:
        r0 = r9.aHi;
        r0 = r0.PX();
        if (r0 == 0) goto L_0x007f;
    L_0x005f:
        r0 = r9.aHi;
        r0 = r0.getMeasuredWidth();
        r4 = r9.aHk;
        r0 = r0 + r4;
        r4 = r9.aHj;
        r4 = r4.getMeasuredWidth();
        r0 = r0 + r4;
        r4 = r9.aHl;
        r0 = r0 + r4;
        if (r0 <= r10) goto L_0x007d;
    L_0x0074:
        r9.aHn = r6;
        r10 = r9.aHi;
        r10 = r10.getMeasuredWidth();
        goto L_0x00b2;
    L_0x007d:
        r10 = r0;
        goto L_0x00b2;
    L_0x007f:
        r0 = r9.aHi;
        r4 = r9.aHi;
        r4 = r4.getLineCount();
        r4 = r4 - r6;
        r0 = r0.getLineWidth(r4);
        r0 = kotlin.d.c.ae(r0);
        r4 = r9.aHk;
        r0 = r0 + r4;
        r4 = r9.aHj;
        r4 = r4.getMeasuredWidth();
        r0 = r0 + r4;
        r4 = r9.aHl;
        r0 = r0 + r4;
        if (r0 <= r10) goto L_0x00a8;
    L_0x009f:
        r9.aHn = r6;
        r10 = r9.aHi;
        r10 = r10.getMeasuredWidth();
        goto L_0x00b2;
    L_0x00a8:
        r10 = r9.aHi;
        r10 = r10.getMeasuredWidth();
        r10 = java.lang.Math.max(r0, r10);
    L_0x00b2:
        r10 = r10 + r1;
        if (r3 == 0) goto L_0x00b6;
    L_0x00b5:
        goto L_0x00d4;
    L_0x00b6:
        r11 = r9.aHn;
        if (r11 == 0) goto L_0x00cb;
    L_0x00ba:
        r11 = r9.aHi;
        r11 = r11.getMeasuredHeight();
        r0 = r9.aHj;
        r0 = r0.getMeasuredHeight();
        r11 = r11 + r0;
        r0 = r9.aHm;
        r11 = r11 + r0;
        goto L_0x00d4;
    L_0x00cb:
        r11 = r9.aHi;
        r11 = r11.getMeasuredHeight();
        r0 = r9.aHm;
        r11 = r11 + r0;
    L_0x00d4:
        r11 = r11 + r2;
        r9.setMeasuredDimension(r10, r11);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.fragment.MessageView.onMeasure(int, int):void");
    }

    protected void onDraw(Canvas canvas) {
        h.e(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.translate((float) getPaddingStart(), (float) getPaddingTop());
        this.aHi.draw(canvas);
        canvas.translate((float) (((getWidth() - getPaddingStart()) - getPaddingEnd()) - this.aHj.getMeasuredWidth()), (float) (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.aHj.getMeasuredHeight()));
        this.aHj.draw(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h.e(motionEvent, "event");
        int action = motionEvent.getAction();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (action == 1 || action == 0) {
            int offsetForHorizontal = this.aHi.getOffsetForHorizontal(this.aHi.getLineForVertical((((int) motionEvent.getY()) - getPaddingTop()) + getScrollY()), (float) ((((int) motionEvent.getX()) - getPaddingLeft()) + getScrollX()));
            SpannableStringBuilder PW = this.aHi.PW();
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) PW.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            h.d(clickableSpanArr, "links");
            if (((clickableSpanArr.length == 0 ? 1 : 0) ^ 1) != 0) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(this);
                } else if (action == 0) {
                    Selection.setSelection(PW, PW.getSpanStart(clickableSpanArr[0]), PW.getSpanEnd(clickableSpanArr[0]));
                }
                return true;
            }
            Selection.removeSelection(PW);
        }
        return onTouchEvent;
    }
}
