package androidx.work.impl.background.systemalarm;

import android.arch.lifecycle.LifecycleService;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.e;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SystemAlarmService extends LifecycleService implements c {
    private e fo;

    public void onCreate() {
        super.onCreate();
        this.fo = new e(this);
        this.fo.a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.fo.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (intent != null) {
            this.fo.a(intent, i2);
        }
        return 1;
    }

    @MainThread
    public void cb() {
        e.b("SystemAlarmService", "All commands completed in dispatcher", new Throwable[0]);
        stopSelf();
    }
}
