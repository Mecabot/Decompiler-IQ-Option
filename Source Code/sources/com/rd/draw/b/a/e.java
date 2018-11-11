package com.rd.draw.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.NonNull;
import com.rd.animation.b.a.c;
import com.rd.draw.data.a;

/* compiled from: FillDrawer */
public class e extends a {
    private Paint oj = new Paint();

    public e(@NonNull Paint paint, @NonNull a aVar) {
        super(paint, aVar);
        this.oj.setStyle(Style.STROKE);
        this.oj.setAntiAlias(true);
    }

    public void a(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar, int i, int i2, int i3) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int unselectedColor = this.ehq.getUnselectedColor();
            float radius = (float) this.ehq.getRadius();
            int aSS = this.ehq.aSS();
            int aTe = this.ehq.aTe();
            int aTf = this.ehq.aTf();
            int aTg = this.ehq.aTg();
            if (this.ehq.aTb()) {
                if (i == aTf) {
                    unselectedColor = cVar.getColor();
                    radius = (float) cVar.getRadius();
                    aSS = cVar.aSS();
                } else if (i == aTe) {
                    unselectedColor = cVar.aSQ();
                    radius = (float) cVar.aSR();
                    aSS = cVar.aST();
                }
            } else if (i == aTe) {
                unselectedColor = cVar.getColor();
                radius = (float) cVar.getRadius();
                aSS = cVar.aSS();
            } else if (i == aTg) {
                unselectedColor = cVar.aSQ();
                radius = (float) cVar.aSR();
                aSS = cVar.aST();
            }
            this.oj.setColor(unselectedColor);
            this.oj.setStrokeWidth((float) this.ehq.aSS());
            float f = (float) i2;
            float f2 = (float) i3;
            canvas.drawCircle(f, f2, (float) this.ehq.getRadius(), this.oj);
            this.oj.setStrokeWidth((float) aSS);
            canvas.drawCircle(f, f2, radius, this.oj);
        }
    }
}
