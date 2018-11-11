package io.reactivex.subjects;

import io.reactivex.d.a;
import io.reactivex.disposables.b;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends c<T> {
    static final PublishDisposable[] etS = new PublishDisposable[0];
    static final PublishDisposable[] etT = new PublishDisposable[0];
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference(etT);

    static final class PublishDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        final m<? super T> actual;
        final PublishSubject<T> parent;

        PublishDisposable(m<? super T> mVar, PublishSubject<T> publishSubject) {
            this.actual = mVar;
            this.parent = publishSubject;
        }

        public void e(T t) {
            if (!get()) {
                this.actual.e(t);
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    public static <T> PublishSubject<T> aXA() {
        return new PublishSubject();
    }

    PublishSubject() {
    }

    public void b(m<? super T> mVar) {
        PublishDisposable publishDisposable = new PublishDisposable(mVar, this);
        mVar.d(publishDisposable);
        if (!a(publishDisposable)) {
            Throwable th = this.error;
            if (th != null) {
                mVar.onError(th);
            } else {
                mVar.onComplete();
            }
        } else if (publishDisposable.isDisposed()) {
            b(publishDisposable);
        }
    }

    boolean a(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        Object obj;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            if (publishDisposableArr == etS) {
                return false;
            }
            int length = publishDisposableArr.length;
            obj = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, obj, 0, length);
            obj[length] = publishDisposable;
        } while (!this.subscribers.compareAndSet(publishDisposableArr, obj));
        return true;
    }

    void b(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        Object obj;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            if (publishDisposableArr != etS && publishDisposableArr != etT) {
                int length = publishDisposableArr.length;
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (publishDisposableArr[i2] == publishDisposable) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = etT;
                    } else {
                        Object obj2 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, obj2, 0, i);
                        System.arraycopy(publishDisposableArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.subscribers.compareAndSet(publishDisposableArr, obj));
    }

    public void d(b bVar) {
        if (this.subscribers.get() == etS) {
            bVar.dispose();
        }
    }

    public void e(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable e : (PublishDisposable[]) this.subscribers.get()) {
            e.e(t);
        }
    }

    public void onError(Throwable th) {
        io.reactivex.internal.a.b.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() == etS) {
            a.onError(th);
            return;
        }
        this.error = th;
        for (PublishDisposable onError : (PublishDisposable[]) this.subscribers.getAndSet(etS)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        if (this.subscribers.get() != etS) {
            for (PublishDisposable onComplete : (PublishDisposable[]) this.subscribers.getAndSet(etS)) {
                onComplete.onComplete();
            }
        }
    }

    public boolean aXy() {
        return this.subscribers.get() == etS && this.error != null;
    }

    public boolean aXx() {
        return this.subscribers.get() == etS && this.error == null;
    }
}
