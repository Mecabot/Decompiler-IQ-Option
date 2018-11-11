package io.reactivex.internal.operators.flowable;

import io.reactivex.c.e;
import io.reactivex.exceptions.CompositeException;
import org.a.c;

/* compiled from: FlowableDoOnEach */
public final class b<T> extends a<T, T> {
    final io.reactivex.c.a eqJ;
    final io.reactivex.c.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;

    /* compiled from: FlowableDoOnEach */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final io.reactivex.c.a eqJ;
        final io.reactivex.c.a onComplete;
        final e<? super Throwable> onError;
        final e<? super T> onNext;

        a(io.reactivex.internal.b.a<? super T> aVar, e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3) {
            super(aVar);
            this.onNext = eVar;
            this.onError = eVar2;
            this.onComplete = aVar2;
            this.eqJ = aVar3;
        }

        public void e(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.e(null);
                    return;
                }
                try {
                    this.onNext.accept(t);
                    this.actual.e(t);
                } catch (Throwable th) {
                    N(th);
                }
            }
        }

        public boolean cf(T t) {
            if (this.done) {
                return false;
            }
            try {
                this.onNext.accept(t);
                return this.actual.cf(t);
            } catch (Throwable th) {
                N(th);
                return false;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            boolean z = true;
            this.done = true;
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.V(th2);
                this.actual.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.actual.onError(th);
            }
            try {
                this.eqJ.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.V(th3);
                io.reactivex.d.a.onError(th3);
            }
        }

        public void onComplete() {
            if (!this.done) {
                try {
                    this.onComplete.run();
                    this.done = true;
                    this.actual.onComplete();
                    try {
                        this.eqJ.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        io.reactivex.d.a.onError(th);
                    }
                } catch (Throwable th2) {
                    N(th2);
                }
            }
        }

        public int requestFusion(int i) {
            return ji(i);
        }

        public T poll() {
            Exception aa;
            CompositeException compositeException;
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    try {
                        this.onNext.accept(poll);
                        this.eqJ.run();
                    } catch (Throwable th) {
                        compositeException = new CompositeException(th, th);
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                    this.eqJ.run();
                }
                return poll;
            } catch (Throwable th2) {
                compositeException = new CompositeException(th, th2);
            }
        }
    }

    /* compiled from: FlowableDoOnEach */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {
        final io.reactivex.c.a eqJ;
        final io.reactivex.c.a onComplete;
        final e<? super Throwable> onError;
        final e<? super T> onNext;

        b(c<? super T> cVar, e<? super T> eVar, e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
            super(cVar);
            this.onNext = eVar;
            this.onError = eVar2;
            this.onComplete = aVar;
            this.eqJ = aVar2;
        }

        public void e(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.e(null);
                    return;
                }
                try {
                    this.onNext.accept(t);
                    this.actual.e(t);
                } catch (Throwable th) {
                    N(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            boolean z = true;
            this.done = true;
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.V(th2);
                this.actual.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.actual.onError(th);
            }
            try {
                this.eqJ.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.V(th3);
                io.reactivex.d.a.onError(th3);
            }
        }

        public void onComplete() {
            if (!this.done) {
                try {
                    this.onComplete.run();
                    this.done = true;
                    this.actual.onComplete();
                    try {
                        this.eqJ.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        io.reactivex.d.a.onError(th);
                    }
                } catch (Throwable th2) {
                    N(th2);
                }
            }
        }

        public int requestFusion(int i) {
            return ji(i);
        }

        public T poll() {
            Exception aa;
            CompositeException compositeException;
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    try {
                        this.onNext.accept(poll);
                        this.eqJ.run();
                    } catch (Throwable th) {
                        compositeException = new CompositeException(th, th);
                    }
                } else if (this.sourceMode == 1) {
                    this.onComplete.run();
                    this.eqJ.run();
                }
                return poll;
            } catch (Throwable th2) {
                compositeException = new CompositeException(th, th2);
            }
        }
    }

    public b(io.reactivex.e<T> eVar, e<? super T> eVar2, e<? super Throwable> eVar3, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        super(eVar);
        this.onNext = eVar2;
        this.onError = eVar3;
        this.onComplete = aVar;
        this.eqJ = aVar2;
    }

    protected void a(c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.b.a) {
            this.eqM.a(new a((io.reactivex.internal.b.a) cVar, this.onNext, this.onError, this.onComplete, this.eqJ));
            return;
        }
        this.eqM.a(new b(cVar, this.onNext, this.onError, this.onComplete, this.eqJ));
    }
}
