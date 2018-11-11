package androidx.work.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.a;
import androidx.work.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Processor */
public class b implements a {
    private a ei;
    private WorkDatabase ej;
    private Map<String, h> ek = new HashMap();
    private List<c> el;
    private Set<String> em;
    private final List<a> en;
    private Context mAppContext;
    private Executor mExecutor;

    public b(Context context, a aVar, WorkDatabase workDatabase, List<c> list, Executor executor) {
        this.mAppContext = context;
        this.ei = aVar;
        this.ej = workDatabase;
        this.el = list;
        this.mExecutor = executor;
        this.em = new HashSet();
        this.en = new ArrayList();
    }

    public synchronized boolean q(String str) {
        return a(str, null);
    }

    public synchronized boolean a(String str, Extras.a aVar) {
        if (this.ek.containsKey(str)) {
            e.b("Processor", String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
            return false;
        }
        Runnable bP = new h.a(this.mAppContext, this.ei, this.ej, str).c(this).f(this.el).a(aVar).bP();
        this.ek.put(str, bP);
        this.mExecutor.execute(bP);
        e.b("Processor", String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
        return true;
    }

    public synchronized boolean r(String str) {
        e.b("Processor", String.format("Processor stopping %s", new Object[]{str}), new Throwable[0]);
        h hVar = (h) this.ek.remove(str);
        if (hVar != null) {
            hVar.s(false);
            e.b("Processor", String.format("WorkerWrapper stopped for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        e.b("Processor", String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    public synchronized boolean s(String str) {
        e.b("Processor", String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
        this.em.add(str);
        h hVar = (h) this.ek.remove(str);
        if (hVar != null) {
            hVar.s(true);
            e.b("Processor", String.format("WorkerWrapper cancelled for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        e.b("Processor", String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    public synchronized boolean t(String str) {
        return this.em.contains(str);
    }

    public synchronized boolean u(@NonNull String str) {
        return this.ek.containsKey(str);
    }

    public synchronized void a(a aVar) {
        this.en.add(aVar);
    }

    public synchronized void b(a aVar) {
        this.en.remove(aVar);
    }

    public synchronized void a(@NonNull String str, boolean z, boolean z2) {
        this.ek.remove(str);
        e.b("Processor", String.format("%s %s executed; isSuccessful = %s, reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z), Boolean.valueOf(z2)}), new Throwable[0]);
        for (a a : this.en) {
            a.a(str, z, z2);
        }
    }
}
