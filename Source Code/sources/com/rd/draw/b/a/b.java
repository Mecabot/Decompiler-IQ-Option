package com.rd.draw.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.NonNull;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.a;

/* compiled from: BasicDrawer */
public class b extends a {
    private Paint oj = new Paint();

    public b(@NonNull Paint paint, @NonNull a aVar) {
        super(paint, aVar);
        this.oj.setStyle(Style.STROKE);
        this.oj.setAntiAlias(true);
        this.oj.setStrokeWidth((float) aVar.aSS());
    }

    public void a(@NonNull Canvas canvas, int i, boolean z, int i2, int i3) {
        Paint paint;
        float radius = (float) this.ehq.getRadius();
        int aSS = this.ehq.aSS();
        float scaleFactor = this.ehq.getScaleFactor();
        int selectedColor = this.ehq.getSelectedColor();
        int unselectedColor = this.ehq.getUnselectedColor();
        int aTe = this.ehq.aTe();
        AnimationType aTi = this.ehq.aTi();
        if (aTi == AnimationType.SCALE && !z) {
            radius *= scaleFactor;
        } else if (aTi == AnimationType.SCALE_DOWN && z) {
            radius *= scaleFactor;
        }
        if (i != aTe) {
            selectedColor = unselectedColor;
        }
        if (aTi != AnimationType.FILL || i == aTe) {
            paint = this.kx;
        } else {
            paint = this.oj;
            paint.setStrokeWidth((float) aSS);
        }
        paint.setColor(selectedColor);
        canvas.drawCircle((float) i2, (float) i3, radius, paint);
    }
}
