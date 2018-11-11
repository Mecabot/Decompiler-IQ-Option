package com.iqoption.view.materialcalendar.a;

import com.iqoption.view.materialcalendar.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: DateFormatTitleFormatter */
public class d implements g {
    private final DateFormat cgq = new SimpleDateFormat("LLLL yyyy", Locale.getDefault());

    public CharSequence o(b bVar) {
        return this.cgq.format(bVar.getDate());
    }
}
