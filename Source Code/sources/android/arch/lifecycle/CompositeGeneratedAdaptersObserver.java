package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter[] aD;

    CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.aD = generatedAdapterArr;
    }

    public void a(LifecycleOwner lifecycleOwner, Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        int i = 0;
        for (GeneratedAdapter a : this.aD) {
            a.a(lifecycleOwner, event, false, methodCallsLogger);
        }
        GeneratedAdapter[] generatedAdapterArr = this.aD;
        int length = generatedAdapterArr.length;
        while (i < length) {
            generatedAdapterArr[i].a(lifecycleOwner, event, true, methodCallsLogger);
            i++;
        }
    }
}
