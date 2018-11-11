package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Transformations {
    @MainThread
    public static <X, Y> LiveData<Y> a(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final LiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.a(liveData, new Observer<X>() {
            public void onChanged(@Nullable X x) {
                mediatorLiveData.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }
}
