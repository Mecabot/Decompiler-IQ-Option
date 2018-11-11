package com.rd.draw.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.rd.draw.data.a;

/* compiled from: ColorDrawer */
public class c extends a {
    public c(@NonNull Paint paint, @NonNull a aVar) {
        super(paint, aVar);
    }

    public void a(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar, int i, int i2, int i3) {
        if (aVar instanceof com.rd.animation.b.a.a) {
            com.rd.animation.b.a.a aVar2 = (com.rd.animation.b.a.a) aVar;
            float radius = (float) this.ehq.getRadius();
            int selectedColor = this.ehq.getSelectedColor();
            int aTe = this.ehq.aTe();
            int aTf = this.ehq.aTf();
            int aTg = this.ehq.aTg();
            if (this.ehq.aTb()) {
                if (i == aTf) {
                    selectedColor = aVar2.getColor();
                } else if (i == aTe) {
                    selectedColor = aVar2.aSQ();
                }
            } else if (i == aTe) {
                selectedColor = aVar2.getColor();
            } else if (i == aTg) {
                selectedColor = aVar2.aSQ();
            }
            this.kx.setColor(selectedColor);
            canvas.drawCircle((float) i2, (float) i3, radius, this.kx);
        }
    }
}
