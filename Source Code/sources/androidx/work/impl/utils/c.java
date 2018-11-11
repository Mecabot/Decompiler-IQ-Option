package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: IdGenerator */
public class c {
    private SharedPreferences gY;

    public c(Context context) {
        this.gY = context.getSharedPreferences("androidx.work.util.id", 0);
    }

    public int h(int i, int i2) {
        synchronized (c.class) {
            int U = U("next_job_scheduler_id");
            if (U < i || U > i2) {
                e("next_job_scheduler_id", i + 1);
            } else {
                i = U;
            }
        }
        return i;
    }

    public int cD() {
        int U;
        synchronized (c.class) {
            U = U("next_firebase_alarm_id");
        }
        return U;
    }

    public int cE() {
        int U;
        synchronized (c.class) {
            U = U("next_alarm_manager_id");
        }
        return U;
    }

    private int U(String str) {
        int i = 0;
        int i2 = this.gY.getInt(str, 0);
        if (i2 != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            i = i2 + 1;
        }
        e(str, i);
        return i2;
    }

    private void e(String str, int i) {
        this.gY.edit().putInt(str, i).apply();
    }
}
