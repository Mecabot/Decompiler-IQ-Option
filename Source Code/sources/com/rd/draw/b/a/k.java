package com.rd.draw.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.rd.animation.b.a.h;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.a;

/* compiled from: WormDrawer */
public class k extends a {
    public RectF kt = new RectF();

    public k(@NonNull Paint paint, @NonNull a aVar) {
        super(paint, aVar);
    }

    public void a(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar, int i, int i2) {
        if (aVar instanceof h) {
            h hVar = (h) aVar;
            int aSW = hVar.aSW();
            int aSX = hVar.aSX();
            int radius = this.ehq.getRadius();
            int unselectedColor = this.ehq.getUnselectedColor();
            int selectedColor = this.ehq.getSelectedColor();
            if (this.ehq.aTh() == Orientation.HORIZONTAL) {
                this.kt.left = (float) aSW;
                this.kt.right = (float) aSX;
                this.kt.top = (float) (i2 - radius);
                this.kt.bottom = (float) (i2 + radius);
            } else {
                this.kt.left = (float) (i - radius);
                this.kt.right = (float) (i + radius);
                this.kt.top = (float) aSW;
                this.kt.bottom = (float) aSX;
            }
            this.kx.setColor(unselectedColor);
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = (float) radius;
            canvas.drawCircle(f, f2, f3, this.kx);
            this.kx.setColor(selectedColor);
            canvas.drawRoundRect(this.kt, f3, f3, this.kx);
        }
    }
}
