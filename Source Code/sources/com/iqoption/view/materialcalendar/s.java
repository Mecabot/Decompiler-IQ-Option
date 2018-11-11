package com.iqoption.view.materialcalendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.iqoption.view.materialcalendar.a.h;

@SuppressLint({"ViewConstructor"})
/* compiled from: WeekDayView */
class s extends TextView {
    private h dHZ = h.dIe;
    private int dIa;

    public s(Context context, int i) {
        super(context);
        setGravity(17);
        if (VERSION.SDK_INT >= 17) {
            setTextAlignment(4);
        }
        setDayOfWeek(i);
    }

    public void setWeekDayFormatter(h hVar) {
        if (hVar == null) {
            hVar = h.dIe;
        }
        this.dHZ = hVar;
        setDayOfWeek(this.dIa);
    }

    public void setDayOfWeek(int i) {
        this.dIa = i;
        setText(this.dHZ.ho(i));
    }
}
