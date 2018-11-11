package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.q;

/* compiled from: ImageLayer */
public class d extends a {
    @Nullable
    private a<ColorFilter, ColorFilter> kC;
    private final Paint kx = new Paint(3);
    private final Rect nO = new Rect();
    private final Rect nP = new Rect();

    d(h hVar, Layer layer) {
        super(hVar, layer);
    }

    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            float fo = f.fo();
            this.kx.setAlpha(i);
            if (this.kC != null) {
                this.kx.setColorFilter((ColorFilter) this.kC.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.nO.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.nP.set(0, 0, (int) (((float) bitmap.getWidth()) * fo), (int) (((float) bitmap.getHeight()) * fo));
            canvas.drawBitmap(bitmap, this.nO, this.nP, this.kx);
            canvas.restore();
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) bitmap.getWidth()), Math.min(rectF.bottom, (float) bitmap.getHeight()));
            this.nA.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.iS.ab(this.nB.eS());
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        super.a((Object) t, (c) cVar);
        if (t != q.kk) {
            return;
        }
        if (cVar == null) {
            this.kC = null;
        } else {
            this.kC = new p(cVar);
        }
    }
}
