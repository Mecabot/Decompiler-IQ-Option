package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

public final class LiveDataReactiveStreams {

    private static class PublisherLiveData<T> extends LiveData<T> {
        private final b<T> bl;
        final AtomicReference<LiveDataSubscriber> bm = new AtomicReference();

        final class LiveDataSubscriber extends AtomicReference<d> implements c<T> {
            LiveDataSubscriber() {
            }

            public void a(d dVar) {
                if (compareAndSet(null, dVar)) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.cancel();
                }
            }

            public void e(T t) {
                PublisherLiveData.this.postValue(t);
            }

            public void onError(final Throwable th) {
                PublisherLiveData.this.bm.compareAndSet(this, null);
                ArchTaskExecutor.A().c(new Runnable() {
                    public void run() {
                        throw new RuntimeException("LiveData does not handle errors. Errors from publishers should be handled upstream and propagated as state", th);
                    }
                });
            }

            public void onComplete() {
                PublisherLiveData.this.bm.compareAndSet(this, null);
            }

            public void O() {
                d dVar = (d) get();
                if (dVar != null) {
                    dVar.cancel();
                }
            }
        }

        PublisherLiveData(@NonNull b<T> bVar) {
            this.bl = bVar;
        }

        protected void onActive() {
            super.onActive();
            c liveDataSubscriber = new LiveDataSubscriber();
            this.bm.set(liveDataSubscriber);
            this.bl.b(liveDataSubscriber);
        }

        protected void onInactive() {
            super.onInactive();
            LiveDataSubscriber liveDataSubscriber = (LiveDataSubscriber) this.bm.getAndSet(null);
            if (liveDataSubscriber != null) {
                liveDataSubscriber.O();
            }
        }
    }

    @NonNull
    public static <T> LiveData<T> a(@NonNull b<T> bVar) {
        return new PublisherLiveData(bVar);
    }
}
