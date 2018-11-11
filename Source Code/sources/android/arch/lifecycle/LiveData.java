package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T> {
    private static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private int mActiveCount = 0;
    private volatile Object mData = NOT_SET;
    private final Object mDataLock = new Object();
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<T>, ObserverWrapper> mObservers = new SafeIterableMap();
    private volatile Object mPendingData = NOT_SET;
    private final Runnable mPostValueRunnable = new Runnable() {
        public void run() {
            Object access$100;
            synchronized (LiveData.this.mDataLock) {
                access$100 = LiveData.this.mPendingData;
                LiveData.this.mPendingData = LiveData.NOT_SET;
            }
            LiveData.this.setValue(access$100);
        }
    };
    private int mVersion = -1;

    private abstract class ObserverWrapper {
        final Observer<T> bj;
        int bk = -1;
        boolean mActive;

        abstract boolean M();

        void N() {
        }

        boolean i(LifecycleOwner lifecycleOwner) {
            return false;
        }

        ObserverWrapper(Observer<T> observer) {
            this.bj = observer;
        }

        void k(boolean z) {
            if (z != this.mActive) {
                this.mActive = z;
                int i = 1;
                Object obj = LiveData.this.mActiveCount == 0 ? 1 : null;
                LiveData liveData = LiveData.this;
                int access$300 = liveData.mActiveCount;
                if (!this.mActive) {
                    i = -1;
                }
                liveData.mActiveCount = access$300 + i;
                if (obj != null && this.mActive) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.mActiveCount == 0 && !this.mActive) {
                    LiveData.this.onInactive();
                }
                if (this.mActive) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }
    }

    private class AlwaysActiveObserver extends ObserverWrapper {
        boolean M() {
            return true;
        }

        AlwaysActiveObserver(Observer<T> observer) {
            super(observer);
        }
    }

    class LifecycleBoundObserver extends ObserverWrapper implements GenericLifecycleObserver {
        @NonNull
        final LifecycleOwner bi;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
            super(observer);
            this.bi = lifecycleOwner;
        }

        boolean M() {
            return this.bi.getLifecycle().I().isAtLeast(State.STARTED);
        }

        public void a(LifecycleOwner lifecycleOwner, Event event) {
            if (this.bi.getLifecycle().I() == State.DESTROYED) {
                LiveData.this.removeObserver(this.bj);
            } else {
                k(M());
            }
        }

        boolean i(LifecycleOwner lifecycleOwner) {
            return this.bi == lifecycleOwner;
        }

        void N() {
            this.bi.getLifecycle().b(this);
        }
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    private void considerNotify(ObserverWrapper observerWrapper) {
        if (!observerWrapper.mActive) {
            return;
        }
        if (!observerWrapper.M()) {
            observerWrapper.k(false);
        } else if (observerWrapper.bk < this.mVersion) {
            observerWrapper.bk = this.mVersion;
            observerWrapper.bj.onChanged(this.mData);
        }
    }

    private void dispatchingValue(@Nullable ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            ObserverWrapper observerWrapper2;
            if (observerWrapper2 == null) {
                Iterator D = this.mObservers.D();
                while (D.hasNext()) {
                    considerNotify((ObserverWrapper) ((Entry) D.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
            considerNotify(observerWrapper2);
            observerWrapper2 = null;
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<T> observer) {
        if (lifecycleOwner.getLifecycle().I() != State.DESTROYED) {
            LifecycleObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            ObserverWrapper observerWrapper = (ObserverWrapper) this.mObservers.putIfAbsent(observer, lifecycleBoundObserver);
            if (observerWrapper != null && !observerWrapper.i(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (observerWrapper == null) {
                lifecycleOwner.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<T> observer) {
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.mObservers.putIfAbsent(observer, alwaysActiveObserver);
        if (observerWrapper != null && (observerWrapper instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (observerWrapper == null) {
            alwaysActiveObserver.k(true);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<T> observer) {
        assertMainThread("removeObserver");
        ObserverWrapper observerWrapper = (ObserverWrapper) this.mObservers.remove(observer);
        if (observerWrapper != null) {
            observerWrapper.N();
            observerWrapper.k(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        assertMainThread("removeObservers");
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((ObserverWrapper) entry.getValue()).i(lifecycleOwner)) {
                removeObserver((Observer) entry.getKey());
            }
        }
    }

    protected void postValue(T t) {
        Object obj;
        synchronized (this.mDataLock) {
            obj = this.mPendingData == NOT_SET ? 1 : null;
            this.mPendingData = t;
        }
        if (obj != null) {
            ArchTaskExecutor.A().b(this.mPostValueRunnable);
        }
    }

    @MainThread
    protected void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    @Nullable
    public T getValue() {
        T t = this.mData;
        return t != NOT_SET ? t : null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    private static void assertMainThread(String str) {
        if (!ArchTaskExecutor.A().C()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot invoke ");
            stringBuilder.append(str);
            stringBuilder.append(" on a background");
            stringBuilder.append(" thread");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
