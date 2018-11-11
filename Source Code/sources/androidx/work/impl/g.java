package androidx.work.impl;

import android.annotation.TargetApi;
import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.ExistingWorkPolicy;
import androidx.work.a;
import androidx.work.e;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.a.b;
import androidx.work.impl.utils.a.c;
import androidx.work.impl.utils.d;
import androidx.work.impl.utils.f;
import androidx.work.j;
import androidx.work.k;
import androidx.work.l;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WorkManagerImpl */
public class g extends j {
    private static g eJ;
    private static g eK;
    private static final Object sLock = new Object();
    private b eE;
    private b eF;
    private f eG;
    private boolean eH;
    private PendingResult eI;
    private a ei;
    private WorkDatabase ej;
    private List<c> el;
    private Context mContext;

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static g bz() {
        synchronized (sLock) {
            g gVar;
            if (eJ != null) {
                gVar = eJ;
                return gVar;
            }
            gVar = eK;
            return gVar;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static void a(@NonNull Context context, @NonNull a aVar) {
        synchronized (sLock) {
            if (eJ == null) {
                context = context.getApplicationContext();
                if (eK == null) {
                    eK = new g(context, aVar);
                }
                eJ = eK;
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public g(@NonNull Context context, @NonNull a aVar) {
        this(context, aVar, context.getResources().getBoolean(h.a.workmanager_test_configuration));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public g(@NonNull Context context, @NonNull a aVar, boolean z) {
        context = context.getApplicationContext();
        this.mContext = context;
        this.ei = aVar;
        this.ej = WorkDatabase.a(context, z);
        this.eE = c.cG();
        this.eF = new b(context, this.ei, this.ej, bC(), aVar.getExecutor());
        this.eG = new f(this.mContext);
        this.eH = false;
        e.k(this.ei.aB());
        this.eE.e(new ForceStopRunnable(context, this));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.mContext;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public WorkDatabase bA() {
        return this.ej;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public a bB() {
        return this.ei;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public List<c> bC() {
        if (this.el == null) {
            this.el = Arrays.asList(new c[]{d.a(this.mContext, this), new androidx.work.impl.background.a.a(this.mContext, this)});
        }
        return this.el;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public b bD() {
        return this.eF;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public b bE() {
        return this.eE;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public f bF() {
        return this.eG;
    }

    public void c(@NonNull List<? extends k> list) {
        new e(this, list).aY();
    }

    @NonNull
    public i a(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<androidx.work.f> list) {
        return new e(this, str, existingWorkPolicy, list);
    }

    public void ba() {
        this.eE.e(androidx.work.impl.utils.a.c(this));
    }

    @NonNull
    public LiveData<l> a(@NonNull UUID uuid) {
        return d.b(this.ej.bu().n(Collections.singletonList(uuid.toString())), new Function<List<androidx.work.impl.b.j.b>, l>() {
            /* renamed from: d */
            public l apply(List<androidx.work.impl.b.j.b> list) {
                return (list == null || list.size() <= 0) ? null : ((androidx.work.impl.b.j.b) list.get(0)).cv();
            }
        });
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void y(String str) {
        b(str, null);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void b(String str, Extras.a aVar) {
        this.eE.e(new androidx.work.impl.utils.g(this, str, aVar));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void z(String str) {
        this.eE.e(new androidx.work.impl.utils.h(this, str));
    }

    @TargetApi(23)
    @RestrictTo({Scope.LIBRARY_GROUP})
    public void bG() {
        if (VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.h(getApplicationContext());
        }
        bA().bu().cx();
        d.a(bB(), bA(), bC());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void bH() {
        synchronized (sLock) {
            this.eH = true;
            if (this.eI != null) {
                this.eI.finish();
                this.eI = null;
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(@NonNull PendingResult pendingResult) {
        synchronized (sLock) {
            this.eI = pendingResult;
            if (this.eH) {
                this.eI.finish();
                this.eI = null;
            }
        }
    }
}
