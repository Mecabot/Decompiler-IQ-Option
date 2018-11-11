package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.a.b;
import io.reactivex.internal.b.a;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import org.a.c;

public final class FlowableFromIterable<T> extends e<T> {
    final Iterable<? extends T> era;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        abstract void aWL();

        abstract void cS(long j);

        public final int requestFusion(int i) {
            return i & 1;
        }

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        public final T poll() {
            if (this.it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!this.it.hasNext()) {
                return null;
            }
            return b.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
        }

        public final boolean isEmpty() {
            return this.it == null || !this.it.hasNext();
        }

        public final void clear() {
            this.it = null;
        }

        public final void request(long j) {
            if (!SubscriptionHelper.validate(j) || io.reactivex.internal.util.b.a(this, j) != 0) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                aWL();
            } else {
                cS(j);
            }
        }

        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final a<? super T> actual;

        IteratorConditionalSubscription(a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.actual = aVar;
        }

        void aWL() {
            Iterator it = this.it;
            a aVar = this.actual;
            while (!this.cancelled) {
                try {
                    Object next = it.next();
                    if (!this.cancelled) {
                        if (next == null) {
                            aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        aVar.cf(next);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        aVar.onComplete();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.V(th);
                                aVar.onError(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.V(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        void cS(long j) {
            Iterator it = this.it;
            a aVar = this.actual;
            long j2 = j;
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object next = it.next();
                            if (!this.cancelled) {
                                if (next == null) {
                                    aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean cf = aVar.cf(next);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.cancelled) {
                                                aVar.onComplete();
                                            }
                                            return;
                                        } else if (cf) {
                                            j++;
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.V(th);
                                        aVar.onError(th);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.V(th2);
                            aVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final c<? super T> actual;

        IteratorSubscription(c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.actual = cVar;
        }

        void aWL() {
            Iterator it = this.it;
            c cVar = this.actual;
            while (!this.cancelled) {
                try {
                    Object next = it.next();
                    if (!this.cancelled) {
                        if (next == null) {
                            cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        cVar.e(next);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        cVar.onComplete();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.V(th);
                                cVar.onError(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.V(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        void cS(long j) {
            Iterator it = this.it;
            c cVar = this.actual;
            long j2 = j;
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object next = it.next();
                            if (!this.cancelled) {
                                if (next == null) {
                                    cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                cVar.e(next);
                                if (!this.cancelled) {
                                    try {
                                        if (it.hasNext()) {
                                            j++;
                                        } else {
                                            if (!this.cancelled) {
                                                cVar.onComplete();
                                            }
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.V(th);
                                        cVar.onError(th);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.V(th2);
                            cVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.era = iterable;
    }

    public void a(c<? super T> cVar) {
        try {
            a(cVar, this.era.iterator());
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            EmptySubscription.error(th, cVar);
        }
    }

    public static <T> void a(c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (it.hasNext()) {
                if (cVar instanceof a) {
                    cVar.a(new IteratorConditionalSubscription((a) cVar, it));
                } else {
                    cVar.a(new IteratorSubscription(cVar, it));
                }
                return;
            }
            EmptySubscription.complete(cVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            EmptySubscription.error(th, cVar);
        }
    }
}
