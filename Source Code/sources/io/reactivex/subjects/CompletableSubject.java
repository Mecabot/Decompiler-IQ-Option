package io.reactivex.subjects;

import io.reactivex.a;
import io.reactivex.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject extends a implements b {
    static final CompletableDisposable[] etQ = new CompletableDisposable[0];
    static final CompletableDisposable[] etR = new CompletableDisposable[0];
    Throwable error;
    final AtomicReference<CompletableDisposable[]> erx = new AtomicReference(etQ);
    final AtomicBoolean once = new AtomicBoolean();

    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final b actual;

        CompletableDisposable(b bVar, CompletableSubject completableSubject) {
            this.actual = bVar;
            lazySet(completableSubject);
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet(null);
            if (completableSubject != null) {
                completableSubject.b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static CompletableSubject aXz() {
        return new CompletableSubject();
    }

    CompletableSubject() {
    }

    public void d(io.reactivex.disposables.b bVar) {
        if (this.erx.get() == etR) {
            bVar.dispose();
        }
    }

    public void onError(Throwable th) {
        io.reactivex.internal.a.b.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int i = 0;
        if (this.once.compareAndSet(false, true)) {
            this.error = th;
            CompletableDisposable[] completableDisposableArr = (CompletableDisposable[]) this.erx.getAndSet(etR);
            int length = completableDisposableArr.length;
            while (i < length) {
                completableDisposableArr[i].actual.onError(th);
                i++;
            }
            return;
        }
        io.reactivex.d.a.onError(th);
    }

    public void onComplete() {
        int i = 0;
        if (this.once.compareAndSet(false, true)) {
            CompletableDisposable[] completableDisposableArr = (CompletableDisposable[]) this.erx.getAndSet(etR);
            int length = completableDisposableArr.length;
            while (i < length) {
                completableDisposableArr[i].actual.onComplete();
                i++;
            }
        }
    }

    protected void b(b bVar) {
        CompletableDisposable completableDisposable = new CompletableDisposable(bVar, this);
        bVar.d(completableDisposable);
        if (!a(completableDisposable)) {
            Throwable th = this.error;
            if (th != null) {
                bVar.onError(th);
            } else {
                bVar.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            b(completableDisposable);
        }
    }

    boolean a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        Object obj;
        do {
            completableDisposableArr = (CompletableDisposable[]) this.erx.get();
            if (completableDisposableArr == etR) {
                return false;
            }
            int length = completableDisposableArr.length;
            obj = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, obj, 0, length);
            obj[length] = completableDisposable;
        } while (!this.erx.compareAndSet(completableDisposableArr, obj));
        return true;
    }

    void b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        Object obj;
        do {
            completableDisposableArr = (CompletableDisposable[]) this.erx.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (completableDisposableArr[i2] == completableDisposable) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = etQ;
                    } else {
                        Object obj2 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, obj2, 0, i);
                        System.arraycopy(completableDisposableArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            }
            return;
        } while (!this.erx.compareAndSet(completableDisposableArr, obj));
    }
}
