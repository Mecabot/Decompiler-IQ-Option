package androidx.work.impl.a.b;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Trackers */
public class g {
    private static g fX;
    private a fY;
    private b fZ;
    private e ga;
    private f gb;

    public static synchronized g i(Context context) {
        g gVar;
        synchronized (g.class) {
            if (fX == null) {
                fX = new g(context);
            }
            gVar = fX;
        }
        return gVar;
    }

    private g(Context context) {
        context = context.getApplicationContext();
        this.fY = new a(context);
        this.fZ = new b(context);
        this.ga = new e(context);
        this.gb = new f(context);
    }

    public a co() {
        return this.fY;
    }

    public b cp() {
        return this.fZ;
    }

    public e cq() {
        return this.ga;
    }

    public f cr() {
        return this.gb;
    }
}
