package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    private final Object bA;
    private final CallbackInfo bB = ClassesInfoCache.ax.c(this.bA.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.bA = obj;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event) {
        this.bB.a(lifecycleOwner, event, this.bA);
    }
}
