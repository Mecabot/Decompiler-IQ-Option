package androidx.work.impl.utils;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.impl.Extras.a;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: StartWorkRunnable */
public class g implements Runnable {
    private String eM;
    private a ed;
    private androidx.work.impl.g eo;

    public g(androidx.work.impl.g gVar, String str, a aVar) {
        this.eo = gVar;
        this.eM = str;
        this.ed = aVar;
    }

    public void run() {
        this.eo.bD().a(this.eM, this.ed);
    }
}
