package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.internal.b.f;
import io.reactivex.internal.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;

public final class FlowablePublish<T> extends io.reactivex.b.a<T> {
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final e<T> eqM;
    final b<T> erh;

    static final class InnerSubscriber<T> extends AtomicLong implements d {
        private static final long serialVersionUID = -4453897557930727610L;
        final c<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(c<? super T> cVar) {
            this.child = cVar;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
                PublishSubscriber publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }

        public void cancel() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                PublishSubscriber publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.b(this);
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    static final class a<T> implements b<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> eri;

        a(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.eri = atomicReference;
            this.bufferSize = i;
        }

        public void b(c<? super T> cVar) {
            PublishSubscriber publishSubscriber;
            InnerSubscriber innerSubscriber = new InnerSubscriber(cVar);
            cVar.a(innerSubscriber);
            while (true) {
                publishSubscriber = (PublishSubscriber) this.eri.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.eri, this.bufferSize);
                    if (this.eri.compareAndSet(publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    }
                }
                if (publishSubscriber.a(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.b(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements io.reactivex.disposables.b, h<T> {
        static final InnerSubscriber[] erj = new InnerSubscriber[0];
        static final InnerSubscriber[] erk = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile i<T> queue;
        final AtomicReference<d> s = new AtomicReference();
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference(erj);
        volatile Object terminalEvent;

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = i;
        }

        public void dispose() {
            if (this.subscribers.get() != erk && ((InnerSubscriber[]) this.subscribers.getAndSet(erk)) != erk) {
                this.current.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.s);
            }
        }

        public boolean isDisposed() {
            return this.subscribers.get() == erk;
        }

        public void a(d dVar) {
            if (SubscriptionHelper.setOnce(this.s, dVar)) {
                if (dVar instanceof f) {
                    f fVar = (f) dVar;
                    int requestFusion = fVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = fVar;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = fVar;
                        dVar.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                dVar.request((long) this.bufferSize);
            }
        }

        public void e(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        boolean a(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                if (innerSubscriberArr == erk) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                obj = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, obj, 0, length);
                obj[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, obj));
            return true;
        }

        void b(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            Object obj;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    break;
                }
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = erj;
                    } else {
                        Object obj2 = new InnerSubscriber[(length - 1)];
                        System.arraycopy(innerSubscriberArr, 0, obj2, 0, i);
                        System.arraycopy(innerSubscriberArr, i + 1, obj2, i, (length - i) - 1);
                        obj = obj2;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, obj));
        }

