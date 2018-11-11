package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher be = new ServiceLifecycleDispatcher(this);

    @CallSuper
    public void onCreate() {
        this.be.Z();
        super.onCreate();
    }

    @Nullable
    @CallSuper
    public IBinder onBind(Intent intent) {
        this.be.aa();
        return null;
    }

    @CallSuper
    public void onStart(Intent intent, int i) {
        this.be.ab();
        super.onStart(intent, i);
    }

    @CallSuper
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @CallSuper
    public void onDestroy() {
        this.be.ac();
        super.onDestroy();
    }

    public Lifecycle getLifecycle() {
        return this.be.getLifecycle();
    }
}
