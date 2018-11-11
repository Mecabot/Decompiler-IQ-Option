package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Preferences */
public class f {
    private SharedPreferences hd;

    public f(@NonNull Context context) {
        this(context.getSharedPreferences("androidx.work.util.preferences", 0));
    }

    @VisibleForTesting
    public f(@NonNull SharedPreferences sharedPreferences) {
        this.hd = sharedPreferences;
    }

    public void e(long j) {
        this.hd.edit().putLong("last_cancel_all_time_ms", j).apply();
    }

    public boolean cF() {
        return this.hd.getBoolean("reschedule_needed", false);
    }

    public void u(boolean z) {
        this.hd.edit().putBoolean("reschedule_needed", z).apply();
    }
}
