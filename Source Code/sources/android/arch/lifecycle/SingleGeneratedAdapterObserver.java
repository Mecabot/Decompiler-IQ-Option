package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter bG;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.bG = generatedAdapter;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event) {
        this.bG.a(lifecycleOwner, event, false, null);
        this.bG.a(lifecycleOwner, event, true, null);
    }
}
