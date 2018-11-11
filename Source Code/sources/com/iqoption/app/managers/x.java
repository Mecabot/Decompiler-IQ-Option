package com.iqoption.app.managers;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Starter */
public final class x {
    private final Set<Runnable> anA;
    private final Runnable anB = new Runnable() {
        public void run() {
            if (x.a(x.this) == 0 && x.this.anz != null) {
                x.this.anz.GH();
            }
            x.this.anA.remove(this);
        }
    };
    private final a anz;
    private int count;

    /* compiled from: Starter */
    public interface a {
        void GG();

        void GH();
    }

    static /* synthetic */ int a(x xVar) {
        int i = xVar.count - 1;
        xVar.count = i;
        return i;
    }

    public x(a aVar) {
        this.anz = aVar;
        this.anA = new HashSet();
    }

    public void start() {
        if (this.anA.remove(this.anB)) {
            com.iqoption.core.d.a.aSe.removeCallbacks(this.anB);
            return;
        }
        int i = this.count;
        this.count = i + 1;
        if (i == 0 && this.anz != null) {
            this.anz.GG();
        }
    }

    public void stop() {
        this.anA.add(this.anB);
        com.iqoption.core.d.a.aSe.execute(this.anB);
    }

    public boolean isStarted() {
        return this.count > 0 && this.anA.isEmpty();
    }
}
