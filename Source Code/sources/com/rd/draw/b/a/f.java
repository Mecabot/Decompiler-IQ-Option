package com.rd.draw.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.rd.animation.b.a.d;
import com.rd.draw.data.a;

/* compiled from: ScaleDownDrawer */
public class f extends a {
    public f(@NonNull Paint paint, @NonNull a aVar) {
        super(paint, aVar);
    }

    public void a(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar, int i, int i2, int i3) {
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            float radius = (float) this.ehq.getRadius();
            int selectedColor = this.ehq.getSelectedColor();
            int aTe = this.ehq.aTe();
            int aTf = this.ehq.aTf();
            int aTg = this.ehq.aTg();
            if (this.ehq.aTb()) {
                if (i == aTf) {
                    radius = (float) dVar.getRadius();
                    selectedColor = dVar.getColor();
                } else if (i == aTe) {
                    radius = (float) dVar.aSR();
                    selectedColor = dVar.aSQ();
                }
            } else if (i == aTe) {
                radius = (float) dVar.getRadius();
                selectedColor = dVar.getColor();
            } else if (i == aTg) {
                radius = (float) dVar.aSR();
                selectedColor = dVar.aSQ();
            }
            this.kx.setColor(selectedColor);
            canvas.drawCircle((float) i2, (float) i3, radius, this.kx);
        }
    }
}
