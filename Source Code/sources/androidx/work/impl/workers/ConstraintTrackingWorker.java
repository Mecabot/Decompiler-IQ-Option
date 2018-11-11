package androidx.work.impl.workers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import androidx.work.Worker;
import androidx.work.Worker.Result;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import androidx.work.impl.g;
import androidx.work.impl.h;
import java.util.Collections;
import java.util.List;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ConstraintTrackingWorker extends Worker implements c {
    @Nullable
    private Worker hh;
    private boolean hi = false;
    private final Object mLock = new Object();

    public void h(@NonNull List<String> list) {
    }

    @NonNull
    public Result bh() {
        Object string = bg().getString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(string)) {
            e.b("ConstraintTrkngWrkr", "No worker to delegate to.", new Throwable[0]);
            return Result.FAILURE;
        }
        this.hh = h.a(getApplicationContext(), string, getId(), bj());
        if (this.hh == null) {
            e.b("ConstraintTrkngWrkr", "No worker to delegate to.", new Throwable[0]);
            return Result.FAILURE;
        }
        j M = bA().bu().M(getId().toString());
        if (M == null) {
            return Result.FAILURE;
        }
        d dVar = new d(getApplicationContext(), this);
        dVar.j(Collections.singletonList(M));
        if (dVar.F(getId().toString())) {
            e.b("ConstraintTrkngWrkr", String.format("Constraints met for delegate %s", new Object[]{string}), new Throwable[0]);
            try {
                Result bh = this.hh.bh();
                synchronized (this.mLock) {
                    if (this.hi) {
                        bh = Result.RETRY;
                        return bh;
                    }
                    c(this.hh.bi());
                    return bh;
                }
            } catch (Throwable th) {
                e.b("ConstraintTrkngWrkr", String.format("Delegated worker %s threw a runtime exception.", new Object[]{string}), th);
                synchronized (this.mLock) {
                    if (!this.hi) {
                        return Result.FAILURE;
                    }
                    e.b("ConstraintTrkngWrkr", "Constraints were unmet, Retrying.", new Throwable[0]);
                    return Result.RETRY;
                }
            }
        }
        e.b("ConstraintTrkngWrkr", String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{string}), new Throwable[0]);
        return Result.RETRY;
    }

    @VisibleForTesting
    public WorkDatabase bA() {
        return g.bz().bA();
    }

    public void i(@NonNull List<String> list) {
        e.b("ConstraintTrkngWrkr", String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.mLock) {
            this.hi = true;
        }
    }
}
