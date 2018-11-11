package at.grabner.circleprogress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import jumio.nv.nfc.a;

/* compiled from: CircleProgressView */
public class c extends View {
    private int hA = 40;
    private int hB = 270;
    private float hC = 1.0f;
    private int hD = 10;
    private float hE = 1.0f;
    private float hF = 1.0f;
    private int hG = -16738680;
    private int hH = -1442840576;
    private int hI = this.hG;
    private int hJ = 0;
    private int hK = -1434201911;
    private int hL = ViewCompat.MEASURED_STATE_MASK;
    private boolean hM = false;
    private int[] hN = new int[]{this.hG};
    private Cap hO = Cap.BUTT;
    private Cap hP = Cap.BUTT;
    private Paint hQ = new Paint();
    private Paint hR = new Paint();
    private Paint hS = new Paint();
    private Paint hT = new Paint();
    private Paint hU = new Paint();
    private Paint hV = new Paint();
    private RectF hW = new RectF();
    private RectF hX = new RectF();
    private PointF hY;
    private RectF hZ = new RectF();
    float hp = 42.0f;
    float hq = 0.0f;
    float hr = 0.0f;
    float hs = 100.0f;
    float ht = 0.0f;
    float hu = 42.0f;
    float hv = 0.0f;
    private int hw = 0;
    private int hx = 0;
    private int hy = 80;
    private int hz = 40;
    private boolean iA = false;
    private int iB = 18;
    private float iC = 0.9f;
    private float iD = (360.0f / ((float) this.iB));
    private float iE = (this.iD * this.iC);
    private int iF;
    private RectF ia = new RectF();
    private RectF ib = new RectF();
    private RectF ic = new RectF();
    private RectF ie = new RectF();
    float if = 2.8f;
    double ig = 900.0d;
    int ih = 15;
    boolean ii;
    Handler ij = new a(this);
    AnimationState ik = AnimationState.IDLE;
    private String il = "";
    private String im = "";
    private int io;
    private TextMode iq = TextMode.PERCENT;
    private boolean ir;
    private boolean is = false;
    private Bitmap iu;
    private Paint iv = new Paint(1);
    private float iw = 0.3f;
    private boolean ix = false;
    private boolean iy = false;
    b iz;
    private int mPaddingBottom = 5;
    private int mPaddingLeft = 5;
    private int mPaddingRight = 5;
    private int mPaddingTop = 5;
    private int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    private Paint mTextPaint = new Paint();
    private int mTextSize = 10;

    public static float c(float f) {
        return ((f % 360.0f) + 360.0f) % 360.0f;
    }

    public c(Context context) {
        super(context);
        this.iv.setFilterBitmap(false);
        this.iv.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        cI();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        i = getMeasuredWidth();
        i = (i - getPaddingLeft()) - getPaddingRight();
        i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (i > i2) {
            i = i2;
        }
        setMeasuredDimension((getPaddingLeft() + i) + getPaddingRight(), (i + getPaddingTop()) + getPaddingBottom());
    }

    private RectF a(RectF rectF) {
        float f;
        float width = (rectF.width() - ((float) ((((double) ((rectF.width() - ((float) Math.max(this.hz, this.hA))) - (this.hC * 2.0f))) / 2.0d) * Math.sqrt(2.0d)))) / 2.0f;
        float f2 = 1.0f;
        if (cH()) {
            f2 = 0.77f;
            f = 1.33f;
        } else {
            f = 1.0f;
        }
        f2 *= width;
        width *= f;
        return new RectF(rectF.left + f2, rectF.top + width, rectF.right - f2, rectF.bottom - width);
    }

