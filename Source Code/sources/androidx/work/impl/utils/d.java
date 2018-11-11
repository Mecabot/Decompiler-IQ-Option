package androidx.work.impl.utils;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.impl.utils.a.c;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: LiveDataUtils */
public class d {
    public static <In, Out> LiveData<Out> b(@NonNull LiveData<In> liveData, @NonNull final Function<In, Out> function) {
        final LiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.a(liveData, new Observer<In>() {
            public void onChanged(@Nullable final In in) {
                c.cG().e(new Runnable() {
                    public void run() {
                        synchronized (mediatorLiveData) {
                            Object apply = function.apply(in);
                            Object value = mediatorLiveData.getValue();
                            if (value == null && apply != null) {
                                mediatorLiveData.postValue(apply);
                            } else if (!(value == null || value.equals(apply))) {
                                mediatorLiveData.postValue(apply);
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}
