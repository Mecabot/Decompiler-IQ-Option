package io.card.payment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.b;
import java.lang.ref.WeakReference;

/* compiled from: OverlayView */
class i extends View {
    private static final String TAG = "i";
    private static final Orientation[] ekT = new Orientation[]{Orientation.TOP_BOTTOM, Orientation.LEFT_RIGHT, Orientation.BOTTOM_TOP, Orientation.RIGHT_LEFT};
    private int dSk;
    private CreditCard ejJ;
    private DetectionInfo ekU;
    private Rect ekV;
    private int ekW;
    private boolean ekX;
    private String ekY;
    private GradientDrawable ekZ;
    private final WeakReference<CardIOActivity> ekd;
    private final Paint ela;
    private final Paint elb;
    private Path elc;
    private Rect eld;
    private final l ele;
    private final f elf;
    private Rect elg;
    private Rect elh;
    private final boolean eli;
    private int elj;
    private Bitmap mBitmap;
    private float mScale = 1.0f;
    private int mState;

    public i(CardIOActivity cardIOActivity, AttributeSet attributeSet, boolean z) {
        super(cardIOActivity, attributeSet);
        this.eli = z;
        this.ekd = new WeakReference(cardIOActivity);
        this.elj = 1;
        this.mScale = getResources().getDisplayMetrics().density / 1.5f;
        this.ele = new l(this.mScale * 70.0f, this.mScale * 50.0f);
        this.elf = new f(cardIOActivity);
        this.ela = new Paint(1);
        this.elb = new Paint(1);
        this.elb.clearShadowLayer();
        this.elb.setStyle(Style.FILL);
        this.elb.setColor(-1157627904);
        this.ekY = b.a(StringKey.SCAN_GUIDE);
    }

    public void iQ(int i) {
        this.ekW = i;
    }

    public void gn(boolean z) {
        this.ekX = z;
    }

    public void lp(String str) {
        this.ekY = str;
    }

