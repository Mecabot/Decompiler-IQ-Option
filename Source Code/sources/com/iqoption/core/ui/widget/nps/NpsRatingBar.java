package com.iqoption.core.ui.widget.nps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.iqoption.core.j.d;

public final class NpsRatingBar extends View {
    private static final int beS = com.iqoption.core.j.b.sp14;
    private static final int beT = com.iqoption.core.j.b.sp36;
    private static final int beU = com.iqoption.core.j.b.dp2;
    private static final int beV = com.iqoption.core.j.b.dp4;
    private static final int beW = com.iqoption.core.j.b.dp14;
    private static final int beX = com.iqoption.core.j.b.dp3;
    private static final int beY = com.iqoption.core.j.a.grey_blue_50;
    private static final int beZ = com.iqoption.core.j.a.white;
    private static final int bfa = com.iqoption.core.j.a.grey_blue;
    private static final int bfb = com.iqoption.core.j.a.green;
    private static final FontMetrics bfc = new FontMetrics();
    private float bfA;
    private f bfB;
    private float bfC;
    private float bfD;
    private float bfE;
    private float bfF;
    private ValueAnimator bfG;
    private final Runnable bfH;
    private float bfI;
    private float bfJ;
    private float bfK;
    private boolean bfL;
    private boolean bfM;
    private b bfN;
    private a bfO;
    private TextPaint bfd;
    private int bfe;
    private String[] bff;
    private int bfg;
    private int bfh;
    private float bfi;
    private float bfj;
    private float bfk;
    private float bfl;
    private float bfm;
    private float bfn;
    private float bfo;
    private float bfp;
    private float bfq;
    private float bfr;
    private float bft;
    private Paint bfu;
    private int bfv;
    private int bfw;
    private Shader bfx;
    private float bfy;
    private float bfz;
    private float offset;
    private int state;

    public interface a {
        void a(@NonNull NpsRatingBar npsRatingBar, int i);
    }

    class b extends AnimatorListenerAdapter {
        private boolean bfQ;
        private boolean cancelled;

        b() {
        }

        void cn(boolean z) {
            this.bfQ = z;
        }

        public void onAnimationStart(Animator animator) {
            NpsRatingBar.this.setState(2);
            this.cancelled = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.cancelled = true;
        }

        public void onAnimationEnd(Animator animator) {
            NpsRatingBar.this.setState(0);
            if (!this.cancelled && this.bfQ) {
                NpsRatingBar.this.LA();
            }
        }
    }

    private static float d(float f, float f2, float f3) {
        return (f * (f3 - f2)) + f2;
    }

    private static int s(float f) {
        return (int) (f + 0.5f);
    }

    private long t(float f) {
        long j = (long) (f * 300.0f);
        return j > 700 ? 700 : j;
    }

    public int getRatingMax() {
        return 10;
    }

    public int getRatingMin() {
        return 0;
    }

    public NpsRatingBar(Context context) {
        super(context);
        this.bfH = new a(this);
        this.bfJ = 0.18f;
        this.bfK = 0.002f;
        init();
    }

