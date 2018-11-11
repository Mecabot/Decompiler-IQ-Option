package io.card.payment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: Logo */
class f {
    private Bitmap ekR;
    private boolean ekS;
    private final Context mContext;
    private final Paint mPaint = new Paint();

    public f(Context context) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setAlpha(100);
        this.ekR = null;
        this.mContext = context;
    }

    void gm(boolean z) {
        if (this.ekR == null || z != this.ekS) {
            this.ekS = z;
            if (z) {
                this.ekR = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.cio_card_io_logo);
            } else {
                this.ekR = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.cio_paypal_logo);
            }
        }
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.ekR == null) {
            gm(false);
        }
        canvas.save();
        float height = ((float) this.ekR.getHeight()) / ((float) this.ekR.getWidth());
        if (f2 / f < height) {
            f = f2 / height;
        } else {
            f2 = f * height;
        }
        f /= 2.0f;
        f2 /= 2.0f;
        canvas.drawBitmap(this.ekR, new Rect(0, 0, this.ekR.getWidth(), this.ekR.getHeight()), new RectF(-f, -f2, f, f2), this.mPaint);
        canvas.restore();
    }
}
