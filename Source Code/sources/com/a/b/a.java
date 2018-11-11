package com.a.b;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import org.threeten.bp.zone.b;

/* compiled from: AndroidThreeTen */
public final class a {
    private static final AtomicBoolean dTU = new AtomicBoolean();

    public static void e(Application application) {
        init(application);
    }

    public static void init(Context context) {
        if (!dTU.getAndSet(true)) {
            b.a(new b(context));
        }
    }
}