    public NpsRatingBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfH = new b(this);
        this.bfJ = 0.18f;
        this.bfK = 0.002f;
        init();
    }

    public NpsRatingBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfH = new c(this);
        this.bfJ = 0.18f;
        this.bfK = 0.002f;
        init();
    }

    @TargetApi(21)
    public NpsRatingBar(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.bfH = new d(this);
        this.bfJ = 0.18f;
        this.bfK = 0.002f;
        init();
    }

    public void setRating(int i) {
        a((float) i, false);
    }

    public int getRating() {
        return (int) this.bfC;
    }

    public void dT(int i) {
        a((float) i, true);
    }

    public void a(float f, boolean z) {
        if (this.bfC == f) {
            return;
        }
        if (z) {
            b(f, false);
            return;
        }
        this.bfC = f;
        invalidate();
    }

    public void setOnRatingChangeListener(@Nullable a aVar) {
        this.bfO = aVar;
    }

    public void bf(long j) {
        this.bfB.bf(j);
    }

    public void setReachingSpeedCoeff(float f) {
        this.bfJ = f;
    }

    public void setReachingMinDiff(float f) {
        this.bfK = f;
    }

    void LA() {
        if (this.bfO != null) {
            this.bfO.a(this, (int) this.bfC);
        }
    }

    private float dU(@DimenRes int i) {
        return com.iqoption.core.ext.a.j(getContext(), i);
    }

    private int dV(@ColorRes int i) {
        return com.iqoption.core.ext.a.i(getContext(), i);
    }

    private void init() {
        this.bfd = new TextPaint(1);
        this.bfd.setTypeface(ResourcesCompat.getFont(getContext(), d.medium));
        this.bfg = dV(beY);
        this.bfh = dV(beZ);
        this.bfe = 11;
        this.bff = new String[this.bfe];
        this.bfi = dU(beS);
        this.bfj = dU(beT);
        this.bfm = this.bfi / this.bfj;
        this.bft = dU(beW);
        this.bfu = new Paint(1);
        this.bfu.setColor(-14077627);
        this.bfv = dV(bfa);
        this.bfw = dV(bfb);
        this.bfy = dU(beU);
        this.bfz = dU(beX);
        this.bfA = dU(beV);
        this.bfB = new f(-1, -7100222);
        this.bfB.setCallback(this);
    }

    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return drawable == this.bfB || super.verifyDrawable(drawable);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        i = MeasureSpec.getSize(i);
        this.bfd.setTextSize(this.bfj);
        this.bfd.getFontMetrics(bfc);
        float f = bfc.descent - bfc.ascent;
        int s = s(f) + this.bfB.getIntrinsicHeight();
        float measureText = this.bfd.measureText(a(this.bff, 0));
        float measureText2 = this.bfd.measureText(a(this.bff, this.bfe - 1));
        this.bfo = Math.max(measureText, (float) this.bfB.getIntrinsicWidth()) / 2.0f;
        this.bfp = Math.max(measureText2, (float) this.bfB.getIntrinsicWidth()) / 2.0f;
        this.bfk = -bfc.ascent;
        this.bfd.setTextSize(this.bfi);
        this.bfd.getFontMetrics(bfc);
        this.bfl = -bfc.ascent;
        this.bfn = f;
        this.bfq = (f - (bfc.descent - bfc.ascent)) / 2.0f;
        f = (float) i;
        this.bfr = ((f - this.bfo) - this.bfp) / 10.0f;
        if (measureText > ((float) this.bfB.getMinimumWidth())) {
            this.bfE = (measureText - ((float) this.bfB.getMinimumWidth())) / 2.0f;
        } else {
            this.bfE = 0.0f;
        }
        if (measureText2 > ((float) this.bfB.getMinimumWidth())) {
            this.bfF = f - ((measureText2 - ((float) this.bfB.getMinimumWidth())) / 2.0f);
        } else {
            this.bfF = f;
        }
        setMeasuredDimension(i, s);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bfx = new LinearGradient(this.bfo, 0.0f, ((float) i) - this.bfp, 0.0f, this.bfv, this.bfw, TileMode.CLAMP);
    }

    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        canvas.save();
        float f3 = 0.0f;
        canvas2.translate(this.bfo, 0.0f);
        float s = ((float) s(this.bfn)) + this.bft;
        float f4 = this.bfr * this.bfC;
        canvas.save();
        canvas2.translate(0.0f, s);
        float f5 = this.bfz;
        float width = (((float) getWidth()) - this.bfo) - this.bfp;
        float f6 = f5 + this.bfy;
        if (this.bfC < 10.0f) {
            this.bfu.setShader(this.bfx);
            f = f5;
            f2 = f6;
            canvas2.drawRect(0.0f, f, f4, f2, this.bfu);
            this.bfu.setShader(null);
            canvas2.drawRect(f4, f, width, f2, this.bfu);
        } else {
            this.bfu.setShader(this.bfx);
            canvas2.drawRect(0.0f, f5, width, f6, this.bfu);
        }
        canvas.restore();
        canvas.save();
        int i = 0;
        while (i < this.bfe) {
            Shader shader;
            String a = a(this.bff, i);
            f2 = this.bfC - ((float) (i + 0));
            canvas.save();
            if (i <= 0 || Math.abs(f2) >= 1.0f) {
                this.bfd.setColor(this.bfg);
                this.bfd.setTextSize(this.bfi);
                f5 = this.bfd.measureText(a);
                f6 = this.bfl + this.bfq;
            } else {
                this.bfd.setTextSize(this.bfj);
                f5 = this.bfd.measureText(a);
                f6 = this.bfk;
                float f7;
                if (f2 > f3) {
                    TextPaint textPaint = this.bfd;
                    f7 = 1.0f - f2;
                    int i2 = this.bfg;
                    f3 = this.bfh;
                    textPaint.setColor(b(f7, i2, f3));
                    f7 = d(f2, 1.0f, this.bfm);
                    canvas2.scale(f7, f7, 0.0f, this.bfn / 2.0f);
                } else {
                    f3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (f3 < null) {
                        f3 = this.bfd;
                        f3.setColor(b(f2 + 1.0f, this.bfg, this.bfh));
                        f7 = d(-f2, 1.0f, this.bfm);
                        canvas2.scale(f7, f7, 0.0f, this.bfn / 2.0f);
                    } else {
                        this.bfd.setColor(this.bfh);
                    }
                }
            }
            canvas2.drawText(a, ((-f5) / 2.0f) + 0.0f, f6, this.bfd);
            canvas.restore();
            if (0.0f < f4) {
                this.bfu.setShader(this.bfx);
                canvas2.drawCircle(0.0f, this.bfA + s, this.bfA, this.bfu);
                shader = null;
            } else {
                shader = null;
                this.bfu.setShader(null);
                canvas2.drawCircle(0.0f, this.bfA + s, this.bfA, this.bfu);
            }
            f = 0.0f + this.bfr;
            i++;
            Shader shader2 = shader;
        }
        canvas.restore();
        canvas.restore();
        int s2 = (s(this.bfo) + s(this.bfr * this.bfC)) - (this.bfB.getIntrinsicWidth() / 2);
        i = s(this.bfn);
        this.bfB.setBounds(s2, i, this.bfB.getIntrinsicWidth() + s2, this.bfB.getIntrinsicHeight() + i);
        this.bfB.draw(canvas2);
        if (!this.bfM) {
            return;
        }
        if (this.bfC != this.bfI) {
            ZJ();
            postOnAnimation(this.bfH);
            return;
        }
        cm(this.bfD != this.bfC);
    }

    private void j(int i, boolean z) {
        if (this.state != i) {
            if (z) {
                ZI();
            }
            this.state = i;
        }
    }

    void setState(int i) {
        j(i, false);
    }

    private void b(float f, boolean z) {
        if (this.bfG == null) {
            this.bfG = new ValueAnimator();
            this.bfG.setInterpolator(new FastOutSlowInInterpolator());
            this.bfN = new b();
            this.bfG.addListener(this.bfN);
            this.bfG.addUpdateListener(new e(this));
        }
        if (this.bfG.isRunning()) {
            this.bfG.cancel();
        }
        this.bfN.cn(z);
        this.bfG.setDuration(t(Math.abs(f - this.bfC)));
        this.bfG.setFloatValues(new float[]{this.bfC, f});
        this.bfG.start();
    }

    final /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.bfC = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void ZI() {
        if (this.bfG != null && this.bfG.isRunning()) {
            this.bfG.cancel();
        }
    }

    private void u(float f) {
        this.bfM = true;
        v(f);
        invalidate();
    }

    private void v(float f) {
        this.bfI = f;
        this.bfL = this.bfI > this.bfC;
    }

    private void ZJ() {
        float f;
        if (this.bfI > this.bfC) {
            f = (this.bfI - this.bfC) * this.bfJ;
            if (f >= this.bfK) {
                this.bfC += f;
                return;
            } else {
                this.bfC = this.bfI;
                return;
            }
        }
        f = (this.bfC - this.bfI) * this.bfJ;
        if (f >= this.bfK) {
            this.bfC -= f;
        } else {
            this.bfC = this.bfI;
        }
    }

    private void cm(boolean z) {
        this.bfM = false;
        if (z) {
            LA();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bfB.ZL();
        boolean z = false;
        float x;
        switch (motionEvent.getActionMasked()) {
            case 0:
                x = motionEvent.getX();
                if (A(x)) {
                    if (this.bfM) {
                        v(w(x));
                    } else {
                        this.bfD = this.bfC;
                        if (B(x)) {
                            this.offset = x - ((float) this.bfB.getBounds().centerX());
                        } else {
                            u(w(x));
                        }
                    }
                    j(1, true);
                    this.bfB.setState(PRESSED_STATE_SET);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.bfM) {
                    this.bfI = (float) s(this.bfI);
                    setState(0);
                } else {
                    x = (float) s(this.bfC);
                    if (this.bfD != x) {
                        z = true;
                    }
                    if (this.bfC != x) {
                        b(x, z);
                    } else if (z) {
                        LA();
                    }
                }
                this.bfB.setState(EMPTY_STATE_SET);
                this.offset = 0.0f;
                break;
            case 2:
                if (this.state == 1) {
                    x = w(motionEvent.getX());
                    if (x < 0.0f) {
                        x = 0.0f;
                    } else if (x > 10.0f) {
                        x = 10.0f;
                    }
                    if (!this.bfM) {
                        a(x, false);
                        break;
                    }
                    if (this.bfL == (this.bfI > this.bfC)) {
                        this.bfI = x;
                        break;
                    }
                    cm(false);
                    break;
                }
                break;
        }
        return true;
    }

    private float w(float f) {
        return (((f - this.offset) - this.bfE) - ((float) (this.bfB.getIntrinsicWidth() / 2))) / this.bfr;
    }

    private boolean A(float f) {
        return f > this.bfE && f < this.bfF;
    }

    private boolean B(float f) {
        Rect bounds = this.bfB.getBounds();
        return f > ((float) bounds.left) && f < ((float) bounds.right);
    }

    private static String a(String[] strArr, int i) {
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        str = String.valueOf(i + 0);
        strArr[i] = str;
        return str;
    }

    private static int b(float f, int i, int i2) {
        float f2 = ((float) ((i >> 24) & 255)) / 255.0f;
        float f3 = ((float) ((i >> 8) & 255)) / 255.0f;
        float f4 = ((float) ((i2 >> 24) & 255)) / 255.0f;
        float f5 = ((float) ((i2 >> 16) & 255)) / 255.0f;
        float f6 = ((float) ((i2 >> 8) & 255)) / 255.0f;
        float pow = (float) Math.pow((double) (((float) ((i >> 16) & 255)) / 255.0f), 2.2d);
        f3 = (float) Math.pow((double) f3, 2.2d);
        float pow2 = (float) Math.pow((double) (((float) (i & 255)) / 255.0f), 2.2d);
        f3 += (((float) Math.pow((double) f6, 2.2d)) - f3) * f;
        pow2 += f * (((float) Math.pow((double) (((float) (i2 & 255)) / 255.0f), 2.2d)) - pow2);
        f2 = (f2 + ((f4 - f2) * f)) * 255.0f;
        return (((s(((float) Math.pow((double) (pow + ((((float) Math.pow((double) f5, 2.2d)) - pow) * f)), 0.45454545454545453d)) * 255.0f) << 16) | (s(f2) << 24)) | (s(((float) Math.pow((double) f3, 0.45454545454545453d)) * 255.0f) << 8)) | s(((float) Math.pow((double) pow2, 0.45454545454545453d)) * 255.0f);
    }
}
