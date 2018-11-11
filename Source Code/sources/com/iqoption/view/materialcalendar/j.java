package com.iqoption.view.materialcalendar;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.util.LinkedList;

/* compiled from: DayViewFacade */
public class j {
    private Drawable dGZ = null;
    private boolean dHg = false;
    private Drawable dHh = null;
    private final LinkedList<Object> dHi = new LinkedList();
    private boolean dHj = false;

    j() {
    }

    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.dHh = drawable;
        this.dHg = true;
    }

    public void d(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.dGZ = drawable;
        this.dHg = true;
    }

    void reset() {
        this.dHh = null;
        this.dGZ = null;
        this.dHi.clear();
        this.dHg = false;
        this.dHj = false;
    }

    void c(j jVar) {
        if (this.dGZ != null) {
            jVar.d(this.dGZ);
        }
        if (this.dHh != null) {
            jVar.setBackgroundDrawable(this.dHh);
        }
        jVar.dHi.addAll(this.dHi);
        jVar.dHg |= this.dHg;
        jVar.dHj = this.dHj;
    }

    boolean aJp() {
        return this.dHg;
    }
}
