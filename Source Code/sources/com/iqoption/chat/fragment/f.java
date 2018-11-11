package com.iqoption.chat.fragment;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import com.iqoption.core.k;
import com.iqoption.util.ax;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002?@B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\bH\u0002J\u0011\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001J\u0011\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020$H\u0001J\u0011\u0010(\u001a\u00020\u00012\u0006\u0010%\u001a\u00020$H\u0001J\u0011\u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020$H\u0001J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u0011\u0010.\u001a\u00020\u00132\u0006\u0010%\u001a\u00020$H\u0001J\u0011\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0001J\u0011\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020$H\u0001J*\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020$2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020403\"\u000204H\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u000207H\u0001J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020$H\u0016J\u0012\u0010:\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0011\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0013H\u0001R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, aXE = {"Lcom/iqoption/chat/fragment/DateDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/iqoption/core/Resourcer;", "resourcer", "dateComparator", "Lcom/iqoption/chat/fragment/DateComparator;", "(Lcom/iqoption/core/Resourcer;Lcom/iqoption/chat/fragment/DateComparator;)V", "value", "", "date", "getDate", "()J", "setDate", "(J)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "datePadding", "Landroid/graphics/RectF;", "dateRadius", "", "dateRect", "dateText", "", "dateYearFormat", "fontMetrics", "Lcom/iqoption/chat/fragment/DateDrawable$FontMetrics;", "rectPaint", "Landroid/graphics/Paint;", "textPaint", "Landroid/text/TextPaint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "formatDate", "getColor", "", "resId", "getColors", "Landroid/content/res/ColorStateList;", "getDrawable", "getFont", "Landroid/graphics/Typeface;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getPixels", "getPixelsInt", "getString", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getViewConfiguration", "Landroid/view/ViewConfiguration;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "toPixels", "dp", "Companion", "FontMetrics", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DateDrawable.kt */
public final class f extends Drawable implements k {
    private static final long aFW = TimeUnit.DAYS.toMillis(1);
    public static final a aFX = new a();
    private final SimpleDateFormat aEF = new SimpleDateFormat("MMMM d yyyy", Locale.getDefault());
    private long aFN;
    private final Paint aFO;
    private final TextPaint aFP;
    private final b aFQ;
    private String aFR;
    private final float aFS;
    private final RectF aFT;
    private final RectF aFU;
    private final e aFV;
    private final /* synthetic */ k aFY;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d", Locale.getDefault());

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/chat/fragment/DateDrawable$Companion;", "", "()V", "DAY", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DateDrawable.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0012"}, aXE = {"Lcom/iqoption/chat/fragment/DateDrawable$FontMetrics;", "Landroid/graphics/Paint$FontMetrics;", "paint", "Landroid/graphics/Paint;", "(Landroid/graphics/Paint;)V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "width", "getWidth", "setWidth", "update", "", "text", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DateDrawable.kt */
    private static final class b extends FontMetrics {
        private float height;
        private final Paint kx;
        private float width;

        public b(Paint paint) {
            h.e(paint, "paint");
            this.kx = paint;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getHeight() {
            return this.height;
        }

        public final void fM(String str) {
            h.e(str, "text");
            this.width = this.kx.measureText(str);
            this.kx.getFontMetrics(this);
            this.height = this.descent - this.ascent;
        }
    }

    public CharSequence dA(int i) {
        return this.aFY.dA(i);
    }

    public ColorStateList dx(int i) {
        return this.aFY.dx(i);
    }

    public float dy(int i) {
        return this.aFY.dy(i);
    }

    public int dz(int i) {
        return this.aFY.dz(i);
    }

    public int getColor(int i) {
        return this.aFY.getColor(i);
    }

    public Drawable getDrawable(int i) {
        return this.aFY.getDrawable(i);
    }

    public Typeface getFont(int i) {
        return this.aFY.getFont(i);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public f(k kVar, e eVar) {
        h.e(kVar, "resourcer");
        h.e(eVar, "dateComparator");
        this.aFY = kVar;
        this.aFV = eVar;
        Paint paint = new Paint(1);
        paint.setColor(getColor(R.color.chat_date_badge_bg));
        this.aFO = paint;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(getColor(R.color.chat_date_badge_text));
        textPaint.setTypeface(getFont(R.font.bold));
        textPaint.setTextSize(dy(R.dimen.sp12));
        if (ax.dws) {
            textPaint.setLetterSpacing(0.02f);
        }
        this.aFP = textPaint;
        this.aFQ = new b(this.aFP);
        this.aFR = "";
        this.aFS = dy(R.dimen.dp13);
        this.aFT = new RectF(dy(R.dimen.dp11), dy(R.dimen.dp6), dy(R.dimen.dp11), dy(R.dimen.dp7));
        this.aFU = new RectF();
    }

    public final long getDate() {
        return this.aFN;
    }

    public final void setDate(long j) {
        j = (j / aFW) * aFW;
        if (this.aFN != j) {
            this.aFN = j;
            String aM = aM(j);
            this.aFQ.fM(aM);
            this.aFR = aM;
            RectF rectF = this.aFU;
            rectF.set(0.0f, 0.0f, this.aFQ.getWidth(), this.aFQ.getHeight());
            float f = rectF.right;
            RectF rectF2 = this.aFT;
            rectF.right = f + (rectF2.left + rectF2.right);
            f = rectF.bottom;
            rectF2 = this.aFT;
            rectF.bottom = f + (rectF2.top + rectF2.bottom);
            invalidateSelf();
        }
    }

    private final String aM(long j) {
        Object dA;
        if (this.aFV.isToday(j)) {
            dA = dA(R.string.today);
        } else if (this.aFV.aK(j)) {
            dA = dA(R.string.yesterday);
        } else if (this.aFV.aL(j)) {
            dA = this.dateFormat.format(Long.valueOf(j));
        } else {
            dA = this.aEF.format(Long.valueOf(j));
        }
        return dA.toString();
    }

    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
            canvas.translate((float) getBounds().left, (float) getBounds().top);
            canvas.drawRoundRect(this.aFU, this.aFS, this.aFS, this.aFO);
            canvas.translate(this.aFT.left, this.aFT.top);
            String str = this.aFR;
            b bVar = this.aFQ;
            canvas.drawText(str, 0.0f, bVar.getHeight() - bVar.descent, this.aFP);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return (int) this.aFU.width();
    }

    public int getIntrinsicHeight() {
        return (int) this.aFU.height();
    }
}
