package com.rd.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import com.rd.draw.a.b;
import com.rd.draw.a.c;

/* compiled from: DrawManager */
public class a {
    private com.rd.draw.data.a ehq = new com.rd.draw.data.a();
    private b eiu = new b(this.ehq);
    private c eiv = new c();
    private com.rd.draw.a.a eiw = new com.rd.draw.a.a(this.ehq);

    @NonNull
    public com.rd.draw.data.a aSn() {
        if (this.ehq == null) {
            this.ehq = new com.rd.draw.data.a();
        }
        return this.ehq;
    }

    public void setClickListener(@Nullable com.rd.draw.a.b.a aVar) {
        this.eiu.setClickListener(aVar);
    }

    public void d(@Nullable MotionEvent motionEvent) {
        this.eiu.d(motionEvent);
    }

    public void b(@Nullable com.rd.animation.b.a aVar) {
        this.eiu.b(aVar);
    }

    public void draw(@NonNull Canvas canvas) {
        this.eiu.draw(canvas);
    }

    public Pair<Integer, Integer> aQ(int i, int i2) {
        return this.eiv.a(this.ehq, i, i2);
    }

    public void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this.eiw.init(context, attributeSet);
    }
}
