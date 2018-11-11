package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.b.f;
import io.fabric.sdk.android.services.concurrency.a.b;
import io.fabric.sdk.android.services.concurrency.a.c;
import io.fabric.sdk.android.services.concurrency.a.e;
import java.io.File;
import java.util.List;

/* compiled from: AnswersRetryFilesSender */
class i implements f {
    private final y sg;
    private final v sh;

    public static i a(y yVar) {
        return new i(yVar, new v(new e(new u(new c(1000, 8), 0.1d), new b(5))));
    }

    i(y yVar, v vVar) {
        this.sg = yVar;
        this.sh = vVar;
    }

    public boolean q(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.sh.h(nanoTime)) {
            return false;
        }
        if (this.sg.q(list)) {
            this.sh.reset();
            return true;
        }
        this.sh.i(nanoTime);
        return false;
    }
}
