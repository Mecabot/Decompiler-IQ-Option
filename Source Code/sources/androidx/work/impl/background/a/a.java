package androidx.work.impl.background.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.State;
import androidx.work.e;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import androidx.work.impl.g;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: GreedyScheduler */
public class a implements androidx.work.impl.a, c, androidx.work.impl.c {
    private g eo;
    private d fk;
    private List<j> fl = new ArrayList();
    private boolean fm;

    public a(Context context, g gVar) {
        this.eo = gVar;
        this.fk = new d(context, this);
    }

    public synchronized void a(j... jVarArr) {
        bQ();
        int size = this.fl.size();
        for (j jVar : jVarArr) {
            if (jVar.gn == State.ENQUEUED && !jVar.isPeriodic() && jVar.gs == 0) {
                if (!jVar.cu()) {
                    this.eo.y(jVar.id);
                } else if (VERSION.SDK_INT < 24 || !jVar.gv.aN()) {
                    e.b("GreedyScheduler", String.format("Starting tracking for %s", new Object[]{jVar.id}), new Throwable[0]);
                    this.fl.add(jVar);
                }
            }
        }
        if (size != this.fl.size()) {
            this.fk.j(this.fl);
        }
    }

    public synchronized void x(@NonNull String str) {
        bQ();
        e.b("GreedyScheduler", String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        this.eo.z(str);
        B(str);
    }

    public synchronized void h(@NonNull List<String> list) {
        for (String str : list) {
            e.b("GreedyScheduler", String.format("Constraints met: Scheduling work ID %s", new Object[]{str}), new Throwable[0]);
            this.eo.y(str);
        }
    }

    public synchronized void i(@NonNull List<String> list) {
        for (String str : list) {
            e.b("GreedyScheduler", String.format("Constraints not met: Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
            this.eo.z(str);
        }
    }

    public synchronized void a(@NonNull String str, boolean z, boolean z2) {
        B(str);
    }

    private synchronized void B(@NonNull String str) {
        int size = this.fl.size();
        for (int i = 0; i < size; i++) {
            if (((j) this.fl.get(i)).id.equals(str)) {
                e.b("GreedyScheduler", String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                this.fl.remove(i);
                this.fk.j(this.fl);
                break;
            }
        }
    }

    private void bQ() {
        if (!this.fm) {
            this.eo.bD().a(this);
            this.fm = true;
        }
    }
}
