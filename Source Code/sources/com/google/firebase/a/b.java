package com.google.firebase.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.firebase.a;
import java.util.concurrent.atomic.AtomicReference;

public final class b {
    private static final AtomicReference<b> XC = new AtomicReference();

    private b(Context context) {
    }

    public static b aC(Context context) {
        XC.compareAndSet(null, new b(context));
        return (b) XC.get();
    }

    public static void c(@NonNull a aVar) {
    }
}
