package com.rd.draw.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.NonNull;
import com.rd.draw.b.a.b;
import com.rd.draw.b.a.c;
import com.rd.draw.b.a.d;
import com.rd.draw.b.a.e;
import com.rd.draw.b.a.f;
import com.rd.draw.b.a.g;
import com.rd.draw.b.a.h;
import com.rd.draw.b.a.i;
import com.rd.draw.b.a.j;
import com.rd.draw.b.a.k;

/* compiled from: Drawer */
public class a {
    private b eiK;
    private c eiL;
    private g eiM;
    private k eiN;
    private h eiO;
    private e eiP;
    private j eiQ;
    private d eiR;
    private i eiS;
    private f eiT;
    private int eiU;
    private int eiV;
    private int position;

    public a(@NonNull com.rd.draw.data.a aVar) {
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        this.eiK = new b(paint, aVar);
        this.eiL = new c(paint, aVar);
        this.eiM = new g(paint, aVar);
        this.eiN = new k(paint, aVar);
        this.eiO = new h(paint, aVar);
        this.eiP = new e(paint, aVar);
        this.eiQ = new j(paint, aVar);
        this.eiR = new d(paint, aVar);
        this.eiS = new i(paint, aVar);
        this.eiT = new f(paint, aVar);
    }

    public void v(int i, int i2, int i3) {
        this.position = i;
        this.eiU = i2;
        this.eiV = i3;
    }

    public void a(@NonNull Canvas canvas, boolean z) {
        if (this.eiL != null) {
            this.eiK.a(canvas, this.position, z, this.eiU, this.eiV);
        }
    }

    public void a(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiL != null) {
            this.eiL.a(canvas, aVar, this.position, this.eiU, this.eiV);
        }
    }

    public void b(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiM != null) {
            this.eiM.a(canvas, aVar, this.position, this.eiU, this.eiV);
        }
    }

    public void c(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiN != null) {
            this.eiN.a(canvas, aVar, this.eiU, this.eiV);
        }
    }

    public void d(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiO != null) {
            this.eiO.a(canvas, aVar, this.eiU, this.eiV);
        }
    }

    public void e(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiP != null) {
            this.eiP.a(canvas, aVar, this.position, this.eiU, this.eiV);
        }
    }

    public void f(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiQ != null) {
            this.eiQ.a(canvas, aVar, this.eiU, this.eiV);
        }
    }

    public void g(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiR != null) {
            this.eiR.a(canvas, aVar, this.eiU, this.eiV);
        }
    }

    public void h(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiS != null) {
            this.eiS.a(canvas, aVar, this.position, this.eiU, this.eiV);
        }
    }

    public void i(@NonNull Canvas canvas, @NonNull com.rd.animation.b.a aVar) {
        if (this.eiT != null) {
            this.eiT.a(canvas, aVar, this.position, this.eiU, this.eiV);
        }
    }
}
