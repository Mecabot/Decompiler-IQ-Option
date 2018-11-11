package android.arch.lifecycle;

import android.arch.core.internal.SafeIterableMap;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> bp = new SafeIterableMap();

    private static class Source<V> implements Observer<V> {
        final LiveData<V> aE;
        final Observer<V> bj;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<V> observer) {
            this.aE = liveData;
            this.bj = observer;
        }

        void P() {
            this.aE.observeForever(this);
        }

        void Q() {
            this.aE.removeObserver(this);
        }

        public void onChanged(@Nullable V v) {
            if (this.mVersion != this.aE.getVersion()) {
                this.mVersion = this.aE.getVersion();
                this.bj.onChanged(v);
            }
        }
    }

    @MainThread
    public <S> void a(@NonNull LiveData<S> liveData, @NonNull Observer<S> observer) {
        Source source = new Source(liveData, observer);
        Source source2 = (Source) this.bp.putIfAbsent(liveData, source);
        if (source2 == null || source2.bj == observer) {
            if (source2 == null && hasActiveObservers()) {
                source.P();
            }
            return;
        }
        throw new IllegalArgumentException("This source was already added with the different observer");
    }

    @MainThread
    public <S> void a(@NonNull LiveData<S> liveData) {
        Source source = (Source) this.bp.remove(liveData);
        if (source != null) {
            source.Q();
        }
    }

    @CallSuper
    protected void onActive() {
        Iterator it = this.bp.iterator();
        while (it.hasNext()) {
            ((Source) ((Entry) it.next()).getValue()).P();
        }
    }

    @CallSuper
    protected void onInactive() {
        Iterator it = this.bp.iterator();
        while (it.hasNext()) {
            ((Source) ((Entry) it.next()).getValue()).Q();
        }
    }
}
