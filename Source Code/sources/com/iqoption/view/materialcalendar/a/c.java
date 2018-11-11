package com.iqoption.view.materialcalendar.a;

import android.support.annotation.NonNull;
import com.iqoption.view.materialcalendar.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: DateFormatDayFormatter */
public class c implements e {
    private final DateFormat cgq = new SimpleDateFormat("d", Locale.getDefault());

    @NonNull
    public String n(@NonNull b bVar) {
        return this.cgq.format(bVar.getDate());
    }
}