    private static float a(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        str = str.replace('1', '0');
        paint.getTextBounds(str, 0, str.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.hx = i;
        this.hw = i2;
        cQ();
        cP();
        if (this.iu != null) {
            this.iu = Bitmap.createScaledBitmap(this.iu, getWidth(), getHeight(), false);
        }
        invalidate();
    }

    public void setAnimationStateChangedListener(b bVar) {
        this.iz = bVar;
    }

    public int getUnitSize() {
        return this.hD;
    }

    public void setUnitSize(@IntRange(from = 0) int i) {
        this.hD = i;
        this.hU.setTextSize((float) i);
    }

    public void setSeekModeEnabled(boolean z) {
        this.ix = z;
    }

    public Cap getSpinnerStrokeCap() {
        return this.hP;
    }

    public void setSpinnerStrokeCap(Cap cap) {
        this.hP = cap;
        this.hR.setStrokeCap(cap);
    }

    public Cap getBarStrokeCap() {
        return this.hO;
    }

    public void setBarStrokeCap(Cap cap) {
        this.hO = cap;
        this.hQ.setStrokeCap(cap);
    }

    public int getContourColor() {
        return this.hH;
    }

    public void setContourColor(@ColorInt int i) {
        this.hH = i;
        this.hV.setColor(i);
    }

    public float getContourSize() {
        return this.hC;
    }

    public void setContourSize(@FloatRange(from = 0.0d) float f) {
        this.hC = f;
        this.hV.setStrokeWidth(f);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.il = str;
        invalidate();
    }

    public void setTextMode(TextMode textMode) {
        this.iq = textMode;
    }

    public String getUnit() {
        return this.im;
    }

    public void setUnit(String str) {
        if (str == null) {
            this.im = "";
        } else {
            this.im = str;
        }
        invalidate();
    }

    private RectF b(String str, Paint paint, RectF rectF) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + ((rectF.width() - ((float) rect.width())) / 2.0f);
        rectF2.top = rectF.top + ((rectF.height() - ((float) rect.height())) / 2.0f);
        rectF2.right = rectF2.left + ((float) rect.width());
        rectF2.bottom = rectF2.top + ((float) rect.height());
        return rectF2;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(@IntRange(from = 0) int i) {
        this.mTextPaint.setTextSize((float) i);
        this.mTextSize = i;
        this.ir = false;
    }

    public void setAutoTextSize(boolean z) {
        this.ir = z;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void setPaddingTop(int i) {
        this.mPaddingTop = i;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public void setPaddingBottom(int i) {
        this.mPaddingBottom = i;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
    }

    public int getCircleRadius() {
        return this.hy;
    }

    public boolean cH() {
        return this.is;
    }

    public void setShowUnit(boolean z) {
        if (z != this.is) {
            this.is = z;
            this.io = 0;
            this.hZ = a(this.hW);
            invalidate();
        }
    }

    public float getUnitScale() {
        return this.hF;
    }

    public void setUnitScale(@FloatRange(from = 0.0d) float f) {
        this.hF = f;
    }

    public float getTextScale() {
        return this.hE;
    }

    public void setTextScale(@FloatRange(from = 0.0d) float f) {
        this.hE = f;
    }

    public void setSpinningBarLength(@FloatRange(from = 0.0d) float f) {
        this.hu = f;
        this.ht = f;
    }

    public int getBarWidth() {
        return this.hz;
    }

    public void setBarWidth(@FloatRange(from = 0.0d) int i) {
        this.hz = i;
        float f = (float) i;
        this.hQ.setStrokeWidth(f);
        this.hR.setStrokeWidth(f);
    }

    public int[] getBarColors() {
        return this.hN;
    }

    public void setBarColor(@ColorInt int... iArr) {
        this.hN = iArr;
        if (this.hN.length > 1) {
            this.hQ.setShader(new SweepGradient(this.hW.centerX(), this.hW.centerY(), this.hN, null));
            Matrix matrix = new Matrix();
            this.hQ.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.hW.centerX(), -this.hW.centerY());
            matrix.postRotate((float) this.hB);
            matrix.postTranslate(this.hW.centerX(), this.hW.centerY());
            this.hQ.getShader().setLocalMatrix(matrix);
            this.hQ.setColor(iArr[0]);
        } else if (this.hN.length == 0) {
            this.hQ.setColor(this.hN[0]);
            this.hQ.setShader(null);
        } else {
            this.hQ.setColor(this.hG);
            this.hQ.setShader(null);
        }
    }

    public void setSpinBarColor(@ColorInt int i) {
        this.hI = i;
        this.hR.setColor(this.hI);
    }

    public int getBackgroundCircleColor() {
        return this.hS.getColor();
    }

    public void setFillCircleColor(@ColorInt int i) {
        this.hJ = i;
        this.hS.setColor(i);
    }

    public int getRimColor() {
        return this.hK;
    }

    public void setRimColor(@ColorInt int i) {
        this.hK = i;
        this.hT.setColor(i);
    }

    public Shader getRimShader() {
        return this.hT.getShader();
    }

    public void setRimShader(Shader shader) {
        this.hT.setShader(shader);
    }

    private int a(double d) {
        int i = 0;
        if (this.hN.length <= 1) {
            return this.hN.length == 1 ? this.hN[0] : ViewCompat.MEASURED_STATE_MASK;
        } else {
            double maxValue = (1.0d / getMaxValue()) * d;
            int floor = (int) Math.floor(((double) (this.hN.length - 1)) * maxValue);
            int i2 = floor + 1;
            if (floor < 0) {
                floor = 1;
            } else if (i2 >= this.hN.length) {
                i = this.hN.length - 2;
                floor = this.hN.length - 1;
            } else {
                i = floor;
                floor = i2;
            }
            return d.a(this.hN[i], this.hN[floor], (float) (1.0d - ((((double) (this.hN.length - 1)) * maxValue) % 1.0d)));
        }
    }

    public double getMaxValue() {
        return (double) this.hs;
    }

    public void setMaxValue(@FloatRange(from = 0.0d) float f) {
        this.hs = f;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setTextColor(@ColorInt int i) {
        this.mTextColor = i;
        this.mTextPaint.setColor(i);
    }

    public void setAutoTextColor(boolean z) {
        this.hM = z;
    }

    public void setUnitColor(@ColorInt int i) {
        this.hL = i;
        this.hU.setColor(i);
        this.hM = false;
    }

    public float getSpinSpeed() {
        return this.if;
    }

    public void setSpinSpeed(float f) {
        this.if = f;
    }

    public int getRimWidth() {
        return this.hA;
    }

    public void setRimWidth(@IntRange(from = 0) int i) {
        this.hA = i;
        this.hT.setStrokeWidth((float) i);
    }

    public int getDelayMillis() {
        return this.ih;
    }

    public void setDelayMillis(int i) {
        this.ih = i;
    }

    @TargetApi(11)
    public void setClippingBitmap(Bitmap bitmap) {
        if (getWidth() <= 0 || getHeight() <= 0) {
            this.iu = bitmap;
        } else {
            this.iu = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        if (this.iu == null) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setTextTypeface(Typeface typeface) {
        this.mTextPaint.setTypeface(typeface);
    }

    public void setUnitTextTypeface(Typeface typeface) {
        this.hU.setTypeface(typeface);
    }

    public float getRelativeUniteSize() {
        return this.iw;
    }

    public void setRelativeUniteSize(@FloatRange(from = 0.0d) float f) {
        this.iw = f;
    }

    public void setShowTextWhileSpinning(boolean z) {
        this.iy = z;
    }

    public int getStartAngle() {
        return this.hB;
    }

    public void setStartAngle(int i) {
        this.hB = (int) c((float) i);
    }

    public void setShowBlock(boolean z) {
        this.iA = z;
    }

    public void setBlockCount(int i) {
        if (i > 1) {
            this.iA = true;
            this.iB = i;
            this.iD = 360.0f / ((float) i);
            this.iE = this.iD * this.iC;
            return;
        }
        this.iA = false;
    }

    public void setBlockScale(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.iC = f;
            this.iE = this.iD * f;
        }
    }

    public int getBlockCount() {
        return this.iB;
    }

    public float getBlockScale() {
        return this.iC;
    }

    public void cI() {
        cP();
        cO();
        cJ();
        cK();
        cL();
        cM();
        cN();
    }

    private void cJ() {
        this.hV.setColor(this.hH);
        this.hV.setAntiAlias(true);
        this.hV.setStyle(Style.STROKE);
        this.hV.setStrokeWidth(this.hC);
    }

    private void cK() {
        this.hU.setStyle(Style.FILL);
        this.hU.setAntiAlias(true);
    }

    private void cL() {
        this.mTextPaint.setSubpixelText(true);
        this.mTextPaint.setLinearText(true);
        this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setStyle(Style.FILL);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize((float) this.mTextSize);
    }

    private void cM() {
        this.hS.setColor(this.hJ);
        this.hS.setAntiAlias(true);
        this.hS.setStyle(Style.FILL);
    }

    private void cN() {
        this.hT.setColor(this.hK);
        this.hT.setAntiAlias(true);
        this.hT.setStyle(Style.STROKE);
        this.hT.setStrokeWidth((float) this.hA);
    }

    private void cO() {
        this.hR.setAntiAlias(true);
        this.hR.setStrokeCap(this.hP);
        this.hR.setStyle(Style.STROKE);
        this.hR.setStrokeWidth((float) this.hz);
        this.hR.setColor(this.hI);
    }

    private void cP() {
        if (this.hN.length > 1) {
            this.hQ.setShader(new SweepGradient(this.hW.centerX(), this.hW.centerY(), this.hN, null));
            Matrix matrix = new Matrix();
            this.hQ.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.hW.centerX(), -this.hW.centerY());
            matrix.postRotate((float) this.hB);
            matrix.postTranslate(this.hW.centerX(), this.hW.centerY());
            this.hQ.getShader().setLocalMatrix(matrix);
        } else {
            this.hQ.setColor(this.hN[0]);
            this.hQ.setShader(null);
        }
        this.hQ.setAntiAlias(true);
        this.hQ.setStrokeCap(this.hO);
        this.hQ.setStyle(Style.STROKE);
        this.hQ.setStrokeWidth((float) this.hz);
    }

    private void cQ() {
        int min = Math.min(this.hx, this.hw);
        int i = this.hx - min;
        int i2 = (this.hw - min) / 2;
        this.mPaddingTop = getPaddingTop() + i2;
        this.mPaddingBottom = getPaddingBottom() + i2;
        i /= 2;
        this.mPaddingLeft = getPaddingLeft() + i;
        this.mPaddingRight = getPaddingRight() + i;
        min = getWidth();
        i = getHeight();
        this.hW = new RectF((float) (this.mPaddingLeft + this.hz), (float) (this.mPaddingTop + this.hz), (float) ((min - this.mPaddingRight) - this.hz), (float) ((i - this.mPaddingBottom) - this.hz));
        this.hX = new RectF(((float) this.mPaddingLeft) + (((float) this.hz) * 1.5f), ((float) this.mPaddingTop) + (((float) this.hz) * 1.5f), ((float) (min - this.mPaddingRight)) - (((float) this.hz) * 1.5f), ((float) (i - this.mPaddingBottom)) - (((float) this.hz) * 1.5f));
        this.hZ = a(this.hW);
        this.ie = new RectF((this.hW.left + (((float) this.hA) / 2.0f)) + (this.hC / 2.0f), (this.hW.top + (((float) this.hA) / 2.0f)) + (this.hC / 2.0f), (this.hW.right - (((float) this.hA) / 2.0f)) - (this.hC / 2.0f), (this.hW.bottom - (((float) this.hA) / 2.0f)) - (this.hC / 2.0f));
        this.ic = new RectF((this.hW.left - (((float) this.hA) / 2.0f)) - (this.hC / 2.0f), (this.hW.top - (((float) this.hA) / 2.0f)) - (this.hC / 2.0f), (this.hW.right + (((float) this.hA) / 2.0f)) + (this.hC / 2.0f), (this.hW.bottom + (((float) this.hA) / 2.0f)) + (this.hC / 2.0f));
        this.hy = ((((min - this.mPaddingRight) - this.hz) / 2) - this.hz) + 1;
        this.hY = new PointF(this.hW.centerX(), this.hW.centerY());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (360.0f / this.hs) * this.hp;
        if (this.hJ != 0) {
            canvas.drawArc(this.hX, 360.0f, 360.0f, false, this.hS);
        }
        if (this.hA > 0) {
            if (this.iA) {
                a(canvas, this.hW, (float) this.hB, 360.0f, false, this.hT);
            } else {
                canvas.drawArc(this.hW, 360.0f, 360.0f, false, this.hT);
            }
        }
        if (this.hC > 0.0f) {
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.ic, 360.0f, 360.0f, false, this.hV);
            canvas2.drawArc(this.ie, 360.0f, 360.0f, false, this.hV);
        }
        if (this.ik == AnimationState.SPINNING || this.ik == AnimationState.END_SPINNING) {
            b(canvas);
            if (this.iy) {
                c(canvas);
            }
        } else if (this.ik == AnimationState.END_SPINNING_START_ANIMATING) {
            b(canvas);
            if (this.ii) {
                a(canvas, f);
                c(canvas);
            } else if (this.iy) {
                c(canvas);
            }
        } else {
            a(canvas, f);
            c(canvas);
        }
        if (this.iu != null) {
            canvas.drawBitmap(this.iu, 0.0f, 0.0f, this.iv);
        }
    }

    private void b(Canvas canvas) {
        if (this.ht < 0.0f) {
            this.ht = 1.0f;
        }
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.hW, (((float) this.hB) + this.hv) - this.ht, this.ht, false, this.hR);
    }

    private void a(Canvas canvas, float f) {
        if (this.iA) {
            a(canvas, this.hW, (float) this.hB, f, false, this.hQ);
            return;
        }
        canvas.drawArc(this.hW, (float) this.hB, f, false, this.hQ);
    }

    private void a(Canvas canvas, RectF rectF, float f, float f2, boolean z, Paint paint) {
        float f3 = 0.0f;
        while (f3 < f2) {
            canvas.drawArc(rectF, f + f3, Math.min(this.iE, f2 - f3), z, paint);
            f3 += this.iD;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A:{SYNTHETIC, RETURN} */
    private void c(android.graphics.Canvas r13) {
        /*
        r12 = this;
        r0 = r12.hM;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = r12.mTextPaint;
        r1 = r12.hp;
        r1 = (double) r1;
        r1 = r12.a(r1);
        r0.setColor(r1);
    L_0x0010:
        r0 = at.grabner.circleprogress.c.AnonymousClass1.a;
        r1 = r12.iq;
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 2: goto L_0x002f;
            case 3: goto L_0x0024;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = r12.il;
        if (r0 == 0) goto L_0x0041;
    L_0x0021:
        r0 = r12.il;
        goto L_0x0043;
    L_0x0024:
        r0 = r12.hp;
        r0 = java.lang.Math.round(r0);
        r0 = java.lang.String.valueOf(r0);
        goto L_0x0043;
    L_0x002f:
        r0 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r1 = r12.hs;
        r0 = r0 / r1;
        r1 = r12.hp;
        r0 = r0 * r1;
        r0 = java.lang.Math.round(r0);
        r0 = java.lang.String.valueOf(r0);
        goto L_0x0043;
    L_0x0041:
        r0 = "";
    L_0x0043:
        r1 = r12.ir;
        r2 = 1028443341; // 0x3d4ccccd float:0.05 double:5.081185235E-315;
        r3 = 1065604874; // 0x3f83d70a float:1.03 double:5.264787603E-315;
        r4 = 0;
        r5 = 1;
        if (r1 == 0) goto L_0x00d7;
    L_0x004f:
        r1 = r12.io;
        r6 = r0.length();
        if (r1 == r6) goto L_0x0154;
    L_0x0057:
        r1 = r0.length();
        r12.io = r1;
        r1 = r12.io;
        if (r1 != r5) goto L_0x008e;
    L_0x0061:
        r1 = new android.graphics.RectF;
        r6 = r12.hZ;
        r6 = r6.left;
        r7 = r12.hZ;
        r7 = r7.width();
        r8 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
        r7 = r7 * r8;
        r6 = r6 + r7;
        r7 = r12.hZ;
        r7 = r7.top;
        r9 = r12.hZ;
        r9 = r9.right;
        r10 = r12.hZ;
        r10 = r10.width();
        r10 = r10 * r8;
        r9 = r9 - r10;
        r8 = r12.hZ;
        r8 = r8.bottom;
        r1.<init>(r6, r7, r9, r8);
        r12.hZ = r1;
        goto L_0x0096;
    L_0x008e:
        r1 = r12.hW;
        r1 = r12.a(r1);
        r12.hZ = r1;
    L_0x0096:
        r1 = r12.hZ;
        r6 = r12.is;
        if (r6 == 0) goto L_0x00be;
    L_0x009c:
        r1 = new android.graphics.RectF;
        r6 = r12.hZ;
        r6 = r6.left;
        r7 = r12.hZ;
        r7 = r7.top;
        r8 = r12.hZ;
        r8 = r8.right;
        r9 = r12.hZ;
        r9 = r9.width();
        r10 = r12.iw;
        r9 = r9 * r10;
        r9 = r9 * r3;
        r8 = r8 - r9;
        r9 = r12.hZ;
        r9 = r9.bottom;
        r1.<init>(r6, r7, r8, r9);
    L_0x00be:
        r6 = r12.mTextPaint;
        r7 = r12.mTextPaint;
        r7 = a(r0, r7, r1);
        r8 = r12.hE;
        r7 = r7 * r8;
        r6.setTextSize(r7);
        r6 = r12.mTextPaint;
        r1 = r12.b(r0, r6, r1);
        r12.ia = r1;
        goto L_0x0155;
    L_0x00d7:
        r1 = r12.io;
        r6 = r0.length();
        if (r1 == r6) goto L_0x0154;
    L_0x00df:
        r1 = r0.length();
        r12.io = r1;
        r1 = r12.mTextPaint;
        r6 = r12.mTextSize;
        r6 = (float) r6;
        r1.setTextSize(r6);
        r1 = r12.mTextPaint;
        r6 = r12.hW;
        r1 = r12.b(r0, r1, r6);
        r12.hZ = r1;
        r12.ia = r1;
        r1 = r12.is;
        if (r1 == 0) goto L_0x0155;
    L_0x00fd:
        r1 = r12.hU;
        r6 = r12.hD;
        r6 = (float) r6;
        r1.setTextSize(r6);
        r1 = r12.im;
        r6 = r12.hU;
        r7 = r12.hW;
        r1 = r12.b(r1, r6, r7);
        r12.ib = r1;
        r1 = r12.hX;
        r1 = r1.width();
        r1 = r1 * r2;
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r1 / r6;
        r7 = new android.graphics.RectF;
        r8 = r12.hZ;
        r8 = r8.left;
        r9 = r12.ib;
        r9 = r9.width();
        r9 = r9 / r6;
        r8 = r8 - r9;
        r8 = r8 - r1;
        r9 = r12.hZ;
        r9 = r9.top;
        r10 = r12.hZ;
        r10 = r10.right;
        r11 = r12.ib;
        r11 = r11.width();
        r11 = r11 / r6;
        r10 = r10 + r11;
        r10 = r10 + r1;
        r11 = r12.hZ;
        r11 = r11.bottom;
        r7.<init>(r8, r9, r10, r11);
        r12.hZ = r7;
        r7 = r12.ia;
        r8 = r12.ib;
        r8 = r8.width();
        r8 = r8 / r6;
        r6 = -r8;
        r6 = r6 - r1;
        r7.offset(r6, r4);
        goto L_0x0155;
    L_0x0154:
        r5 = 0;
    L_0x0155:
        r1 = r12.ia;
        r1 = r1.left;
        r6 = r12.mTextPaint;
        r6 = r6.getTextSize();
        r7 = 1035489772; // 0x3db851ec float:0.09 double:5.11599923E-315;
        r6 = r6 * r7;
        r1 = r1 - r6;
        r6 = r12.ia;
        r6 = r6.bottom;
        r7 = r12.mTextPaint;
        r13.drawText(r0, r1, r6, r7);
        r0 = r12.is;
        if (r0 == 0) goto L_0x0217;
    L_0x0172:
        r0 = r12.hM;
        if (r0 == 0) goto L_0x0182;
    L_0x0176:
        r0 = r12.hU;
        r1 = r12.hp;
        r6 = (double) r1;
        r1 = r12.a(r6);
        r0.setColor(r1);
    L_0x0182:
        if (r5 == 0) goto L_0x0208;
    L_0x0184:
        r0 = r12.ir;
        if (r0 == 0) goto L_0x01cf;
    L_0x0188:
        r0 = new android.graphics.RectF;
        r1 = r12.hZ;
        r1 = r1.left;
        r2 = r12.hZ;
        r2 = r2.width();
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r6 = r12.iw;
        r5 = r5 - r6;
        r2 = r2 * r5;
        r2 = r2 * r3;
        r1 = r1 + r2;
        r2 = r12.hZ;
        r2 = r2.top;
        r3 = r12.hZ;
        r3 = r3.right;
        r5 = r12.hZ;
        r5 = r5.bottom;
        r0.<init>(r1, r2, r3, r5);
        r12.ib = r0;
        r0 = r12.hU;
        r1 = r12.im;
        r2 = r12.hU;
        r3 = r12.ib;
        r1 = a(r1, r2, r3);
        r2 = r12.hF;
        r1 = r1 * r2;
        r0.setTextSize(r1);
        r0 = r12.im;
        r1 = r12.hU;
        r2 = r12.ib;
        r0 = r12.b(r0, r1, r2);
        r12.ib = r0;
        goto L_0x01fa;
    L_0x01cf:
        r0 = r12.hX;
        r0 = r0.width();
        r0 = r0 * r2;
        r1 = r12.hU;
        r2 = r12.hD;
        r2 = (float) r2;
        r1.setTextSize(r2);
        r1 = r12.im;
        r2 = r12.hU;
        r3 = r12.hW;
        r1 = r12.b(r1, r2, r3);
        r12.ib = r1;
        r1 = r12.ia;
        r1 = r1.right;
        r2 = r12.ib;
        r2 = r2.left;
        r1 = r1 - r2;
        r1 = r1 + r0;
        r0 = r12.ib;
        r0.offset(r1, r4);
    L_0x01fa:
        r0 = r12.ia;
        r0 = r0.top;
        r1 = r12.ib;
        r1 = r1.top;
        r0 = r0 - r1;
        r1 = r12.ib;
        r1.offset(r4, r0);
    L_0x0208:
        r0 = r12.im;
        r1 = r12.ib;
        r1 = r1.left;
        r2 = r12.ib;
        r2 = r2.bottom;
        r3 = r12.hU;
        r13.drawText(r0, r1, r2, r3);
    L_0x0217:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.c.c(android.graphics.Canvas):void");
    }

    public void setValue(float f) {
        Message message = new Message();
        message.what = a.SET_VALUE.ordinal();
        message.obj = new float[]{f, f};
        this.ij.sendMessage(message);
    }

    public void a(float f, long j) {
        this.ig = (double) j;
        Message message = new Message();
        message.what = a.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{this.hp, f};
        this.ij.sendMessage(message);
    }

    public void setValueAnimated(float f) {
        this.ig = 1200.0d;
        Message message = new Message();
        message.what = a.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{this.hp, f};
        this.ij.sendMessage(message);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.ix) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 1:
                this.iF = 0;
                a((this.hs / 360.0f) * c((float) Math.round(a(this.hY, new PointF(motionEvent.getX(), motionEvent.getY())) - ((double) this.hB))), 800);
                return true;
            case 2:
                this.iF++;
                if (this.iF <= 5) {
                    return false;
                }
                setValue((this.hs / 360.0f) * c((float) Math.round(a(this.hY, new PointF(motionEvent.getX(), motionEvent.getY())) - ((double) this.hB))));
                return true;
            case 3:
                this.iF = 0;
                return false;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public static double a(PointF pointF, PointF pointF2) {
        double toDegrees = Math.toDegrees(Math.atan2((double) (pointF2.y - pointF.y), (double) (pointF2.x - pointF.x)));
        return toDegrees < 0.0d ? toDegrees + 360.0d : toDegrees;
    }
}
