package androidx.work.impl.utils;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.WorkerThread;
import androidx.work.State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.k;
import androidx.work.impl.c;
import androidx.work.impl.d;
import androidx.work.impl.g;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: CancelWorkRunnable */
public abstract class a implements Runnable {
    void a(g gVar, String str) {
        a(gVar.bA(), str);
        gVar.bD().s(str);
        for (c x : gVar.bC()) {
            x.x(str);
        }
    }

    void b(g gVar) {
        d.a(gVar.bB(), gVar.bA(), gVar.bC());
    }

    private void a(WorkDatabase workDatabase, String str) {
        k bu = workDatabase.bu();
        for (String a : workDatabase.bv().I(str)) {
            a(workDatabase, a);
        }
        State Q = bu.Q(str);
        if (Q != State.SUCCEEDED && Q != State.FAILED) {
            bu.a(State.CANCELLED, str);
        }
    }

    public static Runnable a(@NonNull final String str, @NonNull final g gVar, final boolean z) {
        return new a() {
            @WorkerThread
            public void run() {
                WorkDatabase bA = gVar.bA();
                bA.beginTransaction();
                try {
                    for (String a : bA.bu().S(str)) {
                        a(gVar, a);
                    }
                    bA.setTransactionSuccessful();
                    if (z) {
                        b(gVar);
                    }
                } finally {
                    bA.endTransaction();
                }
            }
        };
    }

    public static Runnable c(@NonNull final g gVar) {
        return new a() {
            public void run() {
                WorkDatabase bA = gVar.bA();
                bA.beginTransaction();
                try {
                    for (String a : bA.bu().cw()) {
                        a(gVar, a);
                    }
                    bA.setTransactionSuccessful();
                    new f(gVar.getApplicationContext()).e(System.currentTimeMillis());
                } finally {
                    bA.endTransaction();
                }
            }
        };
    }
}
