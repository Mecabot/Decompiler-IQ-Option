package com.iqoption.quiz;

import android.support.annotation.NonNull;
import kotlin.jvm.internal.h;

/* compiled from: Providers */
public class m {
    private static y dfP;

    public static void a(y yVar) {
        dfP = yVar;
    }

    @NonNull
    public static y ayY() {
        h.cv(dfP);
        return dfP;
    }
}
