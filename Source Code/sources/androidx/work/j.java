package androidx.work;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.impl.g;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* compiled from: WorkManager */
public abstract class j {
    @NonNull
    public abstract LiveData<l> a(@NonNull UUID uuid);

    @NonNull
    public abstract i a(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<f> list);

    public abstract void ba();

    public abstract void c(@NonNull List<? extends k> list);

    @NonNull
    public static j aZ() {
        j bz = g.bz();
        if (bz != null) {
            return bz;
        }
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    public static void a(@NonNull Context context, @NonNull a aVar) {
        g.a(context, aVar);
    }

    public final void a(@NonNull k... kVarArr) {
        c(Arrays.asList(kVarArr));
    }

    @NonNull
    public final i a(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull f... fVarArr) {
        return a(str, existingWorkPolicy, Arrays.asList(fVarArr));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected j() {
    }
}
