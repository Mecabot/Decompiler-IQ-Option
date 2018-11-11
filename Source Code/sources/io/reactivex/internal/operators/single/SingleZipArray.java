package io.reactivex.internal.operators.single;

import io.reactivex.c.f;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends o<R> {
    final s<? extends T>[] erF;
    final f<? super Object[], ? extends R> zipper;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements b {
        private static final long serialVersionUID = -5556924161382950569L;
        final q<? super R> actual;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final f<? super Object[], ? extends R> zipper;

        ZipCoordinator(q<? super R> qVar, int i, f<? super Object[], ? extends R> fVar) {
            super(i);
            this.actual = qVar;
            this.zipper = fVar;
            ZipSingleObserver[] zipSingleObserverArr = new ZipSingleObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2] = new ZipSingleObserver(this, i2);
            }
            this.observers = zipSingleObserverArr;
            this.values = new Object[i];
        }

        public boolean isDisposed() {
            return get() <= 0;
        }

        public void dispose() {
            int i = 0;
            if (getAndSet(0) > 0) {
                ZipSingleObserver[] zipSingleObserverArr = this.observers;
                int length = zipSingleObserverArr.length;
                while (i < length) {
                    zipSingleObserverArr[i].dispose();
                    i++;
                }
            }
        }

        void n(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(io.reactivex.internal.a.b.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.V(th);
                    this.actual.onError(th);
                }
            }
        }

        void je(int i) {
            ZipSingleObserver[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2].dispose();
            }
            while (true) {
                i++;
                if (i < length) {
                    zipSingleObserverArr[i].dispose();
                } else {
                    return;
                }
            }
        }

        void a(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                je(i);
                this.actual.onError(th);
                return;
            }
            io.reactivex.d.a.onError(th);
        }
    }

    static final class ZipSingleObserver<T> extends AtomicReference<b> implements q<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void d(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(T t) {
            this.parent.n(t, this.index);
        }

        public void onError(Throwable th) {
            this.parent.a(th, this.index);
        }
    }

    final class a implements f<T, R> {
        a() {
        }

        public R apply(T t) {
            return io.reactivex.internal.a.b.requireNonNull(SingleZipArray.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public SingleZipArray(s<? extends T>[] sVarArr, f<? super Object[], ? extends R> fVar) {
        this.erF = sVarArr;
        this.zipper = fVar;
    }

    protected void b(q<? super R> qVar) {
        s[] sVarArr = this.erF;
        int length = sVarArr.length;
        int i = 0;
        if (length == 1) {
            sVarArr[0].a(new a(qVar, new a()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(qVar, length, this.zipper);
        qVar.d(zipCoordinator);
        while (i < length && !zipCoordinator.isDisposed()) {
            s sVar = sVarArr[i];
            if (sVar == null) {
                zipCoordinator.a(new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                sVar.a(zipCoordinator.observers[i]);
                i++;
            }
        }
    }
}