        boolean i(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(erk);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i < length) {
                            innerSubscriberArr[i].child.onError(error);
                            i++;
                        }
                    } else {
                        io.reactivex.d.a.onError(error);
                    }
                    return true;
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.subscribers.getAndSet(erk);
                    int length2 = innerSubscriberArr2.length;
                    while (i < length2) {
                        innerSubscriberArr2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Missing block: B:72:0x0148, code:
            if (r6 <= 0) goto L_0x015b;
     */
        /* JADX WARNING: Missing block: B:74:0x014d, code:
            if (r1.sourceMode == 1) goto L_0x015c;
     */
        /* JADX WARNING: Missing block: B:75:0x014f, code:
            ((org.a.d) r1.s.get()).request(r11);
     */
        /* JADX WARNING: Missing block: B:78:0x0160, code:
            if (r24 == 0) goto L_0x016b;
     */
        /* JADX WARNING: Missing block: B:79:0x0162, code:
            if (r15 != false) goto L_0x016b;
     */
        void dispatch() {
            /*
            r29 = this;
            r1 = r29;
            r2 = r29.getAndIncrement();
            if (r2 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r2 = r1.subscribers;
            r3 = r2.get();
            r3 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r3;
            r5 = 1;
        L_0x0012:
            r6 = r1.terminalEvent;
            r7 = r1.queue;
            if (r7 == 0) goto L_0x0021;
        L_0x0018:
            r9 = r7.isEmpty();
            if (r9 == 0) goto L_0x001f;
        L_0x001e:
            goto L_0x0021;
        L_0x001f:
            r9 = 0;
            goto L_0x0022;
        L_0x0021:
            r9 = 1;
        L_0x0022:
            r6 = r1.i(r6, r9);
            if (r6 == 0) goto L_0x0029;
        L_0x0028:
            return;
        L_0x0029:
            if (r9 != 0) goto L_0x0168;
        L_0x002b:
            r6 = r3.length;
            r10 = r3.length;
            r16 = r9;
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r13 = 0;
            r14 = 0;
        L_0x0036:
            r17 = -9223372036854775808;
            if (r13 >= r10) goto L_0x0059;
        L_0x003a:
            r15 = r3[r13];
            r19 = r15.get();
            r21 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1));
            if (r21 == 0) goto L_0x0050;
        L_0x0044:
            r11 = r15.emitted;
            r23 = r5;
            r4 = r19 - r11;
            r4 = java.lang.Math.min(r8, r4);
            r8 = r4;
            goto L_0x0054;
        L_0x0050:
            r23 = r5;
            r14 = r14 + 1;
        L_0x0054:
            r13 = r13 + 1;
            r5 = r23;
            goto L_0x0036;
        L_0x0059:
            r23 = r5;
            r4 = 1;
            if (r6 != r14) goto L_0x009b;
        L_0x005f:
            r6 = r1.terminalEvent;
            r7 = r7.poll();	 Catch:{ Throwable -> 0x0066 }
            goto L_0x007c;
        L_0x0066:
            r0 = move-exception;
            io.reactivex.exceptions.a.V(r0);
            r6 = r1.s;
            r6 = r6.get();
            r6 = (org.a.d) r6;
            r6.cancel();
            r6 = io.reactivex.internal.util.NotificationLite.error(r0);
            r1.terminalEvent = r6;
            r7 = 0;
        L_0x007c:
            if (r7 != 0) goto L_0x0080;
        L_0x007e:
            r7 = 1;
            goto L_0x0081;
        L_0x0080:
            r7 = 0;
        L_0x0081:
            r6 = r1.i(r6, r7);
            if (r6 == 0) goto L_0x0088;
        L_0x0087:
            return;
        L_0x0088:
            r6 = r1.sourceMode;
            r7 = 1;
            if (r6 == r7) goto L_0x0098;
        L_0x008d:
            r6 = r1.s;
            r6 = r6.get();
            r6 = (org.a.d) r6;
            r6.request(r4);
        L_0x0098:
            r5 = 1;
            goto L_0x0164;
        L_0x009b:
            r6 = 0;
        L_0x009c:
            r11 = (long) r6;
            r13 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1));
            if (r13 >= 0) goto L_0x0144;
        L_0x00a1:
            r13 = r1.terminalEvent;
            r14 = r7.poll();	 Catch:{ Throwable -> 0x00a8 }
            goto L_0x00be;
        L_0x00a8:
            r0 = move-exception;
            io.reactivex.exceptions.a.V(r0);
            r13 = r1.s;
            r13 = r13.get();
            r13 = (org.a.d) r13;
            r13.cancel();
            r13 = io.reactivex.internal.util.NotificationLite.error(r0);
            r1.terminalEvent = r13;
            r14 = 0;
        L_0x00be:
            if (r14 != 0) goto L_0x00c2;
        L_0x00c0:
            r15 = 1;
            goto L_0x00c3;
        L_0x00c2:
            r15 = 0;
        L_0x00c3:
            r13 = r1.i(r13, r15);
            if (r13 == 0) goto L_0x00ca;
        L_0x00c9:
            return;
        L_0x00ca:
            if (r15 == 0) goto L_0x00d0;
        L_0x00cc:
            r24 = r8;
            goto L_0x0148;
        L_0x00d0:
            r11 = io.reactivex.internal.util.NotificationLite.getValue(r14);
            r12 = r3.length;
            r13 = 0;
            r14 = 0;
        L_0x00d7:
            if (r13 >= r12) goto L_0x0120;
        L_0x00d9:
            r10 = r3[r13];
            r19 = r10.get();
            r16 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1));
            if (r16 == 0) goto L_0x010b;
        L_0x00e3:
            r21 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r16 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1));
            if (r16 == 0) goto L_0x00fb;
        L_0x00ec:
            r26 = r7;
            r24 = r8;
            r7 = r10.emitted;
            r28 = r14;
            r27 = r15;
            r14 = r7 + r4;
            r10.emitted = r14;
            goto L_0x0103;
        L_0x00fb:
            r26 = r7;
            r24 = r8;
            r28 = r14;
            r27 = r15;
        L_0x0103:
            r7 = r10.child;
            r7.e(r11);
            r14 = r28;
            goto L_0x0117;
        L_0x010b:
            r26 = r7;
            r24 = r8;
            r27 = r15;
            r21 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r14 = 1;
        L_0x0117:
            r13 = r13 + 1;
            r8 = r24;
            r7 = r26;
            r15 = r27;
            goto L_0x00d7;
        L_0x0120:
            r26 = r7;
            r24 = r8;
            r28 = r14;
            r27 = r15;
            r21 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r6 = r6 + 1;
            r7 = r2.get();
            r7 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r7;
            if (r28 != 0) goto L_0x0142;
        L_0x0137:
            if (r7 == r3) goto L_0x013a;
        L_0x0139:
            goto L_0x0142;
        L_0x013a:
            r8 = r24;
            r7 = r26;
            r16 = r27;
            goto L_0x009c;
        L_0x0142:
            r3 = r7;
            goto L_0x0164;
        L_0x0144:
            r24 = r8;
            r15 = r16;
        L_0x0148:
            if (r6 <= 0) goto L_0x015b;
        L_0x014a:
            r4 = r1.sourceMode;
            r5 = 1;
            if (r4 == r5) goto L_0x015c;
        L_0x014f:
            r4 = r1.s;
            r4 = r4.get();
            r4 = (org.a.d) r4;
            r4.request(r11);
            goto L_0x015c;
        L_0x015b:
            r5 = 1;
        L_0x015c:
            r6 = 0;
            r4 = (r24 > r6 ? 1 : (r24 == r6 ? 0 : -1));
            if (r4 == 0) goto L_0x016b;
        L_0x0162:
            if (r15 != 0) goto L_0x016b;
        L_0x0164:
            r5 = r23;
            goto L_0x0012;
        L_0x0168:
            r23 = r5;
            r5 = 1;
        L_0x016b:
            r4 = r23;
            r3 = -r4;
            r3 = r1.addAndGet(r3);
            if (r3 != 0) goto L_0x0175;
        L_0x0174:
            return;
        L_0x0175:
            r4 = r2.get();
            r4 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r4;
            r5 = r3;
            r3 = r4;
            goto L_0x0012;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.dispatch():void");
        }
    }

    public static <T> io.reactivex.b.a<T> a(e<T> eVar, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.d.a.a(new FlowablePublish(new a(atomicReference, i), eVar, atomicReference, i));
    }

    private FlowablePublish(b<T> bVar, e<T> eVar, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.erh = bVar;
        this.eqM = eVar;
        this.current = atomicReference;
        this.bufferSize = i;
    }

    protected void a(c<? super T> cVar) {
        this.erh.b(cVar);
    }

    public void e(io.reactivex.c.e<? super io.reactivex.disposables.b> eVar) {
        h hVar;
        while (true) {
            hVar = (PublishSubscriber) this.current.get();
            if (hVar != null && !hVar.isDisposed()) {
                break;
            }
            PublishSubscriber publishSubscriber = new PublishSubscriber(this.current, this.bufferSize);
            if (this.current.compareAndSet(hVar, publishSubscriber)) {
                hVar = publishSubscriber;
                break;
            }
        }
        boolean z = true;
        if (hVar.shouldConnect.get() || !hVar.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        try {
            eVar.accept(hVar);
            if (z) {
                this.eqM.a(hVar);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            RuntimeException Z = ExceptionHelper.Z(th);
        }
    }
}
