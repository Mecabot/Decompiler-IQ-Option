package androidx.work;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: Configuration */
public final class a {
    private final int dF;
    private final int dG;
    private final int dH;
    private final int dI;
    @NonNull
    private final Executor mExecutor;

    /* compiled from: Configuration */
    public static final class a {
        int dF = 4;
        int dG = 0;
        int dH = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int dI = 20;
        Executor mExecutor;

        @NonNull
        public a aG() {
            return new a(this);
        }
    }

    a(@NonNull a aVar) {
        if (aVar.mExecutor == null) {
            this.mExecutor = aF();
        } else {
            this.mExecutor = aVar.mExecutor;
        }
        this.dF = aVar.dF;
        this.dG = aVar.dG;
        this.dH = aVar.dH;
        this.dI = aVar.dI;
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @RestrictTo({Scope.LIBRARY})
    public int aB() {
        return this.dF;
    }

    public int aC() {
        return this.dG;
    }

    public int aD() {
        return this.dH;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int aE() {
        if (VERSION.SDK_INT == 23) {
            return this.dI / 2;
        }
        return this.dI;
    }

    @NonNull
    private Executor aF() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
