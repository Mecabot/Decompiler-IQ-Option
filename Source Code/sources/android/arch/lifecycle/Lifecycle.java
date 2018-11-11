package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public abstract class Lifecycle {

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    @NonNull
    public abstract State I();

    @MainThread
    public abstract void a(@NonNull LifecycleObserver lifecycleObserver);

    @MainThread
    public abstract void b(@NonNull LifecycleObserver lifecycleObserver);
}
