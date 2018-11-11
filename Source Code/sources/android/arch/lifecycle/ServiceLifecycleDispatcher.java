package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.os.Handler;
import android.support.annotation.NonNull;

public class ServiceLifecycleDispatcher {
    private DispatchRunnable bD;
    private final LifecycleRegistry bv;
    private final Handler mHandler = new Handler();

    static class DispatchRunnable implements Runnable {
        final Event bE;
        private boolean bF = false;
        private final LifecycleRegistry bv;

        DispatchRunnable(@NonNull LifecycleRegistry lifecycleRegistry, Event event) {
            this.bv = lifecycleRegistry;
            this.bE = event;
        }

        public void run() {
            if (!this.bF) {
                this.bv.b(this.bE);
                this.bF = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NonNull LifecycleOwner lifecycleOwner) {
        this.bv = new LifecycleRegistry(lifecycleOwner);
    }

    private void d(Event event) {
        if (this.bD != null) {
            this.bD.run();
        }
        this.bD = new DispatchRunnable(this.bv, event);
        this.mHandler.postAtFrontOfQueue(this.bD);
    }

    public void Z() {
        d(Event.ON_CREATE);
    }

    public void aa() {
        d(Event.ON_START);
    }

    public void ab() {
        d(Event.ON_START);
    }

    public void ac() {
        d(Event.ON_STOP);
        d(Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.bv;
    }
}
