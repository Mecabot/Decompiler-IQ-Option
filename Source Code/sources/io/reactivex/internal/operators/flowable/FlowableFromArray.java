package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.a.b;
import io.reactivex.internal.b.a;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.a.c;

public final class FlowableFromArray<T> extends e<T> {
    final T[] array;

    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        abstract void aWL();

        abstract void cS(long j);

        public final int requestFusion(int i) {
            return i & 1;
        }

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        public final T poll() {
            int i = this.index;
            Object[] objArr = this.array;
            if (i == objArr.length) {
                return null;
            }
            this.index = i + 1;
            return b.requireNonNull(objArr[i], "array element is null");
        }

        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        public final void clear() {
            this.index = this.array.length;
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

    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final a<? super T> actual;

        ArrayConditionalSubscription(a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.actual = aVar;
        }

        void aWL() {
            Object[] objArr = this.array;
            int length = objArr.length;
            a aVar = this.actual;
            int i = this.index;
            while (i != length) {
                if (!this.cancelled) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        aVar.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        aVar.cf(obj);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                aVar.onComplete();
            }
        }

        void cS(long j) {
            Object[] objArr = this.array;
            int length = objArr.length;
            int i = this.index;
            a aVar = this.actual;
            long j2 = j;
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i == length) {
                        if (i == length) {
                            if (!this.cancelled) {
                                aVar.onComplete();
                            }
                            return;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.index = i;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        Object obj = objArr[i];
                        if (obj == null) {
                            aVar.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (aVar.cf(obj)) {
                            j++;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final c<? super T> actual;

        ArraySubscription(c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.actual = cVar;
        }

        void aWL() {
            Object[] objArr = this.array;
            int length = objArr.length;
            c cVar = this.actual;
            int i = this.index;
            while (i != length) {
                if (!this.cancelled) {
                    Object obj = objArr[i];
                    if (obj == null) {
                        cVar.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        cVar.e(obj);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        void cS(long j) {
            Object[] objArr = this.array;
            int length = objArr.length;
            int i = this.index;
            c cVar = this.actual;
            long j2 = j;
            do {
                j = 0;
                while (true) {
                    if (j == j2 || i == length) {
                        if (i == length) {
                            if (!this.cancelled) {
                                cVar.onComplete();
                            }
                            return;
                        }
                        j2 = get();
                        if (j == j2) {
                            this.index = i;
                            j2 = addAndGet(-j);
                        }
                    } else if (!this.cancelled) {
                        Object obj = objArr[i];
                        if (obj == null) {
                            cVar.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        cVar.e(obj);
                        i++;
                        j++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }

    public void a(c<? super T> cVar) {
        if (cVar instanceof a) {
            cVar.a(new ArrayConditionalSubscription((a) cVar, this.array));
        } else {
            cVar.a(new ArraySubscription(cVar, this.array));
        }
    }
}
