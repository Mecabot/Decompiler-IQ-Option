package com.rd.draw.a;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

/* compiled from: DrawController */
public class b {
    private com.rd.draw.data.a ehq;
    private com.rd.animation.b.a eix;
    private com.rd.draw.b.a eiy;
    private a eiz;

    /* compiled from: DrawController */
    public interface a {
        void iB(int i);
    }

    public b(@NonNull com.rd.draw.data.a aVar) {
        this.ehq = aVar;
        this.eiy = new com.rd.draw.b.a(aVar);
    }

    public void b(@Nullable com.rd.animation.b.a aVar) {
        this.eix = aVar;
    }

    public void setClickListener(@Nullable a aVar) {
        this.eiz = aVar;
    }

    public void d(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            k(motionEvent.getX(), motionEvent.getY());
        }
    }

    private void k(float f, float f2) {
        if (this.eiz != null) {
            int a = com.rd.b.a.a(this.ehq, f, f2);
            if (a >= 0) {
                this.eiz.iB(a);
            }
        }
    }

    public void draw(@NonNull Canvas canvas) {
        int count = this.ehq.getCount();
        for (int i = 0; i < count; i++) {
            a(canvas, i, com.rd.b.a.b(this.ehq, i), com.rd.b.a.c(this.ehq, i));
        }
    }

    private void a(@NonNull Canvas canvas, int i, int i2, int i3) {
        boolean aTb = this.ehq.aTb();
        int aTe = this.ehq.aTe();
        int aTf = this.ehq.aTf();
        int i4 = 0;
        int i5 = (aTb || !(i == aTe || i == this.ehq.aTg())) ? 0 : 1;
        if (aTb && (i == aTe || i == aTf)) {
            i4 = 1;
        }
        aTb = i5 | i4;
        this.eiy.v(i, i2, i3);
        if (this.eix == null || !aTb) {
            this.eiy.a(canvas, aTb);
        } else {
            i(canvas);
        }
    }

    private void i(@NonNull Canvas canvas) {
        switch (this.ehq.aTi()) {
            case NONE:
                this.eiy.a(canvas, true);
                return;
            case COLOR:
                this.eiy.a(canvas, this.eix);
                return;
            case SCALE:
                this.eiy.b(canvas, this.eix);
                return;
            case WORM:
                this.eiy.c(canvas, this.eix);
                return;
            case SLIDE:
                this.eiy.d(canvas, this.eix);
                return;
            case FILL:
                this.eiy.e(canvas, this.eix);
                return;
            case THIN_WORM:
                this.eiy.f(canvas, this.eix);
                return;
            case DROP:
                this.eiy.g(canvas, this.eix);
                return;
            case SWAP:
                this.eiy.h(canvas, this.eix);
                return;
            case SCALE_DOWN:
                this.eiy.i(canvas, this.eix);
                return;
            default:
                return;
        }
    }
}
