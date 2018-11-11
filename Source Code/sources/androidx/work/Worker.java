package androidx.work;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.WorkerThread;
import androidx.work.impl.Extras;
import java.util.UUID;

public abstract class Worker {
    @NonNull
    private UUID dV;
    @NonNull
    private Data ea = Data.dS;
    @NonNull
    private Extras eb;
    @NonNull
    private Context mAppContext;
    private volatile boolean mCancelled;
    private volatile boolean mStopped;

    public enum Result {
        SUCCESS,
        FAILURE,
        RETRY
    }

    @WorkerThread
    @NonNull
    public abstract Result bh();

    public void r(boolean z) {
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    @NonNull
    public final UUID getId() {
        return this.dV;
    }

    @NonNull
    public final Data bg() {
        return this.eb.bg();
    }

    public final void c(@NonNull Data data) {
        this.ea = data;
    }

    @NonNull
    public final Data bi() {
        return this.ea;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public final void q(boolean z) {
        this.mStopped = true;
        this.mCancelled = z;
        r(z);
    }

    @Keep
    private void internalInit(@NonNull Context context, @NonNull UUID uuid, @NonNull Extras extras) {
        this.mAppContext = context;
        this.dV = uuid;
        this.eb = extras;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    public Extras bj() {
        return this.eb;
    }
}