    public void a(Rect rect, int i) {
        Point point;
        this.dSk = i;
        this.ekV = rect;
        invalidate();
        if (this.dSk % 180 != 0) {
            point = new Point((int) (this.mScale * 40.0f), (int) (this.mScale * 60.0f));
            this.elj = -1;
        } else {
            point = new Point((int) (this.mScale * 60.0f), (int) (this.mScale * 40.0f));
            this.elj = 1;
        }
        if (this.eld != null) {
            this.elg = m.a(new Point(this.eld.left + point.x, this.eld.top + point.y), (int) (this.mScale * 70.0f), (int) (this.mScale * 50.0f));
            this.elh = m.a(new Point(this.eld.right - point.x, this.eld.top + point.y), (int) (this.mScale * 100.0f), (int) (this.mScale * 50.0f));
            this.ekZ = new GradientDrawable(ekT[(this.dSk / 90) % 4], new int[]{-1, ViewCompat.MEASURED_STATE_MASK});
            this.ekZ.setGradientType(0);
            this.ekZ.setBounds(this.ekV);
            this.ekZ.setAlpha(50);
            this.elc = new Path();
            this.elc.addRect(new RectF(this.eld), Direction.CW);
            this.elc.addRect(new RectF(this.ekV), Direction.CCW);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            aTR();
        }
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void b(DetectionInfo detectionInfo) {
        if (!(this.ekU == null || this.ekU.a(detectionInfo))) {
            invalidate();
        }
        this.ekU = detectionInfo;
    }

    public Bitmap aTQ() {
        return (this.mBitmap == null || this.mBitmap.isRecycled()) ? null : Bitmap.createBitmap(this.mBitmap, 0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
    }

    private Rect j(int i, int i2, int i3, int i4) {
        int i5 = (int) (this.mScale * 8.0f);
        Rect rect = new Rect();
        rect.left = Math.min(i, i3) - i5;
        rect.right = Math.max(i, i3) + i5;
        rect.top = Math.min(i2, i4) - i5;
        rect.bottom = Math.max(i2, i4) + i5;
        return rect;
    }

    public void onDraw(Canvas canvas) {
        if (this.ekV != null && this.eld != null) {
            int i;
            canvas.save();
            this.ekZ.draw(canvas);
            if (this.dSk == 0 || this.dSk == 180) {
                i = (this.ekV.bottom - this.ekV.top) / 4;
            } else {
                i = (this.ekV.right - this.ekV.left) / 4;
            }
            if (this.ekU != null && this.ekU.aTP() == 4) {
                canvas.drawPath(this.elc, this.elb);
            }
            this.ela.clearShadowLayer();
            this.ela.setStyle(Style.FILL);
            this.ela.setColor(this.ekW);
            canvas.drawRect(j(this.ekV.left, this.ekV.top, this.ekV.left + i, this.ekV.top), this.ela);
            canvas.drawRect(j(this.ekV.left, this.ekV.top, this.ekV.left, this.ekV.top + i), this.ela);
            canvas.drawRect(j(this.ekV.right, this.ekV.top, this.ekV.right - i, this.ekV.top), this.ela);
            canvas.drawRect(j(this.ekV.right, this.ekV.top, this.ekV.right, this.ekV.top + i), this.ela);
            canvas.drawRect(j(this.ekV.left, this.ekV.bottom, this.ekV.left + i, this.ekV.bottom), this.ela);
            canvas.drawRect(j(this.ekV.left, this.ekV.bottom, this.ekV.left, this.ekV.bottom - i), this.ela);
            canvas.drawRect(j(this.ekV.right, this.ekV.bottom, this.ekV.right - i, this.ekV.bottom), this.ela);
            canvas.drawRect(j(this.ekV.right, this.ekV.bottom, this.ekV.right, this.ekV.bottom - i), this.ela);
            if (this.ekU != null) {
                if (this.ekU.topEdge) {
                    canvas.drawRect(j(this.ekV.left, this.ekV.top, this.ekV.right, this.ekV.top), this.ela);
                }
                if (this.ekU.bottomEdge) {
                    canvas.drawRect(j(this.ekV.left, this.ekV.bottom, this.ekV.right, this.ekV.bottom), this.ela);
                }
                if (this.ekU.leftEdge) {
                    canvas.drawRect(j(this.ekV.left, this.ekV.top, this.ekV.left, this.ekV.bottom), this.ela);
                }
                if (this.ekU.rightEdge) {
                    canvas.drawRect(j(this.ekV.right, this.ekV.top, this.ekV.right, this.ekV.bottom), this.ela);
                }
                if (this.ekU.aTP() < 3) {
                    float f = this.mScale * 34.0f;
                    float f2 = this.mScale * 26.0f;
                    m.a(this.ela);
                    this.ela.setTextAlign(Align.CENTER);
                    this.ela.setTextSize(f2);
                    canvas.translate((float) (this.ekV.left + (this.ekV.width() / 2)), (float) (this.ekV.top + (this.ekV.height() / 2)));
                    canvas.rotate((float) (this.elj * this.dSk));
                    if (!(this.ekY == null || this.ekY == "")) {
                        String[] split = this.ekY.split("\n");
                        f2 = (-(((((float) (split.length - 1)) * f) - f2) / 2.0f)) - 3.0f;
                        for (String drawText : split) {
                            canvas.drawText(drawText, 0.0f, f2, this.ela);
                            f2 += f;
                        }
                    }
                }
            }
            canvas.restore();
            if (!this.ekX) {
                canvas.save();
                canvas.translate(this.elh.exactCenterX(), this.elh.exactCenterY());
                canvas.rotate((float) (this.elj * this.dSk));
                this.elf.draw(canvas, this.mScale * 100.0f, this.mScale * 50.0f);
                canvas.restore();
            }
            if (this.eli) {
                canvas.save();
                canvas.translate(this.elg.exactCenterX(), this.elg.exactCenterY());
                canvas.rotate((float) (this.elj * this.dSk));
                this.ele.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void a(CreditCard creditCard) {
        this.ejJ = creditCard;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if ((motionEvent.getAction() & 255) == 0) {
                Rect a = m.a(new Point((int) motionEvent.getX(), (int) motionEvent.getY()), 20, 20);
                if (this.eli && this.elg != null && Rect.intersects(this.elg, a)) {
                    ((CardIOActivity) this.ekd.get()).toggleFlash();
                } else {
                    ((CardIOActivity) this.ekd.get()).aTz();
                }
            }
        } catch (NullPointerException unused) {
            Log.d(TAG, "NullPointerException caught in onTouchEvent method");
        }
        return false;
    }

    private void aTR() {
        RectF rectF = new RectF(2.0f, 2.0f, (float) (this.mBitmap.getWidth() - 2), (float) (this.mBitmap.getHeight() - 2));
        float height = ((float) this.mBitmap.getHeight()) * 0.06666667f;
        Bitmap createBitmap = Bitmap.createBitmap(this.mBitmap.getWidth(), this.mBitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStyle(Style.FILL);
        canvas.drawRoundRect(rectF, height, height, paint);
        Paint paint2 = new Paint();
        paint2.setFilterBitmap(false);
        Canvas canvas2 = new Canvas(this.mBitmap);
        paint2.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
        paint2.setXfermode(null);
        createBitmap.recycle();
    }

    public void aTS() {
        if (this.mBitmap != null) {
            if (this.ejJ.flipped) {
                Matrix matrix = new Matrix();
                matrix.setRotate(180.0f, (float) (this.mBitmap.getWidth() / 2), (float) (this.mBitmap.getHeight() / 2));
                this.mBitmap = Bitmap.createBitmap(this.mBitmap, 0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight(), matrix, false);
            }
            Canvas canvas = new Canvas(this.mBitmap);
            Paint paint = new Paint();
            m.a(paint);
            paint.setTextSize(this.mScale * 28.0f);
            int length = this.ejJ.cardNumber.length();
            float width = ((float) this.mBitmap.getWidth()) / 428.0f;
            int i = (int) ((((float) this.ejJ.yoff) * width) - 6.0f);
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = (int) (((float) this.ejJ.xoff[i2]) * width);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(this.ejJ.cardNumber.charAt(i2));
                canvas.drawText(stringBuilder.toString(), (float) i3, (float) i, paint);
            }
        }
    }

    public boolean isAnimating() {
        return this.mState != 0;
    }

    public void j(Rect rect) {
        this.eld = rect;
    }

    public void go(boolean z) {
        this.ele.gq(z);
        invalidate();
    }

    public void gp(boolean z) {
        this.elf.gm(z);
    }

    public Rect getTorchRect() {
        return this.elg;
    }
}
