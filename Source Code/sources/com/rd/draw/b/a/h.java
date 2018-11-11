package com.rd.draw.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.rd.animation.b.a.e;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.a;

/* compiled from: SlideDrawer */
public class h extends a {
    public h(@NonNull Paint paint, @NonNull a aVar) {
        super(paint, aVar);
    }

    public void a(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar, int i, int i2) {
        if (aVar instanceof e) {
            int aSU = ((e) aVar).aSU();
            int unselectedColor = this.ehq.getUnselectedColor();
            int selectedColor = this.ehq.getSelectedColor();
            int radius = this.ehq.getRadius();
            this.kx.setColor(unselectedColor);
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = (float) radius;
            canvas.drawCircle(f, f2, f3, this.kx);
            this.kx.setColor(selectedColor);
            if (this.ehq.aTh() == Orientation.HORIZONTAL) {
                canvas.drawCircle((float) aSU, f2, f3, this.kx);
            } else {
                canvas.drawCircle(f, (float) aSU, f3, this.kx);
            }
        }
    }
}
