package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    private final FullLifecycleObserver aK;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.aK = fullLifecycleObserver;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event) {
        switch (event) {
            case ON_CREATE:
                this.aK.a(lifecycleOwner);
                return;
            case ON_START:
                this.aK.b(lifecycleOwner);
                return;
            case ON_RESUME:
                this.aK.c(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.aK.d(lifecycleOwner);
                return;
            case ON_STOP:
                this.aK.e(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.aK.f(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
