package com.rd.b;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IdUtils */
public class c {
    private static final AtomicInteger eiW = new AtomicInteger(1);

    public static int generateViewId() {
        if (VERSION.SDK_INT < 17) {
            return aTl();
        }
        return View.generateViewId();
    }

    private static int aTl() {
        int i;
        int i2;
        do {
            i = eiW.get();
            i2 = i + 1;
            if (i2 > ViewCompat.MEASURED_SIZE_MASK) {
                i2 = 1;
            }
        } while (!eiW.compareAndSet(i, i2));
        return i;
    }
}
